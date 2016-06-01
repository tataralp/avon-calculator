package hu.inf.unideb.avon_calculator.controller;

import hu.inf.unideb.avon_calculator.model.Vasarlo;
import hu.inf.unideb.avon_calculator.model.VasarloDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class VasarloFelvetelKepernyoController {

	@FXML
	private TextField vnevF;
	@FXML
	private TextField knevF;
	@FXML
	private TextField telF;
	@FXML
	private TextField mailF;
	@FXML
	private TextField kedvF;

	public VasarloFelvetelKepernyoController() {

	}

	@FXML
	public void menteskattra() {
		if(vnevF.getText().isEmpty() || knevF.getText().isEmpty() || telF.getText().isEmpty() || mailF.getText().isEmpty() || kedvF.getText().isEmpty()){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Figyelmeztetés");
			alert.setHeaderText(null);
			alert.setContentText("Nem adtál meg minden adatot!");

			alert.showAndWait();
			return;
		}
		VasarloDao vasarloDao = new VasarloDao();
		Vasarlo vasarlo = new Vasarlo();
		vasarlo.setVezetekNev(vnevF.getText());
		vasarlo.setKeresztNev(knevF.getText());
		vasarlo.setTelefonszam(telF.getText());
		vasarlo.setEmail(mailF.getText());
		vasarlo.setVasarloKedvezmeny(Integer.valueOf(kedvF.getText()));
		
		vasarloDao.hozzaAdVasarlot(vasarlo);
		
		vnevF.clear();
		knevF.clear();
		telF.clear();
		mailF.clear();
		kedvF.clear();
	}

}
