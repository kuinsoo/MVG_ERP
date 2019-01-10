package material.vo;

public class BuyerVo {
  private String buyer_code;
  private String buyer_name;
  private String buyer_rep;
  private String buyer_addr;

  public BuyerVo() {
  }

  public BuyerVo(String buyer_code, String buyer_name, String buyer_rep, String buyer_addr) {
    this.buyer_code = buyer_code;
    this.buyer_name = buyer_name;
    this.buyer_rep = buyer_rep;
    this.buyer_addr = buyer_addr;
  }

  public String getBuyer_code() {
    return buyer_code;
  }

  public void setBuyer_code(String buyer_code) {
    this.buyer_code = buyer_code;
  }

  public String getBuyer_name() {
    return buyer_name;
  }

  public void setBuyer_name(String buyer_name) {
    this.buyer_name = buyer_name;
  }

  public String getBuyer_rep() {
    return buyer_rep;
  }

  public void setBuyer_rep(String buyer_rep) {
    this.buyer_rep = buyer_rep;
  }

  public String getBuyer_addr() {
    return buyer_addr;
  }

  public void setBuyer_addr(String buyer_addr) {
    this.buyer_addr = buyer_addr;
  }
}