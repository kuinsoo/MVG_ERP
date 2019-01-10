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
import javafx.stage.Stage;
import javafx.util.Callback;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.DefectiveProductVo;
import production.vo.ProductionVo;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;

public class DefectiveSubmitController {
	private IProductionService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private ComboBox<ProductionVo> cb_prodName;

    @FXML
    private TextArea ta_defectReason;

    @FXML
    void insert(ActionEvent event) {
    	try {
    		DefectiveProductVo defectVO = new DefectiveProductVo();
    		defectVO.setDprod_code(Codemaker.defective_code());
    		defectVO.setDprod_qual(cb_prodName.getSelectionModel().getSelectedItem().getProd_code());
    		defectVO.setDprod_reason(ta_defectReason.getText());
    		
    		int cnt = service.insertDefective(defectVO);
    		
    		if(cnt > 0) {
    			AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
    		}else {
    			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
    		}
    		
    		Stage stage = (Stage) btnInsert.getScene().getWindow();
    		stage.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) bntCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'DefectiveSubmit.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'DefectiveSubmit.fxml'.";
        assert cb_prodName != null : "fx:id=\"cb_prodName\" was not injected: check your FXML file 'DefectiveSubmit.fxml'.";
        assert ta_defectReason != null : "fx:id=\"ta_defectReason\" was not injected: check your FXML file 'DefectiveSubmit.fxml'.";
        
        service = ProductionService.getInstance();
       
    }
    
    public void defectiveList(List<ProductionVo> prodVO) {
    	ObservableList<ProductionVo> obProd = FXCollections.observableArrayList(prodVO);
    	cb_prodName.setItems(obProd);
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
}
