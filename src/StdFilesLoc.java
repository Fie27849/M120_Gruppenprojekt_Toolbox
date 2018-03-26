import java.nio.file.Path;
import java.nio.file.Paths;

public interface StdFilesLoc {
	final String HOME = System.getProperty("user.dir");
	final Path input = Paths.get(HOME, "input");
	void check_folder();
}
