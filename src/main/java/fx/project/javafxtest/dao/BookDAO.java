package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;
import fx.project.javafxtest.models.Book;
import fx.project.javafxtest.models.BookProxy;
import fx.project.javafxtest.models.Reader;

import java.sql.*;
import java.text.SimpleDateFormat;
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
            book.setReader_id(resultSet.getInt("reader_id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setId(resultSet.getInt("year_of_production"));
            book.setPreviousReader(resultSet.getInt("previous_reader"));
            book.setSubmission_date(resultSet.getDate("submission_date"));

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
        String query = "UPDATE TABLE BOOKS SET PERSON_ID=? WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, reader.getId());
        statement.setInt(2, book.getId());

        statement.executeUpdate();
    }

    public List<Book> getAllBooksWithReaders() throws SQLException {
        String query = "SELECT * FROM BOOKS LEFT JOIN READERS ON BOOKS.READER_ID=READERS.ID";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        List<Book> bookList = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setSubmission_date(resultSet.getDate("submission_date"));

            Reader reader = new Reader();
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

    public static void main(String[] args) throws Exception {
        System.out.println(new BookDAO().getAllBooksWithReaders());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
    }
}
