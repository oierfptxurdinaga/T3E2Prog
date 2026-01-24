package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Partidua modelatzen duen klasea.
 * <p>
 * Partiduaren oinarrizko datuak gordetzen ditu, hala nola kodea, taldeak,
 * data, set kopuruak eta denboraldia.
 * Gainera, partiduen zerrenda estatikoa eta denboraldiaren kontrol estatikoa kudeatzen ditu.
 * </p>
 */
public class Partidua {

    /** Partiduaren kodea (identifikatzailea) */
    private int partidu_kod;

    /** Etxeko taldea */
    private Taldeak etxeko_taldea;

    /** Kanpoko taldea */
    private Taldeak kanpoko_taldea;

    /** Joko zelaia */
    private String zelaia;

    /** Partiduaren data */
    private String partiduData;

    /** Partiduaren mota */
    private String partiduMota;

    /** Jardunaldia (txapelketako jardunaldi zehatza) */
    private String jardunaldia;

    /** Etxeko taldeak irabazitako set kopurua */
    private int etxekoTaldekoSetak;

    /** Kanpoko taldeak irabazitako set kopurua */
    private int kanpokoTaldekoSetak;

    /** Denboraldia (liga edo txapelketa) */
    private String denboraldia;

    /** Partidua jokatu den edo ez adierazten du */
    private boolean partiduaJokatuta;

    /** Partidu guztiak gordetzeko zerrenda estatikoa */
    private static ArrayList<Partidua> partiduakZerrenda = new ArrayList<>();

    /** Uneko denboraldiaren izena */
    private static String unekoDenboraldia = null;

    /** Denboraldia hasi den ala ez */
    private static boolean denboraldiaHasita = false;

    // ==================== ERAIKITZAILEAK ====================

    /**
     * Eraikitzaile hutsak, partidua jokatu gabe sortzen du.
     */
    public Partidua() {
        this.partiduaJokatuta = false;
    }

    /**
     * Eraikitzaile parametrizatuak, partiduaren datu guztiak ezartzen ditu.
     * @param partidu_kod Partiduaren kodea
     * @param etxeko_taldea Etxeko taldea
     * @param kanpoko_taldea Kanpoko taldea
     * @param zelaia Joko zelaia
     * @param partiduData Partiduaren data
     * @param partiduMota Partiduaren mota
     * @param jardunaldia Jardunaldia
     * @param etxekoSetak Etxeko taldeko set kopurua
     * @param kanpokoSetak Kanpoko taldeko set kopurua
     * @param denboraldia Denboraldia
     */
    public Partidua(int partidu_kod, Taldeak etxeko_taldea, Taldeak kanpoko_taldea, String zelaia, String partiduData,
                    String partiduMota, String jardunaldia, int etxekoSetak, int kanpokoSetak, String denboraldia) {
        this.partidu_kod = partidu_kod;
        this.etxeko_taldea = etxeko_taldea;
        this.kanpoko_taldea = kanpoko_taldea;
        this.zelaia = zelaia;
        this.partiduData = partiduData;
        this.partiduMota = partiduMota;
        this.jardunaldia = jardunaldia;
        this.etxekoTaldekoSetak = etxekoSetak;
        this.kanpokoTaldekoSetak = kanpokoSetak;
        this.denboraldia = denboraldia;
        this.partiduaJokatuta = (etxekoSetak > 0 || kanpokoSetak > 0);
    }

    // ==================== GETTER ETA SETTER METODOAK ====================

    /** @return Partiduaren kodea */
    public int getPartidu_kod() {
        return partidu_kod;
    }

    /** @param partidu_kod Partiduaren kodea ezartzen du */
    public void setPartidu_kod(int partidu_kod) {
        this.partidu_kod = partidu_kod;
    }

    /** @return Etxeko taldea */
    public Taldeak getEtxeko_taldea() {
        return etxeko_taldea;
    }

    /** @param etxeko_taldea Etxeko taldea ezartzen du */
    public void setEtxeko_taldea(Taldeak etxeko_taldea) {
        this.etxeko_taldea = etxeko_taldea;
    }

    /** @return Kanpoko taldea */
    public Taldeak getKanpoko_taldea() {
        return kanpoko_taldea;
    }

    /** @param kanpoko_taldea Kanpoko taldea ezartzen du */
    public void setKanpoko_taldea(Taldeak kanpoko_taldea) {
        this.kanpoko_taldea = kanpoko_taldea;
    }

    /** @return Joko zelaia */
    public String getZelaia() {
        return zelaia;
    }

    /** @param zelaia Joko zelaia ezartzen du */
    public void setZelaia(String zelaia) {
        this.zelaia = zelaia;
    }

    /** @return Partiduaren data */
    public String getPartiduData() {
        return partiduData;
    }

    /** @param partiduData Partiduaren data ezartzen du */
    public void setPartiduData(String partiduData) {
        this.partiduData = partiduData;
    }

    /** @return Partiduaren mota */
    public String getPartiduMota() {
        return partiduMota;
    }

    /** @param partiduMota Partiduaren mota ezartzen du */
    public void setPartiduMota(String partiduMota) {
        this.partiduMota = partiduMota;
    }

    /** @return Jardunaldia */
    public String getJardunaldia() {
        return jardunaldia;
    }

    /** @param jardunaldia Jardunaldia ezartzen du */
    public void setJardunaldia(String jardunaldia) {
        this.jardunaldia = jardunaldia;
    }

    /** @return Etxeko taldeko puntuazioa (set kopurua) */
    public int getEtxekoTaldekoPuntuazioa() {
        return etxekoTaldekoSetak;
    }

    /** @param etxekoTaldekoSetak Etxeko taldeko puntuazioa ezartzen du */
    public void setEtxekoTaldekoPuntuazioa(int etxekoTaldekoSetak) {
        this.etxekoTaldekoSetak = etxekoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    /** @return Kanpoko taldeko puntuazioa (set kopurua) */
    public int getKanpokoTaldekoPuntuazioa() {
        return kanpokoTaldekoSetak;
    }

    /** @param kanpokoTaldekoSetak Kanpoko taldeko puntuazioa ezartzen du */
    public void setKanpokoTaldekoPuntuazioa(int kanpokoTaldekoSetak) {
        this.kanpokoTaldekoSetak = kanpokoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    /** @return Denboraldia */
    public String getDenboraldia() {
        return denboraldia;
    }

    /** @param denboraldia Denboraldia ezartzen du */
    public void setDenboraldia(String denboraldia) {
        this.denboraldia = denboraldia;
    }

    /** @return Partidua jokatu den ala ez */
    public boolean isPartiduaJokatuta() {
        return partiduaJokatuta;
    }

    /** @param partiduaJokatuta Partidua jokatu den ala ez ezartzen du */
    public void setPartiduaJokatuta(boolean partiduaJokatuta) {
        this.partiduaJokatuta = partiduaJokatuta;
    }

    /** @return Etxeko taldeko set kopurua */
    public int getEtxekoTaldekoSetak() {
        return etxekoTaldekoSetak;
    }

    /** @param etxekoTaldekoSetak Etxeko taldeko set kopurua ezartzen du */
    public void setEtxekoTaldekoSetak(int etxekoTaldekoSetak) {
        this.etxekoTaldekoSetak = etxekoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    /** @return Kanpoko taldeko set kopurua */
    public int getKanpokoTaldekoSetak() {
        return kanpokoTaldekoSetak;
    }

    /** @param kanpokoTaldekoSetak Kanpoko taldeko set kopurua ezartzen du */
    public void setKanpokoTaldekoSetak(int kanpokoTaldekoSetak) {
        this.kanpokoTaldekoSetak = kanpokoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    // ==================== DENBORALDIEN KONTROL STATIKOAK ====================

    /** @return Uneko denboraldiaren izena */
    public static String getUnekoDenboraldia() {
        return unekoDenboraldia;
    }

    /** @param denboraldia Uneko denboraldiaren izena ezartzen du */
    public static void setUnekoDenboraldia(String denboraldia) {
        unekoDenboraldia = denboraldia;
    }

    /** @return Denboraldia hasi den ala ez */
    public static boolean isDenboraldiaHasita() {
        return denboraldiaHasita;
    }

    /** @param hasita Denboraldia hasi den ala ez ezartzen du */
    public static void setDenboraldiaHasita(boolean hasita) {
        denboraldiaHasita = hasita;
    }

    /**
     * Denboraldi berri bat hasi daitekeen egiaztatzen du.
     * @return true hasi daiteke, false dagoeneko hasi bada
     */
    public static boolean denboraldiaAmaituta() {
        if (unekoDenboraldia == null) {
            return true;
        }
        
        List<Partidua> partiduak = getPartiduakByDenboraldia(unekoDenboraldia);
        if (partiduak.isEmpty()) {
            return true;
        }
        
        for (Partidua p : partiduak) {
            if (!p.isPartiduaJokatuta()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Denboraldi berria hasi.
     * @param denboraldiaBerria Hasi nahi den denboraldiaren izena
     * @return true hasi bada, false ezin bada hasi
     */
    public static boolean hasiDenboraldiaBerria(String denboraldiaBerria) {
        if (unekoDenboraldia != null && denboraldiaHasita) {
            return false;
        }
        
        unekoDenboraldia = denboraldiaBerria;
        denboraldiaHasita = true;
        
        System.out.println("Denboraldi berria hasita: " + denboraldiaBerria);
        return true;
    }

    /**
     * Uneko denboraldia amaitu.
     */
    public static void amaituDenboraldia() {
        if (unekoDenboraldia == null) {
            System.out.println("Ez dago denboraldi aktiborik amaitzeko");
            return;
        }
        
        System.out.println("Denboraldia amaitu da: " + unekoDenboraldia);
        
        denboraldiaHasita = false;
        // Historiala mantentzeko unekoDenboraldia ez da aldatzen
    }

    // ==================== PARTIDUEN KUDEAKETA ====================

    /**
     * Partidu bat gehitu partidu zerrendara.
     * @param p Gehitu nahi den partidua
     */
    public static void gehituPartidua(Partidua p) {
        partiduakZerrenda.add(p);
    }

    /**
     * Partidu guztiak itzuli.
     * @return Partidu zerrenda osoa
     */
    public static ArrayList<Partidua> getPartiduakZerrenda() {
        return partiduakZerrenda;
    }

    /**
     * Partidu zerrenda berria ezarri.
     * @param zerrenda Partidu zerrenda berria
     */
    public static void setPartiduakZerrenda(ArrayList<Partidua> zerrenda) {
        partiduakZerrenda = zerrenda;
    }

    /**
     * Denboraldi eta jardunaldiaren arabera partiduak iragazi.
     * @param denboraldia Denboraldia iragazteko (edo "Guztiak")
     * @param jardunaldia Jardunaldia iragazteko (edo "Guztiak")
     * @return Iragazitako partiduen zerrenda
     */
    public static List<Partidua> getPartiduakByDenboraldiaAndJardunaldia(String denboraldia, String jardunaldia) {
        List<Partidua> emaitza = new ArrayList<>();
        
        boolean denboraldiaGuztiak = denboraldia == null || denboraldia.isEmpty() || denboraldia.equals("Guztiak");
        boolean jardunaldiaGuztiak = jardunaldia == null || jardunaldia.isEmpty() || jardunaldia.equals("Guztiak");
        
        for (Partidua p : partiduakZerrenda) {
            boolean denboraldiaBerdina = denboraldiaGuztiak || p.getDenboraldia().equals(denboraldia);
            boolean jardunaldiaBerdina = jardunaldiaGuztiak || p.getJardunaldia().equals(jardunaldia);
            
            if (denboraldiaBerdina && jardunaldiaBerdina) {
                emaitza.add(p);
            }
        }
        return emaitza;
    }

    /**
     * Jardunaldi baten arabera partiduak lortu.
     * @param jardunaldia Jardunaldia
     * @return Jardunaldiko partiduak
     */
    public static List<Partidua> getPartiduakByJardunaldia(String jardunaldia) {
        List<Partidua> emaitza = new ArrayList<>();
        for (Partidua p : partiduakZerrenda) {
            if (p.getJardunaldia().equals(jardunaldia)) {
                emaitza.add(p);
            }
        }
        return emaitza;
    }

    /**
     * Partidu guztiak lortu.
     * @return Partidu guztiak zerrenda batean
     */
    public static List<Partidua> getPartiduakGuztiak() {
        return new ArrayList<>(partiduakZerrenda);
    }

    /**
     * Denboraldi bateko partiduak lortu.
     * @param denboraldia Denboraldia
     * @return Denboraldi horretako partiduak
     */
    public static List<Partidua> getPartiduakByDenboraldia(String denboraldia) {
        List<Partidua> emaitza = new ArrayList<>();
        for (Partidua p : partiduakZerrenda) {
            if (p.getDenboraldia().equals(denboraldia)) {
                emaitza.add(p);
            }
        }
        return emaitza;
    }

    /**
     * Egiaztatu denboraldi bat hasita dagoen (gutxienez partida bat jokatu den).
     * @param denboraldia Denboraldia
     * @return true denboraldia hasita badago, bestela false
     */
    public static boolean denboraldiaHasita(String denboraldia) {
        List<Partidua> partiduak = getPartiduakByDenboraldia(denboraldia);
        for (Partidua p : partiduak) {
            if (p.isPartiduaJokatuta()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Egiaztatu denboraldi bateko partidu guztiak jokatu diren.
     * @param denboraldia Denboraldia
     * @return true partidu guztiak jokatu badira, bestela false
     */
    public static boolean denboraldiaOsoaJokatuta(String denboraldia) {
        List<Partidua> partiduak = getPartiduakByDenboraldia(denboraldia);
        if (partiduak.isEmpty()) {
            return false;
        }
        
        for (Partidua p : partiduak) {
            if (!p.isPartiduaJokatuta()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Talde bat kodearen arabera bilatu eta itzuli.
     * @param taldeKod Taldearen kodea
     * @return Taldeak objektua edo null, ez badago taldea
     */
    public static Taldeak getTaldeaByKod(int taldeKod) {
        List<Taldeak> taldeak = Taldeak.TaldeFactory.sortuTaldeak();
        for (Taldeak taldea : taldeak) {
            if (taldea.getTalde_kod() == taldeKod) {
                return taldea;
            }
        }
        return null;
    }

    // ==================== BESTEAK ====================

    /**
     * Partiduaren informazioa string moduan itzultzen du.
     * @return Partiduaren deskribapena
     */
    @Override
    public String toString() {
        return etxeko_taldea + " vs " + kanpoko_taldea + " (" + etxekoTaldekoSetak + " - "
                + kanpokoTaldekoSetak + ") - " + denboraldia;
    }
}
