import java.io.*;
import java.util.ArrayList;
import inflacija.*;
import turizam.*;


public class Agencija <T extends IPut>{
	private ArrayList<T> putevi;
	
	public Agencija(){
		putevi = new ArrayList<>();
	}
	
	public void dodaj(T put) {
		putevi.add(put);
	}
	
	public void uporedi() throws Preskupo,IOException {
		if(putevi.isEmpty())
			return;
		putevi.sort(null);
		for (T t : putevi) {
			t.upisi();
		}
		double najskuplje = putevi.get(putevi.size()-1).getCena();
		if(najskuplje > 2000) {
			System.out.println(najskuplje);
			throw new Preskupo("Preskupo brate...");
		}
		else {
			FileOutputStream f = new FileOutputStream("ekskluziva.bin");
			BufferedOutputStream b = new BufferedOutputStream(f);
			DataOutputStream d = new DataOutputStream(b);
			d.writeDouble(najskuplje);
			d.close();
		}
		
	}
}
