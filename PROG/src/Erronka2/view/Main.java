package Erronka2.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Main klasea - Aplikazioaren leihoa eta goiko pestañak kudeatzen ditu.
 */
public class Main extends JFrame {
    private JPanel panelNagusia;
    private JTabbedPane tablak;
    private EmaitzakMetodo emaitzakPanel;

    public Main() {
        setTitle("Boleibol Federazioa - 3. Taldea");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color urdina = new Color(0, 70, 160);

        panelNagusia = new JPanel(new BorderLayout());
        panelNagusia.setBackground(urdina);
        setContentPane(panelNagusia);

        // Goiko pestañak sortu eta kudeatu
        tablak = new JTabbedPane();
        tablak.setFont(new Font("Arial", Font.BOLD, 14));

        // Partiduak panel modularra sortu
        PartiduakMetodo partiduak = new PartiduakMetodo(urdina);

        // Taldeak panel modularra sortu
        TaldeakMetodo taldeak = new TaldeakMetodo(urdina);

        // Fitxaketak panel modularra sortu
        FitxaketakMetodo fitxaketak = new FitxaketakMetodo(urdina);

        // Klasifikazioa panel modularra sortu
        KlasifikazioaMetodo klasifikazioa = new KlasifikazioaMetodo(urdina);
        
        // Emaitzak panel modularra sortu
        emaitzakPanel = new EmaitzakMetodo(urdina);

        // Pestañak gehitu
        tablak.addTab("Partiduak", partiduak.getPanel());
        tablak.addTab("Fitxaketak", fitxaketak.getPanel());
        tablak.addTab("Taldeak", taldeak.getPanel());
        tablak.addTab("Klasifikazioa", klasifikazioa.getPanel());
        tablak.addTab("Emaitzak", emaitzakPanel.getPanel());

        // Añadir ChangeListener para actualizar Emaitzak cuando se cambie a esa pestaña
        tablak.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tablak.getSelectedIndex() == 4) { // Índice 4 = Emaitzak
                    emaitzakPanel.actualizarTabla();
                }
            }
        });

        panelNagusia.add(tablak, BorderLayout.CENTER);
    }

    /**
     * Main metodoa - aplikazioa martxan jartzen du
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}