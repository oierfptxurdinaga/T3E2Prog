package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Partidua modelatzen duen klasea
 */
public class Partidua {

    private int partidu_kod;
    private Taldeak etxeko_taldea;
    private Taldeak kanpoko_taldea;
    private String zelaia;
    private String partidudata;
    private String partiduMota;
    private String jardunaldia;
    private int etxekoTaldekoSetak; // Cambiado de puntuazioa a setak
    private int kanpokoTaldekoSetak; // Cambiado de puntuazioa a setak
    private String denboraldia;
    private boolean partiduaJokatuta; // Nuevo: indica si el partido se ha jugado

    // Partidu guztiak gordetzeko zerrenda
    private static ArrayList<Partidua> partiduakList = new ArrayList<>();
    
    // Control de temporadas
    private static String unekoDenboraldia = null; // Temporada actual
    private static boolean denboraldiaHasita = false; // Si la temporada ha empezado

    // ==================== ERAIKITZAILEAK ====================

    public Partidua() {
        this.partiduaJokatuta = false;
    }

    public Partidua(int partidu_kod, Taldeak etxeko_taldea, Taldeak kanpoko_taldea, String zelaia, String partidudata,
                    String partiduMota, String jardunaldia, int etxekoSetak, int kanpokoSetak, String denboraldia) {
        this.partidu_kod = partidu_kod;
        this.etxeko_taldea = etxeko_taldea;
        this.kanpoko_taldea = kanpoko_taldea;
        this.zelaia = zelaia;
        this.partidudata = partidudata;
        this.partiduMota = partiduMota;
        this.jardunaldia = jardunaldia;
        this.etxekoTaldekoSetak = etxekoSetak;
        this.kanpokoTaldekoSetak = kanpokoSetak;
        this.denboraldia = denboraldia;
        this.partiduaJokatuta = (etxekoSetak > 0 || kanpokoSetak > 0);
    }

    // ==================== GETTER ETA SETTER ====================

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

    public String getPartidudata() {
        return partidudata;
    }

    public void setPartidudata(String partidudata) {
        this.partidudata = partidudata;
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

    // Mantenemos compatibilidad con el nombre antiguo pero ahora devuelve sets
    public int getEtxekoTaldekoPuntuazioa() {
        return etxekoTaldekoSetak;
    }

    public void setEtxekoTaldekoPuntuazioa(int etxekoTaldekoSetak) {
        this.etxekoTaldekoSetak = etxekoTaldekoSetak;
        this.partiduaJokatuta = true;
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

    // Nuevos getters para sets
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

    // ==================== METODOS ESTATICOS PARA CONTROL DE TEMPORADAS ====================

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

    // Método para verificar si se puede iniciar una nueva temporada
    public static boolean denboraldiaAmaituta() {
        // Si no hay temporada actual, se considera "terminada" (se puede empezar nueva)
        if (unekoDenboraldia == null) {
            return true;
        }
        
        // Si hay temporada actual, verificar si todos los partidos están jugados
        List<Partidua> partiduak = getPartiduakByDenboraldia(unekoDenboraldia);
        if (partiduak.isEmpty()) {
            return true; // No hay partidos, se puede terminar
        }
        
        for (Partidua p : partiduak) {
            if (!p.isPartiduaJokatuta()) {
                return false; // Hay partidos sin jugar
            }
        }
        return true; // Todos los partidos jugados
    }

    // Método para iniciar una nueva temporada - SIMPLIFICADO
    public static boolean hasiDenboraldiaBerria(String denboraldiaBerria) {
        // Siempre se puede iniciar una nueva temporada
        unekoDenboraldia = denboraldiaBerria;
        denboraldiaHasita = true;
        
        System.out.println("Nueva temporada iniciada: " + denboraldiaBerria);
        return true;
    }

    // Método para terminar la temporada actual - SIMPLIFICADO
    public static void amaituDenboraldia() {
        System.out.println("Temporada terminada: " + unekoDenboraldia);
        
        // Solo resetear el estado de que la temporada ha empezado
        denboraldiaHasita = false;
        // NO resetear unekoDenboraldia para mantener el historial
    }

    // ==================== PARTIDUEN KUDEAKETA ====================

    public static void gehituPartidua(Partidua p) {
        partiduakList.add(p);
    }

    public static ArrayList<Partidua> getPartiduakList() {
        return partiduakList;
    }

    public static void setPartiduakList(ArrayList<Partidua> lista) {
        partiduakList = lista;
    }

    // Método para filtrar por temporada y jornada
    public static List<Partidua> getPartiduakByDenboraldiaAndJardunaldia(String denboraldia, String jardunaldia) {
        List<Partidua> emaitza = new ArrayList<>();
        for (Partidua p : partiduakList) {
            boolean denboraldiaBerdina = (denboraldia == null || denboraldia.isEmpty() || 
                                         p.getDenboraldia().equals(denboraldia));
            boolean jardunaldiaBerdina = (jardunaldia == null || jardunaldia.isEmpty() || 
                                         p.getJardunaldia().equals(jardunaldia));
            
            if (denboraldiaBerdina && jardunaldiaBerdina) {
                emaitza.add(p);
            }
        }
        return emaitza;
    }

    // Método nuevo: Obtener partidos por jornada
    public static List<Partidua> getPartiduakByJardunaldia(String jardunaldia) {
        List<Partidua> emaitza = new ArrayList<>();
        for (Partidua p : partiduakList) {
            if (p.getJardunaldia().equals(jardunaldia)) {
                emaitza.add(p);
            }
        }
        return emaitza;
    }

    // Método nuevo: Obtener todos los partidos
    public static List<Partidua> getPartiduakGuztiak() {
        return new ArrayList<>(partiduakList);
    }

    // Método para obtener partidos de una temporada específica
    public static List<Partidua> getPartiduakByDenboraldia(String denboraldia) {
        List<Partidua> emaitza = new ArrayList<>();
        for (Partidua p : partiduakList) {
            if (p.getDenboraldia().equals(denboraldia)) {
                emaitza.add(p);
            }
        }
        return emaitza;
    }

    // Método para verificar si una temporada ha empezado (tiene partidos jugados)
    public static boolean denboraldiaHasita(String denboraldia) {
        List<Partidua> partiduak = getPartiduakByDenboraldia(denboraldia);
        for (Partidua p : partiduak) {
            if (p.isPartiduaJokatuta()) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar si todos los partidos de una temporada están jugados
    public static boolean denboraldiaOsoaJokatuta(String denboraldia) {
        List<Partidua> partiduak = getPartiduakByDenboraldia(denboraldia);
        if (partiduak.isEmpty()) {
            return false; // Si no hay partidos programados, no está completa
        }
        
        for (Partidua p : partiduak) {
            if (!p.isPartiduaJokatuta()) {
                return false; // Hay al menos un partido sin jugar
            }
        }
        return true;
    }

    // ==================== BESTEAK ====================

    @Override
    public String toString() {
        return etxeko_taldea + " vs " + kanpoko_taldea + " (" + etxekoTaldekoSetak + " - "
                + kanpokoTaldekoSetak + ") - " + denboraldia;
    }
}