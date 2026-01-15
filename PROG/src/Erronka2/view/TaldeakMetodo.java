package Erronka2.view;

import Erronka2.model.Jokalaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Taldeak fitxako interfazea eta edukia kudeatzen du.
 */
public class TaldeakMetodo {

    private JPanel taldeakPanela;
    private JPanel sarePanela;
    private JButton saioaAmaituBotoia;
    private JButton botoia;
    private DefaultListModel<Jokalaria> modeloa;
    private ImageIcon ikonoa;
    private List<Jokalaria> jokalariak;
    private  JList<Jokalaria> zerrenda;
    private JScrollPane korritzePanela;
    private Image irudia;

    /**
     * Eraikitzailea - Taldeak panel nagusia sortu eta botoiak gehitu
     */
    public TaldeakMetodo(Color kolorea) {

        taldeakPanela = new JPanel(null);
        taldeakPanela.setBackground(kolorea);

        // ===============================
        // TALDEEN SAREA
        // ===============================
        sarePanela = new JPanel(new GridLayout(2, 3, 30, 30));
        sarePanela.setBackground(kolorea);
        sarePanela.setBounds(50, 50, 800, 380);

        try {
            sarePanela.add(taldeBotoiaSortu(
                    "Otxarkoaga Distira",
                    "/Erronka2/images/LogosEquipos/OtxarkoagaDistira.png"));

            sarePanela.add(taldeBotoiaSortu(
                    "Miribilla Uhinen Jokoak",
                    "/Erronka2/images/LogosEquipos/MiribillaUhinenJokoak.png"));

            sarePanela.add(taldeBotoiaSortu(
                    "Txurdinaga Harriak",
                    "/Erronka2/images/LogosEquipos/TxurdinagaHarriak.png"));

            sarePanela.add(taldeBotoiaSortu(
                    "Usansolo Hortzadak",
                    "/Erronka2/images/LogosEquipos/UsansoloHortzadak.png"));

            sarePanela.add(taldeBotoiaSortu(
                    "Matiko Txirrindulariak",
                    "/Erronka2/images/LogosEquipos/MatikoTxirrindulariak.png"));

            sarePanela.add(taldeBotoiaSortu(
                    "Santutxu Haizeak",
                    "/Erronka2/images/LogosEquipos/SantutxuHaizeak.png"));
                    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(taldeakPanela,
                "Errorea talde botoiak sortzerakoan: " + e.getMessage(),
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        taldeakPanela.add(sarePanela);

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
				try {
					SwingUtilities.invokeLater(() -> new Login().setVisible(true));
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
					frame.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(taldeakPanela,
						"Errorea saioa amaitzerakoan: " + ex.getMessage(),
						"Errorea", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}

		});

        taldeakPanela.add(saioaAmaituBotoia);
    }

    /**
     * Talde bakoitzerako botoia sortzen du (logo + izena)
     * Klik egitean, taldeko jokalariak erakusten dira
     */
    private JButton taldeBotoiaSortu(String izena, String logoBidea) throws Exception {

        botoia = new JButton(izena);

        // Logoa kargatu
        try {
            java.net.URL url = getClass().getResource(logoBidea);
            if (url != null) {
                ikonoa = new ImageIcon(url);
                irudia = ikonoa.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                botoia.setIcon(new ImageIcon(irudia));
            } else {
                throw new Exception("Ezin izan da logoa kargatu: " + logoBidea);
            }
        } catch (Exception e) {
            throw new Exception("Errorea logo kargatzerakoan talderako " + izena + ": " + e.getMessage(), e);
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
        botoia.addActionListener(e -> {
            try {
                erakutsiJokalariak(izena);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(taldeakPanela,
                    "Errorea jokalariak erakusteko: " + ex.getMessage(),
                    "Errorea", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        return botoia;
    }

    private void erakutsiJokalariak(String taldeIzena) throws Exception {

        int taldeKod = lortuTaldeKod(taldeIzena);

        if (taldeKod == -1) {
            throw new IllegalArgumentException("Taldea ez da aurkitu: " + taldeIzena);
        }

        try {
            // Modelotik jokalariak lortu
            jokalariak = Jokalaria.getJokalariakByTaldea(taldeKod);

            if (jokalariak == null) {
                throw new IllegalStateException("Jokalarien zerrenda nulua itzuli da.");
            }

            if (jokalariak.isEmpty()) {
                JOptionPane.showMessageDialog(taldeakPanela,
                        "Ez dago jokalaririk talde honetan",
                        "Informazioa",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Jokalariak JList batean sartu
            modeloa = new DefaultListModel<>();
            for (Jokalaria j : jokalariak) {
                if (j == null) {
                    throw new IllegalStateException("Jokalari nulua aurkitu da.");
                }
                modeloa.addElement(j);
            }

            zerrenda = new JList<>(modeloa);
            zerrenda.setFont(new Font("Arial", Font.PLAIN, 16));

            korritzePanela = new JScrollPane(zerrenda);
            korritzePanela.setPreferredSize(new Dimension(350, 250));

            JOptionPane.showMessageDialog(
                    taldeakPanela,
                    korritzePanela,
                    taldeIzena + " - Jokalariak",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            throw new Exception("Errorea jokalariak erakusteko " + taldeIzena + " talderako: " + e.getMessage(), e);
        }
    }

    /**
     * Taldearen izenaren arabera bere kodea bueltatzen du
     */
    private int lortuTaldeKod(String taldeIzena) throws IllegalArgumentException {
        if (taldeIzena == null || taldeIzena.trim().isEmpty()) {
            throw new IllegalArgumentException("Taldearen izena ezin da hutsik egon.");
        }

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
    public JPanel getPanela() {
        return taldeakPanela;
    }
}