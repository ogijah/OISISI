package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}


	private List<Profesor> profesori;
	private List<String> kolone;

	private BazaProfesora() {
	
		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");

	}

	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		
		Date date1 = null;
		Titula titula;
		
		Profesor profesor1 = new Profesor("Nikolic", "Milos", "Temerinska 15, Novi Sad", "021/356-785", "milos.nikolic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 600", 123123123);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("12.12.1965.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor1.setDatum_rodjenja(date1);
		profesor1.setTitula(profesor1.getTitulaProfDr());
		profesor1.setZvanje(profesor1.getZvanjeRedovniProf());
		profesori.add(profesor1);
		
		Profesor profesor2 = new Profesor("Mirkovic", "Nikola", "Jovana Cvjića 25, Subotica", "021/368-456", "nikola.mirkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 601", 321321321);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("01.01.1978.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor2.setDatum_rodjenja(date1);
		profesor2.setTitula(profesor2.getTitulaProfDr());
		profesor2.setZvanje(profesor1.getZvanjeRedovniProf());
		profesori.add(profesor2);
		
		Profesor profesor3 = new Profesor("Petkovic", "Ilija", "Gogoljeva 1, Novi Sad", "021/215-314", "ilija.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 602", 456456456);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("03.09.1988.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor3.setDatum_rodjenja(date1);
		profesor3.setTitula(profesor3.getTitulaDr());
		profesor3.setZvanje(profesor3.getZvanjeVanredniProf());
		profesori.add(profesor3);
		
		Profesor profesor4 = new Profesor("Petrovic", "Mitar", "Marka Kraljevića 102, Beograd", "021/884-640", "mitar.petrovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 603", 789789789);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("25.07.1976.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor4.setDatum_rodjenja(date1);
		profesor4.setTitula(profesor4.getTitulaDr());
		profesor4.setZvanje(profesor4.getZvanjeVanredniProf());
		profesori.add(profesor4);
		
		Profesor profesor5 = new Profesor("Micic", "Vasa", "Tolstojeva 55, Novi Sad", "021/212-114", "vasa.micic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 604", 001001001);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("14.02.1970.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor5.setDatum_rodjenja(date1);
		profesor5.setTitula(profesor5.getTitulaDr());
		profesor5.setZvanje(profesor5.getZvanjeDocent());
		profesori.add(profesor5);
		
		Profesor profesor6 = new Profesor("Miletic", "Srdjan", "Šekspirova 12, Novi Sad", "021/978-225", "srdjan.miletic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 605", 002002002);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("20.04.1966.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor6.setDatum_rodjenja(date1);
		profesor6.setTitula(profesor6.getTitulaDr());
		profesor6.setZvanje(profesor6.getZvanjeDocent());
		profesori.add(profesor6);
		
		Profesor profesor7 = new Profesor("Mihajlovic", "Branislav", "Jovana Subotića 99, Novi Sad", "021/778-323", "branislav.mihajlovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 606", 559585632);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("28.06.1980.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor7.setDatum_rodjenja(date1);
		profesor7.setTitula(profesor7.getTitulaProfDr());
		profesor7.setZvanje(profesor7.getZvanjeRedovniProf());
		profesori.add(profesor7);
		
		Profesor profesor8 = new Profesor("Marković", "Marko", "Mirka Markovića 101, Kraljevo", "021/899-659", "marko.markovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 607", 334968855);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("31.01.1985.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor8.setDatum_rodjenja(date1);
		profesor8.setTitula(profesor8.getTitulaProfDr());
		profesor8.setZvanje(profesor8.getZvanjeRedovniProf());
		profesori.add(profesor8);
		
		Profesor profesor9 = new Profesor("Milaković", "Miloš", "Braće Jugović 1, Kragujevac", "021/122-326", "milos.milakovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 608", 073070365);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("21.09.1975.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor9.setDatum_rodjenja(date1);
		profesor9.setTitula(profesor9.getTitulaDr());
		profesor9.setZvanje(profesor9.getZvanjeVanredniProf());
		profesori.add(profesor9);
		
		Profesor profesor10 = new Profesor("Bratić", "Lazar", "Jovanke Orleanke 3, Niš", "021/156-326", "lazar.bratic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 609", 106003786);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("13.11.1973.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor10.setDatum_rodjenja(date1);
		profesor10.setTitula(profesor10.getTitulaDr());
		profesor10.setZvanje(profesor10.getZvanjeVanredniProf());
		profesori.add(profesor10);
		
		Profesor profesor11 = new Profesor("Dražić", "Ljeposava", "Vojvode Stepe 1100, Beograd", "021/888-156", "ljeposava.drazic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, NTP 610", 158496152);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("11.08.1964.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		profesor11.setDatum_rodjenja(date1);
		profesor11.setTitula(profesor11.getTitulaDr());
		profesor11.setZvanje(profesor11.getZvanjeDocent());
		profesori.add(profesor11);
		
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void getStudenti(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	
	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return String.valueOf(profesor.getTitula());
		case 3:
			return String.valueOf(profesor.getZvanje());
		default:
			return null;
		}
	}

	public void dodajProfesora(Profesor profesor) {
		boolean postoji = false;
		for(int i = 0; i < profesori.size();i++) {
			if(profesor.getTelefon().equals(profesori.get(i).getTelefon())){
				postoji = true;
				JOptionPane.showMessageDialog(null,"Postoji profesor sa istim brojem telefona!");
				break;
			}
			if(profesor.getEmail().equals(profesori.get(i).getEmail())){
				postoji = true;
				JOptionPane.showMessageDialog(null,"Postoji profesor sa istim e-mailom!");
				break;
			}
			if(profesor.getLicna_karta().equals(profesori.get(i).getLicna_karta())){
				postoji = true;
				JOptionPane.showMessageDialog(null,"Postoji profesor sa istim brojem lične karte!");
				break;
			}
			
		}
		if(!postoji) {
			this.profesori.add(profesor);
			JOptionPane.showMessageDialog(null,"Profesor uspešno dodat u tabelu!");
		}
		
	}
	public void izmeniProfesora(int row, Profesor profesor, Profesor izmenjen) {
		boolean postoji = false;
		for(int i = 0; i < profesori.size(); i++) {
			if(profesor != profesori.get(i)) {
				if(izmenjen.getTelefon().equals(profesori.get(i).getTelefon())){
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji profesor sa unetim brojem telefona!");
					break;
				}
				if(izmenjen.getEmail().equals(profesori.get(i).getEmail())){
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji profesor sa unetim e-mailom!");
					break;
				}
				if(izmenjen.getLicna_karta().equals(profesori.get(i).getLicna_karta())){
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji profesor sa unetom licnom kartom!");
					break;
				}
			}
		}
		
		if(!postoji) {
			profesor.setAdresa(izmenjen.getAdresa());
			profesor.setIme(izmenjen.getIme());
			profesor.setPrezime(izmenjen.getPrezime());
			profesor.setDatum_rodjenja(izmenjen.getDatum_rodjenja());
			profesor.setEmail(izmenjen.getEmail());
			profesor.setKancelarija(izmenjen.getKancelarija());
			profesor.setLicna_karta(izmenjen.getLicna_karta());
			profesor.setTelefon(izmenjen.getTelefon());
			profesor.setTitula(izmenjen.getTitula());
			profesor.setZvanje(izmenjen.getZvanje());

			
			this.profesori.set(row, profesor);
			JOptionPane.showMessageDialog(null, "Profesor je uspesno izmenjen!");
		}
	}
	
	public void obrisiProfesora (int row, Profesor profesor) {
		
		profesori.remove(profesor);
		
		JOptionPane.showMessageDialog(null, "Profesor uspesno obrisan!");
		
	}
	
	
	
}
