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
		
		
		Student student3 = new Student("RA 3/2017","Nikola"	,"Nikolic",1,"Knez Mihajlova 16 Beograd"	,"021/135-463","nikola.nikolic@mailinator.com",2017);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("30.08.2001.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student3.setDatumRodjenja(date1); student3.setStatus(student3.getStatusB()); studenti.add(student3);
		
		Student student4 = new Student("RA 134/2015","Pera"	,"Peric",3,"Gogoljeva 3, Novi Sad","021/903-463","pera.peric@mailinator.com",2015);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("07.06.1995.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student4.setDatumRodjenja(date1); student4.setStatus(student4.getStatusB()); studenti.add(student4);
		
		Student student5 = new Student("RA 5/2019","Sofija","Ilic", 3, "Miše Dimitrijevića 44, Novi Sad	", "021/731-067","sofija.ilic@mailinator.com",2019);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("06.05.1999.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student5.setDatumRodjenja(date1); student5.setStatus(student5.getStatusB()); studenti.add(student5);
		
		Student student6 = new Student("RA 8/2018","Martina","Lukic",3,"Vojvode Stepe 180, Beograd","011/4333-800","martina.lukic@mailinator.com", 2018);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("16.05.1999.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student6.setDatumRodjenja(date1); student6.setStatus(student6.getStatusS()); studenti.add(student6);
		
		Student student7 = new Student("RA 10/2017"	,"Stojan","Stojakovic",1,"1300 Kaplara, Šabac","011/3130-007","stojan.stojakovic@mailinator.com",2017);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("19.10.2001.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student7.setDatumRodjenja(date1); student7.setStatus(student7.getStatusB()); studenti.add(student7);
		
		Student student8 = new Student("RA 12/2017","Milan", "Milanovic",2, "Surepova 12, Šabac	", "015/313-061","milan.milanovic@mailinator.com",2017);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("02.11.2000.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student8.setDatumRodjenja(date1); student8.setStatus(student8.getStatusS()); studenti.add(student8);
		
		Student student9 = new Student("RA 16/2019","Miroslav","Milic",2,"Milovana Glišića, Valjevo", "021/351-091","miroslav.milic@mailinator.com",2019);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("11.10.2000.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student9.setDatumRodjenja(date1); student9.setStatus(student9.getStatusB()); studenti.add(student9);
		
		Student student10 = new Student("RA 21/2015","Stefan","Gojic",3,"Bulevar Mihajla Pupina, Novi Sad","015/324-500","stefan.gojic@mailinator.com",2015);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("01.05.1999.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student10.setDatumRodjenja(date1); student10.setStatus(student10.getStatusS()); studenti.add(student10);
		
		Student student11 = new Student("RA 9/2020", "Anastasija","Jokic",3,"Braće Ribnikar 12, Novi Sad ", "011/2333-900","anastasija.jokic@mailinator.com",2020);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("11.07.1999.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student11.setDatumRodjenja(date1); student11.setStatus(student11.getStatusB()); studenti.add(student11);
		
		Student student12 = new Student("RA 4/2017","Bogdan", "Bogdanovic",3, "Cara Dušana 42, Subotica","021/231-114","bogdan.bogdanovic@mailinator.com",2017);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("23.07.1999.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student12.setDatumRodjenja(date1); student12.setStatus(student12.getStatusS()); studenti.add(student12);
		
		Student student13 = new Student("RA 30/2019","Ana","Dabovic",1,"Marka Kraljevića 1, Kikinda	", "014/303-007", "ana.dabovic@mailinator.com",2019);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("	12.12.2001.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student13.setDatumRodjenja(date1); student13.setStatus(student13.getStatusB()); studenti.add(student13);
		
		Student student14 = new Student("RA 1/2020","Mika","Mikic",1,"Nikole Stojanovića 2, Kraljevo ", "015/101-909","mika.mikic@mailinator.com", 2020);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("05.11.2001.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student14.setDatumRodjenja(date1); student14.setStatus(student14.getStatusS()); studenti.add(student14);
		
		Student student15 = new Student("RA 11/2018", "Jovan","Deretic", 4, "Marka Bratića 99, Niš", "002/200-300","jovan.deretic@mailinator.com",2018);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("10.09.1998.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student15.setDatumRodjenja(date1); student15.setStatus(student15.getStatusB()); studenti.add(student15);
		
		Student student16 = new Student("RA 12/2018" ,"Nikola", "Miskovic",4, "Cara Dušana 12, Banja Luka", "022/123-456", "nikola.miskovic@mailinator.com",2018);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("03.08.1998.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student16.setDatumRodjenja(date1); student16.setStatus(student16.getStatusS()); studenti.add(student16);
		
		Student student17 = new Student("RA 13/2018","Martin","Stojanovic",4, "Borisa Bačkog 1, Bijeljina" ,"024/321-775", "martin.stojanovic@mailinator.com", 2018);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("01.05.1998.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student17.setDatumRodjenja(date1); student17.setStatus(student17.getStatusS()); studenti.add(student17);
		
		Student student18= new Student("RA 14/2018", "Tomislav", "Novakovic",4, "Mirka Maksića 10, Kruševac	", "011/1188-379" ,"tomislav.novakovic@mailinator.com",2018);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("25.02.1996.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student18.setDatumRodjenja(date1); student18.setStatus(student18.getStatusB()); studenti.add(student18);
		
		Student student19 = new Student("RA 154/2016","Lena","Ivic", 4, "Stari Most 6, Sremska Mitrovica","024/333-555", "lena.ivic@mailinator.com",2016);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("11.05.1998.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student19.setDatumRodjenja(date1); student19.setStatus(student2.getStatusB()); studenti.add(student19);
		
		Student student20 = new Student("RA 23/2020","Jovan","Lazic",1,"Nevesinjskih ustanika 10, Nevesinje	","025/1189-479","jovan.lazic@mailinator.com", 2020);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("22.01.2001.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student20.setDatumRodjenja(date1); student20.setStatus(student20.getStatusB()); studenti.add(student20);
		
		Student student21 = new Student("RA 1/2019","Isidora","Mikic",2,"Radničка 11, Novi Sad" ,"011/1122-366"	,"isidora.mikic@mailinator.com",2019);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("31.12.2000.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student21.setDatumRodjenja(date1); student21.setStatus(student21.getStatusB()); studenti.add(student21);
		
		
		Student student22 = new Student("SW 4/2014","Vladimir","Ilic",4,"Miloša Obilića 1, Beograd","0211122-367"	,"vladimir.ilic@mailinator.com"	,2014);
		try {
			date1 = new SimpleDateFormat("dd.mm.yyyy.").parse("31.08.1998.");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		student22.setDatumRodjenja(date1); student22.setStatus(student22.getStatusB()); studenti.add(student22);
		
		
		
		
		
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
