package hu.inf.unideb.avon_calculator;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane root = new BorderPane();

	private static Main instance;

	public Main() {
		instance = this;
	}

	public static Main getInstance() {
		return instance;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AvonCalculator");

		URL menuBarUrl = getClass().getResource("view/Menu.fxml");
		MenuBar bar = FXMLLoader.load(menuBarUrl);

		URL paneOneUrl = getClass().getResource("view/Logo.fxml");
		BorderPane paneOne = FXMLLoader.load(paneOneUrl);

		root.setTop(bar);
		root.setCenter(paneOne);

		Scene scene = new Scene(root, 800, 640);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void vasarloKepernyoMutat() throws IOException {
		URL paneOneUrl = getClass().getResource("view/VasarloKepernyo.fxml");
		BorderPane paneOne = FXMLLoader.load(paneOneUrl);

		root.setCenter(paneOne);
		
	}

	public void rendelesKepernyoMutat() throws IOException {
		URL paneOneUrl = getClass().getResource("view/RendelesKepernyo.fxml");
		BorderPane paneOne = FXMLLoader.load(paneOneUrl);

		root.setCenter(paneOne);
		
	}

	public void vasarloFelvevoMutat() throws IOException {
		URL paneOneUrl = getClass().getResource("view/VasarloFelvetelKepernyo.fxml");
		BorderPane paneOne = FXMLLoader.load(paneOneUrl);

		root.setCenter(paneOne);
		
	}
	
	public void rendelesFelvevoMutat() throws IOException {
		URL paneOneUrl = getClass().getResource("view/RendelesFelvetelKepernyo.fxml");
		BorderPane paneOne = FXMLLoader.load(paneOneUrl);

		root.setCenter(paneOne);
		
	}
	
}
