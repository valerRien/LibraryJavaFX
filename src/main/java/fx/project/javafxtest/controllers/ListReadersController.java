package fx.project.javafxtest.controllers;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fx.project.javafxtest.animations.Shake;
import fx.project.javafxtest.dao.ReadersDAO;
import fx.project.javafxtest.models.Reader;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ListReadersController implements Initializable {

    public static final String PATH = "/fx/project/javafxtest/ListReaders.fxml";
    private ClickController clickController = new ClickController();
    private ReadersDAO readersDAO = new ReadersDAO();
    private Reader selectedReader = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView homeButton;

    @FXML
    private ListView<Reader> listView;

    @FXML
    private Label selectedPanel;

    @FXML
    private ImageView sendNotice;

    public ListReadersController() throws Exception {
    }

    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Reader> readers = readersDAO.getTimeOutReaders();
        List<Reader> list = listView.getItems();
        list.addAll(readers);
        listView.getSelectionModel().selectedItemProperty().addListener(this::selectionChanged);
    }

    private void selectionChanged(ObservableValue<? extends Reader> observable, Reader oldValue, Reader newValue) {
        Reader selectedItem = listView.getSelectionModel().getSelectedItem();
        String getSelectedItem = selectedItem.showNameSurnameEmail();
        selectedPanel.setText(getSelectedItem);
        selectedReader = listView.getSelectionModel().getSelectedItem();
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        clickController.mouseReleasedOnImage(mouseEvent, homeButton, MainAppController.PATH);
    }

    public void sendNotice(MouseEvent mouseEvent) {
        if (selectedReader != null) System.out.println(selectedReader); //emailSender.notice();
        else new Shake(sendNotice).playAnim();
    }
}

