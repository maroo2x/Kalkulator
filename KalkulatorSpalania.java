//import java.lang.Math;
import java.util.Scanner;
import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;


public class KalkulatorSpalania {
public static void main(String[] args) throws IOException 
{
	Scanner scan = new Scanner(System.in);
Dane dane = new Dane();
int p = dane.przebieg();
float t = dane.tankowanie();

//dane.ZapisPrzebieg(p);
//dane.ZapisTankowanie(t);
//dane.Odczyt();
Baza db = new Baza();
db.insert(p, t);
int id = scan.nextInt();
db.update(id);

System.out.println("-----Koniec programu-----");
}
}
