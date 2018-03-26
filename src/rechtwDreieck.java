import java.util.Scanner;

public class rechtwDreieck {
	
	// ---------------------- Variabeln ---------------------------------------------------------------------------------
	
	private double a;
	private double b;
	private double c;
	private double flaeche;
	private double umfang;
	private double hoehe;
	
	private boolean eingabeA;
	private boolean eingabeB;
	private boolean eingabeC;
	private boolean eingabeFlaeche;
	private boolean eingabeUmfang;
	private boolean eingabeHoehe;
	
	Scanner scanner = new Scanner(System.in);	// scanner für Eingaben
	private int eingabe;			// int für Eingaben
	
	
	// ---------------------- Konstruktiren ---------------------------------------------------------------------------------
	
	public rechtwDreieck(){}
		
	// ---------------------- GET&SET ----------------------------------------------------------------------------------------
	
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

	// ---------------------- weitere Methoden -------------------------------------------------------------------------------
	
	
	// Menu, welches die Eingaben anfodrert und abspeichert, ruft danach eingabeMoeglich() auf 
	// um zu prüfen, was mit den Eingaben berechnet werden kann
	private void Menu(){
		System.out.println("=============================================================================================");
		System.out.println("Hallo ich berechne rechtwinklige Dreiecke!");
		
		System.out.println("\nEs können folgende Werte berechnet werden:");
		System.out.println("– Umfang");
		System.out.println("– Fläche");
		System.out.println("– Höhe");
		System.out.println("– Dritte, unbekannte, Seite");
		System.out.println("\n--------------------------------------!!! ACHTUNG !!!----------------------------------------");
		System.out.println("|||     Es müssen mindestens 2 Seiten angegeben werden                                    |||");
		System.out.println("|||     Wenn nur zwei Seiten bekannt sind, diese als a & b eingeben                       |||");
		System.out.println("|||     Seite c wird als Hypotenuse angenommen und muss somit die längste Seite sein!!    |||");
		System.out.println("---------------------------------------------------------------------------------------------");
		
		
		System.out.println("\nBitte gib an, ob du den Wert kennst und, wenn Ja, wie gross er ist:");
		System.out.println("\n1 für Ja\n0 für Nein");
		
		System.out.println("---------------------------------------------------------------------------------------------");
		
		einlesen();

		System.out.println("---------------------------------------------------------------------------------------------");
		
		kontrolle();
		
		berechnenMoeglich();
		
		ergebnisse();
		
	}
	
	// liest die Benutzereingaben zum Dreieck ein und speichert diese
	private void einlesen(){
		// Abfrage Seite a
		System.out.println("\nKennst du die Länge der Seite a?");
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
		System.out.println("\nKennst du die Länge der Seite b?");
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
		System.out.println("\nKennst du die Länge der Seite c (Hypotenuse/Grundlinie)?");
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
		System.out.println("\nKennst du die Fläche?");
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
		System.out.println("\nKennst du den Umfang?");
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
		System.out.println("\nKennst du die Höhe?");
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
	}
	
	// gibt zur Kontrolle alle Variabeln aus
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
	

	

	// prüft, was mit den eingegebenen Daten berechnet werden kann
	// und rutf die notwendigen Funktionen auf
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
			flaecheBerechnen();
			hoeheBerechnen();
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
			hoeheBerechnen();
	
		}else if(	eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe 
				||  !eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
			flaecheBerechnen();
			hoeheBerechnen();
		
		}else if(	eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
				||  !eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
			flaecheBerechnen();
		}
		// zwei Seiten sind bekannt + zwei Variabeln
		else if(	eingabeA && eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
			 	||  !eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Fläche und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			hoeheBerechnen();
	
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
			umfangBerechnen();
			flaecheBerechnen();
		}
		// zwei Seiten sind bekannt + 3 Variabeln
		else if(	eingabeA && eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
				||  eingabeA && !eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
			 	||  !eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden zwei Seitenlängen und die Fläche und der Umfang und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			dritteSeiteBerechnen();
			umfangBerechnen();
	
		}				
		// alle Seiten sind bekannt
		else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
			flaecheBerechnen();
			hoeheBerechnen();
		
		}
		// alle Seiten sind bekannt + 1 Variable
		else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
			hoeheBerechnen();
	
		}else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			flaecheBerechnen();
			hoeheBerechnen();
		
		}else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
			flaecheBerechnen();
		
		}
		// alle Seiten sind bekannt + 2 Variablen
		else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche und der Umfang angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			hoeheBerechnen();
	
		}else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und die Fläche und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			umfangBerechnen();
		
		}else if(	eingabeA && eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Es wurden alle drei Seitenlängen und der Umfang und die Höhe angegeben");
			System.out.println("---------------------------------------------------------------------------------------------");
			flaecheBerechnen();
		}
		// zwei Seiten sind bekannt + 3 Variabeln
		else if(	eingabeA && eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
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
	private void flaecheBerechnen(){
		if(a!=0 && b!=0){
			flaeche = (a*b)/2;
		}
	}
	private void hoeheBerechnen(){
		hoehe = (flaeche*2)/c;
	}
	
	
	// gibt die Ergebnisse aus
	private void ergebnisse(){
		System.out.println("=============================================================================================");
		System.out.println("Ergebnisse:");
		System.out.println("Seite a = " + a + " cm");
		System.out.println("Seite b = " + b + " cm");
		System.out.println("Seite c = " + c + " cm");
		System.out.println("Die Fläche beträgt " + flaeche + " cm^2");
		System.out.println("Der Umfang misst " + umfang + " cm");
		System.out.println("Die Höhe beträgt " + hoehe + " cm");
		System.out.println("=============================================================================================");
	}
	
	
	// Testmethoden
	public void testVor(){
		System.out.println("=============================================================================================");
		System.out.println("Hallo ich bin eiine Testmethode und berechne rechtwinklige Dreiecke!");
		
		a=12;
		b=20;
		c=33;
		eingabeA=true;
		eingabeB=true;
		eingabeC=true;
		
		// zeigt die eingegebenen/gespeicherten Werte zur Kontrolle an
		//kontrolle();
		
		berechnenMoeglich();

		testNach();
	}
	
	private void testNach(){
		if(flaeche==120 && umfang==65){
			System.out.println("Berechnungen sind korrekt");
			System.out.println("=============================================================================================");
		}else{
			System.out.println("Die berechnungen stimmen nicht!");
			System.out.println("\nTestwerte setzen:\na = 12\nb = 20\nc = 33");
			System.out.println("=============================================================================================");
		}
	}
}
