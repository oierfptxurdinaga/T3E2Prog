package Erronka2.model;

public class Rola {
    private Erabiltzailea erabiltzailea;
    private String rola;
    
    public Rola() {
    }
    
    public Rola(Erabiltzailea erabiltzailea, String rola) {
        this.erabiltzailea = erabiltzailea;
        this.rola = rola;
    }
    
    public Erabiltzailea getErabiltzailea() {
        return erabiltzailea;
    }
    
    public void setErabiltzailea(Erabiltzailea erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }
    
    public String getRola() {
        return rola;
    }
    
    public void setRola(String rola) {
        this.rola = rola;
    }
    
    @Override
    public String toString() {
        return "Rola{" +
                "erabiltzailea=" + erabiltzailea +
                ", rola='" + rola + '\'' +
                '}';
    }
}