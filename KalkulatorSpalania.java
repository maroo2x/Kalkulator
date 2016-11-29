import java.lang.Math;
import java.util.Scanner;
public class KalkulatorSpalania {
public static void main(String[] args) {
int[] przebieg = new int[10]; // tabela z wartosciami przebiegow
Float[] tankowanie = new Float[10]; // tabela z wartosciami tankowania
for(int i=0; i<3; i++)
{
System.out.println("Podaj przebieg w km");
Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od uzytkownika

przebieg[i] = Integer.parseInt(odczyt.nextLine()); //int
System.out.println("Ile litrów zatankowałeś?");

tankowanie[i] = Float.parseFloat(odczyt.nextLine()); //float
if (i > 0)
{
System.out.println("Spalanie od ostatniego tankowania: "+tankowanie[i-1]/(przebieg[i]-przebieg[i-1])*100);
}
else
{
System.out.println("---- pierwsze tankowanie------");
}
}
System.out.println("Calkowite srednie spalanie:"+(tankowanie[0]+tankowanie[1])/(przebieg[2]-przebieg[0])*100);
System.out.println("--------- koniec programu -----------");
}
}
