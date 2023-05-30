package fx.project.javafxtest.controllers;

import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.AdminDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AuthorizationController implements Initializable {

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

    private boolean passAuthorization(String login, String password) throws SQLException {
        return adminDAO.passAuthorization(login, password).next();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
}

