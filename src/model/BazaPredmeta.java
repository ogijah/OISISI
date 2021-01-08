package model;

import java.util.ArrayList;
import java.util.List;


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

	
	
	

}
