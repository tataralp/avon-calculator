package hu.inf.unideb.avon_calculator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RendelesKezeloTeszt {

	@Test
	public void tesztTeljesRendelesOsszeg() {
		Vasarlo vasarlo1 = new Vasarlo("vn", "knev", "2345", "email", 5);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(23456, "tusi", 250, 2, 20);
		Termek termek2 = new Termek(23456, "sampi", 350, 3, 20);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		Rendeles rendeles = new Rendeles("5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(1550.0, rendelesKezelo .teljesRendelesOsszegSzamolas(rendeles), 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void tesztVasaloNemJoKedvezmennyel() {
		new Vasarlo("vn", "knev", "01234", "email", -5);
	}
	
	@Test
	public void tesztTeljesRendelesAvonKedvezmennyelOsszeg() {
		Vasarlo vasarlo1 = new Vasarlo("vn", "knev", "2345", "email", 5);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(23456, "tusi", 250, 2, 20);
		Termek termek2 = new Termek(23456, "sampi", 350, 3, 25);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		Rendeles rendeles = new Rendeles("5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(1187.5, rendelesKezelo .teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesRendelesVasarloiKedvezmennyelOsszeg() {
		Vasarlo vasarlo1 = new Vasarlo("vn", "knev", "2345", "email", 5);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(23456, "tusi", 250, 2, 20);
		Termek termek2 = new Termek(23456, "sampi", 350, 3, 25);
		Termek termek3 = new Termek(23456, "sampi", 200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(1672.5, rendelesKezelo .teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesHaszonOsszeg() {
		Vasarlo vasarlo1 = new Vasarlo("vn", "knev", "2345", "email", 5);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(23456, "tusi", 250, 2, 20);
		Termek termek2 = new Termek(23456, "sampi", 350, 3, 25);
		Termek termek3 = new Termek(23456, "sampi", 200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(285, rendelesKezelo .teljesHaszonOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesVasaroikedvezmenyOsszegSzamolas() {
		Vasarlo vasarlo1 = new Vasarlo("vn", "knev", "2345", "email", 5);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(23456, "tusi", 250, 2, 20);
		Termek termek2 = new Termek(23456, "sampi", 350, 3, 25);
		Termek termek3 = new Termek(23456, "sampi", 200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(77.5, rendelesKezelo .teljesVasaroikedvezmenyOsszegSzamolas(rendeles), 0);
	}
}
