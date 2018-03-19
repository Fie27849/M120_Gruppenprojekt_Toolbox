import java.util.concurrent.TimeUnit;

public class Hangman 
{
	public Hangman() throws InterruptedException
	{
		System.out.println("                                                      \n" + 
				" _   _     _     _   _   ____  __  __     _     _   _ \n" + 
				"| | | |   / \\   | \\ | | / ___||  \\/  |   / \\   | \\ | |\n" + 
				"| |_| |  / _ \\  |  \\| || |  _ | |\\/| |  / _ \\  |  \\| |\n" + 
				"|  _  | / ___ \\ | |\\  || |_| || |  | | / ___ \\ | |\\  |\n" + 
				"|_| |_|/_/   \\_\\|_| \\_| \\____||_|  |_|/_/   \\_\\|_| \\_|\n" + 
				"                                                      \n" + 
				"");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				"  |   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|   |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|\\  |\r\n" + 
				"      |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|\\  |\r\n" + 
				" /    |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("  +---+\r\n" + 
				"  |   |\r\n" + 
				"  O   |\r\n" + 
				" /|\\  |\r\n" + 
				" / \\  |\r\n" + 
				"      |\r\n" + 
				"=========");
		TimeUnit.SECONDS.sleep(1);
		
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
				"                                                                                                                                                                                                        \n" + 
				"                                                                                                                                                                                                        \n" + 
				"                                                                                                                                                                                                        \n" + 
				"                                                                                                                                                                                                        \n" + 
				"                                                                                                                                                                                                        \n" + 
				"                                                                                                                                                                                                        \n" + 
				"                                                                                                                                                                                                        \n" + 
				"");
	}
}
