package Erronka2.model;

import java.util.Arrays;

/**
 * Ligaren jardunaldi baten datuak gordetzeko klasea.
 * <p>
 * Klase honek jardunaldiaren kodea, hasiera eta amaiera data, partidu kopurua
 * eta partiduak array batean gordetzen ditu.
 * </p>
 */
public class Jardunaldia {

    private int jardunaldi_kod;       // Jardunaldiaren identifikatzaile (kodea)
    private String hasieraData;       // Jardunaldiaren hasiera data
    private String amaieraData;       // Jardunaldiaren amaiera data
    private int partiduKopurua;       // Jardunaldian jokatutako partidu kopurua
    private Partidua[] partiduak;     // Jardunaldiko partiduak array batean gordeta

    /**
     * Eraikitzaile hutsak, objektua hasieratu gabe sortzeko.
     */
    public Jardunaldia() {
    }

    /**
     * Eraikitzaile parametrizatuak, datu guztiak aldi berean ezartzeko.
     *
     * @param jardunaldi_kod Jardunaldiaren kodea (identifikatzailea)
     * @param hasieraData    Jardunaldiaren hasiera data
     * @param amaieraData    Jardunaldiaren amaiera data
     * @param partiduKopurua Jardunaldian jokatutako partidu kopurua
     * @param partiduak      Jardunaldiko partiduak array batean
     */
    public Jardunaldia(int jardunaldi_kod, String hasieraData, String amaieraData,
                       int partiduKopurua, Partidua[] partiduak) {
        this.jardunaldi_kod = jardunaldi_kod;
        this.hasieraData = hasieraData;
        this.amaieraData = amaieraData;
        this.partiduKopurua = partiduKopurua;
        this.partiduak = partiduak;
    }

    /**
     * Jardunaldiaren kodea itzultzen du.
     *
     * @return Jardunaldiaren kodea
     */
    public int getJardunaldi_kod() {
        return jardunaldi_kod;
    }

    /**
     * Jardunaldiaren kodea ezartzen du.
     *
     * @param jardunaldi_kod Jardunaldiaren kode berria
     */
    public void setJardunaldi_kod(int jardunaldi_kod) {
        this.jardunaldi_kod = jardunaldi_kod;
    }

    /**
     * Jardunaldiaren hasiera data itzultzen du.
     *
     * @return Hasiera data
     */
    public String getHasieraData() {
        return hasieraData;
    }

    /**
     * Jardunaldiaren hasiera data ezartzen du.
     *
     * @param hasieraData Hasiera data berria
     */
    public void setHasieraData(String hasieraData) {
        this.hasieraData = hasieraData;
    }

    /**
     * Jardunaldiaren amaiera data itzultzen du.
     *
     * @return Amaiera data
     */
    public String getAmaieraData() {
        return amaieraData;
    }

    /**
     * Jardunaldiaren amaiera data ezartzen du.
     *
     * @param amaieraData Amaiera data berria
     */
    public void setAmaieraData(String amaieraData) {
        this.amaieraData = amaieraData;
    }

    /**
     * Jardunaldiaren partidu kopurua itzultzen du.
     *
     * @return Partidu kopurua
     */
    public int getPartiduKopurua() {
        return partiduKopurua;
    }

    /**
     * Jardunaldiaren partidu kopurua ezartzen du.
     *
     * @param partiduKopurua Partidu kopuru berria
     */
    public void setPartiduKopurua(int partiduKopurua) {
        this.partiduKopurua = partiduKopurua;
    }

    /**
     * Jardunaldiaren partiduak array moduan itzultzen ditu.
     *
     * @return Partiduak array batean
     */
    public Partidua[] getPartiduak() {
        return partiduak;
    }

    /**
     * Jardunaldiaren partiduak ezartzen ditu.
     *
     * @param partiduak Partiduak array batean
     */
    public void setPartiduak(Partidua[] partiduak) {
        this.partiduak = partiduak;
    }

    /**
     * Objektuaren datuak string formatuan itzultzen ditu, debug edo inprimaketetarako erabilgarria.
     *
     * @return Jardunaldiaren datuen laburpena String moduan
     */
    @Override
    public String toString() {
        return "Jardunaldia{" +
                "jardunaldi_kod=" + jardunaldi_kod +
                ", hasiera_data='" + hasieraData + '\'' +
                ", amaiera_data='" + amaieraData + '\'' +
                ", partidu_kopurua=" + partiduKopurua +
                ", partiduak=" + Arrays.toString(partiduak) +
                '}';
    }
}
