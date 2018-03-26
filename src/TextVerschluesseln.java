import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextVerschluesseln {
	
	private String filename;
	private String text = "";
	private String verschluesselterText = "";
	private String decodierterText = "";
	private String pwd;
	int zpwd;
	private char[] charArray = {};
	private char[] pwdArray = {};
	private final String HOME = System.getProperty("user.dir");
	private Path home;
	
	Scanner scan = new Scanner(System.in);
	
	public TextVerschluesseln(){
		eingabe();
	}
	
	public TextVerschluesseln(String text){
		this.text = text;
		verschluesseln(text);
	}
	
	public void eingabe(){
		
		System.out.println("Möchten Sie eine Eingabe über ein Text file oder per Tastatur Eingabe? 1 für File, 2 für Tastatur");
		int auswahl = scan.nextInt();
		
		if (auswahl == 1){
			System.out.println("Bitte speichern Sie das File im input Ordner ab und geben Sie den Filename an. Beispiel: text.txt");
			filename = scan.next();
			this.home = Paths.get(HOME);
			Path input = Paths.get(HOME, "input");
			File mytext = new File(input.toString(), filename);
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(mytext));
				String line;
			    while ((line = br.readLine()) != null) {
	                System.out.println(line);
	                text +=  line;
	            }
	        } catch (IOException e) {
	            System.out.println("File existiert nicht");
	            eingabe();
	        } 
			
			System.out.println(this.home);
			verschluesseln(text);
		}
		
		if (auswahl == 2){
			System.out.println("Bitte geben Sie den zu verschlüsselnden text ein");
			text = scan.next();
			verschluesseln(text);
		}
		if(auswahl > 2 || auswahl < 1){
			System.out.println("falsche Eingabe, versuchen Sie es nochmals");
			eingabe();
		}
		
	}
	
	public void verschluesseln(String Text){
		System.out.println("Bitte geben Sie das Passwort für die Verschlüsselung ein");
		pwd = scan.next();
		
		pwdArray = pwd.toCharArray();
		charArray = text.toCharArray();
		
		for(int i = 0; i < charArray.length; i++){
			charArray[i] = (char) (charArray[i] + pwdArray[zpwd]);
			zpwd++;
			
			if(zpwd == pwd.length()){
				zpwd = 0;
			}
		}
		
		for(int i = 0; i < charArray.length; i++){
			verschluesselterText += charArray[i];
		}
		ausgabe(verschluesselterText, 1);
		decoder(charArray);
	}
	
	private void decoder(char[] charArray){
		zpwd = 0;
		for(int i = 0; i < charArray.length; i++){
			charArray[i] = (char) (charArray[i] - pwdArray[zpwd]);
			zpwd++;
			
			if(zpwd == pwd.length()){
				zpwd = 0;
			}
		}
		for(int i = 0; i < charArray.length; i++){
			decodierterText += charArray[i];
		}
		ausgabe(decodierterText, 2);
	}

	private void ausgabe(String ausgabe, int check) {
		if(check ==1){
			System.out.println("Verschlüsselter Text: " + ausgabe);
		}
		else{
			System.out.println("decodierter Text: " + ausgabe);
		}
		
	}

}
