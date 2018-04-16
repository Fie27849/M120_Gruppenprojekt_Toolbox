import java.util.Scanner;

public class Quersumme {
	
	private int zahl;
	private int resultat = 0;
	boolean testing = true;
	int testergebnis = 0;
	int testmethode = 0;
	
	Scanner scan = new Scanner(System.in);

	public Quersumme(boolean testing) {
		if(testing){
			System.out.println("\n#######################");
			System.out.println("Testing Quersumme");
			System.out.println("#######################\n");
			zahl = 234;
			berechnen(zahl);
			testmethode++;
			zahl = 2;
			berechnen(zahl);
		}else{
		eingabe();
		}
	}
	
	public Quersumme(int zahl) {
		this.zahl = zahl;
		berechnen(zahl);
	}
	
	public void eingabe(){
		System.out.println("Bitte geben Sie die gewünschte Zahl ein");
		zahl = scan.nextInt();
		berechnen(zahl);
	}

	public void berechnen(int zahl) {
		if (zahl <= 9){
			resultat = zahl;
			ausgabe(resultat);
			if(testing){
				test();
			}
		}
		else{
			while (0 != zahl) {
				resultat = resultat + (zahl % 10);
				zahl = zahl / 10;
			}
			ausgabe(resultat);
			if(testing){
				test();
			}
		}
	}
	
	public void ausgabe(int resultat){
		System.out.println("Die Quersumme ist: " + resultat);
	}	
	
	public void test(){
		if(testmethode == 0){
			if(resultat == 9){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
		}else{
			if(resultat == 2){
				System.out.println("Berechnung korrekt");
				testergebnis++;
				if(testergebnis == 2){
					System.out.println("\nDer Test konnte erfolgreich abgeschlossen werden!");
				}
				else{
					System.out.println("\nBitte Fehler überprüfen!");
				}
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
				System.out.println("\nBitte Fehler überprüfen!");
			}
		}
	}
}

