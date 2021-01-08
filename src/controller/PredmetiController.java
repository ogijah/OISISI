package controller;

import model.BazaPredmeta;
import model.Predmet;
import view.TabelaPredmeta;

public class PredmetiController {

	private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		
		if(instance == null) {
			
			instance = new PredmetiController();
			
		}
		
		return instance;
		
	}
	
	private PredmetiController() {
		
	}
	
	public void dodajPredmet(Predmet predmet) {
		
		//izmena modela
		BazaPredmeta.getInstance().dodajPredmet(predmet);
		TabelaPredmeta.getInstance().azurirajPrikaz("DODAJ", -1);
		
	}
	
	
}
