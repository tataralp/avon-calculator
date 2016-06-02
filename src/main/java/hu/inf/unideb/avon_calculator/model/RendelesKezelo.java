package hu.inf.unideb.avon_calculator.model;

/**
 * A rendelések kezelését végző osztály. (Rendelésekkel kapcsolatos műveleteket tartalmazó osztály.)
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class RendelesKezelo {

	/**
	 * A rendelésben lévő termékek teljes árának összegét számoló metódus.
	 * 
	 * @param rendeles Rendelés
	 * @return Teljes rendelés összeg
	 */
	public double teljesRendelesOsszegSzamolas (Rendeles rendeles){
		return rendeles.getVasarloiRendeles().stream().mapToDouble(r -> r.getAr() * r.getDarabszam()).sum();
	}

	/**
	 * A rendelésben lévő termékek Avon kedvezménnyel csökkentett árának összegét számoló metódus. 
	 * (Tanácsadó által az Avonnak fizetendő rész.)
	 * 
	 * @param rendeles Rendelés
	 * @return Teljes rendelés összeg Avon kedvezménnyel
	 */
	public double teljesRendelesAvonKedvezmennyelOsszegSzamolas(Rendeles rendeles) {
		return rendeles.getVasarloiRendeles().stream()
				.mapToDouble(r -> r.getAr() * r.getDarabszam() * (1 - (r.getAvonKedvezmeny()/100.0)) ).sum();
	}

	/**
	 * A rendelésben lévő termékek vásárló kedvezményével csökkentett árának összegét számoló metódus. 
	 * (A vevő/vásárló által fizetendő összeg.)
	 * 
	 * @param rendeles Rendelés
	 * @return Teljes rendelés összeg vásárló kedvezménnyel
	 */
	public double teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(Rendeles rendeles) {
		Double eredmeny = 0.0;
		for (Termek termek : rendeles.getVasarloiRendeles()) {
			if(termek.getAvonKedvezmeny() >= rendeles.getVasarlo().getVasarloKedvezmeny()){
				eredmeny += (1 - (rendeles.getVasarlo().getVasarloKedvezmeny()/100.0)) * 
						termek.getAr() * termek.getDarabszam();
			} else {
				eredmeny += (1 - (termek.getAvonKedvezmeny()/100.0)) * 
						termek.getAr() * termek.getDarabszam();
			}
		}
		return eredmeny;
	}
	
	/**
	 * A rendelés vásárló által fizetendő ára és a tanácsadó által Avonnak fizetendő összeg közötti különbség. A haszon értéke.
	 * 
	 * @param rendeles Rendelés
	 * @return Teljes haszon összeg
	 */
	public double teljesHaszonOsszegSzamolas (Rendeles rendeles){
		return this.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles) - 
				this.teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendeles);
	}
	
	/**
	 * A várlói kedvezmény miatt a vásárló által megtakarított összeg számolása a rendelésből.
	 * 
	 * @param rendeles Rendelés
	 * @return Teljes vasarlói kedvezmény összeg
	 */
	public double teljesVasaroikedvezmenyOsszegSzamolas (Rendeles rendeles){
		return this.teljesRendelesOsszegSzamolas(rendeles) - 
				this.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles);
	}
	
}