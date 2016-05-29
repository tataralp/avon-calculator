package hu.inf.unideb.avon_calculator;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdatbazisTeszt {
	
	@BeforeClass
	public static void adatbazisInicializalas() {
		AdatbazisKeszito.adatbazisKeszites();
	}

	@Test
	public void tesztVasarlokLekerdezese() {
		VasarloDao vasarloDao = new VasarloDao();
		List<Vasarlo> lekerdezVasarlok = vasarloDao.lekerdezVasarlok();
		Assert.assertEquals(1, lekerdezVasarlok.size());
		Assert.assertEquals("Zsu", lekerdezVasarlok.get(0).getKeresztNev());
		Assert.assertEquals("Tatár", lekerdezVasarlok.get(0).getVezetekNev());
		Assert.assertEquals("susanlpfan", lekerdezVasarlok.get(0).getEmail());
		Assert.assertEquals("70es", lekerdezVasarlok.get(0).getTelefonszam());
		Assert.assertEquals(25, lekerdezVasarlok.get(0).getvKedvezmeny());
	}
}
