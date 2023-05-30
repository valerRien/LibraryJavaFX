package fx.project.javafxtest.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    public static final String PATH = "/fx/project/javafxtest/MainAppFrame.fxml";

    private final ClickController clickController = new ClickController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView booksButton;

    @FXML
    private ImageView readersButton;

    @FXML
    private ImageView settingsButton;

    @FXML
    void initialize() {
    }

    public void mouseReleasedOnReadersButton(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, readersButton, ListReadersController.PATH);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mouseReleasedOnBooksButton(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, readersButton, ListBooksController.PATH);
    }
}
