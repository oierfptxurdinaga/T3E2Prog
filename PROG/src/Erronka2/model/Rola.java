package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Erabiltzailearen rola kudeatzen duen klasea,
 * Erabiltzailea klasea hedatu eta rola motak barne hartzen ditu.
 */
public class Rola extends Erabiltzailea {
    private RolMota rola;  // Erabiltzailearen rola (ADMIN, EPAILEA, ERABILTZAILE)

    // Eraikitzaile huts
    public Rola() {
    }
    
    // Eraikitzaile datuak jasotzen dituena
    public Rola(String izena, String pasahitza, RolMota rolMota) {
        super(izena, pasahitza); 
        this.rola = rolMota;
    }

    // Getter eta Setter metodoak rolarako
    public RolMota getRola() {
        return rola;
    }

    public void setRola(RolMota rola) {
        this.rola = rola;
    }

    // Erabiltzaile zerrendaren getter eta setter estatikoak
    public static List<Rola> getErabiltzaileak() {
        return erabiltzaileak;
    }

    public static void setErabiltzaileak(List<Rola> erabiltzaileak) {
        Rola.erabiltzaileak = erabiltzaileak;
    }

    @Override
    public String toString() {
        return "Rola [rola=" + rola + "]";
    }

    // Erabiltzaile rolen enum mota, erabilgarri dauden rolen izenak
    public enum RolMota {
        ERABILTZAILE, ADMIN, EPAILEA
    }

    // Erabiltzaile guztien zerrenda estatikoa
    private static List<Rola> erabiltzaileak = new ArrayList<>();

    /**
     * Erabiltzaile hasieraketarako metodoa.
     * Zerrenda hutsik badago, lehenengo erabiltzaile batzuk gehitzen ditu.
     */
    public static void erabiltzaileakHasieratu() {
        if (erabiltzaileak.isEmpty()) { // Bakarrik gehitu hutsik badago
            erabiltzaileak.add(new Rola("Urtzi", "admin123", RolMota.ADMIN));
            erabiltzaileak.add(new Rola("Ekaitz", "admin123", RolMota.ADMIN));
            erabiltzaileak.add(new Rola("Irati", "admin123", RolMota.ADMIN));
            erabiltzaileak.add(new Rola("Oier", "epaile123", RolMota.EPAILEA));
            erabiltzaileak.add(new Rola("user", "user123", RolMota.ERABILTZAILE));
        }
    }

    /**
     * Erabiltzaile baten izena eta pasahitza egiaztatzen ditu.
     * @param izena Erabiltzailearen izena
     * @param pasahitza Pasahitza
     * @return Datuak baliozkoak badira Rola objektua, bestela null
     */
    public static Rola Egiaztatu(String izena, String pasahitza) {
        erabiltzaileakHasieratu();

        for (Rola r : erabiltzaileak) {
            if (r.getIzena().equals(izena) &&
                r.getPasahitza().equals(pasahitza)) {
                return r;
            }
        }
        return null;
    }
}
