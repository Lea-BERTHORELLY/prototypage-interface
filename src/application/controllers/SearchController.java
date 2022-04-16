package application.controllers;

import application.Main;
import application.models.Voyage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SearchController {

    @FXML
    private VBox tripListView = null;
    @FXML
    private ImageView imgMap;
    @FXML
    private ScrollPane paneResults;
    @FXML
    private Text txtResults;
    private ArrayList<Voyage> listVoyages;

    public void init() {

        setMap();
        handleResultsQty();
        initialiseResultsPane();

        // todo: initialize effects
//        for (int i=0; i<nodes.length;i++){
//
//        }

        // todo: bind data

        // todo: link to tripView


    }

    public void setMap(){
        File file = new File("src/application/assets/map.png");
        Image image = new Image(file.toURI().toString());
        imgMap.setImage(image);
    }

    public void handleResultsQty(){
        // gère le nombre de résultats
        if (listVoyages.size() == 0) txtResults.setText("Désolé, nous n'avons trouvé aucun résultat...");
        else txtResults.setText(listVoyages.size() + " séjours peuvent vous satisfaire.");
        imgMap.setVisible(listVoyages.size() != 0);
        paneResults.setVisible(listVoyages.size() != 0);
    }

    public void initialiseResultsPane(){
        if (listVoyages.size() > 0){
            Node[] nodes = new Node[20];

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
        }

    }

    public void setListVoyages(ArrayList<Voyage> listVoyages) {
        this.listVoyages = listVoyages;
    }
}
