package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DetailSejourHoteController {
	
	@FXML
	private Button btnValiderSejourHote;

	public void validerSejourHote() {
		Scene scene = btnValiderSejourHote.getScene();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ListeSejourHoteBarreRecherche.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

