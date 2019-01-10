package systemAdministration.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.AttendedVo;
import humanResources.vo.EmployeeVo;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import staticMethod.password.Sha256;

public class LoginController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView img_logo;

	@FXML
	private TextField tf_id;

	@FXML
	private ImageView img_exit;

	@FXML
	private Button btn_login;

	@FXML
	private PasswordField tf_pass;



	private IEmployeeService empService;

	/**
	 *@Method Name : click_btn_login
	 *@date : 2018. 9. 13.
	 *@author : Mr.KKu
	 *@Method 설명 : 로그인 성공시 해당 로그인 사원 부서로 이동  / 실패시 실패 ERROR 창 출력
	 *@param event
	 */
	@FXML
	void click_btn_login(ActionEvent event) {
		empService = EmployeeService.getInstance();				// 사원 서비스 연결
		Map<String, String> map = new HashMap<String, String>();
		map.put("emp_code", tf_id.getText());
		map.put("emp_pass", Sha256.encrypt(tf_pass.getText()));
		EmployeeVo empVo = empService.loginEmp(map);	// 아이디와 일치하는 사원 하나를 검색해온다.

		AttendedVo attendedVo = empService.checkAttendEmp(tf_id.getText());

		//    	map.put(tf_id.getText(), tf_pass.getText());

		Stage primaryStage = (Stage)btn_login.getScene().getWindow();  // 현재 Stage를 가르켜는 큰 변수.

		if (empVo == null ) {	// vo 가 null 값이면 아이디가 일치하는 사원이 없는 것 이다.
			try {
				Stage errorModal = new Stage();						 	// 새로운 스테이지를 하나만든다.
				errorModal.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
				errorModal.initOwner(primaryStage);						// 부모창 설정
				Parent proot = FXMLLoader.load(getClass().getResource("../fxml/error.fxml")); // Error표시를 출력해주는 주소
				Scene scene = new Scene(proot);							// 새창을 연결
				errorModal.setScene(scene);								// 스테이지에 새씬을 연결한다.
				errorModal.initStyle(StageStyle.UNDECORATED);
				errorModal.show();										// 열어주세요.
			} catch (Exception e) {
				System.out.println("login Controller" + e);
			}
		} else if (empVo != null && attendedVo == null) {  // 아이디와 패스워드가 맞으면 실행

			/* 출석 체크 해주세요 */
			try {
				Stage attendStage = new Stage();						 	// 새로운 스테이지를 하나만든다.
				attendStage.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
				attendStage.initOwner(primaryStage);						// 부모창 설정
				Parent proot = FXMLLoader.load(getClass().getResource("../fxml/MyAtten.fxml")); // Error표시를 출력해주는 주소
				Scene scene = new Scene(proot);							// 새창을 연결
				attendStage.setScene(scene);								// 스테이지에 새씬을 연결한다.
				attendStage.initStyle(StageStyle.UNDECORATED);
				attendStage.showAndWait();										// 열어주세요.

				/* 출석체크를 실시 한다 */
				Map<String, String> attdMap = new HashMap<>();
				attdMap.put("attd_emp", tf_id.getText());
				empService.checkAttend(attdMap);
				loadDepartment(empVo.getEmp_dept());
			} catch (Exception e) {
				System.out.println("login Controller" + e);
			}

		} else {  // 아이디와 패스워드가 맞으면 실행
			loadDepartment(empVo.getEmp_dept());
		} 
	}



	/**
	 *@Method Name : deptConnect
	 *@date : 2018. 9. 13.
	 *@author : Mr.KKu
	 *@Method 설명 : 각 부서에 맞는 창으로 연결되는 함수 매개변수로 주소를 받는다.
	 *@param str
	 */
	private void deptConnect(String str) {
		try {
			Stage primaryStage = (Stage)btn_login.getScene().getWindow();  // 현재 Stage를 가르켜는 큰 변수.
			Stage mdhStage = new Stage();		// 새로운 스테이지를 만든다.
			Parent root = FXMLLoader.load(getClass().getResource(str));  // 연결 경로를 저장한다.
			Scene scene = new Scene(root);		// 연결된 fxml 을 새로운 씬에 연결
			mdhStage.setScene(scene);			// 스테이지에 씬을 넣어준다.
			mdhStage.initStyle(StageStyle.UNDECORATED); // 스테이지 옵션  window창 삭제
			mdhStage.show();					// 새로운 스테이지를 보여준다.
			primaryStage.close();				// 로그인 창을 닫아준다.
		} catch (IOException e) {
			System.out.println("empMainTest" + e);
			e.printStackTrace();
		}
	}
	
	private void loadDepartment(String str) {
		switch (str) {  // 부서값을 조건값으로 설정한다.
		case "mdh001": // 인사부
			deptConnect( "../../humanResources/fxml/hr_emp.fxml");  // deptConnect 메서드 (String) 위치값만 지정해주면 된다.
			break;
		case "mdo001": // 외주부
			deptConnect( "../../outsourcing/fxml/DeptOutSrc.fxml");
			break;
		case "mdm001": // 자재부 
			deptConnect( "../../material/fxml/HouseRes1.fxml");
			break;
		case "mdp001": // 생산부
			deptConnect( "../../production/fxml/MainForm.fxml");
			break;
		case "mds001": // 시스템관리자
			deptConnect("../fxml/Sys.fxml");
			break;
		}
	}

	@FXML
	void click_exit(MouseEvent event) {
		Platform.exit();
	}


	@FXML
	void initialize() {
		assert img_logo != null : "fx:id=\"img_logi\" was not injected: check your FXML file 'logIn.fxml'.";
		assert tf_id != null : "fx:id=\"tf_id\" was not injected: check your FXML file 'logIn.fxml'.";
		assert tf_pass != null : "fx:id=\"tf_pass\" was not injected: check your FXML file 'logIn.fxml'.";
		assert btn_login != null : "fx:id=\"btn_login\" was not injected: check your FXML file 'logIn.fxml'.";
		assert img_exit != null : "fx:id=\"img_exit\" was not injected: check your FXML file 'logIn.fxml'.";


	}
}
