package commonDocument.vo;

/**
 * 코드요청서VO
 * @author Sohyoung
 * @since 2018.09.17
 */
public class CodeRequestVo {
	
    private String crq_no;
    private String crq_dept;
    private String crq_emp;
    private String crq_name;
    private String crq_date;
    private String crq_div;
    private String crq_prc;
    private String crq_note;

    public CodeRequestVo() {
    }

    public CodeRequestVo(String crq_no, String crq_dept, String crq_emp, String crq_name, String crq_date, String crq_div, String crq_prc, String crq_note) {
        this.crq_no = crq_no;
        this.crq_dept = crq_dept;
        this.crq_emp = crq_emp;
        this.crq_name = crq_name;
        this.crq_date = crq_date;
        this.crq_div = crq_div;
        this.crq_prc = crq_prc;
        this.crq_note = crq_note;
    }

    public String getCrq_no() {
        return crq_no;
    }

    public void setCrq_no(String crq_no) {
        this.crq_no = crq_no;
    }

    public String getCrq_dept() {
        return crq_dept;
    }

    public void setCrq_dept(String crq_dept) {
        this.crq_dept = crq_dept;
    }

    public String getCrq_emp() {
        return crq_emp;
    }

    public void setCrq_emp(String crq_emp) {
        this.crq_emp = crq_emp;
    }

    public String getCrq_name() {
        return crq_name;
    }

    public void setCrq_name(String crq_name) {
        this.crq_name = crq_name;
    }

    public String getCrq_date() {
        return crq_date;
    }

    public void setCrq_date(String crq_date) {
        this.crq_date = crq_date;
    }

    public String getCrq_div() {
        return crq_div;
    }

    public void setCrq_div(String crq_div) {
        this.crq_div = crq_div;
    }

    public String getCrq_prc() {
        return crq_prc;
    }

    public void setCrq_prc(String crq_prc) {
        this.crq_prc = crq_prc;
    }

    public String getCrq_note() {
        return crq_note;
    }

    public void setCrq_note(String crq_note) {
        this.crq_note = crq_note;
    }
}
