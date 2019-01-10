package production.vo;

public class QualityVo {
    private String qual_code;
    private String qual_date;
    private String qual_level;
    private String qual_note;
    private String qual_write;
    private String qual_qty;

    public QualityVo() {
    }

    public QualityVo(String qual_code, String qual_date, String qual_level, String qual_note) {
        this.qual_code = qual_code;
        this.qual_date = qual_date;
        this.qual_level = qual_level;
        this.qual_note = qual_note;
    }

    public String getQual_code() {
        return qual_code;
    }

    public void setQual_code(String qual_code) {
        this.qual_code = qual_code;
    }

    public String getQual_date() {
        return qual_date;
    }

    public void setQual_date(String qual_date) {
        this.qual_date = qual_date;
    }

    public String getQual_level() {
        return qual_level;
    }

    public void setQual_level(String qual_level) {
        this.qual_level = qual_level;
    }

    public String getQual_note() {
        return qual_note;
    }

    public void setQual_note(String qual_note) {
        this.qual_note = qual_note;
    }

	public String getQual_write() {
		return qual_write;
	}

	public void setQual_write(String qual_write) {
		this.qual_write = qual_write;
	}

	public String getQual_qty() {
		return qual_qty;
	}

	public void setQual_qty(String qual_qty) {
		this.qual_qty = qual_qty;
	}
	
    
}