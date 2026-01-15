package Erronka2.model;

public class Erabiltzailea {
    // Erabiltzaile baten oinarrizko informazioa gordetzen duen klasea

    private String izena;       // Erabiltzailearen izena (erabiltzaile-izena)
    private String pasahitza;   // Erabiltzailearen pasahitza

    // Eraikitzaile hutsak, objetua sortzeko erabil daiteke hasierarik gabe
    public Erabiltzailea() {
    }

    // Eraikitzaile parametrizatuak, erabiltzailearen izena eta pasahitza ezartzeko
    public Erabiltzailea(String izena, String pasahitza) {
        this.izena = izena;
        this.pasahitza = pasahitza;
    }

    // Getters eta setters — atributuak irakurtzeko eta aldatzeko
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }
}
