package Erronka2;

import javax.swing.*;
import java.awt.*;

/**
 * Taldeak pestañako interfazea eta edukia kudeatzen du.
 */
public class TaldeakMetodo {

    private JPanel panelTaldeak;

    /**
     * Eraikitzailea - Taldeak panel nagusia sortu eta botoiak gehitu
     * @param kolorea Atzeko kolorea, kasu honetan urdina
     */
    public TaldeakMetodo(Color kolorea) {

        panelTaldeak = new JPanel(null);
        panelTaldeak.setBackground(kolorea);

        // ===============================
        // TALDEEN GRID-A
        // ===============================
        JPanel gridPanel = new JPanel(new GridLayout(2, 3, 30, 30));
        gridPanel.setBackground(kolorea);
        gridPanel.setBounds(50, 50, 800, 380);

        gridPanel.add(taldeBotoiaSortu("Otxarkoaga Distira", "/LogosEquipos/OtxarkoagaDistira.png"));
        gridPanel.add(taldeBotoiaSortu("Miribilla Uhinen Jokoak", "/LogosEquipos/MiribillaUhinenJokoak.png"));
        gridPanel.add(taldeBotoiaSortu("Txurdinaga Harriak", "/LogosEquipos/TxurdinagaHarriak.png"));
        gridPanel.add(taldeBotoiaSortu("Usansolo Hortzadak", "/LogosEquipos/UsansoloHortzadak.png"));
        gridPanel.add(taldeBotoiaSortu("Matiko Txirrindulariak", "/LogosEquipos/MatikoTxirrindulariak.png"));
        gridPanel.add(taldeBotoiaSortu("Santutxu Haizeak", "/LogosEquipos/SantutxuHaizeak.png"));

        panelTaldeak.add(gridPanel);

        // ===============================
        // BOTOIA - SAIOA AMAITU
        // MISMA POSICIÓN Y TAMAÑO
        // ===============================
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
        saioaAmaituBotoia.setFont(new Font("Arial", Font.BOLD, 18));
        saioaAmaituBotoia.setBackground(Color.RED);
        saioaAmaituBotoia.setForeground(Color.WHITE);
        saioaAmaituBotoia.setFocusPainted(false);
        saioaAmaituBotoia.setBounds(700, 480, 170, 40);

        panelTaldeak.add(saioaAmaituBotoia);
    }

    /**
     * Talde bakoitzeko botoia sortzen du ikonoarekin eta testuarekin
     */
    private JButton taldeBotoiaSortu(String izena, String logoPath) {
        JButton botoia = new JButton(izena);

        java.net.URL url = getClass().getResource(logoPath);
        if (url != null) {
            ImageIcon icono = new ImageIcon(url);
            Image img = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            botoia.setIcon(new ImageIcon(img));
        }

        botoia.setVerticalTextPosition(SwingConstants.BOTTOM);
        botoia.setHorizontalTextPosition(SwingConstants.CENTER);
        botoia.setFont(new Font("Arial", Font.BOLD, 16));
        botoia.setForeground(Color.WHITE);

        botoia.setBorderPainted(false);
        botoia.setFocusPainted(false);
        botoia.setContentAreaFilled(false);
        botoia.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return botoia;
    }

    /**
     * Taldeak panela itzultzen du
     */
    public JPanel getPanel() {
        return panelTaldeak;
    }
}
