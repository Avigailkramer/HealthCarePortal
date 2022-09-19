
//calculates the bill based on the treatment and insurance
public class Bill {
	private int coPay; // what the patient has to pay
	private int insurancePaid; // what insurance covers

	public int getCoPay() {
		return coPay;
	}

	public void setCoPay(int coPay) {
		this.coPay = coPay;
	}

	public int getInsurancePaid() {
		return insurancePaid;
	}

	public void setInsurancePaid(int insurancePaid) {
		this.insurancePaid = insurancePaid;
	}

}
