package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlanningResasController {

	public void goToAccueil(ActionEvent event) throws IOException {
		try {
			System.out.println("Vous êtes sur la page d'accueil");
			Parent Accueil = FXMLLoader.load(getClass().getResource("./application/Accueil.fxml"));
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
