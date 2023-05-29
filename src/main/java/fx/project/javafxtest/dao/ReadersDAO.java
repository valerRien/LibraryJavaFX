package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;
import fx.project.javafxtest.models.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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


    public List<Reader> getTimeOutReaders() {
        return bookDAO.getTimeOutReaders();
    }
}
