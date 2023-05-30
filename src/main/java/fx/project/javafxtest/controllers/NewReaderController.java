package fx.project.javafxtest.controllers;

import fx.project.javafxtest.dao.ReadersDAO;
import fx.project.javafxtest.models.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewReaderController implements Initializable {

    public static final String PATH = "/fx/project/javafxtest/NewReader.fxml";

    private ReadersDAO readersDAO = new ReadersDAO();

    private final ClickController clickController = new ClickController();

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

    @FXML
    void initialize(){

    }

    private Reader getReader() {
        return new Reader(nameField.getText(), surnameField.getText(), emailField.getText(), phoneNumberField.getText(),
                manField.isSelected()?"Муж":womanField.isSelected()?"Жен":"н/д"
                );
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, homeButton, MainAppController.PATH);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setOnAction(actionEvent -> {
            try {
                readersDAO.addReader(getReader());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            clickController.mouserReleasedOnButton(addButton, ListReadersController.PATH);
        });
    }

    public void getGender(ActionEvent actionEvent) {}
}
