package fx.project.javafxtest;

import fx.project.javafxtest.util.DataKeeper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

public class FXApp extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXApp.class.getResource("/fx/project/javafxtest/Authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Библиотека");
        stage.getIcons().add(new Image(FXApp.class.getResourceAsStream("/assets/LibraryWindowLogo.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws MessagingException, GeneralSecurityException, IOException {
        launch();
    }

    public void switchToSceneMainAppFrame(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/MainAppFrame.fxml", event);
    }

    public void switchToSceneMainAppFrame(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/MainAppFrame.fxml", event);
    }

    public void switchToSceneAddBook(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/AddBook.fxml", event);
    }

    public void switchToSceneAddBook(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/AddBook.fxml", event);
    }

    public void switchToSceneAuthorization(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/Authorization.fxml", event);
    }

    public void switchToSceneAuthorization(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/Authorization.fxml", event);
    }

    public void switchToSceneChangeLoginAndPassword(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/ChangeLoginAndPassword.fxml", event);
    }

    public void switchToSceneChangeLoginAndPassword(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/ChangeLoginAndPassword.fxml", event);
    }

    public void switchToSceneListBooks(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/ListBooks.fxml", event);
    }

    public void switchToSceneListBooks(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/ListBooks.fxml", event);
    }

    public void switchToSceneListReaders(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/ListReaders.fxml", event);
    }

    public void switchToSceneListReaders(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/ListReaders.fxml", event);
    }

    public void switchToSceneListReadersFromSearch(MouseEvent event, String regex) throws IOException, SQLException {
        DataKeeper.getInstance().setReaderStringData(regex);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fx/project/javafxtest/ListReadersFromSearch.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void switchToSceneNewReader(ActionEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/NewReader.fxml", event);
    }

    public void switchToSceneNewReader(MouseEvent event) throws IOException {
        switchScene("/fx/project/javafxtest/NewReader.fxml", event);
    }

    public void switchToSceneShowReaderInfo(MouseEvent event, int readerId) throws IOException {
        DataKeeper.getInstance().setReaderIntData(readerId);
        switchScene("/fx/project/javafxtest/ShowReaderInfo.fxml", event);
    }

    public void switchToSceneShowReaderInfo(ActionEvent event, int readerId) throws IOException {
        DataKeeper.getInstance().setReaderIntData(readerId);
        switchScene("/fx/project/javafxtest/ShowReaderInfo.fxml", event);
    }

    private void switchScene(String scenePath, MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(scenePath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    private void switchScene(String scenePath, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(scenePath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void switchToSceneEditReader(MouseEvent event, int readerId) throws IOException {
        DataKeeper.getInstance().setReaderIntData(readerId);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fx/project/javafxtest/EditReader.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void switchToSceneShowBookInfo(MouseEvent event, int bookId) throws IOException {
        DataKeeper.getInstance().setBookIntData(bookId);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fx/project/javafxtest/ShowBookInfo.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void switchToSceneListBookFromSearch(MouseEvent event, String regex) throws IOException {
        DataKeeper.getInstance().setBookStringData(regex);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fx/project/javafxtest/ListBooksFromSearch.fxml"));
        Parent root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
}