package main.com.company.model;

public class Boisson {

    private BoissonType type;
    private int nbSucre;
    private String touillette;
    private boolean extraHot;
    private double prix;
    private String messageOrdre;


    public Boisson() {
    }

    public Boisson(BoissonType type, int nbSucre, String touillette, double prix, String messageOrdre) {
        this.type = type;
        this.nbSucre = nbSucre;
        this.touillette = touillette;
        this.prix = prix;
        this.messageOrdre = messageOrdre;
    }

    public Boisson(BoissonType type, int nbSucre, String touillette, boolean extraHot, double prix, String messageOrdre) {
        this.type = type;
        this.nbSucre = nbSucre;
        this.touillette = touillette;
        this.extraHot = extraHot;
        this.prix = prix;
        this.messageOrdre = messageOrdre;
    }

    public BoissonType getType() {
        return type;
    }

    public void setType(BoissonType type) {
        this.type = type;
    }

    public int getNbSucre() {
        return nbSucre;
    }

    public void setNbSucre(int nbSucre) {
        this.nbSucre = nbSucre;
    }

    public boolean isExtraHot() {
        return extraHot;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getMessageOrdre() {
        return messageOrdre;
    }

    public void setMessageOrdre(String messageOrdre) {
        this.messageOrdre = messageOrdre;
    }

    public String getTouillette() {
        return touillette;
    }

    public void setTouillette(boolean touillette) {
        if (touillette){
            this.touillette = "1";
        }else{
            this.touillette = "0";
        }


    }
}
