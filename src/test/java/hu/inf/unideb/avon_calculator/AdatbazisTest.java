package hu.inf.unideb.avon_calculator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import hu.inf.unideb.avon_calculator.model.AdatbazisKeszito;
import hu.inf.unideb.avon_calculator.model.Rendeles;
import hu.inf.unideb.avon_calculator.model.RendelesDao;
import hu.inf.unideb.avon_calculator.model.Termek;
import hu.inf.unideb.avon_calculator.model.Vasarlo;
import hu.inf.unideb.avon_calculator.model.VasarloDao;

public class AdatbazisTest {
	
	@Ignore
	@BeforeClass
	public static void adatbazisInicializalas() {
		AdatbazisKeszito.adatbazisKeszites();
	}

	@Ignore
	@Test
	public void tesztVasarlokLekerdezese() {
		VasarloDao vasarloDao = new VasarloDao();
		List<Vasarlo> lekerdezVasarlok = vasarloDao.lekerdezVasarlok();
		Assert.assertEquals(1, lekerdezVasarlok.size());
		Assert.assertEquals("Zsu", lekerdezVasarlok.get(0).getKeresztNev());
		Assert.assertEquals("Tatár", lekerdezVasarlok.get(0).getVezetekNev());
		Assert.assertEquals("susanlpfan", lekerdezVasarlok.get(0).getEmail());
		Assert.assertEquals("70es", lekerdezVasarlok.get(0).getTelefonszam());
		Assert.assertEquals(25, lekerdezVasarlok.get(0).getVasarloKedvezmeny());
	}
	
	@Ignore
	@Test
	public void tesztRendeles(){
		VasarloDao vasarloDao = new VasarloDao();
		List<Vasarlo> lekerdezVasarlok = vasarloDao.lekerdezVasarlok();
		Vasarlo vasarlo = lekerdezVasarlok.get(0);
		List<Termek> vasarloiRendeles = new ArrayList<>();
		Termek termek1 = new Termek(32561, "sampika", 600, 2, 25);
		Termek termek2 = new Termek(32561, "balzsamka", 500, 3, 25);
		vasarloiRendeles.add(termek1);
		vasarloiRendeles.add(termek2);
		String kampany = "5";
		Rendeles rendeles = new Rendeles(kampany , vasarlo, vasarloiRendeles);
		RendelesDao rendelesDao = new RendelesDao();
		rendelesDao.hozzaAdRendelest(rendeles);
	}
	
}
