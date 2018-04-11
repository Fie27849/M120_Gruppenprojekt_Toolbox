import java.util.Scanner;

public class Taschenrechner {
	
	String zahleins;
	String zahlzwei;
	String operator;
	boolean testing = true;
	double a;
	double b;
	double resultat;
	double testPlus = 3.0;
	double testMinus = 1.0;
	double testMult = 2.0;
	double testTeilen = 2.0;
	int testergebnis = 0;
	int zaehler = 0;
	String exit = "exit";

	Scanner scan = new Scanner(System.in);
	
	public Taschenrechner(boolean testing){
		this.testing = testing;
		if(testing){
			System.out.println("\n#######################");
			System.out.println("Testing Taschenrechner");
			System.out.println("#######################\n");
			a = 2;
			b = 1;
			operator = "+";
			berechnen();
			operator = "-";
			berechnen();
			operator = "*";
			berechnen();
			operator = "/";
			berechnen();
		}else{
			eingabe();
		}
	}

	private void eingabe() {
		if(zaehler == 0){
			System.out.println("Bitte geben Sie die erste Zahl ein:");
			zahleins = scan.next();
		}
		else{
			System.out.println("Bitte geben Sie die erste Zahl ein: (Beenden mit exit)");
			zahleins = scan.next();
		}
		if (zahleins.equals(exit)){
			System.exit(0);
		}
		else{
			System.out.println(zahleins);
			try{
				a = Double.parseDouble(zahleins);
			}
			catch(NumberFormatException e){
				System.out.println("Sie haben keine Zahl eingegeben!");
				eingabe();
			}
		}
		
		System.out.println("Bitte geben Sie den gewünschten Operator ein. (+ - * /)");
		operator = scan.next();
		
		System.out.println("Bitte geben Sie die zweite Zahl ein:");
		zahlzwei = scan.next();
		try{
			b = Double.parseDouble(zahlzwei);
		}
		catch(NumberFormatException e){
			System.out.println("Sie haben keine Zahl eingegeben!");
			eingabe();
		}
		zaehler++;
		berechnen();
	}
	
	private void berechnen(){
		switch(operator){
			case "+": 
				resultat = a + b;
				if(testing){
					System.out.println("Resultat Addition:" + resultat);
					test(1);
				}
				break;
			case "-": 
				resultat = a - b;
				if(testing){
					System.out.println("Resultat Subtraktion:" + resultat);
					test(2);
				}
				break;
			case "*": 
				resultat = a * b;
				if(testing){
					System.out.println("Resultat Multiplikation:" + resultat);
					test(3);
				}
				break;
			case "/": 
				if(b==0){
					System.out.println("dividieren durch 0 nicht möglich!");
					eingabe();
				}
				else{
					resultat = a / b;
					if(testing){
						System.out.println("Resultat Division:" + resultat);
						test(4);
					}
				}
			break;
			default: System.out.println("Falsche Eingabe beim Operator");
			eingabe();
		}
		if(testing == false){
			System.out.println("\n###########################");
			System.out.println("Das Resultat ist: " + resultat);
			System.out.println("###########################\n");
			eingabe();
		}
	}
	
	private void test(int testMethod){
		switch(testMethod){
		case 1:
			if(resultat == testPlus){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		case 2:
			if(resultat == testMinus){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
					else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		case 3:
			if(resultat == testMult){
				System.out.println("Berechnung korrekt");
				testergebnis++;
			}
			else{
				System.out.println("Es ist ein Fehler aufgetreten");
			}
			break;
		case 4:
			if(resultat == testTeilen){
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
				System.out.println("\nBitte Fehler überprüfen!");
			}
			break;
		default:
			System.out.println("Es ist ein Fehler aufgetreten");
		}
	}
}
