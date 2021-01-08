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
	
	public void izmeniStudenta (int rowSelectedIndex,Student izmenjen) {
		
		if(rowSelectedIndex < 0) {
			
			return;
			
		}
		
		Student student = BazaStudenata.getInstance().getRow(rowSelectedIndex);
		BazaStudenata.getInstance().izmeniStudenta(rowSelectedIndex, student, izmenjen);
		
		TabelaStudenata.getInstance().azurirajPrikaz("IZMENJEN", -1);
		
	}
	
   
	
}
