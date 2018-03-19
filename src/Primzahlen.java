import java.util.ArrayList;

public class Primzahlen 
{
	ArrayList<Integer> primzahlen = new ArrayList<Integer>();
	ArrayList<Integer> nichtprim = new ArrayList<Integer>();
	static int globalstart = 0;
	static int globalende = 0;
	//Test
	public Primzahlen(int ende)
	{
		globalende = ende;
		globalstart = 1;
		if(checkUebergabe(1, ende))
		{
			//Korrekte Eingabe
			berechnen(1,ende);
		}
		else
		{
			//Falsche Eingabe
			System.out.println("Keine Korrekte Angaben!!");
		}
		
		ausgabe();
		if(test())
		{
			System.out.println("Ausgabe Korrekt");
		}
		else
		{
			System.out.println("Fehler in der Ausgabe!!");
		}
	}
	
	public boolean checkUebergabe(int x, int y)
	{
		if(x == y || y < x )
		{
			return false;
		}
		else 
		{
			return true;
		}
	
	}
	
	public void berechnen(int start, int ende)
	{
		int divisor = 0;
		
		if(start == 0 || start == 1)
		{
			divisor = 2;
		}
		else
		{
			divisor = start;
		}
		
		int bereich = ende - start;
		
		for(int i = 1; i <= bereich; i++)
		{
			for(int zaehler = divisor; zaehler <= ende; zaehler++)
			{
				if(zaehler != divisor)
				{
					if(zaehler % divisor == 0)
					{
						if(!nichtprim.contains(zaehler))
						{
							nichtprim.add(zaehler);
						}
					}
				}
				else
				{
					primzahlen.add(divisor);
				}
			}
			
			divisor++;
			
			while(nichtprim.contains(divisor))
			{
				divisor++;
			}
		}
	}
	
	public void ausgabe()
	{
		System.out.println("Alle Primzahlen von " + globalstart + " bis "+ globalende);
		for (Integer integer : primzahlen) {
			System.out.println(integer);
		}
		
	}
	
	public boolean test()
	{
		int zaehler = 1;
		for (Integer integer : primzahlen) {
			if(zaehler == 3)
			{
				break;
			}
			else if(integer == 2 && zaehler == 1)
			{
				return true;
			}
			else if(integer == 3 && zaehler == 2)
			{
				return true;
			}
			zaehler++;
		}
		
		return false;
	}
}
