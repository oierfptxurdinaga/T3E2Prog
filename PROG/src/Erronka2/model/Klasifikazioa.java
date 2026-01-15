package Erronka2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Klasifikazioa implements Serializable {
    // Serializable interfazeak objektuak gordetzeko aukera ematen du
    private static final long serialVersionUID = 1L;
    
    // Talde bakoitzaren klasifikazioa gordetzeko mapa: talde->klasifikazioa
    private static Map<Taldeak, TaldearenKlasifikazioa> klasifikazioaMap = new HashMap<>();
    
    // Static blokean klasifikazioa hasieratu talde guztiekin
    static {
        berrabiarazi();
    }
    
    /**
     * Klasifikazioa berrabiarazi: mapa garbitu eta talde guztiak berriro gehitu
     */
    public static void berrabiarazi() {
        klasifikazioaMap.clear();
        List<Taldeak> taldeak = Taldeak.TaldeFactory.sortuTaldeak();
        for (Taldeak taldea : taldeak) {
            if (taldea.getTalde_kod() != 0) { // "-" placeholder-a baztertu
                klasifikazioaMap.put(taldea, new TaldearenKlasifikazioa(taldea));
            }
        }
    }
    
    /**
     * Klasifikazioa hasieratu denboraldi bateko partiduetatik
     * @param denboraldia Denboraldiaren izena/identifikatzailea
     */
    public static void hasieratuPartiduetatik(String denboraldia) {
        berrabiarazi();
        
        List<Partidua> partiduak = Partidua.getPartiduakByDenboraldia(denboraldia);
        if (partiduak == null) return;
        
        // Jokatuta dauden partiduen arabera klasifikazioa eguneratu
        for (Partidua partidua : partiduak) {
            if (partidua.isPartiduaJokatuta()) {
                eguneratuPartiduarekin(partidua);
            }
        }
    }
    
    /**
     * Klasifikazioa eguneratu partidu batekin
     * @param partidua Partidua, beharrezkoa jokatu izana
     */
    public static void eguneratuPartiduarekin(Partidua partidua) {
        if (partidua == null || !partidua.isPartiduaJokatuta()) {
            return;
        }
        
        Taldeak etxekoTaldea = partidua.getEtxeko_taldea();
        Taldeak kanpokoTaldea = partidua.getKanpoko_taldea();
        
        if (etxekoTaldea == null || kanpokoTaldea == null) {
            return;
        }
        
        TaldearenKlasifikazioa etxekoa = klasifikazioaMap.get(etxekoTaldea);
        TaldearenKlasifikazioa kanpokoa = klasifikazioaMap.get(kanpokoTaldea);
        
        if (etxekoa == null || kanpokoa == null) {
            return;
        }
        
        // Partida jokatu kopurua handitu
        etxekoa.gehitupartidaJokatua();
        kanpokoa.gehitupartidaJokatua();
        
        // Set kopuruak eguneratu irabazi eta galdu moduan
        int etxekoSets = partidua.getEtxekoTaldekoSetak();
        int kanpokoSets = partidua.getKanpokoTaldekoSetak();
        
        etxekoa.gehituSetakIrabaziak(etxekoSets);
        etxekoa.gehituSetakGalduak(kanpokoSets);
        
        kanpokoa.gehituSetakIrabaziak(kanpokoSets);
        kanpokoa.gehituSetakGalduak(etxekoSets);
        
        // Irabazlea eta galdulea ezarri puntuazioak eguneratzeko
        if (etxekoSets > kanpokoSets) {
            etxekoa.gehitupartidaIrabazia();
            kanpokoa.gehitupartidaGaldua();
        } else {
            kanpokoa.gehitupartidaIrabazia();
            etxekoa.gehitupartidaGaldua();
        }
    }
    
    /**
     * Ordenatutako klasifikazioa itzuli:
     *  - Lehen puntuak,
     *  - Ondoren seten diferentzia,
     *  - Eta azkenik set irabaziak kontuan hartuta
     */
    public static List<TaldearenKlasifikazioa> getKlasifikazioaOrdenatua() {
        List<TaldearenKlasifikazioa> ordenatua = new ArrayList<>(klasifikazioaMap.values());
        
        Collections.sort(ordenatua, new Comparator<TaldearenKlasifikazioa>() {
            @Override
            public int compare(TaldearenKlasifikazioa t1, TaldearenKlasifikazioa t2) {
                int puntuakDiff = t2.getPuntuak() - t1.getPuntuak();
                if (puntuakDiff != 0) {
                    return puntuakDiff;
                }
                
                int setDiffDiff = t2.getSetDiferentzia() - t1.getSetDiferentzia();
                if (setDiffDiff != 0) {
                    return setDiffDiff;
                }
                
                return t2.getSetakIrabaziak() - t1.getSetakIrabaziak();
            }
        });
        
        return ordenatua;
    }
    
    /**
     * Talde zehatz baten klasifikazioa itzuli
     * @param taldea Klasifikazioa nahi den taldea
     * @return TaldearenKlasifikazioa objektua edo null
     */
    public static TaldearenKlasifikazioa getKlasifikazioaTaldea(Taldeak taldea) {
        return klasifikazioaMap.get(taldea);
    }
    
    /**
     * Egiaztatu klasifikazioa hutsik dagoen
     * @return true hutsik bada, bestela false
     */
    public static boolean isEmpty() {
        return klasifikazioaMap.isEmpty();
    }
}
