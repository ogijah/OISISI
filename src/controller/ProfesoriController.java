package controller;

import model.BazaProfesora;
import model.Profesor;
import view.TabelaProfesora;


public class ProfesoriController {
private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	private ProfesoriController() {}
	
	public void dodajProfesora(Profesor profesor) {
		// izmena modela
		BazaProfesora.getInstance().dodajProfesora(profesor);
		TabelaProfesora.getInstance().azurirajPrikaz("DODAJ", -1);

	}
	
	public void izmeniProfesora (int rowSelectedIndex,Profesor izmenjen) {
		
		if(rowSelectedIndex < 0) {
			
			return;
			
		}
		
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		BazaProfesora.getInstance().izmeniProfesora(rowSelectedIndex, profesor, izmenjen);
		
		TabelaProfesora.getInstance().azurirajPrikaz("IZMENJEN", -1);
		
	}
	
	public void obrisiProfesora (int selectedRow) {
		
		if(selectedRow < 0) {
			
			return;
			
		}
		
		Profesor profesor = BazaProfesora.getInstance().getRow(selectedRow);
		BazaProfesora.getInstance().obrisiProfesora(selectedRow, profesor);
		
		TabelaProfesora.getInstance().azurirajPrikaz("OBRISAN", -1);
		
	}
}
