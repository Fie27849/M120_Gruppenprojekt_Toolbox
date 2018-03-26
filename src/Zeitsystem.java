import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Zeitsystem 
{
	public Zeitsystem() 
	{
		if(!checkFiles())
		{
			createFiles();
			Start();
		}
		else
		{
			Start();
		}
	}
	
	
	public boolean checkFiles()
	{
		
		File f = new File("Recourcen_Zeitzaehler");
		if(f.exists()) { 
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void createFiles()
	{
		File ordner = new File("Recourcen_Zeitzaehler");
		File file = new File("Recourcen_Zeitzaehler/Test.txt");
		try {
			ordner.mkdir();
			file.createNewFile();
		} catch (Exception e) {
			System.out.println("Ordner erstellen fehlgeschlagen");
			e.printStackTrace();
		}
	}
	
	
	public void Start() 
	{
		//Logik
		System.out.println("=======================================");
		System.out.println("Sie haben folgende Möglichkeiten:");
		System.out.println("1. Zeit erfassen");
		System.out.println("2. Zeit abrufen");
		System.out.println("=======================================");
		System.out.println("Geben sie Ihre Wahl ein:");
		Scanner scan = new Scanner(System.in);
		int eingabe = scan.nextInt();
		scan.close();
		if(eingabe == 1)
		{
			savetime();
		}
		else
		{
			ausgabe();
		}
		
	}
	
	
	
	public String savetime()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
        
        
        String time = dateFormat.format(date);
        
        try {
			Files.write(Paths.get("Recourcen_Zeitzaehler/Test.txt"), time.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return(dateFormat.format(date));
	}
	
	public void ausgabe() 
	{
		String line = null;
		BufferedReader br;
		try {
			br = new BufferedReader(
					new FileReader("Recourcen_Zeitzaehler/Test.txt"));
			 while ((line = br.readLine()) != null) {
				   System.out.println(line);
				 }
			 br.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
