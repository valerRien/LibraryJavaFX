package fx.project.javafxtest.controllers;

import fx.project.javafxtest.dao.ReadersDAO;
import fx.project.javafxtest.models.Reader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewReaderController {

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
    private CheckBox manField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField surnameField;

    @FXML
    private CheckBox genderField;

    public NewReaderController() throws Exception {
    }

    @FXML
    void initialize(){
        addButton.setOnAction(actionEvent -> {
            try {
                readersDAO.addReader(getReader());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            clickController.mouserReleasedOnButton(addButton, MainAppController.PATH);
        });
    }

    private Reader getReader() {
        return new Reader(nameField.getText(), surnameField.getText(), emailField.getText(), phoneNumberField.getText(), genderField.getText());
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, homeButton, MainAppController.PATH);
    }
}
