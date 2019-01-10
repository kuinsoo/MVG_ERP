package staticMethod.windowOptions;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowOpstions {
	
	static Stage primaryStage;
	
	/**
	 *@Method Name : windowExit
	 *@date : 2018. 9. 19.
	 *@author : "Mr.KKu"
	 *@Method 설명 : 창 종료
	 */
	public static void windowExit() {
		Platform.exit();
	}
	
	/**
	 *@Method Name : windowLogout
	 *@date : 2018. 9. 19.
	 *@author : "Mr.KKu"
	 *@Method 설명 : 로그아웃  (매개변수 ex   (Stage)객체이름.getScene().getWindow())
	 *@param url
	 */
	public static void windowLogout(Stage url) {
		primaryStage = url;
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(WindowOpstions.class.getResource("../../systemAdministration/fxml/logIn.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			primaryStage.close();
			
		} catch (IOException e) {
			System.out.println("WindowOpstions windowLogout ERROR => " + e);
		}
	}
	
	/**
	 *@Method Name : windowCommDoc
	 *@date : 2018. 9. 21.
	 *@author : Sohyoung
	 *@Method 설명 : 공통문서 페이지를 여는 메서드
	 *@param url 공통문서 페이지
	 */
	public static void windowCommDoc() {
		try {
			// 새 창으로 공통문서를 엽니다
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(WindowOpstions.class.getResource("../../commonDocument/fxml/Com.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			/* 기존에 열려있던 부서 페이지 창은 닫지 않습니다. 				 */
			/* 공통문서 창과 부서 페이지 창을 동시에 띄우고 사용할 수 있도록 합니다. */
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("WindowOpstions windowCommDoc ERROR => " + e);
		}
	}
	
	/**
	 *@Method Name : windowChart
	 *@date : 2018. 9. 27.
	 *@author : Sohyoung
	 *@Method 설명 : 차트 페이지를 여는 메서드
	 *@param url 차트 페이지
	 */
	public static void windowChart() {
		try {
			// 새 창으로 공통문서를 엽니다
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(WindowOpstions.class.getResource("../../commonDocument/fxml/Chart.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			/* 기존에 열려있던 부서 페이지 창은 닫지 않습니다. 				 */
			/* 차트 창과 부서 페이지 창을 동시에 띄우고 사용할 수 있도록 합니다. */
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("WindowOpstions windowChart ERROR => " + e);
		}
	}
	
}
