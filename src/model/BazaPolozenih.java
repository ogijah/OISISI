package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gui.TrakaSaAlatkama;
import view.TabelaPolozenih;



public class BazaPolozenih {

	private static BazaPolozenih instance = null;
	
	public static BazaPolozenih getInstance() {
		
		if(instance == null) {
			
			instance = new BazaPolozenih();
			
		}
		
		return instance;
		
	}
	int red = TrakaSaAlatkama.getInstance().getSelectovanRed();
	
	List<Ocena> ocene = BazaStudenata.getInstance().getRow(red).getSpisakPolozenihIspita();
	private List<String> kolone;
	
	private BazaPolozenih() {
		
		initPolozeni();
		
		//zaglavlje
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
		
	}
	
	private void initPolozeni() {
		
		this.ocene = new ArrayList<Ocena>();
		
	}
	
	public List<Ocena> getOcene() {
		
		return ocene;
		
	}
	
	public void setOcene(List<Ocena> ocene) {
		
		this.ocene = ocene;
		
	}
	
	public void getOcene(List<Ocena> ocene) {
		
		this.ocene = ocene;
		
	}
	
	public int getColumnNum() {
		
		return 5;
		
	}
	
	public String getColumnName(int index) {
		
		return this.kolone.get(index);
		
	}
	
	public Ocena getRow(int rowIndex) {
		
		return this.ocene.get(rowIndex);
		
	}
	
	public String getValueAt(int row, int column) {
		
		Ocena ocena = this.ocene.get(row);
		
		switch(column) {
		
		case 0:
			return ocena.getPredmet().getSifra();
		case 1:
			return ocena.getPredmet().getNaziv();
		case 2:
			return Integer.toString(ocena.getPredmet().getESPB());
		case 3: 
			return Integer.toString(ocena.getBrojcanaVrednostOcene());	
		case 4:
			DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy.");  
			return dateFormat.format(ocena.getDatumPolaganjaIspita());	
		default:
			return null;
		
		}
		
	}
	
	public double prosek() {
		double prosek = 0;
		int ukupno = 0;
		if(ocene.isEmpty()) {
			prosek = 0;
		}
		else {
			for(Ocena o:ocene) {
				ukupno += o.getBrojcanaVrednostOcene();
			}
			prosek = (double)ukupno/ocene.size();
		}
		return prosek;
	}
	
	public int getESBP() {
		int esbp = 0;
		for(Ocena o:ocene) {
			esbp += o.getPredmet().getESPB();
		}
		return esbp;
	}
	
	public void dodajOcenu(Student student,Predmet predmet,Ocena ocena) {
		
		this.ocene.add(ocena);
		JOptionPane.showMessageDialog(null, "Predmet uspešno dodat u tabelu položenih!");
		TabelaPolozenih.getInstance().azurirajPrikaz("IZMENJEN", -1);
		
		student.setProsecnaOcena(prosek());
		
}
	
	
}
