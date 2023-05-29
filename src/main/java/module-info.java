module fx.project.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;
    requires java.mail;


    opens fx.project.javafxtest to javafx.fxml;
    exports fx.project.javafxtest;
    exports fx.project.javafxtest.controllers;
    opens fx.project.javafxtest.controllers to javafx.fxml;
    exports fx.project.javafxtest.models;
    opens fx.project.javafxtest.models to javafx.fxml;
}