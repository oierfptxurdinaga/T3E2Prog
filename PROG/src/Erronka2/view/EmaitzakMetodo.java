package Erronka2.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Erronka2.model.Partidua;

/**
 * Emaitzak fitxaren interfazea - ORAIN LOGIKA ERREAL ETA AUTOMATIKOAREKIN
 * 
 * Swing erabiliz, erabiltzaileak denboraldia eta jardunaldia aukeratu ditzake
 * eta hautatutako irizpideen arabera emaitzak taulan ikusi.
 */
public class EmaitzakMetodo {
    
    private JPanel panela;                      // Interfazeko panela nagusia
    private Color urdina;                       // Atzeko plano kolorea
    private JComboBox<String> denboraldiaCombo;// Denboraldia hautatzeko ComboBox
    private JComboBox<String> jardunaldiaCombo;// Jardunaldia hautatzeko ComboBox
    private JTable taula;                       // Emaitzak erakusteko taula
    private DefaultTableModel taulaModeloa;    // Taularen datuen modelo dinamikoa
    
    /**
     * Eraikitzailea, panela eta osagai guztiak sortzen ditu
     * @param urdina Kolore nagusia panela eta osagaietarako
     */
    public EmaitzakMetodo(Color urdina) {
        this.urdina = urdina;
        panela = new JPanel(null);
        panela.setBackground(urdina);
        
        // =================================
        // TITULUA SORTU
        // =================================
        JLabel titulua = new JLabel("EMAITZAK", SwingConstants.CENTER);
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 32));
        titulua.setBounds(0, 40, 900, 40);
        panela.add(titulua);
        
        // =================================
        // DENBORALDIA LABEL ETA COMBOBOX
        // =================================
        JLabel denboraldiaEtiketa = new JLabel("Denboraldia:");
        denboraldiaEtiketa.setForeground(Color.WHITE);
        denboraldiaEtiketa.setFont(new Font("Arial", Font.BOLD, 16));
        denboraldiaEtiketa.setBounds(100, 120, 150, 30);
        panela.add(denboraldiaEtiketa);
        
        denboraldiaCombo = new JComboBox<>();
        denboraldiaCombo.addItem("Guztiak");  // Aukera guztien artean ikusteko
        denboraldiaCombo.addItem("2022/2023");
        denboraldiaCombo.addItem("2023/2024");
        denboraldiaCombo.addItem("2024/2025");
        denboraldiaCombo.setBounds(100, 160, 180, 35);
        denboraldiaCombo.addActionListener(e -> {
            try {
                kargatuEmaitzakAutomatikoki();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panela, 
                    "Errorea emaitzak kargatzerakoan: " + ex.getMessage(), 
                    "Errorea", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        panela.add(denboraldiaCombo);
        
        // =================================
        // JARDUNALDIA LABEL ETA COMBOBOX
        // =================================
        JLabel jardunaldiaEtiketa = new JLabel("Jardunaldia:");
        jardunaldiaEtiketa.setForeground(Color.WHITE);
        jardunaldiaEtiketa.setFont(new Font("Arial", Font.BOLD, 16));
        jardunaldiaEtiketa.setBounds(300, 120, 150, 30);
        panela.add(jardunaldiaEtiketa);
        
        jardunaldiaCombo = new JComboBox<>();
        jardunaldiaCombo.addItem("Guztiak");  // Aukera guztien artean ikusteko
        for (int i = 1; i <= 10; i++) {
            jardunaldiaCombo.addItem("Jardunaldia " + i);
        }
        jardunaldiaCombo.setBounds(300, 160, 180, 35);
        jardunaldiaCombo.addActionListener(e -> {
            try {
                kargatuEmaitzakAutomatikoki();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panela, 
                    "Errorea emaitzak kargatzerakoan: " + ex.getMessage(), 
                    "Errorea", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        panela.add(jardunaldiaCombo);
        
        // =================================
        // TAULA (EMAITZAK) SORTU
        // =================================
        String[] zutabeak = {
            "Talde lokala",
            "Setak lokala",
            "Setak kanpokoa",
            "Talde kanpokoa",
            "Jardunaldia",
            "Denboraldia"
        };
        
        taulaModeloa = new DefaultTableModel(zutabeak, 0) {
            @Override
            public boolean isCellEditable(int errenkada, int zutabea) {
                return false; // Ez da taula editagarria izango
            }
            
            @Override
            public Class<?> getColumnClass(int zutabeIndizea) {
                if (zutabeIndizea == 1 || zutabeIndizea == 2) {
                    return Integer.class; // Zenbakiak ondo ordenatzeko
                }
                return String.class;
            }
        };
        
        taula = new JTable(taulaModeloa);
        taula.setRowHeight(35);
        taula.setFont(new Font("Arial", Font.PLAIN, 14));
        taula.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        taula.setAutoCreateRowSorter(true); // Taula ordenagarria
        
        JScrollPane korritzePanela = new JScrollPane(taula);
        korritzePanela.setBounds(100, 230, 700, 220);
        panela.add(korritzePanela);
        
        // =================================
        // SAIOA AMAITZEKO BOTOIA
        // =================================
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);
        saioaAmaituBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Login leihoa berria ireki eta lehendik dagoena itxi
                    SwingUtilities.invokeLater(() -> new Login().setVisible(true));
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    frame.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea saioa amaitzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(saioaAmaituBotoia);
        
        // Hasieran, automatikoki emaitzak kargatu
        try {
            kargatuEmaitzakAutomatikoki();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea hasierako emaitzak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * Emaitzak taulan automatikoki kargatzen ditu hautatutako denboraldia eta jardunaldia kontuan hartuta
     * @throws Exception - Erroreak gertatzen direnean
     */
    private void kargatuEmaitzakAutomatikoki() throws Exception {
        taulaModeloa.setRowCount(0); // Taula garbitu
        
        String jardunaldiaHautatua = (String) jardunaldiaCombo.getSelectedItem();
        String denboraldiaHautatua = (String) denboraldiaCombo.getSelectedItem();
        
        // Aukerak balidatu
        if (jardunaldiaHautatua == null) {
            throw new IllegalStateException("Jardunaldia hautatu gabe.");
        }
        
        if (denboraldiaHautatua == null) {
            throw new IllegalStateException("Denboraldia hautatu gabe.");
        }
        
        // Partiduak iragazi eta lortu
        List<Partidua> partiduak;
        try {
            partiduak = Partidua.getPartiduakByDenboraldiaAndJardunaldia(
                denboraldiaHautatua,
                jardunaldiaHautatua
            );
            
            if (partiduak == null) {
                throw new IllegalStateException("Partidu zerrenda nulua itzuli da.");
            }
            
        } catch (Exception e) {
            throw new Exception("Errorea partiduak iragazterakoan: " + e.getMessage(), e);
        }
        
        boolean partiduakAurkituta = false;
        
        // Partidu bakoitza taulan gehitu
        for (Partidua partidua : partiduak) {
            try {
                partiduakAurkituta = true;
                
                // Partidu balidazioa
                if (partidua == null) {
                    throw new IllegalStateException("Partidu nulua aurkitu da.");
                }
                
                if (partidua.getEtxeko_taldea() == null) {
                    throw new IllegalStateException("Etxeko taldea nulua partiduan.");
                }
                
                if (partidua.getKanpoko_taldea() == null) {
                    throw new IllegalStateException("Kanpoko taldea nulua partiduan.");
                }
                
                // Taularen errenkadan gehitu datuak
                Object[] errenkadaDatuak = {
                    partidua.getEtxeko_taldea().getIzena(),
                    partidua.getEtxekoTaldekoSetak(),
                    partidua.getKanpokoTaldekoSetak(),
                    partidua.getKanpoko_taldea().getIzena(),
                    partidua.getJardunaldia(),
                    partidua.getDenboraldia()
                };
                
                taulaModeloa.addRow(errenkadaDatuak);
                
            } catch (Exception e) {
                throw new Exception("Errorea partidua prozesatzerakoan: " + e.getMessage(), e);
            }
        }
        
        // Partidurik ez badago, mezu bat agertu taulan
        if (!partiduakAurkituta) {
            try {
                Object[] daturikEz = {
                    "Ez dago partidurik",
                    "-",
                    "-",
                    "Sartu partidu bat",
                    "Guztiak".equals(jardunaldiaHautatua) ? "Guztiak" : jardunaldiaHautatua,
                    "Guztiak".equals(denboraldiaHautatua) ? "Guztiak" : denboraldiaHautatua
                };
                taulaModeloa.addRow(daturikEz);
            } catch (Exception e) {
                throw new Exception("Errorea mezua gehitzerakoan: " + e.getMessage(), e);
            }
        }
    }
    
    /**
     * Taula beste klaseetatik eguneratzeko metodo publikoa
     */
    public void eguneratuTaula() {
        try {
            kargatuEmaitzakAutomatikoki();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea taula eguneratzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * Emaitzak erakusten dituen JPanel hau itzultzen du
     * @return JPanel panela nagusia
     */
    public JPanel getPanela() {
        return panela;
    }
    
    // Denboraldia eta jardunaldia hautatzeko ComboBox-en getter-ak
    public JComboBox<String> getDenboraldiaCombo() {
        return denboraldiaCombo;
    }
    
    public JComboBox<String> getJardunaldiaCombo() {
        return jardunaldiaCombo;
    }
    
    // Taularen getter-a
    public JTable getTaula() {
        return taula;
    }
    
    /**
     * Partidu berri bat gehitu dela jakinarazteko metodoa,
     * taula automatikoki eguneratzen du
     */
    public void notifyPartiduaGehitu() {
        try {
            kargatuEmaitzakAutomatikoki();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea partidu berria jakinarazterakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
