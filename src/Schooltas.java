import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Schooltas 
{
	/**
	 * Alle Links zu den bestimmten Büchern 
	 * (können beliebig erweitert werden)
	 */
	static String bookname = "";
	final static String m104 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/062b2e75-40d5-45e0-b07c-cf923dda10bd/";
	final static String excel = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/f37eef14-c054-4989-9996-4a5297855544/";
	final static String word = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/7be8d3be-387a-450a-b7e5-43fc02e53207/";
	final static String netzwerke = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/35fb172e-8fb9-45b3-a517-1cca8d78372e/";
	final static String m131 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/bf28ca85-6f50-4208-857b-e7a99aa02769/";
	final static String m100 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/01a0e4f7-f6c9-4740-9d95-e891f79e065d/";
	final static String m122 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/68b9b3c6-439f-4e0c-97cb-975d13d743d1/";
	final static String m306 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/a4b3af4b-380e-44c7-bc3c-603a8014cc79/";
	final static String m133 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/51815130-b759-4e78-aac8-92f3bb959339/";
	/**
	 * Dieses Probramm lädt die Bücher aus Schooltas in Form von jpg's herunter
	 */
	public Schooltas()
	{
		String link = "";
		
		
			int choice = auswahl();
			switch(choice)
			{
			case 1:
				link = m104;
				bookname = "Modul104";
				break;
			case 2:
				link = excel;
				bookname = "Excel";
				break;
			case 3:
				link = word;
				bookname = "Word";
				break;
			case 4:
				link = netzwerke;
				bookname = "Netzwerke";
				break;
			case 5:
				link = m131;
				bookname = "Modul131";
				break;
			case 6:
				link = m100;
				bookname = "Modul100";
				break;
			case 7:
				link = m122;
				bookname = "Modul122";
				break;
			case 8:
				link = m306;
				bookname = "Modul306";
				break;
			case 9:
				link = m133;
				bookname = "Modul133";
				break;
			default:
				break;
			}
			if(link == "")
			{
				System.out.println("Error");
			}
			else {
				download(link);
			}
		
		
		
	}
	/**
	 * Hier wird der link übergeben und das Buch wird heruntergeladen immer Seite für Seite im Jpg Format
	 * In der Konsole wird ausgegeben wenn der Download beendet ist und welche Datei gerade heruntergeladen wird
	 * @param buch
	 */
	public static void download(String buch)
	{
     	String link = buch;
     	
		boolean site = true;
     	int counter = 1;
     	System.out.println("-----------------------------------------");
     	while(site){
     		try 
     		{
	         	URL url = new URL(link + counter + ".jpg");
	         	
	    			BufferedImage image = ImageIO.read(url);
	    			
	    			save(image, counter, bookname);
	    			counter++;
	    		} 
     		catch (IOException e) 
     		{
	    			site = false;
	    			System.out.println("------------------------------------");
	    			System.out.println("Download erfolgreich abgeschlossen!!");
	    			System.out.println("------------------------------------");
	    		}
     	}
	}
	/**
	 * In dieser Funktion wird das File in einen Neu erstellten Ordner mit dem Buchnamen gespeichert
	 * Hier wird der Name des Buches und das Bild übergeben plus die aktuelle Dateinummer
	 * @param image
	 * @param counter
	 * @param bookname
	 */
	public static void save(BufferedImage image, Integer counter, String bookname) 
	{
		//Neuer Ordner erstellen
		File ordner = new File(bookname);
		try {
			ordner.mkdir();
		} catch (Exception e) {
			System.out.println("Ordner erstellen fehlgeschlagen");
		}
		
		
		try {
		    String name = counter.toString();
		    BufferedImage bi = image;
		    File outputfile = new File(bookname+"/"+bookname + "_" + name +".jpg");
		    System.out.println(bookname + "_" + name +".jpg\t| Wurde heruntergeladen");
		    ImageIO.write((RenderedImage) bi, "jpg", outputfile);
		} catch (IOException e) {
		  System.out.println("Fehler");
		}
	}
	/**
	 * Das ist ein Übersichtsmenü indem man alle Bücher sieht und anhand der Nummer auswählen kann welches heruntergeladen werden soll.
	 * @return
	 */
	public static int auswahl()
	{
		System.out.println("------------------------------------");
		System.out.println("Welches Buch möchten sie herunterladen?");
		System.out.println("1. Modul 104");
		System.out.println("2. Excel");
		System.out.println("3. Word");
		System.out.println("4. Netzwerke");
		System.out.println("5. Modul 131");
		System.out.println("6. Modul 100");
		System.out.println("7. Modul 122");
		System.out.println("8. Modul 306");
		System.out.println("9. Modul 133");
		System.out.println("------------------------------------");
		System.out.println("Geben sie die gewünschte Zahl an:");
		Scanner scan1 = new Scanner(System.in);
		int choice = scan1.nextInt();
		scan1.close();
		switch(choice)
		{
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		case 5:
			return 5;
		case 6:
			return 6;
		case 7:
			return 7;
		case 8:
			return 8;
		case 9:
			return 9;
		default:
			return 0;
		}
	}
	
	
}
