package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ConceptAdeonaController {
	
	@FXML
	private Button btnProposerSejour;
	
	@FXML
	private Button btnVoirSejour;

	public void proposerSejour() {
		Scene scene = btnProposerSejour.getScene();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("DetailSejourHote.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void voirSejour() {
		Scene scene = btnVoirSejour.getScene();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ListeSejourHoteBarreRecherche.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

