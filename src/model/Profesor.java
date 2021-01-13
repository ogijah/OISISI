package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum Titula{BSc, MSc, mr, dr, profdr}
enum Zvanje{saradnik, asistent, docent, vanredni_profesor, redovni_profesor, profesor_emeritus}

public class Profesor {
	private String prezime;
	private String ime;
	private Date datum_rodjenja;
	private String adresa;
	private String telefon;
	private String email;
	private String kancelarija;
	private Integer licna_karta;
	private Titula titula;
	private Zvanje zvanje;
	List<Predmet> predmeti ;
	
	public Profesor(String prezime, String ime, Date datum_rodjenja, String adresa, String telefon, String email,
			String kancelarija, Integer licna_karta) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.kancelarija = kancelarija;
		this.licna_karta = licna_karta;
		this.predmeti = new ArrayList<>();
	
	}
	
	public Profesor(String prezime, String ime,  String adresa, String telefon, String email,
			String kancelarija, Integer licna_karta) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.kancelarija = kancelarija;
		this.licna_karta = licna_karta;
		this.predmeti = new ArrayList<>();
	
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
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
	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}
	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKancelarija() {
		return kancelarija;
	}
	public void setKancelarija(String kancelarija) {
		this.kancelarija = kancelarija;
	}
	public Integer getLicna_karta() {
		return licna_karta;
	}
	public void setLicna_karta(Integer licna_karta) {
		this.licna_karta = licna_karta;
	}
	public Titula getTitula() {
		return titula;
	}
	@SuppressWarnings("static-access")
	public Titula getTitulaMSc() {
		return titula.MSc;
	}
	@SuppressWarnings("static-access")
	public Titula getTitulaBSc() {
		return titula.BSc;
	}
	@SuppressWarnings("static-access")
	public Titula getTitulaDr() {
		return titula.dr;
	}
	@SuppressWarnings("static-access")
	public Titula getTitulaMr() {
		return titula.mr;
	}
	@SuppressWarnings("static-access")
	public Titula getTitulaProfDr() {
		return titula.profdr;
	}
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	
	@SuppressWarnings("static-access")
	public Zvanje getZvanjeAsistent() {
		return zvanje.asistent;
	}
	
	@SuppressWarnings("static-access")
	public Zvanje getZvanjeSaradnik() {
		return zvanje.saradnik;
	}
	
	@SuppressWarnings("static-access")
	public Zvanje getZvanjeDocent() {
		return zvanje.docent;
	}
	
	@SuppressWarnings("static-access")
	public Zvanje getZvanjeVanredniProf() {
		return zvanje.vanredni_profesor;
	}
	
	@SuppressWarnings("static-access")
	public Zvanje getZvanjeRedovniProf() {
		return zvanje.redovni_profesor;
	}
	
	@SuppressWarnings("static-access")
	public Zvanje getZvanjeProfEmeritus() {
		return zvanje.profesor_emeritus;
	}
	
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	
}
