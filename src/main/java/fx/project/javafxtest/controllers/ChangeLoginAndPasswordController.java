package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.AdminDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChangeLoginAndPasswordController implements Initializable {

    private final FXApp sceneController = new FXApp();

    private final AdminDAO adminDAO = new AdminDAO();
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
    private Button saveEditing;

    public ChangeLoginAndPasswordController() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saveEditing.setOnAction(actionEvent -> {
            boolean shouldBeEdit = false;
            int adminId;
            String newLogin;
            String newPassword;
            try {
                if ((adminId = adminDAO.verify(newLogin = getOldLogin(), newPassword = getOldPassword())) != -1) {
                    shouldBeEdit = true;
                } else {
                    new Shake(saveEditing).playAnim();
                }

                if (shouldBeEdit) {
                    if (!getNewLogin().isEmpty() && !getNewPassword().isEmpty()) {
                        newLogin = getNewLogin();
                        newPassword = getNewPassword();
                    } else if (!getNewLogin().isEmpty()) {
                        newLogin = getNewLogin();
                    } else if (!getNewPassword().isEmpty()){
                        newPassword = getNewPassword();
                    }

                    adminDAO.updateAdmin(adminId, newLogin, newPassword);

                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });
    }

    public void mouseReleasedHomeButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneMainAppFrame(mouseEvent);
    }

    private String getOldLogin() {
        return oldLoginField.getText();
    }

    private String getNewLogin() {
        return newLoginField.getText();
    }

    private String getOldPassword() {
        return oldPasswordField.getText();
    }

    private String getNewPassword() {
        return newPasswordField.getText();
    }
}
