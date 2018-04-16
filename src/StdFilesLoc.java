import java.nio.file.Path;
import java.nio.file.Paths;

public interface StdFilesLoc {
	/**
	 * Standard Ordner input
	 * Variablen HOME & input sind dafuer da das jeder
	 * denselben Ordner benutzt
	  */
	
	/**
	 * 2 Variablen welche das arbeiten vereinfachen
	 * HOME = Verzeichnis in welchem der Code drin ist
	 * input = Der Pfad zum Ordner "input"
	 * */
	final String HOME = System.getProperty("user.dir");
	final Path home = Paths.get(HOME);
	final Path input = Paths.get(HOME, "input");
	
	
	
	/**
	 * Methode check_folder() 
	 * muss ausprogrammiert werden um zu prüfen ob der Ordner "input" fehlt
	 */
	boolean check_folder();
	/**
	 * Methode create_folder()
	 * muss ausprogrammiert werden falls der Ordner "input" fehlt
	 */
	boolean create_folder();
}
