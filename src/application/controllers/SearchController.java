package application.controllers;

import application.Main;
import application.models.Voyage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchController {

    @FXML
    private VBox tripListView = null;
    @FXML
    private ImageView map;
    private ArrayList<Voyage> listVoyages;

    public void init() {

        Node[] nodes = new Node[10];

        // initialize graphics
        for (int i=0; i<nodes.length;i++){
            try{
                final int j=i;
                nodes[i] = FXMLLoader.load(Main.class.getResource("views/trip-card-view.fxml"));
                nodes[i].setStyle("-fx-border-color: lightgrey");

                // bind data
                ImageView iv = (ImageView) nodes[i].lookup("#image");
                Label titre = (Label) nodes[i].lookup("#titre");
                Label contrepartie = (Label) nodes[i].lookup("#contrepartie");
                Label logement = (Label) nodes[i].lookup("#logement");
                Label heures = (Label) nodes[i].lookup("#heures");

                File file = new File("src/application/assets/images/"+ listVoyages.get(i).getVille() +".png");
                Image image = new Image(file.toURI().toString());
                iv.setImage(image);
                titre.setText(listVoyages.get(i).getContreparties() + " à " + listVoyages.get(i).getVille());
                contrepartie.setText(listVoyages.get(i).getContreparties());
                logement.setText(listVoyages.get(i).getType());
                heures.setText(listVoyages.get(i).getHeure() + " h/j");

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

        // todo: initialize effects
        for (int i=0; i<nodes.length;i++){

        }

        // todo: bind data

        // todo: link to tripView

        // set map
        File file = new File("src/application/assets/map.jpg");
        Image image = new Image(file.toURI().toString());
        map.setImage(image);

    }

    public void setListVoyages(ArrayList<Voyage> listVoyages) {
        this.listVoyages = listVoyages;
    }

}
