package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gui.TrakaSaAlatkama;
import view.TabelaProfesorovihPredmeta;


public class BazaProfesorovihPredmeta {

	private static BazaProfesorovihPredmeta instance = null;
	
	public static BazaProfesorovihPredmeta getInstance() {
		
		if(instance == null) {
			
			instance = new BazaProfesorovihPredmeta();
			
		}
		
		return instance;
		
	}
	
	List<Predmet> predmeti;
	private List<String> kolone;
	
	public List<Predmet> predmetiProfesora(){
		int red1 = TrakaSaAlatkama.getInstance().getSelectovanRedProfesori();
		List<Predmet> predmeti;
		if(red1 != -1) {
			Profesor profesor = TrakaSaAlatkama.getInstance().getProfesor(red1);
			predmeti = profesor.getPredmeti();
		}
		else {
			predmeti = new ArrayList<Predmet>();
		}
		return predmeti;
	}
	
	
	private BazaProfesorovihPredmeta() {
		
		initNepolozeni();
		
		//zaglavlje
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv ");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
		
	}
	
	private void initNepolozeni() {
		
		this.predmeti = predmetiProfesora();

		
	}
	
	public List<Predmet> getPredmeti() {
		
		this.predmeti = predmetiProfesora();
		return predmeti;
		
	}
	
	public void setPredmeti(List<Predmet> predmeti) {
		
		this.predmeti = predmetiProfesora();
		
	}
	
	public void getPredmeti(List<Predmet> predmeti) {
		
		this.predmeti = predmetiProfesora();
		
	}
	
	public int getColumnNum() {
		
		return 4;
		
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
			return Integer.toString(predmet.getGodina_studija());
		case 3:
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		
		}
		
	}
	
	public void dodajPredmet(Profesor profesor, Predmet predmet) {
		
		boolean postoji = false;
		
		
		
		for(int i = 0; i < profesor.getPredmeti().size(); i++) {
			
			//kod predmeta samo sifra mora biti jedinstvena
			if(predmet.getSifra().equals(predmeti.get(i).getSifra())) {
				
				postoji = true;
				JOptionPane.showMessageDialog(null, "Postoji predmet sa istom sifrom!");
				
			}
			
		}
		
	
		
		if(!postoji) {
			
			this.predmeti.add(predmet);

			JOptionPane.showMessageDialog(null, "Predmet uspešno dodat u tabelu!");
			
			TabelaProfesorovihPredmeta.getInstance().azurirajPrikaz("DODAJ", -1);
		}
		
	}
	
	public void obrisiPredmet(Predmet predmet) {
		
		predmeti.remove(predmet);
		
		JOptionPane.showMessageDialog(null, "Predmet uspesno uklonjen iz liste nepoloženih!");
	    TabelaProfesorovihPredmeta.getInstance().azurirajPrikaz("IZBRISAN", -1);
	}
	
	public void osveziTabelu(Profesor profesor) {
		boolean postoji = false;
		for(Predmet predmet1:profesor.getPredmeti()) {
			for(Predmet predmet2:predmeti) {
				if(predmet1 == predmet2) {
					postoji = true;
				}
			}
			if(!postoji) {
				predmeti.add(predmet1);
				TabelaProfesorovihPredmeta.getInstance().azurirajPrikaz("DODAJ", -1);
			}
		}
		
		boolean postoji1 = false;
		for(Predmet predmet1:predmeti) {
			for(Predmet predmet2:profesor.getPredmeti()) {
				if(predmet1 == predmet2) {
					postoji1 = true;
				}
			}
			if(!postoji1) {
				predmeti.remove(predmet1);
				TabelaProfesorovihPredmeta.getInstance().azurirajPrikaz("OBRISI", -1);
			}
		}
	}
	
	
	
}
