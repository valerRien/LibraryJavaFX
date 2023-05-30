package fx.project.javafxtest.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeLoginAndPasswordController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
