package Erronka2.view;

import javax.swing.*;
import java.awt.*;

/**
 * Main klasea - Aplikazioaren leihoa eta goiko pestañak kudeatzen ditu.
 */
public class Main extends JFrame {

    public Main() {
        setTitle("Partiduak");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color urdina = new Color(0, 70, 160);

        JPanel panelNagusia = new JPanel(new BorderLayout());
        panelNagusia.setBackground(urdina);
        setContentPane(panelNagusia);

        // Goiko pestañak sortu eta kudeatu
        JTabbedPane tabak = new JTabbedPane();
        tabak.setFont(new Font("Arial", Font.BOLD, 14));

        // Partiduak panel modularra sortu
        PartiduakMetodo partiduak = new PartiduakMetodo(urdina);

        // Taldeak panel modularra sortu (orain bai edukia izango du)
        TaldeakMetodo taldeak = new TaldeakMetodo(urdina);

        FitxaketakMetodo fitxaketak = new FitxaketakMetodo(urdina);

        KlasifikazioaMetodo klasifikazioa = new KlasifikazioaMetodo(urdina);
        
        EmaitzakMetodo emaitzak = new EmaitzakMetodo(urdina);

        // Pestañak gehitu, Taldeak eta Partiduak panel modularrak erabiliz
        tabak.addTab("Partiduak", partiduak.getPanel());
        tabak.addTab("Fitxaketak", fitxaketak.getPanel());
        tabak.addTab("Taldeak", taldeak.getPanel());
        tabak.addTab("Klasifikazioa", klasifikazioa.getPanel());
        tabak.addTab("Emaitzak", emaitzak.getPanel());

        panelNagusia.add(tabak, BorderLayout.CENTER);
    }

    /**
     * Main metodoa - aplikazioa martxan jartzen du
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
