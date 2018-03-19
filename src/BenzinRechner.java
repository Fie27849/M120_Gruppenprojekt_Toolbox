import java.util.Scanner;

public class BenzinRechner {
	
	// ---------------------- Variabeln ---------------------------------------------------
	private double tankGesamt;		// Gesamtvolumen des Tanks in Liter
	private double tankRest;		// aktueller Tankfüllstand in Liter
	private double tankBenoetigt;	// Benzin, welches für angegebene Strecke gebraucht wird in Liter
	private double literVerbraucht;	// Liter Benzin, die seit letztem tanken verbraucht wurden
	private double tankFuellen;		// Benzin, dass man für bestimmte km nachtanken muss in Liter
	
	private double kmRest;			// restliche km, die man fahren kann
	private double kmGefahren;		// gefahrene km seit tanken
	private double kmGeplant;		// geplante km, die man fahren möchte
	private double kmRestGeplant;	// geplante km, die man mit aktuellem Füllstand nicht mehr fahren kann
	
	private double verbrauchPro100;	// Menge Benzin, für 100km in Liter
	private double verbrauchKmRestGeplant;	//benötigtes Benzin für kmRestGeplant
	private int anzNachtanken;			// so oft muss nachgetankt werden
	private double tanken;				// hilft anzNachtanken
	
	Scanner scanner = new Scanner(System.in);	// scanner für Eingaben
	private int eingabe;			// int für Eingaben

	
	// ---------------------------- Konstruktorer -------------------------------------------------
	public BenzinRechner(){
		System.out.println("Hallo ich bin der BenzinRechner!\n");
		Menu();	
	}
		
	// --------------------------------- GET & SET -----------------------------------------------
	public double getTankGesamt() {
		return tankGesamt;
	}
	public void setTankGesamt(double tankGesamt) {
		this.tankGesamt = tankGesamt;
	}
	public double getTankRest() {
		return tankRest;
	}
	public void setTankRest(double tankRest) {
		this.tankRest = tankRest;
	}
	public double getTankBenoetigt() {
		return tankBenoetigt;
	}
	public void setTankBenoetigt(double tankBenoetigt) {
		this.tankBenoetigt = tankBenoetigt;
	}
	public double getTankFuellen() {
		return tankFuellen;
	}
	public void setTankFuellen(double tankFuellen) {
		this.tankFuellen = tankFuellen;
	}
	public double getKmRest() {
		return kmRest;
	}
	public void setKmRest(double kmRest) {
		this.kmRest = kmRest;
	}
	public double getKmGefahren() {
		return kmGefahren;
	}
	public void setKmGefahren(double kmGefahren) {
		this.kmGefahren = kmGefahren;
	}
	public double getVerbrauchPro100() {
		return verbrauchPro100;
	}
	public void setVerbrauchPro100(double verbrauchPro100) {
		this.verbrauchPro100 = verbrauchPro100;
	}
		
	
	// ------------------- weitere Methoden ----------------------------------------------------
	
	// MENU zur Auswahl der Berechnungen
	private void Menu(){
		
		System.out.println("Was möchtest du berechnen?");
		System.out.println("Es gibt folgende Möglichkeiten:\n");
		System.out.println("1 maximale km mit vollem Tank berechnen");
		System.out.println("2 aktuellen Füllstand berechnen");
		System.out.println("3 restliche km mit aktuellem Füllstand berechnen");
		System.out.println("4 nötige Liter benzin für bestimmte Strecke berechnen");
		System.out.println("5 berechnen, wieviel Benzin man für die geplante strecke noch tanken muss");
		
		System.out.println("\nBitte gib die entsprechende Zahl ein:");
		eingabe = scanner.nextInt();
		eingabeAuswerten(eingabe);
		
	}

	// Eingabe von Menu AUSWERTEN, Berechnung aufrufen
	private void eingabeAuswerten(int eingabe){
		
		switch (eingabe) {
		case 1:
			case1();
			break;
		case 2:
			case2();
			break;
		case 3:
			case3();
			break;
		case 4:
			case4();
			break;
		case 5:
			case5();
			break;

		default:
			System.out.println("==============================\nDie Eingabe ist leider ungültig."
					+ "\nBitte versuche es mit einer Zahl von 1 bis 5 erneut.\n==============================");
			Menu();
			break;
		}
		
	}
	
	// nach Berechnung fortfahren oder beenden?
	private void fortfahren(){
		
		System.out.println("\nMöchtest du noch etwas berechnen?");
		System.out.println("11 für Ja\n12 für Nein");
		eingabe = scanner.nextInt();
		if(eingabe == 11){
			Menu();
		}else if(eingabe == 12){
			System.out.println("OK, auf wiedersehen.");
			System.exit(0);
		}
		
	}
	
	private int anzNachtanken(double restLiterBenoetigt, double tankRest){
		
		anzNachtanken = 1;
		while(restLiterBenoetigt > tankGesamt){
			anzNachtanken ++;
			//System.out.println(anzNachtanken);
			restLiterBenoetigt = restLiterBenoetigt - tankGesamt;
			//System.out.println(tanken);
		}
		
		return anzNachtanken;
	}
	
	private boolean testMaxKm(double tankRest){
		
		literVerbraucht = kmGefahren*verbrauchPro100/100; 	// verbraucht seit letztem Tanken
		tankRest = tankGesamt-literVerbraucht;				// Restliche Liter im Tank
		
		if(tankRest >= 0){
			//System.out.println("return true");
			return true;
		}
		//System.out.println("return false");
		return false;
	}
	
	// Benutzer wählt OPTION 1: maximale km mit vollem Tank berechnen
	private void case1(){
		System.out.println("Du kannst nun berechnen, wie viele km du mit vollem Tank fahren kannst."
				+ "\nDazu musst du noch ein paar Angaben machen:");
		
		System.out.println("\nWie viele Liter Benzin fasst dein Tank?");
		tankGesamt = scanner.nextDouble();
		System.out.println("Wie viele Liter verbraucht das Auto auf 100 km?");
		verbrauchPro100 = scanner.nextDouble();
		
		kmRest = tankGesamt/verbrauchPro100*100;
		System.out.println("Du kannst mit " + tankGesamt + " Litern " + kmRest + " km weit fahren.");
		
		fortfahren();
				
	}
	
	// Benutzer wählt OPTION 2: aktuellen Füllstand berechnen
	private void case2(){
		
		System.out.println("Du kannst nun berechnen, wieviel Benzin noch im Tank ist."
				+ "\nDazu musst du aber noch ein paar Angaben machen:");
		
		System.out.println("\nWie viele Liter Benzin fasst dein Tank?");
		tankGesamt = scanner.nextDouble();
		System.out.println("Wie viele Liter verbraucht das Auto auf 100 km?");
		verbrauchPro100 = scanner.nextDouble();
		System.out.println("Wie weit bist du seit dem letzten Mal tanken gefahren?");
		kmGefahren = scanner.nextDouble();
		
		literVerbraucht = kmGefahren*verbrauchPro100/100;
		tankRest = tankGesamt-literVerbraucht;
//		System.out.println(literVerbraucht);
//		System.out.println(tankRest);

		System.out.println("Du hast noch " + tankRest + " Liter Benzin im Tank");

		fortfahren();
	}
	
	// Benutzer wählt OPTION 3: restliche km mit aktuellem Füllstand berechnen
	private void case3(){
		
		System.out.println("Du kannst nun berechnen, wie weit du noch fahren kannst, mit dem Benzin, dass noch im Tank ist."
				+ "\nDazu musst du aber noch ein paar Angaben machen:");
		
		System.out.println("Weisst du, wie viel Benzin noch im Tank ist?");
		
		System.out.println("21 für Ja\n22 für Nein");
		eingabe = scanner.nextInt();
		if(eingabe == 21){
			System.out.println("Bitte gib die Menge Benzin ein:");
			tankRest = scanner.nextDouble();
			System.out.println("Wie viele Liter verbraucht das Auto auf 100 km?");
			verbrauchPro100 = scanner.nextDouble();
			kmRest = tankRest/verbrauchPro100*100;
		}else if(eingabe == 22){
			
			System.out.println("\nWie viele Liter Benzin fasst dein Tank?");
			tankGesamt = scanner.nextDouble();
			System.out.println("Wie viele Liter verbraucht das Auto auf 100 km?");
			verbrauchPro100 = scanner.nextDouble();
			System.out.println("Wie weit bist du seit dem letzten Mal tanken gefahren?");
			kmGefahren = scanner.nextDouble();
			
			literVerbraucht = kmGefahren*verbrauchPro100/100;
			tankRest = tankGesamt-literVerbraucht;
			kmRest = tankRest/verbrauchPro100*100;
//			System.out.println(literVerbraucht);
//			System.out.println(tankRest);
//			System.out.println(kmRest);
		}
				
		System.out.println("Du kanns noch " + kmRest + " km weit fahren.");

		fortfahren();
	}
	
	// Benutzer wählt OPTION 4: nötige Liter Benzin für bestimmte Strecke berechnen
	private void case4(){
		
		System.out.println("Du kannst nun berechnen, wie viele Liter Benzin du für eine bekannte Strecke brauchst."
				+ "\nDazu musst du aber noch ein paar Angaben machen:");
		
		System.out.println("Wie weit möchtest du fahren?");
		kmGeplant = scanner.nextDouble();
		System.out.println("Wie viele Liter verbraucht das Auto auf 100 km?");
		verbrauchPro100 = scanner.nextDouble();
		
		tankBenoetigt = kmGeplant*verbrauchPro100/100;
		System.out.println("Du brauchst für " + kmGeplant + " km " + tankBenoetigt + " Liter Benzin.");
		
		fortfahren();
	}
	
	// Benutzer wählt OPTION 5: berechnen, wieviel Benzin man für die geplante strecke noch tanken muss
	private void case5(){
		
		System.out.println("Du kannst nun berechnen, wie viele Liter Benzin du für eine bekannte Strecke nachtankten musst."
				+ "\nDazu musst du aber noch ein paar Angaben machen:");
		
		System.out.println("\nWie viele Liter Benzin fasst dein Tank?");
		tankGesamt = scanner.nextDouble();
		System.out.println("Wie viele Liter verbraucht das Auto auf 100 km?");
		verbrauchPro100 = scanner.nextDouble();
		System.out.println("Wie weit bist du seit dem letzten Mal tanken gefahren?");
		kmGefahren = scanner.nextDouble();
		
		literVerbraucht = kmGefahren*verbrauchPro100/100; 	// verbraucht seit letztem Tanken
		tankRest = tankGesamt-literVerbraucht;				// Restliche Liter im Tank
		
		if(testMaxKm(tankRest)){
			
			System.out.println("Wie weit möchtest du fahren?");
			kmGeplant = scanner.nextDouble();
							
			kmRest = tankRest/verbrauchPro100*100;				// Restliche km mit aktuellem Füllstand
			kmRestGeplant = kmGeplant-kmRest;					// für so viele km muss man nachtanken
			verbrauchKmRestGeplant = kmRestGeplant*verbrauchPro100/100;	// Liter die man nachtanken muss
				
//			System.out.println(literVerbraucht);
//			System.out.println(tankRest);
//			System.out.println(kmRest);
//			System.out.println(kmRestGeplant);
//			System.out.println(verbrauchKmRestGeplant);
			
			System.out.println("Du musst " + verbrauchKmRestGeplant + " Liter nachtanken.");
			if(verbrauchKmRestGeplant > tankGesamt){
				anzNachtanken = anzNachtanken(verbrauchKmRestGeplant, tankRest);
				
				System.out.println("Das passt aber nicht auf einmal in deinen Tank.\nDu musst " + anzNachtanken + " mal tanken.");
			}
			
		}else{
			System.out.println("Das kann nicht sein, so weit kannst du mit einem vollen Tank nicht fahren.");
		}
		
		
		
			
		
		
		
		
		

		fortfahren();
	}
	
	
	

}
