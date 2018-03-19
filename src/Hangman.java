import java.util.ArrayList;
import java.util.Scanner;

public class Hangman 
{
	private String word;
	private String[] foundletters;
	private ArrayList<String> guessedletters;
	private int failedguesses;
	private final int MAXFAILEDGUESS = 7;
	private Scanner scan;
	
	public Hangman(String word) {
		this.word = word.toLowerCase();
		this.guessedletters = new ArrayList<>();
		this.failedguesses = 0;
		this.foundletters = new String[word.length()];
		this.scan = new Scanner(System.in);
		System.out.println("                                                      \n" + 
				" _   _     _     _   _   ____  __  __     _     _   _ \n" + 
				"| | | |   / \\   | \\ | | / ___||  \\/  |   / \\   | \\ | |\n" + 
				"| |_| |  / _ \\  |  \\| || |  _ | |\\/| |  / _ \\  |  \\| |\n" + 
				"|  _  | / ___ \\ | |\\  || |_| || |  | | / ___ \\ | |\\  |\n" + 
				"|_| |_|/_/   \\_\\|_| \\_| \\____||_|  |_|/_/   \\_\\|_| \\_|\n" + 
				"                                                      \n" + 
				"");
		System.out.println("Write letters to guess the word");
	}
	public void start() {
		
		boolean check = true;
		do {
			check = this.guess(scan.next().charAt(0));
		} while (check);

	}
	
	public boolean guess(char letterfromguess){
		if(check()){
			System.out.println("You cannot play anymore!");
			return false;
		}
		if(check_word()){
			System.out.println("You have won!");
			return false;
		}
		String letter = String.valueOf(letterfromguess);
	
		letter = letter.toLowerCase();
		if(word.contains(letter)){
			int index = 0;
			for (int i = 0; i < foundletters.length; i++) {
				if(word.charAt(i) == letter.charAt(0)) {
					foundletters[i] = letter;
				}
			}
			
			guessedletters.add(letter);
			
		} else {
			guessedletters.add(letter);
			failedguesses ++;

		}
		print();
		return true;
	}
	
	public boolean check() {
		if(failedguesses == MAXFAILEDGUESS) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean check_word(){
		boolean check = true;
		for (int i = 0; i < foundletters.length; i++) {
			if(foundletters[i] == null){
				check = false;
				break;
			}
		}
		return check;
	}
	public void print() {
		System.out.println("\n\n\n\n\n\n");
		switch (failedguesses) {
		case 0:
			System.out.println("  +---+\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 1:
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 2:
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 3:
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					"  |   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 4:
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 5:
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|\\  |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 6:
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|\\  |\r\n" + 
					" /    |\r\n" + 
					"      |\r\n" + 
					"=========");
			break;
		case 7:
			System.out.println("                                                                                                                                                                                                        \n" + 
					"                                                                                                                                                                                                        \n" + 
					"        GGGGGGGGGGGGG               AAA               MMMMMMMM               MMMMMMMMEEEEEEEEEEEEEEEEEEEEEE          OOOOOOOOO     VVVVVVVV           VVVVVVVVEEEEEEEEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRR   \n" + 
					"     GGG::::::::::::G              A:::A              M:::::::M             M:::::::ME::::::::::::::::::::E        OO:::::::::OO   V::::::V           V::::::VE::::::::::::::::::::ER::::::::::::::::R  \n" + 
					"   GG:::::::::::::::G             A:::::A             M::::::::M           M::::::::ME::::::::::::::::::::E      OO:::::::::::::OO V::::::V           V::::::VE::::::::::::::::::::ER::::::RRRRRR:::::R \n" + 
					"  G:::::GGGGGGGG::::G            A:::::::A            M:::::::::M         M:::::::::MEE::::::EEEEEEEEE::::E     O:::::::OOO:::::::OV::::::V           V::::::VEE::::::EEEEEEEEE::::ERR:::::R     R:::::R\n" + 
					" G:::::G       GGGGGG           A:::::::::A           M::::::::::M       M::::::::::M  E:::::E       EEEEEE     O::::::O   O::::::O V:::::V           V:::::V   E:::::E       EEEEEE  R::::R     R:::::R\n" + 
					"G:::::G                        A:::::A:::::A          M:::::::::::M     M:::::::::::M  E:::::E                  O:::::O     O:::::O  V:::::V         V:::::V    E:::::E               R::::R     R:::::R\n" + 
					"G:::::G                       A:::::A A:::::A         M:::::::M::::M   M::::M:::::::M  E::::::EEEEEEEEEE        O:::::O     O:::::O   V:::::V       V:::::V     E::::::EEEEEEEEEE     R::::RRRRRR:::::R \n" + 
					"G:::::G    GGGGGGGGGG        A:::::A   A:::::A        M::::::M M::::M M::::M M::::::M  E:::::::::::::::E        O:::::O     O:::::O    V:::::V     V:::::V      E:::::::::::::::E     R:::::::::::::RR  \n" + 
					"G:::::G    G::::::::G       A:::::A     A:::::A       M::::::M  M::::M::::M  M::::::M  E:::::::::::::::E        O:::::O     O:::::O     V:::::V   V:::::V       E:::::::::::::::E     R::::RRRRRR:::::R \n" + 
					"G:::::G    GGGGG::::G      A:::::AAAAAAAAA:::::A      M::::::M   M:::::::M   M::::::M  E::::::EEEEEEEEEE        O:::::O     O:::::O      V:::::V V:::::V        E::::::EEEEEEEEEE     R::::R     R:::::R\n" + 
					"G:::::G        G::::G     A:::::::::::::::::::::A     M::::::M    M:::::M    M::::::M  E:::::E                  O:::::O     O:::::O       V:::::V:::::V         E:::::E               R::::R     R:::::R\n" + 
					" G:::::G       G::::G    A:::::AAAAAAAAAAAAA:::::A    M::::::M     MMMMM     M::::::M  E:::::E       EEEEEE     O::::::O   O::::::O        V:::::::::V          E:::::E       EEEEEE  R::::R     R:::::R\n" + 
					"  G:::::GGGGGGGG::::G   A:::::A             A:::::A   M::::::M               M::::::MEE::::::EEEEEEEE:::::E     O:::::::OOO:::::::O         V:::::::V         EE::::::EEEEEEEE:::::ERR:::::R     R:::::R\n" + 
					"   GG:::::::::::::::G  A:::::A               A:::::A  M::::::M               M::::::ME::::::::::::::::::::E      OO:::::::::::::OO           V:::::V          E::::::::::::::::::::ER::::::R     R:::::R\n" + 
					"     GGG::::::GGG:::G A:::::A                 A:::::A M::::::M               M::::::ME::::::::::::::::::::E        OO:::::::::OO              V:::V           E::::::::::::::::::::ER::::::R     R:::::R\n" + 
					"        GGGGGG   GGGGAAAAAAA                   AAAAAAAMMMMMMMM               MMMMMMMMEEEEEEEEEEEEEEEEEEEEEE          OOOOOOOOO                 VVV            EEEEEEEEEEEEEEEEEEEEEERRRRRRRR     RRRRRRR\n" + 					
					"");
			System.out.println("  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|\\  |\r\n" + 
					" / \\  |\r\n" + 
					"      |\r\n" + 
					"=========");
			System.out.println("The word was " + this.word);
			break;
		default:
			
			break;
		}
		StringBuilder foundlettersoutput = new StringBuilder();
		for (String string : foundletters) {
			foundlettersoutput.append(" ");
			if(string == null) {
				foundlettersoutput.append("_");
			} else {
				foundlettersoutput.append(string);
			}
		}
		System.out.println("Letters Found: \n" + foundlettersoutput.toString());
		
		
		StringBuilder guessedlettersoutput = new StringBuilder();
		for (String string : guessedletters) {
			guessedlettersoutput.append(" ");
			guessedlettersoutput.append(string);
		}
		System.out.println("Guessed Letters: \n" + guessedlettersoutput.toString());
	}
}
