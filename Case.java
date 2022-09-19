
public class Case {
	private Treatment treatment;
	private InsuranceCompanies insurance;

	public Case(Treatment t, InsuranceCompanies i) {
		this.treatment = t;
		this.insurance = i;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}

	public InsuranceCompanies getInsurance() {
		return insurance;
	}

	public void setInsurance(InsuranceCompanies insurance) {
		this.insurance = insurance;
	}

}
