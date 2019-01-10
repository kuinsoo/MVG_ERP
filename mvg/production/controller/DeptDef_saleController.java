package production.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.ProductionVo;
import production.vo.SaleVO;
import staticMethod.alert.AlertWindow;

/**
 * 생산관리부 매출관리
 * @author Sohyoung
 * @since 2018.09.09
 */
public class DeptDef_saleController {

	IProductionService service;
	Parent rooty;
	@FXML
	private TableColumn<SaleVO, String> t1_prodNameCol;

	@FXML
	private TableView<SaleVO> table1;

	@FXML
	private DatePicker td_date;

	@FXML
	private TableColumn<SaleVO, String> t1_prodCodeCol;

	@FXML
	private TableColumn<SaleVO, Integer> t1_prodPriceCol;

	@FXML
	private TableColumn<SaleVO, Boolean> t1_checkCol;

	@FXML
	private Button btnSearch1;

	@FXML
	private TableColumn<SaleVO, Integer> t1_prodSaleQty;

	@FXML
	private ComboBox<String> classification1;

	@FXML
	private TableColumn<SaleVO, String> t1_saleWriter;

	@FXML
	private Button btnSubmit1;

	@FXML
	private Button btnDelete1;

	@FXML
	private TextField tfSearchBox1;

	@FXML
	private TableColumn<SaleVO, Integer> t1_prodSalePriceCol;


	@FXML
	void search1(ActionEvent event) {
		if(classification1.getSelectionModel().getSelectedItem() == null) {
			List<SaleVO> saleList = service.selectSale();
			ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
			table1.setItems(obSaleList);
		}else {
			if(tfSearchBox1.getText() == null) {
				List<SaleVO> saleList = service.selectSale();
				ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
				table1.setItems(obSaleList);
			}
			if(classification1.getSelectionModel().getSelectedItem().equals("상품명")) {
				List<SaleVO> saleVO = service.selectProdNameSales(tfSearchBox1.getText());
				ObservableList<SaleVO> obSaleVO = FXCollections.observableArrayList(saleVO);
				table1.setItems(obSaleVO);

			}else if(classification1.getSelectionModel().getSelectedItem().equals("날짜별")) {
				if(td_date.getValue() == null) {
					List<SaleVO> saleList = service.selectSale();
					ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
					table1.setItems(obSaleList);
				}else {
					List<SaleVO> saleVO = service.selectprodDateSales(td_date.getValue().toString());
					ObservableList<SaleVO> obSaleVO = FXCollections.observableArrayList(saleVO);
					table1.setItems(obSaleVO);
				}
			}

		}

	}

	@FXML
	void submit1(ActionEvent event) {
		try {
			
			List<ProductionVo> prodList = service.selectProdLevel();
			List<ProductionVo> prodTempList = new ArrayList<>();
			boolean check = false;
			
			List<SaleVO> obSaleVOs = table1.getItems();
			for(int i=0; i<prodList.size(); i++) {
				check = false;
				for(int j=0; j<obSaleVOs.size(); j++) {
					if(prodList.get(i).getProd_code().equals(obSaleVOs.get(j).getProd_code())) {
						check = true;
					}
				}
				if(!check) {
					prodTempList.add(prodList.get(i));
				}
			}
			
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../production/fxml/SaleSubmit.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			SaleSubmitController submitController = loader.getController();
			submitController.submitSale(prodTempList);

			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();

			List<SaleVO> saleList = service.selectSale();
			ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
			table1.setItems(obSaleList);


		}catch (IOException e) {
			//			System.out.println(" DeptDef_equipController MachineSubmit2 => " + e);
			e.printStackTrace();
		}

	}

	@FXML
	void delete1(ActionEvent event) {
		List<SaleVO> saleVOs = service.selectSale();
		List<String> tempList = new ArrayList<>();
		saleVOs = table1.getItems();
		int cnt = 0;

		for(SaleVO saleVO : saleVOs) {
			if(saleVO.getCheckBox().isSelected()) {
				tempList.add(saleVO.getProd_code());
			}
		}

		if(tempList.size() <=0) {
			AlertWindow.FailedAlert((Stage)btnDelete1.getScene().getWindow());
		}else {
			cnt = service.deleteSales(tempList);

			if(cnt > 0) {
				AlertWindow.SucceedAlert((Stage)btnDelete1.getScene().getWindow());
			}else {
				AlertWindow.FailedAlert((Stage)btnDelete1.getScene().getWindow());
			}

			List<SaleVO> saleList = service.selectSale();
			ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
			table1.setItems(obSaleList);
		}

	}



	@FXML
	void initialize() {
		assert t1_prodNameCol != null : "fx:id=\"t1_prodNameCol\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert table1 != null : "fx:id=\"table1\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert t1_prodCodeCol != null : "fx:id=\"t1_prodCodeCol\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert t1_prodPriceCol != null : "fx:id=\"t1_prodPriceCol\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert btnSearch1 != null : "fx:id=\"btnSearch1\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert t1_prodSaleQty != null : "fx:id=\"t1_prodSaleQty\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert classification1 != null : "fx:id=\"classification1\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert t1_saleWriter != null : "fx:id=\"t1_saleWriter\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert btnSubmit1 != null : "fx:id=\"btnSubmit1\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert btnDelete1 != null : "fx:id=\"btnDelete1\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert tfSearchBox1 != null : "fx:id=\"tfSearchBox1\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert t1_prodSalePriceCol != null : "fx:id=\"t1_prodSalePriceCol\" was not injected: check your FXML file 'DeptDef_sale.fxml'.";
		assert t1_checkCol != null : "fx:id=\"t1_checkCol\" was not injected: check your FXML file 'DeptDef_sale2.fxml'.";
		assert td_date != null : "fx:id=\"td_date\" was not injected: check your FXML file 'DeptDef_sale2.fxml'.";


		service = ProductionService.getInstance();
		//검색용 콤보박스 종류별
		classification1.getItems().addAll("상품명", "날짜별");

		List<SaleVO> saleList = service.selectSale();
		ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
		table1.setItems(obSaleList);

		t1_checkCol.setCellValueFactory(new PropertyValueFactory<SaleVO, Boolean>("checkBox"));
		t1_prodCodeCol.setCellValueFactory(new PropertyValueFactory<SaleVO, String>("prod_code"));
		t1_prodNameCol.setCellValueFactory(new PropertyValueFactory<SaleVO, String>("prod_name"));
		t1_prodPriceCol.setCellValueFactory(new PropertyValueFactory<SaleVO, Integer>("prod_sale"));
		t1_prodSalePriceCol.setCellValueFactory(new PropertyValueFactory<SaleVO, Integer>("sale_price"));
		t1_prodSaleQty.setCellValueFactory(new PropertyValueFactory<SaleVO, Integer>("prod_qty"));
		t1_saleWriter.setCellValueFactory(new PropertyValueFactory<SaleVO, String>("sale_date"));

		updateList();

		classification1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(classification1.getSelectionModel().getSelectedItem().equals("날짜별")) {
					td_date.setVisible(true);
				}else {
					td_date.setVisible(false);
				}
			}
		});
	}


	public void updateList() {
		table1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//수정 폼이 떠야되 기존 리스트에 있던 내용 띄워주고 각 코드들은 수정 못하게 Editable false로 막아주고
				// 나머지는 수정 사항 적으면  수정 버튼 눌렀을 때  수정해!!
				if(table1.getSelectionModel()==null) {

				}
				if(event.getClickCount() > 1) {

					try {

						Stage stage = new Stage();
						FXMLLoader loader  = new FXMLLoader(getClass().getResource("../../production/fxml/SaleUpdate.fxml"));
						Parent root = loader.load();

						SalesUpdateController update = loader.getController();


						SaleVO saleVO = table1.getSelectionModel().getSelectedItem();
						update.updateSale(saleVO);


						//					BorderPane root = (BorderPane)exit.getScene().getRoot();
						Scene scene = new Scene(root);
						//			root.getChildren().clear();
						//			root.getChildren().add(rooty);

						stage.setScene(scene);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.showAndWait();

						List<SaleVO> saleList = service.selectSale();
						ObservableList<SaleVO> obSaleList = FXCollections.observableArrayList(saleList);
						table1.setItems(obSaleList);


					}catch (IOException e) {
						//			System.out.println(" DeptDef_equipController MachineSubmit2 => " + e);
						e.printStackTrace();
					}
				}

			}
		});
	}

	/** 
	 *@Method Name : infoAlert
	 *@date : 2018. 9. 10.
	 *@author : Sohyoung
	 *@Method 설명 : 인포메이션 알람
	 *@param header
	 *@param msg
	 */
	public void infoAlert(String header, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("INFORMATION");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	/**
	 *@Method Name : errorAlert
	 *@date : 2018. 9. 10.
	 *@author : Sohyoung
	 *@Method 설명 : 에러 알람
	 *@param header
	 *@param msg
	 */
	public void errorAlert(String header, String msg) {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("ERROR");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}


}
