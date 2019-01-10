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
import production.vo.QualityInspectionVO;
import production.vo.QualityVo;
import staticMethod.alert.AlertWindow;

public class QualityUpdateController {
	IProductionService service; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cb_qualLevel;

    @FXML
    private DatePicker td_qualDate;
    
    @FXML
    private ComboBox<EmployeeVo> cb_qualWriter;

    @FXML
    private TextField tf_qualName;

    @FXML
    private TextField tf_qualCode;

    @FXML
    private Button bntCancel;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tf_qualWriter;
    
    @FXML
    private TextField tf_qualProdDate;


 
    @FXML
    void click_update(ActionEvent event) {
    	QualityVo qualityVo = new QualityVo();
    	
    	qualityVo.setQual_code(tf_qualCode.getText());
    	qualityVo.setQual_date(td_qualDate.getValue().toString());
    	qualityVo.setQual_level(cb_qualLevel.getSelectionModel().getSelectedItem());
    	
    	if(cb_qualWriter.getSelectionModel().getSelectedItem() == null) {
    	}else {
    		qualityVo.setQual_write(cb_qualWriter.getSelectionModel().getSelectedItem().getEmp_name());
    	}
    	int cnt = service.updateQuality(qualityVo);
    	
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
        assert cb_qualLevel != null : "fx:id=\"cb_qualLevel\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert td_qualDate != null : "fx:id=\"td_qualDate\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert tf_qualName != null : "fx:id=\"tf_qualName\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert tf_qualCode != null : "fx:id=\"tf_qualCode\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert bntCancel != null : "fx:id=\"bntCancel\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert tf_qualWriter != null : "fx:id=\"tf_qualWriter\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        assert tf_qualProdDate != null : "fx:id=\"tf_qualProdDate\" was not injected: check your FXML file 'QualityUpdate.fxml'.";
        
        service = ProductionService.getInstance();
        cb_qualLevel.getItems().addAll("1", "2", "3", "4","5");
        
   		
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
        
        List<EmployeeVo> empList = service.selectEmployee();
		ObservableList<EmployeeVo> obEmpList = FXCollections.observableArrayList(empList);
		cb_qualWriter.setItems(obEmpList);
		
		cb_qualWriter.setCellFactory(
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
		cb_qualWriter.setButtonCell(
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
    
    public void updateQuality(QualityInspectionVO qualVo) {
    	
    	int year = Integer.parseInt(qualVo.getQual_date().substring(0,4));
    	int month = Integer.parseInt(qualVo.getQual_date().substring(5, 7));
    	int day = Integer.parseInt(qualVo.getQual_date().substring(8, 10));
    	LocalDate currentTime = LocalDate.now();
    	LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
    	
    	
    	tf_qualCode.setText(qualVo.getProd_code());
    	tf_qualName.setText(qualVo.getProd_name());
    	tf_qualProdDate.setText(qualVo.getProd_date());
    	td_qualDate.setValue(targetTime);
    	cb_qualLevel.setValue(qualVo.getQual_level());
    	cb_qualWriter.setPromptText(qualVo.getQual_write());
    	
    	
    	
    	
    }
}
