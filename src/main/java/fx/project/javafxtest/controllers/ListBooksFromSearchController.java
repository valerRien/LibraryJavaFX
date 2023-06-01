package fx.project.javafxtest.controllers;


import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.BookDAO;
import fx.project.javafxtest.models.Book;
import fx.project.javafxtest.util.DataKeeper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListBooksFromSearchController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final BookDAO bookDAO = new BookDAO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addBook;

    @FXML
    private ImageView homeButton;

    @FXML
    private ImageView showBookInfo;

    @FXML
    private ListView<Book> searchResultTable;

    private List<Book> foundBooks = bookDAO.findBooksLike(DataKeeper.getInstance().getBookStringData());

    private Book selectedBook;

    public ListBooksFromSearchController() throws Exception {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Book> list = searchResultTable.getItems();
        list.addAll(foundBooks);
        searchResultTable.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
    }

    private void selectionChanged(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
        selectedBook = searchResultTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    void addBook(MouseEvent event) throws IOException {
        sceneController.switchToSceneAddBook(event);
    }

    @FXML
    void mouseReleasedOnHomeButton(MouseEvent event) throws IOException {
        sceneController.switchToSceneMainAppFrame(event);
    }

    @FXML
    void showBookInfo(MouseEvent event) throws IOException {
        if (selectedBook == null) new Shake(showBookInfo).playAnim();
        else sceneController.switchToSceneShowBookInfo(event, selectedBook.getId());
    }
}
