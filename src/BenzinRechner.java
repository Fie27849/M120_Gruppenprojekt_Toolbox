
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

	
	// Konstruktorer
	public BenzinRechner(){
		System.out.println("Hallo BenzinRechner!");
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

}
