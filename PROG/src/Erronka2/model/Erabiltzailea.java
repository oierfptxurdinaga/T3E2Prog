package Erronka2.model;

public class Erabiltzailea {
    private String izena;
    private String pasahitza;
    
    public Erabiltzailea() {
    }
    
    public Erabiltzailea(String izena, String pasahitza) {
        this.izena = izena;
        this.pasahitza = pasahitza;
    }
    
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