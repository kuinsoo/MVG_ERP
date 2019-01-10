package material.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import material.service.IMaterialService;
import material.service.MaterialService;
import material.vo.BuyerVo;
import material.vo.MaterialCateVo;
import material.vo.MaterialVo;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;

public class MatEnrollmentController2 {

	IMaterialService houseService ;


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label form_mat_price;

	@FXML
	private Button form_no;

	@FXML
	private DatePicker form_tf_mat_date;

	@FXML
	private TextField form_tf_mat_uprice;

	@FXML
	private Button form_ok;

	@FXML
	private Label form_mat_qty;

	@FXML
	private TextField form_tf_mat_qty;

	@FXML
	private TextField form_tf_mat_price;

	@FXML
	private Label form_mat_uprice;

	@FXML
	private ComboBox<BuyerVo> form_tf_buyer_name;

	@FXML
	private ComboBox<MaterialCateVo> form_cd_mat_metc;

	@FXML
	private Label form_mat_date1;

	@FXML
	private Label form_mat_metc;

	@FXML
	private Label form_buyer_name;

	@FXML
	private Label form_mat_date;

	@FXML
	private TextField form_tf_mat_name;

	@FXML
	private Label form_mat_name;

	@FXML
	private TextField form_tf_mat_Remarks;

	ObservableList<MaterialCateVo> matcList;
	ObservableList<BuyerVo> buyerList;


	/**
	 * 
	 *@Method Name : ok
	 *@date : 2018. 9. 19
	 *@author : JeeSeon
	 *@Method 설명 : 물품 등록 등록폼 입력
	 *@param event
	 */
	 @FXML
	 void ok(ActionEvent event) {
		 MaterialVo materialVo = new MaterialVo();
		 System.out.println(Codemaker.mat_Code());

		 MaterialCateVo item = form_cd_mat_metc.getSelectionModel().getSelectedItem();
		 BuyerVo item2 = form_tf_buyer_name.getSelectionModel().getSelectedItem();

		 materialVo.setMat_metc(item.getMatc_code());
		 materialVo.setMat_code(Codemaker.mat_Code());			// 자재 코드 자동 생성
		 materialVo.setMat_name(form_tf_mat_name.getText());
		 materialVo.setMat_buyer(item2.getBuyer_code());
		 materialVo.setMat_qty(Integer.parseInt(form_tf_mat_qty.getText())); 		//Integer.parseInt int변환 
		 materialVo.setMat_price(Integer.parseInt(form_tf_mat_price.getText())); 	//Integer.parseInt int변환 
		 materialVo.setMat_uprice(Integer.parseInt(form_tf_mat_uprice.getText()));	//Integer.parseInt int변환 
		 materialVo.setMat_date(form_tf_mat_date.getValue().toString());
		 materialVo.setMat_note(form_tf_mat_Remarks.getText());

		 int resutl = houseService.insertMatAdd(materialVo);
		 if(resutl <= 0) {
			 AlertWindow.FailedAlert((Stage)form_ok.getScene().getWindow());
		 } else {
			 AlertWindow.SucceedAlert((Stage)form_ok.getScene().getWindow());
		 }
		 
		 Stage stage = (Stage) form_ok.getScene().getWindow();
			stage.close();
	 }

	 /**
	  * 
	  *@Method Name : no
	  *@date : 2018. 9. 19
	  *@author : JeeSeon
	  *@Method 설명 : 입고 등록시 등록폼 취소버튼 :  취소버튼 클릭시 창닫힘
	  *@param event
	  */
	 @FXML
	 void no(ActionEvent event) {
		 Stage thisStage = (Stage)form_no.getScene().getWindow();
		 thisStage.close();
	 }
	 @FXML
	 void initialize() {
		 assert form_mat_price != null : "fx:id=\"form_mat_price\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_no != null : "fx:id=\"form_no\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_mat_date != null : "fx:id=\"form_tf_mat_date\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_mat_uprice != null : "fx:id=\"form_tf_mat_uprice\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_ok != null : "fx:id=\"form_ok\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_mat_qty != null : "fx:id=\"form_mat_qty\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_mat_qty != null : "fx:id=\"form_tf_mat_qty\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_mat_price != null : "fx:id=\"form_tf_mat_price\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_mat_uprice != null : "fx:id=\"form_mat_uprice\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_buyer_name != null : "fx:id=\"form_tf_buyer_name\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_cd_mat_metc != null : "fx:id=\"form_cd_mat_metc\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_mat_date1 != null : "fx:id=\"form_mat_date1\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_mat_metc != null : "fx:id=\"form_mat_metc\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_buyer_name != null : "fx:id=\"form_buyer_name\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_mat_date != null : "fx:id=\"form_mat_date\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_mat_name != null : "fx:id=\"form_tf_mat_name\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_mat_name != null : "fx:id=\"form_mat_name\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";
		 assert form_tf_mat_Remarks != null : "fx:id=\"form_tf_mat_Remarks\" was not injected: check your FXML file 'MatEnrollmentRes2.fxml'.";


		 /**
		  * 
		  *@Method 
		  *@date : 2018. 9. 18.
		  *@author : JeeSeon
		  *@Method 설명 : 입고 등록시 등록폼 콤보박스처리 
		  *@param 
		  */
		 houseService = MaterialService.getInstance();
		 List<MaterialCateVo> matList = houseService.matClassificationCode();
		 List<BuyerVo> buyList = houseService.matAccountCode();

		 // 물품만 받아오기 
		 List<MaterialCateVo> tList = new ArrayList<MaterialCateVo>() ;
		 for (MaterialCateVo matVo : matList) {
			 if(matVo.getMatc_code().substring(0, 3).equals("atc")) {
				 tList.add(matVo);
			 };

		 }

		 matcList = FXCollections.observableArrayList(tList);
		 form_cd_mat_metc.setItems(matcList);

		 buyerList = FXCollections.observableArrayList(buyList);
		 form_tf_buyer_name.setItems(buyerList);

		 // 자재분류코드 화면에 나타나는 셀의 내용만 변경한다.
		 form_cd_mat_metc.setCellFactory(
				 new Callback<ListView<MaterialCateVo>, ListCell<MaterialCateVo>>() {

					 @Override
					 public ListCell<MaterialCateVo> call(ListView<MaterialCateVo> param) {

						 return new ListCell<MaterialCateVo>() {
							 protected void updateItem(MaterialCateVo item, boolean empty) {
								 super.updateItem(item, empty);
								 if(item==null || empty) {
									 setText(null);
								 }else {
									 setText(item.getMatc_name());
								 }
							 }; 
						 };
					 }
				 }
				 );

		 // 자재분류코드 에서 콤보박스 항목선택시 선택된내용이 보여지는 버튼 영역의 내용변경 
		 form_cd_mat_metc.setButtonCell(
				 new ListCell<MaterialCateVo>() {
					 protected void updateItem(MaterialCateVo item, boolean empty) {
						 super.updateItem(item, empty);
						 if(empty) {
							 setText(null);
						 }else {
							 setText(item.getMatc_name());
						 }
					 }; 
				 }
				 );

		 // 거래처 화면에 나타나는 셀의 내용만 변경한다.
		 form_tf_buyer_name.setCellFactory(
				 new Callback<ListView<BuyerVo>, ListCell<BuyerVo>>() {

					 @Override
					 public ListCell<BuyerVo> call(ListView<BuyerVo> param) {

						 return new ListCell<BuyerVo>() {
							 protected void updateItem(BuyerVo item, boolean empty) {
								 super.updateItem(item, empty);
								 if(item==null || empty) {
									 setText(null);
								 }else {
									 setText(item.getBuyer_name());
								 }
							 }; 
						 };
					 }
				 }
				 );

		 // 거래처 에서 콤보박스 항목선택시 선택된내용이 보여지는 버튼 영역의 내용변경 
		 form_tf_buyer_name.setButtonCell(
				 new ListCell<BuyerVo>() {
					 protected void updateItem(BuyerVo item, boolean empty) {
						 super.updateItem(item, empty);
						 if(empty) {
							 setText(null);
						 }else {
							 setText(item.getBuyer_name());
						 }
					 }; 
				 }
				 );

	 }
}
