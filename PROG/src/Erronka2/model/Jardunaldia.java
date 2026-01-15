package Erronka2.model;

import java.util.Arrays;

public class Jardunaldia {
    // Liga edo txapelketa bateko jardunaldi baten datuak gordetzeko klasea

    private int jardunaldi_kod;       // Jardunaldiaren identifikatzaile (kodea)
    private String hasieraData;       // Jardunaldiaren hasiera data
    private String amaieraData;       // Jardunaldiaren amaiera data
    private int partiduKopurua;       // Jardunaldian jokatutako partidu kopurua
    private Partidua[] partiduak;     // Jardunaldiko partiduak array batean gordeta

    // Eraikitzaile hutsak, objektua hasieratu gabe sortzeko
    public Jardunaldia() {
    }

    // Eraikitzaile parametrizatuak, datu guztiak aldi berean ezartzeko
    public Jardunaldia(int jardunaldi_kod, String hasieraData, String amaieraData,
                       int partiduKopurua, Partidua[] partiduak) {
        this.jardunaldi_kod = jardunaldi_kod;
        this.hasieraData = hasieraData;
        this.amaieraData = amaieraData;
        this.partiduKopurua = partiduKopurua;
        this.partiduak = partiduak;
    }

    // Getters eta setters, atributuak irakurtzeko eta aldatzeko
    public int getJardunaldi_kod() {
        return jardunaldi_kod;
    }

    public void setJardunaldi_kod(int jardunaldi_kod) {
        this.jardunaldi_kod = jardunaldi_kod;
    }

    public String getHasieraData() {
        return hasieraData;
    }

    public void setHasieraData(String hasieraData) {
        this.hasieraData = hasieraData;
    }

    public String getAmaieraData() {
        return amaieraData;
    }

    public void setAmaieraData(String amaieraData) {
        this.amaieraData = amaieraData;
    }

    public int getPartiduKopurua() {
        return partiduKopurua;
    }

    public void setPartiduKopurua(int partiduKopurua) {
        this.partiduKopurua = partiduKopurua;
    }

    public Partidua[] getPartiduak() {
        return partiduak;
    }

    public void setPartiduak(Partidua[] partiduak) {
        this.partiduak = partiduak;
    }

    // Objektuaren datuak string moduan itzultzen ditu, lagungarria debug edo inprimaketetan
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
