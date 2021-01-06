package controller;


import model.BazaStudenata;
import model.Student;
import view.TabelaStudenata;


public class StudentiController {
	
	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(Student student) {
		// izmena modela
		BazaStudenata.getInstance().dodajStudenta(student);
		TabelaStudenata.getInstance().azurirajPrikaz("DODAJ", -1);
	}
	
   
	
}
