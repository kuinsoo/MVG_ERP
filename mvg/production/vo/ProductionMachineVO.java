package production.vo;



import javafx.scene.control.CheckBox;

public class ProductionMachineVO {
	private String mach_code;
	private String buyer_name;
	private String mach_name;
	private String mach_date;
	private int mach_qty;
	private String mach_writer;
	private CheckBox chk;
	
	
	public String getMach_code() {
		return mach_code;
	}
	public void setMach_code(String mach_code) {
		this.mach_code = mach_code;
	}
	public String getMach_buyer() {
		return buyer_name;
	}
	public void setMach_buyer(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getMach_name() {
		return mach_name;
	}
	public void setMach_name(String mach_name) {
		this.mach_name = mach_name;
	}
	public String getMach_date() {
		return mach_date;
	}
	public void setMach_date(String mach_date) {
		this.mach_date = mach_date;
	}
	public int getMach_qty() {
		return mach_qty;
	}
	public void setMach_qty(int mach_qty) {
		this.mach_qty = mach_qty;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getMach_writer() {
		return mach_writer;
	}
	public void setMach_writer(String mach_writer) {
		this.mach_writer = mach_writer;
	}
	public CheckBox getChk() {
		return chk;
	}
	public void setChk(CheckBox chk) {
		// TODO Auto-generated method stub
		this.chk = chk;
		
	}

	
	
	
	
	
}
