package objectoriented;

public class Frog {
	//instance variables
	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet;
	private static String species = "Rare Pepe";
	public static final int DEFAULT_AGE = 5;
	public static final double DEFAULT_TONGUESPEED = 5;
	
	//constructors
	public Frog (String name, int age, double tongueSpeed) {
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
		
	}
	
	public Frog (String name, double ageInYears, double tongueSpeed) {
		this(name, (int)(ageInYears*12), tongueSpeed);
		this.isFroglet(age);
	}
	
	public Frog (String name) {
		this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
		this.isFroglet(age);
	}
	
	//method
	private void isFroglet(int age) {
		if (age>1 && age<7) {
			isFroglet = true;
		} else {
			isFroglet = false;
		}
	}
	
	public void grow (int month) {
		age = age + month;
		if (age<12) {
			tongueSpeed = tongueSpeed + (1*month);
		} else if (age >= 30) {
			if ((tongueSpeed - (1*(age-30)) >= 5)) {
				tongueSpeed = tongueSpeed - (1*(age-30));
			}
		}
		this.isFroglet(age);
	}
	
	public void grow () {
		age = age + 1;
		if (age<12) {
			tongueSpeed = tongueSpeed + (1);
		} else if (age >= 30) {
			if ((tongueSpeed - (1*(age-30)) >= 5)) {
				tongueSpeed = tongueSpeed - (1*(age-30));
			}
		}
		this.isFroglet(age);
		System.out.println(isFroglet);
	}
	
	public void eat (Fly f) {
		if (f.isDead()) {
		}
		if (tongueSpeed > f.getSpeed()) {
			System.out.println("The fly is caught!");
			if (f.getMass() >= (0.5*age)) {
				this.grow();
			}
			f.setMass(0);
		} else {
			f.grow(1);
		}
	}
	
	public String toString() {
		if (isFroglet == true) {
			return "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
		} else {
			return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
		}
	}
	
	public String getSpecies () {
		return species;
	}
	
	public void setSpecies (String species) {
		this.species = species;
	}
	
	public static void main (String[] args) {
		Frog frog1 = new Frog("Peepaw", 4.6, 5);
		//frog1.grow();
		System.out.println(frog1.toString());
		System.out.println((int)(4.6*12));
	}
}
