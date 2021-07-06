package objectoriented;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{
	//instance variable
	private int numTasks;
	private int taskSpeed;
	public static final int DEFAULT_SUSLEVEL = 15;
	public static final int DEFAULT_NUM_TASKS = 6;
	public static final int DEFAULT_INT_TASK_SPEED = 10;
	
	//constructor
	public BlueAstronaut (String name, int susLevel, int numTasks, int taskSpeed) {
		super(name, susLevel);
		this.numTasks = numTasks;
		this.taskSpeed = taskSpeed;
	}
	
	public BlueAstronaut (String name) {
		this(name, DEFAULT_SUSLEVEL, DEFAULT_NUM_TASKS, DEFAULT_INT_TASK_SPEED);
	}
	
	//methods
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
	
	int count = 0;
	public void completeTask() {
		if (!super.isFrozen()) {
			if (taskSpeed > 20) {
				numTasks = numTasks - 2;
			} else {
				numTasks = numTasks - 1;
			}
			if (numTasks <= 0) {
				numTasks = 0;
				taskSpeed = 0;
				count++;
			}
		}
	
		if (numTasks == 0 && count == 1) { //only for the first time? have I implemented this yet? yes, you did by handling taskSpeed
			System.out.println("I have completed all my tasks");
			super.setSusLevel((int)(0.5*getSusLevel()));
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof BlueAstronaut) {
            BlueAstronaut red = (BlueAstronaut) o;
            return super.getName().equals(red.getName()) && super.isFrozen() == red.isFrozen()
                    && super.getSusLevel() == red.getSusLevel();
        }
        return false;
	}
	
	public String toString() {
        String statement = super.toString() + " I have " + this.numTasks + " left over.";
        if(this.getSusLevel() > 15) {
        	return statement.toUpperCase();
        } else {
        	return statement;
        }
    }
}
