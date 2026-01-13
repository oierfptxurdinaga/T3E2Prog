package Erronka2.view;

import javax.swing.*;

import Erronka2.model.Rola;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private ImageIcon logoIcon;
	private Image logoImage;
	private ImageIcon scaledLogoIcon;
	private JLabel usuarioLabel;
	private JLabel logoLabel;
	private JLabel nombreLabel;
	private JTextField erabiltzaileField;
	private JLabel contrasenaLabel;
	private JPasswordField pasahitzaField;
	private JButton mostrarBtn;
	private JButton sartuBtn;
	private JButton salirBtn;
	private JLabel lblFederazioa;

    // Frame-aren eraikitzailea
    /**
     * 
     */
    public Login() {
        // Frame-aren izenburua
        super("Boleibol Federazioa - Saioa hasi");

        // Frame-a konfigurazioa
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Leihoa erdian kokatu
        getContentPane().setLayout(null); // Layout absolutua, posizio zehatzak ezartzeko
        getContentPane().setBackground(new Color(60, 72, 191)); // Atzeko plano urdina
        
        // LOGOA ETA IZENA
        // Logoa kargatu proiektuaren 'images' karpetatik
         logoIcon = new ImageIcon(
        	    getClass().getResource("/Erronka2/images/Logo_sinFondo.png")
        	);
        // Eskalatu irudia JLabel-aren tamainara
        logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        scaledLogoIcon = new ImageIcon(logoImage);

        logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(32, 36, 100, 100); // Posizioa eta tamaina
        getContentPane().add(logoLabel);

        // Federazioaren izena
        nombreLabel = new JLabel("Boleibol ");
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setBounds(160, 47, 208, 50);
        getContentPane().add(nombreLabel);

        // ERABILTZAILE ETA PASAHITZA KANPOAK
        usuarioLabel = new JLabel("Erabiltzailea:");
        usuarioLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        usuarioLabel.setForeground(Color.WHITE);
        usuarioLabel.setBounds(50, 160, 100, 25);
        getContentPane().add(usuarioLabel);

        erabiltzaileField = new JTextField();
        erabiltzaileField.setBounds(160, 160, 200, 25);
        getContentPane().add(erabiltzaileField);

        contrasenaLabel = new JLabel("Pasahitza:");
        contrasenaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        contrasenaLabel.setForeground(Color.WHITE);
        contrasenaLabel.setBounds(50, 200, 100, 25);
        getContentPane().add(contrasenaLabel);

        pasahitzaField = new JPasswordField();
        pasahitzaField.setBounds(160, 200, 200, 25);
        pasahitzaField.setEchoChar('*'); // Asteriskoak erakutsi lehenetsita
        getContentPane().add(pasahitzaField);

        // Pasahitza erakutsi/ezkutatu botoi txikia
        mostrarBtn = new JButton("👁");
        mostrarBtn.setBackground(new Color(255, 255, 255));
        mostrarBtn.setBounds(370, 200, 56, 25);
        mostrarBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Sakatuta mantentzen den bitartean, pasahitza erakusten du
                pasahitzaField.setEchoChar((char) 0);
                mostrarBtn.setText("-");
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // Botoia sakatzeari uzten denean, pasahitza ezkutatuko da
                pasahitzaField.setEchoChar('*');
                mostrarBtn.setText("👁");
            }
        });
        getContentPane().add(mostrarBtn);
       
	     // SARTU BOTOIA
	     sartuBtn = new JButton("Sartu");
	     sartuBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
	     sartuBtn.setBackground(new Color(255, 255, 255));
	     sartuBtn.addActionListener(new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	        String erabiltzailea = erabiltzaileField.getText().trim();
	    	        String pasahitza = new String(pasahitzaField.getPassword()).trim();

	    	        //Begiratzen du ea erabiltzaile eta pasahitza beteta dagoen.
	    	        if (erabiltzailea.isEmpty() || pasahitza.isEmpty()) {
	    	            JOptionPane.showMessageDialog(Login.this, "Mesedez, bete erabiltzailea eta pasahitza", "Errorea", JOptionPane.ERROR_MESSAGE);
	    	        } else {
	    	            // Autenticación con Rola
	    	            Rola rol = Rola.Egiaztatu(erabiltzailea, pasahitza);

	    	            if (rol != null) {
	    	                // Erabiltzailea ondo sartuta main orrira sartu eta ongi etorria emango du.
	    	                JOptionPane.showMessageDialog(Login.this, "Ongi etorri, " + erabiltzailea + " !!");
	    	                SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	    	                dispose(); // Login lehioa itxi
	    	            } else {
	    	                // Sartzerakoan ez badaude existitzen 
	    	                JOptionPane.showMessageDialog(Login.this, "Erabiltzailea edo pasahitza okerra", "Errorea", JOptionPane.ERROR_MESSAGE);
	    	            }
	    	        }
	    	    }
	    	});

	     sartuBtn.setBounds(196, 284, 100, 25); // Kokapena
	     getContentPane().add(sartuBtn);



        // IRTEERAKO BOTOIA sakatzerakoan, programatik irteteko da
        salirBtn = new JButton("Irten");
        salirBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        salirBtn.setBackground(Color.RED);
        salirBtn.setForeground(Color.WHITE);
        salirBtn.setBounds(400, 10, 80, 30);
        getContentPane().add(salirBtn);
        
        lblFederazioa = new JLabel("\nFederazioa");
        lblFederazioa.setHorizontalAlignment(SwingConstants.CENTER);
        lblFederazioa.setForeground(Color.WHITE);
        lblFederazioa.setFont(new Font("Arial", Font.BOLD, 30));
        lblFederazioa.setBounds(160, 84, 213, 50);
        getContentPane().add(lblFederazioa);

        // Frame-a bistaratzea
        setVisible(true);
    }

    public static void main(String[] args) {
        // Frame baten instantzia sortu
        new Login();
    }
}
