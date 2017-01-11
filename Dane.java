import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class Dane{
	public int danePrzebieg;
	public float daneTankowanie;
	public int przebieg()
	{
		System.out.println("Podaj przebieg w km");
		Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od uzytkownika
		return Integer.parseInt(odczyt.nextLine()); //int
	}
	public float tankowanie()
	{
//		Float tankowanie; // tabela z wartosciami tankowania
		Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od uzytkownika
		System.out.println("Ile litrów zatankowałeś?");
		return Float.parseFloat(odczyt.nextLine()); //float
	}
	  public void ZapisPrzebieg (int danePrzebieg) throws IOException{
		  this.danePrzebieg = danePrzebieg;
	      FileWriter zapis = new FileWriter("przebieg.txt", true);
	      zapis.write(Integer.toString(this.danePrzebieg)+"\n");
	      zapis.close();
	  }
	  public void ZapisTankowanie (float daneTankowanie) throws IOException{
	      this.daneTankowanie = daneTankowanie;
		  FileWriter zapis = new FileWriter("tankowanie.txt", true);
	      zapis.write(Float.toString(this.daneTankowanie)+"\n");
	      zapis.close();
	  }
	  public String Odczyt() throws IOException{
//		   odczytPrzebieg = null;
		   BufferedReader odczytPrzebieg = new BufferedReader(new FileReader("przebieg.txt"));
		   BufferedReader odczytTankowanie = new BufferedReader(new FileReader("tankowanie.txt"));
			String p = odczytPrzebieg.readLine();
			String t = odczytTankowanie.readLine();
			while (p != null) {
				System.out.println(p);
				int kmPocz = Integer.parseInt(p);
				p = odczytPrzebieg.readLine();
				int kmKonc = Integer.parseInt(p);
				if (Integer.parseInt(p) == danePrzebieg){
					p=null;
				}
			}
			
			odczytPrzebieg.close();
			odczytTankowanie.close();
			return p;
	  }
}