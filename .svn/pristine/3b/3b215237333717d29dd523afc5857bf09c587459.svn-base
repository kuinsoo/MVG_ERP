package systemAdministration.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.AccountVo;

public class Form_AccountInsertController {
	
private ISystemAdministrationService service;
	
	private Stage thisStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf_code;

    @FXML
    private TextField tf_name;

    @FXML
    private Button btn_insert;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField tf_rep;

    @FXML
    private TextField tf_addr;

    @FXML
    void click_cancel(ActionEvent event) {
    	thisStage = (Stage)btn_cancel.getScene().getWindow();
    	thisStage.close();
    }

    /**
     *@Method Name : click_insert
     *@date : 2018. 9. 20.
     *@author : Sohyoung
     *@Method 설명 : 새로운 거래처 등록을 위한 메서드
     *@param event
     */
    @FXML
    void click_insert(ActionEvent event) {
    	if(tf_code.getText().trim().isEmpty() 		||
    			tf_name.getText().trim().isEmpty() 	||
    			tf_rep.getText().trim().isEmpty()	||
    			tf_addr.getText().trim().isEmpty()
    			) {
    		AlertWindow.errorAlert("공백 오류", "비어있는 칸이 있습니다. 내용을 입력해 주세요");
    		return;
    	}
    	
    	AccountVo accountVo = new AccountVo();
    	accountVo.setAcc_code(tf_code.getText());
    	accountVo.setAcc_name(tf_name.getText());
    	accountVo.setAcc_rep(tf_rep.getText());
    	accountVo.setAcc_addr(tf_addr.getText());
    	
    	service = SystemAdministrationService.getInstance();
    	
    	// 작업 성공 시
    	if(service.insertAccount(accountVo) > 0) {
    		AlertWindow.SucceedAlert(thisStage);
    	// 작업 실패시
    	}else {
			AlertWindow.FailedAlert(thisStage);
			return;
    	}
    	
    	//작업 완료 후 이 창 닫기
    	thisStage = (Stage)btn_insert.getScene().getWindow();
    	thisStage.close();
    	
    }

    @FXML
    void initialize() {
    	assert tf_code != null : "fx:id=\"tf_code\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert btn_insert != null : "fx:id=\"btn_insert\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert tf_rep != null : "fx:id=\"tf_rep\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert tf_addr != null : "fx:id=\"tf_addr\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
       
    }
    
    /**
	 *@Method Name : resetField
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 입력칸들을 모두 초기화 합니다.
	 */
	public void resetFields() {
		tf_code.clear();
		tf_name.clear();
		tf_rep.clear();
		tf_addr.clear();
	}

    
}
