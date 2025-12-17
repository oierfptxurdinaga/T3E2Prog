package Erronka2.model;

public class Erabiltzailea {
    private String izena;
    private String pasahitza;
    private String rola;
    
    public Erabiltzailea() {
    }
    
    public Erabiltzailea(String izena, String pasahitza, String rola) {
        this.izena = izena;
        this.pasahitza = pasahitza;
        this.rola = rola;
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
    
    public String getRola() {
        return rola;
    }
    
    public void setRola(String rola) {
        this.rola = rola;
    }
    
    @Override
    public String toString() {
        return "Erabiltzailea{" +
                "izena='" + izena + '\'' +
                ", rola='" + rola + '\'' +
                '}';
    }
}