package Erronka2.model;

public class Taldeak {
    private int talde_kod;
    private String izena;
    private String entrenatzailea;
    private String kokapena;
    private String zelaia;
    
    public Taldeak() {
    }
    
    public Taldeak(int talde_kod, String izena, String kokapena, String entrenatzailea, String zelaia) {
        this.talde_kod = talde_kod;
        this.izena = izena;
        this.kokapena = kokapena;
        this.entrenatzailea = entrenatzailea;
        this.zelaia = zelaia;
    }
    
    public int getTalde_kod() {
        return talde_kod;
    }
    
    public void setTalde_kod(int talde_kod) {
        this.talde_kod = talde_kod;
    }
    
    public String getIzena() {
        return izena;
    }
    
    public void setIzena(String izena) {
        this.izena = izena;
    }
    
    public String getkokapena() {
        return kokapena;
    }
    
    public void setkokapena(String kokapena) {
        this.kokapena = kokapena;
    }
    
    public String getEntrenatzailea() {
        return entrenatzailea;
    }
    
    public void setEntrenatzailea(String entrenatzailea) {
        this.entrenatzailea = entrenatzailea;
    }
    
    public String getZelaia() {
        return zelaia;
    }
    
    public void setZelaia(String zelaia) {
        this.zelaia = zelaia;
    }
    
    @Override
    public String toString() {
        return "Taldeak{" +
                "talde_kod=" + talde_kod +
                ", izena='" + izena + '\'' +
                ", kokapena='" + kokapena + '\'' +
                ", entrenatzailea='" + entrenatzailea + '\'' +
                ", zelaia='" + zelaia + '\'' +
                '}';
    }
}