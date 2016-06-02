package hu.inf.unideb.avon_calculator.controller;

import hu.inf.unideb.avon_calculator.Main;
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
	 * A vásárló képernyő mutatása.
	 */
	@FXML
	public void vasarloKepernyoMutat() {
		Main.getInstance().vasarloKepernyoMutat();
	}
	
	/**
	 * A rendelés képernyő mutatása.
	 */
	@FXML
	public void rendelesKepernyoMutat() {
		Main.getInstance().rendelesKepernyoMutat();
	}

	/**
	 * A vásárló felvétel képernyő mutatása.
	 */
	@FXML 
	public void vasarloFelvevoMutat() {
		Main.getInstance().vasarloFelvevoMutat();
	}

	/**
	 * A rendelés felvétel képernyő mutatása.
	 */
	@FXML 
	public void rendelesFelvevoMutat() {
		Main.getInstance().rendelesFelvevoMutat();
	}
	
	/**
	 * A névjegyhez tartozó metódus.
	 */
	@FXML
	public void nevjegy() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Névjegy");
		alert.setHeaderText(null);
		alert.setContentText("Avon Calculator 1.0 \nKészítette: Tatár Anikó");

		alert.showAndWait();
	}

}
