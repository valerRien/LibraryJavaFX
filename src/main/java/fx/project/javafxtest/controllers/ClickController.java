package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ClickController {

    public void mouseReleasedOnImage(MouseEvent mouseEvent, ImageView buttonFromWindowToHide, String pathToWindowToLaunch) {
        buttonFromWindowToHide.getScene().getWindow().hide();
        sample(pathToWindowToLaunch);
    }

    public void mouserReleasedOnButton(Button buttonFromWindowToHide, String pathToWindowToLaunch) {
        buttonFromWindowToHide.getScene().getWindow().hide();
        sample(pathToWindowToLaunch);
    }

    private void sample(String pathToWindowToLaunch) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pathToWindowToLaunch));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Библиотека");
        stage.getIcons().add(new Image(FXApp.class.getResourceAsStream("/assets/999135.png")));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
