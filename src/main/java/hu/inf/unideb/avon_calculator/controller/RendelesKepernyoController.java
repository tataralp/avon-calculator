package hu.inf.unideb.avon_calculator.controller;

import java.util.List;

import hu.inf.unideb.avon_calculator.model.Rendeles;
import hu.inf.unideb.avon_calculator.model.RendelesDao;
import hu.inf.unideb.avon_calculator.model.RendelesKezelo;
import hu.inf.unideb.avon_calculator.model.Termek;
import hu.inf.unideb.avon_calculator.model.Vasarlo;
import hu.inf.unideb.avon_calculator.model.VasarloDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RendelesKepernyoController {

	public RendelesKepernyoController(){
	}
	
	@FXML
	private TableView<Rendeles> rendelesTableview;
	@FXML
	private TableColumn<Rendeles, String> kamp;
	@FXML
	private TableColumn<Rendeles, String> vas;
	@FXML
	private TableColumn<Rendeles, String> idop;
	@FXML
	private TableColumn<Rendeles, Integer> teljrossz;
	
	@FXML
	private TableView<Termek> termekekTableview;
	@FXML
	private TableColumn<Termek, Integer> cikksz;
	@FXML
	private TableColumn<Termek, String> nev;
	@FXML
	private TableColumn<Termek, Integer> ar;
	@FXML
	private TableColumn<Termek, Integer> dbsz;
	@FXML
	private TableColumn<Termek, Integer> kedv;
	
	private ObservableList<Rendeles> rendelesek = FXCollections.observableArrayList();
	private ObservableList<Termek> termekek = FXCollections.observableArrayList();
	
	
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

	}

	@FXML
	private Label troSz;
	@FXML
	private Label trAkedvSz;
	@FXML
	private Label trVkedvSz;
	@FXML
	private Label thaszosszSz;
	@FXML
	private Label tvaskedvSz;

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
	}
}
