package objectoriented;

public class Fly {
	//instance variables
	private double mass;
	private double speed;
	public static final double DEFAULT_SPEED = 10;
	public static final double DEFAULT_MASS = 5;
	
	//constructors
	public Fly (double mass, double speed) {
		this.mass = mass;
		this.speed = speed;
	}
	
	public Fly (double mass) {
		this(mass, DEFAULT_SPEED);
	}
	
	public Fly () {
		this(DEFAULT_MASS, DEFAULT_SPEED);
	}
	
	//method
	public double getMass() {
		return mass;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public String toString() {
		if (mass == 0) {
			return "I'm dead, but I used to be a fly with speed of " + speed +"."; 
		} else {
			return "I'm a speedy fly with " + speed + " speed and " + mass + " mass.";
		}
	}
	
	public void grow(int addMass) {
		int i = 0;
		while (i != addMass) {
			mass++;
			if (mass <= 20) {
				speed++;
			} else {
				speed = speed - 0.5;
			}
			i++;
		}
	}
	
	public boolean isDead() {
		if (mass==0) {
			return true;
		} else {
			return false;
		}
	}
}
