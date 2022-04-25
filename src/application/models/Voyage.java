package application.models;

import com.opencsv.bean.CsvBindByPosition;

import java.time.chrono.ChronoLocalDate;

public class Voyage {

	@CsvBindByPosition(position = 0)
    private String idVoyage;
	
	@CsvBindByPosition(position = 1)
    private String idHote;
	
	@CsvBindByPosition(position = 2)
    private String nbPersonne;
	
    @CsvBindByPosition(position = 3)
    private String ville;

    @CsvBindByPosition(position = 4)
    private String heure;

    @CsvBindByPosition(position = 5)
    private String type;

    @CsvBindByPosition(position = 6)
    private String contreparties;

    @CsvBindByPosition(position = 7)
    private String contraintes;

    @CsvBindByPosition(position = 8)
    private String services;

    @CsvBindByPosition(position = 9)
    private String transfert;

    @CsvBindByPosition(position = 10)
    private String restauration;

    @CsvBindByPosition(position = 11)
    private String dateDepart;

    @CsvBindByPosition(position = 12)
    private String dateArrivee;
    
    @CsvBindByPosition(position = 13)
    private String idVoyageur;

    //  getters, setters, toString

    public String getIdVoyage() {
        return idVoyage;
    }
    
    public String getIdHote() {
        return idHote;
    }
    
    public String getNbPersonne() {
        return nbPersonne;
    }
    
    public String getVille() {
        return ville;
    }

    public String getHeure() {
        return heure;
    }

    public String getType() {
        return type;
    }

    public String getContreparties() {
        return contreparties;
    }

    public String getContraintes() {
        return contraintes;
    }

    public String getServices() {
        return services;
    }

    public String getTransfert() {
        return transfert;
    }

    public String getRestauration() {
        return restauration;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public String getDateDepart() {
        return dateDepart;
    }
    
    public String getIdVoyageur() {
        return idVoyageur;
    }
}
