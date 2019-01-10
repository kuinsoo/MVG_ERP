package material.controller;

import java.net.URL;
import java.time.LocalDate;
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
import material.vo.MaterialMainVo;
import material.vo.MaterialVo;
import staticMethod.alert.AlertWindow;

public class MatModifiedResController3 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<BuyerVo> form_tf_buyer_name;

    @FXML
    private DatePicker form_tf_mat_date;

    @FXML
    private Button form_no;

    @FXML
    private ComboBox<MaterialCateVo> form_cd_mat_metc;

    @FXML
    private TextField form_tf_mat_uprice;

    @FXML
    private Label Label;

    @FXML
    private Button form_ok;

    @FXML
    private TextField form_tf_mat_qty;

    @FXML
    private TextField form_tf_mat_price;

    @FXML
    private TextField form_tf_mat_name;

    @FXML
    private TextField form_tf_mat_Remarks;
    
    
    ObservableList<MaterialCateVo> objMatcList;
    ObservableList<BuyerVo> objBuyerList;
    
    
	private IMaterialService houseService = MaterialService.getInstance();
    private int resutl = 0;
    
    private String mat_code;
    
    // 수정폼 등록클릭시 등록
    @FXML
    void ok(ActionEvent event) {
    	MaterialVo materialVo = new MaterialVo();
    	if(form_cd_mat_metc.getSelectionModel().getSelectedItem() == null) {
    		
    	}else {
    		materialVo.setMat_metc(form_cd_mat_metc.getSelectionModel().getSelectedItem().getMatc_code());
		}
		materialVo.setMat_code(mat_code);
		materialVo.setMat_name(form_tf_mat_name.getText());
		if(form_tf_buyer_name.getSelectionModel().getSelectedItem() == null) {
			
		}else {
			materialVo.setMat_buyer(form_tf_buyer_name.getSelectionModel().getSelectedItem().getBuyer_code());
		}
		materialVo.setMat_price(Integer.parseInt(form_tf_mat_price.getText()));
		materialVo.setMat_qty(Integer.parseInt(form_tf_mat_qty.getText()));
		materialVo.setMat_uprice(Integer.parseInt(form_tf_mat_uprice.getText()));
		System.out.println("mat_uprices" + materialVo.getMat_uprice());
		materialVo.setMat_note(form_tf_mat_Remarks.getText());
		materialVo.setMat_date(form_tf_mat_date.getValue().toString());
		
    	resutl = houseService.articleUpdate(materialVo);
		if(resutl > 0) {
			AlertWindow.SucceedAlert((Stage)form_ok.getScene().getWindow());
			Stage thisStage = (Stage)form_no.getScene().getWindow();
			thisStage.close();
		} else {
			AlertWindow.FailedAlert((Stage)form_ok.getScene().getWindow());
		}
		
		Stage stage = (Stage) form_ok.getScene().getWindow();
		stage.close();
    }

    
    // 수정폼 취소시 창닫힘 
    @FXML
    void no(ActionEvent event) {
    	Stage thisStage = (Stage)form_no.getScene().getWindow();
		thisStage.close();
    }

    @FXML
    void initialize() {
        assert form_tf_buyer_name != null : "fx:id=\"form_tf_buyer_name\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_tf_mat_date != null : "fx:id=\"form_tf_mat_date\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_no != null : "fx:id=\"form_no\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_cd_mat_metc != null : "fx:id=\"form_cd_mat_metc\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_tf_mat_uprice != null : "fx:id=\"form_tf_mat_uprice\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert Label != null : "fx:id=\"Label\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_ok != null : "fx:id=\"form_ok\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_tf_mat_qty != null : "fx:id=\"form_tf_mat_qty\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_tf_mat_price != null : "fx:id=\"form_tf_mat_price\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_tf_mat_name != null : "fx:id=\"form_tf_mat_name\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";
        assert form_tf_mat_Remarks != null : "fx:id=\"form_tf_mat_Remarks\" was not injected: check your FXML file 'MatModifiedRes3.fxml'.";

        
        /**
         * 
         *@Method 
         *@date : 2018. 9. 18.
         *@author : JeeSeon
         *@Method 설명 : 물품 수정폼 콤보박스 처리
         *@param 
         */
		houseService = MaterialService.getInstance();
		List<MaterialCateVo> matList = houseService.matClassificationCode();
		List<BuyerVo> buyList = houseService.matAccountCode();
		 
		List<MaterialCateVo> tList = new ArrayList<MaterialCateVo>() ;
		for (MaterialCateVo matVo : matList) {
			if(matVo.getMatc_code().substring(0, 3).equals("atc")) {
				tList.add(matVo);
			};
			
		}
		
		List<String> tempList = new ArrayList<>();
		for (BuyerVo buyerVo : buyList) {
			tempList.add(buyerVo.getBuyer_name());
		}
		
		objMatcList = FXCollections.observableArrayList(tList);
		form_cd_mat_metc.setItems(objMatcList);
		
		objBuyerList = FXCollections.observableArrayList(buyList);
		form_tf_buyer_name.setItems(objBuyerList);
		
		// 자재분류코드 화면에 나타나는 셀의 내용만 변경한다.
	      form_cd_mat_metc.setCellFactory(
	         new Callback<ListView<MaterialCateVo>, ListCell<MaterialCateVo>>() {
	            
	            @Override
	            public ListCell<MaterialCateVo> call(ListView<MaterialCateVo> param) {
	               
	               return new ListCell<MaterialCateVo>() {
	                  protected void updateItem(MaterialCateVo matList, boolean empty) {
	                     super.updateItem(matList, empty);
	                     if(matList==null || empty) {
	                        setText(null);
	                     }else {
	                        setText(matList.getMatc_name());
	                     }
	                  }; 
	               };
	            }
	         }
	      );
////	      
	      // 자재분류코드 에서 콤보박스 항목선택시 선택된내용이 보여지는 버튼 영역의 내용변경 
	      form_cd_mat_metc.setButtonCell(
	         new ListCell<MaterialCateVo>() {
	            protected void updateItem(MaterialCateVo matList, boolean empty) {
	               super.updateItem(matList, empty);
	               if(empty) {
	                  setText(null);
	               }else {
	                  setText(matList.getMatc_name());
	               }
	               
	            }; 
	         }
	      );
////	      
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
//		      
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
	/**
	 * 
	 *@Method Name : insertToForm
	 *@date : 2018. 9. 18.
	 *@author : JeeSeon
	 *@Method 설명 : 물품 수정시 수정탭 정보불러오기
	 *@param mat
	 */
	public void insertToForm(MaterialMainVo mat) {
		
		  form_cd_mat_metc.setPromptText(mat.getMatc_name());
		  form_tf_buyer_name.setPromptText(mat.getBuyer_name()) ;
	      form_tf_mat_qty.setText(Integer.toString(mat.getMat_qty()));
	      form_tf_mat_price.setText(Integer.toString(mat.getMat_price()));
	      form_tf_mat_name.setText(mat.getMat_name());
	      form_tf_mat_uprice.setText(Integer.toString(mat.getMat_uprice()));
	      form_tf_mat_Remarks.setText(mat.getMat_note());
	      int year = Integer.parseInt(mat.getMat_date().substring(0, 4));
	      int month = Integer.parseInt(mat.getMat_date().substring(5, 7));
	      int day = Integer.parseInt(mat.getMat_date().substring(8, 10));
	      LocalDate currentDate = LocalDate.now();
	      LocalDate targetDate = currentDate.withYear(year).withMonth(month).withDayOfMonth(day);
	      form_tf_mat_date.setValue(targetDate);
	      mat_code = mat.getMat_code();
	   }
}
