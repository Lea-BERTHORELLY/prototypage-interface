package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controllers.SearchController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AccueilController implements Initializable{
	@FXML private Pane contact;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		contact.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	@FXML
	protected void onSearchButtonClick(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/search-view.fxml"));
		Parent root = (Parent) fxmlLoader.load();

		SearchController controller = (SearchController)fxmlLoader.getController();
		// to init the controller
//		controller.init();

		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
}