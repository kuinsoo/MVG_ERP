package humanResources.vo;

public class SalaryVo {
  private String sal_pos;
  private String sal_basic;
  private String pos_name;

  public SalaryVo() {
  }


  public String getPos_name() {
	return pos_name;
}

public void setPos_name(String pos_name) {
	this.pos_name = pos_name;
}

public String getSal_pos() {
    return sal_pos;
  }

  public void setSal_pos(String sal_pos) {
    this.sal_pos = sal_pos;
  }

  public String getSal_basic() {
    return sal_basic;
  }

  public void setSal_basic(String sal_basic) {
    this.sal_basic = sal_basic;
  }
}
