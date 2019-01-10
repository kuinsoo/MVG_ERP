package outsourcing.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import outsourcing.service.IOutsourcingService;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.ScheduleMovieVo;

public class DeptOutSrcMovieController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<ScheduleMovieVo, String> t1_col_acc_name;

    @FXML
    private TableColumn<ScheduleMovieVo, String> t1_col_plan_title;

    @FXML
    private TableColumn<ScheduleMovieVo, String> t1_col_scd_edate;

    @FXML
    private TabPane tp_root;

    @FXML
    private DatePicker t1_dp;

    @FXML
    private Button t1_btn_add;

    @FXML
    private Button t1_btn_delete;

    @FXML
    private Button t1_btn_next;

    @FXML
    private Button t1_btn_prev;

    @FXML
    private Label t1_label;

    @FXML
    private TableColumn<ScheduleMovieVo, String> t1_col_scd_sdate;

    @FXML
    private Tab t1;

    @FXML
    private TableColumn<ScheduleMovieVo, String> t1_col_scd_scr;
    
    @FXML
    private TableColumn<ScheduleMovieVo, Boolean> t1_col_plan_chk;
    
    @FXML
    private TableView<ScheduleMovieVo> t1_tv;


    @FXML
    void click_t1_btn_next(ActionEvent event) {
    	changeDate = changeDate.plusDays(1);
    	schView(outService.locationDateSchMoive(changeDate.toString()));
    	t1_dp.setValue(changeDate);
    	t1_label.setText(changeDate.toString());
    }

    @FXML
    void click_t1_btn_prev(ActionEvent event) {
    	changeDate = changeDate.minusDays(1);
    	schView(outService.locationDateSchMoive(changeDate.toString()));
    	t1_dp.setValue(changeDate);
    	t1_label.setText(changeDate.toString());
    }

    @FXML
    void select_t1_dp(Event event) {
    	changeDate = t1_dp.getValue();
    	schView(outService.locationDateSchMoive(changeDate.toString()));
    	t1_label.setText(changeDate.toString());
    }
    
    @FXML
    void click_t1_tv(MouseEvent event) {
    	Stage primaryStage = (Stage)t1_tv.getScene().getWindow();
    	try {
		} catch (Exception e) {
//			AlertWindow.FailedAlert(primaryStage); // 잘못 클릭
		}
    }
	
	@FXML
    void click_t1_btn_add(ActionEvent event) {
		try {
			Stage schStage =  (Stage)tp_root.getScene().getWindow();
			Stage addEmp = new Stage();						 	// 새로운 스테이지를 하나만든다.
			addEmp.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
			addEmp.initOwner(schStage);							// 부모창 설정
			Parent proot = FXMLLoader.load(getClass().getResource("../fxml/DeptOutSrcMovieAdd.fxml")); // 위치 
			Scene scene = new Scene(proot);							// 새창을 연결
			addEmp.setScene(scene);								// 스테이지에 새씬을 연결한다.
			addEmp.initStyle(StageStyle.UNDECORATED);
			addEmp.showAndWait();										// 열어주세요.
		} catch (IOException e) {
			System.out.println("DeptOutSrcMovieAdd.fxml(click_add) :" + e);
		} // Error표시를 출력해주는 주소
		schView(outService.locationDateSchMoive(t1_dp.getValue().toString())); // 새로고침
    }

    @FXML
    void click_t1_btn_delete(ActionEvent event) {



    }
    /* 전역변수 */
	private IOutsourcingService outService  = OutsourcingService.getInstance();
	private List<ScheduleMovieVo> schList  ;
	private ObservableList<ScheduleMovieVo> objList;
	private LocalDate currentDate = LocalDate.now();
	private LocalDate changeDate = currentDate;
	
	
    @FXML
    void initialize() {
        assert t1_col_acc_name != null : "fx:id=\"acc_name\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_col_plan_title != null : "fx:id=\"plan_title\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_col_scd_edate != null : "fx:id=\"scd_edate\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert tp_root != null : "fx:id=\"tp_root\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_dp != null : "fx:id=\"t1_dp\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_btn_next != null : "fx:id=\"t1_btn_next\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_btn_prev != null : "fx:id=\"t1_btn_prev\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_label != null : "fx:id=\"t1_label\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_col_scd_sdate != null : "fx:id=\"scd_sdate\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_col_scd_scr != null : "fx:id=\"scd_scr\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_btn_add != null : "fx:id=\"t1_btn_add\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        assert t1_col_plan_chk != null : "fx:id=\"t1_col_plan_chk\" was not injected: check your FXML file 'DeptOutSrcMovie.fxml'.";
        schView(outService.locationDateSchMoive(currentDate.toString())); // 리스트 출력
        
        t1_dp.setValue(currentDate); // 기본 날짜 셋팅
    	t1_label.setText(currentDate.toString());
        
    }
    

	/**
	 *@Method 설명 : 전체리스트를 뿌려준다
	 *@Method Name : schView
	 *@date : 2018. 9. 30.
	 *@author : Mr.KKu
	 *@param schView
	 */
	public void schView(List<ScheduleMovieVo> schViewList) {
		objList = FXCollections.observableArrayList(schViewList);
		t1_tv.setItems(objList);
		t1_col_plan_chk.setCellValueFactory(new PropertyValueFactory<ScheduleMovieVo, Boolean>("scd_chk"));
		t1_col_plan_title.setCellValueFactory(new PropertyValueFactory<ScheduleMovieVo, String>("scd_mov"));
		t1_col_acc_name.setCellValueFactory(new PropertyValueFactory<ScheduleMovieVo, String>("acc_name"));
		t1_col_scd_scr.setCellValueFactory(new PropertyValueFactory<ScheduleMovieVo, String>("scd_scr"));
		t1_col_scd_sdate.setCellValueFactory(new PropertyValueFactory<ScheduleMovieVo, String>("scd_sdate"));
		t1_col_scd_edate.setCellValueFactory(new PropertyValueFactory<ScheduleMovieVo, String>("scd_edate"));
	} //searchAllEmp()
}
