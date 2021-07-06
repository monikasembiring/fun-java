package objectoriented;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;

public class Clinic {
	private File patientFile;
	private int day;
	
	public Clinic(File file) {
		patientFile = file;
	}
	
	public Clinic(String fileName) {
		this(new File(fileName));
	}
	
	//public String nextDay(File f) throws IOException {
	public static void main (String[] args) throws IOException {
		String line = "";  
		String splitBy = ",";
		String[] appointment = null;
		boolean success1 = false;
		boolean success2 = false;
		double health = 0.0;
		int painLevel = 0;
	    
		BufferedReader br = new BufferedReader(new FileReader("Appointments.csv"));
		Scanner input = new Scanner(System.in);
		while ((line = br.readLine()) != null) { //returns a Boolean value  
			appointment = line.split(splitBy); // use comma as separator  
			//System.out.println("Appointment [Name=" + appointment[0] + ", Type=" + appointment[1] + ", Identity=" + appointment[2] + ", Time=" + appointment[3] +"]");  
			System.out.println("Consultation for " + appointment[0] + " the " + appointment[1] + " at " + appointment[3]);
			if (appointment[1].equals("Doggy") == false && appointment[1].equals("Cat") == false) {
				throw new InvalidPetException();
			}
			
			while (!success1) {
				try {
					System.out.print("What is the health of " + appointment[0] + "?\n");
					health = input.nextDouble();
					success1 = true;
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("Please enter a number.");
				}
			}
			
			while (!success2) {
				try {
					System.out.print("On a scale of 1 to 10, how much pain is " + appointment[0] + " in right now?\n");
					painLevel = input.nextInt();
					success2 = true;
				} catch (InputMismatchException e) {
					input.nextLine();
					System.out.println("Please enter a number.");
				}
			}
			if (appointment[1].equals("Doggy")) {
				Doggy dog = new Doggy(appointment[0], health, painLevel, Double.parseDouble(appointment[2]));
				long start = System.currentTimeMillis();
				System.out.print(start);
				dog.speak();
				dog.treat();
			    long end = System.currentTimeMillis();
			    System.out.print(end);
			   // Clinic.day++;
			} else if (appointment[1].equals("Cat")) {
				Cat cat = new Cat(appointment[0], health, painLevel, Integer.parseInt(appointment[2]));
				long start = System.currentTimeMillis();
				System.out.print(start);
				cat.speak();
				cat.treat();
			    long end = System.currentTimeMillis();
			    System.out.print(start);
			    //day++;
			}
			//return 
			
		}
		
	    
		
	}
	
	//public String nextDay(String fileName) throws FileNotFoundException {
		
	//}
	//private String addTime(String timeIn, int treatmentTime) {
		
	//}
}
