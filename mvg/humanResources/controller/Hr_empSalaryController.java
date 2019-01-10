package humanResources.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.join.SalaryEmpVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;

public class Hr_empSalaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_chk;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_note;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_salary;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_pos;

    @FXML
    private AnchorPane tap1_t1;

    @FXML
    private Button t1_bnt_search;

    @FXML
    private TabPane t1_tp_main;

    @FXML
    private Button t1_btn_submit;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_dept;

    @FXML
    private TextField t1_tf_search;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_name;

    @FXML
    private ComboBox<String> t1_cb_search;

    @FXML
    private TableView<SalaryEmpVo> t1_tv;

    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_code;
    
    @FXML
    private TableColumn<SalaryEmpVo, String> t1_col_count;

    @FXML
    private DatePicker t1_dp;

    @FXML
    private Label t1_label;

    @FXML
    void click_t1_btn_search(ActionEvent event) {
    	if(t1_tf_search.getText().equals("")) {
			salaryEmpList(empService.salaryEmpList(LocalDate.now().toString().substring(0, 8))); 
		}else {
			/* 콤보박스 key 값  검색 value 값으로 검색 */
			empService = EmployeeService.getInstance();
			Map<String, String> salMap = new HashMap<>();
			salMap.put("attd_date", t1_dp.getValue().toString().substring(0, 8));
			if(t1_cb_search.getValue().toString().equals("ID")) {
				salMap.put("emp_code", t1_tf_search.getText());
//				getEmp.put("emp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("사원명")) {
				salMap.put("emp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("부서")) {
				salMap.put("dept_name", t1_tf_search.getText());
//				getEmp.put("emp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("직급")) {
				salMap.put("pos_name", t1_tf_search.getText());
//				getEmp.put("emp_name", t1_tf_search.getText());
			}
			/* key 와 value 값으로 결과 출력*/
			List<SalaryEmpVo> salEmpList = empService.salaryEmp(salMap);
			if(salEmpList.size() == 0) {
				AlertWindow.infoAlert("Failed", "결과 값이 존재하지 않습니다.");
			}else {
				salaryEmpList(salEmpList);    			
			}
		}//else 
    }

    @FXML
    void click_t1_tv(MouseEvent event) {

    }

    @FXML
    void click_submit(ActionEvent event) {
    	try {
			Stage hrStage =  (Stage)t1_tp_main.getScene().getWindow();
			Stage salUpdate = new Stage();						 	// 새로운 스테이지를 하나만든다.
			salUpdate.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
			salUpdate.initOwner(hrStage);							// 부모창 설정
			Parent proot = FXMLLoader.load(getClass().getResource("../fxml/hr_empSalaryBasic.fxml")); // 위치 
			Scene scene = new Scene(proot);							// 새창을 연결
			salUpdate.setScene(scene);								// 스테이지에 새씬을 연결한다.
			salUpdate.initStyle(StageStyle.UNDECORATED);
			salUpdate.showAndWait();										// 열어주세요.
		} catch (IOException e) {
			System.out.println("HumanRes.fxml(click_submit) :" + e);
		} // Error표시를 출력해주는 주소
    	salaryEmpList(empService.salaryEmpList(LocalDate.now().toString().substring(0, 8))); // 새로고침
    }
    
    @FXML
    void select_t1_dp(Event event) {
    	List<SalaryEmpVo>salList = empService.salaryEmpList(t1_dp.getValue().toString().substring(0, 8));
    	t1_label.setText(t1_dp.getValue().toString().substring(5, 7) + "월");
		salaryEmpList(salList); // 출력 	
    }
    
    /* 전역 변수 선언 */
	private IEmployeeService empService  = EmployeeService.getInstance();;
	private List<SalaryEmpVo> salaryEmpList   = empService.salaryEmpList(LocalDate.now().toString().substring(0, 8));
	
	private ObservableList<SalaryEmpVo> objList;
	
	@FXML
    void initialize() {
        assert t1_col_chk != null : "fx:id=\"t1_col_chk\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_note != null : "fx:id=\"t1_col_note\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_count != null : "fx:id=\"t1_col_count\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_salary != null : "fx:id=\"t1_col_salary\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_pos != null : "fx:id=\"t1_col_pos\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert tap1_t1 != null : "fx:id=\"tap1_t1\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_bnt_search != null : "fx:id=\"t1_bnt_search\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_tp_main != null : "fx:id=\"t1_tp_main\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_btn_submit != null : "fx:id=\"t1_btn_submit\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_dept != null : "fx:id=\"t1_col_dept\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_tf_search != null : "fx:id=\"t1_tf_search\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_name != null : "fx:id=\"t1_col_name\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_cb_search != null : "fx:id=\"t1_cb_search\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_dp != null : "fx:id=\"t1_dp\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
        assert t1_label != null : "fx:id=\"t1_label\" was not injected: check your FXML file 'hr_empSalary.fxml'.";
    	//시작 .....
        salaryEmpList(salaryEmpList); // 회원목록을 전부 띄워주는 메서드 

		/* 콤보박스 설정 기본값을 first값으로 설정해준다 */
		t1_cb_search.setItems(ComboList.searchCombo());
		t1_cb_search.getSelectionModel().selectFirst(); 
		
		t1_dp.setValue(LocalDate.now());
		t1_label.setText(LocalDate.now().toString().substring(5, 7) + "월");

	}// initialize()

	/**
	 *@Method Name : searchAllEmp
	 *@date : 2018. 9. 14.
	 *@author : Mr.KKu
	 *@Method 설명 : 사원 전부 검색 
	 */
	public void salaryEmpList(List<SalaryEmpVo> empList) {
		/* 체크박스 사용시 주의 사항
		 * ex) 연결되어있는 GetAllNowEmpVo 에서 체크박스를 생성합니다.  (겟터셋터 그리고 오버라이드된 셋터하나더 )
		 * GetAllNowEmpVo 열어서 내용 확인후   EmployeeDao 에서 getAllNowEmp() 메서드안에 내용을 확인한다.
		 * 검색된 수만큼 체크박스를 생성해주는 방식을 이용했다. */
		objList = FXCollections.observableArrayList(empList);
		t1_tv.setItems(objList);
		t1_col_code.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("emp_code"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("emp_name"));
		t1_col_dept.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("dept_name"));
		t1_col_pos.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("pos_name"));
		t1_col_count.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("attd_count"));
		t1_col_salary.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("sal_basic"));
		t1_col_note.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("emp_note"));
		
	} //searchAllEmp()

}
