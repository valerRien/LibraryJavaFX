package fx.project.javafxtest.controllers;

import fx.project.javafxtest.dao.BookDAO;
import fx.project.javafxtest.models.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    public static final String PATH = "/fx/project/javafxtest/AddBook.fxml";

    private ClickController clickController = new ClickController();
    private BookDAO bookDAO = new BookDAO();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField authorField;

    @FXML
    private ImageView homeButton;

    @FXML
    private TextField titleField;

    @FXML
    private TextField yearOfProductionField;

    public AddBookController() throws Exception {
    }


    public void mouseReleasedOnHomeButton(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, homeButton, MainAppController.PATH);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addButton.setOnAction(actionEvent -> {
            Book book = getBook();
            try {
                bookDAO.addBook(book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            clickController.mouserReleasedOnButton(addButton, ListBooksController.PATH);
        });
    }

    private Book getBook() {
        Book book = new Book();
        book.setTitle(titleField.getText());
        book.setAuthor(authorField.getText());
        book.setYearOfProduction(Integer.parseInt(yearOfProductionField.getText()));
        return book;
    }
}

