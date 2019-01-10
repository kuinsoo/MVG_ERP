package outsourcing.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeptOutSrcStateUpdatePopUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label tf_hide;

    @FXML
    private TextField tf_name;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_cancel;

    @FXML
    private ComboBox<?> cb_dept;

    @FXML
    private DatePicker dp_date;

    @FXML
    private TextField tf_addr;

    @FXML
    private TextField tf_name1;

    @FXML
    void change_cb_dept(ActionEvent event) {

    }

    @FXML
    void click_btn_cancel(ActionEvent event) {

    }

    @FXML
    void click_btn_update(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tf_hide != null : "fx:id=\"tf_hide\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert cb_dept != null : "fx:id=\"cb_dept\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert dp_date != null : "fx:id=\"dp_date\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert tf_addr != null : "fx:id=\"tf_addr\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";
        assert tf_name1 != null : "fx:id=\"tf_name1\" was not injected: check your FXML file 'DeptOutSrcStateUpdatePopUp.fxml'.";

    }
}
