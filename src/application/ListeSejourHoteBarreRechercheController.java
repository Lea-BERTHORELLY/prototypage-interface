package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ListeSejourHoteBarreRechercheController {

	@FXML
	private Button btnProposerAutreSejour;

	public void proposerAutreSejour() {
		Scene scene = btnProposerAutreSejour.getScene();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("DetailSejourHote.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
