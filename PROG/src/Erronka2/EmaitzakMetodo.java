package Erronka2;

import javax.swing.*;
import java.awt.*;

/**
 * Emaitzak pestañaren interfazea
 * DISEINUA BAKARRIK, LOGIKARIK GABE
 */
public class EmaitzakMetodo {

    private JPanel panel;
    private Color urdina;

    public EmaitzakMetodo(Color urdina) {
        this.urdina = urdina;

        panel = new JPanel(null);
        panel.setBackground(urdina);

        // ===============================
        // TITULUA
        // ===============================
        JLabel titulua = new JLabel("EMAITZAK", SwingConstants.CENTER);
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 32));
        titulua.setBounds(0, 40, 900, 40);
        panel.add(titulua);

        // ===============================
        // DENBORALDIA (TEMPORADA)
        // ===============================
        JLabel temporadaLabel = new JLabel("Denboraldia:");
        temporadaLabel.setForeground(Color.WHITE);
        temporadaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        temporadaLabel.setBounds(100, 120, 150, 30);
        panel.add(temporadaLabel);

        JComboBox<String> temporadaCombo = new JComboBox<>();
        temporadaCombo.addItem("2022/2023");
        temporadaCombo.addItem("2023/2024");
        temporadaCombo.addItem("2024/2025");
        temporadaCombo.setBounds(100, 160, 180, 35);
        panel.add(temporadaCombo);

        // ===============================
        // JARDUNALDIA (JORNADA)
        // ===============================
        JLabel jornadaLabel = new JLabel("Jardunaldia:");
        jornadaLabel.setForeground(Color.WHITE);
        jornadaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        jornadaLabel.setBounds(300, 120, 150, 30);
        panel.add(jornadaLabel);

        JComboBox<String> jornadaCombo = new JComboBox<>();
        jornadaCombo.addItem("Jardunaldia 1");
        jornadaCombo.addItem("Jardunaldia 2");
        jornadaCombo.addItem("Jardunaldia 3");
        jornadaCombo.setBounds(300, 160, 180, 35);
        panel.add(jornadaCombo);

        // ===============================
        // TAULA (RESULTADOS)
        // ===============================
        String[] columnas = {
                "Talde lokala",
                "Golak lokala",
                "Golak kanpokoa",
                "Talde kanpokoa"
        };

        Object[][] datos = {
                {"[Talde lokala izena]", "[Golak lokala]", "[Golak kanpokoa]", "[Talde kanpoko izena]"},
                {"[Talde lokala izena]", "[Golak lokala]", "[Golak kanpokoa]", "[Talde kanpoko izena]"},
                {"[Talde lokala izena]", "[Golak lokala]", "[Golak kanpokoa]", "[Talde kanpoko izena]"}
        };

        JTable taula = new JTable(datos, columnas);
        taula.setRowHeight(35);
        taula.setFont(new Font("Arial", Font.PLAIN, 14));
        taula.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollTaula = new JScrollPane(taula);
        scrollTaula.setBounds(100, 230, 700, 220);
        panel.add(scrollTaula);

        // ===============================
        // BOTOIA - SAIOA AMAITU
        // ===============================
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);
        panel.add(saioaAmaituBotoia);
    }


    /**
     * Emaitzak panel hau itzultzen du
     */
    public JPanel getPanel() {
        return panel;
    }
}
