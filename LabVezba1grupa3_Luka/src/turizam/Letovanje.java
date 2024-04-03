package turizam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Letovanje implements IPut,Comparable<IPut>{

	private String m_nazivDestinacije;
	private int m_brojDana;
	private double m_cenaPoDanu;
	private double inflacija = (Math.random()+1);
	
	
	public double getCena() {
		return m_cenaPoDanu * m_brojDana * inflacija;
	}
	public Letovanje(String nazivDestinacije, int brojDana, double cenaPoDanu) {
		m_nazivDestinacije = nazivDestinacije;
		m_brojDana = brojDana;
		m_cenaPoDanu = cenaPoDanu;
	}
	public int compareTo(IPut o) {
		if(this.getCena()>o.getCena())
			return 1;
		else if(this.getCena()==o.getCena())
			return 0;
		else 
			return -1;
	}
	public String napraviFajl() {
		String temp = this.getCena() + ".txt";
		return temp;
	}
	public void upisi() {
		String imeFajla = napraviFajl();
		try {
			FileWriter fw = new FileWriter(imeFajla);
			BufferedWriter bw = new BufferedWriter(fw);
			String prvaRec[] = m_nazivDestinacije.split(" ");
			bw.write(prvaRec[0]);
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
