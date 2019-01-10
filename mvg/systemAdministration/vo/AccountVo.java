package systemAdministration.vo;

import javafx.scene.control.CheckBox;

/**
 * 거래처VO
 * @author Sohyoung
 * @since 2018.09.17
 */
public class AccountVo {

	private CheckBox acc_chkbox;
	
	private String acc_code;
	private String acc_name;
	private String acc_rep;
	private String acc_addr;
	
	public AccountVo() {
		acc_chkbox = new CheckBox();
	}

	public AccountVo(String acc_code, String acc_name, String acc_rep, String acc_addr) {
		super();
		this.acc_code = acc_code;
		this.acc_name = acc_name;
		this.acc_rep = acc_rep;
		this.acc_addr = acc_addr;
	}

	public CheckBox getAcc_chkbox() {
		return acc_chkbox;
	}

	public void setAcc_chkbox(CheckBox acc_chkbox) {
		this.acc_chkbox = acc_chkbox;
	}

	public String getAcc_code() {
		return acc_code;
	}

	public void setAcc_code(String acc_code) {
		this.acc_code = acc_code;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getAcc_rep() {
		return acc_rep;
	}

	public void setAcc_rep(String acc_rep) {
		this.acc_rep = acc_rep;
	}

	public String getAcc_addr() {
		return acc_addr;
	}

	public void setAcc_addr(String acc_addr) {
		this.acc_addr = acc_addr;
	}
}
