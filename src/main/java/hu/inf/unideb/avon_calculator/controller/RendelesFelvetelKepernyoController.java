package hu.inf.unideb.avon_calculator.controller;

import java.time.LocalDate;

import hu.inf.unideb.avon_calculator.model.Rendeles;
import hu.inf.unideb.avon_calculator.model.RendelesDao;
import hu.inf.unideb.avon_calculator.model.RendelesKezelo;
import hu.inf.unideb.avon_calculator.model.Termek;
import hu.inf.unideb.avon_calculator.model.TermekDao;
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

public class RendelesFelvetelKepernyoController {

	public RendelesFelvetelKepernyoController() {

	}

	@FXML
	private ComboBox<Vasarlo> vasarloValsztoBox;
	
	private Vasarlo valasztottVasarlo;

	private ObservableList<Vasarlo> comboBoxData = FXCollections.observableArrayList();
	
	private ObservableList<Termek> termekek = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Termek> termekTableview;
	@FXML
	private TableColumn<Termek, Integer> cikkszF;
	@FXML
	private TableColumn<Termek, String> nevF;
	@FXML
	private TableColumn<Termek, Integer> arF;
	@FXML
	private TableColumn<Termek, Integer> dbszF;
	@FXML
	private TableColumn<Termek, Integer> kedvF;

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

	@FXML
	private TextField kampFkitolt;
	@FXML
	private TextField cikkszFelvKitolt;
	@FXML
	private TextField nevFelvKitolt;
	@FXML
	private TextField arFelvKitolt;
	@FXML
	private TextField dbszFelvKitolt;
	@FXML
	private TextField kedvFelvKitolt;
	
	@FXML
	private Label troSzF;
	@FXML
	private Label trAkedvSzF;
	@FXML
	private Label trVkedvSzF;
	@FXML
	private Label thaszosszSzF;
	@FXML
	private Label tvaskedvSzF;


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

	@FXML
	public void menteskattrarend() {
		if (kampFkitolt.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Figyelmeztetés");
			alert.setHeaderText(null);
			alert.setContentText("Nem adtál meg kampányt!");

			alert.showAndWait();
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
	}

	@FXML
	public void vasValaszto() {
		valasztottVasarlo = vasarloValsztoBox.getSelectionModel().getSelectedItem();
	}

}
