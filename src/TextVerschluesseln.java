import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextVerschluesseln implements StdFilesLoc{
	
	private String filename;
	private String text = "";
	private String verschluesselterText = "";
	private String decodierterText = "";
	private String pwd;
	int zpwd;
	int auswahl;
	private char[] charArray = {};
	private char[] pwdArray = {};
	boolean testing = true;
	int testMethod = 0;
	int testergebnis = 0;
	
	Scanner scan = new Scanner(System.in);
	
	public TextVerschluesseln(boolean testing){
		this.testing = testing;
		if(testing){
			System.out.println("\n###########################");
			System.out.println("Testing Textverschlüsselung");
			System.out.println("###########################\n");
			pwd = "test";
			filename = "versch.txt";
			auswahl = 1;
			eingabe();
			testMethod++;
			text = "Dies ist ein Test Text";
			auswahl = 2;
			verschluesselterText = "";
			decodierterText = "";
			zpwd = 0;
			eingabe();
		}else{
			eingabe();
		}
	}
	
	public TextVerschluesseln(String text){
		this.text = text;
		verschluesseln(text);
	}
	
	public void eingabe(){
		if(testing == false){
			System.out.println("Möchten Sie eine Eingabe über ein Text file oder per Tastatur Eingabe? 1 für File, 2 für Tastatur");
			auswahl = scan.nextInt();
		}		
		if(auswahl == 1){
			if(testing == false){
				System.out.println("Bitte speichern Sie das File im input Ordner ab und geben Sie den Filename an. Beispiel: text.txt");
				filename = scan.next();
			}
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
			
			verschluesseln(text);
		}
		
		if (auswahl == 2){
			if(testing == false){
				System.out.println("Bitte geben Sie den zu verschlüsselnden text ein\n");
				scan.nextLine();
				text = scan.nextLine();
			}
			verschluesseln(text);
		}
		if(auswahl > 2 || auswahl < 1){
			System.out.println("falsche Eingabe, versuchen Sie es nochmals");
			eingabe();
		}
		
	}
	
	public void verschluesseln(String Text){
		if(testing == false){
			System.out.println("Bitte geben Sie das Passwort für die Verschlüsselung ein");
			pwd = scan.next();
		}
		
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
		if(check == 1){
			System.out.println("Verschlüsselter Text: " + ausgabe);
		}
		else{
			System.out.println("decodierter Text: " + ausgabe);
			if(testing){
				test();
			}
		}	
	}
	
	private void test(){
		if(testMethod == 0){
			if(decodierterText.equals(text)){
				System.out.println("\nVer- und entschlüsselung mit File erfolgreich!\n");
				testergebnis++;
			}else{
				System.out.println("\nVer- und entschlüsselung mit File fehlerhaft!\n");
			}
		}else{
			if(decodierterText.equals(text)){
				System.out.println("\nVer- und entschlüsselung mit Eingabe erfolgreich!\n");
				testergebnis++;
				if(testergebnis == 2){
					System.out.println("\nDer Test konnte erfolgreich abgeschlossen werden!");
				}
				else{
					System.out.println("\nBitte Fehler überprüfen!");
				}
			}else{
				System.out.println("Ver- und entschlüsselung mit Eingabe fehlerhaft!");
				System.out.println("\nBitte Fehler überprüfen!");
			}
		}
	}


	@Override
	public boolean check_folder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create_folder() {
		// TODO Auto-generated method stub
		return false;
	}

}
