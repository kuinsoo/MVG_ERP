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
import production.vo.ProductionJournalVO;
import production.vo.ProductionVo;
import staticMethod.alert.AlertWindow;

public class ProdJournalUpdateController {
	IProductionService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tf_prodQty;

    @FXML
    private TextField tf_prodName;

    @FXML
    private ComboBox<EmployeeVo> cb_empName;

    @FXML
    private TextField tf_prodPrice;

    @FXML
    private DatePicker td_prodDate;
    
    @FXML
    private TextField tf_prodCode;
    

    @FXML
    void insert(ActionEvent event) {
    	ProductionVo journalVO = new ProductionVo();
    	journalVO.setProd_code(tf_prodCode.getText());
    	journalVO.setProd_name(tf_prodName.getText());
    	journalVO.setProd_date(td_prodDate.getValue().toString());
    	journalVO.setProd_qty(Integer.parseInt(tf_prodQty.getText()));
    	journalVO.setProd_sale(Integer.parseInt(tf_prodPrice.getText()));
    	if(cb_empName.getSelectionModel().getSelectedItem() == null) {
    	}else {
    		journalVO.setProd_writer(cb_empName.getSelectionModel().getSelectedItem().getEmp_name());
    	}
    	
    	int cnt = service.updateProdJournal(journalVO);
    	
    	if(cnt > 0) {
    		AlertWindow.SucceedAlert((Stage)btnInsert.getScene().getWindow());
    		
        	Stage stage = (Stage) btnInsert.getScene().getWindow();
        	stage.close();
    	}else {
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
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert tf_prodQty != null : "fx:id=\"tf_prodQty\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert tf_prodName != null : "fx:id=\"tf_prodName\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert cb_empName != null : "fx:id=\"cb_empName\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert tf_prodPrice != null : "fx:id=\"tf_prodPrice\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert td_prodDate != null : "fx:id=\"td_prodDate\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        assert tf_prodCode != null : "fx:id=\"tf_prodCode\" was not injected: check your FXML file 'ProdJournalUpdate.fxml'.";
        
        service = ProductionService.getInstance();
  

        
        List<EmployeeVo> empVO = service.selectEmployee();
        ObservableList<EmployeeVo> empList = FXCollections.observableArrayList(empVO);
        cb_empName.setItems(empList);
        
        cb_empName.setCellFactory(
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
        cb_empName.setButtonCell(
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
    
    
    public void updateJournal(ProductionJournalVO journalVO) {
    	int year = Integer.parseInt(journalVO.getProd_date().substring(0, 4));
    	int month = Integer.parseInt(journalVO.getProd_date().substring(5, 7));
    	int day = Integer.parseInt(journalVO.getProd_date().substring(8, 10));
    	System.out.println(year);
    	LocalDate currentTime = LocalDate.now();
    	LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
    	tf_prodCode.setText(journalVO.getProd_code());
    	tf_prodName.setText(journalVO.getProd_name());
    	tf_prodPrice.setText(Integer.toString(journalVO.getProd_sale()));
    	tf_prodQty.setText(Integer.toString(journalVO.getProd_qty()));
    	td_prodDate.setValue(targetTime);
    	cb_empName.setPromptText(journalVO.getProd_writer());
    	
    }
}
