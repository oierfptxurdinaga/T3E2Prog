package Erronka2.model;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Taldeak extends Jokalaria {
	private int talde_kod;
	private String izena;
	private String entrenatzailea;
	private String kokapena;
	private String zelaia;

	public Taldeak() {
	}

	public Taldeak(int talde_kod, String izena, String kokapena, String entrenatzailea, String zelaia) {
		this.izena = izena;
		this.talde_kod = talde_kod;
		this.kokapena = kokapena;
		this.entrenatzailea = entrenatzailea;
		this.zelaia = zelaia;
	}

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

	public String getkokapena() {
		return kokapena;
	}

	public void setkokapena(String kokapena) {
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

	@Override
	public String toString() {
		return izena;
	}

	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Taldeak)) return false;
	        Taldeak t = (Taldeak) obj;
	        return this.izena.equals(t.izena);
	    }
	
	
	
	public class TaldeFactory {

		public static List<Taldeak> sortuTaldeak() {
			List<Taldeak> lista = new ArrayList<>();

			lista.add(new Taldeak(0,"-", "", "", ""));

			lista.add(new Taldeak(1, "Otxarkoaga Distira", "", "", ""));
			lista.add(new Taldeak(2, "Miribilla Uhinen Jokoak", "", "", ""));
			lista.add(new Taldeak(3, "Txurdinaga Harriak", "", "", ""));
			lista.add(new Taldeak(4, "Usansolo Hortzadak", "", "", ""));
			lista.add(new Taldeak(5, "Matiko Txirrindulariak", "", "", ""));
			lista.add(new Taldeak(6, "Santutxu Haizeak", "", "", ""));

			return lista;
		}
	}
	
	// Método para obtener un talde por su nombre
	public static Taldeak getTaldeaByIzena(String izena) {
		List<Taldeak> taldeak = TaldeFactory.sortuTaldeak();
		for (Taldeak taldea : taldeak) {
			if (taldea.getIzena().equals(izena)) {
				return taldea;
			}
		}
		return null;
	}

}