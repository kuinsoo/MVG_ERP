package production.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInsert;

    @FXML
    private Button bntCancel;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void insert(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'Form.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'Form.fxml'.";

    }
}
