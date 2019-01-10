package outsourcing.vo;

import javafx.scene.layout.AnchorPane;


/**
 * Create an anchor pane that can store additional data.
 */
public class SchedulePlanVo extends AnchorPane {

    // Date associated with this pane
    private String schPlan_date;
	private String schPlan_note1;
	private String schPlan_note2;
	private String schPlan_note3;
	private String schPlan_note4;

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    
    public SchedulePlanVo() {
//    	   this.setOnMouseClicked(e ->  testVo());
    }

	public String getSchPlan_date() {
		return schPlan_date;
	}

	public void setSchPlan_date(String schPlan_date) {
		this.schPlan_date = schPlan_date;
	}

	public String getSchPlan_note1() {
		return schPlan_note1;
	}

	public void setSchPlan_note1(String schPlan_note1) {
		this.schPlan_note1 = schPlan_note1;
	}

	public String getSchPlan_note2() {
		return schPlan_note2;
	}

	public void setSchPlan_note2(String schPlan_note2) {
		this.schPlan_note2 = schPlan_note2;
	}

	public String getSchPlan_note3() {
		return schPlan_note3;
	}

	public void setSchPlan_note3(String schPlan_note3) {
		this.schPlan_note3 = schPlan_note3;
	}

	public String getSchPlan_note4() {
		return schPlan_note4;
	}

	public void setSchPlan_note4(String schPlan_note4) {
		this.schPlan_note4 = schPlan_note4;
	}

	
	


}
