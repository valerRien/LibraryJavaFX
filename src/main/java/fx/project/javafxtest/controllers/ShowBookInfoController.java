package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.BookDAO;
import fx.project.javafxtest.dao.ReaderDAO;
import fx.project.javafxtest.models.Book;
import fx.project.javafxtest.models.Reader;
import fx.project.javafxtest.util.DataKeeper;
import javafx.beans.value.ObservableValue;
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

public class ShowBookInfoController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final BookDAO bookDAO = new BookDAO();
    private final ReaderDAO readerDAO = new ReaderDAO();
    @FXML
    private Label authorField;

    @FXML
    private Label currentPlace;

    @FXML
    private ImageView homeButton;

    @FXML
    private Label previousPlace;

    @FXML
    private Button releaseOrAddBook;

    @FXML
    private Label titleField;

    @FXML
    private ListView<Reader> listAllReaders;

    private Book currentBook;
    private Reader previousReader;
    private Reader reader;
    private Reader selectedReader;

    public ShowBookInfoController() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentBook = null;
        try {
            currentBook = bookDAO.findBookById(DataKeeper.getInstance().getBookIntData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        titleField.setText(currentBook.getTitle());
        authorField.setText(currentBook.getAuthor() + ", " + currentBook.getYearOfProduction());
        reader = null;
        previousReader = null;
        try {
            reader = readerDAO.findById(currentBook.getReaderId());
            DataKeeper.getInstance().setReaderIntData(reader.getId());
            previousReader = readerDAO.findById(currentBook.getPreviousReader());
        } catch (SQLException e) {

        } finally {
            if (reader == null) {
                currentPlace.setText("");
                listAllReaders.setVisible(true);
                List<Reader> list = listAllReaders.getItems();
                try {
                    list.addAll(readerDAO.getAllReaders());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                listAllReaders.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
                releaseOrAddBook.setText("Выдать");
            } else {
                currentPlace.setText("Сейчас читает: " + reader.getName() + " " + reader.getSurname() + " " + reader.getPhoneNumber());
                listAllReaders.setVisible(false);
            }

            try {
                previousReader = readerDAO.findById(currentBook.getPreviousReader());
            } catch (SQLException e) {
            }
            if (previousReader == null) previousPlace.setText("Раннее не выдавалась");
            else previousPlace.setText("Прошлый читатель: " + previousReader.getName() + " " + previousReader.getSurname() + " " + previousReader.getPhoneNumber());
        }
    }

    private void selectionChanged(ObservableValue<? extends Reader> observable, Reader oldValue, Reader newValue) {
        selectedReader = listAllReaders.getSelectionModel().getSelectedItem();
    }

    @FXML
    void mouseReleasedOnHomeButton(MouseEvent event) throws IOException {
        sceneController.switchToSceneMainAppFrame(event);
    }

    public void releaseOrAddBook(MouseEvent event) throws SQLException, IOException {
        if (releaseOrAddBook.getText().equals("Сдать книгу")) {
            bookDAO.releaseBook(currentBook.getId(), currentBook.getReaderId());
            sceneController.switchToSceneShowBookInfo(event, currentBook.getId());
        } else {
            if (selectedReader == null) new Shake(releaseOrAddBook).playAnim();
            else {
                bookDAO.assignBook(selectedReader, currentBook);
                sceneController.switchToSceneShowBookInfo(event, currentBook.getId());
            }
        }
    }
}
