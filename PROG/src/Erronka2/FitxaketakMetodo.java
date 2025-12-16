package Erronka2;

import javax.swing.*;
import java.awt.*;

/**
 * Fitxaketak pestañaren interfazea - DISEINUA BAKARRIK, LOGIKARIK GABE
 */
public class FitxaketakMetodo {

    private JPanel panel;
    private Color urdina;

    public FitxaketakMetodo(Color urdina) {
        this.urdina = urdina;
        panel = new JPanel(null);
        panel.setBackground(urdina);

        // Izenburua
        JLabel titulua = new JLabel("FITXAKETAK");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 32));
        titulua.setBounds(350, 40, 300, 40);
        panel.add(titulua);

        // Taldea aukeratzeko label eta combo boxa
        JLabel taldeaLabel = new JLabel("Aukeratu taldea:");
        taldeaLabel.setForeground(Color.WHITE);
        taldeaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        taldeaLabel.setBounds(100, 120, 200, 30);
        panel.add(taldeaLabel);

        JComboBox<String> taldeaCombo = new JComboBox<>();
        // Adibidez taldeen izenak (logika gero sartu)
        taldeaCombo.addItem("1. Taldea");
        taldeaCombo.addItem("2. Taldea");
        taldeaCombo.addItem("3. Taldea");
        taldeaCombo.setBounds(100, 160, 250, 35);
        panel.add(taldeaCombo);

        // Jokalarien zerrenda label
        JLabel jokalariakLabel = new JLabel("Jokalariak:");
        jokalariakLabel.setForeground(Color.WHITE);
        jokalariakLabel.setFont(new Font("Arial", Font.BOLD, 18));
        jokalariakLabel.setBounds(100, 210, 200, 30);
        panel.add(jokalariakLabel);

        // Jokalarien lista
        JList<String> jokalariakLista = new JList<>(new DefaultListModel<>());
        JScrollPane scrollJokalariak = new JScrollPane(jokalariakLista);
        scrollJokalariak.setBounds(100, 250, 250, 200);
        panel.add(scrollJokalariak);

        // Transpasatu nahi den taldea aukeratzeko label eta combo boxa
        JLabel helburuTaldeaLabel = new JLabel("Transpasatu nahi den taldea:");
        helburuTaldeaLabel.setForeground(Color.WHITE);
        helburuTaldeaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        helburuTaldeaLabel.setBounds(450, 120, 300, 30);
        panel.add(helburuTaldeaLabel);

        JComboBox<String> helburuTaldeaCombo = new JComboBox<>();
        helburuTaldeaCombo.addItem("1. Taldea");
        helburuTaldeaCombo.addItem("2. Taldea");
        helburuTaldeaCombo.addItem("3. Taldea");
        helburuTaldeaCombo.setBounds(450, 160, 250, 35);
        panel.add(helburuTaldeaCombo);

        // Transpasatu botoia
        JButton transpasatuBotoia = new JButton("Transpasatu");
        transpasatuBotoia.setBounds(475, 250, 200, 40);
        panel.add(transpasatuBotoia);
        
        // Boton Saioa Amaitu (gorria)
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);
        panel.add(saioaAmaituBotoia);
    }
    
    

    /**
     * Fitxaketak panel hau itzultzen du
     * @return JPanel diseinua daukana
     */
    public JPanel getPanel() {
        return panel;
    }
}
