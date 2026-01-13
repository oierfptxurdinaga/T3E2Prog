package Erronka2.view;

import Erronka2.model.Jokalaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Taldeak pestañako interfazea eta edukia kudeatzen du.
 */
public class TaldeakMetodo {

    private JPanel panelTaldeak;
    private JPanel gridPanel;
    private JButton saioaAmaituBotoia;
    private JButton botoia;
    private DefaultListModel<Jokalaria> model;
    private ImageIcon icono;
    private List<Jokalaria> jokalariak;
    private  JList<Jokalaria> lista;
    private JScrollPane scrollPane;
    private Image img;

    /**
     * Eraikitzailea - Taldeak panel nagusia sortu eta botoiak gehitu
     */
    public TaldeakMetodo(Color kolorea) {

        panelTaldeak = new JPanel(null);
        panelTaldeak.setBackground(kolorea);

        // ===============================
        // TALDEEN GRID-A
        // ===============================
        gridPanel = new JPanel(new GridLayout(2, 3, 30, 30));
        gridPanel.setBackground(kolorea);
        gridPanel.setBounds(50, 50, 800, 380);

        gridPanel.add(taldeBotoiaSortu(
                "Otxarkoaga Distira",
                "/Erronka2/images/LogosEquipos/OtxarkoagaDistira.png"));

        gridPanel.add(taldeBotoiaSortu(
                "Miribilla Uhinen Jokoak",
                "/Erronka2/images/LogosEquipos/MiribillaUhinenJokoak.png"));

        gridPanel.add(taldeBotoiaSortu(
                "Txurdinaga Harriak",
                "/Erronka2/images/LogosEquipos/TxurdinagaHarriak.png"));

        gridPanel.add(taldeBotoiaSortu(
                "Usansolo Hortzadak",
                "/Erronka2/images/LogosEquipos/UsansoloHortzadak.png"));

        gridPanel.add(taldeBotoiaSortu(
                "Matiko Txirrindulariak",
                "/Erronka2/images/LogosEquipos/MatikoTxirrindulariak.png"));

        gridPanel.add(taldeBotoiaSortu(
                "Santutxu Haizeak",
                "/Erronka2/images/LogosEquipos/SantutxuHaizeak.png"));

        panelTaldeak.add(gridPanel);

        // ===============================
        // SAIOA AMAITU BOTOIA
        // ===============================
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

        panelTaldeak.add(saioaAmaituBotoia);
    }

    /**
     * Talde bakoitzerako botoia sortzen du (logo + izena)
     * Klik egitean, taldeko jokalariak erakusten dira
     */
    private JButton taldeBotoiaSortu(String izena, String logoPath) {

        botoia = new JButton(izena);

        // Logoa kargatu
        java.net.URL url = getClass().getResource(logoPath);
        if (url != null) {
            icono = new ImageIcon(url);
            img = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
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

        // Klik egiterakoan jokalariak erakutsi
        botoia.addActionListener(e -> erakutsiJokalariak(izena));

        return botoia;
    }

    private void erakutsiJokalariak(String taldeIzena) {

        int taldeKod = lortuTaldeKod(taldeIzena);

        if (taldeKod == -1) {
            JOptionPane.showMessageDialog(panelTaldeak,
                    "Taldea ez da aurkitu",
                    "Errorea",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Modelotik jokalariak lortu
        jokalariak = Jokalaria.getJokalariakByTaldea(taldeKod);

        if (jokalariak.isEmpty()) {
            JOptionPane.showMessageDialog(panelTaldeak,
                    "Ez dago jokalaririk talde honetan",
                    "Informazioa",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Jokalariak JList batean sartu
        model = new DefaultListModel<>();
        for (Jokalaria j : jokalariak) {
            model.addElement(j);
        }

        lista = new JList<>(model);
        lista.setFont(new Font("Arial", Font.PLAIN, 16));

        scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(350, 250));

        JOptionPane.showMessageDialog(
                panelTaldeak,
                scrollPane,
                taldeIzena + " - Jokalariak",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Taldearen izenaren arabera bere kodea bueltatzen du
     */
    private int lortuTaldeKod(String taldeIzena) {

        switch (taldeIzena) {
            case "Otxarkoaga Distira":
                return 1;
            case "Miribilla Uhinen Jokoak":
                return 2;
            case "Txurdinaga Harriak":
                return 3;
            case "Usansolo Hortzadak":
                return 4;
            case "Matiko Txirrindulariak":
                return 5;
            case "Santutxu Haizeak":
                return 6;
            default:
                return -1;
        }
    }

    /**
     * Taldeak panela itzultzen du
     */
    public JPanel getPanel() {
        return panelTaldeak;
    }
}
