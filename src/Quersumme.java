import java.util.Scanner;

public class Quersumme {
	
	private int zahl;
	private int resultat = 0;
	
	Scanner scan = new Scanner(System.in);

	public Quersumme() {
		eingabe();
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
		}
		else{
			while (0 != zahl) {
				resultat = resultat + (zahl % 10);
				zahl = zahl / 10;
			}
			ausgabe(resultat);
		}
	}
	
	public void ausgabe(int resultat){
		System.out.println("Die Quersumme ist: " + resultat);
	}	
}
