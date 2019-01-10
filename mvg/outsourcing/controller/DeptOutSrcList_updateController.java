package outsourcing.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.PlanningVo;
import staticMethod.alert.AlertWindow;

public class DeptOutSrcList_updateController {
	
	private OutsourcingService outsrcService = OutsourcingService.getInstance(); 

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
    private TextField cb_dept;

    @FXML
    private DatePicker dp_date;

    @FXML
    private TextArea tf_note;
    
   
    
    public void getPlan(PlanningVo planVo, LocalDate date) {
    	System.out.println(planVo.getPlan_name());
    	tf_name.setText(planVo.getPlan_name());
    	dp_date.setValue(date);
    	tf_hide.setText(planVo.getPlan_no());
    	tf_note.setText(planVo.getPlan_note());
    	cb_dept.setText(planVo.getPlan_title());
    }

    /**
     * 
     *@Method Name : click_btn_cancel
     *@date : 2018. 9. 22.
     *@author : 박동주
     *@Method 설명 : 취소
     *@param event
     */
    @FXML
    void click_btn_cancel(ActionEvent event) {
    	Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
		thisStage.close();
    }

    /**
     * 
     *@Method Name : click_btn_update
     *@date : 2018. 9. 22.
     *@author : 박동주
     *@Method 설명 : 수정 버튼 눌렀을 때 수정 할 수 있는 변수
     *@param event
     */
    @FXML
    void click_btn_update(ActionEvent event) {
    	try {
    		
    		Stage primaryStage = (Stage)btn_update.getScene().getWindow();
    		
    		if(tf_name.getText().isEmpty() || dp_date.getValue().toString() == null || tf_note.getText().isEmpty()) {
    			
    			AlertWindow.errorAlert("값 입력", "모두 작성해주세요.");
    			return;
    			
    		}
    		Map<String, String> planVo = new HashMap<>();
    		planVo.put("plan_title", cb_dept.getUserData().toString());
    		planVo.put("plan_date", dp_date.getValue().toString());
    		planVo.put("plan_note", tf_note.getText());
    		planVo.put("plan_name", tf_name.getText());
    		planVo.put("plan_no", tf_hide.getText());
    		int cnt = outsrcService.updatePlannig(planVo);
    		if(cnt == 0) {
    			AlertWindow.FailedAlert(primaryStage);
    		}else{
    			AlertWindow.SucceedAlert(primaryStage);
    			primaryStage.close();
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DeptOutSrcList_updateController click_btn_update() " + e);
		}
    	
    }

    @FXML
    void initialize() {
        assert tf_hide != null : "fx:id=\"tf_hide\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";
        assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";
        assert cb_dept != null : "fx:id=\"cb_dept\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";
        assert dp_date != null : "fx:id=\"dp_date\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";
        assert tf_note != null : "fx:id=\"tf_note\" was not injected: check your FXML file 'DeptOutSrcList_update.fxml'.";

    }
}
