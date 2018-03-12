import java.util.Scanner;

public class BenzinRechner {
	
	// Variabeln
	private double tankGesamt;		// Gesamtvolumen des Tanks in Liter
	private double tankRest;		// aktueller Tankfüllstand in Liter
	private double tankBenoetigt;	// Benzin, welches für angegebene Strecke gebraucht wird in Liter
	private double tankFuellen;		// Benzin, dass man für bestimmte km nachtanken muss in Liter
	
	private double kmRest;			// restliche km, die man fahren kann
	private double kmGefahren;		// gefahrene km seit tanken
	
	private double verbrauchPro100;	// Menge Benzin, für 100km in Liter
	private String Rechner;
	
	Scanner scanner = new Scanner(System.in);	// scanner für Eingaben
	private int eingabe;			// int für eingabens

	
	// Konstruktorer
	public BenzinRechner(){
		System.out.println("Hallo ich bin der BenzinRechner!");
		
//		System.out.println("Zuerst brauchen wir ein paas angaben: Tankvolumen, ");
//		System.out.println("Wie gross ist dein Tank in Litern?");
//		tankGesamt = scanner.nextDouble();
		
		System.out.println("Was möchtest du berechnen?");
		System.out.println("Es gibt folgende Möglichkeiten:");
		System.out.println("1 maximale km mit vollem Tank berechnen");
		System.out.println("2 aktuellen Füllstand berechnen");
		System.out.println("3 restliche km mit aktuellem Füllstand berechnen");
		System.out.println("4 nötige Liter benzin für bestimmte Strecke berechnen");
		System.out.println("5 berechnen, wieviel Benzin man für die geplante strecke noch tanken muss");
		
		System.out.println("Bitte gib die entsprechende Zahl ein:");
		eingabe = scanner.nextInt();
		eingabeAuswerten(eingabe);
	}

	
	
	// GET & SET
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
	
	
	
	
	// weitere Methoden
	private void eingabeAuswerten(int eingabe){
		
		switch (eingabe) {
		case 1:
			System.out.println("Case " + 1);
			break;
		case 2:
			System.out.println("Case " + 2);
			break;
		case 3:
			System.out.println("Case " + 3);
			break;
		case 4:
			System.out.println("Case " + 4);
			break;
		case 5:
			System.out.println("Case " + 5);
			break;


		default:
			System.out.println("Die Eingabe ist leider ungültig.\nBitte versuchen Sie es mit einer Zahl von 1 bis 5 erneut.");
			
			break;
		}
		
	}
	
	
	

}
