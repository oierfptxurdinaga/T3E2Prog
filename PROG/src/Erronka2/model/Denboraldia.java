package Erronka2.model;

import java.util.Arrays;

public class Denboraldia {
    private int denboraldi_kod;
    private String denboraldiaren_Izena;
    private String hasiera_data;
    private String amaiera_data;
    private int jardunaldi_kopurua;
    private Jardunaldia[] jardunaldiak;
    
    public Denboraldia() {
    }
    
    public Denboraldia(int denboraldi_kod, String denboraldiaren_Izena, 
                       String hasiera_data, String amaiera_data, 
                       int jardunaldi_kopurua, Jardunaldia[] jardunaldiak) {
        this.denboraldi_kod = denboraldi_kod;
        this.denboraldiaren_Izena = denboraldiaren_Izena;
        this.hasiera_data = hasiera_data;
        this.amaiera_data = amaiera_data;
        this.jardunaldi_kopurua = jardunaldi_kopurua;
        this.jardunaldiak = jardunaldiak;
    }
    
    public int getDenboraldi_kod() {
        return denboraldi_kod;
    }
    
    public void setDenboraldi_kod(int denboraldi_kod) {
        this.denboraldi_kod = denboraldi_kod;
    }
    
    public String getDenboraldiaren_Izena() {
        return denboraldiaren_Izena;
    }
    
    public void setDenboraldiaren_Izena(String denboraldiaren_Izena) {
        this.denboraldiaren_Izena = denboraldiaren_Izena;
    }
    
    public String getHasiera_data() {
        return hasiera_data;
    }
    
    public void setHasiera_data(String hasiera_data) {
        this.hasiera_data = hasiera_data;
    }
    
    public String getAmaiera_data() {
        return amaiera_data;
    }
    
    public void setAmaiera_data(String amaiera_data) {
        this.amaiera_data = amaiera_data;
    }
    
    public int getJardunaldi_kopurua() {
        return jardunaldi_kopurua;
    }
    
    public void setJardunaldi_kopurua(int jardunaldi_kopurua) {
        this.jardunaldi_kopurua = jardunaldi_kopurua;
    }
    
    public Jardunaldia[] getJardunaldiak() {
        return jardunaldiak;
    }
    
    public void setJardunaldiak(Jardunaldia[] jardunaldiak) {
        this.jardunaldiak = jardunaldiak;
    }
    
    @Override
    public String toString() {
        return "Denboraldia{" +
                "denboraldi_kod=" + denboraldi_kod +
                ", denboraldiaren_Izena='" + denboraldiaren_Izena + '\'' +
                ", hasiera_data='" + hasiera_data + '\'' +
                ", amaiera_data='" + amaiera_data + '\'' +
                ", jardunaldi_kopurua=" + jardunaldi_kopurua +
                ", jardunaldiak=" + Arrays.toString(jardunaldiak) +
                '}';
    }
}