package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

public class Taldeak {
    // Talde baten informazioa gordetzen duen klasea

    private int talde_kod;          // Taldearen kodea (ID)
    private String izena;           // Taldearen izena
    private String entrenatzailea;  // Taldearen entrenatzailea
    private String kokapena;        // Taldearen kokapena (herria, auzoa, etab.)
    private String zelaia;          // Taldearen jokalekua (zelaia)

    // Eraikitzaile huts
    public Taldeak() {
    }

    // Eraikitzaile datuekin
    public Taldeak(int talde_kod, String izena, String kokapena, String entrenatzailea, String zelaia) {
        this.izena = izena;
        this.talde_kod = talde_kod;
        this.kokapena = kokapena;
        this.entrenatzailea = entrenatzailea;
        this.zelaia = zelaia;
    }

    // Getters eta setters atributuetarako
    public int getTalde_kod() {
        return talde_kod;
    }

    public void setTalde_kod(int talde_kod) {
        this.talde_kod = talde_kod;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getKokapena() {
        return kokapena;
    }

    public void setKokapena(String kokapena) {
        this.kokapena = kokapena;
    }

    public String getEntrenatzailea() {
        return entrenatzailea;
    }

    public void setEntrenatzailea(String entrenatzailea) {
        this.entrenatzailea = entrenatzailea;
    }

    public String getZelaia() {
        return zelaia;
    }

    public void setZelaia(String zelaia) {
        this.zelaia = zelaia;
    }

    // Taldearen izena itzultzen du string bezala, erabilgarria zerrendetan
    @Override
    public String toString() {
        return izena;
    }

    // Bi taldeak berdinak diren ala ez taldearen izenaren arabera erabakitzeko
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Taldeak)) return false;
        Taldeak t = (Taldeak) obj;
        return this.izena.equals(t.izena);
    }
    
    @Override
    public int hashCode() {
        return izena.hashCode();
    }
    
    // Taldeak sortzeko klase erraza (factory pattern)
    public static class TaldeFactory {
        public static List<Taldeak> sortuTaldeak() {
            List<Taldeak> zerrenda = new ArrayList<>();

            // Talde huts bat lehen posizioan, kode 0 duen "-"-ren ordezkari
            zerrenda.add(new Taldeak(0,"-", "", "", ""));

            // Talde eredu batzuk gehitzen dira
            zerrenda.add(new Taldeak(1, "Otxarkoaga Distira", "", "", ""));
            zerrenda.add(new Taldeak(2, "Miribilla Uhinen Jokoak", "", "", ""));
            zerrenda.add(new Taldeak(3, "Txurdinaga Harriak", "", "", ""));
            zerrenda.add(new Taldeak(4, "Usansolo Hortzadak", "", "", ""));
            zerrenda.add(new Taldeak(5, "Matiko Txirrindulariak", "", "", ""));
            zerrenda.add(new Taldeak(6, "Santutxu Haizeak", "", "", ""));

            return zerrenda;
        }
    }
    
    // Talde bat izenaren arabera bilatzeko metodoa
    public static Taldeak getTaldeaIzenaz(String izena) {
        List<Taldeak> taldeak = TaldeFactory.sortuTaldeak();
        for (Taldeak taldea : taldeak) {
            if (taldea.getIzena().equals(izena)) {
                return taldea;
            }
        }
        return null;
    }
}
