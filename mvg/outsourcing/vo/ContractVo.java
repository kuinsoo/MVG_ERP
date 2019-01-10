package outsourcing.vo;

import javafx.scene.control.CheckBox;

public class ContractVo {
  private CheckBox cont_chk;
  private String cont_no;
  private String cont_plan;
  private String cont_name;
  private String cont_cdate;
  private String cont_date;
  private int cont_dis;
  private String cont_note;

  public ContractVo() {
  }

  public CheckBox getCont_chk() {
	return cont_chk;
  }

  public void setCont_chk(CheckBox cont_chk) {
	this.cont_chk = cont_chk;
  }

  public String getCont_no() {
    return cont_no;
  }

  public void setCont_no(String cont_no) {
    this.cont_no = cont_no;
  }

  public String getCont_plan() {
    return cont_plan;
  }

  public void setCont_plan(String cont_plan) {
    this.cont_plan = cont_plan;
  }

  public String getCont_name() {
    return cont_name;
  }

  public void setCont_name(String cont_name) {
    this.cont_name = cont_name;
  }

  public String getCont_cdate() {
    return cont_cdate;
  }

  public void setCont_cdate(String cont_cdate) {
    this.cont_cdate = cont_cdate;
  }

  public String getCont_date() {
    return cont_date;
  }

  public void setCont_date(String cont_date) {
    this.cont_date = cont_date;
  }

  public int getCont_dis() {
    return cont_dis;
  }

  public void setCont_dis(int cont_dis) {
    this.cont_dis = cont_dis;
  }

  public String getCont_note() {
    return cont_note;
  }

  public void setCont_note(String cont_note) {
    this.cont_note = cont_note;
  }
}