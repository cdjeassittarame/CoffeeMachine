package main.com.company.model;

public enum BoissonType {
    TEA("T", "Tea", "Thé"),
    COFFEE("C", "Coffee", "Café"),
    CHOCOLATE("H", "Chocolate", "Chocolat"),
    ORANGE("O", "Orange", "Orange");

    private String boissonTypeProtocol;

    private String boissonNameEnglish;

    private String boissonNameFrench;

    BoissonType() {
    }

    BoissonType(String protocolCode, String drinkNameEnglish, String drinkNameFrench) {
        this.boissonTypeProtocol = protocolCode;
        this.boissonNameEnglish = drinkNameEnglish;
        this.boissonNameFrench = drinkNameFrench;
    }

    public String getBoissonTypeProtocol() {
        return boissonTypeProtocol;
    }

    public void setBoissonTypeProtocol(String boissonTypeProtocol) {
        this.boissonTypeProtocol = boissonTypeProtocol;
    }

    public String getBoissonNameEnglish() {
        return boissonNameEnglish;
    }

    public String getBoissonNameFrench() {
        return boissonNameFrench;
    }
}
