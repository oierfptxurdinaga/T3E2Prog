package Erronka2.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Main klasea - Aplikazio nagusiaren interfazea eta eguneraketa metodoak.
 * 
 * JFrame baten bidez, aplikazioaren fitxa-panel nagusia kudeatzen du,
 * eta bertan hainbat fitxa ditu: Partiduak, Fitxaketak, Taldeak, Klasifikazioa eta Emaitzak.
 * Fitxa bakoitzak bere panela du eta eguneraketak kudeatzen dira.
 */
public class Main extends JFrame {
    private JPanel panelNagusia;               // Leiho nagusiko panela
    private JTabbedPane fitxaPanela;           // Fitxak kudeatzeko panela
    private EmaitzakMetodo emaitzakPanela;     // Emaitzak panela
    private KlasifikazioaMetodo klasifikazioaPanela; // Klasifikazioa panela
    private PartiduakMetodo partiduakPanela;   // Partiduak panela
    private FitxaketakMetodo fitxaketakPanela; // Fitxaketak panela
    private TaldeakMetodo taldeakPanela;       // Taldeak panela

    /**
     * Eraikitzailea - Aplikazioaren leihoa sortu eta fitxak gehitzen ditu.
     */
    public Main() {
        try {
            setTitle("Boleibol Federazioa - 3. Taldea - Sistema");
            setSize(1000, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Color urdina = new Color(0, 70, 160);

            panelNagusia = new JPanel(new BorderLayout());
            panelNagusia.setBackground(urdina);
            setContentPane(panelNagusia);

            // Fitxa panela sortu eta konfiguratu
            fitxaPanela = new JTabbedPane();
            fitxaPanela.setFont(new Font("Arial", Font.BOLD, 14));

            try {
                // Panel bakoitza sortu, try-catch erabiliz erroreak kontrolatzeko
                partiduakPanela = new PartiduakMetodo(urdina, this);
                fitxaketakPanela = new FitxaketakMetodo(urdina);
                taldeakPanela = new TaldeakMetodo(urdina);
                klasifikazioaPanela = new KlasifikazioaMetodo(urdina);
                emaitzakPanela = new EmaitzakMetodo(urdina);
            } catch (Exception e) {
                System.err.println("Errorea panelak sortzerakoan: " + e.getMessage());
                JOptionPane.showMessageDialog(this, 
                    "Errorea interfazearen osagaiak kargatzerakoan: " + e.getMessage(), 
                    "Errorea", JOptionPane.ERROR_MESSAGE);
                // Saia gaitezen aurrera jarraitzen dugun osagai batzuekin
            }

            // Fitxak gehitu, errore posibleak kontrolatuz
            try {
                if (partiduakPanela != null && partiduakPanela.getPanela() != null) {
                    fitxaPanela.addTab("Partiduak", partiduakPanela.getPanela());
                }
            } catch (Exception e) {
                System.err.println("Errorea Partiduak fitxa gehitzean: " + e.getMessage());
            }

            try {
                if (fitxaketakPanela != null && fitxaketakPanela.getPanela() != null) {
                    fitxaPanela.addTab("Fitxaketak", fitxaketakPanela.getPanela());
                }
            } catch (Exception e) {
                System.err.println("Errorea Fitxaketak fitxa gehitzean: " + e.getMessage());
            }

            try {
                if (taldeakPanela != null && taldeakPanela.getPanela() != null) {
                    fitxaPanela.addTab("Taldeak", taldeakPanela.getPanela());
                }
            } catch (Exception e) {
                System.err.println("Errorea Taldeak fitxa gehitzean: " + e.getMessage());
            }

            try {
                if (klasifikazioaPanela != null && klasifikazioaPanela.getPanela() != null) {
                    fitxaPanela.addTab("Klasifikazioa", klasifikazioaPanela.getPanela());
                }
            } catch (Exception e) {
                System.err.println("Errorea Klasifikazioa fitxa gehitzean: " + e.getMessage());
            }

            try {
                if (emaitzakPanela != null && emaitzakPanela.getPanela() != null) {
                    fitxaPanela.addTab("Emaitzak", emaitzakPanela.getPanela());
                }
            } catch (Exception e) {
                System.err.println("Errorea Emaitzak fitxa gehitzean: " + e.getMessage());
            }

            // Fitxa aldatzean eguneratzeak egiteko entzulea gehitu
            fitxaPanela.addChangeListener(new ChangeListener() {
                /**
                 * Fitxa aldatzean dagokion panela eguneratzen du behar izanez gero.
                 * @param e ChangeEvent
                 */
                @Override
                public void stateChanged(ChangeEvent e) {
                    try {
                        int hautatutakoIndizea = fitxaPanela.getSelectedIndex();
                        switch (hautatutakoIndizea) {
                            case 3: // Klasifikazioa fitxa
                                if (klasifikazioaPanela != null) {
                                    klasifikazioaPanela.eguneratuTaula();
                                }
                                break;
                            case 4: // Emaitzak fitxa
                                if (emaitzakPanela != null) {
                                    emaitzakPanela.eguneratuTaula();
                                }
                                break;
                        }
                    } catch (Exception ex) {
                        System.err.println("Errorea fitxa aldatzeko: " + ex.getMessage());
                        JOptionPane.showMessageDialog(Main.this, 
                            "Errorea datuak kargatzerakoan: " + ex.getMessage(), 
                            "Errorea", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            panelNagusia.add(fitxaPanela, BorderLayout.CENTER);

            // Hasierako mezua konsolan
            System.out.println("Aplikazioa Erabiltzaileak hasita");

        } catch (HeadlessException e) {
            System.err.println("Errorea interfazea sortzerakoan (Headless): " + e.getMessage());
            JOptionPane.showMessageDialog(null, 
                "Errorea interfazea sortzerakoan. Ziurtatu sistema leihoak onartzen dituela.", 
                "Errorea Larria", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Errorea Main frame-a sortzerakoan: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Errorea aplikazio nagusia hasieratzerakoan: " + e.getMessage(), 
                "Errorea Larria", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Fitxa guztiak eguneratu behar denean deitu.
     * Normalean partida bat gehitu ondoren erabiltzen da.
     */
    public void eguneratuDena() {
        try {
            if (klasifikazioaPanela != null) {
                klasifikazioaPanela.eguneratuTaula();
            }
        } catch (Exception e) {
            System.err.println("Errorea klasifikazioa eguneratzerakoan: " + e.getMessage());
        }

        try {
            if (emaitzakPanela != null) {
                emaitzakPanela.eguneratuTaula();
            }
        } catch (Exception e) {
            System.err.println("Errorea emaitzak eguneratzerakoan: " + e.getMessage());
        }
        // Behar izanez gero beste fitxak ere eguneratu daitezke hemen
    }

    /**
     * Main metodoa - aplikazioa martxan jartzen du.
     * Hemen Login leihoa abiarazten da zuzenean.
     *
     * @param args Komando lerroko argumentuak
     */
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> new Login().setVisible(true));
        } catch (Exception e) {
            System.err.println("Errorea aplikazioa abiarazterakoan: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Errorea aplicazioa abiarazterakoan: " + e.getMessage(),
                "Errorea Larria", JOptionPane.ERROR_MESSAGE);
        }
    }
}
