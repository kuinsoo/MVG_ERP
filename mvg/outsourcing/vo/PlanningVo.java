package outsourcing.vo;

import javafx.scene.control.CheckBox;

public class PlanningVo {
  private CheckBox plan_chk;
  private String plan_no;
  private String plan_acc;
  private String plan_dept;
  private String plan_title;
  private String plan_name;
  private String plan_date;
  private String plan_note;

  public PlanningVo() {
  }

  public PlanningVo(CheckBox plan_chk, String plan_no, String plan_acc, String plan_dept, String plan_title, String plan_name, String plan_date, String plan_note) {
    this.plan_no = plan_no;
    this.plan_acc = plan_acc;
    this.plan_dept = plan_dept;
    this.plan_title = plan_title;
    this.plan_name = plan_name;
    this.plan_date = plan_date;
    this.plan_note = plan_note;
  }
  
  public CheckBox getPlan_chk() {
	return plan_chk;
  }

  public void setPlan_chk(CheckBox plan_chk) {
	this.plan_chk = plan_chk;
  }
	

  public String getPlan_no() {
    return plan_no;
  }

  public void setPlan_no(String plan_no) {
    this.plan_no = plan_no;
  }

  public String getPlan_acc() {
    return plan_acc;
  }

  public void setPlan_acc(String plan_acc) {
    this.plan_acc = plan_acc;
  }

  public String getPlan_dept() {
    return plan_dept;
  }

  public void setPlan_dept(String plan_dept) {
    this.plan_dept = plan_dept;
  }

  public String getPlan_title() {
    return plan_title;
  }

  public void setPlan_title(String plan_title) {
    this.plan_title = plan_title;
  }

  public String getPlan_name() {
    return plan_name;
  }

  public void setPlan_name(String plan_name) {
    this.plan_name = plan_name;
  }

  public String getPlan_date() {
    return plan_date;
  }

  public void setPlan_date(String plan_date) {
    this.plan_date = plan_date;
  }

  public String getPlan_note() {
    return plan_note;
  }

  public void setPlan_note(String plan_note) {
    this.plan_note = plan_note;
  }
}