import java.util.Scanner;

public class TicTacToe {

	/**
	 * Klassen Variablen
	 * 
	 * Variablen welche eine Erklaerung brauchen
	 * private boolean turn = Bei True ist player 1 dran & false player 2
	 * private boolean gameon = Bei True ist das Spiel noch am laufen, Bei False ist das Spiel vorbei.
	 * */
	private String[][] field = new String[3][3];
	private String player1 = "o";
	private String player2 = "x";
	private boolean turn;
	private Scanner scan;
	private boolean gameon;
	
	/**
	 * Konstruktor welcher aufgerufen wird um das Spiel aufzusetzen
	 * */
	public TicTacToe() {
		this.scan = new Scanner(System.in);
		this.turn = true;
		this.gameon = true;
		initGame();	
	}
	/**
	 * Das Spielfeld wird mit lauter Leerzeichen aufgefuellt
	 * */
	private void initGame() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				this.field[i][j] = " ";
			}
		}
		
	}
	/**
	 * Um das Spiel zu starten diese Methode aufrufen.
	 * Diese Methode laeuft solange bis es einen Sieger hat
	 * */
	public void start() {
		do {
			user_input();
		} while (gameon);
		System.out.println("We have a Winner!");
	}
	/**
	 * Methode fragt nach User Input (Entweder Player 1 oder Player 2).
	 * Falls die Methode setfield ein False zurueck gibt, wird ausgegeben
	 * das ein ungueltiger Spielzug stattgefunden hat & der Spieler kann aber immernoch
	 * setzen.
	 * */
	private void user_input() {
		System.out.println(turn ? "Player 1" : "Player2");
		System.out.println("Give in Row - (1-3) and Column | (1-3)");
		int row = this.scan.nextInt();
		int column = this.scan.nextInt();
		if(setfield(row, column)) {
			draw_field();
			check_win();
		} else {
			System.out.println("Ungültiger Spielzug!");
		}
	}
	/**
	 * Setzt den "Stein", x oder o, auf das leere Feld.
	 * Falls das Feld schon besetzt ist oder eine ungültige Eingabe folgt
	 * gibt die Methode ein false
	 * */
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
	
	/**
	 * Das Spielfeld wird auf Konsolenlevel ausgegeben
	 * */
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
	
	/**
	 * Prueft ob ein Spieler gewonnen hat.
	 * Da es nur 9 Moeglichkeiten gibt um zu gewinnen (was eher wenig sind)
	 * sind diese im switch case.
	 * Es wird ein String mit den Felder gebildet und der Methode check_line weitergegeben
	 * */
	private void check_win(){
		String line = "";
		for (int i = 0; i < 9; i++) {
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
	/**
	 * Prueft den String line ob dieser "xxx" oder "ooo" ist und 
	 * gibt true als Rueckgabewert
	 * */
	private boolean check_line(String line) {
		if (line.equals("xxx")) {
			return true;
		} else if(line.equals("ooo")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Kleine Debug Methode um das Spielfeld zu prüfen.
	 * */
	public void debug() {
		debug_field();
		draw_field();
		check_win();
		System.out.println(this.gameon ? "Nothing" : "Win");;
	}
	/**
	 * Diese Methode fuellt das Spielfeld aus.
	 * */
	private void debug_field(){
		this.field[2][0] = "x";
		this.field[1][0] = "o";
		this.field[0][2] = "x";
		this.field[1][2] = "o";
		this.field[1][1] = "x";

	}
}
