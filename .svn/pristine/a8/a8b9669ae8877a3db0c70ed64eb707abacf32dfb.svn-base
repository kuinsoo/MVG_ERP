package outsourcing.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import outsourcing.service.IOutsourcingService;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.AccountVo;
import outsourcing.vo.PlanningVo;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;

public class DeptOutSrcListPopupController {
	
	private IOutsourcingService service = OutsourcingService.getInstance();
    private List<String> accNameList = new ArrayList<String>();
    
    private Stage thisStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_submit;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextArea ta_note;

    @FXML
    private ComboBox<String> cb_acc;

    @FXML
    private TextField tf_title;

    @FXML
    private ComboBox<String> cb_empName;

    @FXML
    void click_btn_cancel(ActionEvent event) {
    	Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void click_btn_submit(ActionEvent event) {
    	if(tf_title.getText().trim().isEmpty()	||
    			cb_acc.getValue() == null		||
    			cb_empName.getValue() == null	||
    			ta_note.getText().trim().isEmpty()
    			) {
    		AlertWindow.errorAlert("공백 오류", "모든 항목을 채우세요");
    		return;
    	}
    	PlanningVo planVo = new PlanningVo();
    	planVo.setPlan_no(Codemaker.cont_code());
    	planVo.setPlan_acc(service.getAccCode(cb_acc.getValue()));
    	planVo.setPlan_title(tf_title.getText());
    	planVo.setPlan_name(cb_empName.getValue());
    	planVo.setPlan_date(Codemaker.sysdate());
    	planVo.setPlan_note(ta_note.getText());
    	planVo.setPlan_dept("mdo001");


    	// 작업 성공 시
    	if(service.insertPlanning(planVo) > 0) {
    		AlertWindow.SucceedAlert(thisStage);
    		// 작업 실패시
    	}else {
    		AlertWindow.FailedAlert(thisStage);
    		return;
    	}

    	//작업 완료 후 이 창 닫기
    	thisStage = (Stage)btn_submit.getScene().getWindow();
    	thisStage.close();
    }

    @FXML
    void initialize() {
        assert btn_submit != null : "fx:id=\"btn_submit\" was not injected: check your FXML file 'DeptOutScrListPopup.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'DeptOutScrListPopup.fxml'.";
        assert ta_note != null : "fx:id=\"ta_note\" was not injected: check your FXML file 'DeptOutScrListPopup.fxml'.";
        assert cb_acc != null : "fx:id=\"cb_acc\" was not injected: check your FXML file 'DeptOutScrListPopup.fxml'.";
        assert tf_title != null : "fx:id=\"tf_title\" was not injected: check your FXML file 'DeptOutScrListPopup.fxml'.";
        assert cb_empName != null : "fx:id=\"cb_empName\" was not injected: check your FXML file 'DeptOutScrListPopup.fxml'.";

        // 콤보박스 외주 관리부 직원 이름 셋팅
        cb_empName.getItems().addAll(service.getMDOemp());

        // 콤보박스 거래처 이름 셋팅
        for(AccountVo acc : service.getAllAccount()) {
        	accNameList.add(acc.getAcc_name());
        }
        cb_acc.getItems().addAll(accNameList);
        
    }
  
}
