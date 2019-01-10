package material.vo;

import javafx.scene.control.CheckBox;

public class AssistantVo {
	
  private CheckBox mat_chk;
  private String ast_no;
  private String ast_mat;
  private String ast_date;
  private String ast_name;
  private int ast_qty;
  private String ast_note;
  private String mat_metc;
  private String mat_buyer;
  private String mat_Code;
  private String buyer_name;
  private String matc_name;

 

  public AssistantVo() {
  }

  public AssistantVo(String mat_Code, String ast_no, String ast_mat, String ast_date, String ast_name, int ast_qty, String ast_note, String mat_metc, String mat_buyer, String buyer_name, Boolean mat_chk) {
    this.ast_no = ast_no;
    this.ast_mat = ast_mat;
    this.ast_date = ast_date;
    this.ast_name = ast_name;
    this.ast_qty = ast_qty;
    this.ast_note = ast_note;
    this.mat_metc = mat_metc;
    this.mat_buyer = mat_buyer;
  }

  
  
  public String getMatc_name() {
	return matc_name;
}

public void setMatc_name(String matc_name) {
	this.matc_name = matc_name;
}

public String getMat_Code() {
	return mat_Code;
}

public void setMat_Code(String mat_Code) {
	this.mat_Code = mat_Code;
}

public String getAst_no() {
    return ast_no;
  }

  public void setAst_no(String ast_no) {
    this.ast_no = ast_no;
  }

  public String getAst_mat() {
    return ast_mat;
  }

  public void setAst_mat(String ast_mat) {
    this.ast_mat = ast_mat;
  }

  public String getAst_date() {
    return ast_date;
  }

  public void setAst_date(String ast_date) {
    this.ast_date = ast_date;
  }

  public String getAst_name() {
    return ast_name;
  }

  public void setAst_name(String ast_name) {
    this.ast_name = ast_name;
  }

  public int getAst_qty() {
    return ast_qty;
  }

  public void setAst_qty(int ast_qty) {
    this.ast_qty = ast_qty;
  }

  public String getAst_note() {
    return ast_note;
  }

  public void setAst_note(String ast_note) {
    this.ast_note = ast_note;
  }

public String getMat_metc() {
	return mat_metc;
}

public void setMat_metc(String mat_metc) {
	this.mat_metc = mat_metc;
}

public String getMat_buyer() {
	return mat_buyer;
}

public void setMat_buyer(String mat_buyer) {
	this.mat_buyer = mat_buyer;
}

public String getBuyer_name() {
	return buyer_name;
}

public void setBuyer_name(String buyer_name) {
	this.buyer_name = buyer_name;
}

public CheckBox getMat_chk() {
	return mat_chk;
}

public void setMat_chk(CheckBox mat_chk) {
	this.mat_chk = mat_chk;
}
  
  
}