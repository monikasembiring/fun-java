package objectoriented;

public class Craps {
	private Die die1, die2;
	private int point;
	
	public Craps() {
		die1 = new Die();
		die2 = new Die();
	}
	
	private int toss() {
		int sum = die1.roll() + die2.roll();
		System.out.println("Die One: " + die1.getFace());
		System.out.println("Die Two: " + die2.getFace());
		return sum;
	}
	
	private void go() {
		point = toss();
		System.out.println("Point: " + point);
		if (point == 7 || point == 11) {
			System.out.println("You win!");
		} else if (point == 2 || point == 3 || point == 12) {
			System.out.println("You lose!");
		} else {
			System.out.println("You got point number : " + point);
			System.out.println("Entering stage 2");
			stage2();
		}
	}
	
	public void stage2 () {
		boolean endGame = false;
		while (!endGame) {
			int sum = toss();
			System.out.println("Point: " + sum);
			if (sum == point) {
				System.out.println("You win!");
				endGame = true;
			} else if (sum == 7) {
				System.out.println("You lose!");
				endGame = true;
			}
		}
	}
	public static void main (String[] args) {
		Craps game = new Craps();
		game.go();
	}
}