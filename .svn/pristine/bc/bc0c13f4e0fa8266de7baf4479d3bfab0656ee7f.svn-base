package humanResources.controller;

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

public class Hr_empController {

	/* 전역변수 */
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView img_chart;

	@FXML
	public BorderPane bp_root;

	@FXML
	private ImageView img_logout;

	@FXML
	private ImageView img_exit;

	@FXML
	private TreeView<String> treeview;

	@FXML
	private ImageView img_common;

	/**
	 *@Method Name : click_img_logout
	 *@date : 2018. 9. 19.
	 *@author : "Mr.KKu"
	 *@Method 설명 : 로그아웃 마우스 이벤트
	 *@param event 
	 */
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
	void click_img_chart(MouseEvent event) {
		/* 차트로 이동 */
		WindowOpstions.windowChart();
	}

	@FXML
	void click_img_common(MouseEvent event) {
		/* 공통문서로 이동 */
		WindowOpstions.windowCommDoc();
	}

	@FXML
	void click_treeview(MouseEvent event) {
		/* 트리뷰 탭 설정  */
		if(treeview.getSelectionModel().getSelectedItem() == null) {
		}else {
			String selectTree = treeview.getSelectionModel().getSelectedItem().getValue(); // 트리뷰값 받아오기 
			//            System.out.println(selectTree);
			switch (selectTree) {
			case "퇴직자목록":
				changeCenter("../fxml/hr_empRetire.fxml");
				break; // 퇴직자목록
			case "인사카드":
				changeCenter("../fxml/hr_empList.fxml");
				break; //인사카드
			case "출결관리":
				changeCenter("../fxml/hr_attendedEmp.fxml");
				break; //출결관리
			case "교육일정관리":
				changeCenter("../fxml/hr_schedule1.fxml");
				break; //교육일정관리
			case "행사일정관리":
				changeCenter("../fxml/hr_schedule2.fxml");
				break; //행사일정관리
			case "증명서인쇄":
				changeCenter("../fxml/hr_print.fxml");
				break; //요청업무관리
			case "급여내역":
				changeCenter("../fxml/hr_empSalary.fxml");
				break; //급여관리
//			case "Test":
//				changeCenter("../../outsourcing/fxml/DeptOutSrcSchedule.fxml");// 센터 fxml 주소
//					
//				break; //Test
			}
			
			
		} //else 
	}



	@FXML
	void initialize() {
		assert img_chart != null : "fx:id=\"img_chart\" was not injected: check your FXML file 'HumanRes.fxml'.";
		assert bp_root != null : "fx:id=\"bp_root\" was not injected: check your FXML file 'HumanRes.fxml'.";
		assert img_logout != null : "fx:id=\"img_logout\" was not injected: check your FXML file 'HumanRes.fxml'.";
		assert img_exit != null : "fx:id=\"img_exit\" was not injected: check your FXML file 'HumanRes.fxml'.";
		assert treeview != null : "fx:id=\"treeview\" was not injected: check your FXML file 'HumanRes.fxml'.";
		assert img_common != null : "fx:id=\"img_common\" was not injected: check your FXML file 'HumanRes.fxml'.";
		
		treeViewMain();  // 트리뷰 셋팅 함수 설정

		/* 쓰레드 충돌 방지 */
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				changeCenter("../fxml/hr_attendedEmp.fxml"); //기본 출결사항 로드
			}
		});
	}
	

	/**
	 *@Method Name : treeViewMain
	 *@date : 2018. 9. 14.
	 *@author : Mr.KKu
	 *@Method 설명 : 트리뷰를 담당하는 메서드 
	 */
	@SuppressWarnings("unchecked")
	public void treeViewMain() {
		TreeItem<String> rootTree = new TreeItem<String>("인사부서");
		TreeItem<String> tree1 = new TreeItem<String>("직원관리");
		TreeItem<String> tree1_1 = new TreeItem<String>("인사카드");
		TreeItem<String> tree1_2 = new TreeItem<String>("퇴직자목록");
		/* 근태관리 */
		TreeItem<String> tree2 = new TreeItem<String>("근태관리");
		TreeItem<String> tree2_1 = new TreeItem<String>("출결관리");
		/* 급여관리 */
		TreeItem<String> tree3 = new TreeItem<String>("급여관리");
		TreeItem<String> tree3_1 = new TreeItem<String>("급여내역");
		/* 일정관리 */
		TreeItem<String> tree4 = new TreeItem<String>("일정관리");
		TreeItem<String> tree4_1 = new TreeItem<String>("교육일정관리");
		TreeItem<String> tree4_2 = new TreeItem<String>("행사일정관리");
		/* 요청업무관리 */
		TreeItem<String> tree5 = new TreeItem<>("요청업무관리"); 
		TreeItem<String> tree5_1 = new TreeItem<>("증명서인쇄"); 
		
		/* 테스트 관리 */
//		TreeItem<String> treeTest = new TreeItem<>("Test");
		
		
		
		tree1.getChildren().addAll(tree1_1,tree1_2);
		tree2.getChildren().addAll(tree2_1);
		tree3.getChildren().addAll(tree3_1);
		tree4.getChildren().addAll(tree4_1,tree4_2);
		tree5.getChildren().addAll(tree5_1);
		
		rootTree.getChildren().addAll(tree1, tree2, tree3, tree4, tree5);
		treeview.setShowRoot(false);
		treeview.setRoot(rootTree);
	}

	/**
	 *@Method Name : changeCenter
	 *@date : 2018. 9. 19.
	 *@author : "Mr.KKu"
	 *@Method 설명 : 센터만 교체해준다
	 *@param urlCenterFxml
	 */
	public void changeCenter(String urlCenterFxml) {
		try {
			BorderPane tPane =  (BorderPane)bp_root.getScene().getRoot(); // border pane 을 루트로 잡아준다.
//			tPane.setCenter(null);
			FXMLLoader loder = new FXMLLoader(getClass().getResource(urlCenterFxml));// 센터 fxml 주소
			Parent retireP =loder.load();
			tPane.setCenter(retireP);	// Border Pane 에 Center을 셋팅한다.

		} catch (Exception e) {
			System.out.println("changeCenter Method " + e);
		} 
	}

}
