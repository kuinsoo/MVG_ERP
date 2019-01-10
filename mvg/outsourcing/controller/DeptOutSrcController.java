package outsourcing.controller;

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

public class DeptOutSrcController {
	
	TreeItem<String> item1_1;
	TreeItem<String> item1;
	TreeItem<String> item1_2;
	
	TreeItem<String> item2;
	TreeItem<String> item2_1;
	TreeItem<String> item2_2;
	TreeItem<String> item2_3;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane bp_root;

    @FXML
    private ImageView img_chart;

    @FXML
    private ImageView img_common;

    @FXML
    private ImageView img_logOut;

    @FXML
    private ImageView img_exit;

    @FXML
    private TreeView<String> treeView1;

    @FXML
    void click_treeview(MouseEvent event) {
    	
    	/* 트리뷰 탭 설정  */
		if(treeView1.getSelectionModel().getSelectedItem() == null) {
		}else {
			String selectTree = treeView1.getSelectionModel().getSelectedItem().getValue(); // 트리뷰값 받아오기 
            System.out.println(selectTree);
			switch (selectTree) {
			case "기획서 관리":
				changeCenter("../fxml/DeptOutSrcList.fxml");
				break; // 기획서 관리(기획)
			case "상영관 관리":
				changeCenter("../fxml/DeptOutSrcMovie.fxml");
				break; // 상영관 관리
//			case "기획서관리":
//				changeCenter("../fxml/DeptOutSrcSales.fxml"); 
//				break; // 기획서관리(영업)
			case "계약 현황":
				changeCenter("../fxml/DeptOutSrcContract.fxml"); 
				break; // 계약 현황
			case "계약건 수입/지출":
				changeCenter("../fxml/DeptOutSrcImport.fxml"); 
				break; // 계약건 수입/지출 관리
			default:
				break;
			}
		} //else 

    }
    
    @FXML
    void goChart(MouseEvent event) {
    	/* 차트로 이동 */
		WindowOpstions.windowChart();
    }

    @FXML
    void goCommon(MouseEvent event) {
    	/* 공통문서로 이동 */
		WindowOpstions.windowCommDoc();
    }

    @FXML
    void goExit(MouseEvent event) {
    	Platform.exit();
    }

    @FXML
    void goLogOut(MouseEvent event) {
    	/* 로그아웃 기능 */
		Stage stage = (Stage) img_logOut.getScene().getWindow();
		WindowOpstions.windowLogout(stage);
    }

    @FXML
    void initialize() {
        assert bp_root != null : "fx:id=\"bp_root\" was not injected: check your FXML file 'DeptOutSrc.fxml'.";
        assert img_chart != null : "fx:id=\"img_chart\" was not injected: check your FXML file 'DeptOutSrc.fxml'.";
        assert img_common != null : "fx:id=\"img_common\" was not injected: check your FXML file 'DeptOutSrc.fxml'.";
        assert img_logOut != null : "fx:id=\"img_logOut\" was not injected: check your FXML file 'DeptOutSrc.fxml'.";
        assert img_exit != null : "fx:id=\"img_exit\" was not injected: check your FXML file 'DeptOutSrc.fxml'.";
        assert treeView1 != null : "fx:id=\"treeView1\" was not injected: check your FXML file 'DeptOutSrc.fxml'.";
        
        leftBar(); // leftBar메서드
        
        /* 쓰레드 충돌 방지 */
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				changeCenter("../fxml/DeptOutSrcList.fxml"); // 기획서 관리 로드 시킴.
			}
		});

    }
    
    @SuppressWarnings("unchecked")
	public void leftBar(){
  		TreeItem<String> rootItem;
  		rootItem = new TreeItem<String> (""); 
  		
  		item1 = new TreeItem<String> ("기획관리");
  		item1_1 = new TreeItem<String> ("기획서 관리");
  		item1_2 = new TreeItem<String> ("상영관 관리");
  		item1.getChildren().addAll(item1_1, item1_2);

  		item2 = new TreeItem<String> ("영업관리");
//  		item2_1 = new TreeItem<String> ("기획서관리");
  		item2_2 = new TreeItem<String> ("계약 현황");
  		item2_3 = new TreeItem<String> ("계약건 수입/지출");
  		item2.getChildren().addAll(item2_2, item2_3);

  		rootItem.getChildren().addAll(item1, item2);
  		treeView1.setRoot(rootItem);
  		treeView1.setShowRoot(false);
  	}
    
    /**
	 *@Method Name : changeCenter
	 *@date : 2018. 9. 19.
	 *@author : PDJ
	 *@Method 설명 : 센터만 교체해준다
	 *@param urlCenterFxml
	 */
	public void changeCenter(String urlCenterFxml) {
		try {
			BorderPane tPane =  (BorderPane)bp_root.getScene().getRoot(); // border pane 을 루트로 잡아준다.
            FXMLLoader loder = new FXMLLoader(getClass().getResource(urlCenterFxml));// 센터 fxml 주소
			Parent retireP =loder.load();
			tPane.setCenter(retireP);	// Border Pane 에 Center을 셋팅한다.
			
		} catch (Exception e) {
			System.out.println("changeCenter Method " + e);
		} 
	}
	
}