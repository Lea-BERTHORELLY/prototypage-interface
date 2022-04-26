package application.controllers;

import java.io.IOException;

import application.models.ConnexionParam;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Connexion {
	
	@FXML
	private Button accueil, valider;
	@FXML
	private RadioButton hote, voyageur;
	@FXML
	private TextField id;
	
	private String typeConnexion;
	
	public void accueil() {
		Scene scene = accueil.getScene();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../Accueil.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void valider() {
		try {
			if(hote.isSelected()) {
				System.out.println("hote selectionné");
				typeConnexion="Hote";
				
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../views/ConceptAdeona.fxml"));
				Scene scene = valider.getScene();
				scene.setRoot(root);
			}
			else {
				typeConnexion="Voyageur";
				ConnexionParam param = ConnexionParam.getInstance();
		        param.setConnexion(id.getText(),typeConnexion);
		        
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("../views/search-view.fxml"));
				Scene scene = valider.getScene();
				scene.setRoot(root);
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}

