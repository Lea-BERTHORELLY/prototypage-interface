package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AccueilController implements Initializable{
	@FXML private Pane contact;
	@FXML private ImageView img1,img2,img3,img4,img5;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		contact.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        Image image1 = new Image("https://www.horizon-provence.com/pont-avignon/photos/pont-saint-benezet08.jpg");
        ImageView img1 = new ImageView();
        img1.setImage(image1);
        Image image2 = new Image("https://www.rustica.fr/images/247913j-l760-h550.jpg");
        img2.setImage(image2);
        Image image3 = new Image("https://www.josera.fr/media/magefan_blog/Pferd_Ausritt_shutterstock_1883230375_Ratgeber-Headerbild_1905x1040.jpg");
        img3.setImage(image3);
        Image image4 = new Image("https://www.cabanes-de-france.com/wp-content/uploads/2018/06/clarisse-creaphotos-7.jpg");
        img4.setImage(image4);
        Image image5 = new Image("https://resize2.prod.docfr.doc-media.fr/rcrop/480,280,center-middle/img/var/doctissimo/storage/images/fr/www/famille/maison/jardinage/661232-2-fre-FR/jardinage.jpg");
        img5.setImage(image5);
	}
}