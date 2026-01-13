package Erronka2.model;

import java.util.ArrayList;
import java.util.List;

public class Rola extends Erabiltzailea {
	private RolMota rola;

	public Rola() {
	}
	
    // Eraikitzailea
	public Rola(String izena, String pasahitza, RolMota rolMota) {
		super(izena, pasahitza); 
		this.rola = rolMota;
		}

	// Getters eta Setters
	public RolMota getRola() {
		return rola;
	}

	public void setRola(RolMota rola) {
		this.rola = rola;
	}

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

	public enum RolMota {
		ERABILTZAILE, ADMIN, EPAILEA
	}

	private static List<Rola> erabiltzaileak = new ArrayList<>();


	// Hauek izango dira gure erabiltzailearen izena, pasahitza eta rol mota
	public static void erabiltzaileakHasieratu() {
	    if (erabiltzaileak.isEmpty()) { // Solo agrega si está vacía
	        erabiltzaileak.add(new Rola("Urtzi", "admin123", RolMota.ADMIN));
	        erabiltzaileak.add(new Rola("Ekaitz", "admin123", RolMota.ADMIN));
	        erabiltzaileak.add(new Rola("Irati", "admin123", RolMota.ADMIN));
	        erabiltzaileak.add(new Rola("Oier", "epaile123", RolMota.EPAILEA));
	        erabiltzaileak.add(new Rola("user", "user123", RolMota.ERABILTZAILE));
	    }
	}

	// Metodoa hau rola egiaztatzeko
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