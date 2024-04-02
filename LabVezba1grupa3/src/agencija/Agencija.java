package agencija;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import turizam.Put;
import inflacija.Preskupo;

public class Agencija<T extends Put>{
	
	private ArrayList<T> putovanja;
	
	public Agencija() {
        putovanja = new ArrayList<>();
    }
	public ArrayList<T> getPutevi() {
		return putovanja;
	}

	public void setPutevi(ArrayList<T> putevi) {
		this.putovanja = putevi;
	}
	
	public void dodajPut(T put) {
		putovanja.add(put);
	}
	
	public void uredi() throws Preskupo, IOException{
		if(putovanja.isEmpty()) {
			return;
		}
		
		Collections.sort(putovanja, new Comparator<Put>(){
			public int compare(Put p1, Put p2) {
				if(p1.getCena() > p2.getCena())
					return 1;
				else if(p1.getCena() == p2.getCena())
					return 0;
				else
					return -1;
			}
		});
		for(T put : putovanja) {//PUT TIPA T TRCI KROZ PUTOVANJA
			put.upisiUFajl();
		}
		double najskuplje = putovanja.get(putovanja.size()-1).getCena();
		if(najskuplje > 2000) {
			System.out.println(najskuplje);
			throw new Preskupo("Preskupo brate...");
		} else {
			FileOutputStream fos = new FileOutputStream("Ekskluziva.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeDouble(najskuplje);
			dos.close();
		}
	}
}
