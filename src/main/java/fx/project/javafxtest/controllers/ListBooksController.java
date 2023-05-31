package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.dao.BookDAO;
import fx.project.javafxtest.models.BookProxy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ListBooksController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final BookDAO bookDAO = new BookDAO();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addBookButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private TableColumn<BookProxy, String> authorColumn;

    @FXML
    private TableColumn<BookProxy, String>readerColumn;

    @FXML
    private TableColumn<BookProxy, String> submissionDateColumn;

    @FXML
    private TableColumn<BookProxy, String> titleColumn;

    @FXML
    private TableView<BookProxy> booksTable;

    public ListBooksController() throws Exception {
    }

    @FXML
    void mouseReleasedHomeButton(MouseEvent event) throws IOException {
        sceneController.switchToSceneMainAppFrame(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<BookProxy> books = null;
        try {
            books = bookDAO.getBooksProxy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ObservableList<BookProxy> proxyBooksList = FXCollections.observableArrayList(books);

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        readerColumn.setCellValueFactory(new PropertyValueFactory<>("reader"));
        submissionDateColumn.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));

        booksTable.setItems(proxyBooksList);
    }

    public void mouseReleasedAddBookButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneAddBook(mouseEvent);
    }
}

