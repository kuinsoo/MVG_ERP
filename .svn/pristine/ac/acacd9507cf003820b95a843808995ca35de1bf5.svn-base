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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.BuyerVO;
import production.vo.MachineVO;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;

public class MachineSubmitController {
	
	IProductionService service; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker machDate;

    @FXML
    private TextField tf_machName;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tf_machQty;

    @FXML
    private ComboBox<BuyerVO> cb_buyerName;

    @FXML
    void insert(ActionEvent event) {
    	try {
    		MachineVO machineVO  = new MachineVO();
    		
    		machineVO.setMach_code(Codemaker.mach_code());
    		machineVO.setMach_name(tf_machName.getText());
    		machineVO.setMach_buyer(cb_buyerName.getSelectionModel().getSelectedItem().getBuyer_code());
    		machineVO.setMach_date(machDate.getValue().toString());
    		machineVO.setMach_qty(Integer.parseInt(tf_machQty.getText()));
    		
    		
    		
    		int cnt = service.insertMahcine(machineVO);
    		
    		if(cnt > 0) {
    			AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
    		}else {
    			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
    		}
    		
    		tf_machName.clear();
    		tf_machQty.clear();
    		Stage stage = (Stage) btnInsert.getScene().getWindow();
    		stage.close();
			
		} catch (Exception e) {
			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
			
		}
    	
    	

    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnInsert.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert machDate != null : "fx:id=\"machDate\" was not injected: check your FXML file 'MachineSubmit2.fxml'.";
        assert tf_machName != null : "fx:id=\"tf_machName\" was not injected: check your FXML file 'MachineSubmit2.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'MachineSubmit2.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'MachineSubmit2.fxml'.";
        assert tf_machQty != null : "fx:id=\"tf_machQty\" was not injected: check your FXML file 'MachineSubmit2.fxml'.";
        assert cb_buyerName != null : "fx:id=\"cb_buyerName\" was not injected: check your FXML file 'MachineSubmit2.fxml'.";
        
        
        service = ProductionService.getInstance();
        List<BuyerVO> buyerVOs = service.getBuyerList();
        ObservableList<BuyerVO> buyerList = FXCollections.observableArrayList(buyerVOs);
        System.out.println(buyerList);
        
        cb_buyerName.setItems(buyerList);
//        System.out.println();
        
        cb_buyerName.setCellFactory(
    			new Callback<ListView<BuyerVO>, ListCell<BuyerVO>>() {
    				
    				@Override
    				public ListCell<BuyerVO> call(ListView<BuyerVO> param) {
    					
    					return new ListCell<BuyerVO>() {
    						protected void updateItem(BuyerVO item, boolean empty) {
    							super.updateItem(item, empty);
    							if(item==null || empty) {
    								setText(null);
    							}else {
    								setText(item.getBuyer_name());
    							}
    						}; 
    					};
    				}
    			}
    		);
    		
    		
    		// 콤보박스에서 항목을 선택하면 선택된 내용이 보여지는
    		// 부분을 버튼 영역이라 하는데
    		// 이 버튼 영역의 내용도 변경해 주어야 한다.
        cb_buyerName.setButtonCell(
    			new ListCell<BuyerVO>() {
    				protected void updateItem(BuyerVO item, boolean empty) {
    					super.updateItem(item, empty);
    					if(empty) {
    						setText(null);
    					}else {
    						setText(item.getBuyer_name());
    					}
    				}; 
    			}
    		);
    }
}
