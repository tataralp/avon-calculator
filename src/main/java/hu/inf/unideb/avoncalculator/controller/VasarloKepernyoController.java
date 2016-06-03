package hu.inf.unideb.avoncalculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.inf.unideb.avoncalculator.model.Vasarlo;
import hu.inf.unideb.avoncalculator.model.VasarloDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * A vásárló képernyőhöz tartozó kontroller osztály.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class VasarloKepernyoController {

	/**
     * A naplózó példánya.
     */
	private final static Logger logger = LoggerFactory.getLogger(VasarloKepernyoController.class);
	
	/**
	 * A vásárlókat megjelenítő táblázat.
	 */
	@FXML
	private TableView<Vasarlo> vasarloTableview;
	
	/**
	 * A vásárló vezetéknevét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Vasarlo, String> vNev;
	
	/**
	 * A vásárló keresztnevét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Vasarlo, String> kNev;
	
	/**
	 * A vásárló telefonszámát megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Vasarlo, String> tel;
	
	/**
	 * A vásárló e-mail címét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Vasarlo, String> mail;
	
	/**
	 * A vásárló kedvezményét megjelenítő oszlop.
	 */
	@FXML
	private TableColumn<Vasarlo, Integer> kedv;

	/**
	 * Vásárlókat tartalmazó lista.
	 */
	private ObservableList<Vasarlo> vasarlok = FXCollections.observableArrayList();

	/**
	 * Paraméternélküli konstruktor.
	 */
	public VasarloKepernyoController() {
	}

	/**
	 * Vásárló képernyő inicializáló metódus. 
	 * Amely lekéri és beállítja a megjeleníteni kívánt vásárlók megadott adatait a táblázatban.
	 */
	@FXML
	public void initialize() {
		VasarloDao vasarloDao = new VasarloDao();
		List<Vasarlo> lekerdezVasarlok = vasarloDao.lekerdezVasarlok();
		vasarlok.addAll(lekerdezVasarlok);
		vasarloTableview.setItems(vasarlok);
		
		vNev.setCellValueFactory(new PropertyValueFactory<Vasarlo, String>("vezetekNev"));
		kNev.setCellValueFactory(new PropertyValueFactory<Vasarlo, String>("keresztNev"));
		tel.setCellValueFactory(new PropertyValueFactory<Vasarlo, String>("telefonszam"));
		mail.setCellValueFactory(new PropertyValueFactory<Vasarlo, String>("email"));
		kedv.setCellValueFactory(new PropertyValueFactory<Vasarlo, Integer>("vasarloKedvezmeny"));
		
		logger.info("A vásárló képernyő inicializálása megtörtént.");
	}

}
