package humanResources.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.ScheduleEmpVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;

public class Hr_scheduleNote1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf_note1;

    @FXML
    private TextField tf_date;

    @FXML
    private TextField tf_note2;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField tf_note3;

    @FXML
    private Button btn_update;

    @FXML
    private TextArea ta_note1;

    public void ScheduleEmpVo(ScheduleEmpVo schVo, LocalDate date) {
    	tf_date.setText(date.toString());
    	tf_note1.setText(schVo.getSchemp_note1());
    	ta_note1.setText(schVo.getSchemp_note2());
    	tf_note2.setText(schVo.getSchemp_note3());
    	tf_note3.setText(schVo.getSchemp_note4());
    	
    }
    
    @FXML
    void click_btn_cancel(ActionEvent event) {
    	Stage thisStage = (Stage) btn_cancel.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void click_btn_update(ActionEvent event) {
    	Map<String, String> schMap = new HashMap<String, String>();
    	schMap.put("schemp_date", tf_date.getText());
    	schMap.put("schemp_note1", tf_note1.getText());
    	schMap.put("schemp_note2", ta_note1.getText());
     	schMap.put("schemp_note3", tf_note2.getText());
    	schMap.put("schemp_note4", tf_note3.getText());
    	int result = service.insertSch(schMap);
    	System.out.println(result);
    	if(result == 0) {
			AlertWindow.SucceedAlert((Stage)btn_update.getScene().getWindow());
			Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
			thisStage.close();
		} 
    }
    
    /* 전역변수 선언 */
    IEmployeeService service = EmployeeService.getInstance();
    
    @FXML
    void initialize() {
        assert tf_note1 != null : "fx:id=\"tf_note1\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";
        assert tf_date != null : "fx:id=\"tf_date\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";
        assert tf_note2 != null : "fx:id=\"tf_note2\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";
        assert tf_note3 != null : "fx:id=\"tf_note3\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";
        assert ta_note1 != null : "fx:id=\"ta_note1\" was not injected: check your FXML file 'hr_scheduleNote1.fxml'.";

    }
}
