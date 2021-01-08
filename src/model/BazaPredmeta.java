package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class BazaPredmeta {
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}


	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeta() {
	
		initPredmete();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB bodovi");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");

	}

	private void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void getPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	
	public int getColumnCount() {
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
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return String.valueOf(predmet.getESPB());
		case 3:
			return String.valueOf(predmet.getGodina_studija());
		case 4:
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		}
	}
	
	public void dodajPredmet(Predmet predmet) {
		
		boolean postoji = false;
		
		for(int i = 0; i < predmeti.size(); i++) {
			
			//kod predmeta samo sifra mora biti jedinstvena
			if(predmet.getSifra().equals(predmeti.get(i).getSifra())) {
				
				postoji = true;
				JOptionPane.showMessageDialog(null, "Postoji predmet sa istom sifrom!");
				
			}
			else if(predmet.getNaziv().equals(predmeti.get(i).getNaziv())) {
				postoji = true;
				JOptionPane.showMessageDialog(null, "Postoji predmet sa istim nazivom!");
				
			}
			
		}
		
		if(!postoji) {
			
			this.predmeti.add(predmet);
			JOptionPane.showMessageDialog(null, "Predmet uspešno dodat u tabelu!");
			
		}
		
	}
	
	public void izmeniPredmet(int row, Predmet predmet, Predmet izmenjen) {
		boolean postoji = false;
		for(int i = 0; i < predmeti.size(); i++) {
			if(predmet != predmeti.get(i)) {
				if(izmenjen.getSifra().equals(predmeti.get(i).getSifra())) {
					
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji predmet sa istom sifrom!");
					
				}
				else if(izmenjen.getNaziv().equals(predmeti.get(i).getNaziv())) {
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji predmet sa istim nazivom!");
					
				}
			}
		}
		if(!postoji) {
			predmet.setSifra(izmenjen.getSifra());
			predmet.setNaziv(izmenjen.getNaziv());
			predmet.setGodina_studija(izmenjen.getGodina_studija());
			predmet.setSemestar(izmenjen.getSemestar());
			predmet.setESPB(izmenjen.getESPB());
			
			this.predmeti.set(row, predmet);
			JOptionPane.showMessageDialog(null, "Predmet je uspesno izmenjen!");
		}
		
	}
	
	public void obrisiPredmet(int row, Predmet predmet) {
		
		predmeti.remove(predmet);
		
		JOptionPane.showMessageDialog(null, "Predmet uspesno obrisan!");
		
	}
	
	

}
