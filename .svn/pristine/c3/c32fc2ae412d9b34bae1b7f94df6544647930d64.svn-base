package production.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.ProductionVo;
import production.vo.SaleVO;
import staticMethod.alert.AlertWindow;

public class SaleSubmitController {

	IProductionService service;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tf_sale;

	@FXML
	private TextField tf_qty;

	@FXML
	private Button bntCancel;

	@FXML
	private Button btnInsert;

	@FXML
	private DatePicker td_date;

	@FXML
	private TextField tf_prodCode;

	@FXML
	private ComboBox<ProductionVo> cb_prodName;

	List<ProductionVo> prodList = null;

	@FXML
	void insert(ActionEvent event) {
		try {
			SaleVO sale = new SaleVO();
			sale.setProd_name(cb_prodName.getSelectionModel().getSelectedItem().getProd_name());
			sale.setProd_code(tf_prodCode.getText());
			sale.setProd_qty(Integer.parseInt(tf_qty.getText()));
			//단가
			sale.setProd_sale(Integer.parseInt(tf_sale.getText()));
			sale.setSale_price(Integer.parseInt(tf_sale.getText()) * Integer.parseInt(tf_qty.getText()));
			sale.setSale_date(td_date.getValue().toString());
			if(Integer.parseInt(tf_qty.getText()) > cb_prodName.getSelectionModel().getSelectedItem().getProd_qty()) {
				AlertWindow.errorAlert("에러", "생산수량을 초과하였습니다. 다시 입력해주세요");
			}else {
				int cnt = service.insertSales(sale);
				
				if(cnt > 0) {
					AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
					
					Stage stage = (Stage) btnInsert.getScene().getWindow();
					stage.close();
				}else {
					AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
				}
			}

		} catch (Exception e) {
			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
		}

	}

	@FXML
	void cancel(ActionEvent event) {
		Stage stage = (Stage) bntCancel.getScene().getWindow();
		stage.close();
	}

	@FXML
	void initialize() {
		assert tf_sale != null : "fx:id=\"tf_sale\" was not injected: check your FXML file 'SaleSubmit.fxml'.";
		assert tf_qty != null : "fx:id=\"tf_qty\" was not injected: check your FXML file 'SaleSubmit.fxml'.";
		assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'SaleSubmit.fxml'.";
		assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'SaleSubmit.fxml'.";
		assert td_date != null : "fx:id=\"td_date\" was not injected: check your FXML file 'SaleSubmit.fxml'.";
		assert tf_prodCode != null : "fx:id=\"tf_prodCode\" was not injected: check your FXML file 'SaleSubmit.fxml'.";
		assert cb_prodName != null : "fx:id=\"cb_prodName\" was not injected: check your FXML file 'SaleSubmit.fxml'.";

		service = ProductionService.getInstance();

		prodList = service.selectProdLevel();
		ObservableList<ProductionVo> obProdList = FXCollections.observableArrayList(prodList);

		cb_prodName.setItems(obProdList);

		cb_prodName.setCellFactory(
				new Callback<ListView<ProductionVo>, ListCell<ProductionVo>>() {

					@Override
					public ListCell<ProductionVo> call(ListView<ProductionVo> param) {

						return new ListCell<ProductionVo>() {
							protected void updateItem(ProductionVo item, boolean empty) {
								super.updateItem(item, empty);
								if(item==null || empty) {
									setText(null);
								}else {
									setText(item.getProd_name());
								}
							}; 
						};
					}
				}
				);
	}

	public void submitSale(List<ProductionVo> prodVO ) {

		ObservableList<ProductionVo> obProdList = FXCollections.observableArrayList(prodVO);
		cb_prodName.setItems(obProdList);
		// 콤보박스에서 항목을 선택하면 선택된 내용이 보여지는
		// 부분을 버튼 영역이라 하는데
		// 이 버튼 영역의 내용도 변경해 주어야 한다.
		cb_prodName.setButtonCell(
				new ListCell<ProductionVo>() {
					protected void updateItem(ProductionVo item, boolean empty) {
						super.updateItem(item, empty);
						if(empty) {
							setText(null);
						}else {
							setText(item.getProd_name());
						}
					}; 
				}
				);

		cb_prodName.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tf_prodCode.setText(cb_prodName.getSelectionModel().getSelectedItem().getProd_code());
				tf_sale.setText(Integer.toString(cb_prodName.getSelectionModel().getSelectedItem().getProd_sale()));
			}
		});
	}
	
}
