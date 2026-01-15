package Erronka2.model;

import java.util.Arrays;

public class Denboraldia {
    // Denboraldiaren identifikatzaile eta oinarrizko informazioa gordetzen duen klasea

    private int denboraldi_kod;            // Denboraldiaren kodea (ID)
    private String denboraldiarenIzena;    // Denboraldiaren izena
    private String hasieraData;            // Denboraldiaren hasiera data
    private String amaieraData;            // Denboraldiaren amaiera data
    private int jardunaldiKopurua;         // Denboraldiaren jardunaldien kopurua
    private Jardunaldia[] jardunaldiak;    // Jardunaldiak array batean gordeta (denboraldiaren barruko jardunaldiak)

    // Eraikitzaile hutsak, objektua hasieratzeko balio du
    public Denboraldia() {
    }

    // Eraikitzaile parametrizatuak, datuak hasieratzeko erabiltzen da
    public Denboraldia(int denboraldi_kod, String denboraldiarenIzena, String hasieraData, String amaieraData,
            int jardunaldiKopurua, Jardunaldia[] jardunaldiak) {
        this.denboraldi_kod = denboraldi_kod;
        this.denboraldiarenIzena = denboraldiarenIzena;
        this.hasieraData = hasieraData;
        this.amaieraData = amaieraData;
        this.jardunaldiKopurua = jardunaldiKopurua;
        this.jardunaldiak = jardunaldiak;
    }

    // Getters eta setters — atributuak irakurtzeko eta aldatzeko metodoak
    public int getDenboraldi_kod() {
        return denboraldi_kod;
    }

    public void setDenboraldi_kod(int denboraldi_kod) {
        this.denboraldi_kod = denboraldi_kod;
    }

    public String getDenboraldiarenIzena() {
        return denboraldiarenIzena;
    }

    public void setDenboraldiarenIzena(String denboraldiarenIzena) {
        this.denboraldiarenIzena = denboraldiarenIzena;
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

    public int getJardunaldiKopurua() {
        return jardunaldiKopurua;
    }

    public void setJardunaldiKopurua(int jardunaldiKopurua) {
        this.jardunaldiKopurua = jardunaldiKopurua;
    }

    public Jardunaldia[] getJardunaldiak() {
        return jardunaldiak;
    }

    public void setJardunaldiak(Jardunaldia[] jardunaldiak) {
        this.jardunaldiak = jardunaldiak;
    }

    // Objektuaren informazioa testu moduan bueltatzen du, lagungarria debug eta inprimaketetarako
    @Override
    public String toString() {
        return "Denboraldia{" + "denboraldi_kod=" + denboraldi_kod + ", denboraldiaren_Izena='" + denboraldiarenIzena
                + '\'' + ", hasiera_data='" + hasieraData + '\'' + ", amaiera_data='" + amaieraData + '\''
                + ", jardunaldi_kopurua=" + jardunaldiKopurua + ", jardunaldiak=" + Arrays.toString(jardunaldiak)
                + '}';
    }
}
