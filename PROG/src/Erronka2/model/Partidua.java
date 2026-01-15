package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Partidua modelatzen duen klasea
 */
public class Partidua {

    // Partiduaren oinarrizko datuak
    private int partidu_kod;               // Partiduaren kodea (identifikatzailea)
    private Taldeak etxeko_taldea;        // Etxeko taldea
    private Taldeak kanpoko_taldea;       // Kanpoko taldea
    private String zelaia;                 // Joko zelaia
    private String partiduData;            // Partiduaren data
    private String partiduMota;            // Partiduaren mota
    private String jardunaldia;            // Jardunaldia (txapelketako jardunaldi zehatza)
    private int etxekoTaldekoSetak;       // Etxeko taldeak irabazitako set kopurua
    private int kanpokoTaldekoSetak;      // Kanpoko taldeak irabazitako set kopurua
    private String denboraldia;            // Denboraldia (liga edo txapelketa)
    private boolean partiduaJokatuta;     // Partidua jokatu den edo ez adierazten du

    // Partidu guztiak gordetzeko zerrenda estatikoa
    private static ArrayList<Partidua> partiduakZerrenda = new ArrayList<>();
    
    // Denboraldi uneko kontrol estatikoa
    private static String unekoDenboraldia = null;      // Uneko denboraldiaren izena
    private static boolean denboraldiaHasita = false;   // Denboraldia hasi den ala ez

    // ==================== ERAIKITZAILEAK ====================

    public Partidua() {
        this.partiduaJokatuta = false; // Hasierako balioa jokatu gabea
    }

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
        this.partiduaJokatuta = (etxekoSetak > 0 || kanpokoSetak > 0); // Set kopuru bat badago, partidua jokatu dela suposatu
    }

    // ==================== GETTER ETA SETTER METODOAK ====================

    public int getPartidu_kod() {
        return partidu_kod;
    }

    public void setPartidu_kod(int partidu_kod) {
        this.partidu_kod = partidu_kod;
    }

    public Taldeak getEtxeko_taldea() {
        return etxeko_taldea;
    }

    public void setEtxeko_taldea(Taldeak etxeko_taldea) {
        this.etxeko_taldea = etxeko_taldea;
    }

    public Taldeak getKanpoko_taldea() {
        return kanpoko_taldea;
    }

    public void setKanpoko_taldea(Taldeak kanpoko_taldea) {
        this.kanpoko_taldea = kanpoko_taldea;
    }

    public String getZelaia() {
        return zelaia;
    }

    public void setZelaia(String zelaia) {
        this.zelaia = zelaia;
    }

    public String getPartiduData() {
        return partiduData;
    }

    public void setPartiduData(String partiduData) {
        this.partiduData = partiduData;
    }

    public String getPartiduMota() {
        return partiduMota;
    }

    public void setPartiduMota(String partiduMota) {
        this.partiduMota = partiduMota;
    }

    public String getJardunaldia() {
        return jardunaldia;
    }

    public void setJardunaldia(String jardunaldia) {
        this.jardunaldia = jardunaldia;
    }

    // Izen zaharrak mantendu dira, baina orain set kopuruak itzultzen ditu puntuazio moduan
    public int getEtxekoTaldekoPuntuazioa() {
        return etxekoTaldekoSetak;
    }

    public void setEtxekoTaldekoPuntuazioa(int etxekoTaldekoSetak) {
        this.etxekoTaldekoSetak = etxekoTaldekoSetak;
        this.partiduaJokatuta = true; // Puntuazioak jarrita, partidua jokatu dela suposatu
    }

    public int getKanpokoTaldekoPuntuazioa() {
        return kanpokoTaldekoSetak;
    }

    public void setKanpokoTaldekoPuntuazioa(int kanpokoTaldekoSetak) {
        this.kanpokoTaldekoSetak = kanpokoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    public String getDenboraldia() {
        return denboraldia;
    }

    public void setDenboraldia(String denboraldia) {
        this.denboraldia = denboraldia;
    }

    public boolean isPartiduaJokatuta() {
        return partiduaJokatuta;
    }

    public void setPartiduaJokatuta(boolean partiduaJokatuta) {
        this.partiduaJokatuta = partiduaJokatuta;
    }

    // Set kopuruetarako getter eta setter berriak
    public int getEtxekoTaldekoSetak() {
        return etxekoTaldekoSetak;
    }

    public void setEtxekoTaldekoSetak(int etxekoTaldekoSetak) {
        this.etxekoTaldekoSetak = etxekoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    public int getKanpokoTaldekoSetak() {
        return kanpokoTaldekoSetak;
    }

    public void setKanpokoTaldekoSetak(int kanpokoTaldekoSetak) {
        this.kanpokoTaldekoSetak = kanpokoTaldekoSetak;
        this.partiduaJokatuta = true;
    }

    // ==================== DENBORALDIEN KONTROL STATIKOAK ====================

    public static String getUnekoDenboraldia() {
        return unekoDenboraldia;
    }

    public static void setUnekoDenboraldia(String denboraldia) {
        unekoDenboraldia = denboraldia;
    }

    public static boolean isDenboraldiaHasita() {
        return denboraldiaHasita;
    }

    public static void setDenboraldiaHasita(boolean hasita) {
        denboraldiaHasita = hasita;
    }

    /**
     * Denboraldi berri bat hasi daitekeen egiaztatzen du
     * @return true hasi daiteke, false dagoeneko hasi bada
     */
    public static boolean denboraldiaAmaituta() {
        if (unekoDenboraldia == null) {
            return true; // Ez dago denboraldi unekorik, hasi daiteke
        }
        
        List<Partidua> partiduak = getPartiduakByDenboraldia(unekoDenboraldia);
        if (partiduak.isEmpty()) {
            return true; // Ez dago partidurik denboraldi horretan
        }
        
        for (Partidua p : partiduak) {
            if (!p.isPartiduaJokatuta()) {
                return false; // Badago jokatu gabeko partidu bat
            }
        }
        return true; // Partidu guztiak jokatu dira
    }

    /**
     * Denboraldi berria hasi
     * @param denboraldiaBerria Hasi nahi den denboraldiaren izena
     * @return true hasi bada, false ezin bada hasi
     */
    public static boolean hasiDenboraldiaBerria(String denboraldiaBerria) {
        if (unekoDenboraldia != null && denboraldiaHasita) {
            return false; // Dagoeneko denboraldi bat hasi da
        }
        
        unekoDenboraldia = denboraldiaBerria;
        denboraldiaHasita = true;
        
        System.out.println("Denboraldi berria hasita: " + denboraldiaBerria);
        return true;
    }

    /**
     * Uneko denboraldia amaitu
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
     * Partidu bat gehitu partidu zerrendara
     */
    public static void gehituPartidua(Partidua p) {
        partiduakZerrenda.add(p);
    }

    /**
     * Partidu guztiak itzuli
     */
    public static ArrayList<Partidua> getPartiduakZerrenda() {
        return partiduakZerrenda;
    }

    /**
     * Partidu zerrenda berria ezarri
     */
    public static void setPartiduakZerrenda(ArrayList<Partidua> zerrenda) {
        partiduakZerrenda = zerrenda;
    }

    /**
     * Denboraldi eta jardunaldiaren arabera partiduak iragazi
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
     * Jardunaldi baten arabera partiduak lortu
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
     * Partidu guztiak lortu
     */
    public static List<Partidua> getPartiduakGuztiak() {
        return new ArrayList<>(partiduakZerrenda);
    }

    /**
     * Denboraldi bateko partiduak lortu
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
     * Egiaztatu denboraldi bat hasita dagoen (gutxienez partida bat jokatu den)
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
     * Egiaztatu denboraldi bateko partidu guztiak jokatu diren
     */
    public static boolean denboraldiaOsoaJokatuta(String denboraldia) {
        List<Partidua> partiduak = getPartiduakByDenboraldia(denboraldia);
        if (partiduak.isEmpty()) {
            return false; // Ez dago partidurik, beraz ez dago osorik
        }
        
        for (Partidua p : partiduak) {
            if (!p.isPartiduaJokatuta()) {
                return false; // Gutxienez partidu bat jokatu gabe dago
            }
        }
        return true; // Partidu guztiak jokatu dira
    }
    
    /**
     * Talde bat kodearen arabera bilatu eta itzuli
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

    @Override
    public String toString() {
        return etxeko_taldea + " vs " + kanpoko_taldea + " (" + etxekoTaldekoSetak + " - "
                + kanpokoTaldekoSetak + ") - " + denboraldia;
    }
}
