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
import systemAdministration.vo.PositionVo;

public class Form_PositionUpdateController {

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

	/**
	 *@Method Name : click_btn_update
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 수정 버튼을 누르면 수정된 직급 코드 내용을 DB에 반영하는 메서드
	 *@param event
	 */
	@FXML
	void click_btn_update(ActionEvent event) {
		// 빈칸이 있을 때 처리
		if(tf_code.getText().trim().isEmpty()	||
				tf_name.getText().trim().isEmpty()
				) {
			AlertWindow.errorAlert("공백 오류", "비어있는 칸이 있습니다. 내용을 입력해 주세요");
			return;
		}

		PositionVo positionVo = new PositionVo();
		positionVo.setPos_code(tf_code.getText());
		positionVo.setPos_name(tf_name.getText());

		service = SystemAdministrationService.getInstance();
		int result = service.updatePosition(positionVo);

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

	/**
	 *@Method Name : click_cancel
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 취소 버튼을 누르면 창을 닫습니다.
	 *@param event
	 */
	@FXML
	void click_cancel(ActionEvent event) {
		thisStage = (Stage)btn_cancel.getScene().getWindow();
		thisStage.close();
	}

	@FXML
	void initialize() {
		assert tf_code != null : "fx:id=\"tf_code\" was not injected: check your FXML file 'Form_PositionUpdate.fxml'.";
		assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'Form_PositionUpdate.fxml'.";
		assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'Form_PositionUpdate.fxml'.";
		assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'Form_PositionUpdate.fxml'.";

		// pk인 pos_code는 수정 불가
		tf_code.setDisable(true);
	}

	/**
	 *@Method Name : insertToForm
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : PositionVo를 form에 출력하는 메서드
	 *@param pos 직급 1개 내역(부모 창에서 받아온 vo 입니다.)
	 */
	public void insertToForm(PositionVo pos) {
		tf_code.setText(pos.getPos_code());
		tf_name.setText(pos.getPos_name());
	}
}
