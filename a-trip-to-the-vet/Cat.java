package objectoriented;

public class Cat extends Pet {
	private int miceCaught;
	public static final int DEFAULT_MICE_CAUGHT = 0;
	
	public Cat(String name, double health, int painLevel, int miceCaught) {
		super(name, health, painLevel);
		if (miceCaught < 0) {
			this.miceCaught = 0;
		} else {
			this.miceCaught = miceCaught;
		}
	}
	
	public Cat(String name, double health, int painLevel) {
		this(name, health, painLevel, DEFAULT_MICE_CAUGHT);
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
	
	public double getMiceCaught() {
		return miceCaught;
	}
	
	public int treat() {
		super.heal();
		if (miceCaught < 4) {
			return (int)(Math.ceil((getPainLevel()*2)/getHealth()));
		} else if (miceCaught >= 4 && miceCaught <= 7) {
			return (int)(Math.ceil(getPainLevel()/getHealth()));
		} else {
			return (int)(Math.ceil(getPainLevel()/(getHealth()*2)));
		}
	}
	
	public void speak() {
		super.speak();
		if (miceCaught >= 5) {
			for (int i=0; i<miceCaught; i++) {
				System.out.print("MEOW ");
			}
		} else {
			for (int i=0; i<miceCaught; i++) {
				System.out.print("meow ");
			}
		}
	}
	
	public boolean equals(Object o) {
	    if (!(o instanceof Cat)) {
	        return false;
	    }
	    Cat cat = (Cat) o;
	    return (super.equals(cat) && (cat.miceCaught == miceCaught));
	}
}
