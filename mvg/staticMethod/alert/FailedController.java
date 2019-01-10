package staticMethod.alert;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FailedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ok;

    @FXML
    void click_btn_ok(ActionEvent event) {
    	Stage thisStage = (Stage) btn_ok.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void initialize() {
        assert btn_ok != null : "fx:id=\"btn_ok\" was not injected: check your FXML file 'failed.fxml'.";

    }
}
