package outsourcing.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import outsourcing.service.IOutsourcingService;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.PlanningVo;
import staticMethod.alert.AlertWindow;

public class DeptOutSrcSalesController {
	
	private IOutsourcingService outsourcingService = OutsourcingService.getInstance();
	private ObservableList<PlanningVo> planningList = FXCollections.observableArrayList(outsourcingService.getAllPlanning());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab t1;

    @FXML
    private ComboBox<String> t1_cb;

    @FXML
    private TextField t1_tf_search;

    @FXML
    private Button t1_btn_search;

    @FXML
    private TableView<PlanningVo> t1_tv;

    @FXML
    private TableColumn<?, ?> t1_col_plan_no;

    @FXML
    private TableColumn<?, ?> t1_col_plan_title;

    @FXML
    private TableColumn<?, ?> t1_col_plan_date;

    @FXML
    private TableColumn<?, ?> t1_col_plan_note;

    @FXML
    private TableColumn<?, ?> t1_col_plan_name;

    @FXML
    void click_t1_btn_search(ActionEvent event) {
    	Map<String, String> planMap = new HashMap<String, String>();
    	if(t1_cb.getValue().toString().equals("기획명")) {
    		planMap.put("plan_title", t1_tf_search.getText());
    	}else if (t1_cb.getValue().toString().equals("거래처")) {
			planMap.put("acc_name", t1_tf_search.getText());
		}else if(t1_cb.getValue().toString().equals("작성자")) {
			planMap.put("plan_name", t1_tf_search.getText());
		}
    	List<PlanningVo> planList = outsourcingService.getPlanningList(planMap);
    	
    	if(planList.size() == 0) {
			AlertWindow.infoAlert("Failed", "결과 값이 존재하지 않습니다.");
		}else {
    	
		ObservableList<PlanningVo> ee = FXCollections.observableArrayList(planList);
		t1_tv.setItems(ee);
		
		}
    }

    @FXML
    void initialize() {
        assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_tf_search != null : "fx:id=\"t1_tf_search\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_col_plan_no != null : "fx:id=\"t1_col_plan_no\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_col_plan_title != null : "fx:id=\"t1_col_plan_title\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_col_plan_date != null : "fx:id=\"t1_col_plan_date\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_col_plan_note != null : "fx:id=\"t1_col_plan_note\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        assert t1_col_plan_name != null : "fx:id=\"t1_col_plan_name\" was not injected: check your FXML file 'DeptOutSrcSales.fxml'.";
        
        t1_cb.getItems().addAll("기획명", "거래처", "작성자");
        
        t1_cb.getSelectionModel().selectFirst(); // 처음값으로 셋팅해줌
        
        t1_tv.setItems(planningList);
		t1_col_plan_no.setCellValueFactory(new PropertyValueFactory<>("plan_no"));
		t1_col_plan_title.setCellValueFactory(new PropertyValueFactory<>("plan_title"));
		t1_col_plan_date.setCellValueFactory(new PropertyValueFactory<>("plan_date"));
		t1_col_plan_note.setCellValueFactory(new PropertyValueFactory<>("plan_note"));
		t1_col_plan_name.setCellValueFactory(new PropertyValueFactory<>("plan_name"));

    }
}
