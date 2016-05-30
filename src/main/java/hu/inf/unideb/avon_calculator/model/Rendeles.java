package hu.inf.unideb.avon_calculator.model;

import java.time.LocalDate;
import java.util.List;

public class Rendeles {

	private int id;
	private String kampany;
	private Vasarlo vasarlo;
	private List<Termek> vasarloiRendeles;
	private LocalDate idopont;

	public Rendeles() {
		super();
	}

	public Rendeles(String kampany, Vasarlo vasarlo, List<Termek> vasarloiRendeles) {
		super();
		this.kampany = kampany;
		this.vasarlo = vasarlo;
		this.vasarloiRendeles = vasarloiRendeles;
		this.idopont = LocalDate.now();
	}

	public String getKampany() {
		return kampany;
	}

	public void setKampany(String kampany) {
		this.kampany = kampany;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Termek> getVasarloiRendeles() {
		return vasarloiRendeles;
	}

	public void addTermek(Termek vasarloiRendeles) {
		getVasarloiRendeles().add(vasarloiRendeles);
	}

	public boolean removeTermek(Termek vasarloiRendeles) {
		return getVasarloiRendeles().remove(vasarloiRendeles);
	}

	public LocalDate getIdopont() {
		return idopont;
	}

	public void setIdopont(LocalDate idopont) {
		this.idopont = idopont;
	}

	public Vasarlo getVasarlo() {
		return vasarlo;
	}

	public void setVasarlo(Vasarlo vasarlo) {
		this.vasarlo = vasarlo;
	}

	@Override
	public String toString() {
		return "Rendeles: " + id + ", vasarloiRendeles: " + vasarloiRendeles + ", idopont: " + idopont + ", vasarlo: "
				+ vasarlo;
	}

}
