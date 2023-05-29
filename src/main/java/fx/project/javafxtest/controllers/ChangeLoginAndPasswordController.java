package fx.project.javafxtest.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChangeLoginAndPasswordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView homeButton;

    @FXML
    private TextField newLoginField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private TextField oldLoginField;

    @FXML
    private PasswordField oldPasswordField;

    @FXML
    void initialize() {

    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
