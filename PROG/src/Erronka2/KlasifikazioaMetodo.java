package Erronka2;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Klasifikazioa pestañaren interfazea - DISEINUA BAKARRIK, LOGIKARIK GABE
 */
public class KlasifikazioaMetodo {

    private JPanel panel;
    private Color urdina;

    public KlasifikazioaMetodo(Color urdina) {
        this.urdina = urdina;
        panel = new JPanel(null);
        panel.setBackground(urdina);

        // Izenburua
        JLabel titulua = new JLabel("KLASIFIKAZIOA");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 40));
        titulua.setBounds(320, 20, 400, 50);
        panel.add(titulua);

        // Combo box Denboraldia aukeratzeko
        JComboBox<String> denboraldiaCombo = new JComboBox<>();
        denboraldiaCombo.addItem("Denboraldia 1");
        denboraldiaCombo.addItem("Denboraldia 2");
        denboraldiaCombo.setFont(new Font("Arial", Font.BOLD, 18));
        denboraldiaCombo.setBounds(100, 90, 200, 40);
        panel.add(denboraldiaCombo);

        // Taula - hutsik, zutabeak izen bereziekin
        String[] zutabeak = {"Posizioa", "Taldea", "PJ", "PG", "PE", "PP", "PTS"};
        Object[][] datuak = new Object[6][zutabeak.length]; // 6 ilarak hutsik

        JTable klasifikazioaTaula = new JTable(datuak, zutabeak);
        klasifikazioaTaula.setFont(new Font("Arial", Font.PLAIN, 14));
        klasifikazioaTaula.setFillsViewportHeight(true);
        klasifikazioaTaula.setShowGrid(true);
        klasifikazioaTaula.setGridColor(Color.LIGHT_GRAY);

        // Zentratu testua zutabeetan
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < klasifikazioaTaula.getColumnCount(); i++) {
            klasifikazioaTaula.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(klasifikazioaTaula);
        scrollPane.setBounds(100, 150, 700, 250);
        panel.add(scrollPane);

        // Ajustar altura de filas para que ocupen todo el alto visible
        int numFilas = klasifikazioaTaula.getRowCount();
        int altoDisponible = 227; // altura del scrollPane

        if (numFilas > 0) {
            int alturaFila = altoDisponible / numFilas;
            klasifikazioaTaula.setRowHeight(alturaFila);
        }

        // Boton Gorde
        JButton gordeBotoia = new JButton("Gorde");
        gordeBotoia.setFont(new Font("Arial", Font.BOLD, 20));
        gordeBotoia.setBackground(Color.WHITE);
        gordeBotoia.setBounds(150, 420, 200, 50);
        panel.add(gordeBotoia);

        // Boton Kargatu
        JButton kargatuBotoia = new JButton("Kargatu");
        kargatuBotoia.setFont(new Font("Arial", Font.BOLD, 20));
        kargatuBotoia.setBackground(Color.WHITE);
        kargatuBotoia.setBounds(450, 420, 200, 50);
        panel.add(kargatuBotoia);

        // Boton Saioa Amaitu (gorria)
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);
        panel.add(saioaAmaituBotoia);
    }

    /**
     * Klasifikazioa panel hau itzultzen du
     * @return JPanel diseinua daukana
     */
    public JPanel getPanel() {
        return panel;
    }
}
