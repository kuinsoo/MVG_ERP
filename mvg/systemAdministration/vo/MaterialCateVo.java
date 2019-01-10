package systemAdministration.vo;

import javafx.scene.control.CheckBox;

/**
 * 자재대분류VO
 * @author Sohyoung
 * @since 2018.09.17
 */
public class MaterialCateVo {

	private CheckBox matc_chkbox;
	
	private String matc_code;
	private String matc_name;
	
	public MaterialCateVo() {
		matc_chkbox = new CheckBox();
	}
	
	public MaterialCateVo(String matc_code, String matc_name) {
		super();
		this.matc_code = matc_code;
		this.matc_name = matc_name;
	}

	public CheckBox getMatc_chkbox() {
		return matc_chkbox;
	}

	public void setMatc_chkbox(CheckBox matc_chkbox) {
		this.matc_chkbox = matc_chkbox;
	}

	public String getMatc_code() {
		return matc_code;
	}

	public void setMatc_code(String matc_code) {
		this.matc_code = matc_code;
	}

	public String getMatc_name() {
		return matc_name;
	}

	public void setMatc_name(String matc_name) {
		this.matc_name = matc_name;
	}
}
