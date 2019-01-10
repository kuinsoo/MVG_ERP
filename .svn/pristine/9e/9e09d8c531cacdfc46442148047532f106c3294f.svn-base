package humanResources.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.EmployeeVo;
import humanResources.vo.PositionVo;
import humanResources.vo.RetiredEmployeeVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;
import staticMethod.comboBox.ComboList;
import staticMethod.password.Sha256;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.DepartmentVo;

public class Hr_empList_updateController{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btn_update;

	@FXML
	private ComboBox<String> cb_gender;

	@FXML
	private ComboBox<String> cb_pos;

	@FXML
	private Button btn_cancel;

	@FXML
	private TextField tf_name;

	@FXML
	private TextField tf_hp;

	@FXML
	private TextField tf_addr;

	@FXML
	private TextField tf_regno2;

	@FXML
	private ComboBox<String> cb_dept;

	@FXML
	private TextField tf_regno1;

	@FXML
	private DatePicker dp_hdate;

	@FXML
	private TextField tf_pass;

	@FXML
	private TextField tf_note;

	@FXML
	private Label tf_hide;

	@FXML
	private Button btn_remp;

	private String emp_pos;
	private String emp_dept;
	private String emp_gender;
	private IEmployeeService empService = EmployeeService.getInstance();
	private ISystemAdministrationService sysService = SystemAdministrationService.getInstance();
	private String temp;
	private int resutl = 0;
	private EmployeeVo empVo = new EmployeeVo();

	/**
	 *@Method 설명 : 회원 정보 부모 창에서 받아오기
	 *@Method Name : getEmpInfo
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param emp_code
	 *@param date
	 */
	public void getEmpInfo(String emp_code , LocalDate date) {
		empVo = empService.getOneEmp(emp_code);
		/* 회원정보 입력중 */
		tf_hide.setText(empVo.getEmp_code());
		Map<String, String> map = new HashMap<>();
		for (PositionVo posVo : empService.getAllPosition()) {
			map.put(posVo.getPos_code(),posVo.getPos_name());
		}
		emp_pos = empVo.getEmp_pos();
		temp = ComboList.makerComboList(map, empVo.getEmp_pos());
		cb_pos.setValue(temp);
		map.clear();
		for (DepartmentVo deptVo : sysService.allDepartmentsList()) {
			map.put(deptVo.getDept_code(),deptVo.getDept_name());
		}
		emp_dept = empVo.getEmp_dept();
		temp = ComboList.makerComboList(map, empVo.getEmp_dept());
		cb_dept.setValue(temp);
		tf_pass.setText(empVo.getEmp_pass());
		tf_name.setText(empVo.getEmp_name());
		tf_hp.setText(empVo.getEmp_hp());
		tf_regno1.setText(empVo.getEmp_regno1());
		tf_regno2.setText(empVo.getEmp_regno2());
		tf_addr.setText(empVo.getEmp_addr());
		emp_gender = empVo.getEmp_gender(); 
		if(empVo.getEmp_gender().equals("M")) {
			temp = "남성";
		} else if (empVo.getEmp_gender().equals("F")){
			temp = "여성";
		}
		cb_gender.setValue(temp);
		dp_hdate.setValue(date);
		tf_note.setText(empVo.getEmp_note());

	}

	/**
	 *@Method 설명 : 회원정보 업데이트
	 *@Method Name : click_btn_update
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void click_btn_update(ActionEvent event) {
		EmployeeVo newEmpVo = new EmployeeVo();

		/* 회원정보 입력중 */
		newEmpVo.setEmp_code(tf_hide.getText());
		newEmpVo.setEmp_pos(emp_pos);
		newEmpVo.setEmp_dept(emp_dept);
		if(tf_pass.getText().length() < 20) {
			newEmpVo.setEmp_pass(Sha256.encrypt(tf_pass.getText()));
		}else {
			newEmpVo.setEmp_pass(tf_pass.getText());
		}
		newEmpVo.setEmp_name(tf_name.getText());
		newEmpVo.setEmp_hp(tf_hp.getText());
		newEmpVo.setEmp_regno1(tf_regno1.getText());
		newEmpVo.setEmp_regno2(tf_regno2.getText());
		newEmpVo.setEmp_addr(tf_addr.getText());
		newEmpVo.setEmp_gender(emp_gender);
		newEmpVo.setEmp_hdate(dp_hdate.getValue().toString());
		newEmpVo.setEmp_remp(empVo.getEmp_remp());
		newEmpVo.setEmp_note(tf_note.getText());
		resutl = empService.updateEmp(newEmpVo);
		if(resutl > 0) {
			AlertWindow.SucceedAlert((Stage)btn_update.getScene().getWindow());
			Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
			thisStage.close();
		} else {
			AlertWindow.FailedAlert((Stage)btn_update.getScene().getWindow());
		}
	}

	/**
	 *@Method 설명 : 창닫기
	 *@Method Name : click_btn_cancel
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void click_btn_cancel(ActionEvent event) {
		Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
		thisStage.close();
	}

	/**
	 *@Method 설명 : 콤보박스 직급
	 *@Method Name : change_cb_pos
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void change_cb_pos(ActionEvent event) {
		Map<String, String> map = new HashMap<>();
		for (PositionVo posVo : empService.getAllPosition()) {
			map.put(posVo.getPos_name(),posVo.getPos_code());
		}
		emp_pos = ComboList.makerComboList(map, cb_pos.getValue().toString());
	}

	/**
	 *@Method 설명 : 콤보박스 부서
	 *@Method Name : change_cb_dept
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void change_cb_dept(ActionEvent event) {

		Map<String, String> map = new HashMap<>();
		for (DepartmentVo deptVo : sysService.allDepartmentsList()) {
			map.put(deptVo.getDept_name(),deptVo.getDept_code());
		}
		emp_dept = ComboList.makerComboList(map, cb_dept.getValue().toString());
	}

	/**
	 *@Method 설명 : 콤보박스 성별
	 *@Method Name : chagne_cb_gender
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void chagne_cb_gender(ActionEvent event) {
		if(cb_gender.getValue().equals("남성")) {
			emp_gender = "M";
		} else if (cb_gender.getValue().equals("여성")){
			emp_gender = "F";
		}
	}

	/**
	 *@Method 설명 : 제직중이 회원 퇴사 처리
	 *@Method Name : click_btn_remp
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void click_btn_remp(ActionEvent event) {
		if(AlertWindow.confirmAlert("정말로 등록 하시겠습니까?", "퇴사 처리 됩니다.").showAndWait().get() == ButtonType.OK) {
			RetiredEmployeeVo rempVo = new RetiredEmployeeVo();
			rempVo.setRemp_code(Codemaker.remp_Code(tf_hide.getText()));    	
			rempVo.setRemp_emp(tf_hide.getText());
			rempVo.setRemp_name(empVo.getEmp_name());
			rempVo.setRemp_hp(empVo.getEmp_hp());
			rempVo.setRemp_dept(empVo.getEmp_dept());
			rempVo.setRemp_date(LocalDate.now().toString());
			rempVo.setRemp_note(tf_note.getText());
			resutl = empService.insertRemp(rempVo);
			
			empVo.setEmp_remp("2");
			empService.updateEmp(empVo);
			if(resutl > 0) {
				AlertWindow.SucceedAlert((Stage)btn_update.getScene().getWindow());
				Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
				thisStage.close();
			} else {
				AlertWindow.FailedAlert((Stage)btn_update.getScene().getWindow());
			}
		}
	}

	@FXML
	void initialize() {
		assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert cb_gender != null : "fx:id=\"cb_gender\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert cb_pos != null : "fx:id=\"cb_pos\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_hp != null : "fx:id=\"tf_hp\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_addr != null : "fx:id=\"tf_addr\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_regno2 != null : "fx:id=\"tf_regno2\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert cb_dept != null : "fx:id=\"cb_dept\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_regno1 != null : "fx:id=\"tf_regno1\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert dp_hdate != null : "fx:id=\"cb_hdate\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_pass != null : "fx:id=\"tf_pass\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_note != null : "fx:id=\"tf_note\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert tf_hide != null : "fx:id=\"tf_hide\" was not injected: check your FXML file 'hr_empList_update.fxml'.";
		assert btn_remp != null : "fx:id=\"btn_remp\" was not injected: check your FXML file 'hr_empList_update.fxml'.";

		empService = EmployeeService.getInstance();
		dp_hdate.setValue(LocalDate.now()); // datepicker를 오늘 날짜로 기본 셋팅 
		cb_pos.setItems(ComboList.posCombo());	// comboBox 직급 셋팅
		cb_dept.setItems(ComboList.deptCombo()); // comboBox 부서 셋팅
		cb_gender.setItems(ComboList.genderCombo()); // comboBox 성별 셋팅
	}
}

