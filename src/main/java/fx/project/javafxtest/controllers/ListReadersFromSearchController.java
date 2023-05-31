package fx.project.javafxtest.controllers;

import fx.project.javafxtest.FXApp;
import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.ReadersDAO;
import fx.project.javafxtest.models.Reader;
import fx.project.javafxtest.util.DataKeeper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ListReadersFromSearchController implements Initializable {

    private final FXApp sceneController = new FXApp();
    private final ReadersDAO readersDAO = new ReadersDAO();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView goToPersonProfileButton;

    @FXML
    private ImageView homeButton;

    @FXML
    private ListView<Reader> searchResultTable;

    private Reader selectedReader;

    @FXML
    private Label regexSample;

    private List<Reader> foundReaders = readersDAO.findReadersLike(DataKeeper.getInstance().getStringData());

    public ListReadersFromSearchController() throws Exception {
    }

    public void initRegexToSearch(String regexToSearch){
        regexSample.setText(regexToSearch);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Reader> list = searchResultTable.getItems();
        list.addAll(foundReaders);
        searchResultTable.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
    }

    private void selectionChanged(ObservableValue<? extends Reader> observable, Reader oldValue, Reader newValue) {
        Reader selectedItem = searchResultTable.getSelectionModel().getSelectedItem();
        String getSelectedItem = selectedItem.showNameSurnameEmail();
        selectedReader = searchResultTable.getSelectionModel().getSelectedItem();
    }

    public void mouseReleasedOnHomeButton(MouseEvent mouseEvent) throws IOException {
        sceneController.switchToSceneMainAppFrame(mouseEvent);
    }

    public void mouseReleasedOnPersonInfoButton(MouseEvent mouseEvent) throws SQLException, IOException {
        if (selectedReader == null) new Shake(goToPersonProfileButton).playAnim();
        sceneController.switchToSceneShowReaderInfo(mouseEvent, selectedReader.getId());
    }
}
