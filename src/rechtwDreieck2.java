import java.util.Scanner;

// Aufrufe für im Main
//// Stephanie
////System.out.println("======================== STEPHANIE ========================");
//BenzinRechner benzinRechner = new BenzinRechner();
//rechtwDreieck Dreieck = new rechtwDreieck();
//Dreieck.Menu(); // für normalen Programmverlauf
//Dreieck.testVor(); //zum Testen
//rechtwDreieck2 Dreieck2 = new rechtwDreieck2();
//Dreieck2.Menu(); // für normalen Programmverlauf

public class rechtwDreieck2 {

	
	// ---------------------- Variabeln ---------------------------------------------------------------------------------
	
		private double a;
		private double b;
		private double c;
		private double flaeche;
		private double umfang;
		private double hoehe;
		
		private double p;
		private double q;
		private double x;
		
		private boolean eingabeA;
		private boolean eingabeB;
		private boolean eingabeC;
		private boolean eingabeFlaeche;
		private boolean eingabeUmfang;
		private boolean eingabeHoehe;
		
		Scanner scanner = new Scanner(System.in);	// scanner für Eingaben
		private int eingabe;			// int für Eingaben
	
		// ---------------------- Konstruktoren ---------------------------------------------------------------------------------
		
		public rechtwDreieck2(){}
			
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
		void Menu(){
			System.out.println("=============================================================================================");
			System.out.println("Hallo ich berechne rechtwinklige Dreiecke!");
			
			System.out.println("\nEs können folgende Werte berechnet werden:");
			System.out.println("– Umfang");
			System.out.println("– Fläche");
			System.out.println("– Höhe");
			System.out.println("– Dritte, unbekannte, Seite");
			System.out.println("\n--------------------------------------!!! ACHTUNG !!!----------------------------------------");
			System.out.println("|||     Wenn nur zwei Seiten bekannt sind, diese als a & b eingeben                         |||");
			System.out.println("|||     ausser die Hypotenuse ist bekannt –> als c angeben                                  |||");
			System.out.println("|||     Seite c wird als Hypotenuse angenommen und muss somit die längste Seite sein !!     |||");
			System.out.println("|||     Wenn keine Seiten angegeben werden, wird zuerst c berechnet und dann ei             |||");
			System.out.println("|||     gleichschenkliges Dreieck angenommen.                       |||");
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
			
			// keine Seiten und keine Variabeln sind bekannt
			if(	!eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde keine Seitenlänge und keine weiteren Werte angegeben"
						+ "\nDamit kann nicht berechnet werden.");
				System.out.println("---------------------------------------------------------------------------------------------");
				
			}
			// keine Seite + 1 Variabel ist bekannt
			if(		!eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
				||  !eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
			 	||  !eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
					System.out.println("---------------------------------------------------------------------------------------------");
					System.out.println("Es wurde keine Seitenlänge und nur ein weiterer Wert angegeben"
							+ "\nDamit kann nicht berechnet werden.");
					System.out.println("---------------------------------------------------------------------------------------------");	
			}
			
			
			// keine Seite ist bekannt + 2 Variablen
			else if(	!eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde keine Seitenlänge und die Fläche und der Umfang angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				c=(umfang*umfang - 4*flaeche)/(2*umfang);
				hoehe=2*flaeche/c;
				p=flaeche/hoehe;
				q=c-p;
				a=Math.sqrt(c*q);
				dritteSeiteBerechnen();
				
				
			}else if(	!eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde keine Seitenlänge und der Umfang und die Höhe angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				c=umfang*2/(2*(hoehe+umfang));
				flaecheBerechnen();
				p=flaeche/hoehe;
				x=Math.sqrt(flaeche*flaeche-hoehe*hoehe*hoehe*hoehe);
				q=(flaeche+x)/hoehe;
				a=Math.sqrt(c*q);
				dritteSeiteBerechnen();
				
			
			}else if(	!eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde keine Seitenlänge und die Fläche und die Höhe angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				c=2*flaeche/hoehe;
				p=flaeche/hoehe;
				x=Math.sqrt(flaeche*flaeche-hoehe*hoehe*hoehe*hoehe);
				q=(flaeche+x)/hoehe;
				a=Math.sqrt(c*q);
				dritteSeiteBerechnen();
				umfangBerechnen();
			}
			
			// keine Seite und alle Variabeln sind bekannt
			if(	!eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde keine Seitenlänge und alle variabeln angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				c=2*flaeche/hoehe;
				p=flaeche/hoehe;
				q=c-p;
				a=Math.sqrt(c*q);
				dritteSeiteBerechnen();
			}
			
			
			// 1 Seite ist bekannt
			if(	eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe
			 || !eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe  
			 || !eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang && !eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde nur eine Seitenlänge angegeben"
						+ "\nDamit kann nicht berechnet werden.");
				System.out.println("---------------------------------------------------------------------------------------------");
				
			}
			// 1 Seite ist bekannt + 1 Variable
			else if(	eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
					||  !eingabeA && eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe
				 	||  !eingabeA && !eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && !eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und die Fläche angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				if(eingabeA){
					b = 2*flaeche/a;
					dritteSeiteBerechnen();
					hoeheBerechnen();
					umfangBerechnen();
				}
				else if(eingabeB){
					a = 2*flaeche/b;
					dritteSeiteBerechnen();
					hoeheBerechnen();
					umfangBerechnen();
				}
				else if(eingabeC){
					hoehe = 2*flaeche/c;
					p=flaeche/hoehe;
					q=c-p;
					a=Math.sqrt(c*q);
					dritteSeiteBerechnen();
					hoeheBerechnen();
					umfangBerechnen();
				}
				
			}else if(	eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
					||  !eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe 
					||  !eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und der Umfang angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				if(eingabeA){
					b = 2*flaeche/a;
					dritteSeiteBerechnen();
					hoeheBerechnen();
					flaecheBerechnen();
				}
				else if(eingabeB){
					a = 2*flaeche/b;
					dritteSeiteBerechnen();
					hoeheBerechnen();
					flaecheBerechnen();
				}
				else if(eingabeC){
					flaeche = umfang*(umfang - 2*c)/4;
					hoehe = 2*flaeche/c;
					p=flaeche/hoehe;
					q=c-p;
					a=Math.sqrt(c*q);
					dritteSeiteBerechnen();
					hoeheBerechnen();
					flaecheBerechnen();
				}
			
			}else if(	eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
					||  !eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
					||  !eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und die Höhe angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				
			}
			// 1 Seite ist bekannt + zwei Variabeln
			else if(	eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
					||  !eingabeA && !eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe
				 	||  !eingabeA && eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && !eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und die Fläche und der Umfang angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				if(eingabeA){
					b = 2*flaeche/a;
					dritteSeiteBerechnen();
					hoeheBerechnen();
				}
				else if(eingabeB){
					a = 2*flaeche/b;
					dritteSeiteBerechnen();
					hoeheBerechnen();
				}
				else if(eingabeC){
					p=flaeche/hoehe;
					q=c-p;
					a=Math.sqrt(c*q);
					dritteSeiteBerechnen();
				}
		
			}else if(	eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe
					||  !eingabeA && !eingabeB && eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe 
					||  !eingabeA && eingabeB && !eingabeC && eingabeFlaeche && !eingabeUmfang  && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und die Fläche und die Höhe angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				if(eingabeA){
					b = 2*flaeche/a;
					dritteSeiteBerechnen();
					umfangBerechnen();
				}
				else if(eingabeB){
					a = 2*flaeche/b;
					dritteSeiteBerechnen();
					umfangBerechnen();
				}
				else if(eingabeC){
					hoehe = 2*flaeche/c;
					p=flaeche/hoehe;
					q=c-p;
					a=Math.sqrt(c*q);
					dritteSeiteBerechnen();
				}
			
			}else if(	eingabeA && !eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe
					||  !eingabeA && !eingabeB && eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe 
					||  !eingabeA && eingabeB && !eingabeC && !eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und der Umfang und die Höhe angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				b=umfang*2/(2*(a-umfang))+umfang;
				dritteSeiteBerechnen();
				flaecheBerechnen();
			}
			// 1 Seite ist bekannt + 3 Variabeln
			else if(	eingabeA && !eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
					||  !eingabeA && !eingabeB && eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe
				 	||  !eingabeA && eingabeB && !eingabeC && eingabeFlaeche && eingabeUmfang  && eingabeHoehe){
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("Es wurde eine Seitenlänge und die Fläche und der Umfang und die Höhe angegeben");
				System.out.println("---------------------------------------------------------------------------------------------");
				b=umfang*2/(2*(a-umfang))+umfang;
				dritteSeiteBerechnen();		
			}
			
			
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
	
	
}
