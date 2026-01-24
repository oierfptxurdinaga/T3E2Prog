package Erronka2.model;

/**
 * Talde baten liga edo denboraldi bateko klasifikazio informazioa gordetzeko klasea.
 * Taldearen partidu jokatuak, irabaziak, galduak, puntuak eta set kopuruak mantentzen ditu.
 */
public class TaldearenKlasifikazioa {
    /** Taldearen informazioa */
    private Taldeak taldea;

    /** Jokatu diren partiduen kopurua */
    private int partidaJokatuak;

    /** Irabazitako partiduen kopurua */
    private int partidaIrabaziak;

    /** Galdu diren partiduen kopurua */
    private int partidaGalduak;

    /** Taldeak lortutako puntu kopurua */
    private int puntuak;

    /** Irabazitako set kopurua */
    private int setakIrabaziak;

    /** Galdu diren set kopurua */
    private int setakGalduak;

    /** Seten arteko diferentzia (irabazitakoak - galduak) */
    private int setDiferentzia;

    /**
     * Eraikitzailea, taldearekin hasi eta puntuazio guztiak 0 hasieratzen ditu.
     * @param taldea Taldearen informazioa
     */
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

    /** @return Taldearen informazioa */
    public Taldeak getTaldea() {
        return taldea;
    }

    /** @param taldea Taldearen informazioa ezartzeko */
    public void setTaldea(Taldeak taldea) {
        this.taldea = taldea;
    }

    /** @return Jokatu diren partiduen kopurua */
    public int getPartidaJokatuak() {
        return partidaJokatuak;
    }

    /** @param partidaJokatuak Jokatu diren partiduen kopurua ezartzeko */
    public void setPartidaJokatuak(int partidaJokatuak) {
        this.partidaJokatuak = partidaJokatuak;
    }

    /** @return Irabazitako partiduen kopurua */
    public int getPartidaIrabaziak() {
        return partidaIrabaziak;
    }

    /** @param partidaIrabaziak Irabazitako partiduen kopurua ezartzeko */
    public void setPartidaIrabaziak(int partidaIrabaziak) {
        this.partidaIrabaziak = partidaIrabaziak;
    }

    /** @return Galdu diren partiduen kopurua */
    public int getPartidaGalduak() {
        return partidaGalduak;
    }

    /** @param partidaGalduak Galdu diren partiduen kopurua ezartzeko */
    public void setPartidaGalduak(int partidaGalduak) {
        this.partidaGalduak = partidaGalduak;
    }

    /** @return Taldeak lortutako puntu kopurua */
    public int getPuntuak() {
        return puntuak;
    }

    /** @param puntuak Taldearen puntu kopurua ezartzeko */
    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    /** @return Irabazitako set kopurua */
    public int getSetakIrabaziak() {
        return setakIrabaziak;
    }

    /**
     * Irabazitako set kopurua ezartzen du eta set diferentzia eguneratzen du.
     * @param setakIrabaziak Irabazitako set kopurua
     */
    public void setSetakIrabaziak(int setakIrabaziak) {
        this.setakIrabaziak = setakIrabaziak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }

    /** @return Galdu diren set kopurua */
    public int getSetakGalduak() {
        return setakGalduak;
    }

    /**
     * Galdu diren set kopurua ezartzen du eta set diferentzia eguneratzen du.
     * @param setakGalduak Galdu diren set kopurua
     */
    public void setSetakGalduak(int setakGalduak) {
        this.setakGalduak = setakGalduak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }

    /** @return Seten arteko diferentzia (irabazitakoak - galduak) */
    public int getSetDiferentzia() {
        return setDiferentzia;
    }

    /**
     * Partida jokatu bat gehitzen du.
     */
    public void gehitupartidaJokatua() {
        partidaJokatuak++;
    }

    /**
     * Irabazitako partida bat gehitzen du eta puntuak eguneratzen ditu (+3).
     */
    public void gehitupartidaIrabazia() {
        partidaIrabaziak++;
        puntuak += 3; // Irabazteagatik 3 puntu ematen dira
    }

    /**
     * Galduko partida bat gehitzen du, punturik gehitu gabe.
     */
    public void gehitupartidaGaldua() {
        partidaGalduak++;
        // Ez dira punturik gehitzen
    }

    /**
     * Irabazitako set kopurua handitzen du eta set diferentzia eguneratzen du.
     * @param setak Gehitu nahi diren set kopurua
     */
    public void gehituSetakIrabaziak(int setak) {
        this.setakIrabaziak += setak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }

    /**
     * Galdu diren set kopurua handitzen du eta set diferentzia eguneratzen du.
     * @param setak Gehitu nahi diren set kopurua
     */
    public void gehituSetakGalduak(int setak) {
        this.setakGalduak += setak;
        this.setDiferentzia = this.setakIrabaziak - this.setakGalduak;
    }
}
