package hu.inf.unideb.avon_calculator.controller;

import hu.inf.unideb.avon_calculator.model.Vasarlo;
import hu.inf.unideb.avon_calculator.model.VasarloDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * A vásárló felvétel képernyőhöz tartozó kontroller osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class VasarloFelvetelKepernyoController {

	/**
	 * A vásárló vezetéknevét bekérő mező.
	 */
	@FXML
	private TextField vnevF;
	
	/**
	 * A vásárló keresztnevét bekérő mező.
	 */
	@FXML
	private TextField knevF;
	
	/**
	 * A vásárló telefonszámát bekérő mező.
	 */
	@FXML
	private TextField telF;
	
	/**
	 * A vásárló e-mail címét bekérő mező.
	 */
	@FXML
	private TextField mailF;
	
	/**
	 * A vásárló kedvezményét bekérő mező.
	 */
	@FXML
	private TextField kedvF;

	/**
	 * Paraméternélküli konstruktor.
	 */
	public VasarloFelvetelKepernyoController() {

	}

	/**
	 * A mentés gombra kattintás hatására végrehajtódó műveleteket leíró metódus.
	 */
	@FXML
	public void menteskattra() {
		if(vnevF.getText().isEmpty() || knevF.getText().isEmpty() || telF.getText().isEmpty() || mailF.getText().isEmpty() || kedvF.getText().isEmpty()){
			figyelmeztetes("Nem adtál meg minden adatot!");
			return;
		}
		int kedvezmeny = 0;
		try {
			kedvezmeny = Integer.parseInt(kedvF.getText());
		} catch (NumberFormatException e) {
			kedvezmeny = -1;
		}
		if(kedvezmeny < 0 || kedvezmeny > 100){
			figyelmeztetes("Kedvezmény csak 0-100 közötti szám lehet!");
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
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Értesítés");
		alert.setHeaderText(null);
		alert.setContentText("Sikeres mentés");
		alert.showAndWait();
	}
	
	/**
	 * Figyelmeztető box segédmetódus.
	 * 
	 * @param szoveg Szöveg
	 */
	private void figyelmeztetes(String szoveg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Figyelmeztetés");
		alert.setHeaderText(null);
		alert.setContentText(szoveg);

		alert.showAndWait();
	}

}
