package Erronka2.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import Erronka2.model.Klasifikazioa;
import Erronka2.model.Partidua;
import Erronka2.model.TaldearenKlasifikazioa;

/**
 * Klasifikazioa fitxaren interfazea.
 * Fitxa honetan sailkapen taula erakusten eta kudeatzen da.
 */
public class KlasifikazioaMetodo {

    /** Fitxa nagusia JPanel batean gordetzen du */
    private JPanel panela;
    
    /** Saioa amaitzeko botoia */
    private JButton saioaAmaituBotoia;
    /** Denboraldia aukeratzeko JComboBox */
    private JComboBox<String> denboraldiaCombo;
    /** Sailkapen taula */
    private JTable klasifikazioaTaula;
    /** Taularen modelo dinamikoa */
    private DefaultTableModel taulaModeloa;
    /** Klasifikazioa gordetzeko botoia */
    private JButton gordeBotoia;
    /** Klasifikazioa kargatzeko botoia */
    private JButton kargatuBotoia;
    /** Denboraldia amaitzeko botoia */
    private JButton amaituDenboraldiaBotoia;

    /**
     * Eraikitzailea.
     * Pantaila eta osagai guztiak sortzen ditu.
     * 
     * @param urdina atzeko planoaren kolorea
     */
    public KlasifikazioaMetodo(Color urdina) {
        panela = new JPanel(null);
        panela.setBackground(urdina);

        // Izenburua
        JLabel titulua = new JLabel("KLASIFIKAZIOA");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 40));
        titulua.setBounds(320, 20, 400, 50);
        panela.add(titulua);

        // Denboraldia aukeratzeko ComboBox
        denboraldiaCombo = new JComboBox<>();
        denboraldiaCombo.addItem("2022/2023");
        denboraldiaCombo.addItem("2023/2024");
        denboraldiaCombo.addItem("2024/2025");
        denboraldiaCombo.setFont(new Font("Arial", Font.BOLD, 18));
        denboraldiaCombo.setBounds(100, 90, 200, 40);
        denboraldiaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    kargatuKlasifikazioa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea klasifikazioa kargatzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(denboraldiaCombo);
        
        // Denboraldia amaitzeko botoia
        amaituDenboraldiaBotoia = new JButton("Amaitu Denboraldia");
        amaituDenboraldiaBotoia.setFont(new Font("Arial", Font.BOLD, 16));
        amaituDenboraldiaBotoia.setBackground(Color.ORANGE);
        amaituDenboraldiaBotoia.setForeground(Color.BLACK);
        amaituDenboraldiaBotoia.setBounds(350, 90, 200, 40);
        amaituDenboraldiaBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    amaituDenboraldia();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea denboraldia amaitzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(amaituDenboraldiaBotoia);

        // Taularen zutabeak eta modelo dinamikoa
        String[] zutabeak = {"Posizioa", "Taldea", "PJ", "PG", "PP", "Puntuak", "SI", "SG", "SD"};
        
        taulaModeloa = new DefaultTableModel(zutabeak, 0) {
            @Override
            public boolean isCellEditable(int errenkada, int zutabea) {
                return false; // Taula ez da editagarria
            }
        };
        
        klasifikazioaTaula = new JTable(taulaModeloa);
        klasifikazioaTaula.setFont(new Font("Arial", Font.PLAIN, 14));
        klasifikazioaTaula.setFillsViewportHeight(true);
        klasifikazioaTaula.setShowGrid(true);
        klasifikazioaTaula.setGridColor(Color.LIGHT_GRAY);

        // Testua zutabeetan zentratu
        DefaultTableCellRenderer zentratuErrendatzailea = new DefaultTableCellRenderer();
        zentratuErrendatzailea.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < klasifikazioaTaula.getColumnCount(); i++) {
            klasifikazioaTaula.getColumnModel().getColumn(i).setCellRenderer(zentratuErrendatzailea);
        }

        JScrollPane korritzePanela = new JScrollPane(klasifikazioaTaula);
        korritzePanela.setBounds(100, 150, 700, 250);
        panela.add(korritzePanela);

        // Gorde botoia (Serializable formatuan gordetzeko)
        gordeBotoia = new JButton("Gorde Klasifikazioa");
        gordeBotoia.setFont(new Font("Arial", Font.BOLD, 16));
        gordeBotoia.setBackground(new Color(0, 150, 0));
        gordeBotoia.setForeground(Color.WHITE);
        gordeBotoia.setBounds(200, 420, 200, 40);
        gordeBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gordeKlasifikazioa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea klasifikazioa gordetzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(gordeBotoia);
        
        // Kargatu botoia (Serializable formatutik kargatzeko)
        kargatuBotoia = new JButton("Kargatu Klasifikazioa");
        kargatuBotoia.setFont(new Font("Arial", Font.BOLD, 16));
        kargatuBotoia.setBackground(new Color(0, 100, 200));
        kargatuBotoia.setForeground(Color.WHITE);
        kargatuBotoia.setBounds(450, 420, 200, 40);
        kargatuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    kargatuKlasifikazioaSerializable();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea klasifikazioa kargatzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(kargatuBotoia);

        // Saioa amaitzeko botoia
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
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea saioa amaitzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }

        });
        panela.add(saioaAmaituBotoia);
        
        // Hasierako klasifikazioa kargatu
        try {
            kargatuKlasifikazioa();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea hasierako klasifikazioa kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        // Amaitu botoiaren egoera eguneratu
        eguneratuAmaituBotoia();
    }
    
    /**
     * Klasifikazioa Serializable formatuan gordetzen du.
     * @throws Exception fitxategiaren gordetzean erroreak badira
     */
    private void gordeKlasifikazioa() throws Exception {
        String denboraldia = (String) denboraldiaCombo.getSelectedItem();
        if (denboraldia == null || denboraldia.isEmpty()) {
            throw new IllegalArgumentException("Aukeratu denboraldi bat lehenik.");
        }
        
        // Serializable objektua sortu datuekin
        SerializableKlasifikazioaDatuak datuak = new SerializableKlasifikazioaDatuak();
        datuak.setDenboraldia(denboraldia);
        datuak.setEguna(new Date());
        
        // Taulako datuak bilduma batean sartu
        List<String[]> datuZerrenda = new ArrayList<>();
        for (int i = 0; i < taulaModeloa.getRowCount(); i++) {
            String[] errenkada = new String[taulaModeloa.getColumnCount()];
            for (int j = 0; j < taulaModeloa.getColumnCount(); j++) {
                Object balioa = taulaModeloa.getValueAt(i, j);
                errenkada[j] = (balioa != null) ? balioa.toString() : "";
            }
            datuZerrenda.add(errenkada);
        }
        datuak.setDatuZerrenda(datuZerrenda);
        
        // Klasifikazioa guztiz lortu (modelotik)
        List<TaldearenKlasifikazioa> klasifikazioaOsoa = Klasifikazioa.getKlasifikazioaOrdenatua();
        datuak.setKlaseaEguneratua(false); // Ez da eguneratzen, soilik gordetzen
        
        JFileChooser fitxategiAukeratzailea = new JFileChooser();
        fitxategiAukeratzailea.setDialogTitle("Gorde klasifikazioa");
        fitxategiAukeratzailea.setSelectedFile(new File("klasifikazioa_" + denboraldia + ".dat"));
        
        int erabiltzaileHautapena = fitxategiAukeratzailea.showSaveDialog(panela);
        
        if (erabiltzaileHautapena == JFileChooser.APPROVE_OPTION) {
            File gordetzekoFitxategia = fitxategiAukeratzailea.getSelectedFile();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(gordetzekoFitxategia))) {
                out.writeObject(datuak);
                JOptionPane.showMessageDialog(panela, 
                    "Klasifikazioa gordeta: " + gordetzekoFitxategia.getAbsolutePath() + 
                    "\nDenboraldia: " + denboraldia, 
                    "Ondo", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                System.out.println("KLASIFIKAZIOA GORDETA: " + gordetzekoFitxategia.getAbsolutePath());
                
            } catch (IOException ex) {
                throw new IOException("Ezin izan da fitxategia gorde: " + ex.getMessage());
            } catch (SecurityException ex) {
                throw new SecurityException("Ez dago baimenik fitxategia gordetzeko: " + ex.getMessage());
            }
        }
    }
    
    /**
     * Klasifikazioa Serializable formatutik kargatzen du.
     * @throws Exception fitxategia irekitzean edo irakurtzean erroreak badira
     */
    private void kargatuKlasifikazioaSerializable() throws Exception {
        JFileChooser fitxategiAukeratzailea = new JFileChooser();
        fitxategiAukeratzailea.setDialogTitle("Kargatu klasifikazioa");
        
        int erabiltzaileHautapena = fitxategiAukeratzailea.showOpenDialog(panela);
        
        if (erabiltzaileHautapena == JFileChooser.APPROVE_OPTION) {
            File kargatzekoFitxategia = fitxategiAukeratzailea.getSelectedFile();
            
            // Fitxategia existitzen den eta irakurgarria den egiaztatu
            if (!kargatzekoFitxategia.exists()) {
                throw new FileNotFoundException("Fitxategia ez da aurkitu: " + kargatzekoFitxategia.getAbsolutePath());
            }
            
            if (!kargatzekoFitxategia.canRead()) {
                throw new IOException("Ez dago baimenik fitxategia irakurtzeko: " + kargatzekoFitxategia.getAbsolutePath());
            }
            
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(kargatzekoFitxategia))) {
                SerializableKlasifikazioaDatuak datuak = (SerializableKlasifikazioaDatuak) in.readObject();
                
                // Kargatutako datuak balidatu
                if (datuak == null) {
                    throw new IllegalStateException("Kargatutako datuak nuluek dira.");
                }
                
                // Denboraldia ComboBox eguneratu, aurkitzen bada hautatu, bestela gehitu
                boolean denboraldiaAurkituta = false;
                for (int i = 0; i < denboraldiaCombo.getItemCount(); i++) {
                    if (denboraldiaCombo.getItemAt(i).equals(datuak.getDenboraldia())) {
                        denboraldiaCombo.setSelectedIndex(i);
                        denboraldiaAurkituta = true;
                        break;
                    }
                }
                
                if (!denboraldiaAurkituta) {
                    denboraldiaCombo.addItem(datuak.getDenboraldia());
                    denboraldiaCombo.setSelectedItem(datuak.getDenboraldia());
                }
                
                // Datu zerrenda balidatu
                if (datuak.getDatuZerrenda() == null) {
                    throw new IllegalStateException("Kargatutako datu zerrenda nulua da.");
                }
                
                // Taula garbitu eta datuak gehitu
                taulaModeloa.setRowCount(0);
                for (String[] errenkada : datuak.getDatuZerrenda()) {
                    if (errenkada == null) {
                        throw new IllegalStateException("Errenkada nulua aurkitu da.");
                    }
                    taulaModeloa.addRow(errenkada);
                }
                
                JOptionPane.showMessageDialog(panela, 
                    "Klasifikazioa kargatuta: " + kargatzekoFitxategia.getAbsolutePath() + 
                    "\nDenboraldia: " + datuak.getDenboraldia() + 
                    "\nGordetze data: " + datuak.getEguna(), 
                    "Ondo", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                System.out.println("KLASIFIKAZIOA KARGATUTA: " + kargatzekoFitxategia.getAbsolutePath());
                
            } catch (ClassNotFoundException ex) {
                throw new ClassNotFoundException("Ez da aurkitu klasea fitxategian: " + ex.getMessage());
            } catch (InvalidClassException ex) {
                throw new InvalidClassException("Klasearen bertsioa ez da bateragarria: " + ex.getMessage());
            } catch (StreamCorruptedException ex) {
                throw new StreamCorruptedException("Fitxategia hondatuta dago: " + ex.getMessage());
            } catch (OptionalDataException ex) {
                throw new IOException("Datuak falta dira fitxategian: " + ex.getMessage());
            } catch (EOFException ex) {
                throw new EOFException("Fitxategia ustekabean amaitu da: " + ex.getMessage());
            }
        }
    }
    
    /**
     * Klase pribatu eta estatikoko serializable objektua.
     * Klasifikazio datuak gordetzeko eta kargatzeko erabiltzen da.
     */
    private static class SerializableKlasifikazioaDatuak implements Serializable {
        private static final long serialVersionUID = 1L;
        private String denboraldia;
        private Date eguna;
        private List<String[]> datuZerrenda;
        private boolean klaseaEguneratua;
        
        /** Eraikitzaile huts bat, datu zerrenda hasieratzen duena */
        public SerializableKlasifikazioaDatuak() {
            this.datuZerrenda = new ArrayList<>();
        }
        
        public String getDenboraldia() {
            return denboraldia;
        }
        
        public void setDenboraldia(String denboraldia) {
            if (denboraldia == null || denboraldia.trim().isEmpty()) {
                throw new IllegalArgumentException("Denboraldia ezin da hutsik egon.");
            }
            this.denboraldia = denboraldia;
        }
        
        public Date getEguna() {
            return eguna;
        }
        
        public void setEguna(Date eguna) {
            if (eguna == null) {
                throw new IllegalArgumentException("Data ezin da nulua izan.");
            }
            this.eguna = eguna;
        }
        
        public List<String[]> getDatuZerrenda() {
            return datuZerrenda;
        }
        
        public void setDatuZerrenda(List<String[]> datuZerrenda) {
            if (datuZerrenda == null) {
                throw new IllegalArgumentException("Datu zerrenda ezin da nulua izan.");
            }
            this.datuZerrenda = datuZerrenda;
        }
        
        public boolean isKlaseaEguneratua() {
            return klaseaEguneratua;
        }
        
        public void setKlaseaEguneratua(boolean klaseaEguneratua) {
            this.klaseaEguneratua = klaseaEguneratua;
        }
    }
    
    /**
     * Uneko denboraldia amaitzeko metodoa.
     * Erabiltzaileari baieztapen bat eskatzen dio eta amaitzen badu,
     * fitxaketa egiteko aukera ematen du.
     * 
     * @throws Exception denboraldia amaitzean erroreak badira
     */
    private void amaituDenboraldia() throws Exception {
        String unekoDenboraldia = Partidua.getUnekoDenboraldia();
        
        if (unekoDenboraldia == null) {
            throw new IllegalStateException("Ez dago denboraldirik hasita.");
        }
        
        int erantzuna = JOptionPane.showConfirmDialog(panela,
            "Ziur al zaude " + unekoDenboraldia + " denboraldia amaitu nahi duzula?\n" +
            "Honek fitxaketak egitea ahalbidetuko du.",
            "Denboraldia amaitu",
            JOptionPane.YES_NO_OPTION);
            
        if (erantzuna != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
            Partidua.amaituDenboraldia();
            System.out.println("DENBORALDIA AMAITUTA: " + unekoDenboraldia + " Erabiltzaileak");
            JOptionPane.showMessageDialog(panela, 
                "Denboraldia amaitu da: " + unekoDenboraldia + "\n" +
                "Orain fitxaketak egin ditzakezu edo denboraldi berri bat hasi.",
                "Denboraldia Amaituta",
                JOptionPane.INFORMATION_MESSAGE);
            eguneratuAmaituBotoia();
        } catch (Exception e) {
            throw new Exception("Errorea denboraldia amaitzerakoan: " + e.getMessage(), e);
        }
    }
    
    /**
     * Denboraldia amaitzeko botoiaren egoera eguneratzen du.
     * Botoiaren testua eta tooltip-a eguneratzen dira uneko denboraldiaren arabera.
     */
    private void eguneratuAmaituBotoia() {
        try {
            String unekoDenboraldia = Partidua.getUnekoDenboraldia();
            
            if (unekoDenboraldia != null) {
                if (Partidua.isDenboraldiaHasita()) {
                    amaituDenboraldiaBotoia.setText("Amaitu Denboraldia: " + unekoDenboraldia);
                    amaituDenboraldiaBotoia.setToolTipText("Denboraldia amaitu fitxaketak egiteko");
                } else {
                    amaituDenboraldiaBotoia.setText("Denboraldia Amaituta: " + unekoDenboraldia);
                    amaituDenboraldiaBotoia.setToolTipText("Denboraldia dagoeneko amaitu da");
                }
            } else {
                amaituDenboraldiaBotoia.setText("Amaitu Denboraldia");
                amaituDenboraldiaBotoia.setToolTipText("Ez dago denboraldirik hasita");
            }
            
            amaituDenboraldiaBotoia.setEnabled(true);
        } catch (Exception e) {
            amaituDenboraldiaBotoia.setText("Amaitu Denboraldia");
            amaituDenboraldiaBotoia.setToolTipText("Errorea egoera kargatzerakoan");
            amaituDenboraldiaBotoia.setEnabled(false);
            System.err.println("Errorea amaitu botoia eguneratzerakoan: " + e.getMessage());
        }
    }
    
    /**
     * Klasifikazioa taulan kargatzeko metodoa.
     * Klasifikazioa modelotik jaso eta taulan erakusten du.
     * @throws Exception klasifikazioa kargatzerakoan erroreak badira
     */
    private void kargatuKlasifikazioa() throws Exception {
        taulaModeloa.setRowCount(0);
        
        String denboraldiaHautatua = (String) denboraldiaCombo.getSelectedItem();
        
        if (denboraldiaHautatua == null || denboraldiaHautatua.isEmpty()) {
            throw new IllegalArgumentException("Aukeratu denboraldi bat.");
        }
        
        try {
            Klasifikazioa.hasieratuPartiduetatik(denboraldiaHautatua);
            
            List<TaldearenKlasifikazioa> klasifikazioa = Klasifikazioa.getKlasifikazioaOrdenatua();
            
            if (klasifikazioa == null) {
                throw new IllegalStateException("Klasifikazioa nulua itzuli da.");
            }
            
            int posizioa = 1;
            for (TaldearenKlasifikazioa tk : klasifikazioa) {
                if (tk == null) {
                    throw new IllegalStateException("TaldearenKlasifikazioa nulua aurkitu da.");
                }
                
                if (tk.getTaldea() == null) {
                    throw new IllegalStateException("Talde nulua aurkitu da klasifikazioan.");
                }
                
                Object[] errenkadaDatuak = {
                    posizioa++,
                    tk.getTaldea().getIzena(),
                    tk.getPartidaJokatuak(),
                    tk.getPartidaIrabaziak(),
                    tk.getPartidaGalduak(),
                    tk.getPuntuak(),
                    tk.getSetakIrabaziak(),
                    tk.getSetakGalduak(),
                    tk.getSetDiferentzia()
                };
                taulaModeloa.addRow(errenkadaDatuak);
            }
            
            // Errenkaden altuera egokitu
            int errenkadaKopurua = taulaModeloa.getRowCount();
            if (errenkadaKopurua > 0) {
                int altueraEskura = 227;
                int errenkadaAltuera = Math.max(30, altueraEskura / errenkadaKopurua);
                klasifikazioaTaula.setRowHeight(errenkadaAltuera);
            }
            
        } catch (Exception e) {
            throw new Exception("Errorea klasifikazioa kargatzerakoan: " + e.getMessage(), e);
        }
    }
    
    /**
     * Taula eguneratzeko metodo publikoa.
     * Barruan kargatuKlasifikazioa metodoa deitzen du.
     */
    public void eguneratuTaula() {
        try {
            kargatuKlasifikazioa();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea taula eguneratzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * Klasifikazioa fitxaren JPanel-a itzultzen du.
     * @return JPanel klasifikazioaren interfazearekin
     */
    public JPanel getPanela() {
        return panela;
    }
}