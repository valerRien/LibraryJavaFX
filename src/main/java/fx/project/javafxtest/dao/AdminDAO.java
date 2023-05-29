package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;
import fx.project.javafxtest.models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    private Connection connection = new ConfigDB().getConnection();

    public AdminDAO() throws Exception {
    }

    public void addAdmin(String login, String password) throws SQLException {
        String query = "INSERT INTO ADMIN (LOGIN, PASSWORD) VALUES(?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, login);
        statement.setString(2, password);

        statement.executeUpdate();
    }

    public ResultSet passAuthorization(String login, String password) throws SQLException {
        ResultSet result = null;
        String query = "SELECT * FROM ADMIN WHERE LOGIN=? AND PASSWORD=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, login);
        statement.setString(2, password);
        result = statement.executeQuery();
        return result;
    }

}
