package model;

public class PO_Position {
	String deptName;
	String positonName;
	int quantity;
	int price;
	int totalPrice;
	String number_EW;
	String budgetLineCode;
	String projectCode;
	String mpkCode;
	String mpkStatic;
	int mpkStaticPrice;
	String accountingCode;
	String tag;
	public PO_Position(String deptName, String positonName, int quantity, int price, int totalPrice, String number_EW,
			String budgetLineCode, String projectCode, String mpkCode, String mpkStatic, int mpkStaticPrice,
			String accountingCode, String tag) {
		super();
		this.deptName = deptName;
		this.positonName = positonName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.number_EW = number_EW;
		this.budgetLineCode = budgetLineCode;
		this.projectCode = projectCode;
		this.mpkCode = mpkCode;
		this.mpkStatic = mpkStatic;
		this.mpkStaticPrice = mpkStaticPrice;
		this.accountingCode = accountingCode;
		this.tag = tag;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPositonName() {
		return positonName;
	}
	public void setPositonName(String positonName) {
		this.positonName = positonName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getNumber_EW() {
		return number_EW;
	}
	public void setNumber_EW(String number_EW) {
		this.number_EW = number_EW;
	}
	public String getBudgetLineCode() {
		return budgetLineCode;
	}
	public void setBudgetLineCode(String budgetLineCode) {
		this.budgetLineCode = budgetLineCode;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getMpkCode() {
		return mpkCode;
	}
	public void setMpkCode(String mpkCode) {
		this.mpkCode = mpkCode;
	}
	public String getMpkStatic() {
		return mpkStatic;
	}
	public void setMpkStatic(String mpkStatic) {
		this.mpkStatic = mpkStatic;
	}
	public int getMpkStaticPrice() {
		return mpkStaticPrice;
	}
	public void setMpkStaticPrice(int mpkStaticPrice) {
		this.mpkStaticPrice = mpkStaticPrice;
	}
	public String getAccountingCode() {
		return accountingCode;
	}
	public void setAccountingCode(String accountingCode) {
		this.accountingCode = accountingCode;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return  deptName + ";" + positonName + ";" + quantity
				+ ";" + price + ";" + totalPrice + ";" + number_EW + ";"
				+ budgetLineCode + ";" + projectCode + ";" + mpkCode + ";" + mpkStatic
				+ ";" + mpkStaticPrice + ";" + accountingCode + ";" + tag;
	}

}
