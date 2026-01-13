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

    private JPanel panel;
    private Color urdina;
    private JComboBox<Taldeak> taldeaCombo;
    private JList<Jokalaria> jokalariakLista;
    private DefaultListModel<Jokalaria> listModel;
    private JComboBox<Taldeak> helburuTaldeaCombo; 
    
    private JButton saioaAmaituBotoia;
    private JButton transpasatuBotoia;
    
    private JLabel titulua;
    private JLabel taldeaLabel;
    private JLabel jokalariakLabel;
    private JLabel helburuTaldeaLabel;
    
    private JScrollPane scrollJokalariak;
    private JLabel abisuaLabel; // Nuevo: para mostrar advertencia

    public FitxaketakMetodo(Color urdina) {
        this.urdina = urdina;
        panel = new JPanel(null);
        panel.setBackground(urdina);

        // Izenburua
        titulua = new JLabel("FITXAKETAK");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 32));
        titulua.setBounds(350, 40, 300, 40);
        panel.add(titulua);
        
        // ===============================
        // ADVERTENCIA SI LA TEMPORADA HA EMPEZADO
        // ===============================
        abisuaLabel = new JLabel("");
        abisuaLabel.setForeground(Color.YELLOW);
        abisuaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        abisuaLabel.setBounds(100, 100, 700, 30);
        abisuaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(abisuaLabel);

        // Taldea aukeratzeko label eta combo boxa
        taldeaLabel = new JLabel("Aukeratu taldea:");
        taldeaLabel.setForeground(Color.WHITE);
        taldeaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        taldeaLabel.setBounds(100, 150, 200, 30);
        panel.add(taldeaLabel);

        taldeaCombo = new JComboBox<>();
        for (Taldeak t : TaldeFactory.sortuTaldeak()) {
            taldeaCombo.addItem(t);
        }
        taldeaCombo.setBounds(100, 190, 250, 35);
        panel.add(taldeaCombo);

        // Jokalarien zerrenda label
        jokalariakLabel = new JLabel("Jokalariak:");
        jokalariakLabel.setForeground(Color.WHITE);
        jokalariakLabel.setFont(new Font("Arial", Font.BOLD, 18));
        jokalariakLabel.setBounds(100, 240, 200, 30);
        panel.add(jokalariakLabel);

        // DefaultListModel y JList
        listModel = new DefaultListModel<>();
        jokalariakLista = new JList<>(listModel);
   
        
        scrollJokalariak = new JScrollPane(jokalariakLista);
        scrollJokalariak.setBounds(100, 280, 250, 200);
        panel.add(scrollJokalariak);

        // Transpasatu nahi den taldea aukeratzeko label eta combo boxa
        helburuTaldeaLabel = new JLabel("Transpasatu nahi den taldea:");
        helburuTaldeaLabel.setForeground(Color.WHITE);
        helburuTaldeaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        helburuTaldeaLabel.setBounds(450, 150, 300, 30);
        panel.add(helburuTaldeaLabel);

        helburuTaldeaCombo = new JComboBox<>();
        for (Taldeak t : TaldeFactory.sortuTaldeak()) {
            helburuTaldeaCombo.addItem(t);
        }
        helburuTaldeaCombo.setBounds(450, 190, 250, 35);
        panel.add(helburuTaldeaCombo);

        // Transpasatu botoia
        transpasatuBotoia = new JButton("Transpasatu");
        transpasatuBotoia.setBounds(475, 280, 200, 40);
        
        transpasatuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traspasatuJokalariaGUI();
            }
        });
        panel.add(transpasatuBotoia);
        
        // Boton Saioa Amaitu (gorria)
        saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);
        saioaAmaituBotoia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new Login().setVisible(true));
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				frame.dispose();
			}

		});
        panel.add(saioaAmaituBotoia);
        
        // Gehitu taldeCombo bere actionlistener
        taldeaCombo.addActionListener(new ActionListener() {
        	
            @Override
            // Metodoari deitu
            public void actionPerformed(ActionEvent e) {
                kargatuJokalariak();
            }
        });
        
        // Cargar jugadores inicialmente
        kargatuJokalariak();
        
        // Comprobar estado de la temporada
        eguneratuInterfazeaTemporada();
    }
    
    /**
     * Comprobar estado de la temporada y habilitar/deshabilitar controles
     */
    private void eguneratuInterfazeaTemporada() {
        // Verificar si hay temporada actual y si ha empezado
        String unekoDenboraldia = Partidua.getUnekoDenboraldia();
        boolean denboraldiaHasita = Partidua.isDenboraldiaHasita();
        
        if (unekoDenboraldia != null && denboraldiaHasita) {
            // Temporada ha empezado, deshabilitar fichajes
            transpasatuBotoia.setEnabled(false);
            taldeaCombo.setEnabled(false);
            helburuTaldeaCombo.setEnabled(false);
            abisuaLabel.setText("OHARRA: Denboraldia hasita dago. Ezin dira fitxaketak egin.");
            
            // Cambiar color de advertencia
            abisuaLabel.setForeground(Color.RED);
        } else {
            // Temporada no ha empezado o no hay temporada, permitir fichajes
            transpasatuBotoia.setEnabled(true);
            taldeaCombo.setEnabled(true);
            helburuTaldeaCombo.setEnabled(true);
            abisuaLabel.setText("Fitxaketak egin daitezke denboraldia hasi aurretik.");
            
            // Cambiar color de información
            abisuaLabel.setForeground(Color.YELLOW);
        }
    }
    
    /**
     * Metodo hau erabili da aukeratutako taldeen jokalariak kargatzeko
     */
    private void kargatuJokalariak() {
        listModel.clear();

        Taldeak hautatutakoTaldea = (Taldeak) taldeaCombo.getSelectedItem();

        if (hautatutakoTaldea != null) {

            System.out.println("Talde aukeratua: "
                + hautatutakoTaldea.getIzena()
                + " | kodea: "
                + hautatutakoTaldea.getTalde_kod());

            List<Jokalaria> jokalariak =
                Jokalaria.getJokalariakByTaldea(hautatutakoTaldea.getTalde_kod());

            System.out.println("Aurkitutako jokalariak: " + jokalariak.size());

            for (Jokalaria jokalaria : jokalariak) {
                listModel.addElement(jokalaria);
            }
        }
    }

    
    /**
     * Método de la interfaz gráfica para manejar el traspaso Metodo hau da traspasoa egiteko
     */
    private void traspasatuJokalariaGUI() {
        // Verificar si se pueden hacer fichajes
        if (Partidua.isDenboraldiaHasita()) {
            JOptionPane.showMessageDialog(null, 
                "Ezin dira fitxaketak egin denboraldia hasita dagoelako.", 
                "Abisua", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Hartutako jokalariak
        Jokalaria hautatutakoJokalaria = jokalariakLista.getSelectedValue();
        // Ez badugu aukeratu jokalaririk
        if (hautatutakoJokalaria == null) {
        	JOptionPane.showMessageDialog(null, "Mesedez, aukeratu jokalari bat traspasatzeko.", 
                    "Abisua", JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        // Aukeratu ze taldean egin nahi dugun traspasoa
        Taldeak helburuTaldea = (Taldeak) helburuTaldeaCombo.getSelectedItem();
        // Ez badugu aukeratu Talderik
        if (helburuTaldea == null) {
            JOptionPane.showMessageDialog(null, "Mesedez, aukeratu talde helburu bat.", 
                    "Abisua", JOptionPane.WARNING_MESSAGE);
    
            return;
        }
        
        // Egiaztatu bi ComboBox-sean ez aukeratzea talde berdins
        if (hautatutakoJokalaria.getTaldeKod() == helburuTaldea.getTalde_kod()) {
        	JOptionPane.showMessageDialog(null, "Jokalaria hau talde honetan dago.", 
                    "Abisua", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Mezu bat jarri ziurtatzeko traspasoa egin nahi duen
        int erantzuna = JOptionPane.showConfirmDialog(panel,
            hautatutakoJokalaria.getIzena() + " jokalaria " + helburuTaldea.getIzena() + " taldera traspasatu nahi duzu?",
            "Traspasoa baieztatu",
            JOptionPane.YES_NO_OPTION);
        
        if (erantzuna == JOptionPane.YES_OPTION) {
            // Metodoari deitu traspasoa egiteko
            boolean traspasoExitoso = Jokalaria.traspasatuJokalaria(
                hautatutakoJokalaria, 
                helburuTaldea.getTalde_kod()
            );
            
            if (traspasoExitoso) {
                // List berriaraztu
                kargatuJokalariak();
                
                // Mezua erakutzi
                JOptionPane.showMessageDialog(null, hautatutakoJokalaria.getIzena() + " jokalaria " + helburuTaldea.getIzena() + " taldera traspasatu da.", "Traspasoa burututa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Errorea traspasoa egiterakoan.", "Errorea", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public JPanel getPanel() {
        return panel;
    }
    
    public JList<Jokalaria> getJokalariakLista() {
        return jokalariakLista;
    }
    
    public DefaultListModel<Jokalaria> getListModel() {
        return listModel;
    }
    
    public JComboBox<Taldeak> getTaldeaCombo() {
        return taldeaCombo;
    }
    
    public JComboBox<Taldeak> getHelburuTaldeaCombo() {
        return helburuTaldeaCombo;
    }
}