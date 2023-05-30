package fx.project.javafxtest.dao;

import fx.project.javafxtest.config.ConfigDB;

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

    public int verify(String oldLogin, String oldPassword) throws SQLException {
        ResultSet resultSet = passAuthorization(oldLogin, oldPassword);
        if (resultSet.next()) return resultSet.getInt("ID");
        else return -1;
    }

    public void updateAdmin(int adminId, String newLogin, String newPassword) throws SQLException {
        String query = "UPDATE ADMIN SET LOGIN=?, PASSWORD=? WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, newLogin);
        statement.setString(2, newPassword);
        statement.setInt(3, adminId);

        statement.executeUpdate();
    }
}
