package material.vo;

public class Machine {
    private String mach_code;
    private String mach_buyer;
    private String mach_name;
    private String mach_date;
    private int mach_qty;
    private String mach_note;

    public Machine() {
    }

    public Machine(String mach_code, String mach_buyer, String mach_name, String mach_date, int mach_qty, String mach_note) {
        this.mach_code = mach_code;
        this.mach_buyer = mach_buyer;
        this.mach_name = mach_name;
        this.mach_date = mach_date;
        this.mach_qty = mach_qty;
        this.mach_note = mach_note;
    }

    public String getMach_code() {
        return mach_code;
    }

    public void setMach_code(String mach_code) {
        this.mach_code = mach_code;
    }

    public String getMach_buyer() {
        return mach_buyer;
    }

    public void setMach_buyer(String mach_buyer) {
        this.mach_buyer = mach_buyer;
    }

    public String getMach_name() {
        return mach_name;
    }

    public void setMach_name(String mach_name) {
        this.mach_name = mach_name;
    }

    public String getMach_date() {
        return mach_date;
    }

    public void setMach_date(String mach_date) {
        this.mach_date = mach_date;
    }

    public int getMach_qty() {
        return mach_qty;
    }

    public void setMach_qty(int mach_qty) {
        this.mach_qty = mach_qty;
    }

    public String getMach_note() {
        return mach_note;
    }

    public void setMach_note(String mach_note) {
        this.mach_note = mach_note;
    }
}
