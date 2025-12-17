package Erronka2.model;

import java.util.Date;

public class Jokalaria {
    private int jokalarikod;
    private String nan;
    private Date jaiotzedata;
    private String jokalariRola;
    private int taldeKod;
    
    public Jokalaria() {
    }
    
    public Jokalaria(int jokalarikod, String nan, Date jaiotzedata, String jokalariRola, int taldeKod) {
        this.jokalarikod = jokalarikod;
        this.nan = nan;
        this.jaiotzedata = jaiotzedata;
        this.jokalariRola = jokalariRola;
        this.taldeKod = taldeKod;
    }
    
    public int getJokalarikod() {
        return jokalarikod;
    }
    
    public void setJokalarikod(int jokalarikod) {
        this.jokalarikod = jokalarikod;
    }
    
    public String getNan() {
        return nan;
    }
    
    public void setNan(String nan) {
        this.nan = nan;
    }
    
    public Date getJaiotzedata() {
        return jaiotzedata;
    }
    
    public void setJaiotzedata(Date jaiotzedata) {
        this.jaiotzedata = jaiotzedata;
    }
    
    public String getJokalariRola() {
        return jokalariRola;
    }
    
    public void setJokalariRola(String jokalariRola) {
        this.jokalariRola = jokalariRola;
    }
    
    public int getTaldeKod() {
        return taldeKod;
    }
    
    public void setTaldeKod(int taldeKod) {
        this.taldeKod = taldeKod;
    }
    
    @Override
    public String toString() {
        return "Jokalaria{" +
                "jokalarikod=" + jokalarikod +
                ", nan='" + nan + '\'' +
                ", jaiotzedata=" + jaiotzedata +
                ", jokalariRola='" + jokalariRola + '\'' +
                ", taldeKod=" + taldeKod +
                '}';
    }
}