
public class dreieck 
{
	//berechnung der Fläche eines Dreiecks
	
	Double a,b,c,gamma,flaeche;
	int xa,ya,xb,yb,xc,yc;
	
	public dreieck()
	{
		
	}
	
	public void gammabestimmen()
	{
		double tempoben =  Math.pow(c,2) -  Math.pow( a,2 ) -  Math.pow( b,2 );
		double tempunten = -2 * a * b;
		
		double cosgamma = tempoben/tempunten;
		gamma = Math.acos(cosgamma);
		//gamma = Math.toDegrees(gamma);
	}
	
	public void seitenberechnen()
	{
		a = Math.sqrt(Math.pow((Math.abs(xb -xc)), 2) + Math.pow((Math.abs(yc - yb)), 2));
		b = Math.sqrt(Math.pow((Math.abs(xa -xc)), 2) + Math.pow((Math.abs(yc - ya)), 2));
		c = Math.sqrt(Math.pow((Math.abs(xb -xa)), 2) + Math.pow((Math.abs(ya - yb)), 2));
	}
	
	public double flaechebestimmen()
	{
		 flaeche = 0.5 * a * b * Math.sin(gamma);
		 return flaeche;
	}
	
	public void test()
	{
		xa = 2;
		xb = 5;
		xc = 2;
		ya = 4;
		yb = 4;
		yc = 9;
		
		seitenberechnen();
		gammabestimmen();
		double x = flaechebestimmen();
		
		if(Math.round(x) == 8)
		{
			System.out.println("Fläche Dreieck: Pass");
		}
		else
		{
			System.out.println("Fläche Dreieck: Not Pass");
		}
	}
}
