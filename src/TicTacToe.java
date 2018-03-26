import java.util.Scanner;

public class TicTacToe {

	private String[][] field = new String[3][3];
	private String player1 = "o";
	private String player2 = "x";
	private boolean turn; // True = player 1 & false = player 2
	private Scanner scan;
	private boolean gameon; // True = Game is on & false Game is over
	
	public TicTacToe() {
		this.scan = new Scanner(System.in);
		initGame();	
	}
	
	public void initGame() {
		this.turn = true;
		this.gameon = true;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				this.field[i][j] = " ";
			}
		}
		
	}
	public void start() {
		do {
			user_input();
		} while (gameon);
		System.out.println("We have a Winner!");
	}
	
	public void user_input() {
		System.out.println(turn ? "Player 1" : "Player2");
		System.out.println("Give in Row - (1-3) and Column | (1-3)");
		int row = this.scan.nextInt();
		int column = this.scan.nextInt();
		if(setfield(row, column)) {
			draw_field();
		} else {
			System.out.println("Ungültiger Spielzug!");
		}
		check_win();
	}
	
	private boolean setfield(int row, int column) {
		if(row > 3 || column > 3)
			return false;
		--row;
		--column;
		if(this.field[row][column] == " "){
			if(turn) {
				this.field[row][column] = player1;
				this.turn = false;
			} else {
				this.field[row][column] = player2;
				this.turn = true;
			}
				
			return true;
		}
		
		return false;
	}
	
	private void draw_field(){
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				System.out.print(this.field[i][j]);
				System.out.print(" | ");
			}
			System.out.println();
			System.out.print("- - - - - -");
			System.out.println();
		}
	}
	
	//Winning condition
	private void check_win(){
		String line = "";
		for (int i = 0; i < 8; i++) {
			switch (i) {
			case 0:
				line = this.field[0][0] + this.field[1][0] + this.field[2][0];
				break;
			case 1:
				line = this.field[1][0] + this.field[1][1] + this.field[1][2];
				break;
			case 2:
				line = this.field[2][0] + this.field[2][1] + this.field[2][2];
				break;
			case 3:
				line = this.field[0][0] + this.field[0][1] + this.field[0][2];
				break;
			case 4:
				line = this.field[0][0] + this.field[1][0] + this.field[2][0];
				break;
			case 5:
				line = this.field[1][0] + this.field[1][1] + this.field[1][2];
				break;
			case 6:
				line = this.field[2][0] + this.field[2][1] + this.field[2][2];
				break;
			case 7:
				line = this.field[0][0] + this.field[1][1] + this.field[2][2];
				break;
			case 8:
				line = this.field[0][2] + this.field[1][1] + this.field[2][0];
				break;

			default:
				break;
			}
			if(check_line(line)) {
				this.gameon = false;
				break;
			}
				
		}
		
	}
	private boolean check_line(String line) {
		if (line.equals("xxx")) {
			return true;
		} else if(line.equals("ooo")){
			return true;
		} else {
			return false;
		}
	}
	
	public void debug() {
		debug_field();
		draw_field();
	}
	private void debug_field(){
		this.field[2][2] = "x";
		this.field[1][0] = "o";
		this.field[0][2] = "x";
		this.field[1][2] = "o";
		this.field[1][1] = "x";

	}
}
