package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;
import fx.project.javafxtest.models.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadersDAO {

    private BookDAO bookDAO = new BookDAO();

    private Connection connection = new ConfigDB().getConnection();

    public ReadersDAO() throws Exception {
    }

    public void addReader(Reader reader) throws SQLException {
        String query = "INSERT INTO READERS (NAME, SURNAME, EMAIL, PHONE_NUMBER, GENDER) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, reader.getName());
        statement.setString(2, reader.getSurname());
        statement.setString(3, reader.getEmail());
        statement.setString(4, reader.getPhoneNumber());
        statement.setString(5, reader.getGender());

        statement.executeUpdate();
    }


    public List<Reader> getTimeOutReaders() throws SQLException {
        return bookDAO.getTimeOutReaders();
    }

    public List<Reader> findReadersLike(String regex) throws SQLException {
        String query = "SELECT * FROM READERS WHERE NAME LIKE ? OR SURNAME LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + regex + "%");
        statement.setString(2, "%" + regex + "%");
        ResultSet resultSet = statement.executeQuery();
        List<Reader> searchResult = new ArrayList<>();
        while (resultSet.next()) {
            Reader reader = new Reader();
            reader.setId(resultSet.getInt("id"));
            reader.setName(resultSet.getString("name"));
            reader.setSurname(resultSet.getString("surname"));
            searchResult.add(reader);
        }
        return searchResult;
    }

    public Reader findById(int id) throws SQLException {
        String query = "SELECT * FROM READERS WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        Reader reader = new Reader();
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        reader.setName(resultSet.getString("name"));
        reader.setSurname(resultSet.getString("surname"));
        return reader;
    }
}
