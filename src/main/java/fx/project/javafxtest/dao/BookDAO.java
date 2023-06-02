package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;
import fx.project.javafxtest.models.Book;
import fx.project.javafxtest.models.BookProxy;
import fx.project.javafxtest.models.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Connection connection = new ConfigDB().getConnection();
    public BookDAO() throws Exception {
    }

    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO BOOKS (TITLE, AUTHOR, YEAR_OF_PRODUCTION) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getYearOfProduction());

        statement.executeUpdate();
    }

    public List<Reader> getTimeOutReaders() throws SQLException {
        String query = "select * from BOOKS JOIN READERS ON BOOKS.READER_ID = READERS.ID where DATEDIFF('DAY',BOOKS.SUBMISSION_DATE, ?) > 30";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, new Date(System.currentTimeMillis()));
        ResultSet resultSet = statement.executeQuery();
        List<Reader> readers = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("books.id"));
            book.setReaderId(resultSet.getInt("reader_id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setId(resultSet.getInt("year_of_production"));
            book.setPreviousReader(resultSet.getInt("previous_reader"));
            book.setSubmissionDate(resultSet.getDate("submission_date"));

            Reader reader = new Reader();
            reader.setId(resultSet.getInt("readers.id"));
            reader.setName(resultSet.getString("name"));
            reader.setSurname(resultSet.getString("surname"));
            reader.setEmail(resultSet.getString("email"));
            reader.setPhoneNumber(resultSet.getString("phone_number"));
            reader.setGender(resultSet.getString("gender"));

            reader.setBook(book);
            readers.add(reader);
        }

        return readers;
    }

    public void assignBook(Reader reader, Book book) throws SQLException {
        String query = "UPDATE BOOKS SET READER_ID=?, SUBMISSION_DATE=? WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, reader.getId());
        statement.setDate(2, new Date(System.currentTimeMillis()));
        statement.setInt(3, book.getId());

        statement.executeUpdate();
    }

    public List<Book> getAllBooksWithReaders() throws SQLException {
        String query = "SELECT * FROM BOOKS LEFT JOIN READERS ON BOOKS.READER_ID=READERS.ID";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("books.id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setSubmissionDate(resultSet.getDate("submission_date"));

            Reader reader = new Reader();
            reader.setId(resultSet.getInt("readers.id"));
            reader.setName(resultSet.getString("name"));
            reader.setSurname(resultSet.getString("surname"));

            book.setReader(reader);
            bookList.add(book);
        }

        return bookList;
    }

    public List<BookProxy> getBooksProxy() throws SQLException {
        List<Book> booksList = getAllBooksWithReaders();
        List<BookProxy> proxyBooksList = new ArrayList<>();
        for (Book book : booksList) {
            proxyBooksList.add(new BookProxy(book));
        }
        return proxyBooksList;
    }

    public List<Book> getBooksListByReaderId(int readerId) throws SQLException {
        String query = "SELECT * FROM BOOKS WHERE READER_ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, readerId);
        ResultSet resultSet = statement.executeQuery();
        List<Book> booksList = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setYearOfProduction(Integer.parseInt(resultSet.getString("year_of_production")));
            book.setSubmissionDate(resultSet.getDate("submission_date"));
            booksList.add(book);
        }
        return booksList;
    }

    public void releaseBook(int bookId, int readerId) throws SQLException {
        String query = "UPDATE BOOKS SET READER_ID=null, PREVIOUS_READER=?, SUBMISSION_DATE=null  WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, readerId);
        statement.setInt(2, bookId);
        statement.executeUpdate();
    }

    public List<Book> findBooksLike(String regex) throws SQLException {
        String query = "SELECT * FROM BOOKS WHERE TITLE LIKE ? OR AUTHOR LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + regex + "%");
        statement.setString(2, "%" + regex + "%");
        ResultSet resultSet = statement.executeQuery();
        List<Book> searchResult = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            fillFullBookFromResultSet(book, resultSet);
            searchResult.add(book);
        }
        return searchResult;
    }

    public Book findBookById(int bookId) throws SQLException {
        String query = "SELECT * FROM BOOKS WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, bookId);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Book book = new Book();
        fillFullBookFromResultSet(book, resultSet);
        return book;
    }

    private Book fillFullBookFromResultSet(Book book, ResultSet resultSet) throws SQLException {
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setSubmissionDate(resultSet.getDate("submission_date"));
        book.setReaderId(resultSet.getInt("reader_id"));
        book.setPreviousReader(resultSet.getInt("previous_reader"));
        book.setYearOfProduction(resultSet.getInt("year_of_production"));
        return book;
    }
}
