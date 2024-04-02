package agencija;
import java.io.IOException;
import java.util.Scanner;

import inflacija.*;
import turizam.*;

public class Main {

	public static void main(String[] args) {
		Agencija<Put> agencija = new Agencija<>();
		String tip;
		Scanner tastatura = new Scanner(System.in);
		for(int i = 0;i<5;i++) {			
			System.out.println(i+1 + ". putovanje:");
			System.out.print("Tip putovanja: ");
			tip = tastatura.next();
			tastatura.nextLine();
			if(tip.toLowerCase().equals("zimovanje") || tip.toLowerCase().charAt(0) == 'z') {
				System.out.print("Destinacija: ");
				String naziv = tastatura.nextLine();
				System.out.print("Broj dana: ");
				int dani = tastatura.nextInt();
				System.out.print("Cena po danu: ");
				double cpd = tastatura.nextDouble();
				System.out.print("Cena ski pass-a po danu: ");
				double csp = tastatura.nextDouble();
				Zimovanje zimovanje = new Zimovanje(naziv,dani,cpd,csp);
				agencija.dodajPut(zimovanje);
				
			}else if(tip.toLowerCase().equals("letovanje") || tip.toLowerCase().charAt(0) == 'l'){
				System.out.print("Destinacija: ");
				String naziv = tastatura.nextLine();
				System.out.print("Broj dana: ");
				int dani = tastatura.nextInt();
				System.out.print("Cena po danu: ");
				double cpd = tastatura.nextDouble();
				Letovanje letovanje = new Letovanje(naziv,dani,cpd);
				agencija.dodajPut(letovanje);
			}else {
				System.out.println(tip);
				System.out.println("Ne znas da pises");
				return;
			}
		}
		try {
            agencija.uredi();
        } catch (Preskupo e) {
        	System.out.println(e.getMessage());
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
		finally {
			tastatura.close();
		}
	}

}
