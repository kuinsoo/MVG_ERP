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
import production.vo.ProductionMachineVO;
import staticMethod.alert.AlertWindow;

/**
 * 생산관리부 매출관리
 * @author Sohyoung
 * @since 2018.09.09
 */
public class DeptDef_equipController {

	private IProductionService service = ProductionService.getInstance();

	Parent rooty;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button t1_btn_search;

	@FXML
	private Button t1_btn_delete;

	@FXML
	private TableColumn<ProductionMachineVO, Boolean> t1_chk;

	@FXML
	private TableColumn<ProductionMachineVO, Integer> t1_machQtyCol;


	@FXML
	private ImageView btnCommon;

	@FXML
	private TextField t1_tf;

	@FXML
	private DatePicker td_date;


	@FXML
	private TableColumn<ProductionMachineVO, String> t1_machDateCol;

	@FXML
	private TableView<ProductionMachineVO> table1;

	@FXML
	private Button t1_btn_submit;

	@FXML
	private TableColumn<ProductionMachineVO, String> t1_machCodeCol;

	@FXML
	private TableColumn<ProductionMachineVO, String> t1_machNameCol;

	@FXML
	private ComboBox<String> t1_cb;

	@FXML
	private TableColumn<ProductionMachineVO, String> t1_machManageCol;

	@FXML
	private TableColumn<ProductionMachineVO, String> t1_machBuyerCol;


	@FXML
	void t1_click_search(ActionEvent event) {
		if(t1_cb.getSelectionModel().getSelectedItem() == null || t1_tf.getText() == null) {
			List<ProductionMachineVO> machineList = service.getProductionMachine();
			ObservableList<ProductionMachineVO> obMachineList = FXCollections.observableArrayList(machineList);
			table1.setItems(obMachineList);
		}else {
			if(t1_cb.getSelectionModel().getSelectedItem().equals("기기명")) {
				List<ProductionMachineVO> machVOList = service.selectMachineNameList(t1_tf.getText());
				ObservableList<ProductionMachineVO> obMachList = FXCollections.observableArrayList(machVOList);
				table1.setItems(obMachList);
			}else if(t1_cb.getSelectionModel().getSelectedItem().equals("입고날짜")) {
				if(td_date.getValue() == null) {
					List<ProductionMachineVO> machineList = service.getProductionMachine();
					ObservableList<ProductionMachineVO> obMachineList = FXCollections.observableArrayList(machineList);
					table1.setItems(obMachineList);
				}else {
					List<ProductionMachineVO> machVOList = service.selectMachineDateList(td_date.getValue().toString());
					ObservableList<ProductionMachineVO> obMachList = FXCollections.observableArrayList(machVOList);
					table1.setItems(obMachList);
				}

			}else if(t1_cb.getSelectionModel().getSelectedItem().equals("거래처")) {
				List<ProductionMachineVO> machVOList = service.selectMachineBuyer(t1_tf.getText());
				ObservableList<ProductionMachineVO> obMachList = FXCollections.observableArrayList(machVOList);
				table1.setItems(obMachList);
			}
		}

	}

	@FXML
	void t1_click_submit(ActionEvent event) {
		try {
			Stage stage = new Stage();
			rooty = FXMLLoader.load(getClass().getResource("../../production/fxml/MachineSubmit2.fxml"));
			Scene scene = new Scene(rooty);

			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.showAndWait();

			List<ProductionMachineVO> machineList = service.getProductionMachine();
			ObservableList<ProductionMachineVO> obMachineList = FXCollections.observableArrayList(machineList);
			table1.setItems(obMachineList);


		}catch (IOException e) {
			//			System.out.println(" DeptDef_equipController MachineSubmit2 => " + e);
			e.printStackTrace();
		}

	}

	@FXML
	void t1_click_delete(ActionEvent event) {
		List<ProductionMachineVO> prodMachine = service.getProductionMachine();
		List<String> tempList = new ArrayList<>();
		prodMachine = table1.getItems();
		int cnt = 0;

		for(ProductionMachineVO machVo  : prodMachine) {
			if(machVo.getChk().isSelected()) {
				System.out.println(machVo.getMach_code());
				tempList.add(machVo.getMach_code());
			}
		}

		if(tempList.size() <=0) {
			AlertWindow.FailedAlert((Stage)t1_btn_delete.getScene().getWindow());
		}else {
			// 삭제하는 메서드 넘겨줘
			cnt = service.deleteMachine(tempList);

			if(cnt > 0) {
				AlertWindow.SucceedAlert((Stage)t1_btn_delete.getScene().getWindow());
			}else {
				AlertWindow.FailedAlert((Stage)t1_btn_delete.getScene().getWindow());
			}
			List<ProductionMachineVO> machineList = service.getProductionMachine();
			ObservableList<ProductionMachineVO> obMachineList = FXCollections.observableArrayList(machineList);
			table1.setItems(obMachineList);
		}

	}


	@FXML
	void initialize() {
		assert t1_btn_search != null : "fx:id=\"t1_btn_search\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_btn_delete != null : "fx:id=\"t1_btn_delete\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_machQtyCol != null : "fx:id=\"t1_machQtyCol\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_machBuyerCol != null : "fx:id=\"t1_machBuyerCol\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert btnCommon != null : "fx:id=\"btnCommon\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_tf != null : "fx:id=\"t1_tf\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_machDateCol != null : "fx:id=\"t1_machDateCol\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert table1 != null : "fx:id=\"table1\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_btn_submit != null : "fx:id=\"t1_btn_submit\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_machCodeCol != null : "fx:id=\"t1_machCodeCol\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_machNameCol != null : "fx:id=\"t1_machNameCol\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_cb != null : "fx:id=\"t1_cb\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert t1_machManageCol != null : "fx:id=\"t1_machManageCol\" was not injected: check your FXML file 'DeptDef_equip.fxml'.";
		assert td_date != null : "fx:id=\"td_date\" was not injected: check your FXML file 'DeptDef_equip2.fxml'.";


		//검색용 콤보박스 종류별
		t1_cb.getItems().addAll("기기명", "입고날짜", "거래처");


		machineList();
		updateList();

		List<ProductionMachineVO> machineList = service.getProductionMachine();
		ObservableList<ProductionMachineVO> obMachineList = FXCollections.observableArrayList(machineList);
		table1.setItems(obMachineList);


		t1_cb.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(t1_cb.getSelectionModel().getSelectedItem().equals("입고날짜")) {
					td_date.setVisible(true);
				}else {
					td_date.setVisible(false);
				}
			}
		});
	}

	public void machineList() {

		t1_chk.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, Boolean>("chk"));
		t1_machCodeCol.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, String>("mach_code"));
		t1_machNameCol.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, String>("mach_name"));
		t1_machDateCol.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, String>("mach_date"));
		t1_machBuyerCol.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, String>("mach_buyer"));
		t1_machQtyCol.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, Integer>("mach_qty"));
		t1_machManageCol.setCellValueFactory(new PropertyValueFactory<ProductionMachineVO, String>("mach_writer"));
	}

	public void updateList() {
		
		table1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				//수정 폼이 떠야되 기존 리스트에 있던 내용 띄워주고 각 코드들은 수정 못하게 Editable false로 막아주고
				// 나머지는 수정 사항 적으면  수정 버튼 눌렀을 때  수정해!!
				if(table1.getSelectionModel()==null) {
					
				}
				if(event.getClickCount() > 1) {
					if(table1.getSelectionModel().getSelectedItem()==null) {
						
					}

					try {

						Stage stage = new Stage();
						FXMLLoader loader  = new FXMLLoader(getClass().getResource("../../production/fxml/MahcineUpdate.fxml"));
						Parent root = loader.load();

						MachineUpdateController update = loader.getController();


						ProductionMachineVO machineVO = table1.getSelectionModel().getSelectedItem();
						update.updateMahcine(machineVO);


						//					BorderPane root = (BorderPane)exit.getScene().getRoot();
						Scene scene = new Scene(root);
						//			root.getChildren().clear();
						//			root.getChildren().add(rooty);

						stage.setScene(scene);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.showAndWait();

						List<ProductionMachineVO> machineList = service.getProductionMachine();
						ObservableList<ProductionMachineVO> obMachineList = FXCollections.observableArrayList(machineList);
						table1.setItems(obMachineList);


					}catch (IOException e) {
						//			System.out.println(" DeptDef_equipController MachineSubmit2 => " + e);
						e.printStackTrace();
					}
				}

			}
		});

	}


}
