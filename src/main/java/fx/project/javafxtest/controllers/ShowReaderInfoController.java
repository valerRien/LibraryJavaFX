package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.dao.ReadersDAO;
import fx.project.javafxtest.models.Reader;
import fx.project.javafxtest.util.DataKeeper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowReaderInfoController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final ReadersDAO readersDAO = new ReadersDAO();

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

    public ShowReaderInfoController() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Reader reader = null;
        try {
            reader = readersDAO.findById(DataKeeper.getInstance().getIntData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        nameField.setText(reader.getName());
        surnameField.setText(reader.getSurname());
    }

    public void mouseReleasedOnHomeButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneMainAppFrame(mouseEvent);
    }
}
