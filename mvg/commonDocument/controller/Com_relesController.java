package commonDocument.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import commonDocument.service.CommonDocumentService;
import commonDocument.service.ICommonDocumentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;
import staticMethod.comboBox.ComboList;
import staticMethod.excelDoc.Write_matReles;

public class Com_relesController {

	private ICommonDocumentService service = CommonDocumentService.getInstance();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button t1_btn_print;

    @FXML
    private Button t1_btn_cancel;

    @FXML
    private TextField t1_tf_out_qty1;

    @FXML
    private TextField t1_tf_out_qty2;

    @FXML
    private TextField t1_tf_out_qty3;

    @FXML
    private TextField t1_tf_out_qty4;

    @FXML
    private TextField t1_tf_out_qty5;

    @FXML
    private TextField t1_tf_out_qty6;

    @FXML
    private ComboBox<String> t1_cb_metc1;

    @FXML
    private ComboBox<String> t1_cb_metc2;

    @FXML
    private ComboBox<String> t1_cb_metc3;

    @FXML
    private ComboBox<String> t1_cb_metc4;
                     
    @FXML            
    private ComboBox<String> t1_cb_metc5;
                     
    @FXML            
    private ComboBox<String> t1_cb_metc6;

    @FXML
    private TextField t1_tf_emp_name;

    @FXML
    private TextField t1_tf_note1;

    @FXML
    private TextField t1_tf_note2;

    @FXML
    private TextField t1_tf_note3;

    @FXML
    private TextField t1_tf_note4;

    @FXML
    private TextField t1_tf_note5;

    @FXML
    private TextField t1_tf_note6;

    @FXML
    private TextField t1_tf_dept;

    @FXML
    private ComboBox<String> t1_cb_name1;
                     
    @FXML            
    private ComboBox<String> t1_cb_name2;
                     
    @FXML            
    private ComboBox<String> t1_cb_name3;
                     
    @FXML            
    private ComboBox<String> t1_cb_name4;
                     
    @FXML            
    private ComboBox<String> t1_cb_name5;
                     
    @FXML            
    private ComboBox<String> t1_cb_name6;

    @FXML
    private TextField t1_tf_qty1;

    @FXML
    private TextField t1_tf_qty2;

    @FXML
    private TextField t1_tf_qty3;

    @FXML
    private TextField t1_tf_qty4;

    @FXML
    private TextField t1_tf_qty5;

    @FXML
    private TextField t1_tf_qty6;

    @FXML
    void click_t1_btn_cancel(ActionEvent event) {
    	resetFields();
    }

    @FXML
    void click_t1_btn_print(ActionEvent event) {
    	if(t1_cb_metc1.getValue().isEmpty()				||
    			t1_cb_name1.getValue().isEmpty()		||
    			t1_tf_qty1.getText().trim().isEmpty() 	||
    			t1_tf_out_qty1.getText().trim().isEmpty()
    			) {
    		AlertWindow.errorAlert("공백 오류", "물건을 한개 이상 작성해 주세요.");
    	}else {
    		if(t1_tf_dept.getText().trim().isEmpty()	||
        			t1_tf_emp_name.getText().trim().isEmpty()
        			) {
    			AlertWindow.errorAlert("공백 오류", "부서와 신청자 성함을 입력해 주세요.");
    			return;
    		}

    		String sysdate = Codemaker.sysdate();

    		List<String> empInfo = new ArrayList<String>();
    		List<String> oneStuff1 = new ArrayList<String>();
    		List<String> oneStuff2 = new ArrayList<String>();
    		List<String> oneStuff3 = new ArrayList<String>();
    		List<String> oneStuff4 = new ArrayList<String>();
    		List<String> oneStuff5 = new ArrayList<String>();
    		List<String> oneStuff6 = new ArrayList<String>();
    		List<List<String>> relesList = new ArrayList<List<String>>();
    		
    		// 리스트의 0번: 부서, 1번: 신청자, 2번: 날짜
    		empInfo.add(t1_tf_dept.getText());
    		empInfo.add(t1_tf_emp_name.getText());
    		empInfo.add(sysdate);

    		// 각각 담기
    		// 수량이 숫자인지 확인
    		if(48<t1_tf_out_qty1.getText().charAt(0) && t1_tf_out_qty1.getText().charAt(0)<57) {
	    		oneStuff1.add(t1_cb_metc1.getValue());
	    		oneStuff1.add(t1_cb_name1.getValue());
	    		oneStuff1.add(t1_tf_out_qty1.getText());
	    		oneStuff1.add(""+t1_tf_note1.getText());
    		}else {
    			// 출고수량이 재고수량 초과이면 error메시지
    			if(Integer.parseInt(t1_tf_qty1.getText()) < Integer.parseInt(t1_tf_out_qty1.getText())) {
    				AlertWindow.errorAlert("입력값 오류", "출고수량은 재고수량 이하로 입력해 주세요.");
        			return;	
    			}
    			AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    			return;
    		}
    		// 공백 여부와 수량 확인
    		if(t1_cb_metc2.getValue() == null				||
        			t1_cb_name2.getValue().isEmpty()		||
        			t1_tf_qty2.getText().trim().isEmpty() 	||
        			t1_tf_out_qty2.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<t1_tf_out_qty2.getText().charAt(0) && t1_tf_out_qty2.getText().charAt(0)<57) {
    				oneStuff2.add(t1_cb_metc2.getValue());
    	    		oneStuff2.add(t1_cb_name2.getValue());
    	    		oneStuff2.add(t1_tf_out_qty2.getText());
    	    		oneStuff2.add(""+t1_tf_note2.getText());
    			}else {
    				if(Integer.parseInt(t1_tf_qty1.getText()) < Integer.parseInt(t1_tf_out_qty1.getText())) {
        				AlertWindow.errorAlert("입력값 오류", "출고수량은 재고수량 이하로 입력해 주세요.");
            			return;	
        			}
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    				return;
    			}
    		}
    		if(t1_cb_metc3.getValue() == null				||
    				t1_cb_name3.getValue().isEmpty()		||
    				t1_tf_qty3.getText().trim().isEmpty() 	||
    				t1_tf_out_qty3.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<t1_tf_out_qty3.getText().charAt(0) && t1_tf_out_qty3.getText().charAt(0)<57) {
    				oneStuff3.add(t1_cb_metc3.getValue());
    				oneStuff3.add(t1_cb_name3.getValue());
    				oneStuff3.add(t1_tf_out_qty3.getText());
    				oneStuff3.add(""+t1_tf_note3.getText());
    			}else {
    				if(Integer.parseInt(t1_tf_qty1.getText()) < Integer.parseInt(t1_tf_out_qty1.getText())) {
        				AlertWindow.errorAlert("입력값 오류", "출고수량은 재고수량 이하로 입력해 주세요.");
            			return;	
        			}
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    				return;
    			}
    		}
    		if(t1_cb_metc4.getValue() == null				||
    				t1_cb_name4.getValue().isEmpty()		||
    				t1_tf_qty4.getText().trim().isEmpty() 	||
    				t1_tf_out_qty4.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<t1_tf_out_qty4.getText().charAt(0) && t1_tf_out_qty4.getText().charAt(0)<57) {
    				oneStuff4.add(t1_cb_metc4.getValue());
    				oneStuff4.add(t1_cb_name4.getValue());
    				oneStuff4.add(t1_tf_out_qty4.getText());
    				oneStuff4.add(""+t1_tf_note4.getText());
    			}else {
    				if(Integer.parseInt(t1_tf_qty1.getText()) < Integer.parseInt(t1_tf_out_qty1.getText())) {
        				AlertWindow.errorAlert("입력값 오류", "출고수량은 재고수량 이하로 입력해 주세요.");
            			return;	
        			}
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    				return;
    			}
    		}
    		if(t1_cb_metc5.getValue() == null				||
    				t1_cb_name5.getValue().isEmpty()		||
    				t1_tf_qty5.getText().trim().isEmpty() 	||
    				t1_tf_out_qty5.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<t1_tf_out_qty5.getText().charAt(0) && t1_tf_out_qty5.getText().charAt(0)<57) {
    				oneStuff5.add(t1_cb_metc5.getValue());
    				oneStuff5.add(t1_cb_name5.getValue());
    				oneStuff5.add(t1_tf_out_qty5.getText());
    				oneStuff5.add(""+t1_tf_note5.getText());
    			}else {
    				if(Integer.parseInt(t1_tf_qty1.getText()) < Integer.parseInt(t1_tf_out_qty1.getText())) {
        				AlertWindow.errorAlert("입력값 오류", "출고수량은 재고수량 이하로 입력해 주세요.");
            			return;	
        			}
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    				return;
    			}
    		}
    		if(t1_cb_metc6.getValue() == null				||
    				t1_cb_name6.getValue().isEmpty()		||
    				t1_tf_qty6.getText().trim().isEmpty() 	||
    				t1_tf_out_qty6.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<t1_tf_out_qty6.getText().charAt(0) && t1_tf_out_qty6.getText().charAt(0)<57) {
    				oneStuff6.add(t1_cb_metc6.getValue());
    				oneStuff6.add(t1_cb_name6.getValue());
    				oneStuff6.add(t1_tf_out_qty6.getText());
    				oneStuff6.add(""+t1_tf_note6.getText());
    			}else {
    				if(Integer.parseInt(t1_tf_qty1.getText()) < Integer.parseInt(t1_tf_out_qty1.getText())) {
        				AlertWindow.errorAlert("입력값 오류", "출고수량은 재고수량 이하로 입력해 주세요.");
            			return;	
        			}
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    				return;
    			}
    		}
    		
    		relesList.add(empInfo);
    		relesList.add(oneStuff1);
    		relesList.add(oneStuff2);
    		relesList.add(oneStuff3);
    		relesList.add(oneStuff4);
    		relesList.add(oneStuff5);
    		relesList.add(oneStuff6);
    		
    		// POI 출력하는 행위
    		Write_matReles.printMatReles("자재출고증",relesList);
    		
    		// 초기화
    		resetFields();
    	}
    	
    }
    
/* 분류에 맞는 자재 콤보박스 셋팅하기 */
    @FXML
    void click_t1_cb_metc1(ActionEvent event) {
    	t1_cb_name1.getItems().clear();
    	List<String> mat_names = service.getMatNames(t1_cb_metc1.getValue());
    	t1_cb_name1.getItems().addAll(mat_names);
    }

    @FXML
    void click_t1_cb_metc2(ActionEvent event) {
    	t1_cb_name2.getItems().clear();
    	List<String> mat_names = service.getMatNames(t1_cb_metc2.getValue());
    	t1_cb_name2.getItems().addAll(mat_names);
    }

    @FXML
    void click_t1_cb_metc3(ActionEvent event) {
    	t1_cb_name3.getItems().clear();
    	List<String> mat_names = service.getMatNames(t1_cb_metc3.getValue());
    	t1_cb_name3.getItems().addAll(mat_names);
    }

    @FXML
    void click_t1_cb_metc4(ActionEvent event) {
    	t1_cb_name4.getItems().clear();
    	List<String> mat_names = service.getMatNames(t1_cb_metc4.getValue());
    	t1_cb_name4.getItems().addAll(mat_names);
    }

    @FXML
    void click_t1_cb_metc5(ActionEvent event) {
    	t1_cb_name5.getItems().clear();
    	List<String> mat_names = service.getMatNames(t1_cb_metc5.getValue());
    	t1_cb_name5.getItems().addAll(mat_names);
    }

    @FXML
    void click_t1_cb_metc6(ActionEvent event) {
    	t1_cb_name6.getItems().clear();
    	List<String> mat_names = service.getMatNames(t1_cb_metc6.getValue());
    	t1_cb_name6.getItems().addAll(mat_names);
    }
    
    /*두번째 콤보박스*/
    @FXML
    void click_t1_cb_name1(ActionEvent event) {
    	String qty = service.getMatQty(t1_cb_name1.getValue());
    	t1_tf_qty1.setText(qty);
    }

    @FXML
    void click_t1_cb_name2(ActionEvent event) {
    	String qty = service.getMatQty(t1_cb_name2.getValue());
    	t1_tf_qty2.setText(qty);
    }

    @FXML
    void click_t1_cb_name3(ActionEvent event) {
    	String qty = service.getMatQty(t1_cb_name3.getValue());
    	t1_tf_qty3.setText(qty);
    }

    @FXML
    void click_t1_cb_name4(ActionEvent event) {
    	String qty = service.getMatQty(t1_cb_name4.getValue());
    	t1_tf_qty4.setText(qty);
    }

    @FXML
    void click_t1_cb_name5(ActionEvent event) {
    	String qty = service.getMatQty(t1_cb_name5.getValue());
    	t1_tf_qty5.setText(qty);
    }

    @FXML
    void click_t1_cb_name6(ActionEvent event) {
    	String qty = service.getMatQty(t1_cb_name6.getValue());
    	t1_tf_qty6.setText(qty);
    }

    @FXML
    void initialize() {
        assert t1_btn_print != null : "fx:id=\"t1_btn_print\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_btn_cancel != null : "fx:id=\"t1_btn_cancel\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_out_qty1 != null : "fx:id=\"t1_tf_out_qty1\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_out_qty2 != null : "fx:id=\"t1_tf_out_qty2\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_out_qty3 != null : "fx:id=\"t1_tf_out_qty3\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_out_qty4 != null : "fx:id=\"t1_tf_out_qty4\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_out_qty5 != null : "fx:id=\"t1_tf_out_qty5\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_out_qty6 != null : "fx:id=\"t1_tf_out_qty6\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_metc1 != null : "fx:id=\"t1_cb_metc1\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_metc2 != null : "fx:id=\"t1_cb_metc2\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_metc3 != null : "fx:id=\"t1_cb_metc3\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_metc4 != null : "fx:id=\"t1_cb_metc4\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_metc5 != null : "fx:id=\"t1_cb_metc5\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_metc6 != null : "fx:id=\"t1_cb_metc6\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_emp_name != null : "fx:id=\"t1_tf_emp_name\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_note1 != null : "fx:id=\"t1_tf_note1\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_note2 != null : "fx:id=\"t1_tf_note2\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_note3 != null : "fx:id=\"t1_tf_note3\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_note4 != null : "fx:id=\"t1_tf_note4\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_note5 != null : "fx:id=\"t1_tf_note5\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_note6 != null : "fx:id=\"t1_tf_note6\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_dept != null : "fx:id=\"t1_tf_dept\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_name1 != null : "fx:id=\"t1_cb_name1\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_name2 != null : "fx:id=\"t1_cb_name2\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_name3 != null : "fx:id=\"t1_cb_name3\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_name4 != null : "fx:id=\"t1_cb_name4\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_name5 != null : "fx:id=\"t1_cb_name5\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_cb_name6 != null : "fx:id=\"t1_cb_name6\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_qty1 != null : "fx:id=\"t1_tf_qty1\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_qty2 != null : "fx:id=\"t1_tf_qty2\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_qty3 != null : "fx:id=\"t1_tf_qty3\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_qty4 != null : "fx:id=\"t1_tf_qty4\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_qty5 != null : "fx:id=\"t1_tf_qty5\" was not injected: check your FXML file 'Com_reles.fxml'.";
        assert t1_tf_qty6 != null : "fx:id=\"t1_tf_qty6\" was not injected: check your FXML file 'Com_reles.fxml'.";

        // 콤보박스 셋팅(자재대분류에 존재하는 모든 분류)
        t1_cb_metc1.getItems().addAll(ComboList.matCombo());
        t1_cb_metc2.getItems().addAll(ComboList.matCombo());
        t1_cb_metc3.getItems().addAll(ComboList.matCombo());
        t1_cb_metc4.getItems().addAll(ComboList.matCombo());
        t1_cb_metc5.getItems().addAll(ComboList.matCombo());
        t1_cb_metc6.getItems().addAll(ComboList.matCombo());

        // 기본 부서: 생산부
        t1_tf_dept.setText("생산부");
    }


    /**
     *@Method Name : resetFields
     *@date : 2018. 9. 28.
     *@author : Sohyoung
     *@Method 설명 : 입력칸들을 모두 초기화 합니다.
     */
    public void resetFields() {
    	t1_cb_metc1.getSelectionModel().clearSelection();
		t1_cb_metc2.getSelectionModel().clearSelection();
		t1_cb_metc3.getSelectionModel().clearSelection();
		t1_cb_metc4.getSelectionModel().clearSelection();
		t1_cb_metc5.getSelectionModel().clearSelection();
		t1_cb_metc6.getSelectionModel().clearSelection();
		t1_cb_name1.getSelectionModel().clearSelection();
		t1_cb_name2.getSelectionModel().clearSelection();
		t1_cb_name3.getSelectionModel().clearSelection();
		t1_cb_name4.getSelectionModel().clearSelection();
		t1_cb_name5.getSelectionModel().clearSelection();
		t1_cb_name6.getSelectionModel().clearSelection();
		t1_tf_qty1.clear();
		t1_tf_qty2.clear();
		t1_tf_qty3.clear();
		t1_tf_qty4.clear();
		t1_tf_qty5.clear();
		t1_tf_qty6.clear();
		t1_tf_out_qty1.clear();
		t1_tf_out_qty2.clear();
		t1_tf_out_qty3.clear();
		t1_tf_out_qty4.clear();
		t1_tf_out_qty5.clear();
		t1_tf_out_qty6.clear();
		t1_tf_note1.clear();
		t1_tf_note2.clear();
		t1_tf_note3.clear();
		t1_tf_note4.clear();
		t1_tf_note5.clear();
		t1_tf_note6.clear();
		
		t1_tf_emp_name.clear();
	}
}
