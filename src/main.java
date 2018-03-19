import java.util.Scanner;

public class main 
{	
	public static void main(String[] args) {
		
		
		
		// Janosch
//		System.out.println("======================== JANOSCH ========================");
//		try {
//			Hangman hang = new Hangman();
//		} catch (Exception e) {
//			
//		}
		
		// Stephanie
		//System.out.println("======================== STEPHANIE ========================");
		//BenzinRechner benzinRechner = new BenzinRechner();
		
		
		// Denis
		Hangman hangman = new Hangman("Test");
		hangman.guess('T');
		hangman.guess('a');
		hangman.guess('b');
		hangman.guess('z');
		hangman.guess('u');
		hangman.guess('i');
		hangman.guess('k');
		hangman.guess('l');
		hangman.guess('o');
		
		Hangman hangman2 = new Hangman("Hello");
		Scanner scan = new Scanner(System.in);
		boolean check = true;
		do {
			check = hangman2.guess(scan.next().charAt(0));
		} while (check);
	}
}
