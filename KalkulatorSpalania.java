//import java.lang.Math;
//import java.util.Scanner;
import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;


public class KalkulatorSpalania {
public static void main(String[] args) throws IOException 
{
Dane dane = new Dane();
int p = dane.przebieg();
float t = dane.tankowanie();

//dane.ZapisPrzebieg(p);
//dane.ZapisTankowanie(t);
//dane.Odczyt();
Baza db = new Baza();
//System.out.println(p+" "+t);
db.insert(p, t);

System.out.println("-----Koniec programu-----");
}
//	System.out.println("Calkowite srednie spalanie:"+(tankowanie[0]+tankowanie[1])/(przebieg[2]-przebieg[0])*100);
}
