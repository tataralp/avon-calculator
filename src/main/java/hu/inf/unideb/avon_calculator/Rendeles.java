package hu.inf.unideb.avon_calculator;

import java.time.LocalDateTime;
import java.util.List;

public class Rendeles {

	private int id;
	private String kampány;
	private Vasarlo vasarlo;
	private List<Termek> vasarloiRendeles;
	private LocalDateTime idopont;

	public Rendeles() {
		super();
	}

	public Rendeles(String kampány, Vasarlo vasarlo, List<Termek> vasarloiRendeles) {
		super();
		this.kampány = kampány;
		this.vasarlo = vasarlo;
		this.vasarloiRendeles = vasarloiRendeles;
		this.idopont = LocalDateTime.now();
	}

	public String getKampány() {
		return kampány;
	}

	public void setKampány(String kampány) {
		this.kampány = kampány;
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

	public LocalDateTime getIdopont() {
		return idopont;
	}

	public void setIdopont(LocalDateTime idopont) {
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
