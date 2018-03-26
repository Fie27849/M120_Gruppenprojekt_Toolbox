import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		File file = new File("Recourcen_Zeitzaehler/Zeiten.txt");
		File file2 = new File("Recourcen_Zeitzaehler/einaus.txt");
		try {
			ordner.mkdir();
			file.createNewFile();
			file2.createNewFile();
			writeeinaus();
		} catch (Exception e) {
			System.out.println("Ordner erstellen fehlgeschlagen");
			e.printStackTrace();
		}
	}
	
	
	public void Start() 
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("=======================================");
			System.out.println("Sie haben folgende Möglichkeiten:");
			System.out.println("1. Zeit erfassen");
			System.out.println("2. Zeit abrufen");
			System.out.println("3. Programm beenden");
			System.out.println("=======================================");
			System.out.println("Geben sie Ihre Wahl ein:");
			
			int eingabe = scan.nextInt();
			
			if(eingabe == 1)
			{
				savetime();
			}
			else if(eingabe == 2)
			{
				ausgabe();
			}
			else
			{
				System.out.println("Ihr Programm wurde beendet!");
				System.out.println("=======================================");
				System.exit(0);
			}
			System.out.println("=======================================");
		}
		
	}
	
	
	
	public String savetime()
	{
		String line = null;
		BufferedReader br;
		String einaus = "";
		try {
			br = new BufferedReader(
					new FileReader("Recourcen_Zeitzaehler/einaus.txt"));
			 while ((line = br.readLine()) != null) {
				   einaus = line;
				 }
			 br.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			if(einaus.equals("ein"))
			{
				File file = new File("Recourcen_Zeitzaehler/einaus.txt");
				FileWriter f2 = new FileWriter(file, false);
			    f2.write("aus");
			    f2.close();
			}else {
				writeeinaus();
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
        
        
        String time = dateFormat.format(date) + "\n";
        time = einaus + " | " + time;
        try {
			Files.write(Paths.get("Recourcen_Zeitzaehler/Zeiten.txt"),time.getBytes() , StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return(dateFormat.format(date));
	}
	public void writeeinaus()
	{
		try {
			File file = new File("Recourcen_Zeitzaehler/einaus.txt");
			FileWriter f2 = new FileWriter(file, false);
			
			f2.write("ein");
			f2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	public void ausgabe() 
	{
		String line = null;
		BufferedReader br;
		try {
			br = new BufferedReader(
					new FileReader("Recourcen_Zeitzaehler/Zeiten.txt"));
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
