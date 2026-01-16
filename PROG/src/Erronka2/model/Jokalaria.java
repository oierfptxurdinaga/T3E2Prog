package Erronka2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Jokalaria klasea, jokalari baten oinarrizko informazioa eta jokalarien zerrenda kudeatzen dituena.
 * <p>
 * Klase honek jokalariaren datuak gordetzen ditu eta jokalariak taldearen arabera kudeatzeko metodoak eskaintzen ditu.
 * </p>
 */
public class Jokalaria implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Jokalariaren identifikatzailea.
     */
    private int jokalarikod;

    /**
     * Jokalariaren izena.
     */
    private String izena;

    /**
     * Jokalariaren NAN.
     */
    private String nan;

    /**
     * Jokalariaren jaiotze data.
     */
    private Date jaiotzeData;

    /**
     * Jokalariaren rola taldean.
     */
    private String jokalariRola;

    /**
     * Jokalariaren taldearen kodea.
     */
    private int taldeKod;

    /**
     * Jokalari guztiak gordetzeko zerrenda.
     */
    private static List<Jokalaria> jokalariak;

    static {
        jokalariak = sortuJokalariak();
    }

    /**
     * Eraikitzaile hutsak, objektua sortzeko erabil daiteke.
     */
    public Jokalaria() {
    }

    /**
     * Eraikitzaile parametrizatuak, jokalariaren datuak ezartzeko.
     *
     * @param jokalarikod Jokalariaren identifikatzailea
     * @param nan         Jokalariaren NAN
     * @param izena       Jokalariaren izena
     * @param jaiotzeData Jokalariaren jaiotze data
     * @param jokalariRola Jokalariaren rola
     * @param taldeKod    Jokalariaren taldea kodez
     */
    public Jokalaria(int jokalarikod, String nan, String izena, Date jaiotzeData, String jokalariRola, int taldeKod) {
        this.jokalarikod = jokalarikod;
        this.nan = nan;
        this.izena = izena;
        this.jaiotzeData = jaiotzeData;
        this.jokalariRola = jokalariRola;
        this.taldeKod = taldeKod;
    }

    /**
     * Jokalariaren identifikatzailea itzultzen du.
     *
     * @return Jokalariaren kodea
     */
    public int getJokalarikod() {
        return jokalarikod;
    }

    /**
     * Jokalariaren identifikatzailea ezartzen du.
     *
     * @param jokalarikod Jokalariaren kode berria
     */
    public void setJokalarikod(int jokalarikod) {
        this.jokalarikod = jokalarikod;
    }

    /**
     * Jokalariaren NAN itzultzen du.
     *
     * @return Jokalariaren NAN
     */
    public String getNan() {
        return nan;
    }

    /**
     * Jokalariaren NAN ezartzen du.
     *
     * @param nan Jokalariaren NAN berria
     */
    public void setNan(String nan) {
        this.nan = nan;
    }

    /**
     * Jokalariaren izena itzultzen du.
     *
     * @return Jokalariaren izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Jokalariaren izena ezartzen du.
     *
     * @param izena Jokalariaren izena berria
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Jokalariaren jaiotze data itzultzen du.
     *
     * @return Jaiotze data
     */
    public Date getJaiotzeData() {
        return jaiotzeData;
    }

    /**
     * Jokalariaren jaiotze data ezartzen du.
     *
     * @param jaiotzeData Jaiotze data berria
     */
    public void setJaiotzeData(Date jaiotzeData) {
        this.jaiotzeData = jaiotzeData;
    }

    /**
     * Jokalariaren rola itzultzen du.
     *
     * @return Jokalariaren rola
     */
    public String getJokalariRola() {
        return jokalariRola;
    }

    /**
     * Jokalariaren rola ezartzen du.
     *
     * @param jokalariRola Jokalariaren rola berria
     */
    public void setJokalariRola(String jokalariRola) {
        this.jokalariRola = jokalariRola;
    }

    /**
     * Jokalariaren taldea kodez itzultzen du.
     *
     * @return Taldearen kodea
     */
    public int getTaldeKod() {
        return taldeKod;
    }

    /**
     * Jokalariaren taldea kodez ezartzen du.
     *
     * @param taldeKod Taldearen kode berria
     */
    public void setTaldeKod(int taldeKod) {
        this.taldeKod = taldeKod;
    }

    /**
     * Jokalariaren informazioa string moduan itzultzen du.
     *
     * @return Jokalariaren izena eta rola
     */
    @Override
    public String toString() {
        return izena + " - " + jokalariRola;
    }

    /**
     * Jokalari guztiak sortzen dituen metodo laguntzailea.
     *
     * @return Jokalari zerrenda
     */

    // Jokalari guztiak sortzeko
    private static List<Jokalaria> sortuJokalariak() {
        List<Jokalaria> jokalarienZerrenda = new ArrayList<>();

        // Jaiotze data bat simulatu (doitu dezakezu)
        Date jaiotzeData = new Date();

        // 1. Otxarkoaga Distira (taldeKod = 1)
        jokalarienZerrenda.add(new Jokalaria(1, "11111111A", "Iker Arrieta", jaiotzeData, "Armador", 1));
        jokalarienZerrenda.add(new Jokalaria(2, "11111111B", "Maialen Bilbao", jaiotzeData, "Opuesta", 1));
        jokalarienZerrenda.add(new Jokalaria(3, "11111111C", "Ander Mendieta", jaiotzeData, "Central", 1));
        jokalarienZerrenda.add(new Jokalaria(4, "11111111D", "Ane Larrinaga", jaiotzeData, "Receptora/Atacante", 1));
        jokalarienZerrenda.add(new Jokalaria(5, "11111111E", "Jon Zubia", jaiotzeData, "Central", 1));
        jokalarienZerrenda.add(new Jokalaria(6, "11111111F", "Oihana Goikoetxea", jaiotzeData, "Líbero", 1));
        jokalarienZerrenda.add(new Jokalaria(7, "11111111G", "Unai Aguirre", jaiotzeData, "Armador Suplente", 1));
        jokalarienZerrenda.add(new Jokalaria(8, "11111111H", "Nerea Ruiz", jaiotzeData, "Opuesta Suplente", 1));
        jokalarienZerrenda.add(new Jokalaria(9, "11111111I", "Iker Goikoetxea", jaiotzeData, "Central Suplente", 1));
        jokalarienZerrenda
                .add(new Jokalaria(10, "11111111J", "Irati Etxebarria", jaiotzeData, "Receptora/Atacante Suplente", 1));
        jokalarienZerrenda.add(new Jokalaria(11, "11111111K", "Mikel Laka", jaiotzeData, "Central Suplente", 1));
        jokalarienZerrenda.add(new Jokalaria(12, "11111111L", "Ane Goikoetxea", jaiotzeData, "Líbero Suplente", 1));

        // 2. Miribilla Uhinen Jokoak (taldeKod = 2)
        jokalarienZerrenda.add(new Jokalaria(13, "22222222A", "Jon Zubizarreta", jaiotzeData, "Armador", 2));
        jokalarienZerrenda.add(new Jokalaria(14, "22222222B", "Leire Etxeberria", jaiotzeData, "Opuesta", 2));
        jokalarienZerrenda.add(new Jokalaria(15, "22222222C", "Imanol Bilbao", jaiotzeData, "Central", 2));
        jokalarienZerrenda.add(new Jokalaria(16, "22222222D", "Naiara Goitia", jaiotzeData, "Receptora/Atacante", 2));
        jokalarienZerrenda.add(new Jokalaria(17, "22222222E", "Gorka Mendizábal", jaiotzeData, "Central", 2));
        jokalarienZerrenda.add(new Jokalaria(18, "22222222F", "Ainhoa Urkijo", jaiotzeData, "Líbero", 2));
        jokalarienZerrenda.add(new Jokalaria(19, "22222222G", "Unai Arruabarrena", jaiotzeData, "Armador Suplente", 2));
        jokalarienZerrenda.add(new Jokalaria(20, "22222222H", "Maite Aranburu", jaiotzeData, "Opuesta Suplente", 2));
        jokalarienZerrenda.add(new Jokalaria(21, "22222222I", "Ander Goienetxea", jaiotzeData, "Central Suplente", 2));
        jokalarienZerrenda
                .add(new Jokalaria(22, "22222222J", "Irati Etxebarria", jaiotzeData, "Receptora/Atacante Suplente", 2));
        jokalarienZerrenda.add(new Jokalaria(23, "22222222K", "Mikel Laka", jaiotzeData, "Central Suplente", 2));
        jokalarienZerrenda.add(new Jokalaria(24, "22222222L", "Oihana Zabaleta", jaiotzeData, "Líbero Suplente", 2));

        // 3. Txurdinaga Harriak (taldeKod = 3)
        jokalarienZerrenda.add(new Jokalaria(25, "33333333A", "Unai Arruabarrena", jaiotzeData, "Armador", 3));
        jokalarienZerrenda.add(new Jokalaria(26, "33333333B", "Maite Aranburu", jaiotzeData, "Opuesta", 3));
        jokalarienZerrenda.add(new Jokalaria(27, "33333333C", "Ander Goienetxea", jaiotzeData, "Central", 3));
        jokalarienZerrenda.add(new Jokalaria(28, "33333333D", "Irati Etxebarria", jaiotzeData, "Receptora/Atacante", 3));
        jokalarienZerrenda.add(new Jokalaria(29, "33333333E", "Mikel Laka", jaiotzeData, "Central", 3));
        jokalarienZerrenda.add(new Jokalaria(30, "33333333F", "Oihana Zabaleta", jaiotzeData, "Líbero", 3));
        jokalarienZerrenda.add(new Jokalaria(31, "33333333G", "Aitor Bilbao", jaiotzeData, "Armador Suplente", 3));
        jokalarienZerrenda.add(new Jokalaria(32, "33333333H", "Leire Mendieta", jaiotzeData, "Opuesta Suplente", 3));
        jokalarienZerrenda.add(new Jokalaria(33, "33333333I", "Iker Bilbao", jaiotzeData, "Central Suplente", 3));
        jokalarienZerrenda
                .add(new Jokalaria(34, "33333333J", "Ane Goikoetxea", jaiotzeData, "Receptora/Atacante Suplente", 3));
        jokalarienZerrenda.add(new Jokalaria(35, "33333333K", "Jon Uranga", jaiotzeData, "Central Suplente", 3));
        jokalarienZerrenda.add(new Jokalaria(36, "33333333L", "Maialen Zubia", jaiotzeData, "Líbero Suplente", 3));

        // 4. Usansolo Hortzadak (taldeKod = 4)
        jokalarienZerrenda.add(new Jokalaria(37, "44444444A", "Gorka Arriola", jaiotzeData, "Armador", 4));
        jokalarienZerrenda.add(new Jokalaria(38, "44444444B", "Leire Mendieta", jaiotzeData, "Opuesta", 4));
        jokalarienZerrenda.add(new Jokalaria(39, "44444444C", "Iker Bilbao", jaiotzeData, "Central", 4));
        jokalarienZerrenda.add(new Jokalaria(40, "44444444D", "Ane Goikoetxea", jaiotzeData, "Receptora/Atacante", 4));
        jokalarienZerrenda.add(new Jokalaria(41, "44444444E", "Jon Uranga", jaiotzeData, "Central", 4));
        jokalarienZerrenda.add(new Jokalaria(42, "44444444F", "Maialen Zubia", jaiotzeData, "Líbero", 4));
        jokalarienZerrenda.add(new Jokalaria(43, "44444444G", "Aitor Goikoetxea", jaiotzeData, "Armador Suplente", 4));
        jokalarienZerrenda.add(new Jokalaria(44, "44444444H", "Nerea Ruiz", jaiotzeData, "Opuesta Suplente", 4));
        jokalarienZerrenda.add(new Jokalaria(45, "44444444I", "Unai Etxebarria", jaiotzeData, "Central Suplente", 4));
        jokalarienZerrenda
                .add(new Jokalaria(46, "44444444J", "Irati Mendizábal", jaiotzeData, "Receptora/Atacante Suplente", 4));
        jokalarienZerrenda.add(new Jokalaria(47, "44444444K", "Mikel Laka", jaiotzeData, "Central Suplente", 4));
        jokalarienZerrenda.add(new Jokalaria(48, "44444444L", "Ane Larrinaga", jaiotzeData, "Líbero Suplente", 4));

        // 5. Matiko Txirrindulariak (taldeKod = 5)
        jokalarienZerrenda.add(new Jokalaria(49, "55555555A", "Aitor Etxebarria", jaiotzeData, "Armador", 5));
        jokalarienZerrenda.add(new Jokalaria(50, "55555555B", "Nerea Ruiz", jaiotzeData, "Opuesta", 5));
        jokalarienZerrenda.add(new Jokalaria(51, "55555555C", "Iker Goikoetxea", jaiotzeData, "Central", 5));
        jokalarienZerrenda.add(new Jokalaria(52, "55555555D", "Maialen Arrieta", jaiotzeData, "Receptora/Atacante", 5));
        jokalarienZerrenda.add(new Jokalaria(53, "55555555E", "Unai Aguirre", jaiotzeData, "Central", 5));
        jokalarienZerrenda.add(new Jokalaria(54, "55555555F", "Ane Larrinaga", jaiotzeData, "Líbero", 5));
        jokalarienZerrenda.add(new Jokalaria(55, "55555555G", "Jon Zubizarreta", jaiotzeData, "Armador Suplente", 5));
        jokalarienZerrenda.add(new Jokalaria(56, "55555555H", "Leire Etxeberria", jaiotzeData, "Opuesta Suplente", 5));
        jokalarienZerrenda.add(new Jokalaria(57, "55555555I", "Ander Goienetxea", jaiotzeData, "Central Suplente", 5));
        jokalarienZerrenda
                .add(new Jokalaria(58, "55555555J", "Irati Mendizábal", jaiotzeData, "Receptora/Atacante Suplente", 5));
        jokalarienZerrenda.add(new Jokalaria(59, "55555555K", "Mikel Laka", jaiotzeData, "Central Suplente", 5));
        jokalarienZerrenda.add(new Jokalaria(60, "55555555L", "Oihana Zabaleta", jaiotzeData, "Líbero Suplente", 5));

        // 6. Santutxu Haizeak (taldeKod = 6)
        jokalarienZerrenda.add(new Jokalaria(61, "66666666A", "Aitor Bilbao", jaiotzeData, "Armador", 6));
        jokalarienZerrenda.add(new Jokalaria(62, "66666666B", "Oihana Aranburu", jaiotzeData, "Opuesta", 6));
        jokalarienZerrenda.add(new Jokalaria(63, "66666666C", "Mikel Etxebarria", jaiotzeData, "Central", 6));
        jokalarienZerrenda.add(new Jokalaria(64, "66666666D", "Irati Mendizábal", jaiotzeData, "Receptora/Atacante", 6));
        jokalarienZerrenda.add(new Jokalaria(65, "66666666E", "Unai Goitia", jaiotzeData, "Central", 6));
        jokalarienZerrenda.add(new Jokalaria(66, "66666666F", "Leire Zabaleta", jaiotzeData, "Líbero", 6));
        jokalarienZerrenda.add(new Jokalaria(67, "66666666G", "Jon Zubia", jaiotzeData, "Armador Suplente", 6));
        jokalarienZerrenda.add(new Jokalaria(68, "66666666H", "Maite Aranburu", jaiotzeData, "Opuesta Suplente", 6));
        jokalarienZerrenda.add(new Jokalaria(69, "66666666I", "Ander Goienetxea", jaiotzeData, "Central Suplente", 6));
        jokalarienZerrenda
                .add(new Jokalaria(70, "66666666J", "Ane Larrinaga", jaiotzeData, "Receptora/Atacante Suplente", 6));
        jokalarienZerrenda.add(new Jokalaria(71, "66666666K", "Mikel Laka", jaiotzeData, "Central Suplente", 6));
        jokalarienZerrenda.add(new Jokalaria(72, "66666666L", "Oihana Goikoetxea", jaiotzeData, "Líbero Suplente", 6));

        return jokalarienZerrenda;
    }
    
    /**
     * Talde baten jokalariak lortzen ditu talde kodearen arabera.
     *
     * @param taldeKod Taldearen kodea
     * @return Taldeko jokalarien zerrenda
     * @throws IllegalArgumentException Talde kodea baliogabea bada
     * @throws IllegalStateException    Jokalari zerrenda nulua bada
     */
    public static List<Jokalaria> getJokalariakByTaldea(int taldeKod) {
        if (taldeKod < 0 || taldeKod > 6) {
            throw new IllegalArgumentException("Talde kode baliogabea: " + taldeKod);
        }
        if (jokalariak == null) {
            throw new IllegalStateException("Jokalarien zerrenda nulua da.");
        }
        List<Jokalaria> emaitza = new ArrayList<>();
        for (Jokalaria j : jokalariak) {
            if (j != null && j.getTaldeKod() == taldeKod) {
                emaitza.add(j);
            }
        }
        return emaitza;
    }

    /**
     * Jokalaria traspasatzeko metodoa.
     *
     * @param jokalaria       Traspasatu nahi den jokalaria
     * @param taldeHelburuKod Talde helburua kodez
     * @return true, traspasatzea ondo burutu bada
     * @throws IllegalArgumentException jokalaria null bada edo talde kodea baliogabea bada
     * @throws IllegalStateException    jokalaria dagoeneko talde horretan badago edo ez badago datu basean
     * @throws RuntimeException         errore orokorra eguneratzean
     */
    public static boolean traspasatuJokalaria(Jokalaria jokalaria, int taldeHelburuKod) {
        if (jokalaria == null) {
            throw new IllegalArgumentException("Jokalaria ezin da nulua izan.");
        }
        if (taldeHelburuKod < 1 || taldeHelburuKod > 6) {
            throw new IllegalArgumentException("Talde kode baliogabea: " + taldeHelburuKod);
        }
        if (jokalaria.getTaldeKod() == taldeHelburuKod) {
            throw new IllegalStateException("Jokalaria dagoeneko talde honetan dago.");
        }
        boolean jokalariaExistitzenDa = false;
        for (Jokalaria j : jokalariak) {
            if (j != null && j.getJokalarikod() == jokalaria.getJokalarikod()) {
                jokalariaExistitzenDa = true;
                break;
            }
        }
        if (!jokalariaExistitzenDa) {
            throw new IllegalStateException("Jokalaria ez da existitzen datu basean.");
        }
        boolean helburuTaldeaExistitzenDa = false;
        for (int i = 1; i <= 6; i++) {
            if (i == taldeHelburuKod) {
                helburuTaldeaExistitzenDa = true;
                break;
            }
        }
        if (!helburuTaldeaExistitzenDa) {
            throw new IllegalStateException("Talde helburua ez da existitzen.");
        }
        try {
            jokalaria.setTaldeKod(taldeHelburuKod);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Errorea jokalaria eguneratzerakoan: " + e.getMessage(), e);
        }
    }

    /**
     * Jokalari bat kodearen arabera lortzen du.
     *
     * @param jokalarikod Jokalariaren kodea
     * @return Jokalaria aurkitzen bada, bestela null
     */
    public static Jokalaria getJokalariaId(int jokalarikod) {
        for (Jokalaria j : jokalariak) {
            if (j.getJokalarikod() == jokalarikod) {
                return j;
            }
        }
        return null;
    }

    /**
     * Taldearen izena kodearen arabera itzultzen du.
     *
     * @param taldeKod Taldearen kodea
     * @return Taldearen izena, ezezaguna bada "Ezezaguna" itzultzen du
     */
    public static String getTaldeIzenaByKod(int taldeKod) {
        switch (taldeKod) {
            case 1: return "Otxarkoaga Distira";
            case 2: return "Miribilla Uhinen Jokoak";
            case 3: return "Txurdinaga Harriak";
            case 4: return "Usansolo Hortzadak";
            case 5: return "Matiko Txirrindulariak";
            case 6: return "Santutxu Haizeak";
            default: return "Ezezaguna";
        }
    }
}
