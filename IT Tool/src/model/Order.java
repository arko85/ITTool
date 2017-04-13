package model;

import java.time.LocalDate;

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
			Status status) {

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
