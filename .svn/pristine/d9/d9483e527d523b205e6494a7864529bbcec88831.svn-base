package humanResources.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.SalaryVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;

public class Hr_empSalaryBasicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label tf_hide;

    @FXML
    private ComboBox<String> cb_pos;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField tf_name;

    @FXML
    private Button btn_update;

    @FXML
    void click_btn_update(ActionEvent event) {
    	Map<String, String>salMap = new HashMap<String, String>();
    	salMap.put("pos_name", cb_pos.getValue().toString());
    	salMap.put("sal_basic", tf_name.getText());
    	
    	int cnt = service.updateSalary(salMap);
    	
    	if(cnt > 0) {
			AlertWindow.SucceedAlert((Stage)btn_update.getScene().getWindow());
			Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
			thisStage.close();
		} else {
			AlertWindow.FailedAlert((Stage)btn_update.getScene().getWindow());
		}
    }

    @FXML
    void click_btn_cancel(ActionEvent event) {
    	Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void change_cb_pos(ActionEvent event) {
    	SalaryVo salVo  = service.salaryBasic(cb_pos.getValue().toString());
    	tf_name.setText(""+salVo.getSal_basic());
    }
    IEmployeeService service = EmployeeService.getInstance();
   
    @FXML
    void initialize() {
        assert tf_hide != null : "fx:id=\"tf_hide\" was not injected: check your FXML file 'hr_empSalaryBasic.fxml'.";
        assert cb_pos != null : "fx:id=\"cb_pos\" was not injected: check your FXML file 'hr_empSalaryBasic.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'hr_empSalaryBasic.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'hr_empSalaryBasic.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'hr_empSalaryBasic.fxml'.";
        cb_pos.setItems(ComboList.posCombo());
        cb_pos.getSelectionModel().selectFirst();
        SalaryVo salVo  = service.salaryBasic(cb_pos.getValue().toString());
        tf_name.setText(""+salVo.getSal_basic());
    }
}
