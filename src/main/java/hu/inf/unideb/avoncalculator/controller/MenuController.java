package hu.inf.unideb.avoncalculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.inf.unideb.avoncalculator.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * A menühöz tartozó kontroller osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class MenuController {

	/**
     * A naplózó példánya.
     */
	private final static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	/**
	 * A vásárló képernyő mutatása.
	 */
	@FXML
	public void vasarloKepernyoMutat() {
		logger.info("A vásárlók listázázása menüpontra kattintás.");
		Main.getInstance().vasarloKepernyoMutat();
	}
	
	/**
	 * A rendelés képernyő mutatása.
	 */
	@FXML
	public void rendelesKepernyoMutat() {
		logger.info("A rendelések listázázása menüpontra kattintás.");
		Main.getInstance().rendelesKepernyoMutat();
	}

	/**
	 * A vásárló felvétel képernyő mutatása.
	 */
	@FXML 
	public void vasarloFelvevoMutat() {
		logger.info("Az új vásárló felvétele menüpontra kattintás.");
		Main.getInstance().vasarloFelvevoMutat();
	}

	/**
	 * A rendelés felvétel képernyő mutatása.
	 */
	@FXML 
	public void rendelesFelvevoMutat() {
		logger.info("Az új rendelés felvétele menüpontra kattintás.");
		Main.getInstance().rendelesFelvevoMutat();
	}
	
	/**
	 * A névjegyhez tartozó metódus.
	 */
	@FXML
	public void nevjegy() {
		logger.info("A névjegy menüpontra kattintás.");
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Névjegy");
		alert.setHeaderText(null);
		alert.setContentText("Avon Calculator 1.0 \nKészítette: Tatár Anikó");

		alert.showAndWait();
	}

}
