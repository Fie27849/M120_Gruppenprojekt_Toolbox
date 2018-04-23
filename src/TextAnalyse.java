import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextAnalyse implements StdFilesLoc {
	/**
	 * Klassenvariablen
	 */
	private Scanner scan;
	private char letter;
	private int letterfound;
	private String mytext;
	private String textfile;
	
	/**
	 * Konstruktor verlangt nach dem Namen des @param textfile 
	 * 
	 */
	public TextAnalyse(String textfile){
		this.textfile = textfile;
		this.letterfound = 0;
		this.scan = new Scanner(System.in);
		
		if(!(check_folder()))
			create_folder();
	}
	/**
	 * Methode um die Text Analyse zu starten.
	 */
	public void start() {
		user_input();
		letter_search();
		System.out.println(result());
	}
	/**
	 * Methode um zu testen
	 */
	public void test() {
		this.letter = 'a';
		this.mytext = "Hello this is a text";
		letter_search();
		System.out.println(result());
		
	}
	/**
	 * Oeffnet das Textfile, liest den Text und speichert es in die Klassenvariable mytext
	 * Bei einem Fehler wird die Klassenvariable mytext nur ohne Text instanziert und der
	 * Pfad wird ausgegeben
	 */
	private void find() {
		File mytextfile = new File(input.toString(), this.textfile);
		StringBuilder mystringbuilder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(mytextfile));
			String line;
		    while ((line = br.readLine()) != null) {
		    	mystringbuilder.append(line);
            }
		    br.close();
        } catch (IOException e) {
            System.out.println("Pfad: " + input.toString() + "\nDatei: " + this.textfile);
            this.mytext = "";
        } 
		this.mytext = mystringbuilder.toString();
	}
	/**
	 * Diese Methode verlangt nach Userinput
	 */
	private void user_input() {
		System.out.println("Nach welchem Buchstaben suchen?");
		this.letter = scan.nextLine().charAt(0);
		find();
	}
	/**
	 * Methode um zu suchen wieviel mal der Buchstabe im Text vorkommt.
	 */
	private void letter_search() {
		for (int i = 0; i < this.mytext.length(); i++) {
			if(this.mytext.charAt(i) == this.letter)
				letterfound++;
		}
	}
	/**
	 * Ausgabe
	 */
	private String result() {
		return "Dein Buchstabe " + this.letter + " wurde " + this.letterfound + " mal im Text gefunden";
	}
	
	/**
	 * Methoden welche vom Interface StdFilesLoc uebernommen werden.
	 */
	@Override
	public boolean check_folder() {
		return Files.exists(home);
	}
	@Override
	public boolean create_folder() {
		File file = new File(input.toString());
		file.mkdir();
		return false;
	}
}
