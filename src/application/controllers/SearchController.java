package application.controllers;

import application.Main;
import application.models.Voyage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchController {

    @FXML private TextField txtDestination2;
    @FXML private DatePicker debut_sejour2;
    @FXML private DatePicker fin_sejour2;
    @FXML private Text txtWarning2;

    @FXML private VBox tripListView = null;
    @FXML private ImageView imgMap;
    @FXML private ScrollPane paneResults;
    @FXML private Text txtResults;

    private ArrayList<Voyage> listAllVoyages;
    private ArrayList<Voyage> listVoyagesResults2;

    public void init() {

        setMap();
        handleResultsQty();
        initialiseResultsPane();

        // todo: initialize map effects
//        for (int i=0; i<nodes.length;i++){ }
    }

    public void updateUI(){
        handleResultsQty();
        initialiseResultsPane();
    }

    public void setMap(){
        File file = new File("src/application/assets/map.png");
        Image image = new Image(file.toURI().toString());
        imgMap.setImage(image);
    }

    public void handleResultsQty(){
        // gère le nombre de résultats
        if (listVoyagesResults2.size() == 0) txtResults.setText("Désolé, nous n'avons trouvé aucun résultat...");
        else txtResults.setText(listVoyagesResults2.size() + " séjours peuvent vous satisfaire");
        imgMap.setVisible(listVoyagesResults2.size() != 0);
        paneResults.setVisible(listVoyagesResults2.size() != 0);
    }

    public void initialiseResultsPane(){
        tripListView.getChildren().clear();
        if (listVoyagesResults2.size() > 0){
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

                    File file = new File("src/application/assets/images/"+ listVoyagesResults2.get(i).getVille() +".png");
                    Image image = new Image(file.toURI().toString());
                    iv.setImage(image);
                    titre.setText(listVoyagesResults2.get(i).getContreparties() + " à " + listVoyagesResults2.get(i).getVille());
                    contrepartie.setText(listVoyagesResults2.get(i).getContreparties());
                    logement.setText(listVoyagesResults2.get(i).getType());
                    heures.setText(listVoyagesResults2.get(i).getHeure() + " h/j");

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

    public void setListVoyagesResults(ArrayList<Voyage> listVoyagesResults2) {
        this.listVoyagesResults2 = listVoyagesResults2;
    }

    public void setListAllVoyages(ArrayList<Voyage> listAllVoyages) {
        this.listAllVoyages = listAllVoyages;
    }

    public void setTxtDestination2(TextField txtDestination) {
        this.txtDestination2.setText(txtDestination.getText());
    }

    public void setDebut_sejour2(DatePicker debut_sejour2) {
        this.debut_sejour2.setValue(debut_sejour2.getValue());
    }

    public void setFin_sejour2(DatePicker fin_sejour2) {
        this.fin_sejour2.setValue(fin_sejour2.getValue());
    }

    @FXML
    protected void onSearchButtonClick2(ActionEvent event) throws IOException {
        if (txtDestination2.getText().length() > 1) {

            listVoyagesResults2 = searchVoyagesResults2();
            setListVoyagesResults(listVoyagesResults2);
            updateUI();

        } else {
            displayWarning();
        }
    }

    public ArrayList<Voyage> searchVoyagesResults2(){
        System.out.println(this.txtDestination2.getText());
        if (debut_sejour2.getValue() != null)	System.out.println(this.debut_sejour2.getValue());
        if (fin_sejour2.getValue() != null)	System.out.println(this.fin_sejour2.getValue());

        // FOR DEMO: if input= "all", results if all 10000 voyages
        if (txtDestination2.getText().equals("all")){
            return this.listAllVoyages;
        }

        ArrayList<Voyage> results = new ArrayList<Voyage>();

        for (Voyage v: listAllVoyages){
            if ((v.getVille().contains(txtDestination2.getText()) || v.getContreparties().contains(txtDestination2.getText()))
                    && (debut_sejour2.getValue() == null || !debut_sejour2.getValue().isBefore(LocalDate.parse(v.getDateArrivee())) )
                    && (fin_sejour2.getValue() == null || !fin_sejour2.getValue().isAfter(LocalDate.parse(v.getDateDepart())) ) ){
                results.add(v);
            }
        }
        System.out.println(results.size());
        return results;
    }

    public void displayWarning(){
        txtWarning2.setVisible(true);
        new Thread( new Runnable() {
            public void run()  {
                try  { Thread.sleep( 3000 ); }
                catch (InterruptedException ie)  {}
                txtWarning2.setVisible(false);
            }
        } ).start();
    }
}
