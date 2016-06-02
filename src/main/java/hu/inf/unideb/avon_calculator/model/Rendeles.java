package hu.inf.unideb.avon_calculator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Egy rendelést reprezentáló osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class Rendeles {

	/**
	 * A rendelés id-ja.
	 */
	private int id;
	
	/**
	 * A rendelés kampánya(melyik kampányhoz tartozik).
	 */
	private String kampany;
	
	/**
	 * A rendeléshez tartozó vásárló.
	 */
	private Vasarlo vasarlo;
	
	/**
	 * A rendeléshez tartozó terméklista.
	 */
	private List<Termek> vasarloiRendeles = new ArrayList<>();
	
	/**
	 * A rendelés időpontja.
	 */
	private LocalDate idopont;

	/**
	 * A rendelés paraméter nélküli konstruktora.
	 */
	public Rendeles() {
		super();
	}

	/**
	 * A rendelés paraméteres konstruktora.
	 * 
	 * @param kampany Kampány
	 * @param vasarlo Vásárló
	 * @param vasarloiRendeles (Vásárló által rendelt) Terméklista
	 */
	public Rendeles(String kampany, Vasarlo vasarlo, List<Termek> vasarloiRendeles) {
		super();
		this.kampany = kampany;
		this.vasarlo = vasarlo;
		this.vasarloiRendeles = vasarloiRendeles;
		this.idopont = LocalDate.now();
	}

	/**
	 * Lekérdezi a rendelés melyik kampányban lett leadva.
	 * 
	 * @return Kampány
	 */
	public String getKampany() {
		return kampany;
	}

	/**
	 * Beállítja a rendelés kampányát.
	 * 
	 * @param kampany Kampány
	 */
	public void setKampany(String kampany) {
		this.kampany = kampany;
	}

	/**
	 * Lekéri a rendelés id-ját.
	 * 
	 * @return Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Beállítja a rendelés id-ját.
	 * 
	 * @param id Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri a rendeléshez tartozó vásárlói terméklistát.
	 * 
	 * @return Terméklista / Vásárlói rendelés
	 */
	public List<Termek> getVasarloiRendeles() {
		return vasarloiRendeles;
	}

	/**
	 * Terméket ad a vásárlói rendeléshez.
	 * 
	 * @param vasarloiRendeles Terméklista / Vásárlói rendelés
	 */
	public void addTermek(Termek vasarloiRendeles) {
		getVasarloiRendeles().add(vasarloiRendeles);
	}

	/**
	 * Terméket vesz ki a vásárlói rendelésből.
	 * 
	 * @param vasarloiRendeles Terméklista / Vásárlói rendelés
	 * @return
	 */
	public boolean removeTermek(Termek vasarloiRendeles) {
		return getVasarloiRendeles().remove(vasarloiRendeles);
	}

	/**
	 * Lekéri a rendelés időpontját.
	 * 
	 * @return Időpont
	 */
	public LocalDate getIdopont() {
		return idopont;
	}

	/**
	 * Beállítja a rendelés időpontját.
	 * 
	 * @param idopont Időpont
	 */
	public void setIdopont(LocalDate idopont) {
		this.idopont = idopont;
	}

	/**
	 * Lekéri a rendelés vásárlóját.
	 * 
	 * @return Vásárló
	 */
	public Vasarlo getVasarlo() {
		return vasarlo;
	}

	/**
	 * Beállítja a rendelés vásárlóját.
	 * 
	 * @param vasarlo Vásárló
	 */
	public void setVasarlo(Vasarlo vasarlo) {
		this.vasarlo = vasarlo;
	}

	/**
	 * ToString metódus a rendelés kiiratásához.
	 */
	@Override
	public String toString() {
		return "Rendeles: " + id + ", vasarloiRendeles: " + vasarloiRendeles + ", idopont: " + idopont + ", vasarlo: "
				+ vasarlo;
	}

}
