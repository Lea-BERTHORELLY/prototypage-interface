package application.controllers;

import application.Main;
import application.models.Voyage;
import com.opencsv.bean.CsvToBeanBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private VBox tripListView = null;
    @FXML
    private ImageView map;

    private List<Voyage> listVoyages;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // bind data voyages
        listVoyages = this.getAllVoyages();

        Node[] nodes = new Node[20];
        int activeNodeIndex = 0;

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

    public List<Voyage> getAllVoyages(){
        String fileName = "src/application/assets/voyages.csv";

        List<Voyage> voyages = null;
        try {
            voyages = new CsvToBeanBuilder(new FileReader(fileName)).withSeparator(';')
                    .withType(Voyage.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        for (Voyage v: voyages) {System.out.println(v.getVille() + " : " + v.getContreparties());}
        return voyages;
    }
}
