package commonDocument.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import staticMethod.alert.AlertWindow;
import staticMethod.codemaker.Codemaker;
import staticMethod.excelDoc.Write_purchaseApp;

/**
 * 자재구매 신청서 page
 * @author Sohyoung
 * @since 2018.09.07
 */
public class Com_matController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button t1_btn_print;

	@FXML
	private Button t1_btn_cancel;

	@FXML
	private TextField tf_mat_name1;

	@FXML
	private TextField tf_mat_buyer1;

	@FXML
	private TextField tf_mat_qty1;

	@FXML
	private TextField tf_mat_price1;

	@FXML
	private TextField tf_mat_note1;

	@FXML
	private TextField tf_mat_name2;

	@FXML
	private TextField tf_mat_buyer2;

	@FXML
	private TextField tf_mat_qty2;

	@FXML
	private TextField tf_mat_price2;

	@FXML
	private TextField tf_mat_note2;

	@FXML
	private TextField tf_mat_name3;

	@FXML
	private TextField tf_mat_buyer3;

	@FXML
	private TextField tf_mat_qty3;

	@FXML
	private TextField tf_mat_price3;

	@FXML
	private TextField tf_mat_note3;

	@FXML
	private TextField tf_mat_name4;

	@FXML
	private TextField tf_mat_buyer4;

	@FXML
	private TextField tf_mat_qty4;

	@FXML
	private TextField tf_mat_price4;

	@FXML
	private TextField tf_mat_note4;

	@FXML
	private TextField tf_mat_name5;

	@FXML
	private TextField tf_mat_buyer5;

	@FXML
	private TextField tf_mat_qty5;

	@FXML
	private TextField tf_mat_price5;

	@FXML
	private TextField tf_mat_note5;

	@FXML
	private TextField tf_mat_name6;

	@FXML
	private TextField tf_mat_buyer6;

	@FXML
	private TextField tf_mat_qty6;

	@FXML
	private TextField tf_mat_price6;

	@FXML
	private TextField tf_mat_note6;

	@FXML
	private TextField t1_tf_mat_dept;

	@FXML
	private TextField t1_tf_emp_name;

	@FXML
	private TextField tf_mat_uprice1;

	@FXML
	private TextField tf_mat_uprice2;

	@FXML
	private TextField tf_mat_uprice3;

	@FXML
	private TextField tf_mat_uprice4;

	@FXML
	private TextField tf_mat_uprice5;

	@FXML
	private TextField tf_mat_uprice6;

	@FXML
	private TextField tf_mat_stand1;

	@FXML
	private TextField tf_mat_stand2;

	@FXML
	private TextField tf_mat_stand3;

	@FXML
	private TextField tf_mat_stand4;

	@FXML
	private TextField tf_mat_stand5;

	@FXML
	private TextField tf_mat_stand6;

	@FXML
	void click_t1_btn_cancel(ActionEvent event) {
		resetFields();
	}

	@FXML
	void click_t1_btn_print(ActionEvent event) {
		if(tf_mat_name1.getText().trim().isEmpty()			||
    			tf_mat_buyer1.getText().trim().isEmpty()	||
    			tf_mat_qty1.getText().trim().isEmpty()		||
    			tf_mat_price1.getText().trim().isEmpty()	||
    			tf_mat_stand1.getText().trim().isEmpty()	||
    			tf_mat_uprice1.getText().trim().isEmpty()
    			) {
    		AlertWindow.errorAlert("공백 오류", "물건을 한개 이상 작성해 주세요.");
    	}else {
    		
    		if(t1_tf_mat_dept.getText().trim().isEmpty()	||
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
    		List<List<String>> purchaseList = new ArrayList<List<String>>();
    		
    		// 리스트의 0번: 부서, 1번: 신청자, 2번: 날짜
    		empInfo.add(t1_tf_mat_dept.getText());
    		empInfo.add(t1_tf_emp_name.getText());
    		empInfo.add(sysdate);

    		// 각각 담기
    		// 수량이 숫자인지 확인
    		if(48<tf_mat_qty1.getText().charAt(0) && tf_mat_qty1.getText().charAt(0)<57) {
	    		oneStuff1.add(tf_mat_name1.getText());
	    		oneStuff1.add(tf_mat_buyer1.getText());
	    		oneStuff1.add(tf_mat_qty1.getText());
	    		oneStuff1.add(tf_mat_price1.getText());
	    		oneStuff1.add(tf_mat_stand1.getText());
	    		oneStuff1.add(tf_mat_uprice1.getText());
	    		oneStuff1.add(tf_mat_note1.getText());
    		}else {
    			AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    			return;
    		}
    		// 공백 여부와 수량 확인
    		if(tf_mat_name2.getText().trim().isEmpty()			||
    				tf_mat_buyer2.getText().trim().isEmpty()	||
    				tf_mat_qty2.getText().trim().isEmpty()		||
    				tf_mat_price2.getText().trim().isEmpty()	||
    				tf_mat_stand2.getText().trim().isEmpty()	||
    				tf_mat_uprice2.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<tf_mat_qty2.getText().charAt(0) && tf_mat_qty2.getText().charAt(0)<57) {
    				oneStuff2.add(tf_mat_name2.getText());
    				oneStuff2.add(tf_mat_buyer2.getText());
    				oneStuff2.add(tf_mat_qty2.getText());
    				oneStuff2.add(tf_mat_price2.getText());
    				oneStuff2.add(tf_mat_stand2.getText());
    				oneStuff2.add(tf_mat_uprice2.getText());
    				oneStuff2.add(" "+tf_mat_note2.getText());
    			}else {
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
    				return;
    			}
    		}
    		if(tf_mat_name3.getText().trim().isEmpty()			||
    				tf_mat_buyer3.getText().trim().isEmpty()	||
    				tf_mat_qty3.getText().trim().isEmpty()		||
    				tf_mat_price3.getText().trim().isEmpty()	||
    				tf_mat_stand3.getText().trim().isEmpty()	||
    				tf_mat_uprice3.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<tf_mat_qty3.getText().charAt(0) && tf_mat_qty3.getText().charAt(0)<57) {
	    			oneStuff3.add(tf_mat_name3.getText());
	    			oneStuff3.add(tf_mat_buyer3.getText());
	    			oneStuff3.add(tf_mat_qty3.getText());
	    			oneStuff3.add(tf_mat_price3.getText());
	    			oneStuff3.add(tf_mat_stand3.getText());
	    			oneStuff3.add(tf_mat_uprice3.getText());
	    			oneStuff3.add(" "+tf_mat_note3.getText());
    			}else {
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
        			return;
    			}
    		}
    		if(tf_mat_name4.getText().trim().isEmpty()			||
    				tf_mat_buyer4.getText().trim().isEmpty()	||
    				tf_mat_qty4.getText().trim().isEmpty()		||
    				tf_mat_price4.getText().trim().isEmpty()	||
    				tf_mat_stand4.getText().trim().isEmpty()	||
    				tf_mat_uprice4.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<tf_mat_qty4.getText().charAt(0) && tf_mat_qty4.getText().charAt(0)<57) {
	    			oneStuff4.add(tf_mat_name4.getText());
	    			oneStuff4.add(tf_mat_buyer4.getText());
	    			oneStuff4.add(tf_mat_qty4.getText());
	    			oneStuff4.add(tf_mat_price4.getText());
	    			oneStuff4.add(tf_mat_stand4.getText());
	    			oneStuff4.add(tf_mat_uprice4.getText());
	    			oneStuff4.add(" "+tf_mat_note4.getText());
    			}else {
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
        			return;
    			}
    		}
    		if(tf_mat_name5.getText().trim().isEmpty()			||
    				tf_mat_buyer5.getText().trim().isEmpty()	||
    				tf_mat_qty5.getText().trim().isEmpty()		||
    				tf_mat_price5.getText().trim().isEmpty()	||
    				tf_mat_stand5.getText().trim().isEmpty()	||
    				tf_mat_uprice5.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<tf_mat_qty5.getText().charAt(0) && tf_mat_qty5.getText().charAt(0)<57) {
	    			oneStuff5.add(tf_mat_name5.getText());
	    			oneStuff5.add(tf_mat_buyer5.getText());
	    			oneStuff5.add(tf_mat_qty5.getText());
	    			oneStuff5.add(tf_mat_price5.getText());
	    			oneStuff5.add(tf_mat_stand5.getText());
	    			oneStuff5.add(tf_mat_uprice5.getText());
	    			oneStuff5.add(" "+tf_mat_note5.getText());
    			}else {
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
        			return;
    			}
    		}
    		if(tf_mat_name6.getText().trim().isEmpty()			||
    				tf_mat_buyer6.getText().trim().isEmpty()	||
    				tf_mat_qty6.getText().trim().isEmpty()		||
    				tf_mat_price6.getText().trim().isEmpty()	||
    				tf_mat_stand6.getText().trim().isEmpty()	||
    				tf_mat_uprice6.getText().trim().isEmpty()	
    				) {
    		}else {
    			if(48<tf_mat_qty6.getText().charAt(0) && tf_mat_qty6.getText().charAt(0)<57) {
    			oneStuff6.add(tf_mat_name6.getText());
    			oneStuff6.add(tf_mat_buyer6.getText());
    			oneStuff6.add(tf_mat_qty6.getText());
    			oneStuff6.add(tf_mat_price6.getText());
    			oneStuff6.add(tf_mat_stand6.getText());
    			oneStuff6.add(tf_mat_uprice6.getText());
    			oneStuff6.add(" "+tf_mat_note6.getText());
    			}else {
    				AlertWindow.errorAlert("입력값 오류", "수량은 숫자로 입력해 주세요.");
        			return;
    			}
    		}
    		
    		purchaseList.add(empInfo);
    		purchaseList.add(oneStuff1);
    		purchaseList.add(oneStuff2);
    		purchaseList.add(oneStuff3);
    		purchaseList.add(oneStuff4);
    		purchaseList.add(oneStuff5);
    		purchaseList.add(oneStuff6);
    		
    		// POI 출력하는 행위
    		Write_purchaseApp.printPurchaseApp("자재 구매 신청서",purchaseList);
    		
    		// 초기화
    		resetFields();
    	}
	}

	@FXML
	void initialize() {
		assert t1_btn_print != null : "fx:id=\"t1_btn_print\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert t1_btn_cancel != null : "fx:id=\"t1_btn_cancel\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_name1 != null : "fx:id=\"tf_mat_name1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_buyer1 != null : "fx:id=\"tf_mat_buyer1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_qty1 != null : "fx:id=\"tf_mat_qty1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_price1 != null : "fx:id=\"tf_mat_price1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_note1 != null : "fx:id=\"tf_mat_note1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_name2 != null : "fx:id=\"tf_mat_name2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_buyer2 != null : "fx:id=\"tf_mat_buyer2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_qty2 != null : "fx:id=\"tf_mat_qty2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_price2 != null : "fx:id=\"tf_mat_price2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_note2 != null : "fx:id=\"tf_mat_note2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_name3 != null : "fx:id=\"tf_mat_name3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_buyer3 != null : "fx:id=\"tf_mat_buyer3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_qty3 != null : "fx:id=\"tf_mat_qty3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_price3 != null : "fx:id=\"tf_mat_price3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_note3 != null : "fx:id=\"tf_mat_note3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_name4 != null : "fx:id=\"tf_mat_name4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_buyer4 != null : "fx:id=\"tf_mat_buyer4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_qty4 != null : "fx:id=\"tf_mat_qty4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_price4 != null : "fx:id=\"tf_mat_price4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_note4 != null : "fx:id=\"tf_mat_note4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_name5 != null : "fx:id=\"tf_mat_name5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_buyer5 != null : "fx:id=\"tf_mat_buyer5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_qty5 != null : "fx:id=\"tf_mat_qty5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_price5 != null : "fx:id=\"tf_mat_price5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_note5 != null : "fx:id=\"tf_mat_note5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_name6 != null : "fx:id=\"tf_mat_name6\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_buyer6 != null : "fx:id=\"tf_mat_buyer6\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_qty6 != null : "fx:id=\"tf_mat_qty6\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_price6 != null : "fx:id=\"tf_mat_price6\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_note6 != null : "fx:id=\"tf_mat_note6\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert t1_tf_mat_dept != null : "fx:id=\"t1_tf_mat_dept\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert t1_tf_emp_name != null : "fx:id=\"t1_tf_emp_name\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_uprice1 != null : "fx:id=\"tf_mat_uprice1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_uprice2 != null : "fx:id=\"tf_mat_uprice2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_uprice3 != null : "fx:id=\"tf_mat_uprice3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_uprice4 != null : "fx:id=\"tf_mat_uprice4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_uprice5 != null : "fx:id=\"tf_mat_uprice5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_uprice6 != null : "fx:id=\"tf_mat_uprice6\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_stand1 != null : "fx:id=\"tf_mat_stand1\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_stand2 != null : "fx:id=\"tf_mat_stand2\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_stand3 != null : "fx:id=\"tf_mat_stand3\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_stand4 != null : "fx:id=\"tf_mat_stand4\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_stand5 != null : "fx:id=\"tf_mat_stand5\" was not injected: check your FXML file 'Com_mat.fxml'.";
		assert tf_mat_stand6 != null : "fx:id=\"tf_mat_stand6\" was not injected: check your FXML file 'Com_mat.fxml'.";

	}
	
	/**
	 *@Method Name : resetField
	 *@date : 2018. 9. 22.
	 *@author : Sohyoung
	 *@Method 설명 : 입력칸들을 모두 초기화 합니다.
	 */
	public void resetFields() {
		tf_mat_name1.clear();
		tf_mat_name2.clear();
		tf_mat_name3.clear();
		tf_mat_name4.clear();
		tf_mat_name5.clear();
		tf_mat_name6.clear();
		tf_mat_buyer1.clear();
		tf_mat_buyer2.clear();
		tf_mat_buyer3.clear();
		tf_mat_buyer4.clear();
		tf_mat_buyer5.clear();
		tf_mat_buyer6.clear();
		tf_mat_qty1.clear();
		tf_mat_qty2.clear();
		tf_mat_qty3.clear();
		tf_mat_qty4.clear();
		tf_mat_qty5.clear();
		tf_mat_qty6.clear();
		tf_mat_price1.clear();
		tf_mat_price2.clear();
		tf_mat_price3.clear();
		tf_mat_price4.clear();
		tf_mat_price5.clear();
		tf_mat_price6.clear();
		tf_mat_uprice1.clear();
		tf_mat_uprice2.clear();
		tf_mat_uprice3.clear();
		tf_mat_uprice4.clear();
		tf_mat_uprice5.clear();
		tf_mat_uprice6.clear();
		tf_mat_stand1.clear();
		tf_mat_stand2.clear();
		tf_mat_stand3.clear();
		tf_mat_stand4.clear();
		tf_mat_stand5.clear();
		tf_mat_stand6.clear();
		tf_mat_note1.clear();
		tf_mat_note2.clear();
		tf_mat_note3.clear();
		tf_mat_note4.clear();
		tf_mat_note5.clear();
		tf_mat_note6.clear();
		
		t1_tf_mat_dept.clear();
        t1_tf_emp_name.clear();
	}
}

