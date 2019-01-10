package humanResources.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import humanResources.service.EmployeeService;
import humanResources.service.IEmployeeService;
import humanResources.vo.ScheduleEmpVo;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Hr_scheduleController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	public TabPane t1_tp_main;


	@FXML
	public Pane t1_pane;

	@FXML
	void initialize() {
		assert t1_tp_main != null : "fx:id=\"t1_tp_main\" was not injected: check your FXML file 'hr_schedule.fxml'.";
		assert t1_pane != null : "fx:id=\"t1_pane\" was not injected: check your FXML file 'hr_schedule.fxml'.";

		fullCalendarView(YearMonth.now());	 	//달려 셋팅
		t1_pane.getChildren().add(getView()); 	// 달력 출력


	}
	private ArrayList<ScheduleEmpVo> allCalendarDays = new ArrayList<>(35);
	private VBox view;
	private Text calendarTitle;
	private YearMonth currentYearMonth;
	private IEmployeeService service = EmployeeService.getInstance();
	/**
	 * Create a calendar view
	 * @param yearMonth year month to create the calendar of
	 */
	public void fullCalendarView(YearMonth yearMonth) {
		currentYearMonth = yearMonth;
		// Create the calendar grid pane
		GridPane calendar = new GridPane();
		calendar.setPrefSize(550, 380);
		calendar.setGridLinesVisible(false);
		calendar.setHgap(8);
		calendar.setVgap(8);

		// Create rows and columns with anchor panes for the calendar
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				//            	VBox box = new VBox();
				ScheduleEmpVo ap = new ScheduleEmpVo();
				ap.setPrefSize(200,200);
				ap.setStyle("-fx-background-radius: 8px;  -fx-background-color : #dceeef; ");
				//                box.setStyle("-fx-background-radius: 10px;  -fx-background-color : #ffffff; ");
				calendar.add(ap,j,i);
				//                ap.setStyle("-fx-background-radius: 10px;  -fx-background-color : #ffffff; -fx-border-color: #ccc; -fx-border-width: 1px;");

				allCalendarDays.add(ap);
			}
		}
		// Days of the week labels
		Text[] dayNames = new Text[]{ new Text("   Sun"), new Text("   Mon"), 
				new Text("   Tue"),	new Text("   Wed"), new Text("   Thu"), 
				new Text("   Fri"),	new Text("   Sat") };
		GridPane dayLabels = new GridPane();
		dayLabels.setPrefWidth(600);
		Integer col = 0;
		for (Text txt : dayNames) {
			AnchorPane ap = new AnchorPane();
			ap.setPrefSize(200, 10);
			ap.setTopAnchor(txt, 20.0);
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
		view.setPadding(new Insets(30,10,30,80));
	}

	/**
	 * Set the days of the calendar to correspond to the appropriate date
	 * @param yearMonth year and month of month to render
	 */
	public void populateCalendar(YearMonth yearMonth) {
		// Get the date we want to start with on the calendar
		List<ScheduleEmpVo> schList = service.searchSch();
		LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
		String note = "";
		// Dial back the day until it is SUNDAY (unless the month starts on a sunday)
		while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
			calendarDate = calendarDate.minusDays(1);
			
		}
		// Populate the calendar with day numbers
		for (ScheduleEmpVo ap : allCalendarDays) {
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
					System.out.println(ap.getSchemp_date()); 
					Stage updateEmp = new Stage();
					try {
						FXMLLoader loader= new FXMLLoader(getClass().getResource("../fxml/hr_scheduleNote1.fxml"));
						updateEmp.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
						updateEmp.initOwner(t1_tp_main.getScene().getWindow());						// 부모창 설정
						Parent pRoot = loader.load();
						Hr_scheduleNote1Controller formController = loader.getController();
						int year = Integer.parseInt(ap.getSchemp_date().substring(0,4));
						int month = Integer.parseInt(ap.getSchemp_date().substring(5,7));
						int day = Integer.parseInt(ap.getSchemp_date().substring(8,10));

						LocalDate  currentTime = LocalDate.now();
						LocalDate targetTime = currentTime.withYear(year).withMonth(month).withDayOfMonth(day);
						formController.ScheduleEmpVo(ap , targetTime);
						Scene scene = new Scene(pRoot);							// 새창을 연결
						updateEmp.setScene(scene);								// 스테이지에 새씬을 연결한다.
						updateEmp.initStyle(StageStyle.UNDECORATED);
						updateEmp.showAndWait();										// 열어주세요.
						
						try {
							Stage bp_root = (Stage)t1_tp_main.getScene().getWindow();
							BorderPane tPane =  (BorderPane)bp_root.getScene().getRoot(); // border pane 을 루트로 잡아준다.
							FXMLLoader loder = new FXMLLoader(getClass().getResource("../fxml/hr_schedule1.fxml"));// 센터 fxml 주소
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
			ap.setSchemp_date(calendarDate.toString());
			VBox vBox = new VBox();
			Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
			Text txt2 = new Text();


			try {
				for (ScheduleEmpVo schVo : schList) {
					if  (ap.getSchemp_date().equals(schVo.getSchemp_date())) {
						ap.setSchemp_note1(schVo.getSchemp_note1());
						ap.setSchemp_note2(schVo.getSchemp_note2());
						if(schVo.getSchemp_note1().equals(null)) {
							note = "";
						} 
						else {
							note = "\n" + schVo.getSchemp_note1();
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
			
			ap.setTopAnchor(vBox, 5.0);
			ap.setLeftAnchor(vBox, 2.0); 
			vBox.getChildren().addAll(txt, txt2);
			ap.getChildren().add(vBox);
			calendarDate = calendarDate.plusDays(1);

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

	public ArrayList<ScheduleEmpVo> getAllCalendarDays() {
		return allCalendarDays;
	}

	public void setAllCalendarDays(ArrayList<ScheduleEmpVo> allCalendarDays) {
		this.allCalendarDays = allCalendarDays;
	}
}
