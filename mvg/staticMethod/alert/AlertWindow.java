package staticMethod.alert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 알람창 메서드 모음
 */
public class AlertWindow {
	
	
	/**
	 *@Method Name : FailedAlert
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@Method 설명 : 에러 fxml 출력
	 *@param primaryStage
	 */
	public static void FailedAlert(Stage primaryStage) {
		try {
			Stage failed = new Stage();						 	// 새로운 스테이지를 하나만든다.
			failed.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
			failed.initOwner(primaryStage);						// 부모창 설정
			Parent proot = FXMLLoader.load(AlertWindow.class.getResource("failed.fxml")); // Error표시를 출력해주는 주소
			Scene scene = new Scene(proot);							// 새창을 연결
			failed.setScene(scene);								// 스테이지에 새씬을 연결한다.
			failed.initStyle(StageStyle.UNDECORATED);
			failed.showAndWait();										// 열어주세요.
		} catch (Exception e) {
			System.out.println("failed Controller" + e);
		}
	}

	/**
	 *@Method Name : SucceedAlert
	 *@date : 2018. 9. 20.
	 *@author : Mr.KKu
	 *@Method 설명 : 단순 성공 창 출력
	 *@param primaryStage
	 */
	public static void SucceedAlert(Stage primaryStage) {
		try {
			Stage succeed = new Stage();						 	// 새로운 스테이지를 하나만든다.
			succeed.initModality(Modality.APPLICATION_MODAL); 	// 모달창 셋팅 
			succeed.initOwner(primaryStage);						// 부모창 설정
			Parent proot = FXMLLoader.load(AlertWindow.class.getResource("succeed.fxml")); // Error표시를 출력해주는 주소
			Scene scene = new Scene(proot);							// 새창을 연결
			succeed.setScene(scene);								// 스테이지에 새씬을 연결한다.
			succeed.initStyle(StageStyle.UNDECORATED);
			succeed.showAndWait();										// 열어주세요.
		} catch (Exception e) {
			System.out.println("succeed Controller" + e);
		}
	}

	/**
	 *@Method Name : errorAlert
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 제목과 메시지를 입력할 수 있는 에러 창
	 *@param header 제목 설정
	 *@param msg 메시지 설정
	 */
	public static void errorAlert(String header, String msg) {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("ERROR");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	/**
	 *@Method Name : infoAlert
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 제목과 메시지를 입력할 수 있는 재확인 창
	 *@param header 제목 설정
	 *@param msg 메시지 설정
	 */
	public static void infoAlert(String header, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("INFORMATION");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
	
	/**
	 *@Method Name : confirmAlert
	 *@date : 2018. 9. 18.
	 *@author : Sohyoung
	 *@Method 설명 : Y / N 창  (ok 버튼 처리를 위해 show()가 없습니다.)
	 *@param header
	 *@param msg
	 */
	public static Alert confirmAlert(String header, String msg) {
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("CONFIRMATION");
		alert.setHeaderText(header);
		alert.setContentText(msg);
		/*		사용 시
			if(confirmAlert("삭제", "정말로 삭제하시겠습니까?").showAndWait().get() == ButtonType.OK) {
			}else{	}
			처리 해주세요~
		 */		
		return alert;
	}



}
