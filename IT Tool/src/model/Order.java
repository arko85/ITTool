package model;

import java.time.LocalDate;



public class Order {
	String id;
	LocalDate data;
	String towar;
	int ilosczam;
	String pO="PO";
	int iloscodeb;
	String mpk;
	String uwagi;
	Status status;


	public Order(String id, LocalDate data, String towar, int ilosczam, String pO, int iloscodeb, String mpk, String odbiorca,
			Status status) {

		this.id=id;
		this.data = data;
		this.towar = towar;
		this.ilosczam = ilosczam;
		this.pO = pO;
		this.iloscodeb = iloscodeb;
		this.mpk = mpk;
		this.uwagi = odbiorca;
		this.status = status;


	}
	public Order() {
		// TODO Auto-generated constructor stub
	}
//	private SimpleBooleanProperty checked = new SimpleBooleanProperty(false);
//	   // other columns here
//
//	    public SimpleBooleanProperty checkedProperty() {
//	        return this.checked;
//	    }
//
//	    public java.lang.Boolean getChecked() {
//	        return this.checkedProperty().get();
//	    }
//
//	    public void setChecked(final java.lang.Boolean checked) {
//	        this.checkedProperty().set(checked);
//	    }
	public LocalDate getData() {
		return data;
	}
	public void setData(String data) {

		this.data=LocalDate.parse(data);

	}
	public String getTowar() {

		return towar;
	}
	public void setTowar(String towar) {
		this.towar = towar;
	}
	public int getIlosczam() {
		return ilosczam;
	}
	public void setIlosczam(int ilosczam) {
		this.ilosczam = ilosczam;
	}
	public String getpO() {
		return pO;
	}
	public void setpO(String pO) {
		this.pO = pO;
	}
	public int getIloscodeb() {
		return iloscodeb;
	}
	public void setIloscodeb(int iloscodeb) {
		this.iloscodeb = iloscodeb;
	}
	public String getMpk() {
		return mpk;
	}
	public void setMpk(String mpk) {

		this.mpk = mpk;

	}
	public String getUwagi() {
		return uwagi;
	}
	public void setOdbiorca(String odbiorca) {
		this.uwagi = odbiorca;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getId() {
		// TODO Auto-generated method stub

		return id;
	}
	public void setId(String id) {
		this.id =id;
	}
	/*public void setChecked(SimpleBooleanProperty checked) {
		this.checked = checked;
	}
*/





}
