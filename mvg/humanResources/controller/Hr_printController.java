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
import humanResources.vo.EmployeeVo;
import humanResources.vo.join.GetAllNowEmpVo;
import humanResources.vo.join.GetAllRetiredEmpVo;
import humanResources.vo.join.SalaryEmpVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import staticMethod.alert.AlertWindow;
import staticMethod.comboBox.ComboList;
import staticMethod.pdf.hrPDF.Hr_LocationPDF;
import staticMethod.pdf.hrPDF.Hr_empPDF;
import staticMethod.pdf.hrPDF.Hr_rempPDF;
import staticMethod.pdf.hrPDF.Hr_salaryPDF;

public class Hr_printController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TabPane t1_tp_main;

	/* tap1 */
	@FXML
	private AnchorPane tap1_t1;
	@FXML
	private Tab t1_tap;
	@FXML
	private TextField t1_tf_search;
	@FXML
	private Button t1_bnt_search;
	@FXML
	private Button t1_btn_PDF;

	@FXML
	private TableView<GetAllNowEmpVo> t1_tv;
	@FXML
	private ComboBox<String> t1_cb_search;
	@FXML
	private TableColumn<GetAllNowEmpVo, Boolean> t1_col_chk;
	@FXML
	private TableColumn<GetAllNowEmpVo, String> t1_col_code;
	@FXML
	private TableColumn<GetAllNowEmpVo, String> t1_col_name;
	@FXML
	private TableColumn<GetAllNowEmpVo, String> t1_col_pos;
	@FXML
	private TableColumn<GetAllNowEmpVo, String> t1_col_dept;
	@FXML
	private TableColumn<GetAllNowEmpVo, String> t1_col_hdate;
	@FXML
	private TableColumn<GetAllNowEmpVo, String> t1_col_note;

	/* tap1 action */
    @FXML
    void click_t1_tap(Event event) {
    	if(t1_tap.isSelected()) {
    		searchAllEmp(empList);
    		/* 콤보박스 설정 기본값을 first값으로 설정해준다 */
    		t1_cb_search.getSelectionModel().selectFirst(); 
    		t1_tf_search.setText("");;;
    	}
    }
	@FXML
	void click_t1_btn_search(ActionEvent event) {
		if(t1_tf_search.getText().equals("")) {
			searchAllEmp(empService.getAllNowEmp()); 
		}else {
			/* 콤보박스 key 값  검색 value 값으로 검색 */
			empService = EmployeeService.getInstance();
			Map<String, String> getEmp = new HashMap<>();
			if(t1_cb_search.getValue().toString().equals("ID")) {
				getEmp.put("emp_code", t1_tf_search.getText());
//				getEmp.put("emp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("사원명")) {
				getEmp.put("emp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("부서")) {
				getEmp.put("dept_name", t1_tf_search.getText());
//				getEmp.put("emp_name", t1_tf_search.getText());
			} else if (t1_cb_search.getValue().toString().equals("직급")) {
				getEmp.put("pos_name", t1_tf_search.getText());
//				getEmp.put("emp_name", t1_tf_search.getText());
			}
			/* key 와 value 값으로 결과 출력*/
			List<GetAllNowEmpVo> empList = empService.getEmp(getEmp);
			if(empList.size() == 0) {
				AlertWindow.infoAlert("Failed", "결과 값이 존재하지 않습니다.");
			}else {
				searchAllEmp(empList);    			
			}
		}//else 
	}

	@FXML
	void click_t1_tv(MouseEvent event) {
//		if (event.getClickCount() > 1) { 
//			Stage updateEmp = new Stage();
//			if(t1_tv.getSelectionModel().getSelectedItem() == null) {
//
//			} else {
//				try {
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/hr_empList_update.fxml"));
//					updateEmp.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
//					updateEmp.initOwner(t1_tp_main.getScene().getWindow());						// 부모창 설정
//					Parent pRoot = loader.load();
//					Hr_empList_updateController formController = loader.getController();
//					GetAllNowEmpVo empVo = t1_tv.getSelectionModel().getSelectedItem();
//					int year = Integer.parseInt(empVo.getEmp_hdate().substring(0,4));
//					int month = Integer.parseInt(empVo.getEmp_hdate().substring(5,7));
//					int day = Integer.parseInt(empVo.getEmp_hdate().substring(8,10));
//					LocalDate  currentTime = LocalDate.now();
//					LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
//					formController.getEmpInfo(empVo.getEmp_code() , targetTime);
//					Scene scene = new Scene(pRoot);							// 새창을 연결
//					updateEmp.setScene(scene);								// 스테이지에 새씬을 연결한다.
//					updateEmp.showAndWait();										// 열어주세요.
//				} catch (IOException e) {
//					System.out.println("hr_empListController" + e);
//				}
//				searchAllEmp(empService.getAllNowEmp()); // 새로고침
//			}
//		}
	}


	@FXML
	void click_t1_print(ActionEvent event) {
		
		List<GetAllNowEmpVo> getAllNowEmpVos =  t1_tv.getItems();
		String emp_code = "";
		String pos_name = "";
		for (GetAllNowEmpVo getAllNowEmpVo : getAllNowEmpVos) {
			if(getAllNowEmpVo.getEmp_chk().isSelected()) {
				emp_code = getAllNowEmpVo.getEmp_code();
				pos_name = getAllNowEmpVo.getPos_name();

				EmployeeVo empVo = empService.getOneEmp(emp_code);
				Hr_empPDF.makePDF_emp(empVo.getEmp_name(), empVo.getEmp_regno1(), empVo.getEmp_regno2(),pos_name, empVo.getEmp_addr(), empVo.getEmp_hdate());
				try {
					new ProcessBuilder(
							Hr_LocationPDF.LOCATION_PDF,
							 // PDF 실행파일 위치
							Hr_LocationPDF.LOCATION_PDF_JEJIC).start(); // PDF파일 위치

					// PDF실행 파일이 위치한 폴더까지 경로를 써주고 그다음 만든 PDF파일이 위치한 경로를 쓴다. 단 여기서 일반 적인
					//경로에는 역슬레시(\)가 하나지만 자바에서는 하나만 들어가면 문자로 인식 하기때문에 두개를 넣어주어야 오류가 나지 않는다.
				} catch (IOException e) {
					System.out.println("Hr_printController = " + e);
				} 
				return;
			}
		}
		AlertWindow.errorAlert("선택된 회원이 없습니다.", "하나의 회원이 선택되어야 합니다.  \n 만약 두명이 있다면 위에 체크되는 사람이 선택됩니다.");
		return ;
	}


	/* tap2 */
	@FXML
	private AnchorPane tap2_t1;
	@FXML
	private Tab t2_tap;
	@FXML
	private TextField t2_tf_search;
	@FXML
	private Button t2_bnt_search;
	@FXML
	private Button t2_btn_PDF;


	@FXML
	private TableView<GetAllRetiredEmpVo> t2_tv;
	@FXML
	private ComboBox<String> t2_cb_search;
	@FXML
	private TableColumn<GetAllRetiredEmpVo, Boolean> t2_col_chk;
	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t2_col_code;
	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t2_col_name;
	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t2_col_dept;
	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t2_col_pos;
	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t2_col_datae;


	@FXML
	private TableColumn<GetAllRetiredEmpVo, String> t2_col_note;

	/* tap2 action */
    @FXML
    void click_t2_tap(Event event) {
    	if(t2_tap.isSelected()) {
    		getAllRetiredEmp(rempList);
    	}
    }
	@FXML
	void click_t2_btn_search(ActionEvent event) {
		if(t2_tf_search.getText().equals("")) {
			getAllRetiredEmp(rempList); 
		}else {
			/* 콤보박스 key 값  검색 value 값으로 검색 */
		
			Map<String, String> getEmp = new HashMap<>();
			if(t2_cb_search.getValue().toString().equals("퇴사자코드")) {
				getEmp.put("remp_code", t2_tf_search.getText());
			} else if (t2_cb_search.getValue().toString().equals("퇴사자명")) {
				getEmp.put("remp_name", t2_tf_search.getText());
			} else if (t2_cb_search.getValue().toString().equals("부서")) {
				getEmp.put("dept_name", t2_tf_search.getText());
			} 
			/* key 와 value 값으로 결과 출력*/
			List<GetAllRetiredEmpVo> rempList = empService.getRemp(getEmp);
			if(rempList.size() == 0) {
				AlertWindow.infoAlert("Failed", "결과 값이 존재하지 않습니다.");
			}else {
				getAllRetiredEmp(rempList);    			
			}
		}//else 
	}

	@FXML
	void click_t2_tv(MouseEvent event) {

	}

	@FXML
	void click_t2_print(ActionEvent event) {
		List<GetAllRetiredEmpVo> getAllRetiredEmpList =  t2_tv.getItems();
		for (GetAllRetiredEmpVo rempVo : getAllRetiredEmpList) {
			if(rempVo.getRemp_chk().isSelected()) {
				Hr_rempPDF.makePDF_remp(rempVo.getDept_name(), rempVo.getPos_name(), rempVo.getRemp_name(), "생년월일", 
						rempVo.getEmp_hdate(),rempVo.getEmp_regno1(),rempVo.getEmp_regno2(), rempVo.getRemp_date(), rempVo.getRemp_note(), rempVo.getEmp_addr() );
				try {
					new ProcessBuilder(
							Hr_LocationPDF.LOCATION_PDF, // PDF 실행파일 위치
							Hr_LocationPDF.LOCATION_PDF_RETIRED).start(); // PDF파일 위치

					// PDF실행 파일이 위치한 폴더까지 경로를 써주고 그다음 만든 PDF파일이 위치한 경로를 쓴다. 단 여기서 일반 적인
					//경로에는 역슬레시(\)가 하나지만 자바에서는 하나만 들어가면 문자로 인식 하기때문에 두개를 넣어주어야 오류가 나지 않는다.
				} catch (IOException e) {
					System.out.println("Hr_printController = " + e);
				} 
				return;
			}
		}
		AlertWindow.errorAlert("선택된 회원이 없습니다.", "하나의 회원이 선택되어야 합니다.  \n 만약 두명이 있다면 위에 체크되는 사람이 선택됩니다.");
		return ;
	}


	/* tap3 */
	@FXML
	private AnchorPane tap3_t1;
	@FXML
	private Tab t3_tap;
	@FXML
	private TextField t3_tf_search;
	@FXML
	private Button t3_bnt_search;
	@FXML
	private Button t3_btn_PDF;
    @FXML
    private DatePicker t3_dp;
    @FXML
    private Label t3_label;
    
	@FXML
	private TableView<SalaryEmpVo> t3_tv;
	@FXML
	private ComboBox<String> t3_cb_search;
	@FXML
	private TableColumn<SalaryEmpVo, Boolean> t3_col_chk;
	@FXML
	private TableColumn<SalaryEmpVo, String> t3_col_code;
	@FXML
	private TableColumn<SalaryEmpVo, String> t3_col_name;
	@FXML
	private TableColumn<SalaryEmpVo, String> t3_col_pos;
	@FXML
	private TableColumn<SalaryEmpVo, String> t3_col_dept;
    @FXML
    private TableColumn<SalaryEmpVo, String> t3_col_salary;
    @FXML
    private TableColumn<SalaryEmpVo, String> t3_col_count;
    @FXML
    private TableColumn<SalaryEmpVo, String> t3_col_note;


	/* tap3 Action */
    @FXML
    void click_t3_tap(Event event) {
    	if(t3_tap.isSelected()) {
    		
    	}
    }
	@FXML
	void click_t3_btn_search(ActionEvent event) {
		if(t3_tf_search.getText().equals("")) {
			salaryEmpList(empService.salaryEmpList(LocalDate.now().toString().substring(0, 8))); 
		}else {
			/* 콤보박스 key 값  검색 value 값으로 검색 */
			empService = EmployeeService.getInstance();
			Map<String, String> salMap = new HashMap<>();
			salMap.put("attd_date", t3_dp.getValue().toString().substring(0, 8));
			if(t3_cb_search.getValue().toString().equals("ID")) {
				salMap.put("emp_code", t3_tf_search.getText());
			} else if (t3_cb_search.getValue().toString().equals("사원명")) {
				salMap.put("emp_name", t3_tf_search.getText());
			} else if (t3_cb_search.getValue().toString().equals("부서")) {
				salMap.put("dept_name", t3_tf_search.getText());
			} else if (t3_cb_search.getValue().toString().equals("직급")) {
				salMap.put("pos_name", t3_tf_search.getText());
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
	void click_t3_tv(MouseEvent event) {

	}

	@FXML
	void click_t3_print(ActionEvent event) {
		LocalDate currentDate = LocalDate.now();
		List<SalaryEmpVo> salaryEmpList =  t3_tv.getItems();
		for (SalaryEmpVo salVo : salaryEmpList) {
			if(salVo.getSal_chk().isSelected()) {
				int salBasic = Integer.parseInt(salVo.getSal_basic()+"0000");
				int absence =currentDate.lengthOfMonth() -  Integer.parseInt(salVo.getAttd_count());
				Hr_salaryPDF.makePDF_salary(salVo.getEmp_name(), salBasic, salVo.getAttd_count(), "9",0,0,0,0,0,0,0,0,0,absence);;
				try {
					new ProcessBuilder(
							Hr_LocationPDF.LOCATION_PDF, // PDF 실행파일 위치
							Hr_LocationPDF.LOCATION_PDF_SALARY).start(); // PDF파일 위치

					// PDF실행 파일이 위치한 폴더까지 경로를 써주고 그다음 만든 PDF파일이 위치한 경로를 쓴다. 단 여기서 일반 적인
					//경로에는 역슬레시(\)가 하나지만 자바에서는 하나만 들어가면 문자로 인식 하기때문에 두개를 넣어주어야 오류가 나지 않는다.
				} catch (IOException e) {
					System.out.println("Hr_printController = " + e);
				} 
				return;
			}
		}
		AlertWindow.errorAlert("선택된 회원이 없습니다.", "하나의 회원이 선택되어야 합니다.  \n 만약 두명이 있다면 위에 체크되는 사람이 선택됩니다.");
		return ;
	}
	
    @FXML
    void select_t3_dp(Event event) {
    	List<SalaryEmpVo>salList = empService.salaryEmpList(t3_dp.getValue().toString().substring(0, 8));
    	t3_label.setText(t3_dp.getValue().toString().substring(5, 7) + "월");
		salaryEmpList(salList); // 출력 		
    }

	/* 전역 변수 선언 */
	private IEmployeeService empService  = EmployeeService.getInstance();;
	private List<GetAllNowEmpVo> empList    = empService.getAllNowEmp();
	private List<GetAllRetiredEmpVo> rempList = empService.getAllRetiredEmp();
	private ObservableList<GetAllNowEmpVo> empObjList;
	private ObservableList<GetAllRetiredEmpVo> rempObjList;
	private List<SalaryEmpVo> salaryEmpList   = empService.salaryEmpList(LocalDate.now().toString().substring(0, 8));
	private ObservableList<SalaryEmpVo> salaryList;

	 @FXML
	    void initialize() {
	        assert t3_col_salary != null : "fx:id=\"t3_col_salary\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_tv != null : "fx:id=\"t3_tv1\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_bnt_search != null : "fx:id=\"t3_bnt_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_code != null : "fx:id=\"t3_col_code\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_datae != null : "fx:id=\"t2_col_datae\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_tap != null : "fx:id=\"t3_tap\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_hdate != null : "fx:id=\"t1_col_hdate\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_pos != null : "fx:id=\"t1_col_pos\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_btn_PDF != null : "fx:id=\"t1_btn_PDF\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_pos != null : "fx:id=\"t2_col_pos\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_bnt_search != null : "fx:id=\"t1_bnt_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_tp_main != null : "fx:id=\"t1_tp_main\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert tap2_t1 != null : "fx:id=\"tap2_t1\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_code != null : "fx:id=\"t2_col_code\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_dept != null : "fx:id=\"t1_col_dept\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_note != null : "fx:id=\"t3_col_note\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_tv != null : "fx:id=\"t2_tv\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_name != null : "fx:id=\"t1_col_name\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_tf_search != null : "fx:id=\"t2_tf_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_cb_search != null : "fx:id=\"t1_cb_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_count != null : "fx:id=\"t3_col_count\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_pos != null : "fx:id=\"t3_col_pos\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_chk != null : "fx:id=\"t2_col_chk\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_dept != null : "fx:id=\"t3_col_dept\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_tf_search != null : "fx:id=\"t3_tf_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_name != null : "fx:id=\"t3_col_name\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_chk != null : "fx:id=\"t1_col_chk\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_note != null : "fx:id=\"t1_col_note\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_bnt_search != null : "fx:id=\"t2_bnt_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_btn_PDF != null : "fx:id=\"t3_btn_PDF\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_cb_search != null : "fx:id=\"t3_cb_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_btn_PDF != null : "fx:id=\"t2_btn_PDF\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_col_chk != null : "fx:id=\"t3_col_chk\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_tap != null : "fx:id=\"t1_tap\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_note != null : "fx:id=\"t2_col_note\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert tap1_t1 != null : "fx:id=\"tap1_t1\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_name != null : "fx:id=\"t2_col_name\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert tap3_t1 != null : "fx:id=\"tap3_t1\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_cb_search != null : "fx:id=\"t2_cb_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_tf_search != null : "fx:id=\"t1_tf_search\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_tap != null : "fx:id=\"t2_tap\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t2_col_dept != null : "fx:id=\"t2_col_dept\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t1_col_code != null : "fx:id=\"t1_col_code\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_dp != null : "fx:id=\"t3_dp\" was not injected: check your FXML file 'hr_print.fxml'.";
	        assert t3_label != null : "fx:id=\"t3_label\" was not injected: check your FXML file 'hr_print.fxml'.";
		//시작 .....
		searchAllEmp(empList); // 회원목록을 전부 띄워주는 메서드 
		getAllRetiredEmp(rempList);
		salaryEmpList(salaryEmpList);  // 급여 내역
		
		/* 콤보박스 설정 기본값을 first값으로 설정해준다 */
		t1_cb_search.setItems(ComboList.searchCombo());
		t1_cb_search.getSelectionModel().selectFirst(); 
		
		t2_cb_search.setItems(ComboList.searchRemp());
		t2_cb_search.getSelectionModel().selectFirst();

		t3_cb_search.setItems(ComboList.searchCombo());
		t3_cb_search.getSelectionModel().selectFirst(); 
		
		t3_dp.setValue(LocalDate.now());
		t3_label.setText(LocalDate.now().toString().substring(5, 7) + "월");
	}

	public void searchAllEmp(List<GetAllNowEmpVo> empList) {
		empObjList = FXCollections.observableArrayList(empList);
		t1_tv.setItems(empObjList);
		t1_col_chk.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, Boolean>("emp_chk"));
		t1_col_code.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, String>("emp_code"));
		t1_col_name.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, String>("emp_name"));
		t1_col_dept.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, String>("dept_name"));
		t1_col_pos.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, String>("pos_name"));
		t1_col_hdate.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, String>("emp_hdate"));
		t1_col_note.setCellValueFactory(new PropertyValueFactory<GetAllNowEmpVo, String>("emp_note"));
	} //searchAllEmp()

	public void getAllRetiredEmp(List<GetAllRetiredEmpVo> rempList) {
		rempObjList = FXCollections.observableArrayList(rempList);
		t2_tv.setItems(rempObjList);
		t2_col_chk.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, Boolean>("remp_chk"));
		t2_col_code.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_code"));
		t2_col_name.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_name"));
		t2_col_dept.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("dept_name"));
		t2_col_pos.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("pos_name"));
		t2_col_datae.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_date"));
		t2_col_note.setCellValueFactory(new PropertyValueFactory<GetAllRetiredEmpVo, String>("remp_note"));
	} //getAllRetiredEmp()
	
	public void salaryEmpList(List<SalaryEmpVo> salList) {
		salaryList = FXCollections.observableArrayList(salList);
		t3_tv.setItems(salaryList);
		t3_col_chk.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, Boolean>("sal_chk"));
		t3_col_code.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("emp_code"));
		t3_col_name.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("emp_name"));
		t3_col_dept.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("dept_name"));
		t3_col_pos.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("pos_name"));
		t3_col_count.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("attd_count"));
		t3_col_salary.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("sal_basic"));
		t3_col_note.setCellValueFactory(new PropertyValueFactory<SalaryEmpVo, String>("emp_note"));
		
	} //searchAllEmp()
}
