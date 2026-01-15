package Erronka2.view;

import javax.swing.*;

import Erronka2.model.Rola;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private ImageIcon logoIkurra;
    private Image logoIrudia;
    private ImageIcon eskalatutakoLogoIkurra;
    private JLabel erabiltzaileEtiketa;
    private JLabel logoEtiketa;
    private JLabel izenEtiketa;
    private JTextField erabiltzaileEremua;
    private JLabel pasahitzaEtiketa;
    private JPasswordField pasahitzaEremua;
    private JButton erakutsiBotoia;
    private JButton sartuBotoia;
    private JButton irtenBotoia;
    private JLabel lblFederazioa;

    /**
     * Frame-aren eraikitzailea
     */
    public Login() {
        // El constructor debe ser lo primero
        super("Boleibol Federazioa - Saioa hasi");
        
        try {
            // Frame-a konfigurazioa
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Leihoa erdian kokatu
            getContentPane().setLayout(null); // Layout absolutua, posizio zehatzak ezartzeko
            getContentPane().setBackground(new Color(60, 72, 191)); // Atzeko plano urdina
            
            // LOGOA ETA IZENA
            // Logoa kargatu proiektuak 'images' karpetatik
            try {
                logoIkurra = new ImageIcon(
                    getClass().getResource("/Erronka2/images/Logo_sinFondo.png")
                );
                
                if (logoIkurra == null) {
                    throw new Exception("Ezin izan da logoa kargatu. Path okerra: /Erronka2/images/Logo_sinFondo.png");
                }
                
                // Eskalatu irudia JLabel-aren tamainara
                logoIrudia = logoIkurra.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                eskalatutakoLogoIkurra = new ImageIcon(logoIrudia);

                logoEtiketa = new JLabel(eskalatutakoLogoIkurra);
                logoEtiketa.setBounds(32, 36, 100, 100); // Posizioa eta tamaina
                getContentPane().add(logoEtiketa);
                
            } catch (Exception e) {
                // Si falla la carga de logo, usar texto alternativo
                System.err.println("Errorea logo kargatzerakoan: " + e.getMessage());
                logoEtiketa = new JLabel("[LOGOA]");
                logoEtiketa.setForeground(Color.WHITE);
                logoEtiketa.setFont(new Font("Arial", Font.BOLD, 14));
                logoEtiketa.setBounds(32, 36, 100, 100);
                getContentPane().add(logoEtiketa);
            }

            // Federazioaren izena
            izenEtiketa = new JLabel("Boleibol ");
            izenEtiketa.setHorizontalAlignment(SwingConstants.CENTER);
            izenEtiketa.setFont(new Font("Arial", Font.BOLD, 30));
            izenEtiketa.setForeground(Color.WHITE);
            izenEtiketa.setBounds(160, 47, 208, 50);
            getContentPane().add(izenEtiketa);

            // ERABILTZAILE ETA PASAHITZA KANPOAK
            erabiltzaileEtiketa = new JLabel("Erabiltzailea:");
            erabiltzaileEtiketa.setFont(new Font("Tahoma", Font.BOLD, 13));
            erabiltzaileEtiketa.setForeground(Color.WHITE);
            erabiltzaileEtiketa.setBounds(50, 160, 100, 25);
            getContentPane().add(erabiltzaileEtiketa);

            erabiltzaileEremua = new JTextField();
            erabiltzaileEremua.setBounds(160, 160, 200, 25);
            getContentPane().add(erabiltzaileEremua);

            pasahitzaEtiketa = new JLabel("Pasahitza:");
            pasahitzaEtiketa.setFont(new Font("Tahoma", Font.BOLD, 13));
            pasahitzaEtiketa.setForeground(Color.WHITE);
            pasahitzaEtiketa.setBounds(50, 200, 100, 25);
            getContentPane().add(pasahitzaEtiketa);

            pasahitzaEremua = new JPasswordField();
            pasahitzaEremua.setBounds(160, 200, 200, 25);
            pasahitzaEremua.setEchoChar('*'); // Asteriskoak erakutsi lehenetsita
            getContentPane().add(pasahitzaEremua);

            // Pasahitza erakutsi/ezkutatu botoi txikia
            erakutsiBotoia = new JButton("👁");
            erakutsiBotoia.setBackground(new Color(255, 255, 255));
            erakutsiBotoia.setBounds(370, 200, 56, 25);
            erakutsiBotoia.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                        // Sakatuta mantentzen den bitartean, pasahitza erakusten du
                        pasahitzaEremua.setEchoChar((char) 0);
                        erakutsiBotoia.setText("-");
                    } catch (Exception ex) {
                        System.err.println("Errorea pasahitza erakusteko: " + ex.getMessage());
                    }
                }
                
                @Override
                public void mouseReleased(MouseEvent e) {
                    try {
                        // Botoia sakatzeari uzten denean, pasahitza ezkutatuko da
                        pasahitzaEremua.setEchoChar('*');
                        erakutsiBotoia.setText("👁");
                    } catch (Exception ex) {
                        System.err.println("Errorea pasahitza ezkutatzeko: " + ex.getMessage());
                    }
                }
            });
            getContentPane().add(erakutsiBotoia);
           
         // SARTU BOTOIA
         sartuBotoia = new JButton("Sartu");
         sartuBotoia.setFont(new Font("Tahoma", Font.BOLD, 12));
         sartuBotoia.setBackground(new Color(255, 255, 255));
         sartuBotoia.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String erabiltzailea = erabiltzaileEremua.getText().trim();
                        String pasahitza = new String(pasahitzaEremua.getPassword()).trim();

                        //Begiratzen du ea erabiltzaile eta pasahitza beteta dagoen.
                        if (erabiltzailea.isEmpty() || pasahitza.isEmpty()) {
                            throw new IllegalArgumentException("Mesedez, bete erabiltzailea eta pasahitza");
                        }

                        // Autentikazioa Rola-rekin
                        Rola rol = Rola.Egiaztatu(erabiltzailea, pasahitza);

                        if (rol != null) {
                            // Erabiltzailea ondo sartuta main orrira sartu eta ongi etorria emango du.
                            JOptionPane.showMessageDialog(Login.this, "Ongi etorri, " + erabiltzailea + " !!");
                            SwingUtilities.invokeLater(() -> new Main().setVisible(true));
                            dispose(); // Login lehioa itxi
                        } else {
                            // Sartzerakoan ez badaude existitzen 
                            throw new SecurityException("Erabiltzailea edo pasahitza okerra");
                        }
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(Login.this, ex.getMessage(), "Abisua", 
                            JOptionPane.WARNING_MESSAGE);
                    } catch (SecurityException ex) {
                        JOptionPane.showMessageDialog(Login.this, ex.getMessage(), "Errorea", 
                            JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Login.this, 
                            "Errorea sistemara sartzerakoan: " + ex.getMessage(), 
                            "Errorea", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            });

         sartuBotoia.setBounds(196, 284, 100, 25); // Kokapena
         getContentPane().add(sartuBotoia);

        // IRTEERAKO BOTOIA sakatzerakoan, programatik irteteko da
        irtenBotoia = new JButton("Irten");
        irtenBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(0);
                } catch (SecurityException ex) {
                    JOptionPane.showMessageDialog(Login.this, 
                        "Ez dago baimenik aplikazioa ixteko: " + ex.getMessage(),
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Login.this, 
                        "Errorea aplikazioa ixteko: " + ex.getMessage(),
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        irtenBotoia.setBackground(Color.RED);
        irtenBotoia.setForeground(Color.WHITE);
        irtenBotoia.setBounds(400, 10, 80, 30);
        getContentPane().add(irtenBotoia);
        
        lblFederazioa = new JLabel("\nFederazioa");
        lblFederazioa.setHorizontalAlignment(SwingConstants.CENTER);
        lblFederazioa.setForeground(Color.WHITE);
        lblFederazioa.setFont(new Font("Arial", Font.BOLD, 30));
        lblFederazioa.setBounds(160, 84, 213, 50);
        getContentPane().add(lblFederazioa);

        // Frame-a bistaratzea
        setVisible(true);
            
        } catch (HeadlessException e) {
            System.err.println("Errorea interfazea sortzerakoan (Headless): " + e.getMessage());
            JOptionPane.showMessageDialog(null, 
                "Errorea interfazea sortzerakoan. Ziurtatu sistema leihoak onartzen dituela.", 
                "Errorea Larria", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.err.println("Errorea Login frame-a sortzerakoan: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Errorea aplikazioa hasieratzerakoan: " + e.getMessage(), 
                "Errorea Larria", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            // Frame baten instantzia sortu
            SwingUtilities.invokeLater(() -> new Login());
        } catch (Exception e) {
            System.err.println("Errorea aplikazioa abiarazterakoan: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Errorea aplikazioa abiarazterakoan: " + e.getMessage(), 
                "Errorea Larria", JOptionPane.ERROR_MESSAGE);
        }
    }
}