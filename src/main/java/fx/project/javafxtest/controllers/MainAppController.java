package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    private final FXApp sceneController = new FXApp();
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
    private TextField findReader;

    @FXML
    private ImageView searchForBookButton;

    @FXML
    private ImageView searchForReaderButton;

    public void mouseReleasedOnReadersButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneListReaders(mouseEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mouseReleasedOnBooksButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneListBooks(mouseEvent);
    }

    public void mouseReleasedOnSettingsButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneChangeLoginAndPassword(mouseEvent);
    }

    public void searchForBooks(MouseEvent mouseEvent) throws Exception {

    }

    public void searchForReaders(MouseEvent mouseEvent) throws IOException, SQLException {
        sceneController.switchToSceneListReadersFromSearch(mouseEvent, findReader.getText());
    }
}

