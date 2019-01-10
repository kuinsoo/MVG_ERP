package production.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.DefectiveProductVo;
import production.vo.DefectiveVO;
import production.vo.ProductionVo;
import staticMethod.alert.AlertWindow;

public class DefectiveUpdateController {
	IProductionService service;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf_qualCode;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tf_prodCode;

    @FXML
    private TextArea ta_defectReason;

    @FXML
    private ComboBox<ProductionVo> cb_prodName;

    @FXML
    void click_update(ActionEvent event) {
    	DefectiveProductVo dprodVO = new DefectiveProductVo();
    	
    	dprodVO.setDprod_code(tf_qualCode.getText());
    	if(cb_prodName.getSelectionModel().getSelectedItem() == null) {
    	}else {
    		dprodVO.setDprod_qual(cb_prodName.getSelectionModel().getSelectedItem().getProd_code());
    	}
    	dprodVO.setDprod_reason(ta_defectReason.getText());
    	
    	int cnt = service.updateDefective(dprodVO);
    	
    	if(cnt > 0) {
    		AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
    	
        	Stage stage = (Stage) btnInsert.getScene().getWindow();
        	stage.close();
    	}else {
    		AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
    	}
    }

    @FXML
    void click_cancle(ActionEvent event) {
    	Stage stage = (Stage) bntCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert tf_qualCode != null : "fx:id=\"tf_qualCode\" was not injected: check your FXML file 'DefectiveUpdate.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'DefectiveUpdate.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'DefectiveUpdate.fxml'.";
        assert tf_prodCode != null : "fx:id=\"tf_prodCode\" was not injected: check your FXML file 'DefectiveUpdate.fxml'.";
        assert ta_defectReason != null : "fx:id=\"ta_defectReason\" was not injected: check your FXML file 'DefectiveUpdate.fxml'.";
        assert cb_prodName != null : "fx:id=\"cb_prodName\" was not injected: check your FXML file 'DefectiveUpdate.fxml'.";
        
        service = ProductionService.getInstance();
        List<ProductionVo> prodVO = service.selectProd();
        ObservableList<ProductionVo> obProdList = FXCollections.observableArrayList(prodVO);
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

    }
    
    public void updateDefective(DefectiveVO defectiveVO) {
    	tf_prodCode.setText(defectiveVO.getProd_code());
    	tf_qualCode.setText(defectiveVO.getDprod_code());
    	cb_prodName.setPromptText(defectiveVO.getProd_name());
    	ta_defectReason.setText(defectiveVO.getDprod_reason());
    	
    }
    
    
}
