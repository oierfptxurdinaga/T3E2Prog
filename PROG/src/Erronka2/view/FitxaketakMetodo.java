package Erronka2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Erronka2.model.Taldeak;
import Erronka2.model.Taldeak.TaldeFactory;
import Erronka2.model.Jokalaria;
import Erronka2.model.Partidua;

public class FitxaketakMetodo {

    private JPanel panela;
    private Color urdina;
    private JComboBox<Taldeak> taldeaCombo;
    private JList<Jokalaria> jokalariakZerrenda;
    private DefaultListModel<Jokalaria> zerrendaModeloa;
    private JComboBox<Taldeak> helburuTaldeaCombo; 
    
    private JButton saioaAmaituBotoia;
    private JButton traspasatuBotoia;
    
    private JLabel titulua;
    private JLabel taldeaEtiketa;
    private JLabel jokalariakEtiketa;
    private JLabel helburuTaldeaEtiketa;
    
    private JScrollPane korritzePanelaJokalariak;
    private JLabel abisuaEtiketa; // Berria: abisua erakusteko

    public FitxaketakMetodo(Color urdina) {
        this.urdina = urdina;
        panela = new JPanel(null);
        panela.setBackground(urdina);

        // Izenburua
        titulua = new JLabel("FITXAKETAK");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 32));
        titulua.setBounds(350, 40, 300, 40);
        panela.add(titulua);
        
        // ===============================
        // ABISUA DENBORALDIA HASITA BADAGO
        // ===============================
        abisuaEtiketa = new JLabel("");
        abisuaEtiketa.setForeground(Color.YELLOW);
        abisuaEtiketa.setFont(new Font("Arial", Font.BOLD, 16));
        abisuaEtiketa.setBounds(100, 100, 700, 30);
        abisuaEtiketa.setHorizontalAlignment(SwingConstants.CENTER);
        panela.add(abisuaEtiketa);

        // Taldea aukeratzeko etiketa eta kombo kutxa
        taldeaEtiketa = new JLabel("Aukeratu taldea:");
        taldeaEtiketa.setForeground(Color.WHITE);
        taldeaEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        taldeaEtiketa.setBounds(100, 150, 200, 30);
        panela.add(taldeaEtiketa);

        taldeaCombo = new JComboBox<>();
        try {
            for (Taldeak t : TaldeFactory.sortuTaldeak()) {
                if (t != null) {
                    taldeaCombo.addItem(t);
                }
            }
        } catch (Exception e) {
            System.err.println("Errorea taldeak kargatzerakoan: " + e.getMessage());
            JOptionPane.showMessageDialog(panela, 
                "Errorea taldeak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
        }
        taldeaCombo.setBounds(100, 190, 250, 35);
        panela.add(taldeaCombo);

        // Jokalarien zerrenda etiketa
        jokalariakEtiketa = new JLabel("Jokalariak:");
        jokalariakEtiketa.setForeground(Color.WHITE);
        jokalariakEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        jokalariakEtiketa.setBounds(100, 240, 200, 30);
        panela.add(jokalariakEtiketa);

        // DefaultListModel eta JList
        zerrendaModeloa = new DefaultListModel<>();
        jokalariakZerrenda = new JList<>(zerrendaModeloa);
   
        
        korritzePanelaJokalariak = new JScrollPane(jokalariakZerrenda);
        korritzePanelaJokalariak.setBounds(100, 280, 250, 200);
        panela.add(korritzePanelaJokalariak);

        // Traspasatu nahi den taldea aukeratzeko etiketa eta kombo kutxa
        helburuTaldeaEtiketa = new JLabel("Traspasatu nahi den taldea:");
        helburuTaldeaEtiketa.setForeground(Color.WHITE);
        helburuTaldeaEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        helburuTaldeaEtiketa.setBounds(450, 150, 300, 30);
        panela.add(helburuTaldeaEtiketa);

        helburuTaldeaCombo = new JComboBox<>();
        try {
            for (Taldeak t : TaldeFactory.sortuTaldeak()) {
                if (t != null) {
                    helburuTaldeaCombo.addItem(t);
                }
            }
        } catch (Exception e) {
            System.err.println("Errorea helburu taldeak kargatzerakoan: " + e.getMessage());
            JOptionPane.showMessageDialog(panela, 
                "Errorea helburu taldeak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
        }
        helburuTaldeaCombo.setBounds(450, 190, 250, 35);
        panela.add(helburuTaldeaCombo);

        // Traspasatu botoia
        traspasatuBotoia = new JButton("Traspasatu");
        traspasatuBotoia.setBounds(475, 280, 200, 40);
        
        traspasatuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    traspasatuJokalariaGUI();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea jokalaria traspasatzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(traspasatuBotoia);
        
        // Saioa Amaitu botoia (gorria)
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
        
        // Gehitu taldeCombo-ri bere actionlistener
        taldeaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    kargatuJokalariak();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea jokalariak kargatzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        
        // Jokalariak hasieran kargatu
        try {
            kargatuJokalariak();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea hasierako jokalariak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        // Denboraldiaren egoera egiaztatu
        eguneratuInterfazeaDenboraldia();
    }
    
    /**
     * Denboraldiaren egoera egiaztatu eta kontrolak gaitu/desgaitu
     */
    private void eguneratuInterfazeaDenboraldia() {
        try {
            // Egiaztatu denboraldi aktiborik dagoen eta hasita dagoen
            String unekoDenboraldia = Partidua.getUnekoDenboraldia();
            boolean denboraldiaHasita = Partidua.isDenboraldiaHasita();
            
            if (unekoDenboraldia != null && denboraldiaHasita) {
                // Denboraldia hasita dago, fitxaketak desgaitu
                traspasatuBotoia.setEnabled(false);
                taldeaCombo.setEnabled(false);
                helburuTaldeaCombo.setEnabled(false);
                abisuaEtiketa.setText("OHARRA: Denboraldia hasita dago. Ezin dira fitxaketak egin.");
                
                // Abisuaren kolorea aldatu
                abisuaEtiketa.setForeground(Color.RED);
            } else {
                // Denboraldia ez dago hasita edo ez dago denboraldirik, fitxaketak baimendu
                traspasatuBotoia.setEnabled(true);
                taldeaCombo.setEnabled(true);
                helburuTaldeaCombo.setEnabled(true);
                abisuaEtiketa.setText("Fitxaketak egin daitezke denboraldia hasi aurretik.");
                
                // Informazioaren kolorea aldatu
                abisuaEtiketa.setForeground(Color.YELLOW);
            }
        } catch (Exception e) {
            System.err.println("Errorea denboraldiaren egoera egiaztatzerakoan: " + e.getMessage());
            // En caso de error, deshabilitar todo por seguridad
            traspasatuBotoia.setEnabled(false);
            taldeaCombo.setEnabled(false);
            helburuTaldeaCombo.setEnabled(false);
            abisuaEtiketa.setText("Errorea sistemaren egoera egiaztatzerakoan.");
            abisuaEtiketa.setForeground(Color.RED);
        }
    }
    
    /**
     * Metodo hau erabili da aukeratutako taldeen jokalariak kargatzeko
     */
    private void kargatuJokalariak() throws Exception {
        zerrendaModeloa.clear();

        Taldeak hautatutakoTaldea = (Taldeak) taldeaCombo.getSelectedItem();

        if (hautatutakoTaldea == null) {
            throw new IllegalStateException("Ez da talderik aukeratu.");
        }
        
        if (hautatutakoTaldea.getTalde_kod() != 0) { // "-" placeholder-a baztertu

            System.out.println("Talde aukeratua: "
                + hautatutakoTaldea.getIzena()
                + " | kodea: "
                + hautatutakoTaldea.getTalde_kod());

            List<Jokalaria> jokalariak;
            try {
                jokalariak = Jokalaria.getJokalariakByTaldea(hautatutakoTaldea.getTalde_kod());
                
                if (jokalariak == null) {
                    throw new IllegalStateException("Jokalarien zerrenda nulua itzuli da.");
                }
                
            } catch (Exception e) {
                throw new Exception("Errorea jokalariak datu basetik kargatzerakoan: " + e.getMessage(), e);
            }

            System.out.println("Aurkitutako jokalariak: " + jokalariak.size());

            for (Jokalaria jokalaria : jokalariak) {
                if (jokalaria == null) {
                    throw new IllegalStateException("Jokalari nulua aurkitu da.");
                }
                zerrendaModeloa.addElement(jokalaria);
            }
        }
    }
    
    /**
     * Interfaze grafikoaren metodoa traspasoa kudeatzeko
     */
    private void traspasatuJokalariaGUI() throws Exception {
        // Egiaztatu fitxaketak egin daitezkeen
        try {
            if (Partidua.isDenboraldiaHasita()) {
                throw new IllegalStateException("Ezin dira fitxaketak egin denboraldia hasita dagoelako.");
            }
        } catch (Exception e) {
            throw new Exception("Errorea denboraldiaren egoera egiaztatzerakoan: " + e.getMessage(), e);
        }
        
        // Hautatutako jokalaria
        Jokalaria hautatutakoJokalaria = jokalariakZerrenda.getSelectedValue();
        
        // Ez badugu aukeratu jokalaririk
        if (hautatutakoJokalaria == null) {
            throw new IllegalArgumentException("Mesedez, aukeratu jokalari bat traspasatzeko.");
        }
        
        // Aukeratu ze taldean egin nahi dugun traspasoa
        Taldeak helburuTaldea = (Taldeak) helburuTaldeaCombo.getSelectedItem();
        
        // Ez badugu aukeratu Talderik
        if (helburuTaldea == null) {
            throw new IllegalArgumentException("Mesedez, aukeratu talde helburu bat.");
        }
        
        if (helburuTaldea.getTalde_kod() == 0) {
            throw new IllegalArgumentException("Aukeratu talde helburu balido bat (ez '-').");
        }
        
        // Egiaztatu bi ComboBox-sean ez aukeratzea talde berdins
        if (hautatutakoJokalaria.getTaldeKod() == helburuTaldea.getTalde_kod()) {
            throw new IllegalArgumentException("Jokalaria hau talde honetan dago.");
        }
        
        // Mezu bat jarri ziurtatzeko traspasoa egin nahi duen
        int erantzuna = JOptionPane.showConfirmDialog(panela,
            hautatutakoJokalaria.getIzena() + " jokalaria " + helburuTaldea.getIzena() + " taldera traspasatu nahi duzu?",
            "Traspasoa baieztatu",
            JOptionPane.YES_NO_OPTION);
        
        if (erantzuna == JOptionPane.YES_OPTION) {
            try {
                // Jatorrizko taldearen izena lortu
                String taldeJatorriIzena = Jokalaria.getTaldeIzenaByKod(hautatutakoJokalaria.getTaldeKod());
                
                // Validar nombre del equipo
                if (taldeJatorriIzena == null || taldeJatorriIzena.equals("Ezezaguna")) {
                    throw new IllegalStateException("Ezin izan da jatorrizko taldearen izena lortu.");
                }
                
                // Metodoari deitu traspasoa egiteko
                boolean traspasoArrakastatsua = Jokalaria.traspasatuJokalaria(
                    hautatutakoJokalaria, 
                    helburuTaldea.getTalde_kod()
                );
                
                if (!traspasoArrakastatsua) {
                    throw new Exception("Traspasoa huts egin du.");
                }
                
                // Zerrenda berriaraztu
                kargatuJokalariak();
                
                // Arrakasta mezua erakutsi
                JOptionPane.showMessageDialog(null, 
                    hautatutakoJokalaria.getIzena() + " traspasatu da " + taldeJatorriIzena + 
                    " taldetik " + helburuTaldea.getIzena() + " taldera.", 
                    "Traspasoa burututa", 
                    JOptionPane.INFORMATION_MESSAGE);
                    
                // Konsolan erakutsi (log simulazioa)
                System.out.println("TRASPASOA: " + hautatutakoJokalaria.getIzena() + 
                                 " " + taldeJatorriIzena + "-tik " + 
                                 helburuTaldea.getIzena() + "-ra Erabiltzaileak");
                                 
            } catch (Exception e) {
                throw new Exception("Errorea traspasoa exekutatzeko: " + e.getMessage(), e);
            }
        }
    }
    
    public JPanel getPanela() {
        return panela;
    }
    
    public JList<Jokalaria> getJokalariakZerrenda() {
        return jokalariakZerrenda;
    }
    
    public DefaultListModel<Jokalaria> getZerrendaModeloa() {
        return zerrendaModeloa;
    }
    
    public JComboBox<Taldeak> getTaldeaCombo() {
        return taldeaCombo;
    }
    
    public JComboBox<Taldeak> getHelburuTaldeaCombo() {
        return helburuTaldeaCombo;
    }
}