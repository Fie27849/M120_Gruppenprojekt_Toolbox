import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextAnalyse {
	
	private final String HOME = System.getProperty("user.dir");
	private Path home;
	
	public TextAnalyse(){
	
		this.home = Paths.get(HOME);
		Path input = Paths.get(HOME, "input");
		File mytext = new File(input.toString(), "denis.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(mytext));
			String line;
		    while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
		System.out.println(this.home);
		
	}
}
