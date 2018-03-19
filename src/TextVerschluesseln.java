import java.util.Scanner;

public class TextVerschluesseln {
	
	private String text;
	private String verschluesselterText = "";
	private String decodierterText = "";
	private String pwd;
	int zpwd;
	private char[] charArray = {};
	private char[] pwdArray = {};
	
	Scanner scan = new Scanner(System.in);
	
	public TextVerschluesseln(){
		eingabe();
	}
	
	public TextVerschluesseln(String text){
		this.text = text;
		verschluesseln(text);
	}
	
	public void eingabe(){
		System.out.println("Bitte geben Sie den zu verschlüsselnden text ein");
		text = scan.next();
		verschluesseln(text);
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
