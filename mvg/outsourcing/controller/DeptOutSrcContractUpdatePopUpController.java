package outsourcing.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.ContractVo;
import staticMethod.alert.AlertWindow;

public class DeptOutSrcContractUpdatePopUpController {
	
	private OutsourcingService outsrcService = OutsourcingService.getInstance(); 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label tf_hide;
    
    @FXML
    private Label tf_hide1;

    @FXML
    private TextField tf_name;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_cancel;

    @FXML
    private ComboBox<String> cb_dept;

    @FXML
    private DatePicker dp_date;

    @FXML
    private TextField tf_note;

    @FXML
    void change_cb_dept(ActionEvent event) {

    }

    @FXML
    void click_btn_cancel(ActionEvent event) {
    	Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
		thisStage.close();
    }

    @FXML
    void click_btn_update(ActionEvent event) {
    	
    	try {
			
    		Stage primaryStage = (Stage)btn_update.getScene().getWindow();
    		
    		if(tf_name.getText().isEmpty() || dp_date.getValue().toString() == null || tf_note.getText().isEmpty()) {
    			
    			AlertWindow.errorAlert("값 입력", "모두 알맞게 입력해주세요.");
    			
    		}
    		Map<String, String> contVo = new HashMap<>();
    		contVo.put("cont_no", cb_dept.getUserData().toString());
    		contVo.put("cont_date", dp_date.getValue().toString());
    		contVo.put("cont_cdate", tf_hide1.getText());
    		contVo.put("cont_note", tf_note.getText());
    		contVo.put("cont_name", tf_name.getText());
    		contVo.put("cont_plan", tf_hide.getText());
    		int cnt = outsrcService.updateContract(contVo);
    		if(cnt == 0) {
    			AlertWindow.FailedAlert(primaryStage);
    		}else{
    			AlertWindow.SucceedAlert(primaryStage);
    			primaryStage.close();
    		}
    		
		} catch (Exception e) {

		}
    }
    
    public void getCont(ContractVo contVo, LocalDate date) {
    	System.out.println(contVo.getCont_name());
    	tf_name.setText(contVo.getCont_name());
    	dp_date.setValue(date);
    	tf_hide.setText(contVo.getCont_plan());
    	tf_hide1.setText(contVo.getCont_cdate());
    	tf_note.setText(contVo.getCont_note());
    	cb_dept.setUserData(contVo.getCont_no().toString());
    }


    @FXML
    void initialize() {
        assert tf_hide != null : "fx:id=\"tf_hide\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert tf_hide1 != null : "fx:id=\"tf_hide1\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert cb_dept != null : "fx:id=\"cb_dept\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert dp_date != null : "fx:id=\"dp_date\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";
        assert tf_note != null : "fx:id=\"tf_note\" was not injected: check your FXML file 'DeptOutSrcContractUpdatePopUp.fxml'.";

    }
}