package Erronka2.view;

import javax.swing.*;
import java.awt.*;

/**
 * Partiduak pestañako interfazea eta edukia kudeatzen du.
 */
public class PartiduakMetodo {

    private JPanel panelPartiduak;

    // Osagaiak partekatu nahi badituzu klasean gordeta
    private JComboBox<String> jardunaldiaCombo;
    private JComboBox<String> etxekoCombo;
    private JTextField etxekoPuntuak;
    private JComboBox<String> kanpokoCombo;
    private JTextField kanpokoPuntuak;
    private JButton puntuakSartuBotoia;
    private JButton saioaAmaituBotoia;

    /**
     * Eraikitzailea - Panel nagusia sortu eta osagaiak gehitu
     * @param kolorea Atzeko kolorea, kasu honetan urdina
     */
    public PartiduakMetodo(Color kolorea) {
        panelPartiduak = new JPanel(null); // Layout null, kokapen absolutua
        panelPartiduak.setBackground(kolorea);
        
        // Izenburua
        JLabel titulua = new JLabel("PARTIDUAK SARTU");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 40));
        titulua.setBounds(250, 40, 400, 50);
        panelPartiduak.add(titulua);

        // Jardunaldia
        JLabel jardunaldia = new JLabel("Aukeratu jardunaldia:");
        jardunaldia.setForeground(Color.WHITE);
        jardunaldia.setFont(new Font("Arial", Font.BOLD, 32));
        jardunaldia.setBounds(100, 170, 400, 40);
        panelPartiduak.add(jardunaldia);

        // Jardunaldia aukeratzeko combo boxa
        jardunaldiaCombo = new JComboBox<>();
        jardunaldiaCombo.addItem("Jardunaldia 1");
        jardunaldiaCombo.addItem("Jardunaldia 2");
        jardunaldiaCombo.addItem("Jardunaldia 3");
        jardunaldiaCombo.setBounds(500, 175, 250, 35);
        panelPartiduak.add(jardunaldiaCombo);

        // Etxeko taldea label eta combo
        JLabel etxekoLabel = new JLabel("Etxeko Taldea:");
        etxekoLabel.setForeground(Color.WHITE);
        etxekoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        etxekoLabel.setBounds(100, 235, 200, 30);
        panelPartiduak.add(etxekoLabel);

        etxekoCombo = new JComboBox<>();
        etxekoCombo.addItem("1. Taldea");
        etxekoCombo.addItem("2. Taldea");
        etxekoCombo.addItem("3. Taldea");
        etxekoCombo.addItem("4. Taldea");
        etxekoCombo.setBounds(100, 275, 250, 35);
        panelPartiduak.add(etxekoCombo);

        // Etxeko puntuazioa label eta textfield
        JLabel etxekoPuntuakLabel = new JLabel("Puntuak:");
        etxekoPuntuakLabel.setForeground(Color.WHITE);
        etxekoPuntuakLabel.setFont(new Font("Arial", Font.BOLD, 16));
        etxekoPuntuakLabel.setBounds(100, 340, 100, 25);
        panelPartiduak.add(etxekoPuntuakLabel);

        etxekoPuntuak = new JTextField();
        etxekoPuntuak.setBounds(196, 340, 120, 30);
        panelPartiduak.add(etxekoPuntuak);

        // Kanpoko taldea label eta combo
        JLabel kanpokoLabel = new JLabel("Kanpoko Taldea:");
        kanpokoLabel.setForeground(Color.WHITE);
        kanpokoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        kanpokoLabel.setBounds(500, 235, 200, 30);
        panelPartiduak.add(kanpokoLabel);

        kanpokoCombo = new JComboBox<>();
        kanpokoCombo.addItem("1. Taldea");
        kanpokoCombo.addItem("2. Taldea");
        kanpokoCombo.addItem("3. Taldea");
        kanpokoCombo.addItem("4. Taldea");
        kanpokoCombo.setBounds(500, 275, 250, 35);
        panelPartiduak.add(kanpokoCombo);

        // Kanpoko puntuazioa label eta textfield
        JLabel kanpokoPuntuakLabel = new JLabel("Puntuak:");
        kanpokoPuntuakLabel.setForeground(Color.WHITE);
        kanpokoPuntuakLabel.setFont(new Font("Arial", Font.BOLD, 16));
        kanpokoPuntuakLabel.setBounds(499, 340, 100, 25);
        panelPartiduak.add(kanpokoPuntuakLabel);

        kanpokoPuntuak = new JTextField();
        kanpokoPuntuak.setBounds(590, 340, 120, 30);
        panelPartiduak.add(kanpokoPuntuak);

        // Puntuak sartzeko botoia
        puntuakSartuBotoia = new JButton("Sartu puntuak");
        puntuakSartuBotoia.setBounds(350, 400, 200, 40);
        panelPartiduak.add(puntuakSartuBotoia);

        // Boton Saioa Amaitu (gorria)
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);
        panelPartiduak.add(saioaAmaituBotoia);
    }


    /**
     * Partiduak panela itzultzen du
     * @return JPanel - Partiduak pestañako edukia duen panel nagusia
     */
    public JPanel getPanel() {
        return panelPartiduak;
    }

    // Hemen jarri ahal izango dituzu etorkizunean Partiduak atalarentzako metodoak
    // adibidez, puntuak gordetzeko edo beste interakzioak egiteko.
}
