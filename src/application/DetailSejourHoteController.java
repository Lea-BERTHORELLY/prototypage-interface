package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DetailSejourHoteController {
	
	@FXML
	private Button btnValiderSejourHote;
	@FXML
	private Button btnConcept;
	
	/*
	@FXML 
	private TextField localisation, periodeDeb, periodeFin, logementAutre, serviceAutre, dureeQuotidienne, contrainte, nbVoyageur, contrepartieAutre;

	@FXML 
	private RadioButton cabane, chambre, jardinage, bricolage, cuisine, petitDej, demiPension, pensionComplete, baladeCheval, blanchissage, piscine, transfertOui, transfertNon;
	
	private String localisation1, periodeDeb1, periodeFin1, logementAutre1, serviceAutre1, dureeQuotidienne1, contrainte1, nbVoyageur1, contrepartieAutre1;
	
	*/
	public void validerSejourHote() {
		Scene scene = btnValiderSejourHote.getScene();
		try {
			
			/*
			localisation1 = localisation.getText();
			//récupérer valeur calendrier ?
			logementAutre1 = logementAutre.getText();
			serviceAutre1 = serviceAutre.getText();
			dureeQuotidienne1 = dureeQuotidienne.getText();
			contrainte1 = contrainte.getText();
			nbVoyageur1 = nbVoyageur.getText();
			contrepartieAutre1 = contrepartieAutre.getText();
			
			
			System.out.println(localisation1);
			System.out.println(logementAutre1);
			System.out.println(serviceAutre1);
			System.out.println(dureeQuotidienne1);
			System.out.println(contrainte1);
			System.out.println(nbVoyageur1);
			System.out.println(contrepartieAutre1);
			*/
			
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ListeSejourHoteBarreRecherche.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void concept() {
		Scene scene = btnConcept.getScene();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ConceptAdeona.fxml"));
			scene.setRoot(root);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}