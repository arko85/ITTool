package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {
	int id;
	LocalDate data;
	String towar;
	int ilosczam;
	String pO;
	int iloscodeb;
	int mpk;
	String uwagi;
	Status status;


	public Order(int id, LocalDate data, String towar, int ilosczam, String pO, int iloscodeb, int mpk, String odbiorca,
			Status status) {

		this.id = id;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.getDefault() );
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
	public int getMpk() {
		return mpk;
	}
	public void setMpk(int mpk) {
		this.mpk = mpk;
	}
	public String getOdbiorca() {
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
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public void setChecked(SimpleBooleanProperty checked) {
		this.checked = checked;
	}
*/





}
