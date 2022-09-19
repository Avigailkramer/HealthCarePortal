

import java.time.LocalDate;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class MedicalBillingOrganizerMain {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		// arraylist that will hold the patients
		ArrayList<Patient> patients = new ArrayList<Patient>();

		// read from the file and put all the patients into the arraylist
		try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("PatientInfo.txt"));) {
			patients = loadPatientsFromFile(objectIn);
		} catch (Exception e) {
		}
 
		try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("PatientInfo.txt"));) {

			// all the patients were read from the file and removed from the file when it
			// was read and so theyre no longer in it,
			// so put them back in
			for (int i = 0; i < patients.size(); i++) {
				objectOut.writeObject(patients.get(i));
			}
			
			
			
			
			
			

			while (true) {
//				 setting the current patient to null, it will be set to an actual patient
//				 object later on
				Patient currPatient = null;

				// set the answer to a, will be changed when the user inputs an answer
				char answer = 'a';

				// loop for input validation
				while ((answer != 'Y') && (answer != 'N') && (answer != 'E')) {
					System.out.println("Are you Already in our System? enter yes/no, or press e to exit");
					answer = input.nextLine().toUpperCase().charAt(0);
				}

				// if they are already in the system
				if (answer == 'Y') {

					// loop until they enter a patient id that we have in the system
					while (currPatient == null) {
						// search them based on their patient id and set them to the current patient
						System.out.println("Enter your patient id");
						int id = Integer.parseInt(input.nextLine());

						// loop thru the patient arraylist and find the patient that matches the patient
						// id they entered
						for (int i = 0; i < patients.size(); i++) {
							if (id == patients.get(i).getPatientId()) {
								currPatient = patients.get(i);
							}
						}
					}
					// print out the name that correspond with this patient
					System.out.println("Your name is: " + currPatient.getName());

					// if they are not in the system yet
				} else if (answer == 'N') {
					// Patient info

					System.out.println("Please enter your full name:");
					String name = input.nextLine();

					LocalDate dateOfBirth = getDOB(input);

					System.out.println("Please enter you SSN:");
					String SSNumber = input.next();
					while (SSNumber.length() != 9) {
						System.out.println("Enter a VALID SSN number:");
						SSNumber = input.next();
					}

					// clearing the buffer
					input.nextLine();

					System.out.println("Enter the first line of your address:");
					String address = input.nextLine();

					// set the currpatient to a new patient based on this info
					currPatient = new Patient(name, dateOfBirth, SSNumber);
					patients.add(currPatient);
					objectOut.writeObject(currPatient);

					//
					System.out.println("Your patient id is " + currPatient.getPatientId());

					// if they chose to exit
				} else if (answer == 'E') {
					System.exit(0);
				}

				// we dont need this stuff for the demos

//			// calling insurance company method
//			InsuranceCompanies i = getInsuranceClient(input);
//
//			// calling method to get the treatment type
//			Treatment t = getTreatmentName(input);
//
//			// adding a new case to this patient
//			currPatient.addCase(new Case(t, i));

			}
		} catch (Exception e) {

		}

	}

	public static ArrayList<Patient> loadPatientsFromFile(ObjectInputStream ois) {

		ArrayList<Patient> p = new ArrayList<>();
		try {
			while (true) {
				p.add((Patient) ois.readObject());
				// for every patient we are reading, we need to increment the counter that gives
				// out patient ids becuase we dont want duplicate ids
				Patient.incrementPatientId();
			}
		} catch (Exception e) {
			return p;
		}

	}

	public static LocalDate getDOB(Scanner input) {
		System.out.println("What is your Date of birth? (dd/MM/yyyy)");
		while (!input.hasNext("([0-9]{2})/([0-9]{2})/([0-9]){4}")) {
			System.out.print("That's not a valid date. Enter the date again: ");
			input.nextLine();
		}

		String dateOfBirth = input.next();

		int month = Integer.parseInt(dateOfBirth.substring(0, 2));
		int date = Integer.parseInt(dateOfBirth.substring(3, 5));
		int year = Integer.parseInt(dateOfBirth.substring(6, 10));
		LocalDate dob = LocalDate.of(year, month, date);

		// clearing the buffer
		input.nextLine();

		return dob;
	}
//
//	public static InsuranceCompanies getInsuranceClient(Scanner input) {
//		int numInsurance;
//		InsuranceCompanies company = null; // will change in the switch statements
//		System.out.println("1) Medicaid\n2) UnitedHealth\n3)EmblemHealth\n4)Cigna\n5)Aetna\n6)Molina\n7)Anthem");
//		do {
//			System.out.print("Please enter the number of your insurance: ");
//			numInsurance = input.nextInt();
//		} while (numInsurance < 0 || numInsurance > 7);
//		switch (numInsurance) {
//		case 1:
//			company = InsuranceCompanies.Medicaid;
//			break;
//		case 2:
//			company = InsuranceCompanies.UnitedHealth;
//			break;
//		case 3:
//			company = InsuranceCompanies.EmblemHealth;
//			break;
//		case 4:
//			company = InsuranceCompanies.Cigna;
//			break;
//		case 5:
//			company = InsuranceCompanies.Aetna;
//			break;
//		case 6:
//			company = InsuranceCompanies.Molina;
//			break;
//		case 7:
//			company = InsuranceCompanies.Anthem;
//			break;
//		}
//
//		// clearing the buffer
//		input.nextLine();
//
//		return company;
//
//	}
//
//	public static Treatment getTreatmentName(Scanner input) {
//		int treatmentNum;
//		Treatment treatment = null; // for now
//		System.out.println("Enter the number of your treatment: ");
//		System.out.println("1.CT Scan \n2.Echocardiogram \n3.Bypass Surgery \n4.Hip Replacment"
//				+ "\n5.MRI \n6.Upper Endoscopy \n7.Xray");
//		treatmentNum = input.nextInt();
//		if (treatmentNum > 0 && treatmentNum < 7) {
//			switch (treatmentNum) {
//			case 1:
//				treatment = Treatment.CT_SCAN;
//				break;
//			case 2:
//				treatment = Treatment.ECHOCARDIOGRAM;
//				break;
//			case 3:
//				treatment = Treatment.HEART_BYPASS_SURGERY;
//				break;
//			case 4:
//				treatment = Treatment.HIP_REPLACEMENT_SURGERY;
//				break;
//			case 5:
//				treatment = Treatment.MRI;
//				break;
//			case 6:
//				treatment = Treatment.UPPER_ENDOSCOPY;
//				break;
//			case 7:
//				treatment = Treatment.XRAY;
//				break;
//			}
//
//			// clearing the buffer
//			input.nextLine();
//		}
//		return treatment;
//
//	}

}