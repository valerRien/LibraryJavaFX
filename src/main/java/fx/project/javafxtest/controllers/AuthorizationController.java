package fx.project.javafxtest.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.AdminDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class AuthorizationController {

    private AdminDAO adminDAO = new AdminDAO();
    private ClickController clickController = new ClickController();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    public AuthorizationController() throws Exception {
    }

    @FXML
    void initialize() {
        signInButton.setOnAction(actionEvent -> {
            String login = loginField.getText().trim();
            String password = passwordField.getText().trim();

            try {
                if (!login.equals("") && !password.equals("") && passAuthorization(login, password)) {
                    clickController.mouserReleasedOnButton(signInButton, MainAppController.PATH);
                } else {
                    new Shake(signInButton).playAnim();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private boolean passAuthorization(String login, String password) throws SQLException {
        return adminDAO.passAuthorization(login, password).next();
    }

}

