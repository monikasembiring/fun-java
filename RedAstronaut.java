package objectoriented;
import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
	//instance variable
	private String skill;
	public static final int DEFAULT_SUSLEVEL = 15;
	public static final String DEFAULT_SKILL = "experienced";
	
	//constructor
	public RedAstronaut(String name, int susLevel, String skill) {
		super(name, susLevel);
		this.skill = skill;
	}
	
	public RedAstronaut(String name) {
		this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
	}
	
	//method
	public void emergencyMeeting() {
		if (!super.isFrozen()) {
			Player[] players = super.getPlayers();
			Arrays.sort(players);
			int pointer = players.length-1;
			int second;
			while (players[pointer].isFrozen() == true) {
				pointer--;
			}
			second = pointer-1;
			while (players[second].isFrozen() == true) {
				second--;
			}
			if (players[pointer].getSusLevel() == players[second].getSusLevel()) {
					
			} else if (players[pointer].getName() != super.getName()) {
				players[pointer].setFrozen(true);
			}
		}
		gameOver();
	}
	
	public void freeze(Player p) {
		if (p instanceof Impostor || super.isFrozen() == true || p.isFrozen() == true){
			return;
		} else {
			if (this.getSusLevel() < p.getSusLevel()) {
				p.setFrozen(true);
			} else {
				this.setSusLevel(getSusLevel()*2);
			}
		}
		gameOver();
	}
	
	public void sabotage(Player p) {
		if (p instanceof Impostor || super.isFrozen() == true || p.isFrozen() == true){
			return;
		} else {
			if (this.getSusLevel() < 20) {
				p.setSusLevel((int)(1.5*p.getSusLevel()));
			} else {
				p.setSusLevel((int)(1.25*p.getSusLevel()));
			}
		}
	}
	
	public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut red = (RedAstronaut) o;
            return super.getName().equals(red.getName()) && super.isFrozen() == red.isFrozen()
                    && super.getSusLevel() == red.getSusLevel();
        }
        return false;
    }
	
	public String toString() {
        String statement = super.toString() + " I am an " + this.skill + " player!";
        if(this.getSusLevel() > 15) {
        	return statement.toUpperCase();
        } else {
        	return statement;
        }
    }
}
