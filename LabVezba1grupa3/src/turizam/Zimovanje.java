package turizam;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Zimovanje implements Put, Comparable<Put>{
	
	private String nazivdestinacije;
	private int brdana;
	private double cenapodanu;
	private double skipass;
	
	public Zimovanje(String naziv_destinacije, int broj_dana, double cena_po_danu, double ski_pass) {
		this.nazivdestinacije = naziv_destinacije;
		this.brdana = broj_dana;
		this.cenapodanu = cena_po_danu;
		this.skipass = ski_pass;
	}
	
	public int compareTo(Put o) {
		if(this.getCena() > o.getCena()) {
			return 1;
		}else if(this.getCena() == o.getCena()){
			return 0;
		}else {
			return -1;
		}
		//return Double.compare(this.getCena(), o.getCena());
	}
	
	public double getCena() {
		
		return brdana*cenapodanu + skipass*(brdana-2);
	}
	
	public void upisiUFajl() throws IOException {
		try {
			double c = this.getCena();
			FileWriter pisatelj = new FileWriter(Double.toString(c) + ".txt");
			BufferedWriter bw = new BufferedWriter(pisatelj);
			String text;
			if(nazivdestinacije.contains(" ")){
				text = nazivdestinacije.split(" ")[0];
			}else
				text = nazivdestinacije;
			bw.write(text);
			bw.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getNazivdestinacije() {
		return nazivdestinacije;
	}

	public void setNazivdestinacije(String nazivdestinacije) {
		this.nazivdestinacije = nazivdestinacije;
	}

	public int getBrdana() {
		return brdana;
	}

	public void setBrdana(int brdana) {
		this.brdana = brdana;
	}

	public double getCenapodanu() {
		return cenapodanu;
	}

	public void setCenapodanu(int cenapodanu) {
		this.cenapodanu = cenapodanu;
	}

	public double getSkipass() {
		return skipass;
	}

	public void setSkipass(int skipass) {
		this.skipass = skipass;
	}

	
}
