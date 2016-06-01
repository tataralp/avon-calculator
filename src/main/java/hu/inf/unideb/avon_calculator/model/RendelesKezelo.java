package hu.inf.unideb.avon_calculator.model;


public class RendelesKezelo {

	public double teljesRendelesOsszegSzamolas (Rendeles rendeles){
		return rendeles.getVasarloiRendeles().stream().mapToDouble(r -> r.getAr() * r.getDarabszam()).sum();
	}

	public double teljesRendelesAvonKedvezmennyelOsszegSzamolas(Rendeles rendeles) {
		return rendeles.getVasarloiRendeles().stream()
				.mapToDouble(r -> r.getAr() * r.getDarabszam() * (1 - (r.getAvonKedvezmeny()/100.0)) ).sum();
	}

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
	
	public double teljesHaszonOsszegSzamolas (Rendeles rendeles){
		return this.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles) - 
				this.teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendeles);
	}
	
	public double teljesVasaroikedvezmenyOsszegSzamolas (Rendeles rendeles){
		return this.teljesRendelesOsszegSzamolas(rendeles) - 
				this.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles);
	}
	
}