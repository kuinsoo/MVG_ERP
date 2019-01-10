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

public class Form_AccountUpdateController {
	
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
    private Button btn_update;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField tf_rep;

    @FXML
    private TextField tf_addr;

    @FXML
    void click_btn_cancel(ActionEvent event) {
    	thisStage = (Stage)btn_cancel.getScene().getWindow();
    	thisStage.close();
    }

    /**
     *@Method Name : click_btn_update
     *@date : 2018. 9. 20.
     *@author : Sohyoung
     *@Method 설명 : 거래처 수정을 위한 메서드
     *@param event
     */
    @FXML
    void click_btn_update(ActionEvent event) {
    	// 비어있는 칸이 있는지 검사
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
    	if(service.updateAccount(accountVo) > 0) {
    		AlertWindow.SucceedAlert(thisStage);
    	// 작업 실패시
    	}else {
			AlertWindow.FailedAlert(thisStage);
			return;
    	}
    	
    	//작업 완료 후 이 창 닫기
    	thisStage = (Stage)btn_update.getScene().getWindow();
    	thisStage.close();
    	
    }

    @FXML
    void initialize() {
    	assert tf_code != null : "fx:id=\"tf_code\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert btn_update != null : "fx:id=\"btn_insert\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert tf_rep != null : "fx:id=\"tf_rep\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
        assert tf_addr != null : "fx:id=\"tf_addr\" was not injected: check your FXML file 'Form_AccountInsert.fxml'.";
       
        // pk인 acc_code는 수정 불가
        tf_code.setDisable(true);
    }
    
    /**
   	 *@Method Name : insertToForm
   	 *@date : 2018. 9. 20.
   	 *@author : Sohyoung
   	 *@Method 설명 : AccountVo를 form에 출력하는 메서드
   	 *@param code 거래처코드 1개 내역(부모 창에서 받아온 vo 입니다.)
   	 */
   	public void insertToForm(AccountVo acc) {
   		tf_code.setText(acc.getAcc_code());
   		tf_name.setText(acc.getAcc_name());
   		tf_rep.setText(acc.getAcc_rep());
   		tf_addr.setText(acc.getAcc_addr());
   	}

    
}
