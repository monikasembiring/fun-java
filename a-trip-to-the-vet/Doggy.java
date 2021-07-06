package objectoriented;

public class Doggy extends Pet{
	private double droolRate;
	public static final double DEFAULT_DROLL_RATE = 5.0;
	
	public Doggy(String name, double health, int painLevel, double droolRate) {
		super(name, health, painLevel);
		if (droolRate <= 0.0) {
			this.droolRate = 0.5;
		} else {
			this.droolRate = droolRate;
		}
	}
	
	public Doggy(String name, double health, int painLevel) {
		this(name, health, painLevel, DEFAULT_DROLL_RATE);
	}
	
	public String getName() {
		return super.getName();
	}
	
	public double getHealth() {
		return super.getHealth();
	}
	
	public int getPainLevel() {
		return super.getPainLevel();
	}
	
	public double getDroolRate() {
		return droolRate;
	}
	
	public int treat() {
		super.heal();
		if (droolRate < 3.5) {
			return (int)(Math.ceil((getPainLevel()*2)/getHealth()));
		} else if (droolRate >= 3.5 && droolRate <= 7.5) {
			return (int)(Math.ceil(getPainLevel()/getHealth()));
		} else {
			return (int)(Math.ceil(getPainLevel()/(getHealth()*2)));
		}
	}
	
	public void speak() {
		super.speak();
		int count = getPainLevel();
		if (count > 5) {
			for (int i=0; i<count; i++) {
				System.out.print("BARK ");
			}
		} else {
			for (int i=0; i<count; i++) {
				System.out.print("bark ");
			}
		}
		
	}
	
	public boolean equals(Object o) {
	    if (!(o instanceof Doggy)) {
	        return false;
	    }
	    Doggy doggy = (Doggy) o;
	    return (super.equals(doggy) && (doggy.droolRate == droolRate));
	}
}
