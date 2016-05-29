package hu.inf.unideb.avon_calculator;

public class Termek {

	private int id;
	private int cikkszam;
	private String nev;
	private int ar;
	private int darabszam;
	private int avonKedvezmeny;

	public Termek() {
		super();
	}

	public Termek(int cikkszam, String nev, int ar, int darabszam, int avonKedvezmeny) {
		super();
		this.cikkszam = cikkszam;
		this.nev = nev;
		this.ar = ar;
		this.darabszam = darabszam;
		this.avonKedvezmeny = avonKedvezmeny;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCikkszam() {
		return cikkszam;
	}

	public void setCikkszam(int cikkszam) {
		this.cikkszam = cikkszam;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
	}

	public int getDarabszam() {
		return darabszam;
	}

	public void setDarabszam(int darabszam) {
		this.darabszam = darabszam;
	}

	public int getAvonKedvezmeny() {
		return avonKedvezmeny;
	}

	public void setAvonKedvezmeny(int avonKedvezmeny) throws IllegalArgumentException {
		if (avonKedvezmeny < 0 || avonKedvezmeny > 100)
			throw new IllegalArgumentException();
		this.avonKedvezmeny = avonKedvezmeny;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ar;
		result = prime * result + avonKedvezmeny;
		result = prime * result + cikkszam;
		result = prime * result + darabszam;
		result = prime * result + id;
		result = prime * result + ((nev == null) ? 0 : nev.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Termek other = (Termek) obj;
		if (ar != other.ar)
			return false;
		if (avonKedvezmeny != other.avonKedvezmeny)
			return false;
		if (cikkszam != other.cikkszam)
			return false;
		if (darabszam != other.darabszam)
			return false;
		if (id != other.id)
			return false;
		if (nev == null) {
			if (other.nev != null)
				return false;
		} else if (!nev.equals(other.nev))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Termek: " + id + ", cikkszam: " + cikkszam + ", nev: " + nev + ", ar: " + ar + ", darabszam: "
				+ darabszam + ", avonKedvezmeny: " + avonKedvezmeny;
	}

}
