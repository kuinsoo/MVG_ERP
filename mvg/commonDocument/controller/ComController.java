package commonDocument.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import staticMethod.alert.AlertWindow;

/**
 * 물품구매 신청서 page
 * @author Sohyoung
 * @since 2018.09.07
 */
public class ComController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private BorderPane thisRoot;

	@FXML
	private ImageView img_exit;

	@FXML
	private TreeView<String> treeView1;

	@FXML
	void click_img_exit(MouseEvent event) {
		Stage thisStage = (Stage)img_exit.getScene().getWindow();
		thisStage.close();
	}

	@FXML
	void click_treeView1(MouseEvent event) {
		if(treeView1.getSelectionModel().getSelectedItem() == null) {
			AlertWindow.errorAlert("오류", "서버 오류 입니다.");
			return;
		}else {
			// 트리뷰에서 선택한 메뉴 값 가져오기
			String selectTree = treeView1.getSelectionModel().getSelectedItem().getValue();

			System.out.println(selectTree);

			switch (selectTree) {

			case "물품구매신청서":
				changeCenter("../fxml/Com_prod.fxml");
				break;

			case "자재구매신청서":
				changeCenter("../fxml/Com_mat.fxml");
				break;

			case "자재출고증":
				// 로그인 한 사람이 생산부일 경우에만 사용 가능한 항목
//				if(아이디의 부서코드가 생산부일 경우) {
//					입장 가능
//				}else {
//					입장 불가
//				}
				changeCenter("../fxml/Com_reles.fxml");
				break;

			case "근태신청서":
				changeCenter("../fxml/Com_atten.fxml");
				break;

			case "코드신청서":
				changeCenter("../fxml/Com_cod.fxml");
				break;

			default:
				AlertWindow.errorAlert("오류", "서버 오류 입니다.");
				break;
			}
		} //else 
	}

	/**
	 *@Method Name : changeCenter
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : tap만 바꾸는 행위
	 *@param urlCenterFxml 바꾸고자 하는 화면 fxml
	 */
	public void changeCenter(String urlCenterFxml) {
		try {
			BorderPane tPane =  (BorderPane)thisRoot.getScene().getRoot(); 				// border pane 을 루트로 잡아준다.
			FXMLLoader loder = new FXMLLoader(getClass().getResource(urlCenterFxml));	// 센터 fxml 주소
			Parent retireP =loder.load();
			tPane.setCenter(retireP);	// Border Pane 에 Center을 셋팅한다.

		} catch (Exception e) {
			System.out.println("changeCenter Method " + e);
		} 
	}

	@FXML
	void initialize() {
		assert thisRoot != null : "fx:id=\"thisRoot\" was not injected: check your FXML file 'Com.fxml'.";
		assert img_exit != null : "fx:id=\"img_exit\" was not injected: check your FXML file 'Com.fxml'.";
		assert treeView1 != null : "fx:id=\"treeView1\" was not injected: check your FXML file 'Com.fxml'.";

		// 좌측 메뉴
		leftBar();

		/* 쓰레드 충돌 방지 */
		/* 첫 페이지의 tap */
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				changeCenter("../fxml/Com_prod.fxml");
			}
		});
		
	}

	/**
	 *@Method Name : leftBar
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 좌측 메뉴를 위한 treeView
	 */
	@SuppressWarnings("unchecked")
	public void leftBar(){

		TreeItem<String> rootItem = new TreeItem<String> (""); // ("InBox", rootICon);
		TreeItem<String> item1 = new TreeItem<String> ("물품구매신청서");
		TreeItem<String> item2 = new TreeItem<String> ("자재구매신청서");
		TreeItem<String> item3 = new TreeItem<String> ("자재출고증");
		TreeItem<String> item4 = new TreeItem<String> ("근태신청서");
		TreeItem<String> item5 = new TreeItem<String> ("코드신청서");

		rootItem.getChildren().addAll(item1, item2, item3, item4, item5);
		treeView1.setRoot(rootItem);
		treeView1.setShowRoot(false);
	}

	


}
