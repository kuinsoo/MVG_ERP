package commonDocument.controller;

import java.net.URL;
import java.util.ResourceBundle;

import commonDocument.service.CommonDocumentService;
import commonDocument.service.ICommonDocumentService;
import commonDocument.vo.CodeRequestVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;
import staticMethod.comboBox.ComboList;

/**
 * 코드신청서 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class Com_codController {

	private ICommonDocumentService service = CommonDocumentService.getInstance();
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button t1_btn_send;

	@FXML
	private Button t1_btn_cancel;

	@FXML
	private TextField tf_crq_emp;

	@FXML
	private TextField tf_crq_name;

	@FXML
	private TextField tf_crq_note;

	@FXML
	private ComboBox<String> cb_crq_div;

	@FXML
	private ComboBox<String> cb_crq_dept;

	/**
	 *@Method Name : click_t1_btn_cancel
	 *@date : 2018. 9. 17.
	 *@author : Sohyoung
	 *@Method 설명 : 작성한 내용을 모두 초기화 합니다.
	 *@param event
	 */
	@FXML
	void click_t1_btn_cancel(ActionEvent event) {
		resetFields();
	}

	/**
	 * 
	 *@Method Name : click_t1_btn_send
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 :
	 *@param event
	 */
	@FXML
	void click_t1_btn_send(ActionEvent event) {
		System.out.println(cb_crq_div.getSelectionModel().getSelectedItem());
		System.out.println(Codemaker.sysdate_no());

		if(cb_crq_dept.getValue() == null				||
				tf_crq_emp.getText().trim().isEmpty()	||
				tf_crq_name.getText().trim().isEmpty()	||
				cb_crq_div.getValue().isEmpty() 
				) {
			AlertWindow.errorAlert("공백 오류", "비어있는 칸이 있습니다. 내용을 입력해 주세요");
			return;
		}

		CodeRequestVo codeRequestVo = new CodeRequestVo();
		codeRequestVo.setCrq_no(Codemaker.sysdate_no());
		codeRequestVo.setCrq_dept(cb_crq_dept.getValue());
		codeRequestVo.setCrq_emp(tf_crq_emp.getText());
		codeRequestVo.setCrq_name(tf_crq_name.getText());
		codeRequestVo.setCrq_date(Codemaker.sysdate());
		codeRequestVo.setCrq_div(cb_crq_div.getSelectionModel().getSelectedItem());
		codeRequestVo.setCrq_prc("N");
		codeRequestVo.setCrq_note(tf_crq_note.getText());


		int result = service.insertCodeRequest(codeRequestVo);

		if(result > 0) {
			AlertWindow.infoAlert("성공", "시스템 관리자에게 코드 신청서를 전송하였습니다.");
			resetFields();

		}else {
			AlertWindow.errorAlert("전송 실패", "오류가 발생했습니다.");
			return;
		}
	}

	@FXML
	void initialize() {
		assert t1_btn_send != null : "fx:id=\"t1_btn_send\" was not injected: check your FXML file 'Com_cod.fxml'.";
		assert t1_btn_cancel != null : "fx:id=\"t1_btn_cancel\" was not injected: check your FXML file 'Com_cod.fxml'.";
		assert tf_crq_emp != null : "fx:id=\"tf_crq_emp\" was not injected: check your FXML file 'Com_cod.fxml'.";
		assert tf_crq_name != null : "fx:id=\"tf_crq_name\" was not injected: check your FXML file 'Com_cod.fxml'.";
		assert tf_crq_note != null : "fx:id=\"tf_crq_note\" was not injected: check your FXML file 'Com_cod.fxml'.";
		assert cb_crq_div != null : "fx:id=\"cb_crq_div\" was not injected: check your FXML file 'Com_cod.fxml'.";

		//부서 콤보박스 내용
		cb_crq_dept.getItems().addAll(ComboList.deptCombo());
		cb_crq_dept.getSelectionModel().selectFirst();
		//종류 콤보박스 내용
		cb_crq_div.getItems().addAll(ComboList.codeR_divCombo());
		cb_crq_div.getSelectionModel().selectFirst();

	}

	/**
	 *@Method Name : resetField
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : 입력칸들을 모두 초기화 합니다.
	 */
	public void resetFields() {
		cb_crq_dept.getSelectionModel().selectFirst();
		tf_crq_emp.clear();
		tf_crq_name.clear();
		tf_crq_note.clear();
		cb_crq_div.getSelectionModel().selectFirst();
	}

}
