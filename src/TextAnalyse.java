import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAnalyse {
	
	private final String HOME = System.getProperty("user.dir");
	private Path home;
	
	public TextAnalyse(){
		this.home = Paths.get(HOME);
		Path input = Paths.get(HOME, "input");
		
		
		System.out.println(this.home);
		
	}
}
