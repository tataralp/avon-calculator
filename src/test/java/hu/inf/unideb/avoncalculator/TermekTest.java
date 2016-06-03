package hu.inf.unideb.avoncalculator;

import org.junit.Test;

import hu.inf.unideb.avoncalculator.model.Termek;

public class TermekTest {
	@Test(expected = IllegalArgumentException.class)
	public void tesztTermekNemJoCikkszammal() {
		new Termek(100000, "tusi", 250, 2, 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tesztTermekNemJoArral() {
		new Termek(23456, "tusi", -250, 2, 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tesztTermekNemJoDarabszammal() {
		new Termek(23456, "tusi", 250, 0, 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tesztTermekNemJoKedvezmennyel() {
		new Termek(23456, "tusi", 250, 2, 200);
	}
}
