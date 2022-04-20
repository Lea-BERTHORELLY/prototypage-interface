package controller;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProfilVoyageurController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int idUtilisateur = 2;
	
	@FXML Text textPrenomNom;
	@FXML Text textPays;
	@FXML Text textVille;
	@FXML Text textAPropos;
	
	
	public void readDataLineByLine()
	{
	    try {
	 
	        // Create an object of filereader
	        // class with CSV file as a parameter.
	        FileReader filereader = new FileReader("profil.csv");
	 
	        // create csvReader object passing
	        // file reader as a parameter
	        CSVReader csvReader = new CSVReader(filereader);
	        String[] nextRecord;
	 
	        // we are going to read data line by line
	        while ((nextRecord = csvReader.readNext()) != null) {
	            for (String cell : nextRecord) {
	                System.out.print(cell + "\t");
	            }
	            System.out.println();
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void modifierProfil(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/views/ModificationProfilVoyageur.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,1280,720);
		stage.setScene(scene);
		stage.show();
		
		//Controller secController = loader.getController();
	}
	
	public void miseEnPlaceProfil() {
		try {
			 
	        // Create an object of filereader
	        // class with CSV file as a parameter.
	        FileReader filereader = new FileReader("profil.csv");
	        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
	        // create csvReader object passing
	        // file reader as a parameter
	        CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
	        String[] nextRecord = null;
	        int i = 0;
	        while (i != idUtilisateur) {
	        	nextRecord = csvReader.readNext();
	        	i++;
	        }
	        textPrenomNom.setText(nextRecord[2] + " " + nextRecord[1]);
	        textPays.setText(nextRecord[4]);
	    	textVille.setText(nextRecord[3]);
	    	textAPropos.setText(nextRecord[6]);
	    	textAPropos.setWrappingWidth(350);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
