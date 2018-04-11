import java.util.Scanner;

public class ImperialMetric {
	
	double wert;
	double testMile = 3.2;
	double testInch = 50.0;
	double testFoot = 0.6666666666666666;
	double testPound = 0.908;
	boolean testing = true;
	String eingabe;
	String auswahl;
	int menuAuswahl;
	int testergebnis = 0;
	double resultat;
	int zaehler;
	String exit = "exit";
	
	Scanner scan = new Scanner(System.in);
	
	public ImperialMetric(boolean testing){
		this.testing = testing;
		if(testing){
			System.out.println("\n#######################");
			System.out.println("Testing ImperialMetric");
			System.out.println("#######################\n");
			wert = 2;
			mileToKm(false);
			inchTomm(false);
			footToMeter(false);
			poundToKg(false);
		}else{
			auswahl();
		}
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
			mileToKm(true);
			break;
		case 2:
			inchTomm(true);
			break;
		case 3:
			footToMeter(true);
			break;
		case 4:
			poundToKg(true);
			break;
		default:
			System.out.println("Falsche Menü Eingabe!");
			auswahl();
		}
		zaehler++;
		auswahl();
	}

	private void mileToKm(boolean testing) {
		if(testing == true){
			System.out.println("Geben Sie bitte die Anzahl Meilen an: ");
			eingabe = scan.next();
			try{
				wert = Double.parseDouble(eingabe);
			}
			catch(NumberFormatException e){
				System.out.println("Sie haben keine Zahl eingegeben!");
				mileToKm(true);
			}
		}
		
		resultat = wert * 1.6;
		System.out.println(wert + " Meilen sind " + resultat +" km");
		
		if(testing == false){
			test(1);
		}
	}
	
	private void inchTomm(boolean testing) {
		if(testing == true){
			System.out.println("Geben Sie bitte die Anzahl inch an: ");
			eingabe = scan.next();
			try{
				wert = Double.parseDouble(eingabe);
			}
			catch(NumberFormatException e){
				System.out.println("Sie haben keine Zahl eingegeben!");
				inchTomm(true);
			}
		}
		resultat = wert * 25;
		System.out.println(wert + " inch sind " + resultat +" mm");	
		
		if(testing == false){
			test(2);
		}
	}
	
	private void footToMeter(boolean testing) {
		if(testing == true){
			System.out.println("Geben Sie bitte die Anzahl foot an: ");
			eingabe = scan.next();
			try{
				wert = Double.parseDouble(eingabe);
			}
			catch(NumberFormatException e){
				System.out.println("Sie haben keine Zahl eingegeben!");
				footToMeter(true);
			}
		}
		resultat = wert / 3;
		System.out.println(wert + " foot sind " + resultat +" meter");
		
		if(testing == false){
			test(3);
		}
	}
	
	private void poundToKg(boolean testing) {
		if(testing == true){
			System.out.println("Geben Sie bitte die Anzahl Pfund an: ");
			eingabe = scan.next();
			try{
				wert = Double.parseDouble(eingabe);
			}
			catch(NumberFormatException e){
				System.out.println("Sie haben keine Zahl eingegeben!");
				footToMeter(true);
			}
		}	
		resultat = wert * 0.454;
		System.out.println(wert + " Pfund sind " + resultat +" kg");
		
		if(testing == false){
			test(4);
		}
	}
	
	private void test(int testMethod){
		switch(testMethod){
		case 1:
			if(resultat == testMile){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		case 2:
			if(resultat == testInch){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
					else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		case 3:
			if(resultat == testFoot){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		case 4:
			if(resultat == testPound){
				System.out.println("Berechnung korrekt");
				testergebnis++;
				if(testergebnis == 4){
					System.out.println("\nDer Test konnte erfolgreich abgeschlossen werden!");
				}
				else{
					System.out.println("\nBitte Fehler überprüfen!");
				}
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		default:
			System.out.println("Es ist ein Fehler aufgetreten");
		}
	}
	
}
