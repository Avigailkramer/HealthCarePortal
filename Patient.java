import java.time.*;
import java.util.ArrayList;
import java.io.Serializable;

public class Patient implements Serializable {

	private String name;
	private int patientId;
	private LocalDate dateOfBirth;
	private String SSNumber;
	private String address;
	private ArrayList<Case> cases = new ArrayList<Case>();
	
	//gonna increment this number for each new patient and set it to their patient id this way each patient has a unique patiney
	private static int patientIdValue = 1000;
	
	//constructor
	public Patient(String name, LocalDate dob, String SSNumber) {
		if(SSNumber.length()!=9) {
			throw new IllegalArgumentException("Social Security Number Must be 9 digits");
		}
		this.name = name;
		//increment the patient id number trackerientIdValue
		patientIdValue++;
		//set the patient id to be this new incremented number this way
		this.patientId =  patientIdValue;
		this.dateOfBirth = dob;
		this.SSNumber = SSNumber;
	}
	public static void incrementPatientId() {
		patientIdValue++;

	}
	
	public int getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getSSNumber() {
		return SSNumber;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAbove18() {
		LocalDate today = LocalDate.now();
		Period timeInBetween 
				= Period.between(this.dateOfBirth,today);
		
		return timeInBetween.getYears() >= 18;
	}
	public boolean isAbove65() {
		LocalDate today = LocalDate.now();
		Period timeInBetween 
				= Period.between(this.dateOfBirth,today);
		
		return timeInBetween.getYears() >= 65;
	}
	public int getAge() {
		LocalDate today = LocalDate.now();
		Period age 
				= Period.between(this.dateOfBirth,today);
		
		return age.getYears();
	}
	public void addCase(Case c) {
		this.cases.add(c);
	}
	//return the requested case
	public Case getCase(int i) {
		return this.cases.get(i);
	}
}
