package Erronka2.view;

import javax.swing.*;

import Erronka2.model.Klasifikazioa;
import Erronka2.model.Partidua;
import Erronka2.model.Taldeak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Partiduak fitxako interfazea eta edukia kudeatzen ditu.
 * Hemen erabiltzaileak partida berriak sartu, denboraldia hasi eta saioa amaitu dezake.
 */
public class PartiduakMetodo {

    private JPanel partiduakPanela;

    private JTextField etxekoSetak;
    private JTextField kanpokoSetak;

    private JComboBox<String> denboraldiaCombo;
    private JComboBox<String> jardunaldiaCombo;
    private JComboBox<String> etxekoCombo;
    private JComboBox<String> kanpokoCombo;

    private JButton puntuakSartuBotoia;
    private JButton saioaAmaituBotoia;

    private JLabel titulua;
    private JLabel denboraldiaEtiketa;
    private JLabel jardunaldiaEtiketa; 
    private JLabel etxekoEtiketa;
    private JLabel etxekoSetakEtiketa;
    private JLabel kanpokoEtiketa;
    private JLabel kanpokoSetakEtiketa;
    
    private JButton hasiDenboraldiaBotoia;
    
    // Main erreferentzia interfazea eguneratzeko
    private Main leihoNagusia;

    /**
     * Eraikitzailea Main erreferentziarekin.
     * 
     * @param kolorea Panelaren atzeko kolorea
     * @param leihoNagusia Main klasearen erreferentzia, fitxak eguneratzeko
     */
    public PartiduakMetodo(Color kolorea, Main leihoNagusia) {
        this.leihoNagusia = leihoNagusia;
        partiduakPanela = new JPanel(null);
        partiduakPanela.setBackground(kolorea);

        // Izenburua
        titulua = new JLabel("PARTIDUAK SARTU");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 40));
        titulua.setBounds(250, 40, 400, 50);
        partiduakPanela.add(titulua);
        
        // ===============================
        // "HASI DENBORALDIA" BOTOIA
        // ===============================
        hasiDenboraldiaBotoia = new JButton("Hasi Denboraldia");
        hasiDenboraldiaBotoia.setFont(new Font("Arial", Font.BOLD, 16));
        hasiDenboraldiaBotoia.setBackground(Color.GREEN);
        hasiDenboraldiaBotoia.setForeground(Color.BLACK);
        hasiDenboraldiaBotoia.setBounds(600, 90, 200, 40);
        hasiDenboraldiaBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hasiDenboraldiaBerria();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(partiduakPanela, 
                        "Errorea denboraldia hasteko: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        partiduakPanela.add(hasiDenboraldiaBotoia);

        // ===============================
        // DENBORALDIA (TEMPORADA)
        // ===============================
        denboraldiaEtiketa = new JLabel("Aukeratu denboraldia:");
        denboraldiaEtiketa.setForeground(Color.WHITE);
        denboraldiaEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        denboraldiaEtiketa.setBounds(100, 120, 200, 30);
        partiduakPanela.add(denboraldiaEtiketa);

        denboraldiaCombo = new JComboBox<>();
        denboraldiaCombo.addItem("2022/2023");
        denboraldiaCombo.addItem("2023/2024");
        denboraldiaCombo.addItem("2024/2025");
        denboraldiaCombo.setBounds(100, 160, 200, 35);
        partiduakPanela.add(denboraldiaCombo);

        // ===============================
        // JARDUNALDIA
        // ===============================
        jardunaldiaEtiketa = new JLabel("Aukeratu jardunaldia:");
        jardunaldiaEtiketa.setForeground(Color.WHITE);
        jardunaldiaEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        jardunaldiaEtiketa.setBounds(320, 120, 200, 30);
        partiduakPanela.add(jardunaldiaEtiketa);

        // Jardunaldia aukeratzeko kombo kutxa
        jardunaldiaCombo = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            jardunaldiaCombo.addItem("Jardunaldia " + i);
        }
        jardunaldiaCombo.setBounds(320, 160, 200, 35);
        partiduakPanela.add(jardunaldiaCombo);

        // ===============================
        // ETXEKO TALDEA
        // ===============================
        etxekoEtiketa = new JLabel("Etxeko Taldea:");
        etxekoEtiketa.setForeground(Color.WHITE);
        etxekoEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        etxekoEtiketa.setBounds(100, 220, 200, 30);
        partiduakPanela.add(etxekoEtiketa);

        etxekoCombo = new JComboBox<>();
        etxekoCombo.addItem("Otxarkoaga Distira");
        etxekoCombo.addItem("Miribilla Uhinen Jokoak");
        etxekoCombo.addItem("Txurdinaga Harriak");
        etxekoCombo.addItem("Usansolo Hortzadak");
        etxekoCombo.addItem("Matiko Txirrindulariak");
        etxekoCombo.addItem("Santutxu Haizeak");
        etxekoCombo.setBounds(100, 260, 200, 35);
        partiduakPanela.add(etxekoCombo);

        // Etxeko setak etiketa eta testu-eremua
        etxekoSetakEtiketa = new JLabel("Setak (0-3):");
        etxekoSetakEtiketa.setForeground(Color.WHITE);
        etxekoSetakEtiketa.setFont(new Font("Arial", Font.BOLD, 16));
        etxekoSetakEtiketa.setBounds(100, 320, 100, 25);
        partiduakPanela.add(etxekoSetakEtiketa);

        etxekoSetak = new JTextField();
        etxekoSetak.setBounds(180, 320, 120, 30);
        partiduakPanela.add(etxekoSetak);

        // ===============================
        // KANPOKO TALDEA
        // ===============================
        kanpokoEtiketa = new JLabel("Kanpoko Taldea:");
        kanpokoEtiketa.setForeground(Color.WHITE);
        kanpokoEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        kanpokoEtiketa.setBounds(320, 220, 200, 30);
        partiduakPanela.add(kanpokoEtiketa);

        kanpokoCombo = new JComboBox<>();
        kanpokoCombo.addItem("Otxarkoaga Distira");
        kanpokoCombo.addItem("Miribilla Uhinen Jokoak");
        kanpokoCombo.addItem("Txurdinaga Harriak");
        kanpokoCombo.addItem("Usansolo Hortzadak");
        kanpokoCombo.addItem("Matiko Txirrindulariak");
        kanpokoCombo.addItem("Santutxu Haizeak");
        kanpokoCombo.setBounds(320, 260, 200, 35);
        partiduakPanela.add(kanpokoCombo);

        // Kanpoko setak etiketa eta testu-eremua
        kanpokoSetakEtiketa = new JLabel("Setak (0-3):");
        kanpokoSetakEtiketa.setForeground(Color.WHITE);
        kanpokoSetakEtiketa.setFont(new Font("Arial", Font.BOLD, 16));
        kanpokoSetakEtiketa.setBounds(320, 320, 100, 25);
        partiduakPanela.add(kanpokoSetakEtiketa);

        kanpokoSetak = new JTextField();
        kanpokoSetak.setBounds(400, 320, 120, 30);
        partiduakPanela.add(kanpokoSetak);

        // ===============================
        // BOTOIAK
        // ===============================
        puntuakSartuBotoia = new JButton("Sartu partidua");
        puntuakSartuBotoia.setBounds(200, 380, 200, 40);
        puntuakSartuBotoia.setFont(new Font("Arial", Font.BOLD, 16));
        partiduakPanela.add(puntuakSartuBotoia);

        puntuakSartuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    procesarPartidua();
                } catch (NumberFormatException ex) {  // Primero las excepciones más específicas
                    JOptionPane.showMessageDialog(partiduakPanela, "Mesedez, sartu zenbaki baliodunak setetan.", 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(partiduakPanela, ex.getMessage(), "Abisua", 
                        JOptionPane.WARNING_MESSAGE);
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(partiduakPanela, ex.getMessage(), "Errorea", 
                        JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {  // Siempre al final las más generales
                    JOptionPane.showMessageDialog(partiduakPanela, 
                        "Errorea partidua sartzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
            
            /**
             * Partidua sartu eta balidazio guztiak egin.
             * 
             * @throws Exception balidazio errore edo sartze akatsak.
             */
            private void procesarPartidua() throws Exception {
                // Egiaztatu denboraldi aktiborik dagoen
                if (Partidua.getUnekoDenboraldia() == null) {
                    throw new IllegalStateException("Lehenik denboraldia bat hasi behar duzu.");
                }
                
                String etxekoIzena = (String) etxekoCombo.getSelectedItem();
                String kanpokoIzena = (String) kanpokoCombo.getSelectedItem();
                String jardunaldia = (String) jardunaldiaCombo.getSelectedItem();
                String denboraldia = (String) denboraldiaCombo.getSelectedItem();
                
                // Validar selecciones
                if (etxekoIzena == null || kanpokoIzena == null || jardunaldia == null || denboraldia == null) {
                    throw new IllegalStateException("Mesedez, bete eremu guztiak.");
                }
                
                // Egiaztatu ez direla beste denboraldiko emaitzak sartzen
                if (!denboraldia.equals(Partidua.getUnekoDenboraldia())) {
                    throw new IllegalStateException("Ezin duzu partidurik sartu denboraldi honetan. Uneko denboraldia: " + 
                        Partidua.getUnekoDenboraldia());
                }

                // Etxeko eta kanpoko taldea berdinak ez direla egiaztatu
                if (etxekoIzena.equals(kanpokoIzena)) {
                    throw new IllegalArgumentException("Etxeko eta kanpoko taldea ezin dira berdinak izan.");
                }

                int etxekoS, kanpokoS;
                try {
                    etxekoS = Integer.parseInt(etxekoSetak.getText().trim());
                    kanpokoS = Integer.parseInt(kanpokoSetak.getText().trim());
                } catch (NumberFormatException ex) {
                    throw new NumberFormatException("Mesedez, sartu zenbaki baliodunak setetan.");
                }

                // Seten balidazioa (boleibola 5 setetakoa da)
                if (etxekoS < 0 || etxekoS > 3 || kanpokoS < 0 || kanpokoS > 3) {
                    throw new IllegalArgumentException("Setak 0 eta 3 artean egon behar dira.");
                }

                // Egiaztatu talde batek 3 set irabazi dituela
                if ((etxekoS == 3 && kanpokoS <= 2) || (kanpokoS == 3 && etxekoS <= 2)) {
                    // Válido: un equipo tiene 3 sets y el otro 2 o menos
                } else {
                    throw new IllegalArgumentException("Partidu batek 3 set irabazi behar ditu (bestea 0, 1 edo 2).");
                }

                // Seten batura ezin da 5 baino handiagoa izan
                if ((etxekoS + kanpokoS) > 5) {
                    throw new IllegalArgumentException("Set guztien batura ezin da 5 baino handiagoa izan.");
                }

                // Jardunaldi berean partida errepikaturik ez dagoela egiaztatu
                for (Partidua p : Partidua.getPartiduakZerrenda()) {
                    if (p == null) continue;
                    
                    boolean jardunaldiBerdina = p.getJardunaldia() != null && p.getJardunaldia().equals(jardunaldia);
                    boolean denboraldiaBerdina = p.getDenboraldia() != null && p.getDenboraldia().equals(denboraldia);
                    boolean taldeBerdinak = p.getEtxeko_taldea() != null && p.getKanpoko_taldea() != null &&
                            ((p.getEtxeko_taldea().getIzena().equals(etxekoIzena)
                                    && p.getKanpoko_taldea().getIzena().equals(kanpokoIzena))
                                || (p.getEtxeko_taldea().getIzena().equals(kanpokoIzena)
                                        && p.getKanpoko_taldea().getIzena().equals(etxekoIzena)));

                    if (jardunaldiBerdina && denboraldiaBerdina && taldeBerdinak) {
                        throw new IllegalStateException("Partida hau jolastu da denboraldi honetako jardunaldi honetan.");
                    }
                }

                // Taldeak objektu osoak lortu
                Taldeak etxekoTaldea = Taldeak.getTaldeaIzenaz(etxekoIzena);
                Taldeak kanpokoTaldea = Taldeak.getTaldeaIzenaz(kanpokoIzena);
                
                // Ez badira aurkitzen getTaldeaIzenaz metodoa erabiliz, zerrendan bilatu
                if (etxekoTaldea == null) {
                    List<Taldeak> taldeakZerrenda = Taldeak.TaldeFactory.sortuTaldeak();
                    for (Taldeak t : taldeakZerrenda) {
                        if (t.getIzena().equals(etxekoIzena)) {
                            etxekoTaldea = t;
                            break;
                        }
                    }
                }
                
                if (kanpokoTaldea == null) {
                    List<Taldeak> taldeakZerrenda = Taldeak.TaldeFactory.sortuTaldeak();
                    for (Taldeak t : taldeakZerrenda) {
                        if (t.getIzena().equals(kanpokoIzena)) {
                            kanpokoTaldea = t;
                            break;
                        }
                    }
                }
                
                // Ziurtatu bi taldeak existitzen direla
                if (etxekoTaldea == null || kanpokoTaldea == null) {
                    throw new IllegalStateException("Talde batzuk ez dira aurkitu.");
                }

                // Partidua sortu
                Partidua p = new Partidua();
                p.setDenboraldia(denboraldia);
                p.setJardunaldia(jardunaldia);
                
                p.setEtxeko_taldea(etxekoTaldea);
                p.setKanpoko_taldea(kanpokoTaldea);
                
                p.setEtxekoTaldekoSetak(etxekoS);
                p.setKanpokoTaldekoSetak(kanpokoS);
                
                // Uneko data gehitu
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                p.setPartiduData(sdf.format(new Date()));

                // Partidua gorde
                Partidua.gehituPartidua(p);
                
                // Klasifikazioa eguneratu
                Klasifikazioa.eguneratuPartiduarekin(p);
                
                // Konsolan erakutsi (log simulazioa)
                System.out.println("PARTIDUA ERREGISTRATUA: " + etxekoIzena + " " + etxekoS + 
                                 " - " + kanpokoS + " " + kanpokoIzena + 
                                 " | " + jardunaldia + " | " + denboraldia + " Erabiltzaileak");

                // Irabazlea detektatu eta koloreak markatu
                if (etxekoS > kanpokoS) {
                    etxekoSetak.setBackground(Color.GREEN);
                    kanpokoSetak.setBackground(Color.RED);
                } else {
                    etxekoSetak.setBackground(Color.RED);
                    kanpokoSetak.setBackground(Color.GREEN);
                }

                JOptionPane.showMessageDialog(partiduakPanela, 
                    "Partidua ondo gorde da.\n" +
                    "Emaitzak eta klasifikazioa automatikoki eguneratuko dira.", 
                    "Ondo", 
                    JOptionPane.INFORMATION_MESSAGE);

                // Hurrengo sarrerarako eremuak garbitu
                etxekoSetak.setText("");
                kanpokoSetak.setText("");
                etxekoSetak.setBackground(Color.WHITE);
                kanpokoSetak.setBackground(Color.WHITE);
                
                // FITXA GUZTIAK AUTOMATIKOKI EGUNERATU
                if (leihoNagusia != null) {
                    leihoNagusia.eguneratuDena();
                }
            }
        });

        // ===============================
        // BOTOIA - SAIOA AMAITU
        // ===============================
        saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);

        saioaAmaituBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SwingUtilities.invokeLater(() -> new Login().setVisible(true));
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    frame.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(partiduakPanela, 
                        "Errorea saioa amaitzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        partiduakPanela.add(saioaAmaituBotoia);
        
        // Egungo denboraldiaren egoera egiaztatu
        eguneratuInterfazea();
    }
    
    /**
     * Eraikitzailea Main erreferentziarik gabe (bateragarritasunerako).
     * @param kolorea Panelaren atzeko kolorea
     */
    public PartiduakMetodo(Color kolorea) {
        this(kolorea, null);
    }
    
    /**
     * Denboraldi berri bat hasteko metodoa.
     * @throws Exception denboraldi berria hastean erroreak agertzen badira.
     */
    private void hasiDenboraldiaBerria() throws Exception {
        // Hautatutako denboraldia lortu
        String denboraldiaBerria = (String) denboraldiaCombo.getSelectedItem();
        
        if (denboraldiaBerria == null || denboraldiaBerria.isEmpty()) {
            throw new IllegalArgumentException("Aukeratu denboraldi bat.");
        }
        
        // Denboraldi berria hasi
        boolean ondo = Partidua.hasiDenboraldiaBerria(denboraldiaBerria);
        
        if (ondo) {
            JOptionPane.showMessageDialog(partiduakPanela, 
                    "Denboraldi berria hasi da: " + denboraldiaBerria + "\n" +
                    "Orain partiduak sartu ditzakezu.", "Ondo",
                    JOptionPane.INFORMATION_MESSAGE);
            
            // Klasifikazioa berrabiarazi denboraldi berrirako
            Klasifikazioa.berrabiarazi();
            
            // Konsolan erakutsi (log simulazioa)
            System.out.println("DENBORALDIA HASITA: " + denboraldiaBerria + " Erabiltzaileak");
            
            // Interfazea eguneratu
            eguneratuInterfazea();
            
            // Fitxa guztiak eguneratu
            if (leihoNagusia != null) {
                leihoNagusia.eguneratuDena();
            }
        } else {
            throw new IllegalStateException("Dagoeneko denboraldi aktibo bat dago. Lehenik unekoa amaitu.");
        }
    }
    
    /**
     * Interfazea eguneratu denboraldiaren egoeraren arabera.
     * Kontrolak gaitzen edo desgaitzen ditu denboraldia hasi edo amaitu den arabera.
     */
    private void eguneratuInterfazea() {
        try {
            String unekoDenboraldia = Partidua.getUnekoDenboraldia();
            boolean denboraldiaHasita = Partidua.isDenboraldiaHasita();
            
            if (unekoDenboraldia != null) {
                hasiDenboraldiaBotoia.setText("Denboraldia: " + unekoDenboraldia);
                hasiDenboraldiaBotoia.setEnabled(true);
                
                // Kontrolak gaitu/desgaitu denboraldia hasita dagoen ala ez
                puntuakSartuBotoia.setEnabled(denboraldiaHasita);
                etxekoSetak.setEnabled(denboraldiaHasita);
                kanpokoSetak.setEnabled(denboraldiaHasita);
                
                // Egoera erakutsi
                if (denboraldiaHasita) {
                    hasiDenboraldiaBotoia.setToolTipText("Denboraldia hasita dago. Partiduak sartu ditzakezu.");
                } else {
                    hasiDenboraldiaBotoia.setToolTipText("Denboraldia amaitu da. Hasi beste bat partiduak sartzeko.");
                }
            } else {
                hasiDenboraldiaBotoia.setText("Hasi Denboraldia");
                hasiDenboraldiaBotoia.setEnabled(true);
                hasiDenboraldiaBotoia.setToolTipText("Hasi denboraldi berri bat");
                
                // Kontrolak desgaitu denboraldirik ez badago
                puntuakSartuBotoia.setEnabled(false);
                etxekoSetak.setEnabled(false);
                kanpokoSetak.setEnabled(false);
            }
        } catch (Exception e) {
            System.err.println("Errorea interfazea eguneratzerakoan: " + e.getMessage());
            // En caso de error, establecer estado seguro
            hasiDenboraldiaBotoia.setText("Hasi Denboraldia");
            hasiDenboraldiaBotoia.setToolTipText("Errorea egoera kargatzerakoan");
            hasiDenboraldiaBotoia.setEnabled(false);
            puntuakSartuBotoia.setEnabled(false);
            etxekoSetak.setEnabled(false);
            kanpokoSetak.setEnabled(false);
        }
    }

    /**
     * Partiduak panel nagusia itzultzen du.
     * 
     * @return JPanel Partiduak fitxako edukia duen panela
     */
    public JPanel getPanela() {
        return partiduakPanela;
    }
}
