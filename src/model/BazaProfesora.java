package model;

import java.util.ArrayList;
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

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getTitula();
		case 3:
			return profesor.getZvanje();
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
}
