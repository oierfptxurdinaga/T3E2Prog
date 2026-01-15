package Erronka2.model;

public class TaldearenKlasifikazioa {
    // Talde baten liga edo denboraldi bateko klasifikazio informazioa gordetzeko klasea

    private Taldeak taldea;             // Taldearen informazioa
    private int partidaJokatuak;         // Jokatu diren partiduen kopurua
    private int partidaIrabaziak;        // Irabazitako partiduen kopurua
    private int partidaGalduak;          // Galdu diren partiduen kopurua
    private int puntuak;                 // Taldeak lortutako puntu kopurua
    private int setakIrabaziak;          // Irabazitako set kopurua
    private int setakGalduak;            // Galdu diren set kopurua
    private int setDiferentzia;          // Seten arteko diferentzia (irabazitakoak - galduak)
    
    // Eraikitzailea, taldearekin hasi eta denak 0 hasieratzen ditu
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
    
    // Getters eta setters atributuetarako
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
    
    // Setak irabaziak aldatzean setDiferentzia eguneratzen da
    public void setSetakIrabaziak(int setakIrabaziak) {
        this.setakIrabaziak = setakIrabaziak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
    
    public int getSetakGalduak() {
        return setakGalduak;
    }
    
    // Setak galduak aldatzean setDiferentzia eguneratzen da
    public void setSetakGalduak(int setakGalduak) {
        this.setakGalduak = setakGalduak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
    
    public int getSetDiferentzia() {
        return setDiferentzia;
    }
    
    // Partida jokatu bat gehitzeko metodoa
    public void gehitupartidaJokatua() {
        partidaJokatuak++;
    }
    
    // Irabazitako partida bat gehitzeko metodoa, puntuak ere handitzen ditu
    public void gehitupartidaIrabazia() {
        partidaIrabaziak++;
        puntuak += 3; // Irabazteagatik 3 puntu ematen dira
    }
    
    // Galduko partida bat gehitzeko metodoa, punturik gehitu gabe
    public void gehitupartidaGaldua() {
        partidaGalduak++;
        // Ez dira punturik gehitzen
    }
    
    // Set irabazi kopurua handitzeko metodoa, diferentzia ere eguneratzen du
    public void gehituSetakIrabaziak(int setak) {
        this.setakIrabaziak += setak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
    
    // Set galdu kopurua handitzeko metodoa, diferentzia ere eguneratzen du
    public void gehituSetakGalduak(int setak) {
        this.setakGalduak += setak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
}
