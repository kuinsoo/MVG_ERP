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
import production.vo.AssistantVO;
import production.vo.MachineVO;
import production.vo.ProductionVo;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;

public class ProdJournalSubmitController {
	
	IProductionService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<AssistantVO> cb_astNo;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tf_prodQty;

    @FXML
    private ComboBox<MachineVO> cb_machName;

    @FXML
    private TextField tf_prodName;

    @FXML
    private TextField tf_prodPrice;

    @FXML
    private DatePicker td_prodDate;

    @FXML
    private ComboBox<EmployeeVo> cb_prodWriter;

    @FXML
    void insert(ActionEvent event) {
    	try {
    		ProductionVo productionVo = new ProductionVo();
    		productionVo.setProd_code(Codemaker.prod_code());
    		productionVo.setProd_name(tf_prodName.getText());
    		productionVo.setProd_mach(cb_machName.getSelectionModel().getSelectedItem().getMach_code());
    		productionVo.setProd_date(td_prodDate.getValue().toString());
    		productionVo.setProd_ast(cb_astNo.getSelectionModel().getSelectedItem().getAst_no());
    		productionVo.setProd_qty(Integer.parseInt(tf_prodQty.getText()));
    		productionVo.setProd_sale(Integer.parseInt(tf_prodPrice.getText()));
    		productionVo.setProd_dept("mdp001");
    		productionVo.setProd_writer(cb_prodWriter.getSelectionModel().getSelectedItem().getEmp_name());
    		
    		int cnt = service.insertProduction(productionVo);
    		
    		if(cnt > 0) {
    			AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
    		}else {
    			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
    		}
		} catch (Exception e) {
			AlertWindow.FailedAlert((Stage)btnInsert.getScene().getWindow());
		}
    	Stage stage = (Stage) btnInsert.getScene().getWindow();
    	stage.close();
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) bntCancel.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void initialize() {
        assert cb_astNo != null : "fx:id=\"cb_astNo\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert tf_prodQty != null : "fx:id=\"tf_prodQty\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert cb_machName != null : "fx:id=\"cb_machName\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert tf_prodName != null : "fx:id=\"tf_prodName\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert tf_prodPrice != null : "fx:id=\"tf_prodPrice\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert td_prodDate != null : "fx:id=\"td_prodDate\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        assert cb_prodWriter != null : "fx:id=\"cb_prodWriter\" was not injected: check your FXML file 'ProdJournalSubmit.fxml'.";
        
        service = ProductionService.getInstance();
        
        List<AssistantVO> assistantList = service.selectAssistant();
        ObservableList<AssistantVO> obAssistant = FXCollections.observableArrayList(assistantList);
        
        cb_astNo.setItems(obAssistant);
        
        List<EmployeeVo> empList = service.selectEmployee();
        ObservableList<EmployeeVo> obEmpList = FXCollections.observableArrayList(empList);
        
        
        cb_prodWriter.setItems(obEmpList);
        
        List<MachineVO> machinList = service.selectMachineList();
        ObservableList<MachineVO> obMachineList = FXCollections.observableArrayList(machinList);
        
        cb_machName.setItems(obMachineList);
        
        		
        
        
        cb_astNo.setCellFactory(
    			new Callback<ListView<AssistantVO>, ListCell<AssistantVO>>() {
    				
    				@Override
    				public ListCell<AssistantVO> call(ListView<AssistantVO> param) {
    					
    					return new ListCell<AssistantVO>() {
    						protected void updateItem(AssistantVO item, boolean empty) {
    							super.updateItem(item, empty);
    							if(item==null || empty) {
    								setText(null);
    							}else {
    								setText(item.getAst_name());
    							}
    						}; 
    					};
    				}
    			}
    		);
    		
    		
    		// 콤보박스에서 항목을 선택하면 선택된 내용이 보여지는
    		// 부분을 버튼 영역이라 하는데
    		// 이 버튼 영역의 내용도 변경해 주어야 한다.
        cb_astNo.setButtonCell(
    			new ListCell<AssistantVO>() {
    				protected void updateItem(AssistantVO item, boolean empty) {
    					super.updateItem(item, empty);
    					if(empty) {
    						setText(null);
    					}else {
    						setText(item.getAst_name());
    					}
    				}; 
    			}
    		);

        
        cb_prodWriter.setCellFactory(
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
        cb_prodWriter.setButtonCell(
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
        
        
        cb_machName.setCellFactory(
    			new Callback<ListView<MachineVO>, ListCell<MachineVO>>() {
    				
    				@Override
    				public ListCell<MachineVO> call(ListView<MachineVO> param) {
    					
    					return new ListCell<MachineVO>() {
    						protected void updateItem(MachineVO item, boolean empty) {
    							super.updateItem(item, empty);
    							if(item==null || empty) {
    								setText(null);
    							}else {
    								setText(item.getMach_name());
    							}
    						}; 
    					};
    				}
    			}
    		);
    		
    		
    		// 콤보박스에서 항목을 선택하면 선택된 내용이 보여지는
    		// 부분을 버튼 영역이라 하는데
    		// 이 버튼 영역의 내용도 변경해 주어야 한다.
        cb_machName.setButtonCell(
    			new ListCell<MachineVO>() {
    				protected void updateItem(MachineVO item, boolean empty) {
    					super.updateItem(item, empty);
    					if(empty) {
    						setText(null);
    					}else {
    						setText(item.getMach_name());
    					}
    				}; 
    			}
    		);
    }
}
