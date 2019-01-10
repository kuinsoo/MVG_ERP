package systemAdministration.vo;

import javafx.scene.control.CheckBox;

/**
 * 부서VO
 * @author Sohyoung
 * @since 2018.09.17
 */
public class DepartmentVo {

	private CheckBox dept_chkbox;

	private String dept_code;
	private String dept_name;

	public DepartmentVo() {
		dept_chkbox = new CheckBox();
	}

	public DepartmentVo(String dept_code, String dept_name) {
		this.dept_code = dept_code;
		this.dept_name = dept_name;
	}

	public CheckBox getDept_chkbox() {
		return dept_chkbox;
	}

	public void setDept_chkbox(CheckBox dept_chkbox) {
		this.dept_chkbox = dept_chkbox;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
}
