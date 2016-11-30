import java.lang.Math;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class KalkulatorSpalania {
public static void main(String[] args) throws FileNotFoundException 
{
Dane dane = new Dane();
dane.przebieg();
dane.tankowanie();
dane.ZapisPrzebieg(args);
dane.ZapisTankowanie(args);



System.out.println("-----Koniec programu-----");
}
//	System.out.println("Calkowite srednie spalanie:"+(tankowanie[0]+tankowanie[1])/(przebieg[2]-przebieg[0])*100);
}
