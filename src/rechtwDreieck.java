import java.util.Scanner;

public class rechtwDreieck {
	
	// ---------------------- Variabeln ------------------------------
	
	private double a;
	private double b;
	private double c;
	private double flaeche;
	private double umfang;
	private double hoehe;
	private double wAlpha;
	private double wBeta;
	private double p;
	private double q;
	
	private boolean eingabeA;
	private boolean eingabeB;
	private boolean eingabeC;
	private boolean eingabeFlaeche;
	private boolean eingabeUmfang;
	private boolean eingabeHoehe;
	private boolean eingabeWAlpha;
	private boolean eingabeWBeta;
	private boolean eingabeP;
	private boolean eingabeQ;
	
	Scanner scanner = new Scanner(System.in);	// scanner für Eingaben
	private int eingabe;			// int für Eingaben
	
	
	// ---------------------- Konstruktiren ------------------------------
	
	public rechtwDreieck(){
		System.out.println("=============================================================================================");
		System.out.println("Hallo ich berechne rechtwinklige Dreiecke!");
		Menu();
	}
	
	
	// ---------------------- GET&SET ------------------------------
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public double getFlaeche() {
		return flaeche;
	}
	public void setFlaeche(double flaeche) {
		this.flaeche = flaeche;
	}
	public double getUmfang() {
		return umfang;
	}
	public void setUmfang(double umfang) {
		this.umfang = umfang;
	}
	public double getHoehe() {
		return hoehe;
	}
	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}
	public double getwAlpha() {
		return wAlpha;
	}
	public void setwAlpha(double wAlpha) {
		this.wAlpha = wAlpha;
	}
	public double getwBeta() {
		return wBeta;
	}
	public void setwBeta(double wBeta) {
		this.wBeta = wBeta;
	}
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	public double getQ() {
		return q;
	}
	public void setQ(double q) {
		this.q = q;
	}

	// ---------------------- weitere Methoden ------------------------------
	
	
	// Menu, welches die Eingaben anfodrert und abspeichert, ruft danach eingabeMoeglich() auf 
	// um zu prüfen, was mit den Eingaben berechnet werden kann
	private void Menu(){
		System.out.println("\nEs können folgende Werte berechnet werden:");
		System.out.println("– Seitenumfang");
		System.out.println("– Fläche");
		System.out.println("– Dritte, unbekannte, Seite");
		System.out.println("\nAchtung!! Seite c wird als Hypotenuse angenommen und muss somit die längste Seite sein!!");
		
		System.out.println("---------------------------------------------------------------------------------------------");
		
		System.out.println("\nBitte gib an, ob du den Wert kennst und, wenn Ja, wie gross er ist:");
		System.out.println("\n1 für Ja\n0 für Nein");
		
		System.out.println("---------------------------------------------------------------------------------------------");
		
		// Abfrage Seite a
		System.out.println("Kennst du die Länge der Hypothenuse (Seite a)?");
		eingabe = scanner.nextInt();
		if(eingabe == 1){
			System.out.println("Wie lang ist die Seite a in cm?");
			a = scanner.nextDouble();
			eingabeA = true;
		}else if(eingabe == 0){
			eingabeA = false;
		}else{
			System.out.println("Ungültige Eingabe!\nNochmal von Forne!");
			Menu();
		}
		
		// Abfrage Seite b
		System.out.println("Kennst du die Länge der Seite b?");
		eingabe = scanner.nextInt();
		if(eingabe == 1){
			System.out.println("Wie lang ist die Seite b in cm?");
			b = scanner.nextDouble();
			eingabeB = true;
		}else if(eingabe == 0){
			eingabeB = false;
		}else{
			System.out.println("Ungültige Eingabe!\nNochmal von Forne!");
			Menu();
		}
		
		// Abfrage Seite c
		System.out.println("Kennst du die Länge der Seite c?");
		eingabe = scanner.nextInt();
		if(eingabe == 1){
			System.out.println("Wie lang ist die Seite c in cm?");
			c = scanner.nextDouble();
			eingabeC = true;
		}else if(eingabe == 0){
			eingabeC = false;
		}else{
			System.out.println("Ungültige Eingabe!\nNochmal von Forne!");
			Menu();
		}
		
		// Abfrage Fläche
		System.out.println("Kennst du die Fläche?");
		eingabe = scanner.nextInt();
		if(eingabe == 1){
			System.out.println("Wie gross ist die Fläche in cm^2 ?");
			flaeche = scanner.nextDouble();
			eingabeFlaeche = true;
		}else if(eingabe == 0){
			eingabeFlaeche = false;
		}else{
			System.out.println("Ungültige Eingabe!\nNochmal von Forne!");
			Menu();
		}
		
		// Abfrage Umfang
		System.out.println("Kennst du den Umfang?");
		eingabe = scanner.nextInt();
		if(eingabe == 1){
			System.out.println("Wie lang ist der Umfang in cm?");
			umfang = scanner.nextDouble();
			eingabeUmfang = true;
		}else if(eingabe == 0){
			eingabeUmfang = false;
		}else{
			System.out.println("Ungültige Eingabe!\nNochmal von Forne!");
			Menu();
		}
		
		// Abfrage Höhe
		System.out.println("Kennst du die Höhe?");
		eingabe = scanner.nextInt();
		if(eingabe == 1){
			System.out.println("Wie gross ist die Höhe in cm?");
			umfang = scanner.nextDouble();
			eingabeHoehe = true;
		}else if(eingabe == 0){
			eingabeHoehe = false;
		}else{
			System.out.println("Ungültige Eingabe!\nNochmal von Forne!");
			Menu();
		}
		

		System.out.println("---------------------------------------------------------------------------------------------");
		
		// zeigt die eingegebenen/gespeicherten Werte zur Kontrolle an
		kontrolle();
		
		// Aufruf
		berechnenMoeglich();

		kontrolle2();
		
	}
	
	private void kontrolle(){
		System.out.println("=============================================================================================");
		System.out.println("Kontrollausgabe:");
		System.out.println("eingabeA: " + eingabeA);
		System.out.println("a: " + a);
		System.out.println("eingabeB: " + eingabeB);
		System.out.println("b: " + b);
		System.out.println("eingabeC: " + eingabeC);
		System.out.println("c: " + c);
		System.out.println("eingabeFlaeche: " + eingabeFlaeche);
		System.out.println("flaeche: " + flaeche);
		System.out.println("eingabeUmfang: " + eingabeUmfang);
		System.out.println("umfang: " + umfang);
		System.out.println("eingabeHoehe: " + eingabeHoehe);
		System.out.println("hoehe: " + hoehe);
		System.out.println("=============================================================================================");
	}
	
	private void kontrolle2(){
		System.out.println("=============================================================================================");
		System.out.println("Kontrollausgabe:");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("flaeche: " + flaeche);
		System.out.println("umfang: " + umfang);
		System.out.println("hoehe: " + hoehe);
		System.out.println("=============================================================================================");
	}
	

	// prüft, was mit den eingegebenen Date berechnet werden kann
	private void berechnenMoeglich(){
		
		// zwei Seiten sind bekannt
		if(	eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe
		 || eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe  
		 || !eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
		}
		// zwei Seiten sind bekannt + 1 Variable
		else if(	eingabeA && eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
			 	||  !eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Fläche angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
	
		}else if(	eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe 
				||  !eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
		
		}else if(	eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
				||  !eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
		}
		// zwei Seiten sind bekannt + zwei Variabeln
		else if(	eingabeA && eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
			 	||  !eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Fläche und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
	
		}else if(	eingabeA && eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
				||  !eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Fläche und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
		
		}else if(	eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe 
				||  !eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und der Umfang und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
		}
		// zwei Seiten sind bekannt + 3 Variabeln
		else if(	eingabeA && eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
			 	||  !eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Fläche und der Umfang und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
	
		}				
		// alle Seiten sind bekannt
		else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  &&!eingabeHoehe 
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
		
		}
		// alle Seiten sind bekannt + 1 Variable
		else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
			 	||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
	
		}else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe 
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
		
		}else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
		
		}
		// alle Seiten sind bekannt + 2 Variablen
		else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
			 	||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
	
		}else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
				||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
		
		}else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe 
				||  eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und der Umfang und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
		}
		// zwei Seiten sind bekannt + 3 Variabeln
		else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
				||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
			 	||  eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche und der Umfang und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es ist schon alles bekannt.\nAuf wiedersehen");
			System.exit(0);
		}
		
	}
	
	
	// Methoden für die Berechnungen und Ausgabe der Ergebnisse

	private void dritteSeiteBerechnen(){
		if(a!=0 && b!=0 && c!=0){
			System.out.println("FEHLER: dritteSeiteBerechnen() -> ALLE SEITEN BEKANNT");
		}else if(a!=0 && b!=0){
			double t = a*a+b*b;
			c = Math.sqrt(t);
		}else if(a!=0 && c!=0){
			double t = (c*c)-(a*a);
			b = Math.sqrt(t);
		}else if(b!=0 && c!=0){
			double t = (c*c)-(b*b);
			a = Math.sqrt(t);
		}
	}
	
	private void umfangBerechnen(){
		umfang = a+b+c;
	}
	
	private void hoeheBerechnen(){
		
	}
	
	private void alphaBerechnen(){
		
	}
	
	private void betaBerechnen(){
		
	}
	
	private void flaecheBerechnen(){
		
	}
	
	
	
	
}
