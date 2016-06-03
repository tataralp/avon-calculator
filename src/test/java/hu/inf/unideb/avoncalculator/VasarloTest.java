package hu.inf.unideb.avoncalculator;

import org.junit.Test;

import hu.inf.unideb.avoncalculator.model.Vasarlo;

public class VasarloTest {

	@Test(expected = IllegalArgumentException.class)
	public void tesztVasarloNemJoKedvezmennyel() {
		new Vasarlo("vn", "knev", "01234", "email", -5);
	}
}
