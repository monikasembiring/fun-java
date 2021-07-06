public abstract class Pet {
	private String name;
	private double health;// = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
	private int painLevel; //= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public Pet(String name, double health, int painLevel) {
		this.name = name;
		if (health > 1.0) {
			this.health = 1.0;
		} else if (health < 0.0) {
			this.health = 0.0;
		} else {
			this.health = health;
		}
		if (painLevel > 10) {
			this.painLevel = 10;
		} else if (painLevel < 1) {
			this.painLevel = 1;
		} else {
			this.painLevel = painLevel;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public double getHealth() {
		return health;
	}
	
	public int getPainLevel() {
		return painLevel;
	}
	
	public abstract int treat();
	
	public void speak() {
		if (painLevel > 5) {
			System.out.println(("Hello! My name is " + name).toUpperCase());
		} else {
			System.out.println("Hello! My name is " + name);
		}
	}
	
	public boolean equals(Object o) {
	    if (!(o instanceof Pet)) {
	        return false;
	    }
	    Pet pet = (Pet) o;
	    return ((pet.name == name));
	}
	
	protected void heal() {
		health = 1.0;
		painLevel = 1;
	}
}
