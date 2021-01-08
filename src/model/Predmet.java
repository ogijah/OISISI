package model;

import java.util.List;

enum Semestar{letnji, zimski};

public class Predmet {
	private String sifra;
	private String naziv;
	private Semestar semestar;
	private Integer godina_studija;
	public Profesor profesor;
	private Integer ESPB;
	List<Student> polozili;
	List<Student> nisu_polozili;
	
	public Predmet(String sifra, String naziv, Semestar semestar, Integer godina_studija, Profesor profesor,
			Integer ESPB) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
		this.profesor = profesor;
		this.ESPB = ESPB;
	}
	
	//konstruktor bez profesora i semestra
	public Predmet(String sifra, String naziv, Integer godina_studija, Integer ESPB) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.godina_studija = godina_studija;
		this.ESPB = ESPB;
	}
	
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Semestar getSemestar() {
		return semestar;
	}
	
	@SuppressWarnings("static-access")
	public Semestar getSemestarLetnji() {
		
		return semestar.letnji;
		
	}
	
	@SuppressWarnings("static-access")
	public Semestar getSemestarZimski() {
		
		return semestar.zimski;
		
	}
	
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	public Integer getGodina_studija() {
		return godina_studija;
	}
	public void setGodina_studija(Integer godina_studija) {
		this.godina_studija = godina_studija;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Integer getESPB() {
		return ESPB;
	}
	public void setESPB(Integer eSPB) {
		ESPB = eSPB;
	}
	public List<Student> getPolozili() {
		return polozili;
	}
	public void setPolozili(List<Student> polozili) {
		this.polozili = polozili;
	}
	public List<Student> getNisu_polozili() {
		return nisu_polozili;
	}
	public void setNisu_polozili(List<Student> nisu_polozili) {
		this.nisu_polozili = nisu_polozili;
	}
	
	
}
