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
import systemAdministration.vo.AccountVo;

/**
 * 외주관리부 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class Sys_outController {

	private ISystemAdministrationService service = SystemAdministrationService.getInstance();

	private ObservableList<AccountVo> listData;

	private Stage thisStage;

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
	private Button t1_btn_add;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private TableView<AccountVo> t1_tv;
	
	@FXML
    private CheckBox t1_chk;

	@FXML
	private TableColumn<AccountVo, Boolean> t1_col_chkbox;

	@FXML
	private TableColumn<AccountVo, String> t1_col_code;

	@FXML
	private TableColumn<AccountVo, String> t1_col_name;

	@FXML
	private TableColumn<AccountVo, String> t1_col_rep;

	@FXML
	private TableColumn<AccountVo, String> t1_col_addr;

	/**
	 *@Method Name : click_t1_btn_add
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 새 거래처 등록을 위한 form 창 부르기
	 *@param event
	 */
	@FXML
	void click_t1_btn_add(ActionEvent event) {
		Stage formAccount = null;
		try {
			formAccount = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/Form_AccountInsert.fxml"));

			Scene scene = new Scene(root);
			formAccount.setScene(scene);
			formAccount.initStyle(StageStyle.UNDECORATED);
			formAccount.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sys_outController click_t1_btn_add ERROR => " + e);
		}finally {
			showList(FXCollections.observableArrayList(service.allAccountsList()));
		}	
	}
	/**
	 *@Method Name : click_t1_btn_delete
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 삭제 버튼을 눌렀을 때 거래처코드들 DB에서 삭제하는 메서드
	 *@param event
	 */
	@FXML
	void click_t1_btn_delete(ActionEvent event) {
		// OK 누를 시 삭제 진행
		if(AlertWindow.confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {

			// 현재 tableView에 띄워진 목록들을 담기.
			List<AccountVo> tableViewList = t1_tv.getItems();

			// 체크된 컬럼의 acc_code만 저장하기 위한 리스트
			List<String> acc_codeList = new ArrayList<String>();

			// 체크박스로 체크된 컬럼의 acc_code 가져오기
			for(AccountVo code : tableViewList) {
				// 그 중 체크박스가 체크된 VO의 acc_code를 가져와 리스트에 저장
				if(code.getAcc_chkbox().isSelected()) {
					acc_codeList.add(code.getAcc_code());
				}
			}
			// 체크된 항목이 없을 경우
			if(acc_codeList.size() == 0) {
				AlertWindow.FailedAlert(thisStage);
				return;
			}

			// 삭제하는 행위
			int result = service.deleteAccounts(acc_codeList);

			// 삭제 성공 시
			if(result > 0) {
				AlertWindow.SucceedAlert(thisStage);
			}else {
				AlertWindow.FailedAlert(thisStage);
			}
			// 거래처 새로고침
			showList(FXCollections.observableArrayList(service.allAccountsList()));
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
				t1_tv.getItems().get(i).getAcc_chkbox().setSelected(true);
			}
		}else {
			for(int i=0; i<t1_tv.getItems().size() ; i++) {
				t1_tv.getItems().get(i).getAcc_chkbox().setSelected(false);
			}
		}
	}

	/**
	 *@Method Name : click_t1_tv
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 목록 중 한 항목을 선택하면 거래처 코드 수정 form이 뜹니다.
	 *@param event
	 */
	@FXML
	void click_t1_tv(MouseEvent event) {
		// 더블클릭시 이벤트 발동
		if(event.getClickCount() > 1) {

			// 창 띄우기
			Stage accUpdateForm = new Stage();
			// 스타일은 한번만 적용되어야 하기 때문에 위로 뺐어요
			accUpdateForm.initStyle(StageStyle.UNDECORATED);

			// 아무 값도 없을 경우
			if(t1_tv.getSelectionModel().getSelectedItem() == null)
				return;

			// 값이 있을 경우
			AccountVo accountVo = t1_tv.getSelectionModel().getSelectedItem();
			try {
				// form 창의 경로
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Form_AccountUpdate.fxml"));
				Parent root = loader.load();

				Form_AccountUpdateController form = loader.getController();

				// form에 정보 뿌려주는 메서드 호출하여 VO 넘겨주기
				form.insertToForm(accountVo);

				Scene scene = new Scene(root);
				accUpdateForm.setScene(scene);
				accUpdateForm.showAndWait();

				// 목록 새로고침
				showList(FXCollections.observableArrayList(service.allAccountsList()));

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Sys_outController click_t2_tv() ERROR => " + e);
			}
		}
	}

	/**
	 *@Method Name : click_t1_btn_search
	 *@date : 2018. 9. 21.
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
				showList(FXCollections.observableArrayList(service.allAccountsList()));
				t1_cb.getSelectionModel().selectFirst();
				return;
			}
			
			/* Map<콤보박스 : key  , tf값 : value > */
			Map<String, String> searchAcc = new HashMap<String, String>();

			// 콤보박스 값
			// 전체
			if(t1_cb.getValue() == ComboList.accountCombo().get(0)) {
				listData = FXCollections.observableArrayList(service.searchAllAccounts(t1_tf_search.getText()));
				// 결과값이 없다면
				if(listData.isEmpty()) {
					t1_tv.setItems(null);
				// 결과값이 있다면 tableView에 출력해주기
				}else {
					showList(listData);
				}
				return;
				
			// 거래처코드
			}else if(t1_cb.getValue() == ComboList.accountCombo().get(1)) {
				searchAcc.put("acc_code", t1_tf_search.getText());
			// 거래처명	
			}else if(t1_cb.getValue() == ComboList.accountCombo().get(2)) {
				searchAcc.put("acc_name", t1_tf_search.getText());
			// 대표
			}else if(t1_cb.getValue() == ComboList.accountCombo().get(3)) {
				searchAcc.put("acc_rep", t1_tf_search.getText());
			}
			// 콤보박스 조건에 맞는 검색 결과 출력
			listData =  FXCollections.observableArrayList(service.searchAccounts(searchAcc));
			
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
		assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_tf_search != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_btn_add != null : "fx:id=\"t1_btn_add\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_col_chkbox != null : "fx:id=\"t1_col_chkbox\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_col_name != null : "fx:id=\"t1_col_name\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_col_rep != null : "fx:id=\"t1_col_rep\" was not injected: check your FXML file 'Sys_out.fxml'.";
		assert t1_col_addr != null : "fx:id=\"t1_col_addr\" was not injected: check your FXML file 'Sys_out.fxml'.";

		// 검색용 콤보박스 내용
		t1_cb.getItems().addAll(ComboList.accountCombo());
		t1_cb.getSelectionModel().selectFirst();

		// 거래처 목록 띄우기
		showList(FXCollections.observableArrayList(service.allAccountsList()));

	}

	/**
	 *@Method Name : showList
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 거래처 코드 목록 띄우는 메서드
	 */
	public void showList(ObservableList<AccountVo> listData) {
		t1_tv.setItems(listData);

		t1_col_chkbox.setCellValueFactory(new PropertyValueFactory<AccountVo, Boolean>("acc_chkbox"));
		t1_col_code.setCellValueFactory(new PropertyValueFactory<AccountVo, String>("acc_code"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<AccountVo, String>("acc_name"));
		t1_col_rep.setCellValueFactory(new PropertyValueFactory<AccountVo, String>("acc_rep"));
		t1_col_addr.setCellValueFactory(new PropertyValueFactory<AccountVo, String>("acc_addr"));
	}



}
