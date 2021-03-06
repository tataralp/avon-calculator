package hu.inf.unideb.avoncalculator;

import java.io.IOException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A főprogram.
 * 
 * @since 1.0
 * @author Tatár Anikó
 *
 */
public class Main extends Application {

	/**
	 * A naplózó példánya.
	 */
	private final static Logger logger = LoggerFactory.getLogger(Main.class);

	/**
	 * A JavaFX fő stage-e.
	 */
	private Stage primaryStage;

	/**
	 * A program border pane-je. (Keret.) Felül a menü, alul pedig az aktuális
	 * képernyő.
	 */
	private BorderPane root = new BorderPane();

	/**
	 * A főprogram statikus példánya.
	 */
	// csak egyet akarunk belőle
	private static Main instance;

	/**
	 * Main publikus konstruktorja. Nem készít új példányt, csak az aktuálisat
	 * állítja be az instance-ba. Egy példány lehessen.
	 * 
	 * @throws UnsupportedOperationException Exception dobás, ha többször akarnák példányosítani a programot.
	 */
	public Main() {
		super();
		if (instance != null) {
			logger.error("A main osztály singleton de mégis többször lett meghívva a konstruktor!");
			throw new UnsupportedOperationException(
					getClass() + " osztály singleton de mégis többször lett meghívva a konstruktor");
		}
		instance = this;
	}

	/**
	 * Lekéri a főprogramot.
	 * 
	 * @return Main
	 */
	public static Main getInstance() {
		return instance;
	}

	/**
	 * A JavaFX belépési pontja.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("AvonCalculator");

			URL menuBarUrl = getClass().getResource("view/Menu.fxml");
			MenuBar bar;
			bar = FXMLLoader.load(menuBarUrl);

			URL paneOneUrl = getClass().getResource("view/Logo.fxml");
			BorderPane paneOne = FXMLLoader.load(paneOneUrl);

			root.setTop(bar);
			root.setCenter(paneOne);

			Scene scene = new Scene(root, 800, 640);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			logger.error("Hiba történt az induláskor: " + e.getMessage());
		}
	}

	/**
	 * A program belépési pontja. Indítja a JavaFX-et.
	 * 
	 * @param args
	 *            Alkalmazás paramétere
	 */
	public static void main(String[] args) {
		logger.info("Az Avon Calculator fut.");
		launch(args);
	}

	/**
	 * A vásárló képernyő betöltését végző metódus.
	 */
	public void vasarloKepernyoMutat() {
		try {
			URL paneOneUrl = getClass().getResource("view/VasarloKepernyo.fxml");
			BorderPane paneOne;
			paneOne = FXMLLoader.load(paneOneUrl);

			root.setCenter(paneOne);
		} catch (IOException e) {
			logger.error("A vásárló képernyő betöltése nem sikerült!" + e.getMessage());
		}
	}

	/**
	 * A rendelés képernyő betöltését végző metódus.
	 */
	public void rendelesKepernyoMutat() {
		try {
			URL paneOneUrl = getClass().getResource("view/RendelesKepernyo.fxml");
			BorderPane paneOne;
			paneOne = FXMLLoader.load(paneOneUrl);

			root.setCenter(paneOne);
		} catch (IOException e) {
			logger.error("A rendelés képernyő betöltése nem sikerült!" + e.getMessage());
		}
	}

	/**
	 * A vásárló felvétel képernyő betöltését végző metódus.
	 */
	public void vasarloFelvevoMutat() {
		try {
			URL paneOneUrl = getClass().getResource("view/VasarloFelvetelKepernyo.fxml");
			BorderPane paneOne;
			paneOne = FXMLLoader.load(paneOneUrl);

			root.setCenter(paneOne);
		} catch (IOException e) {
			logger.error("A vásárló felvétel képernyő betöltése nem sikerült!" + e.getMessage());
		}
	}

	/**
	 * A rendelés felvétel képernyő betöltését végző metódus.
	 */
	public void rendelesFelvevoMutat() {
		try {
			URL paneOneUrl = getClass().getResource("view/RendelesFelvetelKepernyo.fxml");
			BorderPane paneOne;
			paneOne = FXMLLoader.load(paneOneUrl);

			root.setCenter(paneOne);
		} catch (IOException e) {
			logger.error("A rendelés felvétel képernyő betöltése nem sikerült!" + e.getMessage());
		}
	}

}
