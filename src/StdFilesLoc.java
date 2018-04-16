import java.nio.file.Path;
import java.nio.file.Paths;

public interface StdFilesLoc {
	/*
	 * Standard Ordner input
	 * Variablen HOME & input sind daf�r da das jeder
	 * denselben Ordner ben�tzt
	  */
	final String HOME = System.getProperty("user.dir");
	final Path input = Paths.get(HOME, "input");
	/*
	 * Methode check_folder() 
	 * muss ausprogrammiert werden
	 */
	boolean check_folder();
	/*
	 * Methode create_folder()
	 * muss ausprogrammiert werden falls der Ordner "input" fehlt
	 */
	boolean create_folder();
}
