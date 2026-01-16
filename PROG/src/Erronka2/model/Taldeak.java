package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Talde baten informazioa gordetzen duen klasea.
 * Taldearen kodea, izena, entrenatzailea, kokapena eta jokalekua barne.
 */
public class Taldeak {
    /** Taldearen kodea (ID) */
    private int talde_kod;

    /** Taldearen izena */
    private String izena;

    /** Taldearen entrenatzailea */
    private String entrenatzailea;

    /** Taldearen kokapena (herria, auzoa, etab.) */
    private String kokapena;

    /** Taldearen jokalekua (zelaia) */
    private String zelaia;

    /**
     * Eraikitzaile huts.
     */
    public Taldeak() {
    }

    /**
     * Eraikitzaile datuekin.
     *
     * @param talde_kod     Taldearen identifikatzaile kodea
     * @param izena         Taldearen izena
     * @param kokapena      Taldearen kokapena
     * @param entrenatzailea Taldearen entrenatzailea
     * @param zelaia        Taldearen jokalekua
     */
    public Taldeak(int talde_kod, String izena, String kokapena, String entrenatzailea, String zelaia) {
        this.izena = izena;
        this.talde_kod = talde_kod;
        this.kokapena = kokapena;
        this.entrenatzailea = entrenatzailea;
        this.zelaia = zelaia;
    }

    /** 
     * Taldearen kodea itzultzen du.
     * @return talde_kod
     */
    public int getTalde_kod() {
        return talde_kod;
    }

    /**
     * Taldearen kodea ezartzen du.
     * @param talde_kod Taldearen kode berria
     */
    public void setTalde_kod(int talde_kod) {
        this.talde_kod = talde_kod;
    }

    /**
     * Taldearen izena itzultzen du.
     * @return Taldearen izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Taldearen izena ezartzen du.
     * @param izena Taldearen izena
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Taldearen kokapena itzultzen du.
     * @return Taldearen kokapena
     */
    public String getKokapena() {
        return kokapena;
    }

    /**
     * Taldearen kokapena ezartzen du.
     * @param kokapena Taldearen kokapena
     */
    public void setKokapena(String kokapena) {
        this.kokapena = kokapena;
    }

    /**
     * Taldearen entrenatzailea itzultzen du.
     * @return Taldearen entrenatzailea
     */
    public String getEntrenatzailea() {
        return entrenatzailea;
    }

    /**
     * Taldearen entrenatzailea ezartzen du.
     * @param entrenatzailea Taldearen entrenatzailea
     */
    public void setEntrenatzailea(String entrenatzailea) {
        this.entrenatzailea = entrenatzailea;
    }

    /**
     * Taldearen jokalekua itzultzen du.
     * @return Taldearen jokalekua
     */
    public String getZelaia() {
        return zelaia;
    }

    /**
     * Taldearen jokalekua ezartzen du.
     * @param zelaia Taldearen jokalekua
     */
    public void setZelaia(String zelaia) {
        this.zelaia = zelaia;
    }

    /**
     * Taldearen izena string moduan itzultzen du.
     * Erabilgarria zerrendetan eta inprimaketetan.
     * 
     * @return Taldearen izena
     */
    @Override
    public String toString() {
        return izena;
    }

    /**
     * Bi taldeak berdinak diren ala ez erabakitzen du taldearen izenaren arabera.
     * 
     * @param obj Konparatu nahi den objektua
     * @return true izen berdina badute, bestela false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Taldeak)) return false;
        Taldeak t = (Taldeak) obj;
        return this.izena.equals(t.izena);
    }

    /**
     * hashCode metodoa izenaren hashcode bidez sortzen du.
     * 
     * @return Taldearen izenaren hashcode
     */
    @Override
    public int hashCode() {
        return izena.hashCode();
    }

    /**
     * Taldeak sortzeko klase erraza (factory pattern).
     * Talde eredu batzuk bueltatzen ditu.
     */
    public static class TaldeFactory {
        /**
         * Talde ereduak sortzen ditu zerrenda batean.
         * Lehen posizioan talderik gabeko "-" ordezkaria dago.
         * 
         * @return Talde ereduak zerrendan
         */
        public static List<Taldeak> sortuTaldeak() {
            List<Taldeak> zerrenda = new ArrayList<>();

            // Talde huts bat lehen posizioan, kode 0 duen "-" ordezkari
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

    /**
     * Talde bat izenaren arabera bilatzen du.
     * 
     * @param izena Bilatu nahi den taldearen izena
     * @return Taldea aurkitzen bada, bestela null
     */
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
