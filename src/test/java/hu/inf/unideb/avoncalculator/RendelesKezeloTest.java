package hu.inf.unideb.avoncalculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hu.inf.unideb.avoncalculator.model.Rendeles;
import hu.inf.unideb.avoncalculator.model.RendelesKezelo;
import hu.inf.unideb.avoncalculator.model.Termek;
import hu.inf.unideb.avoncalculator.model.Vasarlo;

public class RendelesKezeloTest {

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
		assertEquals(1550.0, rendelesKezelo.teljesRendelesOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesRendelesOsszeg2() {
		Vasarlo vasarlo1 = new Vasarlo("vezetek", "kereszt", "56245", "email", 10);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(78456, "szemceruza", 950, 1, 25);
		Termek termek2 = new Termek(56456, "krém", 1500, 2, 10);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		Rendeles rendeles = new Rendeles("2016-5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(3950.0, rendelesKezelo.teljesRendelesOsszegSzamolas(rendeles), 0);
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
		assertEquals(1187.5, rendelesKezelo.teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesRendelesAvonKedvezmennyelOsszeg2() {
		Vasarlo vasarlo1 = new Vasarlo("vezetek", "kereszt", "56245", "email", 10);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(78456, "szemceruza", 950, 1, 25);
		Termek termek2 = new Termek(56456, "krém", 1500, 2, 10);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		Rendeles rendeles = new Rendeles("2016-5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(3412.5, rendelesKezelo.teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendeles), 0);
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
		assertEquals(1672.5, rendelesKezelo.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles), 0);
	}

	@Test
	public void tesztTeljesRendelesVasarloiKedvezmennyelOsszeg2() {
		Vasarlo vasarlo1 = new Vasarlo("vezetek", "kereszt", "56245", "email", 10);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(78456, "szemceruza", 950, 1, 25);
		Termek termek2 = new Termek(56456, "krém", 1500, 2, 10);
		Termek termek3 = new Termek(15456, "szempillaspirál", 1200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("2016-5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(4755, rendelesKezelo.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles), 0);
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
		assertEquals(285, rendelesKezelo.teljesHaszonOsszegSzamolas(rendeles), 0);
	}

	@Test
	public void tesztTeljesHaszonOsszeg2() {
		Vasarlo vasarlo1 = new Vasarlo("vezetek", "kereszt", "56245", "email", 10);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(78456, "szemceruza", 950, 1, 25);
		Termek termek2 = new Termek(56456, "krém", 1500, 2, 10);
		Termek termek3 = new Termek(15456, "szempillaspirál", 1200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("2016-5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(142.5, rendelesKezelo.teljesHaszonOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesHaszonOsszeg3() {
		Vasarlo vasarlo1 = new Vasarlo("vn", "knev", "2345", "email", 10);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(23456, "tusi", 1000, 1, 25);
		Termek termek2 = new Termek(23456, "sampi", 350, 3, 30);
		Termek termek3 = new Termek(23456, "sampi", 200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(360, rendelesKezelo.teljesHaszonOsszegSzamolas(rendeles), 0);
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
		assertEquals(77.5, rendelesKezelo.teljesVasaroikedvezmenyOsszegSzamolas(rendeles), 0);
	}
	
	@Test
	public void tesztTeljesVasaroikedvezmenyOsszegSzamolas2() {
		Vasarlo vasarlo1 = new Vasarlo("vezetek", "kereszt", "56245", "email", 10);
		List<Termek> vasarloiRendeles1 = new ArrayList<Termek>();
		Termek termek1 = new Termek(78456, "szemceruza", 950, 1, 25);
		Termek termek2 = new Termek(56456, "krém", 1500, 2, 10);
		Termek termek3 = new Termek(15456, "szempillaspirál", 1200, 1, 0);
		vasarloiRendeles1.add(termek1);
		vasarloiRendeles1.add(termek2);
		vasarloiRendeles1.add(termek3);
		Rendeles rendeles = new Rendeles("2016-5", vasarlo1, vasarloiRendeles1);
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		assertEquals(395, rendelesKezelo.teljesVasaroikedvezmenyOsszegSzamolas(rendeles), 0);
	}
}
