package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class PlanningController implements Initializable{
	@FXML Pane planning;
	@FXML Label lundi,mardi,mercredi,jeudi,vendredi,samedi,dimanche;
	@FXML GridPane planningCases;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		planning.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		//LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		lundi.setTextAlignment(TextAlignment.CENTER);
		mardi.setTextAlignment(TextAlignment.CENTER);
		mercredi.setTextAlignment(TextAlignment.CENTER);
		jeudi.setTextAlignment(TextAlignment.CENTER);
		vendredi.setTextAlignment(TextAlignment.CENTER);
		samedi.setTextAlignment(TextAlignment.CENTER);
		dimanche.setTextAlignment(TextAlignment.CENTER);
		Button bouton = new Button("test");
		planningCases.add(bouton, 0, 0);
		
	}

}
