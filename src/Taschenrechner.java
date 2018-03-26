import java.util.Scanner;

public class Taschenrechner {
	
	String zahleins;
	String zahlzwei;
	String operator;
	double a;
	double b;
	double resultat;

	Scanner scan = new Scanner(System.in);
	
	public Taschenrechner(){
		eingabe();
	}

	private void eingabe() {
		System.out.println("Bitte geben Sie die erste Zahl ein:");
		zahleins = scan.next();
		try{
			a = Double.parseDouble(zahleins);
		}
		catch(NumberFormatException e){
			System.out.println("Sie haben keine Zahl eingegeben!");
			eingabe();
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
		
		berechnen();
	}
	
	private void berechnen(){
		switch(operator){
			case "+": resultat = a + b; 
			break;
			case "-": resultat = a - b;
			break;
			case "*": resultat = a * b;
			break;
			case "/": 
				if(a==0){
					System.out.println("dividieren durch 0 nicht möglich!");
					eingabe();
				}
				else{
					resultat = a / b;
				}
			break;
			default: System.out.println("Falsche Eingabe beim Operator");
			eingabe();
		}
		
		System.out.println("\n###########################");
		System.out.println("Das Resultat ist: " + resultat);
		System.out.println("###########################\n");
		eingabe();
	}
}
