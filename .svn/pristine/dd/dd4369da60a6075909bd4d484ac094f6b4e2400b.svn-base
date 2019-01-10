package systemAdministration.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.CodeRequestVo;
import systemAdministration.vo.join.CodeRequest_DepartmentVo;

public class Form_CodeUpdateController {
	
	private ISystemAdministrationService service;
	
	private Stage thisStage;
	
	public CodeRequestVo coderequestVo;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tf_dept;

	@FXML
	private TextField tf_emp;

	@FXML
	private TextField tf_date;

	@FXML
	private TextField tf_no;

	@FXML
	private Button btn_update;

	@FXML
	private Button btn_cancel;

	@FXML
	private TextField tf_note;

	@FXML
	private ComboBox<String> cb_prc;

	@FXML
	private TextField tf_div;

	/**
	 *@Method Name : click_cancel
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : 취소 버튼을 누르면 해당 창이 닫힙니다.
	 *@param event
	 */
	@FXML
	void click_cancel(ActionEvent event) {
		thisStage = (Stage)btn_cancel.getScene().getWindow();
    	thisStage.close();
	}

	/**
	 *@Method Name : click_update
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : 수정 버튼을 누르면 수정된 내용을 DB에 반영하는 메서드
	 *@param event
	 */
	@FXML
	void click_update(ActionEvent event) {
		// 처리여부를 선택하지 않았을 때
		if(cb_prc.getValue().isEmpty()) {
			AlertWindow.FailedAlert(thisStage);
			return;
		}
		
		CodeRequestVo codeRequestVo = new CodeRequestVo();
		codeRequestVo.setCrq_no(tf_no.getText());
		codeRequestVo.setCrq_dept(tf_dept.getText());
		codeRequestVo.setCrq_emp(tf_emp.getText());
		codeRequestVo.setCrq_date(tf_date.getText());
		codeRequestVo.setCrq_div(tf_div.getText());
		codeRequestVo.setCrq_note(tf_note.getText());
		codeRequestVo.setCrq_prc(cb_prc.getSelectionModel().getSelectedItem());
		
		service = SystemAdministrationService.getInstance();
		int result = service.updateCodeRequest(codeRequestVo);
		
		if(result > 0) {
			AlertWindow.SucceedAlert(thisStage);
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
		assert tf_dept != null : "fx:id=\"tf_dept\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert tf_emp != null : "fx:id=\"tf_emp\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert tf_date != null : "fx:id=\"tf_date\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert tf_no != null : "fx:id=\"tf_no\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert tf_note != null : "fx:id=\"tf_note\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert cb_prc != null : "fx:id=\"cb_prc\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";
		assert tf_div != null : "fx:id=\"tf_div\" was not injected: check your FXML file 'CodeUpdateForm.fxml'.";

		tf_dept.setDisable(true);
		tf_emp.setDisable(true);
		tf_date.setDisable(true);
		tf_no.setDisable(true);
		tf_note.setDisable(true);
		tf_div.setDisable(true);
		
		// 콤보박스 내용
		cb_prc.getItems().addAll("Y", "N");
		
	}
	
	/**
	 *@Method Name : insertToForm
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : CodeRequest_DepartmentVo를 form에 출력하는 메서드
	 *@param code 코드신청서 1개 내역(부서코드는 부서table과 조인하여 부서명으로 가져옵니다.)
	 */
	public void insertToForm(CodeRequest_DepartmentVo code) {
		tf_no.setText(code.getCrq_no());
		tf_dept.setText(code.getDept_name());
		tf_emp.setText(code.getCrq_name());
		tf_date.setText(code.getCrq_date());
		tf_div.setText(code.getCrq_div());
		tf_note.setText(code.getCrq_note());
		cb_prc.setValue(code.getCrq_prc());
	}
}
