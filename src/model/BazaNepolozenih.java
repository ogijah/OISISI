package model;

import java.util.ArrayList;
import java.util.List;


import gui.TrakaSaAlatkama;


public class BazaNepolozenih {

	private static BazaNepolozenih instance = null;
	
	public static BazaNepolozenih getInstance() {
		
		if(instance == null) {
			
			instance = new BazaNepolozenih();
			
		}
		
		return instance;
		
	}
	
	int red = TrakaSaAlatkama.getInstance().getSelectovanRed();
	
	List<Predmet> predmeti = BazaStudenata.getInstance().getRow(red).getSpisakNepolozenihIspita();
	private List<String> kolone;
	
	private BazaNepolozenih() {
		
		initPolozeni();
		
		//zaglavlje
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
	}
	
	private void initPolozeni() {
		
		this.predmeti = new ArrayList<Predmet>();
		
	}
	
	public List<Predmet> getPredmeti() {
		
		return predmeti;
		
	}
	
	public void setPredmeti(List<Predmet> predmeti) {
		
		this.predmeti = predmeti;
		
	}
	
	public void getPredmeti(List<Predmet> predmeti) {
		
		this.predmeti = predmeti;
		
	}
	
	public int getColumnNum() {
		
		return 5;
		
	}
	
	public String getColumnName(int index) {
		
		return this.kolone.get(index);
		
	}
	
	public Predmet getRow(int rowIndex) {
		
		return this.predmeti.get(rowIndex);
		
	}
	
	public String getValueAt(int row, int column) {
		
		Predmet predmet = this.predmeti.get(row);
		
		switch(column) {
		
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return Integer.toString(predmet.getESPB());
		case 3:
			return Integer.toString(predmet.getGodina_studija());
		case 4:
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		
		}
		
	}
	
	
	
}
