import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Dane{
	public int przebieg()
	{
		int przebieg; // przebieg samochodu
		System.out.println("Podaj przebieg w km");
		Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od uzytkownika
		przebieg = Integer.parseInt(odczyt.nextLine()); //int
		return przebieg;
	}
	public float tankowanie()
	{
		Float tankowanie; // tabela z wartosciami tankowania
		Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od uzytkownika
		System.out.println("Ile litrów zatankowałeś?");
		tankowanie = Float.parseFloat(odczyt.nextLine()); //float
		return tankowanie;
	}
	  public void ZapisPrzebieg (String[] args) throws FileNotFoundException{
	      PrintWriter zapis = new PrintWriter("przebieg.txt");
	      zapis.printf("Zapisuje przebieg z klasy Dane");
	      zapis.close();
	  }
	  public void ZapisTankowanie (String[] args) throws FileNotFoundException{
	      PrintWriter zapis = new PrintWriter("tankowanie.txt");
	      zapis.println("Zapisuje tankowanie z klasy Dane");
	      zapis.close();
	  }
}
