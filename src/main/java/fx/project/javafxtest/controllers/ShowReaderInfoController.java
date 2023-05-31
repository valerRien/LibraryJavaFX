package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.dao.BookDAO;
import fx.project.javafxtest.dao.ReaderDAO;
import fx.project.javafxtest.models.Book;
import fx.project.javafxtest.models.Reader;
import fx.project.javafxtest.util.DataKeeper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ShowReaderInfoController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final ReaderDAO readerDAO = new ReaderDAO();
    private final BookDAO bookDAO = new BookDAO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView homeButton;

    @FXML
    private Label nameField;

    @FXML
    private Label surnameField;

    @FXML
    private ListView<Book> booksList;

    @FXML
    private ImageView editReader;

    @FXML
    private Button releaseBook;

    private Book selectedBook;

    private Reader currentReader;

    public ShowReaderInfoController() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentReader = null;
        List<Book> listOfBooks = null;
        try {
            currentReader = readerDAO.findById(DataKeeper.getInstance().getIntData());
            listOfBooks = bookDAO.getBooksListByReaderId(DataKeeper.getInstance().getIntData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Book> listView = booksList.getItems();
        listView.addAll(listOfBooks);
        booksList.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
        nameField.setText(currentReader.getName());
        surnameField.setText(currentReader.getSurname());
    }

    private void selectionChanged(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
        selectedBook = booksList.getSelectionModel().getSelectedItem();
    }

    public void mouseReleasedOnHomeButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneMainAppFrame(mouseEvent);
    }

    public void releaseBook(ActionEvent event) throws IOException, SQLException {
        bookDAO.releaseBook(selectedBook.getId(), currentReader.getId());
        sceneController.switchToSceneShowReaderInfo(event, DataKeeper.getInstance().getIntData());
    }
}
