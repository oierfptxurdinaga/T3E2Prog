package Erronka2.model;

public class TaldearenKlasifikazioa {
    private Taldeak taldea;
    private int partidaJokatuak;
    private int partidaIrabaziak;
    private int partidaGalduak;
    private int puntuak;
    private int setakIrabaziak; // Nuevo: sets ganados
    private int setakGalduak;   // Nuevo: sets perdidos
    private int setDiferentzia; // Nuevo: diferencia de sets
    
    public TaldearenKlasifikazioa(Taldeak taldea) {
        this.taldea = taldea;
        this.partidaJokatuak = 0;
        this.partidaIrabaziak = 0;
        this.partidaGalduak = 0;
        this.puntuak = 0;
        this.setakIrabaziak = 0;
        this.setakGalduak = 0;
        this.setDiferentzia = 0;
    }
    
    // Getters y setters
    public Taldeak getTaldea() {
        return taldea;
    }
    
    public void setTaldea(Taldeak taldea) {
        this.taldea = taldea;
    }
    
    public int getPartidaJokatuak() {
        return partidaJokatuak;
    }
    
    public void setPartidaJokatuak(int partidaJokatuak) {
        this.partidaJokatuak = partidaJokatuak;
    }
    
    public int getPartidaIrabaziak() {
        return partidaIrabaziak;
    }
    
    public void setPartidaIrabaziak(int partidaIrabaziak) {
        this.partidaIrabaziak = partidaIrabaziak;
    }
    
    public int getPartidaGalduak() {
        return partidaGalduak;
    }
    
    public void setPartidaGalduak(int partidaGalduak) {
        this.partidaGalduak = partidaGalduak;
    }
    
    public int getPuntuak() {
        return puntuak;
    }
    
    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }
    
    public int getSetakIrabaziak() {
        return setakIrabaziak;
    }
    
    public void setSetakIrabaziak(int setakIrabaziak) {
        this.setakIrabaziak = setakIrabaziak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
    
    public int getSetakGalduak() {
        return setakGalduak;
    }
    
    public void setSetakGalduak(int setakGalduak) {
        this.setakGalduak = setakGalduak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
    
    public int getSetDiferentzia() {
        return setDiferentzia;
    }
    
    // Métodos para incrementar
    public void gehitupartidaJokatua() {
        partidaJokatuak++;
    }
    
    public void gehitupartidaIrabazia() {
        partidaIrabaziak++;
        puntuak += 3; // 3 puntos por victoria
    }
    
    public void gehitupartidaGaldua() {
        partidaGalduak++;
        // No se suman puntos
    }
    
    // Nuevos métodos para sets
    public void gehituSetakIrabaziak(int setak) {
        this.setakIrabaziak += setak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
    
    public void gehituSetakGalduak(int setak) {
        this.setakGalduak += setak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
}