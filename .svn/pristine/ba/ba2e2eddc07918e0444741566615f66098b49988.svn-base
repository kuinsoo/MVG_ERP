package humanResources.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.EmployeeVo;
import humanResources.vo.RetiredEmployeeVo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.DepartmentVo;

public class Hr_rempList_updateController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tf_note;

	@FXML
	private Label tf_hide;

	@FXML
	private Button btn_cancel;

	@FXML
	private DatePicker dp_date;

	@FXML
	private TextField tf_name;

	@FXML
	private TextField tf_hp;

	@FXML
	private ComboBox<String> cb_dept;

	@FXML
	private Button btn_update;


	public void getRempInfo(String remp_code , LocalDate date) {
		rempVo = empService.getOneRemp(remp_code);
		if(rempVo == null) {
			return;
		}
		
		remp_emp = rempVo.getRemp_emp();
		tf_hide.setText(rempVo.getRemp_code());
		Map<String, String> map = new HashMap<>();
		for (DepartmentVo deptVo : sysService.allDepartmentsList()) {
			map.put(deptVo.getDept_code(),deptVo.getDept_name());
		}
		remp_dept = rempVo.getRemp_dept();
		temp = ComboList.makerComboList(map, remp_dept);
		System.out.println(remp_dept + "dfsdf" + temp);
		cb_dept.setValue(temp);
		tf_name.setText(rempVo.getRemp_name());
		tf_hp.setText(rempVo.getRemp_hp());
		dp_date.setValue(date);
		tf_note.setText(rempVo.getRemp_note());
	}

	@FXML
	void click_btn_update(ActionEvent event) {
		RetiredEmployeeVo newrempVo = new RetiredEmployeeVo();
		EmployeeVo newEmpVo = empService.getOneEmp(remp_emp);
		/* 회원정보 입력중 */
		newrempVo.setRemp_code(tf_hide.getText());
		newrempVo.setRemp_emp(remp_emp);
		newrempVo.setRemp_dept(remp_dept);
		newEmpVo.setEmp_dept(remp_dept);
		newrempVo.setRemp_name(tf_name.getText());
		newrempVo.setRemp_hp(tf_hp.getText());
		newrempVo.setRemp_date(dp_date.getValue().toString());
		newrempVo.setRemp_note(tf_note.getText());
		
		empService.updateEmp(newEmpVo);
		result = empService.updateRemp(newrempVo);
		
		if(result > 0) {
			AlertWindow.SucceedAlert((Stage)btn_update.getScene().getWindow());
			Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
			thisStage.close();
		} else {
			AlertWindow.FailedAlert((Stage)btn_update.getScene().getWindow());
		}
	}

	@FXML
	void click_btn_cancel(ActionEvent event) {
		Stage thisStage = (Stage)btn_cancel.getScene().getWindow();
		thisStage.close();
	}

	@FXML
	void change_cb_dept(ActionEvent event) {
		Map<String, String> map = new HashMap<>();
		for (DepartmentVo deptVo : sysService.allDepartmentsList()) {
			map.put(deptVo.getDept_name(),deptVo.getDept_code());
		}
		remp_dept = ComboList.makerComboList(map, cb_dept.getValue().toString());
	}

	/* 전역변수 */
	private IEmployeeService empService = EmployeeService.getInstance();
	private ISystemAdministrationService sysService = SystemAdministrationService.getInstance();
	private RetiredEmployeeVo rempVo = null;
	private String remp_dept = "";
	private String remp_emp = "";
	String temp = "";
	private int result = 0;
	@FXML
	void initialize() {
		assert tf_note != null : "fx:id=\"tf_note\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert tf_hide != null : "fx:id=\"tf_hide\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert dp_date != null : "fx:id=\"dp_date\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert tf_hp != null : "fx:id=\"tf_hp\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert cb_dept != null : "fx:id=\"cb_dept\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		assert btn_update != null : "fx:id=\"btn_update\" was not injected: check your FXML file 'hr_rempList_update.fxml'.";
		cb_dept.setItems(ComboList.deptCombo()); // comboBox 부서 셋팅
	}
}
