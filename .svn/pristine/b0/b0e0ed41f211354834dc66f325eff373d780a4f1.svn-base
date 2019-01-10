package production.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import humanResources.vo.EmployeeVo;
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
import production.vo.ProductionVo;
import production.vo.QualityVo;
import staticMethod.alert.AlertWindow;

public class QualitySubmitController {
	
	IProductionService service = ProductionService.getInstance();
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cb_qualLevel;

    @FXML
    private DatePicker td_qualDate;

    @FXML
    private Button bntCancel;

    @FXML
    private TextField tf_qualWriter;

    @FXML
    private Button btnInsert;

    @FXML
    private ComboBox<ProductionVo> cb_prodName;
    
    @FXML
    private ComboBox<EmployeeVo> cb_Writer;
    


 
    @FXML
    void insert(ActionEvent event) {
    	try {
    		QualityVo qualVO = new QualityVo();
    		
    		qualVO.setQual_code(cb_prodName.getSelectionModel().getSelectedItem().getProd_code());
    		qualVO.setQual_date(td_qualDate.getValue().toString());
    		qualVO.setQual_level(cb_qualLevel.getSelectionModel().getSelectedItem());
    		qualVO.setQual_write(cb_Writer.getSelectionModel().getSelectedItem().getEmp_name());
    		
    		int cnt = service.submiteQuality(qualVO);
    		
    		if(cnt > 0) {
    			AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
    		}else {
    			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
    		}
    		
    		Stage stage = (Stage) btnInsert.getScene().getWindow();
    		stage.close();
    		
			
		} catch (Exception e) {
			// TODO: handle exception
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
        assert cb_qualLevel != null : "fx:id=\"cb_qualLevel\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        assert td_qualDate != null : "fx:id=\"td_qualDate\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        assert tf_qualWriter != null : "fx:id=\"tf_qualWriter\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        assert cb_prodName != null : "fx:id=\"cb_prodName\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        assert cb_Writer != null : "fx:id=\"cb_Writer\" was not injected: check your FXML file 'QualitySubmit.fxml'.";
        
        cb_prodName.setPromptText("상품명을 선택하세요");
        cb_qualLevel.setPromptText("등급을 선택하세요");
        
        ObservableList<EmployeeVo> empList = FXCollections.observableArrayList(service.selectEmployee());
        cb_Writer.setItems(empList);
        
      cb_qualLevel.getItems().addAll("1","2","3","4","5");
      
        
        
        
        cb_Writer.setCellFactory(
        		new Callback<ListView<EmployeeVo>, ListCell<EmployeeVo>>() {
        			
        			@Override
        			public ListCell<EmployeeVo> call(ListView<EmployeeVo> param) {
        				
        				return new ListCell<EmployeeVo>() {
        					protected void updateItem(EmployeeVo item, boolean empty) {
        						super.updateItem(item, empty);
        						if(item==null || empty) {
        							setText(null);
        						}else {
        							setText(item.getEmp_name());
        						}
        					}; 
        				};
        			}
        		}
        		);
        
        
        // 콤보박스에서 항목을 선택하면 선택된 내용이 보여지는
        // 부분을 버튼 영역이라 하는데
        // 이 버튼 영역의 내용도 변경해 주어야 한다.
        cb_Writer.setButtonCell(
        		new ListCell<EmployeeVo>() {
        			protected void updateItem(EmployeeVo item, boolean empty) {
        				super.updateItem(item, empty);
        				if(empty) {
        					setText(null);
        				}else {
        					setText(item.getEmp_name());
        				}
        			}; 
        		}
        		);
        
        // 콤보박스에서 항목을 선택하면 선택된 내용이 보여지는
        // 부분을 버튼 영역이라 하는데
        // 이 버튼 영역의 내용도 변경해 주어야 한다.
        cb_qualLevel.setButtonCell(
        		new ListCell<String>() {
        			protected void updateItem(String item, boolean empty) {
        				super.updateItem(item, empty);
        				if(empty) {
        					setText(null);
        				}else {
        					setText(item + "등급");
        				}
        			}; 
        		}
        		);

    }
    
    public void submitQuality(List<ProductionVo> prodList) {
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


