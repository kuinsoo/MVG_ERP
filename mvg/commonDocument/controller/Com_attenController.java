package commonDocument.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;
import staticMethod.comboBox.ComboList;
import staticMethod.excelDoc.Write_Atten;

/**
 * 근태신청서 page
 * @author Sohyoung
 * @since 2018.09.08
 */
public class Com_attenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button t1_btn_print;

    @FXML
    private Button t1_btn_cancel;

    @FXML
	private ComboBox<String> cb_crq_dept;

    @FXML
    private TextField tf_emp_code;

    @FXML
    private TextField tf_emp_name;

    @FXML
    private DatePicker absence_start_date;

    @FXML
    private DatePicker absence_end_date;

    @FXML
    private TextField tf_attd_note;

    @FXML
    private TextField tf_etc;

    @FXML
    void click_t1_btn_cancel(ActionEvent event) {
    	resetFields();
    }

    @FXML
    void click_t1_btn_print(ActionEvent event) {
    	if(cb_crq_dept.getValue() == null				||
    			tf_emp_code.getText().trim().isEmpty()	||
    			tf_emp_name.getText().trim().isEmpty()	||
    			absence_start_date.getValue() == null	||
    			absence_end_date.getValue() == null		||
    			tf_attd_note.getText().trim().isEmpty()
    			) {
    		AlertWindow.errorAlert("공백 오류", "필수 항목을 모두 채워주세요.");
    	}else {
    		// 당일 날짜
    		String sysdate = Codemaker.sysdate();
    		
    		// 출력할 내용 list에 담기
    		List<String> oneAtten = new ArrayList<String>();
    		oneAtten.add(cb_crq_dept.getValue());
    		oneAtten.add(tf_emp_code.getText());
    		oneAtten.add(tf_emp_name.getText());
    		oneAtten.add(absence_start_date.getValue().toString());
    		oneAtten.add(absence_end_date.getValue().toString());
    		oneAtten.add(tf_attd_note.getText());
    		oneAtten.add(tf_etc.getText());
    		oneAtten.add(sysdate);
    		
    		// POI 출력하는 행위
    		Write_Atten.printAtten(oneAtten);
    		
    		// 초기화
    		resetFields();
    	}
    }

    @FXML
    void initialize() {
        assert t1_btn_print != null : "fx:id=\"t1_btn_print\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert t1_btn_cancel != null : "fx:id=\"t1_btn_cancel\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert tf_emp_code != null : "fx:id=\"tf_emp_code\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert tf_emp_name != null : "fx:id=\"tf_emp_name\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert absence_start_date != null : "fx:id=\"absence_start_date\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert absence_end_date != null : "fx:id=\"absence_end_date\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert tf_attd_note != null : "fx:id=\"tf_attd_note\" was not injected: check your FXML file 'Com_atten.fxml'.";
        assert tf_etc != null : "fx:id=\"tf_etc\" was not injected: check your FXML file 'Com_atten.fxml'.";

      //부서 콤보박스 내용
      cb_crq_dept.getItems().addAll(ComboList.deptCombo());
    }
    
    /**
	 *@Method Name : resetField
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 입력칸들을 모두 초기화 합니다.
	 */
	public void resetFields() {
		cb_crq_dept.setValue(null);
    	tf_emp_code.clear();
    	tf_emp_name.clear();
    	absence_start_date.setValue(null);
    	absence_end_date.setValue(null);
    	tf_attd_note.clear();
    	tf_etc.clear();
	}
}

