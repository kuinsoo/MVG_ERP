package systemAdministration.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyAttenController {

	private int year;
	private int month;
	private int day;
	private int minute;
	private int hour;
	private int second;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label lb_clock;

	@FXML
	private Button btn_attended;

	/**
	 *@Method Name : click_attended
	 *@date : 2018. 9. 13.
	 *@author : Sohyoung
	 *@Method 설명 : 출근 버튼을 눌렀을 때의 액션
	 *@param event
	 */
	@FXML
	void click_attended(ActionEvent event) {
		Stage stage = (Stage) btn_attended.getScene().getWindow();
		stage.close();
	}

	@FXML
	void initialize() {
		assert lb_clock != null : "fx:id=\"clock\" was not injected: check your FXML file 'MyAtten.fxml'.";
		assert btn_attended != null : "fx:id=\"btn_attended\" was not injected: check your FXML file 'MyAtten.fxml'.";

		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> { 
			year = LocalDateTime.now().getYear();
			month = LocalDateTime.now().getMonthValue();
			day = LocalDateTime.now().getDayOfMonth();
			second = LocalDateTime.now().getSecond();
			minute = LocalDateTime.now().getMinute();
			hour = LocalDateTime.now().getHour();
			lb_clock.setText(year +" . "+ month +" . " + day +"\n" +hour + ":" + minute + ":" + second);
			}),
				new KeyFrame(Duration.seconds(1))
		);
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();

	}

//  main창 대신
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("../fxml/MyAtten.fxml"));
//
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.initStyle(StageStyle.UNDECORATED);
//			primaryStage.show();
//
//		} catch (IOException e) {
//			System.out.println("MyAttenController Main ERROR => " + e);
//		}
//
//	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
}
