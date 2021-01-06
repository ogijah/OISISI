package model;



import java.util.Date;
import java.util.List;



	 enum Status {B, S};	//B = budzet , S = samofinansiranje

public class Student {
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresa_Stanovanja;
	private String kontaktTelefon;
	private String EmailAdresa;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	private double prosecnaOcena;
	private List<Predmet> spisakPolozenihIspita;
	private List<Predmet> spisakNepolozenihIspita;
	
	
	public Student(String prezime, String ime, Date datumRodjenja, String adresa_Stanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija, Status status) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa_Stanovanja = adresa_Stanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.EmailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
	}
	
	


	public Student(String prezime, String ime, Date datumRodjenja, String adresa_Stanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa_Stanovanja = adresa_Stanovanja;
		this.kontaktTelefon = kontaktTelefon;
		EmailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}




	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public Date getDatumRodjenja() {
		return datumRodjenja;
	}


	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}


	public String getAdresa_Stanovanja() {
		return adresa_Stanovanja;
	}


	public void setAdresa_Stanovanja(String adresa_Stanovanja) {
		this.adresa_Stanovanja = adresa_Stanovanja;
	}


	public String getKontaktTelefon() {
		return kontaktTelefon;
	}


	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}


	public String getEmailAdresa() {
		return EmailAdresa;
	}


	public void setEmailAdresa(String emailAdresa) {
		EmailAdresa = emailAdresa;
	}


	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}


	public int getGodinaUpisa() {
		return godinaUpisa;
	}


	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}


	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}


	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}


	@SuppressWarnings("static-access")
	public Status getStatusB() {
		return status.B;
	}
	
	@SuppressWarnings("static-access")
	public Status getStatusS() {
		return status.S;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public double getProsecnaOcena() {
		return 0; //TODO:ispraviti posle
	}



	public List<Predmet> getSpisakPolozenihIspita() {
		return spisakPolozenihIspita;
	}


	public void setSpisakPolozenihIspita(List<Predmet> spisakPolozenihIspita) {
		this.spisakPolozenihIspita = spisakPolozenihIspita;
	}


	public List<Predmet> getSpisakNepolozenihIspita() {
		return spisakNepolozenihIspita;
	}


	public void setSpisakNepolozenihIspita(List<Predmet> spisakNepolozenihIspita) {
		this.spisakNepolozenihIspita = spisakNepolozenihIspita;
	}
	
	
	
	
}

;