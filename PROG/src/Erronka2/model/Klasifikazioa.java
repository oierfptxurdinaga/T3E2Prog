package Erronka2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Klasifikazioa {
    
    private static Map<Taldeak, TaldearenKlasifikazioa> klasifikazioaMap = new HashMap<>();
    
    static {
        inicializatuKlasifikazioa();
    }
    
    private static void inicializatuKlasifikazioa() {
        klasifikazioaMap.clear();
        List<Taldeak> taldeak = Taldeak.TaldeFactory.sortuTaldeak();
        for (Taldeak taldea : taldeak) {
            if (!taldea.getIzena().equals("-")) { // Excluir el placeholder
                klasifikazioaMap.put(taldea, new TaldearenKlasifikazioa(taldea));
            }
        }
    }
    
    public static void eguneratuPartiduarekin(Partidua partidua) {
        Taldeak etxekoa = partidua.getEtxeko_taldea();
        Taldeak kanpokoa = partidua.getKanpoko_taldea();
        
        int etxekoSetak = partidua.getEtxekoTaldekoSetak();
        int kanpokoSetak = partidua.getKanpokoTaldekoSetak();
        
        // Obtener o crear las estadísticas de cada equipo
        TaldearenKlasifikazioa etxekoKlasifikazioa = klasifikazioaMap.get(etxekoa);
        TaldearenKlasifikazioa kanpokoKlasifikazioa = klasifikazioaMap.get(kanpokoa);
        
        if (etxekoKlasifikazioa == null) {
            etxekoKlasifikazioa = new TaldearenKlasifikazioa(etxekoa);
            klasifikazioaMap.put(etxekoa, etxekoKlasifikazioa);
        }
        
        if (kanpokoKlasifikazioa == null) {
            kanpokoKlasifikazioa = new TaldearenKlasifikazioa(kanpokoa);
            klasifikazioaMap.put(kanpokoa, kanpokoKlasifikazioa);
        }
        
        // Ambos equipos han jugado un partido
        etxekoKlasifikazioa.gehitupartidaJokatua();
        kanpokoKlasifikazioa.gehitupartidaJokatua();
        
        // Añadir sets ganados y perdidos
        etxekoKlasifikazioa.gehituSetakIrabaziak(etxekoSetak);
        etxekoKlasifikazioa.gehituSetakGalduak(kanpokoSetak);
        
        kanpokoKlasifikazioa.gehituSetakIrabaziak(kanpokoSetak);
        kanpokoKlasifikazioa.gehituSetakGalduak(etxekoSetak);
        
        // Determinar el ganador (mejor de 5 sets)
        if (etxekoSetak > kanpokoSetak) {
            etxekoKlasifikazioa.gehitupartidaIrabazia();
            kanpokoKlasifikazioa.gehitupartidaGaldua();
        } else if (etxekoSetak < kanpokoSetak) {
            kanpokoKlasifikazioa.gehitupartidaIrabazia();
            etxekoKlasifikazioa.gehitupartidaGaldua();
        } else {
            // Empate (raro en voleibol al mejor de 5)
            // No se suman puntos por empate
        }
    }
    
    public static List<TaldearenKlasifikazioa> getKlasifikazioaOrdenatua() {
        List<TaldearenKlasifikazioa> klasifikazioa = new ArrayList<>(klasifikazioaMap.values());
        
        // Ordenar por puntos (descendente), luego por diferencia de sets, luego por sets ganados
        Collections.sort(klasifikazioa, new Comparator<TaldearenKlasifikazioa>() {
            @Override
            public int compare(TaldearenKlasifikazioa t1, TaldearenKlasifikazioa t2) {
                // Primero por puntos
                if (t1.getPuntuak() != t2.getPuntuak()) {
                    return Integer.compare(t2.getPuntuak(), t1.getPuntuak()); // descendente
                }
                // Si hay empate, por diferencia de sets
                if (t1.getSetDiferentzia() != t2.getSetDiferentzia()) {
                    return Integer.compare(t2.getSetDiferentzia(), t1.getSetDiferentzia());
                }
                // Si aún hay empate, por sets ganados
                if (t1.getSetakIrabaziak() != t2.getSetakIrabaziak()) {
                    return Integer.compare(t2.getSetakIrabaziak(), t1.getSetakIrabaziak());
                }
                // Si aún hay empate, por partidos ganados
                if (t1.getPartidaIrabaziak() != t2.getPartidaIrabaziak()) {
                    return Integer.compare(t2.getPartidaIrabaziak(), t1.getPartidaIrabaziak());
                }
                // Por último, por nombre
                return t1.getTaldea().getIzena().compareTo(t2.getTaldea().getIzena());
            }
        });
        
        return klasifikazioa;
    }
    
    // Método para resetear la clasificación para nueva temporada
    public static void reset() {
        inicializatuKlasifikazioa();
    }
    
    // Método para inicializar desde partidos existentes de una temporada específica
    public static void inicializatuPartiduetatik(String denboraldia) {
        reset();
        List<Partidua> partiduak = Partidua.getPartiduakByDenboraldia(denboraldia);
        for (Partidua partidua : partiduak) {
            if (partidua.isPartiduaJokatuta()) {
                eguneratuPartiduarekin(partidua);
            }
        }
    }
}