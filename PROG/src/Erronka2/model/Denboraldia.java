package Erronka2.model;

import java.util.Arrays;

/**
 * Denboraldiaren identifikatzaile eta oinarrizko informazioa gordetzen duen klasea.
 * <p>
 * Klase honek denboraldi baten datuak gordetzen ditu, hala nola kodea, izena, hasiera eta amaiera data,
 * jardunaldien kopurua eta jardunaldiak berak.
 * </p>
 */
public class Denboraldia {
    private int denboraldi_kod;            // Denboraldiaren kodea (ID)
    private String denboraldiarenIzena;    // Denboraldiaren izena
    private String hasieraData;            // Denboraldiaren hasiera data
    private String amaieraData;            // Denboraldiaren amaiera data
    private int jardunaldiKopurua;         // Denboraldiaren jardunaldien kopurua
    private Jardunaldia[] jardunaldiak;    // Jardunaldiak array batean gordeta (denboraldiaren barruko jardunaldiak)

    /**
     * Eraikitzaile hutsak, objektua hasieratzeko balio du.
     */
    public Denboraldia() {
    }

    /**
     * Eraikitzaile parametrizatuak, denboraldiaren datuak hasieratzeko erabiltzen da.
     *
     * @param denboraldi_kod    Denboraldiaren kodea (ID)
     * @param denboraldiarenIzena Denboraldiaren izena
     * @param hasieraData       Denboraldiaren hasiera data
     * @param amaieraData       Denboraldiaren amaiera data
     * @param jardunaldiKopurua Denboraldiaren jardunaldien kopurua
     * @param jardunaldiak      Denboraldiaren barruan dauden jardunaldiak array batean
     */
    public Denboraldia(int denboraldi_kod, String denboraldiarenIzena, String hasieraData, String amaieraData,
            int jardunaldiKopurua, Jardunaldia[] jardunaldiak) {
        this.denboraldi_kod = denboraldi_kod;
        this.denboraldiarenIzena = denboraldiarenIzena;
        this.hasieraData = hasieraData;
        this.amaieraData = amaieraData;
        this.jardunaldiKopurua = jardunaldiKopurua;
        this.jardunaldiak = jardunaldiak;
    }

    /** 
     * Denboraldiaren kodea itzultzen du.
     * @return Denboraldiaren kodea (int)
     */
    public int getDenboraldi_kod() {
        return denboraldi_kod;
    }

    /**
     * Denboraldiaren kodea ezartzen du.
     * @param denboraldi_kod Denboraldiaren kode berria
     */
    public void setDenboraldi_kod(int denboraldi_kod) {
        this.denboraldi_kod = denboraldi_kod;
    }

    /**
     * Denboraldiaren izena itzultzen du.
     * @return Denboraldiaren izena (String)
     */
    public String getDenboraldiarenIzena() {
        return denboraldiarenIzena;
    }

    /**
     * Denboraldiaren izena ezartzen du.
     * @param denboraldiarenIzena Denboraldiaren izena berria
     */
    public void setDenboraldiarenIzena(String denboraldiarenIzena) {
        this.denboraldiarenIzena = denboraldiarenIzena;
    }

    /**
     * Denboraldiaren hasiera data itzultzen du.
     * @return Hasiera data (String)
     */
    public String getHasieraData() {
        return hasieraData;
    }

    /**
     * Denboraldiaren hasiera data ezartzen du.
     * @param hasieraData Hasiera data berria
     */
    public void setHasieraData(String hasieraData) {
        this.hasieraData = hasieraData;
    }

    /**
     * Denboraldiaren amaiera data itzultzen du.
     * @return Amaiera data (String)
     */
    public String getAmaieraData() {
        return amaieraData;
    }

    /**
     * Denboraldiaren amaiera data ezartzen du.
     * @param amaieraData Amaiera data berria
     */
    public void setAmaieraData(String amaieraData) {
        this.amaieraData = amaieraData;
    }

    /**
     * Denboraldiaren jardunaldien kopurua itzultzen du.
     * @return Jardunaldi kopurua (int)
     */
    public int getJardunaldiKopurua() {
        return jardunaldiKopurua;
    }

    /**
     * Denboraldiaren jardunaldien kopurua ezartzen du.
     * @param jardunaldiKopurua Jardunaldi kopuru berria
     */
    public void setJardunaldiKopurua(int jardunaldiKopurua) {
        this.jardunaldiKopurua = jardunaldiKopurua;
    }

    /**
     * Denboraldiaren barruko jardunaldiak itzultzen ditu array moduan.
     * @return Jardunaldiak array batean (Jardunaldia[])
     */
    public Jardunaldia[] getJardunaldiak() {
        return jardunaldiak;
    }

    /**
     * Denboraldiaren barruko jardunaldiak ezartzen ditu.
     * @param jardunaldiak Jardunaldiak array batean
     */
    public void setJardunaldiak(Jardunaldia[] jardunaldiak) {
        this.jardunaldiak = jardunaldiak;
    }

    /**
     * Objektuaren informazioa testu moduan itzultzen du.
     * @return Denboraldiaren atributuen laburpena String formatuan
     */
    @Override
    public String toString() {
        return "Denboraldia{" + "denboraldi_kod=" + denboraldi_kod + ", denboraldiaren_Izena='" + denboraldiarenIzena
                + '\'' + ", hasiera_data='" + hasieraData + '\'' + ", amaiera_data='" + amaieraData + '\''
                + ", jardunaldi_kopurua=" + jardunaldiKopurua + ", jardunaldiak=" + Arrays.toString(jardunaldiak)
                + '}';
    }
}
