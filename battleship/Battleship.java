package basic;
import java.util.Scanner;

public class Battleship {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");
		
		//Player 1 insert their ship to board
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES");
		char[][] board1 = new char[5][5];
		int count1 = 1;
		do {
			System.out.println("Enter ship " + (count1) + " location:");
			int row = input.nextInt();
			int col = input.nextInt();
			if (row < 0 || row >= board1.length || col < 0 || col >= board1.length ) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
			} else if (board1[row][col] == '@') {
				System.out.println("You already have a ship there. Choose different coordinates.");
			} else {
				insertToBoard(board1, row, col);
				count1++;
			}
		} while (count1 <= 5);
		printBoard(board1);
		
		for (int i=0; i<100; i++)
		System.out.println("");
		
		//Player 2 insert their ship to board
		System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES");
		char[][] board2 = new char[5][5];
		int count2 = 1;
		do {
			System.out.println("Enter ship " + (count2) + " location:");
			int row = input.nextInt();
			int col = input.nextInt();
			if (row < 0 || row >= board2.length || col < 0 || col >= board2.length ) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
			} else if (board2[row][col] == '@') {
				System.out.println("You already have a ship there. Choose different coordinates.");
			} else {
				insertToBoard(board2, row, col);
				count2++;
			}
		} while (count2 <= 5);
		printBoard(board2);
		System.out.println("");
		
		//Initialize player 1 history board
		char[][] historyBoard1 = new char[5][5];
		for (int i=0; i<historyBoard1.length; i++) {
			for (int j=0; j<historyBoard1.length; j++) {
				historyBoard1[i][j] = '-';
			}
		}
		
		//Initialize player 1 history board
		char[][] historyBoard2 = new char[5][5];
		for (int i=0; i<historyBoard2.length; i++) {
			for (int j=0; j<historyBoard2.length; j++) {
				historyBoard2[i][j] = '-';
			}
		}
		
		//Player round
		boolean complete = false;
		int winner = 0;
		while (complete== false) {
			//Player 1 round
			boolean status1 = false;
			int row = 0;
			int col = 0;
			do {
				System.out.println("Player 1, enter hit row/column:");
				row = input.nextInt();
				col = input.nextInt();
				status1 = checkInputToHit(historyBoard1, row, col);
			} while (status1 == false);
		
			hitShip(1, board2, historyBoard1, row, col);
			printBoard(historyBoard1);
			complete = finalState(board2);
			if (complete == true) {
				winner = 1;
				break;
			} else {
				//Player 2 round
				System.out.println("");
				boolean status2 = false;
				do {
					System.out.println("Player 2, enter hit row/column:");
					row = input.nextInt();
					col = input.nextInt();
					status2 = checkInputToHit(historyBoard2, row, col);
				} while (status2 == false);
		
				hitShip(2, board1, historyBoard2, row, col);
				printBoard(historyBoard2);
				complete = finalState(board1);
				if (complete == true) {
					winner = 2;
					break;
				}
				System.out.println("");
			}	
		}
		//Print result
		System.out.println("PLAYER " + winner +" WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
		System.out.println("");
		
		//Print final board
		System.out.println("Final boards:");
		System.out.println("");
		System.out.println("Player 1 board:");
		printBoard(board1);
		System.out.println("");
		System.out.println("Player 2 board:");
		printBoard(board2);
	}
	
	private static boolean finalState(char[][] board) {
		//there is no @ anymore in the board = complete 
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board.length; j++) {
				if (board[i][j] == '@') {
					return false;
				} 	
			}
		}
		return true;
	}
	
	private static void insertToBoard(char[][] board, int row, int col) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board.length; j++) {
				if (i==row && j==col) {
					board[i][j] = '@';
				} else if (board[i][j] == '@') {
					
				} else {
						board[i][j] = '-';
				} 	
			}
		}
	}
	
	private static boolean checkInputToHit(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board.length ) {
			System.out.println("Invalid coordinates. Choose different coordinates.");
			return false;
		} else if (board[row][col] == 'X' || board[row][col] == 'O') {
			System.out.println("You already fired on this spot. Choose different coordinates.");
			return false;
		} 
		return true;
	}
	
	private static void hitShip(int player, char[][] board, char[][] history, int row, int col) {
		if (board[row][col] == '@') {
			history[row][col] = 'X';
			board[row][col] = 'X';
			if (player == 1) {
				System.out.println("PLAYER 1 HIT PLAYER 2's SHIP");
			} else if (player == 2) {
				System.out.println("PLAYER 2 HIT PLAYER 1's SHIP");
			}
		} else {
			history[row][col] = 'O';
			board[row][col] = 'O';
			if (player == 1) {
				System.out.println("PLAYER 1 MISSED");
			} else if (player == 2) {
				System.out.println("PLAYER 2 MISSED");
			}
		}
	}
	
	private static void printBoard(char[][] player) {
		System.out.print("  ");
		for (int row=-1; row<player.length; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			} 
			for (int column=0; column<player.length; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}
