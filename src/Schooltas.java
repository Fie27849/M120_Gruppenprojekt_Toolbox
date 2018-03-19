import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Schooltas 
{
	final static String m104 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/062b2e75-40d5-45e0-b07c-cf923dda10bd/";
	final static String excel = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/f37eef14-c054-4989-9996-4a5297855544/";
	final static String word = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/7be8d3be-387a-450a-b7e5-43fc02e53207/";
	final static String netzwerke = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/35fb172e-8fb9-45b3-a517-1cca8d78372e/";
	final static String m131 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/bf28ca85-6f50-4208-857b-e7a99aa02769/";
	final static String m100 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/01a0e4f7-f6c9-4740-9d95-e891f79e065d/";
	final static String m122 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/68b9b3c6-439f-4e0c-97cb-975d13d743d1/";
	final static String m306 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/a4b3af4b-380e-44c7-bc3c-603a8014cc79/";
	final static String m133 = "https://production-applicationstack-x2l8-pdfcontentbucket-8lgvyehv6f1g.s3.eu-central-1.amazonaws.com/tiles/51815130-b759-4e78-aac8-92f3bb959339/";
	
	public Schooltas()
	{
		String link = word;
		download(link);
	}
	
	public static void download(String buch)
	{
     	String link = buch;
     	String bookname = "Word";
		boolean site = true;
     	int counter = 1;
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
	
	public static void save(BufferedImage image, Integer counter, String bookname) 
	{
		try {
		    String name = counter.toString();
		    BufferedImage bi = image;
		    File outputfile = new File(bookname + "_" + name +".jpg");
		    System.out.println(bookname + "_" + name +".jpg | Wurde gespeichert");
		    ImageIO.write((RenderedImage) bi, "jpg", outputfile);
		} catch (IOException e) {
		  System.out.println("Fehler");
		}
	}
	
	public static int auswahl()
	{
		System.out.println("------------------------------------");
		System.out.println("Welches buch möchten sie herunterladen?");
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
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
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
