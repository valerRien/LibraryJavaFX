package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.dao.ReaderDAO;
import fx.project.javafxtest.models.Reader;
import fx.project.javafxtest.util.DataKeeper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditReaderController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final ReaderDAO readerDAO = new ReaderDAO();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField emailField;

    @FXML
    private ImageView homeButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField surnameField;

    private Reader currentReader;

    public EditReaderController() throws Exception {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentReader = null;
        try {
            currentReader = readerDAO.findById(DataKeeper.getInstance().getReaderIntData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        nameField.setPromptText(currentReader.getName());
        surnameField.setPromptText(currentReader.getSurname());
        emailField.setPromptText(currentReader.getEmail());
        phoneNumberField.setPromptText(currentReader.getPhoneNumber());
    }

    @FXML
    void saveEditing(MouseEvent event) throws IOException, SQLException {
        if (!checkFieldForEmptiness()) {
            Reader reader = new Reader();
            reader.setName(nameField.getText().isEmpty() ? nameField.getPromptText() : nameField.getText());
            reader.setSurname(surnameField.getText().isEmpty() ? surnameField.getPromptText() : surnameField.getText());
            reader.setEmail(emailField.getText().isEmpty() ? emailField.getPromptText() : emailField.getText());
            reader.setPhoneNumber(phoneNumberField.getText().isEmpty() ? phoneNumberField.getPromptText() : phoneNumberField.getText());
            readerDAO.updateReader(DataKeeper.getInstance().getReaderIntData(), reader);
        }
        sceneController.switchToSceneShowReaderInfo(event, DataKeeper.getInstance().getReaderIntData());
    }

    @FXML
    void deleteReader(MouseEvent event) throws SQLException, IOException {
        readerDAO.deleteReaderById(DataKeeper.getInstance().getReaderIntData());
        sceneController.switchToSceneListReadersFromSearch(event, "");
    }

    @FXML
    void mouseReleasedOnHomeButton(MouseEvent event) throws IOException {
        sceneController.switchToSceneMainAppFrame(event);
    }

    private boolean checkFieldForEmptiness() {
        return nameField.getText().isEmpty() && surnameField.getText().isEmpty() && emailField.getText().isEmpty() && phoneNumberField.getText().isEmpty();
    }
}
