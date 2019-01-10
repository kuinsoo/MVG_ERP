package production.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.ProductionVo;
import production.vo.SaleVO;
import staticMethod.alert.AlertWindow;

public class SalesUpdateController {

	private IProductionService service = ProductionService.getInstance();
	
	private Stage thisStage;
	
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
    private ComboBox<String> cb_prodName;


    @FXML
    void insert(ActionEvent event) {
    	ProductionVo prodVO = service.selectProdQty(tf_prodCode.getText());
    	System.out.println(tf_prodCode.getText());
    	System.out.println(tf_qty.getText());
    	System.out.println(prodVO.getProd_qty());
    	SaleVO saleVO = new SaleVO();
    	saleVO.setProd_code(tf_prodCode.getText());
    	if(cb_prodName.getSelectionModel().getSelectedItem() == null) {
    		
    	}else {
    		saleVO.setProd_name(cb_prodName.getSelectionModel().getSelectedItem());
    	}
    	
    	saleVO.setProd_qty(Integer.parseInt(tf_qty.getText()));
    	saleVO.setProd_sale(Integer.parseInt(tf_sale.getText()));
    	saleVO.setSale_price(saleVO.getProd_qty()* saleVO.getProd_sale());
    	saleVO.setSale_date(td_date.getValue().toString());
    	
    	if(Integer.parseInt(tf_qty.getText()) > prodVO.getProd_qty()) {
    		AlertWindow.errorAlert("에러", "생산수량을 초과하였습니다. 다시 입력해주세요");
    	}else {
    		int cnt = service.updateSales(saleVO);
    		
    		if(cnt > 0) {
    			AlertWindow.SucceedAlert(thisStage);
    			Stage stage = (Stage) btnInsert.getScene().getWindow();
    			stage.close();
    		}else {
    			AlertWindow.errorAlert("에러", "수정 실패되었습니다.");
    		}
    	}
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) bntCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert tf_sale != null : "fx:id=\"tf_sale\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        assert tf_qty != null : "fx:id=\"tf_qty\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        assert td_date != null : "fx:id=\"td_date\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        assert tf_prodCode != null : "fx:id=\"tf_prodCode\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        assert cb_prodName != null : "fx:id=\"cb_prodName\" was not injected: check your FXML file 'SaleUpdate.fxml'.";
        
    }
    
    public void updateSale(SaleVO saleVO) {
    	tf_prodCode.setText(saleVO.getProd_code());
    	cb_prodName.setPromptText(saleVO.getProd_name());
    	tf_qty.setText(Integer.toString(saleVO.getProd_qty()));
    	tf_sale.setText(Integer.toString(saleVO.getProd_sale()));
    	int year = Integer.parseInt(saleVO.getSale_date().substring(0, 4));
    	int month = Integer.parseInt(saleVO.getSale_date().substring(5, 7));
    	int day = Integer.parseInt(saleVO.getSale_date().substring(8, 10));
    	LocalDate currentTime = LocalDate.now();
    	LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
    	td_date.setValue(targetTime);
    }
    
}
