package hu.inf.unideb.avon_calculator.controller;

import java.util.List;

import hu.inf.unideb.avon_calculator.model.Vasarlo;
import hu.inf.unideb.avon_calculator.model.VasarloDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VasarloKepernyoController {

	@FXML
	private TableView<Vasarlo> vasarloTableview;
	@FXML
	private TableColumn<Vasarlo, String> vNev;
	@FXML
	private TableColumn<Vasarlo, String> kNev;
	@FXML
	private TableColumn<Vasarlo, String> tel;
	@FXML
	private TableColumn<Vasarlo, String> mail;
	@FXML
	private TableColumn<Vasarlo, Integer> kedv;

	private ObservableList<Vasarlo> vasarlok = FXCollections.observableArrayList();

	public VasarloKepernyoController() {
	}

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
	}

}
