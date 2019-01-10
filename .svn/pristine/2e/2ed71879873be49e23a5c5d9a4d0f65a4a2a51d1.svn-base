package humanResources.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.join.AttendedEmpVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;

public class Hr_attendedEmp {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane t1_tp_main;

    @FXML
    private AnchorPane tap1_t1;

    @FXML
    private ComboBox<String> t1_cb_search;

    @FXML
    private TextField t1_tf_search;

    @FXML
    private Button t1_bnt_search;

    @FXML
    private TableView<AttendedEmpVo> t1_tv;

    @FXML
    private TableColumn<AttendedEmpVo, String> t1_col_code;

    @FXML
    private TableColumn<AttendedEmpVo, String> t1_col_name;

    @FXML
    private TableColumn<AttendedEmpVo, String> t1_col_pos;

    @FXML
    private TableColumn<AttendedEmpVo, String> t1_col_dept;

    @FXML
    private TableColumn<AttendedEmpVo, String> t1_col_chk;

    @FXML
    private TableColumn<AttendedEmpVo, String> t1_col_note;

    @FXML
    private DatePicker t1_dp;

    @FXML
    void click_search(ActionEvent event) {
       	Map<String, String> attdMap = new HashMap<>();
    	if(t1_cb_search.getValue().toString().equals("사원명")) {
    		attdMap.put("emp_name", t1_tf_search.getText());
		}else if (t1_cb_search.getValue().toString().equals("사원코드")) {
			attdMap.put("attd_emp", t1_tf_search.getText());
//			attdMap.put("emp_name", t1_tf_search.getText());
		} else if (t1_cb_search.getValue().toString().equals("부서")) {
			attdMap.put("dept_name", t1_tf_search.getText());
//			attdMap.put("emp_name", t1_tf_search.getText());
		} else if (t1_cb_search.getValue().toString().equals("직급")) {
			attdMap.put("pos_name", t1_tf_search.getText());
//			attdMap.put("emp_name", t1_tf_search.getText());
		}
    	attdMap.put("attd_date", t1_dp.getValue().toString());  // 날짜 검색
    	List<AttendedEmpVo>attdList = attendService.searchAttend(attdMap);
    	if(attdList.size() == 0) {
			AlertWindow.infoAlert("Failed", "결과 값이 존재하지 않습니다.");
		}else {
			getListAttended(attdList); // 출력 			
		}
    }

    @FXML
    void select_t1_pd(ActionEvent event) {
    	System.out.println(t1_dp.getValue().toString());
    	List<AttendedEmpVo>attdList = attendService.listToday(t1_dp.getValue().toString());
		getListAttended(attdList); // 출력 			
    }

    
    /* 전역변수 선언 */
    IEmployeeService attendService = EmployeeService.getInstance();
    ObservableList<AttendedEmpVo> objList;
    
    @FXML
    void initialize() {
        assert t1_col_chk != null : "fx:id=\"t1_col_chk\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_col_note != null : "fx:id=\"t1_col_note\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_col_pos != null : "fx:id=\"t1_col_pos\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert tap1_t1 != null : "fx:id=\"tap1_t1\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_bnt_search != null : "fx:id=\"t1_bnt_search\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_dp != null : "fx:id=\"t1_dp\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_tp_main != null : "fx:id=\"t1_tp_main\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_col_dept != null : "fx:id=\"t1_col_dept\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_tf_search != null : "fx:id=\"t1_tf_search\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_col_name != null : "fx:id=\"t1_col_name\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_cb_search != null : "fx:id=\"t1_cb_search\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'hr_attended.fxml'.";
        assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'hr_attended.fxml'.";
       
        t1_dp.setValue(LocalDate.now());
        
        getListAttended(attendService.listToday(t1_dp.getValue().toString())); // 초기 출력 리스트
        
        t1_cb_search.setItems(ComboList.searchAttended());
        t1_cb_search.getSelectionModel().selectFirst();
        
    }
    
    /**
     *@Method 설명 : 출결사항 리스트 출력
     *@Method Name : getListAttended
     *@date : 2018. 9. 21.
     *@author : Mr.KKu
     *@param empList
     */
    public void getListAttended(List<AttendedEmpVo> empList) {
		objList = FXCollections.observableArrayList(empList);
		t1_tv.setItems(objList);
		t1_col_code.setCellValueFactory(new PropertyValueFactory<AttendedEmpVo, String>("attd_emp"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<AttendedEmpVo, String>("emp_name"));
		t1_col_pos.setCellValueFactory(new PropertyValueFactory<AttendedEmpVo, String>("pos_name"));
		t1_col_dept.setCellValueFactory(new PropertyValueFactory<AttendedEmpVo, String>("dept_name"));
		t1_col_chk.setCellValueFactory(new PropertyValueFactory<AttendedEmpVo, String>("attd_chk"));
		t1_col_note.setCellValueFactory(new PropertyValueFactory<AttendedEmpVo, String>("attd_note"));
	} //searchAllEmp()
}
