package hu.inf.unideb.avon_calculator;

public class Vasarlo {

	private int id;
	private String vezetekNev;
	private String keresztNev;
	private String telefonszam;
	private String email;
	private int vKedvezmeny;

	public Vasarlo() {
		super();
	}

	public Vasarlo(String vezetekNev, String keresztNev, String telefonszam, String email, int vKedvezmeny) {
		super();
		this.vezetekNev = vezetekNev;
		this.keresztNev = keresztNev;
		this.telefonszam = telefonszam;
		this.email = email;
		this.setvKedvezmeny(vKedvezmeny);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeresztNev() {
		return keresztNev;
	}

	public void setKeresztNev(String keresztNev) {
		this.keresztNev = keresztNev;
	}

	public String getVezetekNev() {
		return vezetekNev;
	}

	public void setVezetekNev(String vezetekNev) {
		this.vezetekNev = vezetekNev;
	}

	public String getTelefonszam() {
		return telefonszam;
	}

	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getvKedvezmeny() {
		return vKedvezmeny;
	}

	public void setvKedvezmeny(int vKedvezmeny) throws IllegalArgumentException {
		if (vKedvezmeny < 0 || vKedvezmeny > 100)
			throw new IllegalArgumentException();
		this.vKedvezmeny = vKedvezmeny;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((keresztNev == null) ? 0 : keresztNev.hashCode());
		result = prime * result + ((telefonszam == null) ? 0 : telefonszam.hashCode());
		result = prime * result + vKedvezmeny;
		result = prime * result + ((vezetekNev == null) ? 0 : vezetekNev.hashCode());
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
		if (vKedvezmeny != other.vKedvezmeny)
			return false;
		if (vezetekNev == null) {
			if (other.vezetekNev != null)
				return false;
		} else if (!vezetekNev.equals(other.vezetekNev))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vasarlo: " + id + ", Nev: " + keresztNev + " " + vezetekNev + ", telsz.: " + telefonszam + ", email: "
				+ email + ", Kedvezmeny: " + vKedvezmeny;
	}

}
