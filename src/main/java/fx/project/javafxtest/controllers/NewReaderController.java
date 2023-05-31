package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.dao.ReaderDAO;
import fx.project.javafxtest.models.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewReaderController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final ReaderDAO readerDAO = new ReaderDAO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private TextField emailField;

    @FXML
    private RadioButton manField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField surnameField;

    @FXML
    private RadioButton womanField;

    public NewReaderController() throws Exception {
    }

    private Reader getReader() {
        return new Reader(nameField.getText(), surnameField.getText(), emailField.getText(), phoneNumberField.getText(),
                manField.isSelected()?"Муж":womanField.isSelected()?"Жен":"н/д"
                );
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getGender(ActionEvent actionEvent) {

    }

    public void mouseReleasedOnHomeButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneMainAppFrame(mouseEvent);
    }

    public void addReader(MouseEvent event) throws IOException, SQLException {
        try {
            readerDAO.addReader(getReader());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        sceneController.switchToSceneListReadersFromSearch(event, "");
    }
}
