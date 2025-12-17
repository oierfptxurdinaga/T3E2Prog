package Erronka2.model;

public class Klasifikazioa {
    private Denboraldia[] denboraldia;
    private int posizioa;
    private Taldeak[] taldeak;
    private Partidua[] partiduak;
    private int irabaziak;
    private int berdinketak;
    private int galduak;
    private int aldekoSetak;
    private int kontrakoSetak;
    
    public Klasifikazioa() {
    }
    
    public Klasifikazioa(Denboraldia[] denboraldia, int posizioa, Taldeak[] taldeak, 
                         Partidua[] partiduak, int irabaziak, int berdinketak, 
                         int galduak, int aldekoSetak, int kontrakoSetak) {
        this.denboraldia = denboraldia;
        this.posizioa = posizioa;
        this.taldeak = taldeak;
        this.partiduak = partiduak;
        this.irabaziak = irabaziak;
        this.berdinketak = berdinketak;
        this.galduak = galduak;
        this.aldekoSetak = aldekoSetak;
        this.kontrakoSetak = kontrakoSetak;
    }
    
    public Denboraldia[] getDenboraldia() {
        return denboraldia;
    }
    
    public void setDenboraldia(Denboraldia[] denboraldia) {
        this.denboraldia = denboraldia;
    }
    
    public int getPosizioa() {
        return posizioa;
    }
    
    public void setPosizioa(int posizioa) {
        this.posizioa = posizioa;
    }
    
    public Taldeak[] getTaldeak() {
        return taldeak;
    }
    
    public void setTaldeak(Taldeak[] taldeak) {
        this.taldeak = taldeak;
    }
    
    public Partidua[] getPartiduak() {
        return partiduak;
    }
    
    public void setPartiduak(Partidua[] partiduak) {
        this.partiduak = partiduak;
    }
    
    public int getIrabaziak() {
        return irabaziak;
    }
    
    public void setIrabaziak(int irabaziak) {
        this.irabaziak = irabaziak;
    }
    
    public int getBerdinketak() {
        return berdinketak;
    }
    
    public void setBerdinketak(int berdinketak) {
        this.berdinketak = berdinketak;
    }
    
    public int getGalduak() {
        return galduak;
    }
    
    public void setGalduak(int galduak) {
        this.galduak = galduak;
    }
    
    public int getAldekoSetak() {
        return aldekoSetak;
    }
    
    public void setAldekoSetak(int aldekoSetak) {
        this.aldekoSetak = aldekoSetak;
    }
    
    public int getKontrakoSetak() {
        return kontrakoSetak;
    }
    
    public void setKontrakoSetak(int kontrakoSetak) {
        this.kontrakoSetak = kontrakoSetak;
    }
    
    @Override
    public String toString() {
        return "Klasifikazioa{" +
                "posizioa=" + posizioa +
                ", irabaziak=" + irabaziak +
                ", berdinketak=" + berdinketak +
                ", galduak=" + galduak +
                ", aldekoSetak=" + aldekoSetak +
                ", kontrakoSetak=" + kontrakoSetak +
                '}';
    }
}