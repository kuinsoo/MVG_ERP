package systemAdministration.controller;

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
import staticMethod.windowOptions.WindowOpstions;

/**
 * 외주관리부 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class SysController {

	private TreeItem<String> rootItem;
	private TreeItem<String> item1;

	private TreeItem<String> item2;
	private TreeItem<String> item2_1;
	private TreeItem<String> item2_2;
	private TreeItem<String> item2_3;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private BorderPane thisRoot;

    @FXML
    private ImageView img_logout;

    @FXML
    private ImageView img_exit;

    @FXML
    private TreeView<String> treeView1;

    @FXML
	void click_img_logout(MouseEvent event) {
		/* 로그아웃 기능 */
		Stage stage = (Stage) img_logout.getScene().getWindow();
		WindowOpstions.windowLogout(stage);
	}

	@FXML
	void click_img_exit(MouseEvent event) {
		/* 종료 기능 */
		Platform.exit();
	}

    @FXML
    void click_treeView1(MouseEvent event) {
    	if(treeView1.getSelectionModel().getSelectedItem() == null) {
//			AlertWindow.errorAlert("오류", "서버 오류 입니다.");
//			return;
		}else {
			// 트리뷰에서 선택한 메뉴 값 가져오기
			String selectTree = treeView1.getSelectionModel().getSelectedItem().getValue();

			System.out.println(selectTree);

			switch (selectTree) {

			case "코드신청서관리":
				changeCenter("../fxml/Sys_cod.fxml");
				break;

			case "부서별관리":
				break;

			case "인사관리부":
				changeCenter("../fxml/Sys_hr.fxml");
				break;

			case "외주관리부":
				changeCenter("../fxml/Sys_out.fxml");
				break;

			case "생산관리부":
				changeCenter("../fxml/Sys_def.fxml");
				break;
			default :
				return;
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
			e.printStackTrace();
			System.out.println("changeCenter Method " + e);
		} 
	}


    @FXML
    void initialize() {
        assert img_logout != null : "fx:id=\"img_logout\" was not injected: check your FXML file 'Sys.fxml'.";
        assert img_exit != null : "fx:id=\"img_exit\" was not injected: check your FXML file 'Sys.fxml'.";
        assert treeView1 != null : "fx:id=\"treeView1\" was not injected: check your FXML file 'Sys.fxml'.";

		//좌측 트리뷰
		leftBar();

		/* 쓰레드 충돌 방지 */
		/* 첫 페이지의 tap */
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				changeCenter("../fxml/Sys_cod.fxml");
			}
		});
	}

    /**
	 *@Method Name : leftBar
	 *@date : 2018. 9. 19.
	 *@author : Sohyoung
	 *@Method 설명 : 좌측 메뉴를 위한 treeView
	 */
	public void leftBar(){
		rootItem = new TreeItem<String> (""); // ("InBox", rootICon);
		item1 = new TreeItem<String> ("코드신청서관리");

		item2 = new TreeItem<String> ("부서별관리");
		item2_1 = new TreeItem<String> ("인사관리부");
		item2_2 = new TreeItem<String> ("외주관리부");
		item2_3 = new TreeItem<String> ("생산관리부");
		item2.getChildren().addAll(item2_1, item2_2, item2_3);

		rootItem.getChildren().addAll(item1, item2);
		treeView1.setRoot(rootItem);
		treeView1.setShowRoot(false);
	}

}
