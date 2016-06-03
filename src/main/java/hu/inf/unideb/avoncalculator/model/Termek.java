package hu.inf.unideb.avoncalculator.model;

/**
 * Terméket reprezentáló osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class Termek {

	/**
	 * Termék id-ja.
	 */
	private int id;
	
	/**
	 * Termék cikkszáma.
	 */
	private int cikkszam;
	
	/**
	 * Termék megnevezése/neve.
	 */
	private String nev;
	
	/**
	 * Termék ára.
	 */
	private int ar;
	
	/**
	 * Termék darabszáma/mennyisége.
	 */
	private int darabszam;
	
	/**
	 * Termék Avon kedvezmény értéke.
	 */
	private int avonKedvezmeny;

	/**
	 * Termék paraméter nélküli konstruktora.
	 */
	public Termek() {
		super();
	}

	/**
	 * Termék paraméteres konstruktora.
	 * 
	 * @param cikkszam Cikkszám
	 * @param nev Név
	 * @param ar Ár
	 * @param darabszam Darabszám
	 * @param avonKedvezmeny Avon kedvezmény
	 */
	public Termek(int cikkszam, String nev, int ar, int darabszam, int avonKedvezmeny) {
		super();
		this.setCikkszam(cikkszam);
		this.nev = nev;
		this.setAr(ar);
		this.setDarabszam(darabszam);
		this.setAvonKedvezmeny(avonKedvezmeny);
	}

	/**
	 * Lekéri a termék id-ját.
	 * 
	 * @return Termék id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Beállítja a termék id-ját.
	 * 
	 * @param id Termék id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri a termék cikkszámát.
	 * 
	 * @return Cikkszám
	 */
	public int getCikkszam() {
		return cikkszam;
	}

	/**
	 * Beállítja a termék cikkszámát.
	 * 
	 * @param cikkszam Cikkszám
	 * @throws IllegalArgumentException Exception dobása, ha a cikkszám kisebb mint nulla, vagy nagyobb mint 99999.
	 */
	public void setCikkszam(int cikkszam) throws IllegalArgumentException{
		if ( cikkszam < 0 || cikkszam > 99999 )
			throw new IllegalArgumentException();
		this.cikkszam = cikkszam;
	}

	/**
	 * Lekéri a termék nevét / megnevezését.
	 * 
	 * @return Név
	 */
	public String getNev() {
		return nev;
	}

	/**
	 * Beállítja a termék nevét / megnevezését.
	 * 
	 * @param nev Név
	 */
	public void setNev(String nev) {
		this.nev = nev;
	}

	/**
	 * Lekéri a termék árát.
	 * 
	 * @return Ár
	 */
	public int getAr() {
		return ar;
	}

	/**
	 * Beállítja a termék árát.
	 * 
	 * @param ar Ár
	 * @throws IllegalArgumentException Exception dobása, ha az ár kisebb mint nulla.
	 */
	public void setAr(int ar) throws IllegalArgumentException {
		if (ar < 0)
			throw new IllegalArgumentException();
		this.ar = ar;
	}

	/**
	 * Lekéri a termék darabszámt.
	 * 
	 * @return Darabszám
	 */
	public int getDarabszam() {
		return darabszam;
	}

	/**
	 * Beállítja a termék darabszámát.
	 * 
	 * @param darabszam Darabszám
	 * @throws IllegalArgumentException Exceptiont dobása, ha a darabszám kisebb mint egy.
	 */
	public void setDarabszam(int darabszam) throws IllegalArgumentException {
		if (darabszam < 1)
			throw new IllegalArgumentException();
		this.darabszam = darabszam;
	}

	/**
	 * Lekéri a termék Avon kedvezményét.
	 * 
	 * @return Avon kedvezmény
	 */
	public int getAvonKedvezmeny() {
		return avonKedvezmeny;
	}

	/**
	 * Beállítja a termék Avon kedvezményét.
	 * 
	 * @param avonKedvezmeny Avon kedvezmény
	 * @throws IllegalArgumentException Exception dobása, ha a kedvezmény értéke nem 0 és 100 közé esik.
	 */
	public void setAvonKedvezmeny(int avonKedvezmeny) throws IllegalArgumentException {
		if (avonKedvezmeny < 0 || avonKedvezmeny > 100)
			throw new IllegalArgumentException();
		this.avonKedvezmeny = avonKedvezmeny;
	}

	/**
	 * HashCode generálása.
	 */
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

	/**
	 * Az equals metódus a termékek összehasonlításához.
	 */
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

	/**
	 * ToString metódus a termék kiiratásához.
	 */
	@Override
	public String toString() {
		return "Termek: " + id + ", cikkszam: " + cikkszam + ", nev: " + nev + ", ar: " + ar + ", darabszam: "
				+ darabszam + ", avonKedvezmeny: " + avonKedvezmeny;
	}

}
