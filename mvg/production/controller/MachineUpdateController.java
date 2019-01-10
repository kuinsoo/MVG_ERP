package production.controller;

import java.net.URL;
import java.time.LocalDate;
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
import production.vo.BuyerVO;
import production.vo.MachineVO;
import production.vo.ProductionMachineVO;
import staticMethod.alert.AlertWindow;

public class MachineUpdateController {

	IProductionService service ;
	ProductionMachineVO machVo;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ComboBox<EmployeeVo> cb_machWriter;

    @FXML
    private TextField tf_machManager;

    @FXML
    private TextField tf_machName;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private DatePicker td_machDate;

    @FXML
    private TextField tf_machCode;

    @FXML
    private TextField tf_machQty;

    @FXML
    private ComboBox<BuyerVO> cb_buyerName;
    
    

    @FXML
    void click_update(ActionEvent event) {
    	MachineVO machVO = new  MachineVO();
    	machVO.setMach_code(tf_machCode.getText());
    	machVO.setMach_name(tf_machName.getText());
    	machVO.setMach_qty(Integer.parseInt(tf_machQty.getText()));
    	machVO.setMach_date(td_machDate.getValue().toString());
    	if(cb_machWriter.getSelectionModel().getSelectedItem()==null) {
    		
    	}else {
    		machVO.setMach_writer(cb_machWriter.getSelectionModel().getSelectedItem().getEmp_name());
    	}
    	System.out.println(cb_buyerName.getPromptText());
    	if(cb_buyerName.getSelectionModel().getSelectedItem() == null) {
    	
    	}else {
    		machVO.setMach_buyer(cb_buyerName.getSelectionModel().getSelectedItem().getBuyer_code());
    	}
    	

    	
    	
    	
    	
    	
    	
    	int cnt = service.updateMachine(machVO);
    	
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
    	Stage stage = (Stage) btnInsert.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {
        assert tf_machManager != null : "fx:id=\"tf_machManager\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert tf_machName != null : "fx:id=\"tf_machName\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert td_machDate != null : "fx:id=\"td_machDate\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert tf_machCode != null : "fx:id=\"tf_machCode\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert tf_machQty != null : "fx:id=\"tf_machQty\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert cb_buyerName != null : "fx:id=\"cb_buyerName\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        assert cb_machWriter != null : "fx:id=\"cb_machWriter\" was not injected: check your FXML file 'MahcineUpdate.fxml'.";
        
        
      
        service = ProductionService.getInstance();
        List<BuyerVO> buyerVOs = service.getBuyerList();
        ObservableList<BuyerVO> buyerList = FXCollections.observableArrayList(buyerVOs);
        System.out.println(buyerList);
        
        List<EmployeeVo> empVO = service.selectEmployee();
        ObservableList<EmployeeVo> empList = FXCollections.observableArrayList(empVO);
        
        cb_buyerName.setItems(buyerList);
        cb_machWriter.setItems(empList);
        
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
        
        
        cb_machWriter.setCellFactory(
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
        cb_machWriter.setButtonCell(
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

    }
    
    
    public void updateMahcine(ProductionMachineVO machVO) {
    	int year = Integer.parseInt(machVO.getMach_date().substring(0, 4));
    	int month = Integer.parseInt(machVO.getMach_date().substring(5, 7));
    	int day = Integer.parseInt(machVO.getMach_date().substring(8, 10));
    	LocalDate currentTime = LocalDate.now();
    	LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
    	 tf_machCode.setText(machVO.getMach_code());
    	 tf_machName.setText(machVO.getMach_name());
    	 tf_machQty.setText(Integer.toString(machVO.getMach_qty()));
    	 td_machDate.setValue(targetTime);
    	 cb_buyerName.setPromptText(machVO.getMach_buyer());
    	 cb_machWriter.setPromptText(machVO.getMach_writer());
    	
    }
}


