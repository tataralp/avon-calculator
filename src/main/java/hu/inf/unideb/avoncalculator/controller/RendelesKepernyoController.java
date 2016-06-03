package hu.inf.unideb.avoncalculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.inf.unideb.avoncalculator.model.Rendeles;
import hu.inf.unideb.avoncalculator.model.RendelesDao;
import hu.inf.unideb.avoncalculator.model.RendelesKezelo;
import hu.inf.unideb.avoncalculator.model.Termek;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * A rendelés képernyőhöz tartozó kontroller osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class RendelesKepernyoController {

	/**
     * A naplózó példánya.
     */
	private final static Logger logger = LoggerFactory.getLogger(RendelesKepernyoController.class);
	
	/**
	 * Paraméternélküli konstruktor.
	 */
	public RendelesKepernyoController(){
	}
	
	/**
	 * A rendeléseket megjelenítő táblázat.
	 */
	@FXML
	private TableView<Rendeles> rendelesTableview;
	
	/**
	 * A rendelés kampányát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Rendeles, String> kamp;
	
	/**
	 * A rendelés vásárlóját megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Rendeles, String> vas;
	
	/**
	 * A rendelés időpontját megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Rendeles, String> idop;
	
	/**
	 * A termékeket megjelenítő táblázat.
	 */
	@FXML
	private TableView<Termek> termekekTableview;
	
	/**
	 * A termék cikkszámát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> cikksz;
	
	/**
	 * A termék nevét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, String> nev;
	
	/**
	 * A termék árát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> ar;
	
	/**
	 * A termék darabszámát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> dbsz;
	
	/**
	 * A termék Avon kedvezményét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Termek, Integer> kedv;
	
	/**
	 * Rendeléseket tartalmazó lista.
	 */
	private ObservableList<Rendeles> rendelesek = FXCollections.observableArrayList();
	
	/**
	 * Termékeket tartalmazó lista.
	 */
	private ObservableList<Termek> termekek = FXCollections.observableArrayList();
	
	/**
	 * A rendelés képernyő inicializáló metódusa.
	 * Amely lekéri és beállítja a megjeleníteni kívánt rendelések (és a hozzájuk tartozó termékek) megadott adatait a táblázatokban.
	 */
	@FXML
	public void initialize() {
		RendelesDao rendelesDao = new RendelesDao();
		rendelesek.addAll(rendelesDao.lekerdezRendelesek());
		rendelesTableview.setItems(rendelesek);
		
		kamp.setCellValueFactory(new PropertyValueFactory<Rendeles, String>("kampany"));
		vas.setCellValueFactory(new PropertyValueFactory<Rendeles, String>("vasarlo"));
		idop.setCellValueFactory(new PropertyValueFactory<Rendeles, String>("idopont"));
		
		termekekTableview.setItems(termekek);
		cikksz.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("cikkszam"));
		nev.setCellValueFactory(new PropertyValueFactory<Termek, String>("nev"));
		ar.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("ar"));
		dbsz.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("darabszam"));
		kedv.setCellValueFactory(new PropertyValueFactory<Termek, Integer>("avonKedvezmeny"));

		logger.info("A rendelés képernyő inicializálása megtörtént.");
	}

	/**
	 * Teljes rendelés összeget tartalmazó label.
	 */
	@FXML
	private Label troSz;
	
	/**
	 * Teljes rendelés Avon kedvezménnyel összeget tartalmazó label.
	 */
	@FXML
	private Label trAkedvSz;
	
	/**
	 * Teljes rendelés vásárlói kedvezménnyel összeget tartalmazó label.
	 */
	@FXML
	private Label trVkedvSz;
	
	/**
	 * Teljes haszon összeget tartalmazó label.
	 */
	@FXML
	private Label thaszosszSz;
	
	/**
	 * Teljes vásárlói kedvezmény összeget tartalmazó label.
	 */
	@FXML
	private Label tvaskedvSz;

	/**
	 * A rendelésre való kattintás hatására végrehajtandó műveleteket tartalmazó metódus. 
	 * (A termékek és a számolások megjelenítéséhez.)
	 */
	@FXML public void kattraTermekek() {
		Rendeles rendeles = rendelesTableview.getSelectionModel().getSelectedItem();
		termekek.clear();
		termekek.addAll(rendeles.getVasarloiRendeles());
		
		RendelesKezelo rendelesKezelo = new RendelesKezelo();
		troSz.setText((int)rendelesKezelo.teljesRendelesOsszegSzamolas(rendeles)+" Ft");
		trAkedvSz.setText((int)rendelesKezelo.teljesRendelesAvonKedvezmennyelOsszegSzamolas(rendeles)+" Ft");
		trVkedvSz.setText((int)rendelesKezelo.teljesRendelesVasarloiKedvezmennyelOsszegSzamolas(rendeles)+" Ft");
		thaszosszSz.setText((int)rendelesKezelo.teljesHaszonOsszegSzamolas(rendeles)+" Ft");
		tvaskedvSz.setText((int)rendelesKezelo.teljesVasaroikedvezmenyOsszegSzamolas(rendeles)+" Ft");
		
		logger.info("A rendeléshez tartozó termék(ek) megjelenítésre került(ek).");
	}
}
