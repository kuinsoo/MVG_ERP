package humanResources.vo.join;

import javafx.scene.control.CheckBox;

public class GetAllNowEmpVo {
	private CheckBox emp_chk;
	private String emp_code;
	private String dept_name;
	private String pos_name;
	private String emp_name;
	private String emp_gender;
	private String emp_hdate;
	
	public GetAllNowEmpVo() {
		super();
	}



	public GetAllNowEmpVo(CheckBox emp_chk, String emp_code, String dept_name, String pos_name, String emp_name,
			String emp_gender, String emp_hdate) {
		super();
		this.emp_chk = emp_chk;
		this.emp_code = emp_code;
		this.dept_name = dept_name;
		this.pos_name = pos_name;
		this.emp_name = emp_name;
		this.emp_gender = emp_gender;
		this.emp_hdate = emp_hdate;
	}

	

	public CheckBox getEmp_chk() {
		return emp_chk;
	}



	public void setEmp_chk(CheckBox emp_chk) {
		this.emp_chk = emp_chk;
	}



	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public String getEmp_hdate() {
		return emp_hdate;
	}
	public void setEmp_hdate(String emp_hdate) {
		this.emp_hdate = emp_hdate;
	}
	
	
}
