package production.vo;

public class SalesManagementVO {
	
	private String prod_code;
	private String prod_name;
	private int uPrice;
	private int sales;	//판매가
	private int salesQty;
	private int salesPrice;		//판매금액
	private String updateDate;
	private String salesManagementWritter;
	
	
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
	public int getuPrice() {
		return uPrice;
	}
	public void setuPrice(int uPrice) {
		this.uPrice = uPrice;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getSalesQty() {
		return salesQty;
	}
	public void setSalesQty(int salesQty) {
		this.salesQty = salesQty;
	}
	public int getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getSalesManagementWritter() {
		return salesManagementWritter;
	}
	public void setSalesManagementWritter(String salesManagementWritter) {
		this.salesManagementWritter = salesManagementWritter;
	}
	
	
	

}
