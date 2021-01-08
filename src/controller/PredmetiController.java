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
	
	public void izmeniPredmet(int selectedRow, Predmet izmenjen) {
		
		if(selectedRow < 0) {
			
			return;
			
		}
		
		Predmet predmet = BazaPredmeta.getInstance().getRow(selectedRow);
		BazaPredmeta.getInstance().izmeniPredmet(selectedRow, predmet, izmenjen);

		TabelaPredmeta.getInstance().azurirajPrikaz("IZMENJEN", -1);
		
	}
	
	public void obrisiPredmet (int selectedRow) {
		
		if(selectedRow < 0) {
			
			return;
			
		}
		
		Predmet predmet = BazaPredmeta.getInstance().getRow(selectedRow);
		BazaPredmeta.getInstance().obrisiPredmet(selectedRow, predmet);
		
		TabelaPredmeta.getInstance().azurirajPrikaz("OBRISAN", -1);
		
	}
	
	
}
