package production.vo;

import javafx.scene.control.CheckBox;

public class ProductionStockVO {
	
	private CheckBox checkBox;
	private String ast_no;
	private String matc_name;
	private String mat_code;
	private String ast_name;
	private String ast_date;
	private int ast_qty;
	private int mat_uprice;
	
	public ProductionStockVO() {

	}
	
	public String getAst_no() {
		return ast_no;
	}
	public void setAst_no(String ast_no) {
		this.ast_no = ast_no;
	}
	
	public String getMatc_name() {
		return matc_name;
	}
	public void setMatc_name(String matc_name) {
		this.matc_name = matc_name;
	}
	public String getMat_code() {
		return mat_code;
	}
	public void setMat_code(String mat_code) {
		this.mat_code = mat_code;
	}
	public String getAst_name() {
		return ast_name;
	}
	public void setAst_name(String ast_name) {
		this.ast_name = ast_name;
	}
	public String getAst_date() {
		return ast_date;
	}
	public void setAst_date(String ast_date) {
		this.ast_date = ast_date;
	}
	public int getAst_qty() {
		return ast_qty;
	}
	public void setAst_qty(int ast_qty) {
		this.ast_qty = ast_qty;
	}

	public CheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public int getMat_uprice() {
		return mat_uprice;
	}

	public void setMat_uprice(int mat_uprice) {
		this.mat_uprice = mat_uprice;
	}

	
	
	
	

}
