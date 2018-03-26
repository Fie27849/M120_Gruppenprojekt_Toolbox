import java.util.Scanner;

public class ImperialMetric {
	
	int wert;
	String eingabe;
	String auswahl;
	int menuAuswahl;
	double resultat;
	int zaehler;
	String exit = "exit";
	
	Scanner scan = new Scanner(System.in);
	
	public ImperialMetric(){
		auswahl();
	}

	private void auswahl() {

		System.out.println("#######################");
		System.out.println("Menü, bitte auswählen");
		System.out.println("#######################\n");
		System.out.println("Bitte wählen Sie was Sie umrechnen möchten:");
		if(zaehler > 0){
			System.out.println("Beenden mit exit");
		}
		System.out.println("1. Meilen in Km\n" + "2. Inch in mm\n" + "3. foot in Meter\n" + "4. Pfund in kg");
		auswahl = scan.next();
		
		if (auswahl.equals(exit)){
			System.exit(0);
		}
		else{
			try{
				menuAuswahl = Integer.parseInt(auswahl);
			}
			catch(NumberFormatException e){
				System.out.println("Sie haben keine Zahl eingegeben!");
				auswahl();
			}
		}
		berechnung(menuAuswahl);
	}

	private void berechnung(int menuAuswahl) {
		switch(menuAuswahl){
		case 1:
			mileToKm();
			break;
		case 2:
			inchTomm();
			break;
		case 3:
			footToMeter();
			break;
		case 4:
			poundToKg();
			break;
		default:
			System.out.println("Falsche Menü Eingabe!");
			auswahl();
		}
		zaehler++;
		auswahl();
	}

	private void mileToKm() {
		System.out.println("Geben Sie bitte die Anzahl Meilen an: ");
		eingabe = scan.next();
		try{
			wert = Integer.parseInt(eingabe);
		}
		catch(NumberFormatException e){
			System.out.println("Sie haben keine Zahl eingegeben!");
			mileToKm();
		}
		resultat = wert * 1.6;
		System.out.println(wert + " Meilen sind " + resultat +" km");
	}
	
	private void inchTomm() {
		System.out.println("Geben Sie bitte die Anzahl inch an: ");
		eingabe = scan.next();
		try{
			wert = Integer.parseInt(eingabe);
		}
		catch(NumberFormatException e){
			System.out.println("Sie haben keine Zahl eingegeben!");
			footToMeter();
		}
		resultat = wert * 25;
		System.out.println(wert + " inch sind " + resultat +" mm");	
	}
	
	private void footToMeter() {
		System.out.println("Geben Sie bitte die Anzahl foot an: ");
		eingabe = scan.next();
		try{
			wert = Integer.parseInt(eingabe);
		}
		catch(NumberFormatException e){
			System.out.println("Sie haben keine Zahl eingegeben!");
			footToMeter();
		}
		resultat = wert / 3;
		System.out.println(wert + " foot sind " + resultat +" meter");
	}
	
	private void poundToKg() {
		System.out.println("Geben Sie bitte die Anzahl Pfund an: ");
		eingabe = scan.next();
		try{
			wert = Integer.parseInt(eingabe);
		}
		catch(NumberFormatException e){
			System.out.println("Sie haben keine Zahl eingegeben!");
			footToMeter();
		}
		resultat = wert * 0.454;
		System.out.println(wert + " Pfund sind " + resultat +" kg");
	}
	
	
}
