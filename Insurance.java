
public class Insurance {
	private int insuranceID;
	private int dateBegan;
	private int yearBegan;
	

	public Insurance (int ID, int dayDate, int yearDate) {
		insuranceID= ID;
		dateBegan= dayDate;
		yearBegan= yearDate; 
	}
	public int getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}
	public int getDateBegan() {
		return dateBegan;
	}
	public void setDateBegan(int dateBegan) {
		this.dateBegan = dateBegan;
	}
	public int getYearBegan() {
		return yearBegan;
	}
	public void setYearBegan(int yearBegan) {
		this.yearBegan = yearBegan;
	}
	

}
