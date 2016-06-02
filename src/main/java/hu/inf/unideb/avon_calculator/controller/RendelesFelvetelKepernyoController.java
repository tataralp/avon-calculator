package hu.inf.unideb.avon_calculator.controller;

import java.time.LocalDate;

import hu.inf.unideb.avon_calculator.model.Rendeles;
import hu.inf.unideb.avon_calculator.model.RendelesDao;
import hu.inf.unideb.avon_calculator.model.RendelesKezelo;
import hu.inf.unideb.avon_calculator.model.Termek;
import hu.inf.unideb.avon_calculator.model.Vasarlo;
import hu.inf.unideb.avon_calculator.model.VasarloDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * A rendelés felvétel képernyőhöz tartozó kontroller osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class RendelesFelvetelKepernyoController {

	/**
	 * Paraméternélküli konstruktor.
	 */
	public RendelesFelvetelKepernyoController() {

	}

	/**
	 * A vásárló kiválásztásához való box.
	 */
	@FXML
	private ComboBox<Vasarlo> vasarloValsztoBox;
	
	/**
	 * Választott Vásárló
	 */
	private Vasarlo valasztottVasarlo;

	/**
	 * Vásárlókat tartalmazó lista a boxba.
	 */
	private ObservableList<Vasarlo> comboBoxData = FXCollections.observableArrayList();
	
	/**
	 * Termékeket tartalmazó lista.
	 */
	private ObservableList<Termek> termekek = FXCollections.observableArrayList();
	
	/**
	 * A termékeket megjelenítő táblázat.
	 */
	@FXML
	private TableView<Termek> termekTableview;
	
	/**
	 * A termék cikkszámát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> cikkszF;
	
	/**
	 * A termék nevét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, String> nevF;
	
	/**
	 * A termék árát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> arF;
	
	/**
	 * A termék darabszámát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> dbszF;
	
	/**
	 * A termék Avon kedvezményét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> kedvF;

	/**
	 * A rendelés felvétel képernyő inicializáló metódusa.
	 * Amely lekéri és beállítja a megjeleníteni kívánt termékek megadott adatait a táblázatban, és a vásárlókat a választó boxba.
	 */
	@FXML
	public void initialize() {
		VasarloDao vasarloDao = new VasarloDao();
		comboBoxData.addAll(vasarloDao.lekerdezVasarlok());
		vasarloValsztoBox.setItems(comboBoxData);
		
		termekTableview.setItems(termekek);
		cikkszF.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("cikkszam"));
		nevF.setCellValueFactory(new PropertyValueFactory<Termek, String>("nev"));
		arF.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("ar"));
		dbszF.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("darabszam"));
		kedvF.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("avonKedvezmeny"));
	}

	/**
	 * A rendelés kampányát bekérő mező.
	 */
	@FXML
	private TextField kampFkitolt;
	
	/**
	 * A termék cikkszámát bekérő mező.
	 */
	@FXML
	private TextField cikkszFelvKitolt;
	
	/**
	 * A termék nevét bekérő mező.
	 */
	@FXML
	private TextField nevFelvKitolt;
	
	/**
	 * A termék árát bekérő mező.
	 */
	@FXML
	private TextField arFelvKitolt;
	
	/**
	 * A termék darabszámát bekérő mező.
	 */
	@FXML
	private TextField dbszFelvKitolt;
	
	/**
	 * A termék Avon kedvezményét bekérő mező.
	 */
	@FXML
	private TextField kedvFelvKitolt;
	
	/**
	 * Teljes rendelés összeget tartalmazó label.
	 */
	@FXML
	private Label troSzF;
	
	/**
	 * Teljes rendelés Avon kedvezménnyel összeget tartalmazó label.
	 */
	@FXML
	private Label trAkedvSzF;
	
	/**
	 * Teljes rendelés vásárlói kedvezménnyel összeget tartalmazó label.
	 */
	@FXML
	private Label trVkedvSzF;
	
	/**
	 * Teljes haszon összeget tartalmazó label.
	 */
	@FXML
	private Label thaszosszSzF;
	
	/**
	 * Teljes vásárlói kedvezmény összeget tartalmazó label.
	 */
	@FXML
	private Label tvaskedvSzF;

	/**
	 * A termék felvétel gombra kattintás hatására végrehajtódó műveleteket leíró metódus.
	 * Terméket felveszi egy listára, majd megjeleníti a táblázatban.
	 */
	@FXML
	public void menteskattraTermek() {
		if (cikkszFelvKitolt.getText().isEmpty() || nevFelvKitolt.getText().isEmpty()
				|| arFelvKitolt.getText().isEmpty() || dbszFelvKitolt.getText().isEmpty()
				|| kedvFelvKitolt.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Figyelmeztetés");
			alert.setHeaderText(null);
			alert.setContentText("Nem adtál meg minden termék adatot!");

			alert.showAndWait();
			return;
		}
		int kedvezmeny = 0;
		int cikkszam = 0;
		int darabszam = 0;
		int ar = 0;
		try {
			kedvezmeny = Integer.parseInt(kedvFelvKitolt.getText());
		} catch (NumberFormatException e) {
			kedvezmeny = -1;
		}
		try {
			cikkszam = Integer.parseInt(cikkszFelvKitolt.getText());
		} catch (NumberFormatException e) {
			cikkszam = -1;
		}
		try {
			darabszam = Integer.parseInt(dbszFelvKitolt.getText());
		} catch (NumberFormatException e) {
			darabszam = -1;
		}
		try {
			ar = Integer.parseInt(arFelvKitolt.getText());
		} catch (NumberFormatException e) {
			ar = -1;
		}
		if(kedvezmeny < 0 || kedvezmeny > 100){
			figyelmeztetes("Kedvezmény csak 0-100 közötti szám lehet!");
			return;
		}
		if(cikkszam < 0 || cikkszam > 99999){
			figyelmeztetes("Cikkszam csak 0-99999 közötti szám lehet!");
			return;
		}
		if(darabszam < 1 || darabszam > 100){
			figyelmeztetes("Darabszám csak 1-100 közötti szám lehet!");
			return;
		}
		if(ar < 0){
			figyelmeztetes("Ár csak szám lehet!");
			return;
		}

		Termek termek = new Termek();
		termek.setCikkszam(Integer.valueOf(cikkszFelvKitolt.getText()));
		termek.setNev(nevFelvKitolt.getText());
		termek.setAr(Integer.valueOf(arFelvKitolt.getText()));
		termek.setDarabszam(Integer.valueOf(dbszFelvKitolt.getText()));
		termek.setAvonKedvezmeny(Integer.valueOf(kedvFelvKitolt.getText()));
		
		termekek.add(termek);

		cikkszFelvKitolt.clear();
		nevFelvKitolt.clear();
		arFelvKitolt.clear();
		dbszFelvKitolt.clear();
		kedvFelvKitolt.clear();
		
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		Rendeles rendelesx = new Rendeles();
		rendelesx.setKampany(kampFkitolt.getText());
		rendelesx.setVasarlo(valasztottVasarlo);
		for (Termek termekx : termekek) {
			rendelesx.addTermek(termekx);
		}
		
		troSzF.setText((int)rendelesKezelo.teljesRendelesOsszegSzamolas(rendelesx)+" Ft");
		trAkedvSzF.setText((int)rendelesKezelo.teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendelesx)+" Ft");
		trVkedvSzF.setText((int)rendelesKezelo.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendelesx)+" Ft");
		thaszosszSzF.setText((int)rendelesKezelo.teljesHaszonOsszegSzamolas(rendelesx)+" Ft");
		tvaskedvSzF.setText((int)rendelesKezelo.teljesVasaroikedvezmenyOsszegSzamolas(rendelesx)+" Ft");
	}

	/**
	 * A mentés gombra kattintás hatására végrehajtódó műveleteket leíró metódus.
	 * Menti az adatbázisba a felvett rendelést, majd az oldalt üresre állítja.
	 */
	@FXML
	public void menteskattrarend() {
		if (kampFkitolt.getText().isEmpty()) {
			figyelmeztetes("Nem adtál meg kampányt!");
			return;
		}
		if (vasarloValsztoBox.getSelectionModel().getSelectedItem() == null) {
			figyelmeztetes("Nem adtál meg vásárlót!");
			return;
		}
		if (termekek.isEmpty()) {
			figyelmeztetes("Nem adtál meg terméket!");
			return;
		}
		
		RendelesDao rendelesDao = new RendelesDao();
		Rendeles rendeles = new Rendeles();
		rendeles.setKampany(kampFkitolt.getText());
		rendeles.setVasarlo(valasztottVasarlo);
		for (Termek termek : termekek) {
			rendeles.addTermek(termek);
		}
		rendeles.setIdopont(LocalDate.now());
		rendelesDao.hozzaAdRendelest(rendeles);
		
		kampFkitolt.clear();	
		termekek.clear();
		valasztottVasarlo = null;
		vasarloValsztoBox.getSelectionModel().clearSelection();
		
		troSzF.setText("0 Ft");
		trAkedvSzF.setText("0 Ft");
		trVkedvSzF.setText("0 Ft");
		thaszosszSzF.setText("0 Ft");
		tvaskedvSzF.setText("0 Ft");
		
		cikkszFelvKitolt.clear();
		nevFelvKitolt.clear();
		arFelvKitolt.clear();
		dbszFelvKitolt.clear();
		kedvFelvKitolt.clear();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Értesítés");
		alert.setHeaderText(null);
		alert.setContentText("Sikeres mentés");
		alert.showAndWait();
	}

	/**
	 * Figyelmeztető ablak segéd metódus.
	 * @param szoveg Szöveg
	 */
	private void figyelmeztetes(String szoveg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Figyelmeztetés");
		alert.setHeaderText(null);
		alert.setContentText(szoveg);

		alert.showAndWait();
	}

	/**
	 * A boxból kiválasztott vásárló mentésére szolgáló segédmetódus.
	 */
	@FXML
	public void vasValaszto() {
		valasztottVasarlo = vasarloValsztoBox.getSelectionModel().getSelectedItem();
	}

}
