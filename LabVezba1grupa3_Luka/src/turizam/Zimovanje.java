package turizam;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Zimovanje implements IPut,Comparable<IPut>{

	private String m_nazivDestinacije;
	private int m_brojDana;
	private double m_cenaPoDanu;
	private double m_cenaSkiPass;
	
	
	public double getCena() {
		return m_brojDana*m_cenaPoDanu + m_cenaSkiPass*(m_brojDana-2);
	}
	
	public Zimovanje(String nazivDestinacije,int brojDana,
			double cenaPoDanu, double cenaSkiPass) {
		
		m_nazivDestinacije = nazivDestinacije;
		m_brojDana = brojDana;
		m_cenaPoDanu = cenaPoDanu;
		m_cenaSkiPass = cenaSkiPass;
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
		String temp = getCena() + ".txt";
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
