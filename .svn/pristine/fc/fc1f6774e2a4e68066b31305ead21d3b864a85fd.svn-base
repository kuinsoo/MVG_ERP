package outsourcing.controller;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import outsourcing.service.IOutsourcingService;
import outsourcing.service.OutsourcingService;
import outsourcing.vo.SchedulePlanVo;


public class DeptOutSrcScheduleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane t1_tp_main;

    @FXML
    private AnchorPane t1_pane;

    @FXML
    private Tab t1;


    @FXML
    void initialize() {
        assert t1_tp_main != null : "fx:id=\"t1_tp_main\" was not injected: check your FXML file 'DeptOutSrcSchedule.fxml'.";
        assert t1_pane != null : "fx:id=\"t1_pane\" was not injected: check your FXML file 'DeptOutSrcSchedule.fxml'.";
        assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file 'DeptOutSrcSchedule.fxml'.";




		fullCalendarView(YearMonth.now());	 	//달려 셋팅
		t1_pane.getChildren().add(getView()); 	// 달력 출력


	}
    
	private ArrayList<SchedulePlanVo> allCalendarDays = new ArrayList<>(35);
	private VBox view;
	private Text calendarTitle;
	private YearMonth currentYearMonth;
	private IOutsourcingService service = OutsourcingService.getInstance();
	/**
	 * Create a calendar view
	 * @param yearMonth year month to create the calendar of
	 */
	public void fullCalendarView(YearMonth yearMonth) {
		currentYearMonth = yearMonth;
		// Create the calendar grid pane
		GridPane calendar = new GridPane();
		calendar.setPrefSize(600, 400);
		calendar.setGridLinesVisible(false);
		calendar.setHgap(10);
		calendar.setVgap(10);

		// Create rows and columns with anchor panes for the calendar
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				//            	VBox box = new VBox();
				SchedulePlanVo ap = new SchedulePlanVo();
				ap.setPrefSize(200,200);
				ap.setStyle("-fx-background-radius: 10px;  -fx-background-color : #ffffff; ");
				//                box.setStyle("-fx-background-radius: 10px;  -fx-background-color : #ffffff; ");
				calendar.add(ap,j,i);
				//                ap.setStyle("-fx-background-radius: 10px;  -fx-background-color : #ffffff; -fx-border-color: #ccc; -fx-border-width: 1px;");

				allCalendarDays.add(ap);
			}
		}
		// Days of the week labels
		Text[] dayNames = new Text[]{ new Text("Sunday"), new Text("Monday"), new Text("Tuesday"),
				new Text("Wednesday"), new Text("Thursday"), new Text("Friday"),
				new Text("Saturday") };
		GridPane dayLabels = new GridPane();
		dayLabels.setPrefWidth(600);
		Integer col = 0;
		for (Text txt : dayNames) {
			AnchorPane ap = new AnchorPane();
			ap.setPrefSize(200, 10);
			ap.setTopAnchor(txt, 30.0);
			ap.setBottomAnchor(txt, 5.0);
			ap.setLeftAnchor(txt, 10.0);
			ap.getChildren().add(txt);
			dayLabels.add(ap, col++, 0);
		}
		// Create calendarTitle and buttons to change current month
		calendarTitle = new Text();
		calendarTitle.setStyle("-fx-font-size : 20px;"); 
		Button previousMonth = new Button("<<");
		previousMonth.setStyle("-fx-background-color : #f2f2f2; -fx-font-size:20px ;");
		previousMonth.setOnAction(e -> previousMonth());
		Button nextMonth = new Button(">>");
		nextMonth.setStyle("-fx-background-color : #f2f2f2; -fx-font-size:20px;");
		nextMonth.setOnAction(e -> nextMonth());
		HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
		titleBar.setSpacing(10);
		titleBar.setAlignment(Pos.BASELINE_CENTER);
		// Populate calendar with the appropriate day numbers
		populateCalendar(yearMonth);
		// Create the calendar view
		view = new VBox(titleBar, dayLabels, calendar);
		view.setPadding(new Insets(30,10,10,80));
	}

	/**
	 * Set the days of the calendar to correspond to the appropriate date
	 * @param yearMonth year and month of month to render
	 */
	public void populateCalendar(YearMonth yearMonth) {
		// Get the date we want to start with on the calendar
		List<SchedulePlanVo> schList = service.searchSchPlan();
		LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
		String note = "";
		// Dial back the day until it is SUNDAY (unless the month starts on a sunday)
		while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
			calendarDate = calendarDate.minusDays(1);
		}
		// Populate the calendar with day numbers
		for (SchedulePlanVo ap : allCalendarDays) {
			if (ap.getChildren().size() != 0) {
				ap.getChildren().remove(0);
			}
			//            if(ap.getSchemp_date(){
			//            		for (ScheduleEmpVo scheduleEmpVo : schList) {
			//            		note = scheduleEmpVo.getSchemp_note1();
			//            	}
			//            }

			ap.setOnMouseClicked(new EventHandler<Event>() { // 클릭 이벤트 발생
				@Override
				public void handle(Event event) {
					System.out.println(ap.getSchPlan_date()); 
					Stage updateEmp = new Stage();
					try {
						FXMLLoader loader= new FXMLLoader(getClass().getResource("../fxml/DeptOutSrcScheduleNote1.fxml"));
						updateEmp.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
						updateEmp.initOwner(t1_tp_main.getScene().getWindow());						// 부모창 설정
						Parent pRoot = loader.load();
						DeptOutSrcScheduleNote1Controller formController = loader.getController();
						int year = Integer.parseInt(ap.getSchPlan_date().substring(0,4));
						int month = Integer.parseInt(ap.getSchPlan_date().substring(5,7));
						int day = Integer.parseInt(ap.getSchPlan_date().substring(8,10));

						LocalDate  currentTime = LocalDate.now();
						LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
						formController.SchedulePlanVo(ap , targetTime);
						Scene scene = new Scene(pRoot);							// 새창을 연결
						updateEmp.setScene(scene);								// 스테이지에 새씬을 연결한다.
						updateEmp.showAndWait();										// 열어주세요.
						
						try {
							Stage bp_root = (Stage)t1_tp_main.getScene().getWindow();
							BorderPane tPane =  (BorderPane)bp_root.getScene().getRoot(); // border pane 을 루트로 잡아준다.
							FXMLLoader loder = new FXMLLoader(getClass().getResource("../fxml/DeptOutSrcSchedule.fxml"));// 센터 fxml 주소
							Parent retireP =loder.load();
							tPane.setCenter(retireP);	// Border Pane 에 Center을 셋팅한다.
						} catch (Exception e) {
							System.out.println("changeCenter Method " + e);
						} 
						
					} catch (IOException e) {
						System.out.println("Hr_scheduleController(populateCalendar)" + e);
					}
					
				}
			});
			ap.setSchPlan_date(calendarDate.toString());
			VBox vBox = new VBox();
			Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
			Text txt2 = new Text();


			try {
				for (SchedulePlanVo schVo : schList) {
					if  (ap.getSchPlan_date().equals(schVo.getSchPlan_date())) {
						ap.setSchPlan_note1(schVo.getSchPlan_note1());
						ap.setSchPlan_note2(schVo.getSchPlan_note2());
						if(schVo.getSchPlan_note1().equals(null)) {
							note = "";
						} 
						else {
							note = "\n" + schVo.getSchPlan_note1();
						}
						//            			note = schVo.getSchemp_note1();
						break;
					}else {
						note = "";	
					}
				}
				txt2.setText(note);
				txt2.setStyle("-fx-fill : red");

			} catch (Exception e) {
				System.out.println("targerno 1" + e);
			}



			//            	if(scheduleEmpVo == null) {
			//            		System.out.println("nulld 입니다.");
			//            	} else if(ap.getSchemp_date().equals(scheduleEmpVo.getSchemp_date()) ) {
			//					System.out.println(scheduleEmpVo.getSchemp_date());
			//					System.out.println(scheduleEmpVo.getSchemp_note1());
			////					ap = scheduleEmpVo;
			//				}
			//			}
			//            ap.setLabel1(new Label());
			//            ap.setLabel2(new Label());
			//             lb.setPrefSize(60, 10 );
			//            ap.getLabel2().setPrefSize(60, 10 );
			//             lb.setStyle("-fx-text-fill: red;");
			//            ap.getLabel2().setStyle("-fx-text-fill: red; -fx-background-color: #ffb630  ");

			ap.setTopAnchor(txt, 5.0);
			ap.setLeftAnchor(txt, 5.0); 
			vBox.getChildren().addAll(txt, txt2);
			//            ap.setLeftAnchor(lb, 7.0);
			//            ap.setTopAnchor(lb, 40.0);
			//            ap.setLeftAnchor(ap.getLabel2(), 7.0);
			ap.getChildren().add(vBox);
			calendarDate = calendarDate.plusDays(1);
			//			System.out.println(ap.getSchemp_date());

		}
		// Change the title of the calendar
		calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
	}

	/**
	 * Move the month back by one. Repopulate the calendar with the correct dates.
	 */
	public void previousMonth() {
		currentYearMonth = currentYearMonth.minusMonths(1);
		populateCalendar(currentYearMonth);
	}

	/**
	 * Move the month forward by one. Repopulate the calendar with the correct dates.
	 */
	public void nextMonth() {
		currentYearMonth = currentYearMonth.plusMonths(1);
		populateCalendar(currentYearMonth);
	}

	public VBox getView() {
		return view;
	}

	public ArrayList<SchedulePlanVo> getAllCalendarDays() {
		return allCalendarDays;
	}

	public void setAllCalendarDays(ArrayList<SchedulePlanVo> allCalendarDays) {
		this.allCalendarDays = allCalendarDays;
	}
}