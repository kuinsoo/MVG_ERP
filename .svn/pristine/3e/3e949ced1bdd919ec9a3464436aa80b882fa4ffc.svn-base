package systemAdministration.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import staticMethod.alert.AlertWindow;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.DepartmentVo;
import systemAdministration.vo.PositionVo;

/**
 * 인사부 시스템관리 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class Sys_hrController {

	private ISystemAdministrationService service;

	private ObservableList<PositionVo> listData_t1;
	private ObservableList<DepartmentVo> listData_t2;

	private Stage thisStage;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button t1_btn_add;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private TableView<PositionVo> t1_tv;

	@FXML
	private CheckBox t1_chk;

	@FXML
	private TableColumn<PositionVo, Boolean> t1_col_chkbox;

	@FXML
	private TableColumn<PositionVo, String> t1_col_name;

	@FXML
	private TableColumn<PositionVo, String> t1_col_code;

	@FXML
	private Button t2_btn_add;

	@FXML
	private Button t2_btn_delete;

	@FXML
	private TableView<DepartmentVo> t2_tv;

	@FXML
	private CheckBox t2_chk;

	@FXML
	private TableColumn<DepartmentVo, Boolean> t2_col_chkbox;

	@FXML
	private TableColumn<DepartmentVo, String> t2_col_name;

	@FXML
	private TableColumn<DepartmentVo, String> t2_col_code;

	/**
	 *@Method Name : click_t1_btn_add
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 새 직급 등록을 위한 form 창 부르기
	 *@param event
	 */
	@FXML
	void click_t1_btn_add(ActionEvent event) {
		Stage formPosition = null;
		try {
			formPosition = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/Form_PositionInsert.fxml"));

			Scene scene = new Scene(root);
			formPosition.setScene(scene);
			formPosition.initStyle(StageStyle.UNDECORATED);
			formPosition.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sys_hrController click_t1_btn_add ERROR => " + e);
		}finally {
			showPositionList_t1();
		}
	}

	/**
	 *@Method Name : click_t1_btn_delete
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 삭제 버튼을 눌렀을 때 직급들을 DB에서 삭제하는 메서드
	 *@param event
	 */
	@FXML
	void click_t1_btn_delete(ActionEvent event) {
		// OK 누를 시 삭제 진행
		if(AlertWindow.confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {

			service = SystemAdministrationService.getInstance();

			// 현재 tableView에 띄워진 목록들을 담기.
			List<PositionVo> tableViewList = t1_tv.getItems();

			// 체크된 컬럼의 dept_code만 저장하기 위한 리스트
			List<String> pos_codeList = new ArrayList<String>();

			// 체크박스로 체크된 컬럼의 dept_code 가져오기
			for(PositionVo code : tableViewList) {
				// 그 중 체크박스가 체크된 VO의 dept_code를 가져와 리스트에 저장
				if(code.getPos_chkbox().isSelected()) {
					pos_codeList.add(code.getPos_code());
				}
			}
			// 체크된 항목이 없을 경우
			if(pos_codeList.size() == 0) {
				AlertWindow.FailedAlert(thisStage);
				return;
			}
			
			// 삭제하는 행위
			int result = service.deletePositions(pos_codeList);

			// 삭제 성공 시
			if(result > 0) {
				AlertWindow.SucceedAlert(thisStage);
			}else {
				AlertWindow.FailedAlert(thisStage);
			}

			showPositionList_t1();
			// 삭제 취소 누를 시 메서드 끝내기
		}else {
			return;
		}
	}
	
	/**
	 *@Method Name : click_t1_chk
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 전체 체크 설정
	 *@param event
	 */
	@FXML
	void click_t1_chk(ActionEvent event) {
		if(t1_chk.isSelected()) {
			for(int i=0; i<t1_tv.getItems().size() ; i++) {
				t1_tv.getItems().get(i).getPos_chkbox().setSelected(true);
			}
		}else {
			for(int i=0; i<t1_tv.getItems().size() ; i++) {
				t1_tv.getItems().get(i).getPos_chkbox().setSelected(false);
			}
		}
	}

	/**
	 *@Method Name : click_t1_tv
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 목록 중 한 항목을 선택하면 권한 코드 수정 form이 뜹니다.
	 *@param event
	 */
	@FXML
	void click_t1_tv(MouseEvent event) {
		// 더블클릭시 이벤트 발동
		if(event.getClickCount() > 1) {

			// 창 띄우기
			Stage posUpdateForm = new Stage();
			// 스타일은 한번만 적용되어야 하기 때문에 위로 뺐어요
			posUpdateForm.initStyle(StageStyle.UNDECORATED);

			// 아무 값도 없을 경우
			if(t1_tv.getSelectionModel().getSelectedItem() == null)
				return;

			// 값이 있을 경우
			PositionVo positionVo = t1_tv.getSelectionModel().getSelectedItem();
			try {
				// form 창의 경로
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Form_PositionUpdate.fxml"));
				Parent root = loader.load();

				Form_PositionUpdateController form = loader.getController();

				// form에 정보 뿌려주는 메서드 호출하여 VO 넘겨주기
				form.insertToForm(positionVo);

				Scene scene = new Scene(root);
				posUpdateForm.setScene(scene);
				posUpdateForm.showAndWait();

				// 목록 새로고침
				showPositionList_t1();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Sys_hrController click_t1_tv() ERROR => " + e);
			}

		}
	}

	/**
	 *@Method Name : click_t2_btn_add
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 새 부서코드 등록 form 이 뜨게 하는 메서드
	 *@param event
	 */
	@FXML
	void click_t2_btn_add(ActionEvent event) {
		Stage formDept = null;
		try {
			formDept = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/Form_DepartmentInsert.fxml"));

			Scene scene = new Scene(root);
			formDept.setScene(scene);
			formDept.initStyle(StageStyle.UNDECORATED);
			formDept.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sys_hrController click_t2_btn_add ERROR => " + e);
		}finally {
			showDepartmentList_t2();
		}

	}

	/**
	 *@Method Name : click_t2_btn_delete
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 삭제 버튼을 눌렀을 때 부서코드들을 DB에서 삭제하는 메서드
	 *@param event
	 */
	@FXML
	void click_t2_btn_delete(ActionEvent event) {
		// OK 누를 시 삭제 진행
		if(AlertWindow.confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {

			service = SystemAdministrationService.getInstance();

			// 현재 tableView에 띄워진 목록들을 담기.
			List<DepartmentVo> tableViewList = t2_tv.getItems();

			// 체크된 컬럼의 crq_no만 저장하기 위한 리스트
			List<String> dept_codeList = new ArrayList<String>();

			// 체크박스로 체크된 컬럼의 crq_no 가져오기
			for(DepartmentVo code : tableViewList) {
				// 그 중 체크박스가 체크된 VO의 crq_no를 가져와 리스트에 저장
				if(code.getDept_chkbox().isSelected()) {
					dept_codeList.add(code.getDept_code());
				}
			}
			// 체크된 항목이 없을 경우
			if(dept_codeList.size() == 0) {
				AlertWindow.FailedAlert(thisStage);
				return;
			}
			// 삭제하는 행위
			int result = service.deleteDepartments(dept_codeList);

			// 삭제 성공 시
			if(result > 0) {
				AlertWindow.SucceedAlert(thisStage);
			// 삭제 실패 시
			}else {
				AlertWindow.FailedAlert(thisStage);
			}

			showDepartmentList_t2();
		// 삭제 취소 누를 시 메서드 끝내기
		}else {
			return;
		}
	}
	
	/**
	 *@Method Name : click_t2_chk
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 전체 체크 설정
	 *@param event
	 */
	@FXML
    void click_t2_chk(ActionEvent event) {
		if(t2_chk.isSelected()) {
			for(int i=0; i<t2_tv.getItems().size() ; i++) {
				t2_tv.getItems().get(i).getDept_chkbox().setSelected(true);
			}
		}else {
			for(int i=0; i<t2_tv.getItems().size() ; i++) {
				t2_tv.getItems().get(i).getDept_chkbox().setSelected(false);
			}
		}
    }

	/**
	 *@Method Name : click_t2_tv
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 목록 중 한 항목을 선택하면 부서 코드 수정 form이 뜹니다.
	 *@param event
	 */
	@FXML
	void click_t2_tv(MouseEvent event) {
		// 더블클릭시 이벤트 발동
		if(event.getClickCount() > 1) {

			// 창 띄우기
			Stage deptUpdateForm = new Stage();
			// 스타일은 한번만 적용되어야 하기 때문에 위로 뺐어요
			deptUpdateForm.initStyle(StageStyle.UNDECORATED);

			// 아무 값도 없을 경우
			if(t2_tv.getSelectionModel().getSelectedItem() == null)
				return;

			// 값이 있을 경우
			DepartmentVo departmentVo = t2_tv.getSelectionModel().getSelectedItem();
			try {
				// form 창의 경로
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Form_DepartmentUpdate.fxml"));
				Parent root = loader.load();

				Form_DepartmentUpdateController form = loader.getController();

				// form에 정보 뿌려주는 메서드 호출하여 VO 넘겨주기
				form.insertToForm(departmentVo);

				Scene scene = new Scene(root);
				deptUpdateForm.setScene(scene);
				deptUpdateForm.showAndWait();

				// 목록 새로고침
				showDepartmentList_t2();

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Sys_hrController click_t2_tv() ERROR => " + e);
			}

		}
	}

	@FXML
	void initialize() {
		assert t1_btn_add != null : "fx:id=\"t1_btn_add\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t1_col_chkbox != null : "fx:id=\"t1_col_chkbox\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t1_col_name != null : "fx:id=\"t1_col_name\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t2_btn_add != null : "fx:id=\"t2_btn_add\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t2_btn_delete != null : "fx:id=\"t2_btn_delete\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t2_tv != null : "fx:id=\"t2_tv\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t2_col_chkbox != null : "fx:id=\"t2_col_chkbox\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t2_col_name != null : "fx:id=\"t2_col_name\" was not injected: check your FXML file 'Sys_hr.fxml'.";
		assert t2_col_code != null : "fx:id=\"t2_col_code\" was not injected: check your FXML file 'Sys_hr.fxml'.";

		// t1 직급 리스트 뿌리기
		showPositionList_t1();

		// t2 부서 리스트 뿌리기
		showDepartmentList_t2();

	}

	/**
	 *@Method Name : showPositionList_t1
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : t1의 권한별 코드 리스트 뿌리기
	 */
	public void showPositionList_t1() {
		service = SystemAdministrationService.getInstance();

		listData_t1 = FXCollections.observableArrayList(service.allPositionsList());
		t1_tv.setItems(listData_t1);

		t1_col_chkbox.setCellValueFactory(new PropertyValueFactory<PositionVo, Boolean>("pos_chkbox"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<PositionVo, String>("pos_name"));
		t1_col_code.setCellValueFactory(new PropertyValueFactory<PositionVo, String>("pos_code"));

	}

	/**
	 *@Method Name : showDepartmentList_t2
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : t2의 부서별 코드 리스트 뿌리기
	 */
	public void showDepartmentList_t2() {
		service = SystemAdministrationService.getInstance();

		listData_t2 = FXCollections.observableArrayList(service.allDepartmentsList());
		t2_tv.setItems(listData_t2);

		t2_col_chkbox.setCellValueFactory(new PropertyValueFactory<DepartmentVo, Boolean>("dept_chkbox"));
		t2_col_name.setCellValueFactory(new PropertyValueFactory<DepartmentVo, String>("dept_name"));
		t2_col_code.setCellValueFactory(new PropertyValueFactory<DepartmentVo, String>("dept_code"));

	}



}
