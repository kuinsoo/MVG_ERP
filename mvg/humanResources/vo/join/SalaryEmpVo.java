package humanResources.vo.join;

import javafx.scene.control.CheckBox;

public class SalaryEmpVo {
	private CheckBox sal_chk;
	private String emp_code;
	private String emp_name;
	private String dept_name;
	private String pos_name;
	private String sal_basic;
	private String attd_count;
	private String emp_note;
	
	
	public SalaryEmpVo() {
		super();
	}
	
	public CheckBox getSal_chk() {
		return sal_chk;
	}

	public void setSal_chk(CheckBox sal_chk) {
		this.sal_chk = sal_chk;
	}

	public String getDept_name() {
		return dept_name;
	}
	
	public String getEmp_note() {
		return emp_note;
	}

	public void setEmp_note(String emp_note) {
		this.emp_note = emp_note;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	public String getSal_basic() {
		return sal_basic;
	}
	public void setSal_basic(String sal_basic) {
		this.sal_basic = sal_basic;
	}
	public String getAttd_count() {
		return attd_count;
	}
	public void setAttd_count(String attd_count) {
		this.attd_count = attd_count;
	}
	
	
}
