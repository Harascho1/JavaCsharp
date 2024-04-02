import java.io.IOException;
import java.util.Scanner;

import inflacija.Preskupo;
import turizam.*;

public class Glavna {
	public static void main(String[] args) throws Preskupo, IOException {
		
		Scanner tastatura = new Scanner(System.in);
		Agencija<IPut> agent = new Agencija<IPut>();
		String tip;
		
		for (int i = 0; i < 2; i++) {

			System.out.print("Tip putovanja: ");
			tip = tastatura.next();
			tastatura.nextLine();
			
			if(tip.toLowerCase().equals("letovanje")) {
				System.out.print("Destinacija: ");
				String mesto = tastatura.nextLine();
				System.out.print("Broj dana: ");
				int brojDana = tastatura.nextInt();
				System.out.print("Cena po danu: ");
				double cena = tastatura.nextDouble();
				Letovanje l = new Letovanje(mesto,brojDana,cena);
				agent.dodaj(l);
			}
			
			else if(tip.toLowerCase().equals("zimovanje")) {
				System.out.print("Destinacija: ");
				String mesto = tastatura.nextLine();
				System.out.print("Broj dana: ");
				int brojDana = tastatura.nextInt();
				System.out.print("Cena po danu: ");
				int cena = tastatura.nextInt();
				System.out.print("Cena za SkyPass: ");
				int SkyPass = tastatura.nextInt();
				Zimovanje z = new Zimovanje(mesto,brojDana,cena,SkyPass);
				agent.dodaj(z);
			}
			
			else {
				System.out.println("Nisi ubo putovanje, Probaj ponovo");
				i--;
			}
				
		}
		agent.uporedi();
		
		
		
		tastatura.close();
	}
}
