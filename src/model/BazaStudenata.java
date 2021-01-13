package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}


	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudenata() {
	
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");

	}

	private void initStudente()  {
		this.studenti = new ArrayList<Student>();
		Date date1 = null;
		Student student1 = new Student("RA 2/2020","Marko","Milosevic",1,"Karađorđeva 83, Novi Sad"	,"021/333-555","marko.milosevic@mailinator.com",2020);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("12.03.2001.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		student1.setDatumRodjenja(date1); student1.setStatus(student1.getStatusB()); studenti.add(student1);
		
		Student student2 = new Student("RA 3/2019","Marija","Milić",2,"Stražilovska 12, Novi Sad","021/555-2222","marija.milic@mailinator.com",2019);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("12.01.2000.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student2.setDatumRodjenja(date1); student2.setStatus(student2.getStatusS()); studenti.add(student2);
		
		
		
		
	
		
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void getStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	
	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return student.getTrenutnaGodinaStudija();
		case 4:
			return String.valueOf(student.getStatus());
		case 5:
			return student.getProsecnaOcena();
		default:
			return null;
		}
	}

	public void dodajStudenta(Student student) {
		boolean postoji = false;
		for(int i = 0; i < studenti.size();i++) {
			if(student.getBrojIndeksa().equals(studenti.get(i).getBrojIndeksa())){
				postoji = true;
				JOptionPane.showMessageDialog(null, "Postoji student sa istim brojem indeksa!");
				break;
			}
			if(student.getEmailAdresa().equals(studenti.get(i).getEmailAdresa())) {
				postoji = true;
				JOptionPane.showMessageDialog(null, "Postoji student sa istom e-mail adresom!");
				break;
			}
			if(student.getKontaktTelefon().equals(studenti.get(i).getKontaktTelefon())) {
				postoji = true;
				JOptionPane.showMessageDialog(null, "Postoji student sa istim brojem telefona!");
				break;
			}
		}
		if(!postoji) {
			this.studenti.add(student);
			JOptionPane.showMessageDialog(null, "Student uspešno dodat u tabelu!");	
		}
		
	}
	
	public void izmeniStudenta (int row, Student student, Student izmenjen) {
		boolean postoji = false;
		for(int i = 0; i < studenti.size(); i++) {
			if(student != studenti.get(i)) {
				if(izmenjen.getBrojIndeksa().equals(studenti.get(i).getBrojIndeksa())){
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji student sa istim brojem indeksa!");
				}
				if(izmenjen.getEmailAdresa().equals(studenti.get(i).getEmailAdresa())) {
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji student sa istom e-mail adresom!");
				}
				if(izmenjen.getKontaktTelefon().equals(studenti.get(i).getKontaktTelefon())) {
					postoji = true;
					JOptionPane.showMessageDialog(null, "Postoji student sa istim brojem telefona!");
				}
			}
		}
		if(!postoji) {
			student.setIme(izmenjen.getIme());
			student.setPrezime(izmenjen.getPrezime());
			student.setDatumRodjenja(izmenjen.getDatumRodjenja());
			student.setAdresa_Stanovanja(izmenjen.getAdresa_Stanovanja());
			student.setKontaktTelefon(izmenjen.getKontaktTelefon());
			student.setEmailAdresa(izmenjen.getEmailAdresa());
			student.setGodinaUpisa(izmenjen.getGodinaUpisa());
			student.setTrenutnaGodinaStudija(izmenjen.getTrenutnaGodinaStudija());
			student.setBrojIndeksa(izmenjen.getBrojIndeksa());
			student.setStatus(izmenjen.getStatus());
			
			this.studenti.set(row, student);
			JOptionPane.showMessageDialog(null, "Student uspešno izmenjen!");
		}

	}
	
	public void obrisiStudenta (int row, Student student) {
		
		studenti.remove(student);
		
		JOptionPane.showMessageDialog(null, "Student uspesno obrisan!");
		
	}


}
