package model;

import java.time.LocalDate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Order {
	int id;
	LocalDate data;
	String Towar;
	int ilosczam;
	String pO;
	int iloscodeb;
	int mpk;
	String odbiorca;
	Status status;


	public Order(int id, LocalDate data, String towar, int ilosczam, String pO, int iloscodeb, int mpk, String odbiorca,
			Status status, Boolean checked) {

		this.id = id;
		this.data = data;
		Towar = towar;
		this.ilosczam = ilosczam;
		this.pO = pO;
		this.iloscodeb = iloscodeb;
		this.mpk = mpk;
		this.odbiorca = odbiorca;
		this.status = status;


	}
	private SimpleBooleanProperty checked = new SimpleBooleanProperty(false);
	   // other columns here

	    public SimpleBooleanProperty checkedProperty() {
	        return this.checked;
	    }

	    public java.lang.Boolean getChecked() {
	        return this.checkedProperty().get();
	    }

	    public void setChecked(final java.lang.Boolean checked) {
	        this.checkedProperty().set(checked);
	    }
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getTowar() {
		return Towar;
	}
	public void setTowar(String towar) {
		Towar = towar;
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
		return odbiorca;
	}
	public void setOdbiorca(String odbiorca) {
		this.odbiorca = odbiorca;
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






}
