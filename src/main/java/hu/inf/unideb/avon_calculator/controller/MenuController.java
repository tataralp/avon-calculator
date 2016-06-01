package hu.inf.unideb.avon_calculator.controller;

import java.io.IOException;

import hu.inf.unideb.avon_calculator.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MenuController {

	@FXML
	public void vasarloKepernyoMutat() throws IOException {
		Main.getInstance().vasarloKepernyoMutat();
	}
	
	@FXML
	public void rendelesKepernyoMutat() throws IOException {
		Main.getInstance().rendelesKepernyoMutat();
	}

	@FXML public void vasarloFelvevoMutat() throws IOException {
		Main.getInstance().vasarloFelvevoMutat();
	}

	@FXML
	public void nevjegy() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Névjegy");
		alert.setHeaderText(null);
		alert.setContentText("Avon Calculator 1.0 \nKészítette: Tatár Anikó");

		alert.showAndWait();
	}

	@FXML public void rendelesFelvevoMutat() throws IOException {
		Main.getInstance().rendelesFelvevoMutat();
	}

}
