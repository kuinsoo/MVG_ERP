package production.vo;

import javafx.scene.control.CheckBox;

public class SaleVO {
	
	private CheckBox checkBox;
	private String prod_code;
	private String prod_name;
	private int prod_sale;
	private int prod_qty;
	private int sale_price;
	private String sale_date;
	
	public String getProd_code() {
		return prod_code;
	}
	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_sale() {
		return prod_sale;
	}
	public void setProd_sale(int prod_sale) {
		this.prod_sale = prod_sale;
	}
	public int getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}
	
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	public String getSale_date() {
		return sale_date;
	}
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	public CheckBox getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(CheckBox checkBox) {
		this.checkBox = checkBox;
	}
	
	
	
	

}
