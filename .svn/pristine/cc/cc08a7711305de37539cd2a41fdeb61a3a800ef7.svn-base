package production.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.DefectiveVO;
import production.vo.ProductionVo;
import production.vo.QualityInspectionVO;
import staticMethod.alert.AlertWindow;

/**
 * 생산관리부 품질관리
 * @author Sohyoung
 * @since 2018.09.09
 */
public class DeptDef_qualController {


	private IProductionService service = ProductionService.getInstance();

	Parent rooty;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private TableColumn<QualityInspectionVO, String> t1_prodCodeCol;

	@FXML
	private TableColumn<QualityInspectionVO, String> t1_qualWriterCol;

	@FXML
	private TableColumn<QualityInspectionVO, Boolean> t1_chkCol;

	@FXML
    private TableColumn<DefectiveVO, Boolean> t2_tf_checkCol;

	@FXML
	private TextField t1_tf;

	@FXML
	private TableColumn<QualityInspectionVO, String> t1_qualDateCol;

	@FXML
	private TableView<DefectiveVO> table2;

	@FXML
	private TableView<QualityInspectionVO> table1;

	@FXML
	private TableColumn<DefectiveVO, String> t2_dprodReasonCol;

	@FXML
	private ComboBox<String> t1_cb;

	@FXML
	private TableColumn<DefectiveVO, String> t2_dprodNameCol;

	@FXML
	private TableColumn<QualityInspectionVO, Integer> t1_qualLevelCol;

	@FXML
	private Button t2_btn_submit;

	@FXML
	private TableColumn<QualityInspectionVO, String> t1_prodNameCol;

	@FXML
	private Button t1_btn_search;

	@FXML
	private TableColumn<DefectiveVO, Integer> t2_qualLevelCol;

	@FXML
	private TextField t2_tf;

	@FXML
	private Button t2_btn_delete;

	@FXML
	private ImageView btnCommon;

	@FXML
	private ImageView exit;

	@FXML
	private Button t1_btn_submit;

	@FXML
	private Button t2_btn_search;



	@FXML
	private TableColumn<DefectiveVO, String> t2_dprodCodeCol;

	@FXML
	private TableColumn<QualityInspectionVO, String> t1_prodDateCol;

	@FXML
	private ComboBox<String> t2_cb;

	@FXML
	private Tab t1;

	@FXML
	private ImageView logOut;

	@FXML
	private Tab t2;

	@FXML
	private ImageView btnChart;

	@FXML
	private TableColumn<DefectiveVO, String> t2_dprodDateCol;

	@FXML
	private TableColumn<DefectiveVO, String> t2_prodCodeCol;

	@FXML
	private DatePicker t2_td_date;

	@FXML
	private DatePicker t1_td_date;

	@FXML
	void t1_click_submit(ActionEvent event) {
		try {

			List<ProductionVo> prodList = service.getAllProd();
			List<ProductionVo> prodTempList = new ArrayList<>();
			boolean check = false;
			//			ObservableList<QualityInspectionVO> obqualList = FXCollections.observableArrayList(table1.getItems());
			List<QualityInspectionVO> obqualList = table1.getItems();
			for(int i = 0; i<prodList.size(); i++) {	
				check = false;
				for(int j = 0; j<obqualList.size(); j++) { 
					if(prodList.get(i).getProd_code().equals(obqualList.get(j).getProd_code())) {
						check = true;
					}
				}
				if(!check) {
					prodTempList.add(prodList.get(i));
				}
			}
			for (ProductionVo prodVOget : prodTempList) {
				System.out.println(prodVOget.getProd_name());
			}
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../production/fxml/QualitySubmit.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			QualitySubmitController submitController = loader.getController(); 

			submitController.submitQuality(prodTempList);

			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();

			List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
			ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
			table1.setItems(obQualList);


		}catch (IOException e) {
			//			System.out.println(" DeptDef_equipController MachineSubmit2 => " + e);
			e.printStackTrace();
		}
	}

	@FXML
	void t1_click_search(ActionEvent event) {
		if(t1_cb.getSelectionModel().getSelectedItem() == null || t1_tf.getText() == null ) {
			List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
			ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
			table1.setItems(obQualList);
		}else {
			if(t1_cb.getSelectionModel().getSelectedItem().equals("상품명")) {
				if(t1_tf.getText()== null) {
					List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
					ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
					table1.setItems(obQualList);
				}else {
					List<QualityInspectionVO> qualList = service.selectQualityNameList(t1_tf.getText());
					ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
					table1.setItems(obQualList);
				}

			}else if(t1_cb.getSelectionModel().getSelectedItem().equals("검사날짜")) {
				if(t1_tf.getText() == null || t1_td_date.getValue() == null){
					//검색 조건 없이도 검색 가능한 수행문
					List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
					ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
					table1.setItems(obQualList);
				}else {
					List<QualityInspectionVO> qualList = service.selectQualityDateList(t1_td_date.getValue().toString());
					ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
					table1.setItems(obQualList);
				}

			}else if(t1_cb.getSelectionModel().getSelectedItem().equals("등급")) {
				if(t1_tf.getText() == null) {
					//검색 조건 없이도 검색 가능한 수행문
					List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
					ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
					table1.setItems(obQualList);
				}else {
					List<QualityInspectionVO> qualList = service.selectQualityLevelList(Integer.parseInt(t1_tf.getText()));
					ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
					table1.setItems(obQualList);
				}
			}
		}
	}

	@FXML
	void t1_click_delete(ActionEvent event) {
		List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
		List<String> tempList = new ArrayList<>();
		qualList = table1.getItems();
		int cnt =0;


		for(QualityInspectionVO qualVO : qualList) {
			if(qualVO.getCheckBox().isSelected()) {
				System.out.println(qualVO.getProd_code());
				tempList.add(qualVO.getProd_code());
			}
		}

		cnt = service.deleteQuality(tempList);

		if(tempList.size() <= 0 ) {
			AlertWindow.FailedAlert((Stage)t1_btn_delete.getScene().getWindow());
		}else {
			if(cnt > 0) {
				AlertWindow.SucceedAlert((Stage)t1_btn_delete.getScene().getWindow());
			}else {
				AlertWindow.FailedAlert((Stage)t1_btn_delete.getScene().getWindow());
			}
		}

		List<QualityInspectionVO> insepctionVO = service.getQuailtyInspecton();
		ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(insepctionVO);
		table1.setItems(obQualList);
	}



	@FXML
	void t2_click_search(ActionEvent event) {
		if(t2_cb.getSelectionModel().getSelectedItem() == null) {
			//검색 조건 없이도 검색 가능한 수행문
			List<DefectiveVO> defectList = service.getDefectiveProduction();
			ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectList);
			table2.setItems(obDefectList);

		}else {
			if(t2_cb.getSelectionModel().getSelectedItem().equals("상품명")) {
				List<DefectiveVO> defectList = service.selectDefectNameList(t2_tf.getText());
				ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectList);
				table2.setItems(obDefectList);

			}else if(t2_cb.getSelectionModel().getSelectedItem().equals("생산날짜")) {
				List<DefectiveVO> defectList = service.selectDefectDateList(t2_td_date.getValue().toString());
				ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectList);
				table2.setItems(obDefectList);

			}else if(t2_cb.getSelectionModel().getSelectedItem().equals("등급")) {
				List<DefectiveVO> defectList = service.selectDefectLevelList(Integer.parseInt(t2_tf.getText()));
				ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectList);
				table2.setItems(obDefectList);

			}
		}

	}

	@FXML
	void t2_click_submit(ActionEvent event) {
		try {
			
			List<ProductionVo> prodList = service.selectProd();
			List<ProductionVo> prodTempList = new ArrayList<>();	
			Boolean check = false;
			
			List<DefectiveVO> obDefectiveVOs = table2.getItems();
			
			for(int i =0 ; i<prodList.size(); i++) {
				check = false;
				for(int j =0; j<obDefectiveVOs.size(); j++) {
					if(prodList.get(i).getProd_code().equals(obDefectiveVOs.get(j).getProd_code())) {
						check = true;
					}
				}
				
				if(!check) {
					prodTempList.add(prodList.get(i));
				}
			}
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../../production/fxml/DefectiveSubmit.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			DefectiveSubmitController controller = loader.getController();
			controller.defectiveList(prodTempList);
			
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();
			List<DefectiveVO> defectiveList = service.getDefectiveProduction();
			ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectiveList);
			table2.setItems(obDefectList);


		}catch (IOException e) {
			//			System.out.println(" DeptDef_equipController MachineSubmit2 => " + e);
			e.printStackTrace();
		}


	}

	@FXML
	void t2_click_delete(ActionEvent event) {

		List<DefectiveVO> defectList = service.getDefectiveProduction();
		List<String> tempList = new ArrayList<>();
		defectList = table2.getItems();

		for(DefectiveVO defectiveVO : defectList) {
			if (defectiveVO.getCheckBox().isSelected()) {
				tempList.add(defectiveVO.getDprod_code());
			}
		}


		if(tempList.size() <= 0 ) {
			AlertWindow.FailedAlert((Stage)t2_btn_delete.getScene().getWindow());
		}else {
			int cnt = service.deleteDefective(tempList);
			if(cnt > 0) {
				AlertWindow.SucceedAlert((Stage)t2_btn_delete.getScene().getWindow());
			}else {
				AlertWindow.FailedAlert((Stage)t2_btn_delete.getScene().getWindow());
			}
		}

		List<DefectiveVO> defectiveList = service.getDefectiveProduction();
		ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectiveList);
		table2.setItems(obDefectList);

	}

	@FXML
	void initialize() {
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_prodCodeCol != null : "fx:id=\"t1_prodCodeCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_qualWriterCol != null : "fx:id=\"t1_qualWriterCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_tf != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_qualDateCol != null : "fx:id=\"t1_qualDateCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert table2 != null : "fx:id=\"table2\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert table1 != null : "fx:id=\"table1\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_dprodReasonCol != null : "fx:id=\"t2_dprodReasonCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_dprodNameCol != null : "fx:id=\"t2_dprodNameCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_qualLevelCol != null : "fx:id=\"t1_qualLevelCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_btn_submit != null : "fx:id=\"t2_btn_submit\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_prodNameCol != null : "fx:id=\"t1_prodNameCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_qualLevelCol != null : "fx:id=\"t2_qualLevelCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_tf != null : "fx:id=\"t2_tf\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_btn_delete != null : "fx:id=\"t2_btn_delete\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert btnCommon != null : "fx:id=\"btnCommon\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_btn_submit != null : "fx:id=\"t1_btn_submit\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_btn_search != null : "fx:id=\"t2_btn_search\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_dprodCodeCol != null : "fx:id=\"t2_dprodCodeCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_prodDateCol != null : "fx:id=\"t1_prodDateCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_cb != null : "fx:id=\"t2_cb\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1 != null : "fx:id=\"t1\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert logOut != null : "fx:id=\"logOut\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2 != null : "fx:id=\"t2\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert btnChart != null : "fx:id=\"btnChart\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_dprodDateCol != null : "fx:id=\"t2_dprodDateCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t2_prodCodeCol != null : "fx:id=\"t2_prodCodeCol\" was not injected: check your FXML file 'DeptDef_qual.fxml'.";
		assert t1_chkCol != null : "fx:id=\"t1_chkCol\" was not injected: check your FXML file 'DeptDef_qual2.fxml'.";
		assert t2_tf_checkCol != null : "fx:id=\"t2_tf_checkCol\" was not injected: check your FXML file 'DeptDef_qual2.fxml'.";
		assert t2_td_date != null : "fx:id=\"t2_td_date\" was not injected: check your FXML file 'DeptDef_qual2.fxml'.";
		assert t1_td_date != null : "fx:id=\"t1_td_date\" was not injected: check your FXML file 'DeptDef_qual2.fxml'.";


		//검색용 콤보박스 종류별
		t1_cb.getItems().addAll("상품명", "검사날짜", "등급");
		t2_cb.getItems().addAll("상품명", "생산날짜", "등급");

		// 품질 검사 리스트 출력
		qualityInspection();

		// 품질 검사 수정폼 띄우는 메서드
		qaulUpdateList();

		//불량 관리 수정폼 띄우는 메서드
		updateDefective();

		t1_cb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(t1_cb.getSelectionModel().getSelectedItem().equals("검사날짜")) {
					t1_td_date.setVisible(true);
				}else {
					t1_td_date.setVisible(false);
				}
			}
		});

		t2_cb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(t2_cb.getSelectionModel().getSelectedItem().equals("생산날짜")) {
					t2_td_date.setVisible(true);
				}else {
					t2_td_date.setVisible(false);
				}
			}
		});
	}

	public void qualityInspection() {

		List<QualityInspectionVO> qualList = service.getQuailtyInspecton();
		List<DefectiveVO> defectiveList = service.getDefectiveProduction();
		ObservableList<QualityInspectionVO> obQualList = FXCollections.observableArrayList(qualList);
		ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectiveList);
		table1.setItems(obQualList);
		table2.setItems(obDefectList);

		t1_prodCodeCol.setCellValueFactory(new PropertyValueFactory<QualityInspectionVO, String>("prod_code"));
		t1_prodNameCol.setCellValueFactory(new PropertyValueFactory<QualityInspectionVO, String>("prod_name"));
		t1_prodDateCol.setCellValueFactory(new PropertyValueFactory<QualityInspectionVO, String>("prod_date"));
		t1_qualDateCol.setCellValueFactory(new PropertyValueFactory<QualityInspectionVO, String>("qual_date"));
		t1_qualLevelCol.setCellValueFactory(new PropertyValueFactory<QualityInspectionVO, Integer>("qual_level"));
		t1_qualWriterCol.setCellValueFactory(new PropertyValueFactory<QualityInspectionVO, String>("qual_write"));

		t2_tf_checkCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, Boolean>("checkBox"));
		t2_dprodCodeCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, String>("dprod_code"));
		t2_prodCodeCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, String>("prod_code"));
		t2_dprodNameCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, String>("prod_name"));
		t2_dprodDateCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, String>("prod_date"));
		t2_dprodReasonCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, String>("dprod_reason"));
		t2_qualLevelCol.setCellValueFactory(new PropertyValueFactory<DefectiveVO, Integer>("qual_level"));


	}

	public void qaulUpdateList() {
		table1.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(table1.getSelectionModel() == null) {

				}
				if(event.getClickCount() > 1) {

					try {
						Stage stage = new Stage();
						FXMLLoader loader  = new FXMLLoader(getClass().getResource("../../production/fxml/QualityUpdate.fxml"));
						Parent root = loader.load();

						QualityUpdateController update = loader.getController();

						QualityInspectionVO qualVo = table1.getSelectionModel().getSelectedItem();
						update.updateQuality(qualVo);

						Scene scene = new Scene(root);

						stage.setScene(scene);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.showAndWait();

						List<QualityInspectionVO> qualityInspection = service.getQuailtyInspecton();
						ObservableList<QualityInspectionVO> obqualList = FXCollections.observableArrayList(qualityInspection);
						table1.setItems(obqualList);


					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("DeptDef_qualController qaulUpdateList() ERROR => " +e );
					}
				}
			}
		});
	}



	public void updateDefective() {
		table2.setOnMouseClicked(new EventHandler<MouseEvent>() {


			@Override
			public void handle(MouseEvent event) {

				if(table2.getSelectionModel()==null) {

				}

				if(event.getClickCount() > 1) {

					try {
						Stage stage = new Stage();
						FXMLLoader loader  = new FXMLLoader(getClass().getResource("../../production/fxml/DefectiveUpdate2.fxml"));
						Parent root = loader.load();

						DefectiveUpdateController update = loader.getController();

						DefectiveVO defectVo = table2.getSelectionModel().getSelectedItem();
						update.updateDefective(defectVo);

						Scene scene = new Scene(root);

						stage.setScene(scene);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.showAndWait();

						List<DefectiveVO> defectiveList = service.getDefectiveProduction();
						ObservableList<DefectiveVO> obDefectList = FXCollections.observableArrayList(defectiveList);
						table2.setItems(obDefectList);


					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("DeptDef_qualController updateDefective() ERROR => " +e );
					}

				}
			}

		});
	}
}




