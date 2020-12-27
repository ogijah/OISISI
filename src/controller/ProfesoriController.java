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
}
