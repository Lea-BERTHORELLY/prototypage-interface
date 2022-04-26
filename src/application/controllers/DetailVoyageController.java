package application.controllers;

import application.models.Voyage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class DetailVoyageController {

    private Voyage voyage;
    @FXML
    ImageView imgVoyage;
    @FXML
    Text txtTitle;
    @FXML Text txtService;
    @FXML Text txtHeures;
    @FXML Text txtNomPrenomHote;
    @FXML Text txtDescriptifHote;
    @FXML ImageView imgHote;
    @FXML
    Button btnContacter;
    @FXML Text txtLogement;
    @FXML ImageView imgLogement;
    @FXML ImageView imgContreparties;


    public void init() {
        File file = new File("src/application/assets/images/ville/" + voyage.getVille() + ".png");
        Image image = new Image(file.toURI().toString());
        imgVoyage.setImage(image);
        txtTitle.setText(voyage.getContreparties() + " à " + voyage.getVille());
        txtService.setText(voyage.getContreparties());
        txtHeures.setText(voyage.getHeure() + "h/j");

        txtLogement.setText(voyage.getType());
        File file2 = new File("src/application/assets/images/logement/" + voyage.getType() + ".png");
        Image image2 = new Image(file2.toURI().toString());
        imgLogement.setImage(image2);

        File file3 = new File("src/application/assets/images/contreparties.png");
        Image image3 = new Image(file3.toURI().toString());
        imgContreparties.setImage(image3);
    }

    public void setVoyage(Voyage voyage){
        this.voyage = voyage;
    }
    public void goToAccueil(ActionEvent event) throws IOException {
		try {
			System.out.println("Vous �tes sur la page d'accueil");
			Parent Accueil = FXMLLoader.load(getClass().getResource("/application/views/Accueil.fxml"));
			Scene AccueilScene = new Scene(Accueil);
			
			Stage settStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			settStage.setScene(AccueilScene);
			settStage.show();
		} 
		catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}
