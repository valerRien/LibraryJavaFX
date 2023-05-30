package fx.project.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class FXApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXApp.class.getResource("/fx/project/javafxtest/MainAppFrame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Библиотека");
        stage.getIcons().add(new Image(FXApp.class.getResourceAsStream("/assets/999135.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws MessagingException, GeneralSecurityException, IOException {
        launch();
    }
}