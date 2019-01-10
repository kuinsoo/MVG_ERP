package material.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import material.service.IMaterialService;
import material.service.MaterialService;
import material.vo.MaterialMainVo;
import staticMethod.alert.AlertWindow;
import staticMethod.windowOptions.WindowOpstions;

public class HouseController4 {

	private TreeItem<String> rootItem;
	private TreeItem<String> item1; 

	private TreeItem<String> item2;
	
	private IMaterialService houseService ;


	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<MaterialMainVo, String> t1_materialCodeCol;

    @FXML
    private TableColumn<MaterialMainVo, String> t1_materialCodeCol2;

    @FXML
    private Button t1_btn_search;

    @FXML
    private TableColumn<MaterialMainVo, Integer> t1_uprice;

    @FXML
    private Button t1_btn_delete;

    @FXML
    private TableColumn<MaterialMainVo, String> t1_Remarks;

    @FXML
    private TableColumn<MaterialMainVo, String> t1_wearingNameCol;

    @FXML
    private TableColumn<MaterialMainVo, String> t1_dateOfReceiptCol;

    @FXML
    private TreeView<String> treeView1;

    @FXML
    private Button t1_btn_submint;

    @FXML
    private TextField t1_tf;

    @FXML
    private TableColumn<MaterialMainVo, String> t1_accountCol;

    @FXML
    private ImageView logOut11;

    @FXML
    private ImageView exit;

    @FXML
    private TableColumn<MaterialMainVo, Integer> t1_priceCol;

    @FXML
    private TableColumn<MaterialMainVo, Boolean> t1_chk;

    @FXML
    private ComboBox<String> t1_cb;

    @FXML
    private ImageView logOut1;

    @FXML
    private ImageView logOut;

    @FXML
    private TableView<MaterialMainVo> t1_tv;

    @FXML
    private TableColumn<MaterialMainVo, Integer> t1_quantityCol;

    @FXML
    private TabPane tab;
    
    @FXML
    private ImageView chart;
    
    @FXML
    private ImageView com;

    
    /**
	 * 
	 *@Method Name : actSearch
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 물품  관리 콤보박스 및 검색처리
	 *@param event
	 */
    @FXML
    void actSearch(ActionEvent event) {
    	houseService = MaterialService.getInstance();
		Map<String, String> astMap = new HashMap<>();
		if(t1_cb.getValue().toString().equals("분류코드") ) {  // 콤보박스 값을 가져와서 비교하는 부분
			astMap.put("matc_name", t1_tf.getText());
		}else if(t1_cb.getValue().toString().equals("자재코드")){
			astMap.put("mat_code", t1_tf.getText());
		}else if(t1_cb.getValue().toString().equals("물품명")){
			System.out.println(t1_tf.getText());
			astMap.put("mat_name", t1_tf.getText());
		}else if(t1_cb.getValue().toString().equals("거래처")){
			astMap.put("buyer_name", t1_tf.getText());

		}

//		이게 물품명  이건 테스트용 
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("물품명", "연필");
//		map.put("물품명", "공책");
		
		//List<MaterialMainVo> act = houseService.getAct(map);
		List<MaterialMainVo> astList = houseService.getAct(astMap);
		ObservableList<MaterialMainVo> houseVo  = FXCollections.observableArrayList(astList);		
		t1_tv.setItems(houseVo);
    }
    
    /**
	 * 
	 *@Method Name : Modified
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 자재부 리스트 내역 클릭시 수정창 오픈
	 *@param event
	 */
    @FXML
    void Modified(MouseEvent event) {
    	if(event.getClickCount() > 1) {	// 두번 누르면 실행 

			try {
				Stage okStage =  (Stage)tab.getScene().getWindow();
				Stage MatEnrollment = new Stage();						 	
				MatEnrollment.initModality(Modality.APPLICATION_MODAL); 	
				MatEnrollment.initOwner(okStage);	
				System.out.println("들어간다");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/MatModifiedRes3.fxml"));
				Parent proot = loader.load();

				MatModifiedResController3 update = loader.getController();
				MaterialMainVo mat = t1_tv.getSelectionModel().getSelectedItem();

				update.insertToForm(mat);

				System.out.println("갖다온다");
				Scene scene = new Scene(proot);							
				MatEnrollment.setScene(scene);	
				MatEnrollment.initStyle(StageStyle.UNDECORATED);
				MatEnrollment.showAndWait();

				ObservableList<MaterialMainVo> houseVo  = FXCollections.observableArrayList(houseService.getMatArticle());		
				t1_tv.setItems(houseVo);

			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
    }

    
    /**
	 * 
	 *@Method Name : ok
	 *@date : 2018. 9. 20.
	 *@author : JeeSeon
	 *@Method 설명 : 
	 *@param event
	 */
    @FXML
    void ok(ActionEvent event) {
    	try {
			Stage okStage =  (Stage)tab.getScene().getWindow();
			Stage MatEnrollment = new Stage();						 	
			MatEnrollment.initModality(Modality.APPLICATION_MODAL); 	
			MatEnrollment.initOwner(okStage);							
			Parent proot = FXMLLoader.load(getClass().getResource("../fxml/MatEnrollmentRes2.fxml"));  
			Scene scene = new Scene(proot);							
			MatEnrollment.setScene(scene);			
			MatEnrollment.initStyle(StageStyle.UNDECORATED);	// 창 고정 
			MatEnrollment.showAndWait();

			ObservableList<MaterialMainVo> houseVo  = FXCollections.observableArrayList(houseService.getMatArticle());		
			t1_tv.setItems(houseVo);							
		} catch (IOException e) {
			System.out.println(e);
		} 
    	
    }

    
    @FXML
    void wearingDelete(ActionEvent event) {
    	List<MaterialMainVo> matList = houseService.getMatArticle();
		List<String> tempList = new ArrayList<>();
		matList = t1_tv.getItems();
		int cnt = 0;
		for(MaterialMainVo matVo  : matList) {
			if(matVo.getMat_chk().isSelected()) {
				System.out.println(matVo.getMat_code());
				tempList.add(matVo.getMat_code());
			}
		}
		// 삭제하는 메서드 넘겨주는 부분
		cnt = houseService.deleteArticle(tempList);

		if(tempList.size() <= 0) {
			AlertWindow.FailedAlert((Stage)t1_btn_delete.getScene().getWindow());
			
		}else {
			
			if(cnt > 0) {
				AlertWindow.SucceedAlert((Stage)t1_btn_delete.getScene().getWindow());
			}else {
			}
			List<MaterialMainVo> materialList = houseService.getMatArticle();
			ObservableList<MaterialMainVo> matMatList = FXCollections.observableArrayList(materialList);
			t1_tv.setItems(matMatList);
		}

    }
    
    
    @FXML
    void goLogin(MouseEvent event) {
    	/* 로그아웃 기능 */
		Stage stage = (Stage) logOut.getScene().getWindow();
		WindowOpstions.windowLogout(stage);
    }


    /**
	 *@Method Name : goExit
	 *@date : 2018. 9. 6.
	 *@author : Jeeseon
	 *@Method 설명 : 화면이 꺼집니다.
	 *@param event
	 */
	@FXML
	void goExit(MouseEvent event) {
		Platform.exit();
	}
	
	 
	  @FXML
	    void com(MouseEvent event) {
		  /* 공통문서로 이동 */
		  WindowOpstions.windowCommDoc();
	    }

	    @FXML
	    void chart(MouseEvent event) {
	    	/* 차트로 이동 */
			WindowOpstions.windowChart();
		}
	    

    @FXML
    void initialize() {
    	assert com != null : "fx:id=\"com\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_materialCodeCol != null : "fx:id=\"t1_materialCodeCol\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_materialCodeCol2 != null : "fx:id=\"t1_materialCodeCol2\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_uprice != null : "fx:id=\"t1_uprice\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_Remarks != null : "fx:id=\"t1_Remarks\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_wearingNameCol != null : "fx:id=\"t1_wearingNameCol\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_dateOfReceiptCol != null : "fx:id=\"t1_dateOfReceiptCol\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert treeView1 != null : "fx:id=\"treeView1\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_btn_submint != null : "fx:id=\"t1_btn_submint\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_tf != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_accountCol != null : "fx:id=\"t1_accountCol\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert tab != null : "fx:id=\"tab\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_priceCol != null : "fx:id=\"t1_priceCol\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_chk != null : "fx:id=\"t1_chk\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert logOut != null : "fx:id=\"logOut\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert chart != null : "fx:id=\"chart\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_tv != null : "fx:id=\"t1_tv\" was not injected: check your FXML file 'HouseRes4.fxml'.";
        assert t1_quantityCol != null : "fx:id=\"t1_quantityCol\" was not injected: check your FXML file 'HouseRes4.fxml'.";

         
        leftBar();
        matArticleMain();

		EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
			handleMouseClicked(event);
		};
		treeView1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle); 
		
		t1_cb.getItems().addAll("분류코드","자재코드","물품명","거래처");
		t1_cb.getSelectionModel().selectFirst(); // 첫번째값으로 넣어주기 
    }
    
    @SuppressWarnings("unchecked")
	public void leftBar(){

		rootItem = new TreeItem<String> (""); // ("InBox", rootICon);
		item1 = new TreeItem<String> ("자재관리");

		item2 = new TreeItem<String> ("물품관리");

		rootItem.getChildren().addAll(item1, item2);
		treeView1.setRoot(rootItem);
		treeView1.setShowRoot(false);

	}
    
	@SuppressWarnings("rawtypes")
	private void handleMouseClicked(MouseEvent event) {
		Node node = event.getPickResult().getIntersectedNode();
		if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
			String name = (String) ((TreeItem<String>)treeView1.getSelectionModel().getSelectedItem()).getValue();

			/**
			 *@Method Name : handleMouseClicked
			 *@date : 2018. 9. 9.
			 *@author : Jeeseon
			 *@Method 설명 : item1 직원관리 페이지처리
			 *@param event
			 */
			if(name.equals(item1.getValue())) {
				System.out.println(name);

				try {

					Parent login = FXMLLoader.load(getClass().getResource("../fxml/HouseRes1.fxml"));

					BorderPane root = (BorderPane)exit.getScene().getRoot();

					root.getChildren().clear();
					root.getChildren().add(login);

					KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
					KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
					Timeline timeline = new Timeline();
					timeline.getKeyFrames().add(keyFrame);
					timeline.play();


				}catch (IOException e) {
					System.out.println("HouseResController1 handleMouseClicked : HouseRes ERROR => " + e);
				}
			}else if(name.equals(item2.getValue()) ){
				try {
					Parent login = FXMLLoader.load(getClass().getResource("../fxml/HouseRes4.fxml"));

					BorderPane root = (BorderPane)exit.getScene().getRoot();

					root.getChildren().clear();
					root.getChildren().add(login);

					login.setTranslateX(0);  
					login.setTranslateY(0);

					KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
					KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
					Timeline timeline = new Timeline();
					timeline.getKeyFrames().add(keyFrame);
					timeline.play();
				} catch (IOException e) {
					e.printStackTrace();
				}

			
			}
		}
	}
	
	/**
	 *@Method Name : matWearingMain
	 *@date : 2018. 9. 16.
	 *@author : Jeeseon
	 *@Method 설명 : 자재관리 물품메인테이블
	 *@param 
	 */
	private void matArticleMain() {
		houseService = MaterialService.getInstance();
		ObservableList<MaterialMainVo> houseVo  = FXCollections.observableArrayList(houseService.getMatArticle());		
		t1_tv.setItems(houseVo);

		System.out.println(houseVo.toString());

		t1_chk.setCellValueFactory(new PropertyValueFactory<MaterialMainVo, Boolean>("mat_chk"));
		t1_materialCodeCol.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,String>("matc_name"));
		t1_materialCodeCol2.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,String>("mat_code"));
		t1_wearingNameCol.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,String>("mat_name"));
		t1_accountCol.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,String>("buyer_name"));
		t1_quantityCol.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,Integer>("mat_qty"));
		t1_priceCol.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,Integer>("mat_price"));
		t1_uprice.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,Integer>("mat_uprice"));
		t1_dateOfReceiptCol.setCellValueFactory(new PropertyValueFactory<MaterialMainVo, String>("mat_date"));
		t1_Remarks.setCellValueFactory(new PropertyValueFactory<MaterialMainVo,String>("mat_note"));

	}
}
