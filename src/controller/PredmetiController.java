package controller;



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
	
	
}
