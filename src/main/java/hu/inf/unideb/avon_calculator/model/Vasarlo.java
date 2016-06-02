package hu.inf.unideb.avon_calculator.model;

/**
 * Egy vásárlót reprezentáló osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class Vasarlo {

	/**
	 * Vásáró azonosító.
	 */
	private int id;
	
	/**
	 * Vásárló vezetékneve.
	 */
	private String vezetekNev;
	
	/**
	 * Vásárló keresztneve.
	 */
	private String keresztNev;
	
	/**
	 * Vásárló telefonszáma.
	 */
	private String telefonszam;
	
	/**
	 * Vásárló e-mail címe.
	 */
	private String email;
	
	/**
	 * Vásárlónak adott kedvezmény értéke. 
	 */
	private int vasarloKedvezmeny;

	/**
	 * Paraméter nélküli konstruktor.
	 */
	public Vasarlo() {
		super();
	}

	/**
	 * Pareméteres konstuktor.
	 * @param vezetekNev Vezetéknév
	 * @param keresztNev Keresztnév
	 * @param telefonszam Telefonszám
	 * @param email E-mail
	 * @param vasarloKedvezmeny Vásárló kedvezménye
	 */
	public Vasarlo(String vezetekNev, String keresztNev, String telefonszam, String email, int vasarloKedvezmeny) {
		super();
		this.vezetekNev = vezetekNev;
		this.keresztNev = keresztNev;
		this.telefonszam = telefonszam;
		this.email = email;
		this.setVasarloKedvezmeny(vasarloKedvezmeny);
	}

	/**
	 * Lekéri a vásárló id-ját.
	 * 
	 * @return Vásárló id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Beállítja a vásárló id-ját.
	 * 
	 * @param id Vásárló id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri a vásárló keresztnevét.
	 * 
	 * @return Keresztnév
	 */
	public String getKeresztNev() {
		return keresztNev;
	}
 /**
  * Beállítja a vásárló keresztnevét.
  * 
  * @param keresztNev Keresztnév
  */
	public void setKeresztNev(String keresztNev) {
		this.keresztNev = keresztNev;
	}

	/**
	 * Lekéri a vásárló vezetéknevét.
	 * 
	 * @return Vezetéknév
	 */
	public String getVezetekNev() {
		return vezetekNev;
	}

	/**
	 * Lekéri a vásárló veetéknevét.
	 * 
	 * @param vezetekNev Vezetéknév
	 */
	public void setVezetekNev(String vezetekNev) {
		this.vezetekNev = vezetekNev;
	}

	/**
	 * Lekéri a vásárló telefonszámát.
	 * 
	 * @return Telefonszám
	 */
	public String getTelefonszam() {
		return telefonszam;
	}

	/**
	 * Beállítja a vásárló telefonszámát.
	 * 
	 * @param telefonszam Telefonszám
	 */
	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}

	/**
	 * Lekéri a vásárló e-mail címét.
	 * 
	 * @return E-mail cím
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Beállítja a vásárló e-mail címét
	 * 
	 * @param email E-mail cím
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Lekéri a vásárló kedvezményét.
	 * 
	 * @return Vásárló kedvezmény
	 */
	public int getVasarloKedvezmeny() {
		return vasarloKedvezmeny;
	}

	/**
	 * Beállítja a vásárló kedvezményét.
	 * 
	 * @param vasarloKedvezmeny Vásárló kedvezménye
	 * @throws IllegalArgumentException Exception dobás, ha a kedvezmény értéke nem 0 és 100 közé esik.
	 */
	public void setVasarloKedvezmeny(int vasarloKedvezmeny) throws IllegalArgumentException {
		if (vasarloKedvezmeny < 0 || vasarloKedvezmeny > 100)
			throw new IllegalArgumentException();
		this.vasarloKedvezmeny = vasarloKedvezmeny;
	}

	/**
	 * A hashCode generálása.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((keresztNev == null) ? 0 : keresztNev.hashCode());
		result = prime * result + ((telefonszam == null) ? 0 : telefonszam.hashCode());
		result = prime * result + vasarloKedvezmeny;
		result = prime * result + ((vezetekNev == null) ? 0 : vezetekNev.hashCode());
		return result;
	}

	/**
	 * Az equals metódus a vásárlók összehasonlításához.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vasarlo other = (Vasarlo) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (keresztNev == null) {
			if (other.keresztNev != null)
				return false;
		} else if (!keresztNev.equals(other.keresztNev))
			return false;
		if (telefonszam == null) {
			if (other.telefonszam != null)
				return false;
		} else if (!telefonszam.equals(other.telefonszam))
			return false;
		if (vasarloKedvezmeny != other.vasarloKedvezmeny)
			return false;
		if (vezetekNev == null) {
			if (other.vezetekNev != null)
				return false;
		} else if (!vezetekNev.equals(other.vezetekNev))
			return false;
		return true;
	}

	/**
	 * ToSting metódus a vásárlók kiiratásához.
	 */
	@Override
	public String toString() {
		return vezetekNev + " " + keresztNev;
	}

}
