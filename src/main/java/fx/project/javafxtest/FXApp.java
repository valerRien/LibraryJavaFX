package fx.project.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class FXApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXApp.class.getResource("/fx/project/javafxtest/Authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("FXApp");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws MessagingException, GeneralSecurityException, IOException {
        launch();
    }
}