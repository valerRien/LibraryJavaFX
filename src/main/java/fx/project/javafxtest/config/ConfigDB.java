package fx.project.javafxtest.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigDB {
    private Connection connection;

    public Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:./database/library_java_fx", "admin", "admin");
        return connection;
    }
}
