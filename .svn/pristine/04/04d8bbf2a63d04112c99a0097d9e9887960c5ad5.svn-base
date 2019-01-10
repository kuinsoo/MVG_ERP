package systemAdministration.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;
import systemAdministration.service.ISystemAdministrationService;
import systemAdministration.service.SystemAdministrationService;
import systemAdministration.vo.join.CodeRequest_DepartmentVo;

/**
 * 코드신청서 목록 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class Sys_codController {

	private ISystemAdministrationService service = SystemAdministrationService.getInstance();

	private Stage thisStage;

	private ObservableList<CodeRequest_DepartmentVo> listData;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> t1_cb;

	@FXML
	private TextField t1_tf_search;

	@FXML
	private Button t1_btn_search;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private TableView<CodeRequest_DepartmentVo> t1_tv;
	
	@FXML
	private CheckBox t1_chk;

	@FXML
	private TableColumn<CodeRequest_DepartmentVo, Boolean> t1_col_chkbox;

	@FXML               
	private TableColumn<CodeRequest_DepartmentVo, String> t1_col_no;

	@FXML               
	private TableColumn<CodeRequest_DepartmentVo, String> t1_col_dept;

	@FXML               
	private TableColumn<CodeRequest_DepartmentVo, String> t1_col_emp;

	@FXML               
	private TableColumn<CodeRequest_DepartmentVo, String> t1_col_date;

	@FXML               
	private TableColumn<CodeRequest_DepartmentVo, String> t1_col_div;

	@FXML              
	private TableColumn<CodeRequest_DepartmentVo, String> t1_col_prc;

	/**
	 *@Method Name : click_t1_btn_delete
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : 삭제 버튼을 눌렀을 때 코드요청서들을 DB에서 삭제하는 메서드
	 *@param event
	 */
	@FXML
	void click_t1_btn_delete(ActionEvent event) {

		// OK 누를 시 삭제 진행
		if(AlertWindow.confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {

			// 현재 tableView에 띄워진 목록들을 담기.
			List<CodeRequest_DepartmentVo> tableViewList = t1_tv.getItems();

			// 체크된 컬럼의 crq_no만 저장하기 위한 리스트
			List<String> crq_noList = new ArrayList<String>();

			// 체크박스로 체크된 컬럼의 crq_no 가져오기
			for(CodeRequest_DepartmentVo code : tableViewList) {
				System.out.println("1");
				
				// 그 중 체크박스가 체크된 VO의 crq_no를 가져와 리스트에 저장
				if(code.getCrq_chkbox().isSelected()) {
					crq_noList.add(code.getCrq_no());
					System.out.println("여기 보세요~~~~~~~"+code.getCrq_no());
					System.out.println(code.getCrq_chkbox().isSelected());
				}
			}
			// 체크된 항목이 없을 경우
			if(crq_noList.size() == 0) {
				AlertWindow.FailedAlert(thisStage);
				return;
			}

			// 삭제하는 행위
			int result = service.deleteCodeRequests(crq_noList);
			
			// 삭제 성공 시
			if(result > 0) {
				AlertWindow.SucceedAlert(thisStage);
			}else {
				AlertWindow.FailedAlert(thisStage);
			}

			showList(FXCollections.observableArrayList(service.allCodeRequestsList()));
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
				t1_tv.getItems().get(i).getCrq_chkbox().setSelected(true);
			}
		}else {
			for(int i=0; i<t1_tv.getItems().size() ; i++) {
				t1_tv.getItems().get(i).getCrq_chkbox().setSelected(false);
			}
		}
	}

	/**
	 *@Method Name : click_t1_tv
	 *@date : 2018. 9. 18.
	 *@edit : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 목록 중 한 항목을 선택하면 수정 form이 뜹니다.
	 *@param event
	 */
	@FXML
	void click_t1_tv(MouseEvent event) {
		// 더블클릭시 이벤트 발동
		if(event.getClickCount() > 1) {

			// 창 띄우기
			Stage codeUpdateForm = new Stage();
			// 스타일은 한번만 적용되어야 하기 때문에 위로 뺐어요
			codeUpdateForm.initStyle(StageStyle.UNDECORATED);

			// 아무 값도 없을 경우
			if(t1_tv.getSelectionModel().getSelectedItem() == null)
				return;

			// 값이 있을 경우
			CodeRequest_DepartmentVo codeRequestVo = t1_tv.getSelectionModel().getSelectedItem();
			try {
				// form 창의 경로
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Form_CodeUpdate.fxml"));
				Parent root = loader.load();

				Form_CodeUpdateController form = loader.getController();

				// form에 정보 뿌려주는 메서드 호출하여 VO 넘겨주기
				form.insertToForm(codeRequestVo);

				Scene scene = new Scene(root);
				codeUpdateForm.setScene(scene);
				codeUpdateForm.showAndWait();

				// 목록 새로고침
				showList(FXCollections.observableArrayList(service.allCodeRequestsList()));

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Sys_codController listClicked() ERROR => " + e);
			}
		}
	}

	/**
	 *@Method Name : click_t1_btn_search
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 검색 버튼을 눌렀을 때 그에 따른 결과를 tableView에 출력하는 메서드
	 *@param event
	 */
	@FXML
	void click_t1_btn_search(ActionEvent event) {
		// 콤보박스 오류, 
		if(t1_cb.getValue() == null) {
			return;

			// 콤보박스 선택을 했을 시,
		}else {
			// 검색창이 비어있으면 전체 초기화를 하고 메서드를 종료한다.
			if(t1_tf_search.getText().trim().isEmpty()) {
				showList(FXCollections.observableArrayList(service.allCodeRequestsList()));
				t1_cb.getSelectionModel().selectFirst();
				return;
			}

			/* Map<콤보박스 : key  , tf값 : value > */
			Map<String, String> searchCodeR = new HashMap<String, String>();

			// 콤보박스 값
			// 전체
			if(t1_cb.getValue() == ComboList.buyerCombo().get(0)) {
				listData = FXCollections.observableArrayList(service.searchAllCodeRequests(t1_tf_search.getText()));
				// 결과값이 없다면
				if(listData.isEmpty()) {
					t1_tv.setItems(null);
					// 결과값이 있다면 tableView에 출력해주기
				}else {
					showList(listData);
				}
				return;

			// 부서별
			}else if(t1_cb.getValue() == ComboList.codeRCombo().get(1)) {
				searchCodeR.put("dept_name", t1_tf_search.getText());
			// 날짜별	
			}else if(t1_cb.getValue() == ComboList.codeRCombo().get(2)) {
				searchCodeR.put("crq_date", t1_tf_search.getText());
			// 구분항목별
			}else if(t1_cb.getValue() == ComboList.codeRCombo().get(3)) {
				searchCodeR.put("crq_div", t1_tf_search.getText());
			// 처리여부
			}else if(t1_cb.getValue() == ComboList.codeRCombo().get(4)) {
				searchCodeR.put("crq_prc", t1_tf_search.getText().toUpperCase());
			}
			// 콤보박스 조건에 맞는 검색 결과 출력
			listData =  FXCollections.observableArrayList(service.searchCodeRequests(searchCodeR));

			// 검색 결과가 없을 때
			if(listData.isEmpty()) {
				t1_tv.setItems(null);
				return;
			// 검색 결과를 tableView에 출력하기
			}else {
				showList(listData);
			}
		}
	}

	@FXML
	void initialize() {
		assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_tf_search != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_chkbox != null : "fx:id=\"t1_col_chkbox\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_no != null : "fx:id=\"t1_col_no\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_dept != null : "fx:id=\"t1_col_dept\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_emp != null : "fx:id=\"t1_col_emp\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_date != null : "fx:id=\"t1_col_date\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_div != null : "fx:id=\"t1_col_div\" was not injected: check your FXML file 'Sys_cod.fxml'.";
		assert t1_col_prc != null : "fx:id=\"t1_col_prc\" was not injected: check your FXML file 'Sys_cod.fxml'.";

		//검색용 콤보박스 내용
		t1_cb.getItems().addAll(ComboList.codeRCombo());
		t1_cb.getSelectionModel().selectFirst();

		//리스트 뿌리기
		showList(FXCollections.observableArrayList(service.allCodeRequestsList()));
		
	}

	/**
	 *@Method Name : showList
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : 코드 신청서를 tableView에 뿌리기
	 */ 
	public void showList(ObservableList<CodeRequest_DepartmentVo> listData) {

		t1_tv.setItems(listData);

		t1_col_chkbox.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, Boolean>("crq_chkbox"));
		t1_col_no.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, String>("crq_no"));
		t1_col_dept.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, String>("dept_name"));
		t1_col_emp.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, String>("crq_name"));
		t1_col_date.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, String>("crq_date"));
		t1_col_div.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, String>("crq_div"));
		t1_col_prc.setCellValueFactory(new PropertyValueFactory<CodeRequest_DepartmentVo, String>("crq_prc"));
	}





}
