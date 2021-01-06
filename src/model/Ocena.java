package model;

import java.util.Date;

public class Ocena {
	
	private Student student;
	private Predmet predmet;
	private int brojcanaVrednostOcene;
	private Date datumPolaganjaIspita;
	
	public Ocena(Student student, Predmet predmet, int brojcanaVrednostOcene, Date datumPolaganjaIspita) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.brojcanaVrednostOcene = brojcanaVrednostOcene;
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getBrojcanaVrednostOcene() {
		return brojcanaVrednostOcene;
	}

	public void setBrojcanaVrednostOcene(int brojcanaVrednostOcene) {
		while(brojcanaVrednostOcene < 6 || brojcanaVrednostOcene > 10) {
			this.brojcanaVrednostOcene = brojcanaVrednostOcene;
		}
	}

	public Date getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}

	public void setDatumPolaganjaIspita(Date datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}
	
	

}