package fx.project.javafxtest.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainAppController {

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

    public void mouseReleased(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, readersButton,ListReadersController.PATH);
    }
}
