import java.nio.file.Path;
import java.nio.file.Paths;

public interface Files {
	final String HOME = System.getProperty("user.dir");
	final Path input = Paths.get(HOME, "input");
}
