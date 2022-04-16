package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.controllers.SearchController;
import application.models.Voyage;
import com.opencsv.bean.CsvToBeanBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccueilController implements Initializable{
	@FXML private Pane contact;
	@FXML private TextField txtf_rechercher_voyage;
	@FXML private DatePicker debut_sejour;
	@FXML private DatePicker fin_sejour;
	@FXML private Text txtWarning;

	private ArrayList<Voyage> listAllVoyages;
	private ArrayList<Voyage> listVoyagesResults;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		contact.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		// get all voyages
		listAllVoyages = this.getAllVoyages();
	}

	@FXML
	protected void onSearchButtonClick(ActionEvent event) throws IOException {
		if (txtf_rechercher_voyage.getText().length() > 1) {
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/search-view.fxml"));
			Parent root = (Parent) fxmlLoader.load();

			SearchController controller = (SearchController)fxmlLoader.getController();
			listVoyagesResults = searchVoyagesResults();
			controller.setListVoyages(listVoyagesResults);
			controller.init();

			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		} else {
			displayWarning();
		}
	}

	public ArrayList<Voyage> getAllVoyages(){
		String fileName = "src/application/assets/voyages.csv";

		ArrayList<Voyage> voyages = null;
		try {
			voyages = (ArrayList<Voyage>) new CsvToBeanBuilder(new FileReader(fileName)).withSeparator(';')
					.withType(Voyage.class)
					.build()
					.parse();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//        for (Voyage v: voyages) {System.out.println(v.getVille() + " : " + v.getContreparties());}
		return voyages;
	}

	public ArrayList<Voyage> searchVoyagesResults(){
		System.out.println(this.txtf_rechercher_voyage.getText());
		if (debut_sejour.getValue() != null)	System.out.println(this.debut_sejour.getValue());
		if (fin_sejour.getValue() != null)	System.out.println(this.fin_sejour.getValue());

		// FOR DEMO: if input= "all", results if all 10000 voyages
		if (txtf_rechercher_voyage.getText().equals("all")){
			return this.listAllVoyages;
		}

		ArrayList<Voyage> results = new ArrayList<Voyage>();

		for (Voyage v: listAllVoyages){
			if ((v.getVille().contains(txtf_rechercher_voyage.getText()) || v.getContreparties().contains(txtf_rechercher_voyage.getText()))
					&& (debut_sejour.getValue() == null || !debut_sejour.getValue().isBefore(LocalDate.parse(v.getDateArrivee())) )
					&& (fin_sejour.getValue() == null || !fin_sejour.getValue().isAfter(LocalDate.parse(v.getDateDepart())) ) ){
				results.add(v);
			}
		}
		System.out.println(results.size());
		return results;

	}

	public void displayWarning(){
		txtWarning.setVisible(true);
		new Thread( new Runnable() {
			public void run()  {
				try  { Thread.sleep( 3000 ); }
				catch (InterruptedException ie)  {}
				txtWarning.setVisible(false);
			}
		} ).start();
	}

	//todo: tous les champs d'informations (logement,etc) pour la recherche
	//todo: afficher sejour 20 par 20
	//todo: deporter recherche vers SearchController

}