package outsourcing.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import outsourcing.service.IOutsourcingService;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.PlanningVo;
import staticMethod.alert.AlertWindow;

public class DeptOutSrcListController {
	
	private IOutsourcingService outsourcingService = OutsourcingService.getInstance();
	private ObservableList<PlanningVo> planningList = FXCollections.observableArrayList(outsourcingService.getAllPlanning());
//	private List<PlanningVo> planList = outsourcingService.getAllPlanning();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane tp_root;

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
    private CheckBox t1_chk;
    
    @FXML
    private TableColumn<?, ?> t1_col_chk;

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
    private Button t1_btn_add;

    @FXML
    private Button t1_btn_delete;

    /**
     *@Method Name : click_t1_btn_add
     *@date : 2018. 9. 18.
     *@author : PDJ
     *@Method 설명 : 등록 버튼 이벤트
     *@param event
     */
    @FXML
    void click_t1_btn_add(ActionEvent event) {

    	try {
    		Stage deptOutSrcListStage = (Stage)t1_btn_add.getParent().getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/DeptOutScrListPopup.fxml"));
			Stage deptOutSrcListAddStage = new Stage();
			
			deptOutSrcListAddStage.initModality(Modality.WINDOW_MODAL);
			deptOutSrcListAddStage.initOwner(deptOutSrcListStage);
			Scene scene = new Scene(root);
			deptOutSrcListAddStage.setScene(scene);
			deptOutSrcListAddStage.initStyle(StageStyle.UNDECORATED);
			deptOutSrcListAddStage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	outsourcingService = OutsourcingService.getInstance();
		planningList = FXCollections.observableArrayList(outsourcingService.getAllPlanning());
		
		t1_tv.setItems(planningList);
    	
    }
    
    @FXML
    void click_t1_tv(MouseEvent event) {
    	PlanningVo planningVo =  null;
    	if(event.getClickCount() > 1) {

    		planningVo = t1_tv.getSelectionModel().getSelectedItem();
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/DeptOutSrcList_update.fxml"));
				Parent root = loader.load();
				DeptOutSrcList_updateController updateController = loader.getController();
				int year = Integer.parseInt(planningVo.getPlan_date().substring(0,4));
				int month = Integer.parseInt(planningVo.getPlan_date().substring(5,7));
				int day = Integer.parseInt(planningVo.getPlan_date().substring(8,10));
				LocalDate currentTime = LocalDate.now();
				LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
				System.out.println(targetTime.toString());
				updateController.getPlan(planningVo, targetTime);
				Stage deptOutSrcListUpdateStage = new Stage();
				deptOutSrcListUpdateStage.initModality(Modality.APPLICATION_MODAL);
				deptOutSrcListUpdateStage.initStyle(StageStyle.UNDECORATED);
				Scene scene = new Scene(root);
				deptOutSrcListUpdateStage.setScene(scene);
				deptOutSrcListUpdateStage.showAndWait();
			} catch (IOException e) {
				e.printStackTrace();
			}
			outsourcingService = OutsourcingService.getInstance();
			planningList = FXCollections.observableArrayList(outsourcingService.getAllPlanning());
			
			t1_tv.setItems(planningList);
    	}
    }

    /**
     *@Method Name : click_t1_btn_delete
     *@date : 2018. 9. 27.
     *@author : 박동주
     *@Method 설명 : 삭제 버튼 이벤트
     *@param event
     */
    @FXML
    void click_t1_btn_delete(ActionEvent event) {
    	
    	Stage primaryStage = (Stage)t1_btn_search.getScene().getWindow();
    	
    	List<PlanningVo> planList2 = t1_tv.getItems();
    	List<String> chkList = new ArrayList<String>();
    	for (PlanningVo planningVo : planList2) {
			if(planningVo.getPlan_chk().isSelected()) {
				chkList.add(planningVo.getPlan_no());
				System.out.println(planningVo.getPlan_no());
			}
		}
    	int cnt = outsourcingService.deletePlan(chkList);
    	if(cnt > 0) {
    		AlertWindow.SucceedAlert(primaryStage);
    	}else {
    		AlertWindow.FailedAlert(primaryStage);
    	}
    	
//    	planList = outsourcingService.getAllPlanning();
//		if(t1_chk.isSelected()) {
//			for (PlanningVo planningVo : planList) {
//				planningVo.getPlan_chk().setSelected(true);
//			}
//		} else {
//			for (PlanningVo planningVo : planList) {
//				planningVo.getPlan_chk().setSelected(false);
//			}
//		}
		outsourcingService = OutsourcingService.getInstance();
		planningList = FXCollections.observableArrayList(outsourcingService.getAllPlanning());
		
		t1_tv.setItems(planningList); // 새로고침
    }

    /**
     *@Method Name : click_t1_btn_search
     *@date : 2018. 9. 27.
     *@author : 박동주
     *@Method 설명 : 검색 이벤트
     *@param event
     */
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
    void select_t1_chk(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert tp_root != null : "fx:id=\"tp_root\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_tf_search != null : "fx:id=\"t1_tf_search\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_col_chk != null : "fx:id=\"t1_col_chk\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_col_plan_no != null : "fx:id=\"t1_col_plan_no\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_col_plan_title != null : "fx:id=\"t1_col_plan_title\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_col_plan_date != null : "fx:id=\"t1_col_plan_date\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_col_plan_note != null : "fx:id=\"t1_col_plan_note\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_col_plan_name != null : "fx:id=\"t1_col_plan_name\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_btn_add != null : "fx:id=\"t1_btn_add\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";
        assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'DeptOutSrcList.fxml'.";

        t1_cb.getItems().addAll("기획명", "작성자");
        
        t1_cb.getSelectionModel().selectFirst(); // 처음값으로 셋팅해줌
        
        t1_tv.setItems(planningList);
        
        t1_col_chk.setCellValueFactory(new PropertyValueFactory<>("plan_chk"));
		t1_col_plan_no.setCellValueFactory(new PropertyValueFactory<>("plan_no"));
		t1_col_plan_title.setCellValueFactory(new PropertyValueFactory<>("plan_title"));
		t1_col_plan_date.setCellValueFactory(new PropertyValueFactory<>("plan_date"));
		t1_col_plan_note.setCellValueFactory(new PropertyValueFactory<>("plan_note"));
		t1_col_plan_name.setCellValueFactory(new PropertyValueFactory<>("plan_name"));
    }
}
