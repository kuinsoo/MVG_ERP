package humanResources.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.join.GetAllRetiredEmpVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;

public class Hr_empRetireController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t1_col_hp;

	@FXML
	private TableColumn<GetAllRetiredEmpVo, Boolean> t1_col_chk;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private AnchorPane tap1_t1;

	@FXML
	private Button t1_bnt_search;

	@FXML
	private TabPane t1_tp_main;

	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t1_col_dept;

	@FXML
	private TextField t1_tf_search;

	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t1_col_name;

	@FXML
	private ComboBox<String> t1_cb_search;

	@FXML
	private TableView<GetAllRetiredEmpVo> t1_tv;

	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t1_col_date;

	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t1_col_code;

	@FXML
	private CheckBox t1_chk;


	@FXML
	void select_t1_cb_search(ActionEvent event) {

	}

	@FXML
	void click_search(ActionEvent event) {
		Map<String, String> getEmp = new HashMap<>();
		if(t1_tf_search.getText().equals("")) {
			getAllRetiredEmp(empService.getAllRetiredEmp()); 
		}else {
			if(t1_cb_search.getValue().toString().equals("퇴사자코드")) {
				getEmp.put("remp_code", t1_tf_search.getText());
//				getEmp.put("remp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("퇴사자명")) {
				getEmp.put("remp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("부서")) {
				getEmp.put("dept_name", t1_tf_search.getText());
//				getEmp.put("remp_name", t1_tf_search.getText());
			}
			List<GetAllRetiredEmpVo> rempList =  empService.getRemp(getEmp);
			if(rempList.size() == 0) {
				AlertWindow.infoAlert("Failed", "결과 값이 존재하지 않습니다.");
			}else {
				getAllRetiredEmp(rempList); // 출력 			
			}
		}// else 
	}

	@FXML
	void click_t1_tv(MouseEvent event) {
		if (event.getClickCount() > 1) { 
			Stage updateEmp = new Stage();
			if(t1_tv.getSelectionModel().getSelectedItem() == null) {

			} else {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/hr_rempList_update.fxml"));
					updateEmp.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
					updateEmp.initOwner(t1_tp_main.getScene().getWindow());						// 부모창 설정
					Parent pRoot = loader.load();
					Hr_rempList_updateController formController = loader.getController();
					GetAllRetiredEmpVo rempVo = t1_tv.getSelectionModel().getSelectedItem();
					int year = Integer.parseInt(rempVo.getRemp_date().substring(0,4));
					int month = Integer.parseInt(rempVo.getRemp_date().substring(5,7));
					int day = Integer.parseInt(rempVo.getRemp_date().substring(8,10));
					LocalDate  currentTime = LocalDate.now();
					LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
					formController.getRempInfo(rempVo.getRemp_code() , targetTime);
					Scene scene = new Scene(pRoot);							// 새창을 연결
					updateEmp.setScene(scene);								// 스테이지에 새씬을 연결한다.
					updateEmp.showAndWait();										// 열어주세요.
				} catch (IOException e) {
					System.out.println("hr_empListController" + e);
				}
				getAllRetiredEmp(empService.getAllRetiredEmp()); // 새로고침
			}
		}
	}

	/**
	 *@Method 설명 : 퇴사회원을 삭제한다.
	 *@Method Name : click_delete
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@param event
	 */
	@FXML
	void click_delete(ActionEvent event) {
		rempList = empService.getAllRetiredEmp();
		List<String> tempList = new ArrayList<>();
		rempList = t1_tv.getItems();
		int cnt = 0;
		for (GetAllRetiredEmpVo remployeeVo : rempList) {
			if(remployeeVo.getRemp_chk().isSelected()) {
				tempList.add(remployeeVo.getRemp_code());
			}
		}
		if(tempList.size() == 0) {
			AlertWindow.FailedAlert((Stage) t1_btn_delete.getScene().getWindow());
			return;
		}
		/* 쿼리 생성*/
		cnt =   empService.deleteRemp(tempList);
		if(cnt > 0 ) {
			System.out.println(cnt + "건이 삭제되었습니다.");
			staticMethod.alert.AlertWindow.SucceedAlert((Stage) t1_btn_delete.getScene().getWindow());
		} else {
			AlertWindow.FailedAlert((Stage) t1_btn_delete.getScene().getWindow());
		}

		getAllRetiredEmp(empService.getAllRetiredEmp());
	}

	@FXML
	void select_t1_chk(ActionEvent event) {
		rempList = empService.getAllRetiredEmp();
		if(t1_chk.isSelected()) {
			for (GetAllRetiredEmpVo remployeeVo : rempList) {
				remployeeVo.getRemp_chk().setSelected(true);
			}
		} else {
			for (GetAllRetiredEmpVo remployeeVo : rempList) {
				remployeeVo.getRemp_chk().setSelected(false);
			}
		}
		getAllRetiredEmp(rempList); // 새로고침
	}

	/* 전역 변수 선언 */
	private IEmployeeService empService  = EmployeeService.getInstance();
	private List<GetAllRetiredEmpVo> rempList;
	private ObservableList<GetAllRetiredEmpVo> objList;

	@FXML
	void initialize() {
		assert t1_col_chk != null : "fx:id=\"t1_col_chk\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_col_hp != null : "fx:id=\"t1_col_hp\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_col_chk != null : "fx:id=\"t1_col_chk\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert tap1_t1 != null : "fx:id=\"tap1_t1\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_bnt_search != null : "fx:id=\"t1_bnt_search\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_tp_main != null : "fx:id=\"t1_tp_main\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_col_dept != null : "fx:id=\"t1_col_dept\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_tf_search != null : "fx:id=\"t1_tf_search\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_col_name != null : "fx:id=\"t1_col_name\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_cb_search != null : "fx:id=\"t1_cb_search\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_col_date != null : "fx:id=\"t1_col_date\" was not injected: check your FXML file 'hr_empRetire.fxml'.";
		assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'hr_empRetire.fxml'.";

		getAllRetiredEmp(empService.getAllRetiredEmp());

		t1_cb_search.setItems(ComboList.searchRemp());
		t1_cb_search.getSelectionModel().selectFirst();
	}

	public void getAllRetiredEmp(List<GetAllRetiredEmpVo> empList) {
		/* 체크박스 사용시 주의 사항
		 * ex) 연결되어있는 GetAllNowEmpVo 에서 체크박스를 생성합니다.  (겟터셋터 그리고 오버라이드된 셋터하나더 )
		 * GetAllNowEmpVo 열어서 내용 확인후   EmployeeDao 에서 getAllNowEmp() 메서드안에 내용을 확인한다.
		 * 검색된 수만큼 체크박스를 생성해주는 방식을 이용했다. */
		objList = FXCollections.observableArrayList(empList);
		t1_tv.setItems(objList);
		t1_col_chk.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, Boolean>("remp_chk"));
		t1_col_code.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_code"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_name"));
		t1_col_hp.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_hp"));
		t1_col_dept.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("dept_name"));
		t1_col_date.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_date"));
	} //getAllRetiredEmp()
}
