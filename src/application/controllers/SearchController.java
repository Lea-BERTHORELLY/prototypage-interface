package application.controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private VBox tripListView = null;
    @FXML
    private ImageView map;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Node[] nodes = new Node[4];
        int activeNodeIndex = 0;

        // initialize graphics
        for (int i=0; i<nodes.length;i++){
            try{
                final int j=i;
                nodes[i] = FXMLLoader.load(Main.class.getResource("views/trip-card-view.fxml"));
                nodes[i].setStyle("-fx-border-color: lightgrey");

                // add some effect
                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-border-color: grey");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-border-color: lightgrey");
                });

                // add items
                tripListView.getChildren().add(nodes[i]);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        // initialize effects
        for (int i=0; i<nodes.length;i++){

        }

        // set map
        File file = new File("src/application/assets/map.jpg");
        Image image = new Image(file.toURI().toString());
        map.setImage(image);

    }
}
