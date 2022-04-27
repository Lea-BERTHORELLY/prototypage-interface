package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class PlanningResasController implements Initializable {
	
	@FXML DatePicker dateResa;
	
	 static ArrayList<String> voyage = new ArrayList<String>();
	 static ArrayList<ArrayList<String>> listeVoyages = new ArrayList<ArrayList<String>>();
	
	public static void LectureVoyagesHote() throws FileNotFoundException {
		File getCSVFiles = new File("application/voyages.csv");
        Scanner sc = new Scanner(getCSVFiles);
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
        	voyage.add(sc.next());
            System.out.print(sc.next() + " | ");
        }
        if(voyage.get(11)=="21") {
        	listeVoyages.add(voyage);
        }
        
        sc.close();
	}
	

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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			LectureVoyagesHote();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			for(int i=0;i<listeVoyages.size();i++) {
				System.out.println(listeVoyages.get(i).get(0));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
