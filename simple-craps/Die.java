package objectoriented;
import java.util.Random;

public class Die {
	
	//instance variables
	public static final int SIDE = 6;;
	private int face;
	private Random rand;
	
	//constructor
	public Die () {
		face = 1;
		rand = new Random();
	}	
	
	//methods
	public int roll() {
		face = rand.nextInt(SIDE) + 1;
		return face;
	}
	
	public int getFace() {
		return face;
	}
	
	public String toString() {
		return "Die with face value: " + face;
	}
}	
