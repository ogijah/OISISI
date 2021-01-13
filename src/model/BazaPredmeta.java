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
		Predmet predmet1 = new Predmet("p1", "osnove programiranja", 1, 7);
		predmet1.setSemestar(predmet1.getSemestarZimski());
		predmeti.add(predmet1);
		Predmet predmet2 = new Predmet("p2", "statistika", 3, 8);
		predmet2.setSemestar(predmet2.getSemestarLetnji());
		predmeti.add(predmet2);
		Predmet predmet3 = new Predmet("p3", "algoritmi i strukture podataka", 2, 9);
		predmet3.setSemestar(predmet3.getSemestarLetnji());
		predmeti.add(predmet3);
		Predmet predmet4 = new Predmet("p4", "LPRS", 3, 7);
		predmet4.setSemestar(predmet4.getSemestarZimski());
		predmeti.add(predmet4);
		Predmet predmet5 = new Predmet("p5", "matematika", 1, 11);
		predmet5.setSemestar(predmet5.getSemestarLetnji());
		predmeti.add(predmet5);
		Predmet predmet6 = new Predmet("p6", "xml i web servisi", 4, 6);
		predmet6.setSemestar(predmet6.getSemestarLetnji());
		predmeti.add(predmet6);
		Predmet predmet7 = new Predmet("p7", "Metode optimizacije", 3, 6);
		predmet7.setSemestar(predmet7.getSemestarZimski());
		predmeti.add(predmet7);
		Predmet predmet8 = new Predmet("p8", "osnove elektortehnike", 1, 11);
		predmet8.setSemestar(predmet8.getSemestarLetnji());
		predmeti.add(predmet8);
		Predmet predmet9 = new Predmet("p9", "Sociologija", 1, 10);
		predmet9.setSemestar(predmet9.getSemestarZimski());
		predmeti.add(predmet9);
		Predmet predmet10 = new Predmet("p10", "Filozofija", 1, 4);
		predmet10.setSemestar(predmet10.getSemestarZimski());
		predmeti.add(predmet10);
		Predmet predmet11 = new Predmet("p11", "ORT", 2, 7);
		predmet11.setSemestar(predmet11.getSemestarLetnji());
		predmeti.add(predmet11);
		Predmet predmet12 = new Predmet("p12", "NANS", 2, 5);
		predmet12.setSemestar(predmet12.getSemestarLetnji());
		predmeti.add(predmet12);
		Predmet predmet13 = new Predmet("p13", "Organizacija podataka", 2, 7);
		predmet13.setSemestar(predmet13.getSemestarZimski());
		predmeti.add(predmet13);
		Predmet predmet14 = new Predmet("p14", "Baze podataka", 2, 6);
		predmet14.setSemestar(predmet14.getSemestarZimski());
		predmeti.add(predmet14);
		Predmet predmet15 = new Predmet("p15", "paralelno programiranje", 2, 8);
		predmet15.setSemestar(predmet15.getSemestarZimski());
		predmeti.add(predmet15);
		Predmet predmet16 = new Predmet("p16", "konkurentno programiranje", 2, 9);
		predmet16.setSemestar(predmet16.getSemestarLetnji());
		predmeti.add(predmet16);
		Predmet predmet17 = new Predmet("p17", "Operativni sistemi", 2, 8);
		predmet17.setSemestar(predmet17.getSemestarLetnji());
		predmeti.add(predmet17);
		Predmet predmet18 = new Predmet("p18", "Algebra", 1, 15);
		predmet18.setSemestar(predmet18.getSemestarZimski());
		predmeti.add(predmet18);
		Predmet predmet19 = new Predmet("p19", "Verovatnoca", 3, 14);
		predmet19.setSemestar(predmet19.getSemestarLetnji());
		predmeti.add(predmet19);
		Predmet predmet20 = new Predmet("ps20", "Upravljacki sistemi", 3, 8);
		predmet20.setSemestar(predmet20.getSemestarLetnji());
		predmeti.add(predmet20);
		Predmet predmet21 = new Predmet("ps21", "Osnovi elektronike", 2, 7);
		predmet21.setSemestar(predmet21.getSemestarZimski());
		predmeti.add(predmet21);
		Predmet predmet22 = new Predmet("ps22", "Slucajni procesi", 4, 9);
		predmet22.setSemestar(predmet22.getSemestarLetnji());
		predmeti.add(predmet22);
		Predmet predmet23 = new Predmet("ps23", "Racunarstvo visokih performansi", 4, 10);
		predmet23.setSemestar(predmet23.getSemestarLetnji());
		predmeti.add(predmet23);
		Predmet predmet24 = new Predmet("p24", "Analiza 1", 1, 20);
		predmet24.setSemestar(predmet24.getSemestarZimski());
		predmeti.add(predmet24);
		Predmet predmet25 = new Predmet("it25", "Informaciona bezbednost", 4, 9);
		predmet25.setSemestar(predmet25.getSemestarLetnji());
		predmeti.add(predmet25);
		Predmet predmet26 = new Predmet("it26", "Elektronsko placanje", 3, 8);
		predmet26.setSemestar(predmet26.getSemestarZimski());
		predmeti.add(predmet26);
		Predmet predmet27 = new Predmet("it27", "Distribuirani sistemi", 4, 6);
		predmet27.setSemestar(predmet27.getSemestarZimski());
		predmeti.add(predmet27);
		Predmet predmet28 = new Predmet("p28", "Projektovanje softvera", 3, 5);
		predmet28.setSemestar(predmet28.getSemestarZimski());
		predmeti.add(predmet28);
		Predmet predmet29 = new Predmet("p29", "Informacioni sistemi", 4, 6);
		predmet29.setSemestar(predmet29.getSemestarZimski());
		predmeti.add(predmet29);
		Predmet predmet30 = new Predmet("p30", "Masinsko ucenje", 4, 7);
		predmet30.setSemestar(predmet30.getSemestarLetnji());
		predmeti.add(predmet30);
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

	public Object getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getESPB();
		case 3:
			return predmet.getGodina_studija();
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
