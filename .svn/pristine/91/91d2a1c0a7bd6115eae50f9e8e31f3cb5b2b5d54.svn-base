package material.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import material.service.IMaterialService;
import material.service.MaterialService;
import material.vo.AssistantVo;
import material.vo.BuyerVo;
import material.vo.MaterialCateVo;
import staticMethod.alert.AlertWindow;

public class MatModifiedResController2 {

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
    
    @FXML
    private Label ast_no;

    
    
    ObservableList<MaterialCateVo> objMatcList;
    ObservableList<BuyerVo> objBuyerList;
    
	private IMaterialService houseService = MaterialService.getInstance();
    private int resutl = 0;
    
    private String mat_code;
    
    
    /**
     * 
     *@Method Name : ok
     *@date : 2018. 9. 18.
     *@author : JeeSeon
     *@Method 설명 : 물품 수정시 수정탭 등록
     *@param event
     */
    @FXML
    void ok(ActionEvent event) {
    	AssistantVo assistantVo = new AssistantVo();
    	assistantVo.setAst_no(ast_no.getText());
    	
    	if(form_cd_mat_metc.getSelectionModel().getSelectedItem() == null) {
    		
    	}else {
    		assistantVo.setMat_metc(form_cd_mat_metc.getSelectionModel().getSelectedItem().getMatc_code());
		}
    	assistantVo.setMat_Code(mat_code);
    	assistantVo.setAst_name(form_tf_mat_name.getText());
		if(form_tf_buyer_name.getSelectionModel().getSelectedItem() == null) {
			
		}else {
			assistantVo.setMat_buyer(form_tf_buyer_name.getSelectionModel().getSelectedItem().getBuyer_code());
		}
		assistantVo.setAst_qty(Integer.parseInt(form_tf_mat_qty.getText()));
		assistantVo.setAst_note(form_tf_mat_Remarks.getText());
		assistantVo.setAst_name(form_tf_mat_name.getText());
		assistantVo.setAst_date(form_tf_mat_date.getValue().toString());
    	resutl = houseService.assUpdate(assistantVo);
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

    
    /**
     * 
     *@Method Name : no
     *@date : 2018. 9. 18.
     *@author : JeeSeon
     *@Method 설명 : 물품 수정폼 취소버튼 
     *@param event
     */
    @FXML
    void no(ActionEvent event) {
    	Stage thisStage = (Stage)form_no.getScene().getWindow();
		thisStage.close();
    }

    @FXML
    void initialize() {
        assert form_tf_buyer_name != null : "fx:id=\"form_tf_buyer_name\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_tf_mat_date != null : "fx:id=\"form_tf_mat_date\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_no != null : "fx:id=\"form_no\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_cd_mat_metc != null : "fx:id=\"form_cd_mat_metc\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_tf_mat_uprice != null : "fx:id=\"form_tf_mat_uprice\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert Label != null : "fx:id=\"Label\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_ok != null : "fx:id=\"form_ok\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_tf_mat_qty != null : "fx:id=\"form_tf_mat_qty\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_tf_mat_price != null : "fx:id=\"form_tf_mat_price\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_tf_mat_name != null : "fx:id=\"form_tf_mat_name\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert form_tf_mat_Remarks != null : "fx:id=\"form_tf_mat_Remarks\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
        assert ast_no != null : "fx:id=\"ast_no\" was not injected: check your FXML file 'MatModifiedRes2.fxml'.";
    }
    
    /**
     * 
     *@Method Name : insertToForm
     *@date : 2018. 9. 18.
     *@author : JeeSeon
     *@Method 설명 : 수불 수정시 수정탭 정보불러오기
     *@param mat
     */
    public void insertToForm(AssistantVo ast) {
    	
    	  ast_no.setText(ast.getAst_no());
    	  form_cd_mat_metc.setPromptText(ast.getMatc_name());
    	  form_tf_buyer_name.setPromptText(ast.getBuyer_name()) ;
	      form_tf_mat_qty.setText(Integer.toString(ast.getAst_qty()));
	      form_tf_mat_name.setText(ast.getAst_name());
	      form_tf_mat_Remarks.setText(ast.getAst_note());
	      int year = Integer.parseInt(ast.getAst_date().substring(0, 4));
	      int month = Integer.parseInt(ast.getAst_date().substring(5, 7));
	      int day = Integer.parseInt(ast.getAst_date().substring(8, 10));
	      LocalDate currentDate = LocalDate.now();
	      LocalDate targetDate = currentDate.withYear(year).withMonth(month).withDayOfMonth(day);
	      form_tf_mat_date.setValue(targetDate);
	      mat_code = ast.getAst_mat();
	   }
}
