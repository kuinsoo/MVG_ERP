package production.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.ProductionJournalVO;
import production.vo.ProductionStockVO;
import staticMethod.alert.AlertWindow;


/**
 * 생산관리부 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class DeptDef_prodController {
	
	private IProductionService service;
	Parent rooty;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private DatePicker t1_td_date;

	@FXML
	private TableColumn<ProductionStockVO, String> t1_matCodeCol;

	@FXML
	private TableColumn<ProductionJournalVO , Boolean> t2_chkCol;

	@FXML
	private TableColumn<ProductionStockVO , Boolean> t1_chkCol;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private TableColumn<ProductionStockVO, String> t1_astDateCol;

	@FXML
	private TableColumn<ProductionStockVO, Integer> t1_astQtyCol;

	@FXML
	private TableColumn<ProductionStockVO, Integer> t1_upriceCol;

	@FXML
	private TextField t1_tf;

	@FXML
	private TableColumn<ProductionJournalVO, Integer> t2_prodSaleCol;

	@FXML
	private TableView<ProductionJournalVO> table2;

	@FXML
	private TableView<ProductionStockVO> table1;

	@FXML
	private ComboBox<String> t1_cb;

	@FXML
	private TableColumn<ProductionStockVO, String> t1_mectNameCol;

	@FXML
	private TableColumn<ProductionJournalVO, String> t2_prodNameCol;

	@FXML
	private Button t2_btn_submit;

	@FXML
	private Button t1_btn_search;

	@FXML
	private TableColumn<ProductionStockVO, String> t1_astNameCol;

	@FXML
	private TableColumn<ProductionJournalVO, String> t2_writerCol;

	@FXML
	private TextField t2_tf;

	@FXML
	private Button t2_btn_delete;

	@FXML
	private TableColumn<ProductionJournalVO, Integer> t2_prodQtyCol;

	@FXML
	private Button t1_btn_submit;

	@FXML
	private Button t2_btn_search;

	@FXML
	private TableColumn<ProductionJournalVO, String> t2_prodCodeCol;

	@FXML
	private ComboBox<String> t2_cb;

	@FXML
	private TableColumn<ProductionJournalVO, String> t2_prodDateCol;

	@FXML
	private Tab t1;

	@FXML
	private Tab t2;


	@FXML
	private DatePicker t2_td_date;




	@FXML
	void t1_click_search(ActionEvent event) {

		if(t1_cb.getSelectionModel().getSelectedItem() == null || t1_tf.getText() == null) {
			List<ProductionStockVO> stockList = service.getAllProduction();
			ObservableList<ProductionStockVO> obStockList = FXCollections.observableArrayList(stockList);
			table1.setItems(obStockList);

		}else {
			if(t1_cb.getSelectionModel().getSelectedItem().equals("분류명")) {
				//분류 코드명 검색
				List<ProductionStockVO> prodStockList = service.selectStockCodeList(t1_tf.getText());
				ObservableList<ProductionStockVO> obProdStockList = FXCollections.observableArrayList(prodStockList);
				table1.setItems(obProdStockList);
			}else if (t1_cb.getSelectionModel().getSelectedItem().equals("날짜")) {
				// 날짜 별(ast_date) 리스트 검색
				if(t1_td_date.getValue() == null) {
					List<ProductionStockVO> stockList = service.getAllProduction();
					ObservableList<ProductionStockVO> obStockList = FXCollections.observableArrayList(stockList);
					table1.setItems(obStockList);
				}else {
					List<ProductionStockVO> prodStockList = service.selectStockDateList(t1_td_date.getValue().toString());
					ObservableList<ProductionStockVO> obProdStockList = FXCollections.observableArrayList(prodStockList);
					table1.setItems(obProdStockList);
				}

			}else if(t1_cb.getSelectionModel().getSelectedItem().equals("품목명")){
				// 품목명 별(ast_name) 리스트 검색
				List<ProductionStockVO> prodStockList = service.selectStockNameList(t1_tf.getText());
				ObservableList<ProductionStockVO> obProdStockList = FXCollections.observableArrayList(prodStockList);
				table1.setItems(obProdStockList);
			}
		}
	}

	@FXML
	void t1_click_submit(ActionEvent event) {

		try {

			Stage stage = new Stage();
			rooty = FXMLLoader.load(getClass().getResource("../../production/fxml/ProductionSumbit.fxml"));

			//					BorderPane root = (BorderPane)exit.getScene().getRoot();
			Scene scene = new Scene(rooty);
			//			root.getChildren().clear();
			//			root.getChildren().add(rooty);

			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();



		}catch (IOException e) {
			System.out.println("DeptDef_controller ==> ProductionSubmit => " + e);
		}

	}

	@FXML
	void search2(ActionEvent event) {
		if(t2_cb.getSelectionModel().getSelectedItem() == null ) {
			List<ProductionJournalVO> journalList = service.getProductionJournal();
			ObservableList<ProductionJournalVO> obJournalList = FXCollections.observableArrayList(journalList);
			table2.setItems(obJournalList);
		}else {
			if(t2_tf.getText()== null) {
				List<ProductionJournalVO> journalList = service.getProductionJournal();
				ObservableList<ProductionJournalVO> obJournalList = FXCollections.observableArrayList(journalList);
				table2.setItems(obJournalList);
			}
			if(t2_cb.getSelectionModel().getSelectedItem().equals("상품명")) {
				//분류 코드명 검색
				List<ProductionJournalVO> prodJournalList = service.selectJournalCodeList(t2_tf.getText());
				ObservableList<ProductionJournalVO> obprodJournalList = FXCollections.observableArrayList(prodJournalList);
				table2.setItems(obprodJournalList);
			} else if (t2_cb.getSelectionModel().getSelectedItem().equals("날짜")) {
				if(t2_td_date.getValue() == null) {
					List<ProductionJournalVO> journalList = service.getProductionJournal();
					ObservableList<ProductionJournalVO> obJournalList = FXCollections.observableArrayList(journalList);
					table2.setItems(obJournalList);
				}else {
					// 날짜 별(ast_date) 리스트 검색
					List<ProductionJournalVO> prodJournalList = service.selectJournalDateList(t2_td_date.getValue().toString());
					ObservableList<ProductionJournalVO> obProdJournalList = FXCollections.observableArrayList(prodJournalList);
					table2.setItems(obProdJournalList);
				}

			}
		}
	}

	@FXML
	void submit2(ActionEvent event) {
		try {

			Stage stage = new Stage();
			rooty = FXMLLoader.load(getClass().getResource("../../production/fxml/ProdJournalSubmit.fxml"));

			//					BorderPane root = (BorderPane)exit.getScene().getRoot();
			Scene scene = new Scene(rooty);
			//			root.getChildren().clear();
			//			root.getChildren().add(rooty);

			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();

			List<ProductionJournalVO> journalList = service.getProductionJournal();
			ObservableList<ProductionJournalVO> obJournalList = FXCollections.observableArrayList(journalList);
			table2.setItems(obJournalList);


		}catch (IOException e) {
			//			System.out.println("DeptDef_controller ==> ProdJournalSubmit => " + e);
			e.printStackTrace();
		}


	}

	@FXML
	void delete2(ActionEvent event) {
		List<ProductionJournalVO> prodJournalVO = service.getProductionJournal();
		List<String> tempList = new ArrayList<>();
		prodJournalVO  = table2.getItems();

		int cnt = 0;

		for(ProductionJournalVO journalVO : prodJournalVO) {
			if(journalVO.getCheckBox().isSelected()) {
				tempList.add(journalVO.getProd_code());
			}
		}

		if(tempList.size() <= 0 ) {
			AlertWindow.errorAlert("에러", "삭제할 항목이 존재하지않습니다.");
		}else {
			cnt = service.deleteProdJournal(tempList);

			if(cnt > 0) {
				AlertWindow.SucceedAlert((Stage)t2_btn_delete.getScene().getWindow());
			}else {
				AlertWindow.FailedAlert((Stage)t2_btn_delete.getScene().getWindow());
			}

			List<ProductionJournalVO> journalList = service.getProductionJournal();
			ObservableList<ProductionJournalVO> obJournalList = FXCollections.observableArrayList(journalList);
			table2.setItems(obJournalList);
		}


	}




	@FXML
	void initialize() {
		assert t1_matCodeCol != null : "fx:id=\"t1_matCodeCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_astDateCol != null : "fx:id=\"t1_astDateCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_astQtyCol != null : "fx:id=\"t1_astQtyCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_upriceCol != null : "fx:id=\"t1_upriceCol\" was not injected: check your FXML file 'DeptDef_prod2.fxml'.";
		assert t1_tf != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_prodSaleCol != null : "fx:id=\"t2_prodSaleCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert table2 != null : "fx:id=\"table2\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert table1 != null : "fx:id=\"table1\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_mectNameCol != null : "fx:id=\"t1_mectNameCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_prodNameCol != null : "fx:id=\"t2_prodNameCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_btn_submit != null : "fx:id=\"t2_btn_submit\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_astNameCol != null : "fx:id=\"t1_astNameCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_writerCol != null : "fx:id=\"t2_writerCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_tf != null : "fx:id=\"t2_tf\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_btn_delete != null : "fx:id=\"t2_btn_delete\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_prodQtyCol != null : "fx:id=\"t2_prodQtyCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1_btn_submit != null : "fx:id=\"t1_btn_submit\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_btn_search != null : "fx:id=\"t2_btn_search\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_prodCodeCol != null : "fx:id=\"t2_prodCodeCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_cb != null : "fx:id=\"t2_cb\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_prodDateCol != null : "fx:id=\"t2_prodDateCol\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2 != null : "fx:id=\"t2\" was not injected: check your FXML file 'DeptDef_prod.fxml'.";
		assert t2_chkCol != null : "fx:id=\"t2_chkCol\" was not injected: check your FXML file 'DeptDef_prod2.fxml'.";
		assert t1_chkCol != null : "fx:id=\"t1_chkCol\" was not injected: check your FXML file 'DeptDef_prod2.fxml'.";
		assert t1_td_date != null : "fx:id=\"t1_td_date\" was not injected: check your FXML file 'DeptDef_prod2.fxml'.";
		assert t2_td_date != null : "fx:id=\"t2_td_date\" was not injected: check your FXML file 'DeptDef_prod2.fxml'.";


		//검색용 콤보박스 종류별
		t1_cb.getItems().addAll("분류명", "날짜", "품목명");
		t2_cb.getItems().addAll("상품명","날짜");

		//serivce 객체 생성
		service = ProductionService.getInstance();


		// 리스트 출력
		productionStockList();

		//콤보박스에서 날짜 별 검색시 TextField가 아닌 DatePicker 가 나타난다.
		t1_cb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(t1_cb.getSelectionModel().getSelectedItem().equals("날짜")) {
					t1_td_date.setVisible(true);
				}else {
					t1_td_date.setVisible(false);
				}
			}
		});

		//콤보박스에서 날짜 별 검색시 TextField가 아닌 DatePicker 가 나타난다.
		t2_cb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(t2_cb.getSelectionModel().getSelectedItem().equals("날짜")) {
					t2_td_date.setVisible(true);
				}else {
					t2_td_date.setVisible(false);
				}
			}
		});

		// 생산일지 수정폼 띄우기
		updateProdJournal();
	}


	public void productionStockList() {
		List<ProductionStockVO> stockList = service.getAllProduction();
		List<ProductionJournalVO> journalList = service.getProductionJournal();
		ObservableList<ProductionStockVO> obStockList = FXCollections.observableArrayList(stockList);
		ObservableList<ProductionJournalVO> obJournalList = FXCollections.observableArrayList(journalList);
		table1.setItems(obStockList);
		table2.setItems(obJournalList);

		//		t1_astNoCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, String>("ast_no"));
		t1_mectNameCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, String>("ast_no"));
		t1_matCodeCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, String>("matc_name"));
		t1_astNameCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, String>("ast_name"));
		t1_astDateCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, String>("ast_date"));
		t1_astQtyCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, Integer>("ast_qty"));
		t1_upriceCol.setCellValueFactory(new PropertyValueFactory<ProductionStockVO, Integer>("mat_uprice"));


		t2_chkCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, Boolean>("checkBox"));
		t2_prodCodeCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, String>("prod_code"));
		t2_prodNameCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, String>("prod_name"));
		t2_prodDateCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, String>("prod_date"));
		t2_prodQtyCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, Integer>("prod_qty"));
		t2_prodSaleCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, Integer>("prod_sale"));
		t2_writerCol.setCellValueFactory(new PropertyValueFactory<ProductionJournalVO, String>("prod_writer"));

	}

	public void updateProdJournal() {
		table2.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(table2.getSelectionModel()==null) {

				}

				if(event.getClickCount() > 1) {
					if(table2.getSelectionModel()==null) {

					}

					try {
						Stage stage = new Stage();
						FXMLLoader loader  = new FXMLLoader(getClass().getResource("../../production/fxml/ProdJournalUpdate.fxml"));
						Parent root = loader.load();

						ProdJournalUpdateController update = loader.getController();

						ProductionJournalVO journalVO = table2.getSelectionModel().getSelectedItem();
						System.out.println(journalVO.getProd_code());

						//수정 폼 넘어감
						update.updateJournal(journalVO);


						Scene scene = new Scene(root);
						System.out.println(journalVO.getProd_date());
						stage.setScene(scene);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.showAndWait();

						List<ProductionJournalVO> journalList = service.getProductionJournal();
						ObservableList<ProductionJournalVO> obJournalList= FXCollections.observableArrayList(journalList);
						table2.setItems(obJournalList);


					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		});
	}
	

}
