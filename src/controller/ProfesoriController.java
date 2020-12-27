package controller;

import model.BazaProfesora;
import model.Profesor;


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
		
	}
}
