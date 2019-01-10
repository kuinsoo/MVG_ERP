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
import systemAdministration.vo.BuyerVo;
import systemAdministration.vo.MaterialCateVo;

/**
 * 생산관리부 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class Sys_defController {

	private ISystemAdministrationService service = SystemAdministrationService.getInstance();

	private ObservableList<MaterialCateVo> listData_matc;
	private ObservableList<BuyerVo> listData_buyer;

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
	private TableView<MaterialCateVo> t1_tv;
	
	@FXML
    private CheckBox t1_chk;

	@FXML
	private TableColumn<MaterialCateVo, Boolean> t1_col_chkbox;

	@FXML
	private TableColumn<MaterialCateVo, String> t1_col_code;

	@FXML
	private TableColumn<MaterialCateVo, String> t1_col_name;

	@FXML
	private ComboBox<String> t2_cb;

	@FXML
	private TextField t2_tf_search;

	@FXML
	private Button t2_btn_search;

	@FXML
	private Button t2_btn_add;

	@FXML
	private Button t2_btn_delete;

	@FXML
	private TableView<BuyerVo> t2_tv;
	
	@FXML
	private CheckBox t2_chk;

	@FXML
	private TableColumn<BuyerVo, Boolean> t2_col_chkbox;

	@FXML
	private TableColumn<BuyerVo, String> t2_col_code;

	@FXML
	private TableColumn<BuyerVo, String> t2_col_name;

	@FXML
	private TableColumn<BuyerVo, String> t2_col_rep;

	@FXML
	private TableColumn<BuyerVo, String> t2_col_addr;

	/**
	 *@Method Name : click_t2_btn_add
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 새 자재코드 등록을 위한 form 창 부르기
	 *@param event
	 */
	@FXML
	void click_t1_btn_add(ActionEvent event) {
		Stage formMaterialCate = null;
		try {
			formMaterialCate = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/Form_MaterialCateInsert.fxml"));

			Scene scene = new Scene(root);
			formMaterialCate.setScene(scene);
			formMaterialCate.initStyle(StageStyle.UNDECORATED);
			formMaterialCate.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sys_defController click_t1_btn_add ERROR => " + e);
		}finally {
			listData_matc = FXCollections.observableArrayList(service.allMaterialCatesList());
			showMaterialCateList_t1(listData_matc);
		}
	}

	/**
	 *@Method Name : click_t1_btn_delete
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 삭제 버튼을 눌렀을 때 거래처코드들을 DB에서 삭제하는 메서드
	 *@param event
	 */
	@FXML
	void click_t1_btn_delete(ActionEvent event) {
		// OK 누를 시 삭제 진행
		if(AlertWindow.confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {

			// 현재 tableView에 띄워진 목록들을 담기.
			List<MaterialCateVo> tableViewList = t1_tv.getItems();

			// 체크된 컬럼의 matc_code만 저장하기 위한 리스트
			List<String> matc_codeList = new ArrayList<String>();

			// 체크박스로 체크된 컬럼의 matc_code 가져오기
			for(MaterialCateVo code : tableViewList) {
				// 그 중 체크박스가 체크된 VO의 matc_code를 가져와 리스트에 저장
				if(code.getMatc_chkbox().isSelected()) {
					matc_codeList.add(code.getMatc_code());
				}
			}
			// 체크된 항목이 없을 경우
			if(matc_codeList.size() == 0) {
				AlertWindow.FailedAlert(thisStage);
				return;
			}

			// 삭제하는 행위
			int result = service.deleteMaterialCates(matc_codeList);

			// 삭제 성공 시
			if(result > 0) {
				AlertWindow.SucceedAlert(thisStage);
			}else {
				AlertWindow.FailedAlert(thisStage);
			}
			// 목록 새로고침
			listData_matc = FXCollections.observableArrayList(service.allMaterialCatesList());
			showMaterialCateList_t1(listData_matc);
			
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
				t1_tv.getItems().get(i).getMatc_chkbox().setSelected(true);
			}
		}else {
			for(int i=0; i<t1_tv.getItems().size() ; i++) {
				t1_tv.getItems().get(i).getMatc_chkbox().setSelected(false);
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
			Stage matcUpdateForm = new Stage();
			// 스타일은 한번만 적용되어야 하기 때문에 위로 뺐어요
			matcUpdateForm.initStyle(StageStyle.UNDECORATED);

			// 아무 값도 없을 경우
			if(t1_tv.getSelectionModel().getSelectedItem() == null)
				return;

			// 값이 있을 경우
			MaterialCateVo materialCateVo = t1_tv.getSelectionModel().getSelectedItem();
			try {
				// form 창의 경로
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Form_MaterialCateUpdate.fxml"));
				Parent root = loader.load();

				Form_MaterialCateUpdateController form = loader.getController();

				// form에 정보 뿌려주는 메서드 호출하여 VO 넘겨주기
				form.insertToForm(materialCateVo);

				Scene scene = new Scene(root);
				matcUpdateForm.setScene(scene);
				matcUpdateForm.showAndWait();

				// 목록 새로고침
				listData_matc = FXCollections.observableArrayList(service.allMaterialCatesList());
				showMaterialCateList_t1(listData_matc);
				

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Sys_defController click_t1_tv() ERROR => " + e);
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
				showMaterialCateList_t1(FXCollections.observableArrayList(service.allMaterialCatesList()));
				t1_cb.getSelectionModel().selectFirst();
				return;
			}
			
			/* Map<콤보박스 : key  , tf값 : value > */
			Map<String, String> searchMatc = new HashMap<String, String>();

			// 콤보박스 값
			// 전체
			if(t1_cb.getValue() == ComboList.materialCateCombo().get(0)) {
				listData_matc = FXCollections.observableArrayList(service.searchAllMaterialCates(t1_tf_search.getText()));
				// 결과값이 없다면
				if(listData_matc.isEmpty()) {
					t1_tv.setItems(null);
				// 결과값이 있다면 tableView에 출력해주기
				}else {
					showMaterialCateList_t1(listData_matc);
				}
				return;
				
			// 분류코드
			}else if(t1_cb.getValue() == ComboList.materialCateCombo().get(1)) {
				searchMatc.put("matc_code", t1_tf_search.getText());
			// 품목명	
			}else if(t1_cb.getValue() == ComboList.materialCateCombo().get(2)) {
				searchMatc.put("matc_name", t1_tf_search.getText());
			}
			
			// 콤보박스 조건에 맞는 검색 결과 출력
			listData_matc =  FXCollections.observableArrayList(service.searchMaterialCates(searchMatc));
			
			// 검색 결과가 없을 때
			if(listData_matc.isEmpty()) {
				t1_tv.setItems(null);
				return;
			
			// 검색 결과를 tableView에 출력하기
			}else {
				showMaterialCateList_t1(listData_matc);
			}
		}
	}

	/**
	 *@Method Name : click_t2_btn_add
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 새 구매처 등록을 위한 form 창 부르기
	 *@param event
	 */
	@FXML
	void click_t2_btn_add(ActionEvent event) {
		Stage formBuyer = null;
		try {
			formBuyer = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/Form_BuyerInsert.fxml"));

			Scene scene = new Scene(root);
			formBuyer.setScene(scene);
			formBuyer.initStyle(StageStyle.UNDECORATED);
			formBuyer.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Sys_defController click_t2_btn_add ERROR => " + e);
		}finally {
			//Buyer t2 목록 새로고침
			showBuyerList_t2(FXCollections.observableArrayList(service.allBuyersList()));
		}	
	}

	/**
	 *@Method Name : click_t2_btn_delete
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 삭제 버튼을 눌렀을 때 구매처코드들을 DB에서 삭제하는 메서드
	 *@param event
	 */
	@FXML
	void click_t2_btn_delete(ActionEvent event) {

		// OK 누를 시 삭제 진행
		if(AlertWindow.confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {

			// 현재 tableView에 띄워진 목록들을 담기.
			List<BuyerVo> tableViewList = t2_tv.getItems();

			// 체크된 컬럼의 buyer_code만 저장하기 위한 리스트
			List<String> buyer_codeList = new ArrayList<String>();

			// 체크박스로 체크된 컬럼의 buyer_code 가져오기
			for(BuyerVo code : tableViewList) {
				// 그 중 체크박스가 체크된 VO의 buyer_code를 가져와 리스트에 저장
				if(code.getBuyer_chkbox().isSelected()) {
					buyer_codeList.add(code.getBuyer_code());
				}
			}
			// 체크된 항목이 없을 경우
			if(buyer_codeList.size() == 0) {
				AlertWindow.FailedAlert(thisStage);
				return;
			}
			// 삭제하는 행위
			int result = service.deleteBuyers(buyer_codeList);

			// 삭제 성공 시
			if(result > 0) {
				AlertWindow.SucceedAlert(thisStage);
			}else {
				AlertWindow.FailedAlert(thisStage);
			}
			
			//MaterialCate t1 목록 새로고침
			listData_buyer = FXCollections.observableArrayList(service.allBuyersList());
			showBuyerList_t2(listData_buyer);
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
				t2_tv.getItems().get(i).getBuyer_chkbox().setSelected(true);
			}
		}else {
			for(int i=0; i<t2_tv.getItems().size() ; i++) {
				t2_tv.getItems().get(i).getBuyer_chkbox().setSelected(false);
			}
		}
	}
	
	/**
	 *@Method Name : click_t2_tv
	 *@date : 2018. 9. 20.
	 *@author : Sohyoung
	 *@Method 설명 : 목록 중 한 항목을 선택하면 구매처 코드 수정 form이 뜹니다.
	 *@param event
	 */
	@FXML
	void click_t2_tv(MouseEvent event) {
		// 더블클릭시 이벤트 발동
		if(event.getClickCount() > 1) {

			// 창 띄우기
			Stage buyerUpdateForm = new Stage();
			// 스타일은 한번만 적용되어야 하기 때문에 위로 뺐어요
			buyerUpdateForm.initStyle(StageStyle.UNDECORATED);

			// 아무 값도 없을 경우
			if(t2_tv.getSelectionModel().getSelectedItem() == null)
				return;

			// 값이 있을 경우
			BuyerVo buyerVo = t2_tv.getSelectionModel().getSelectedItem();
			try {
				// form 창의 경로
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Form_BuyerUpdate.fxml"));
				Parent root = loader.load();

				Form_BuyerUpdateController form = loader.getController();

				// form에 정보 뿌려주는 메서드 호출하여 VO 넘겨주기
				form.insertToForm(buyerVo);

				Scene scene = new Scene(root);
				buyerUpdateForm.setScene(scene);
				buyerUpdateForm.showAndWait();

				//Buyer t2 목록 새로고침
				showBuyerList_t2(FXCollections.observableArrayList(service.allBuyersList()));

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Sys_hrController click_t2_tv() ERROR => " + e);
			}
		}
	}

	@FXML
	void click_t2_btn_search(ActionEvent event) {
		// 콤보박스 오류, 
		if(t2_cb.getValue() == null) {
			return;

			// 콤보박스 선택을 했을 시,
		}else {
			// 검색창이 비어있으면 전체 초기화를 하고 메서드를 종료한다.
			if(t2_tf_search.getText().trim().isEmpty()) {
				showBuyerList_t2(FXCollections.observableArrayList(service.allBuyersList()));
				t2_cb.getSelectionModel().selectFirst();
				return;
			}

			/* Map<콤보박스 : key  , tf값 : value > */
			Map<String, String> searchBuyer = new HashMap<String, String>();

			// 콤보박스 값
			// 전체
			if(t2_cb.getValue() == ComboList.buyerCombo().get(0)) {
				listData_buyer = FXCollections.observableArrayList(service.searchAllBuyers(t2_tf_search.getText()));
				// 결과값이 없다면
				if(listData_buyer.isEmpty()) {
					t2_tv.setItems(null);
					// 결과값이 있다면 tableView에 출력해주기
				}else {
					showBuyerList_t2(listData_buyer);
				}
				return;

				// 구매처코드
			}else if(t2_cb.getValue() == ComboList.buyerCombo().get(1)) {
				searchBuyer.put("buyer_code", t2_tf_search.getText());
				// 구매처명	
			}else if(t2_cb.getValue() == ComboList.buyerCombo().get(2)) {
				searchBuyer.put("buyer_name", t2_tf_search.getText());
				// 대표
			}else if(t2_cb.getValue() == ComboList.buyerCombo().get(3)) {
				searchBuyer.put("buyer_rep", t2_tf_search.getText());
			}
			// 쿼리
			listData_buyer =  FXCollections.observableArrayList(service.searchBuyers(searchBuyer));

			// 검색 결과가 없을 때
			if(listData_buyer.isEmpty()) {
				t2_tv.setItems(null);
				return;
				// 검색 결과를 tableView에 출력하기
			}else {
				showBuyerList_t2(listData_buyer);
			}
		}
	}

	@FXML
	void initialize() {
		assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_tf_search != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_btn_add != null : "fx:id=\"t1_btn_add\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_col_chkbox != null : "fx:id=\"t1_col_chkbox\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t1_col_name != null : "fx:id=\"t1_col__name\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_cb != null : "fx:id=\"t2_cb\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_tf_search != null : "fx:id=\"t2_tf\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_btn_search != null : "fx:id=\"t2_btn_search\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_btn_add != null : "fx:id=\"t2_btn_add\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_btn_delete != null : "fx:id=\"t2_btn_delete\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_tv != null : "fx:id=\"t2_tv\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_col_chkbox != null : "fx:id=\"t2_col_chkbox\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_col_code != null : "fx:id=\"t2_col_code\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_col_name != null : "fx:id=\"t2_col_name\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_col_rep != null : "fx:id=\"t2_col_rep\" was not injected: check your FXML file 'Sys_def.fxml'.";
		assert t2_col_addr != null : "fx:id=\"t2_col_addr\" was not injected: check your FXML file 'Sys_def.fxml'.";

		//품목(자재) 검색용 콤보박스
		t1_cb.getItems().addAll(ComboList.materialCateCombo());
		t1_cb.getSelectionModel().selectFirst();
		//구매처 검색용 콤보박스
		t2_cb.getItems().addAll(ComboList.buyerCombo());
		t2_cb.getSelectionModel().selectFirst();

		
		//MaterialCate t1 목록 뿌리기
		showMaterialCateList_t1(FXCollections.observableArrayList(service.allMaterialCatesList()));

		//Buyer t2 목록 뿌리기
		showBuyerList_t2(FXCollections.observableArrayList(service.allBuyersList()));

	}

	/**
	 *@Method Name : showMaterialCateList_t1
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 자재 코드 목록 띄우는 메서드
	 */
	public void showMaterialCateList_t1(ObservableList<MaterialCateVo> listData_matc) {
		t1_tv.setItems(listData_matc);

		t1_col_chkbox.setCellValueFactory(new PropertyValueFactory<MaterialCateVo, Boolean>("matc_chkbox"));
		t1_col_code.setCellValueFactory(new PropertyValueFactory<MaterialCateVo, String>("matc_code"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<MaterialCateVo, String>("matc_name"));
	}

	/**
	 *@Method Name : showBuyerList_t2
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 구매처 코드 목록 띄우는 메서드
	 */
	public void showBuyerList_t2(ObservableList<BuyerVo> listData_buyer) {
		t2_tv.setItems(listData_buyer);

		t2_col_chkbox.setCellValueFactory(new PropertyValueFactory<BuyerVo, Boolean>("buyer_chkbox"));
		t2_col_code.setCellValueFactory(new PropertyValueFactory<BuyerVo, String>("buyer_code"));
		t2_col_name.setCellValueFactory(new PropertyValueFactory<BuyerVo, String>("buyer_name"));
		t2_col_rep.setCellValueFactory(new PropertyValueFactory<BuyerVo, String>("buyer_rep"));
		t2_col_addr.setCellValueFactory(new PropertyValueFactory<BuyerVo, String>("buyer_addr"));
	}

}
