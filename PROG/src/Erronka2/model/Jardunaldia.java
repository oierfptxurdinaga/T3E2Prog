package Erronka2.model;

import java.util.Arrays;

public class Jardunaldia  {
    private int jardunaldi_kod;
    private String hasiera_data;
    private String amaiera_data;
    private int partidu_kopurua;
    private Partidua[] partiduak;
    
    public Jardunaldia() {
    }
    
    public Jardunaldia(int jardunaldi_kod, String hasiera_data, String amaiera_data, 
                       int partidu_kopurua, Partidua[] partiduak) {
        this.jardunaldi_kod = jardunaldi_kod;
        this.hasiera_data = hasiera_data;
        this.amaiera_data = amaiera_data;
        this.partidu_kopurua = partidu_kopurua;
        this.partiduak = partiduak;
    }
    
    public int getJardunaldi_kod() {
        return jardunaldi_kod;
    }
    
    public void setJardunaldi_kod(int jardunaldi_kod) {
        this.jardunaldi_kod = jardunaldi_kod;
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
    
    public int getPartidu_kopurua() {
        return partidu_kopurua;
    }
    
    public void setPartidu_kopurua(int partidu_kopurua) {
        this.partidu_kopurua = partidu_kopurua;
    }
    
    public Partidua[] getPartiduak() {
        return partiduak;
    }
    
    public void setPartiduak(Partidua[] partiduak) {
        this.partiduak = partiduak;
    }
    
    @Override
    public String toString() {
        return "Jardunaldia{" +
                "jardunaldi_kod=" + jardunaldi_kod +
                ", hasiera_data='" + hasiera_data + '\'' +
                ", amaiera_data='" + amaiera_data + '\'' +
                ", partidu_kopurua=" + partidu_kopurua +
                ", partiduak=" + Arrays.toString(partiduak) +
                '}';
    }
}