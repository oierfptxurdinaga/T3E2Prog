package Erronka2.view;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

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
        getContentPane().setBackground(new Color(0, 102, 204)); // Atzeko plano urdina
        
        // ------------------------------
        // LOGOA ETA IZENA
        // ------------------------------
     // Logoa kargatu proiektuaren 'images' karpetatik
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/logo.png"));

        // Eskalatu irudia JLabel-aren tamainara
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(30, 30, 100, 100); // Posizioa eta tamaina
        getContentPane().add(logoLabel);

        // Federazioaren izena
        JLabel nombreLabel = new JLabel("Boleibol Federazioa");
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setBounds(140, 60, 300, 50);
        getContentPane().add(nombreLabel);

        // ------------------------------
        // ERABILTZAILE ETA PASAHITZA KAMPOAK
        // ------------------------------
        JLabel usuarioLabel = new JLabel("Erabiltzailea:");
        usuarioLabel.setForeground(Color.WHITE);
        usuarioLabel.setBounds(50, 160, 100, 25);
        getContentPane().add(usuarioLabel);

        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(160, 160, 200, 25);
        getContentPane().add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Pasahitza:");
        contrasenaLabel.setForeground(Color.WHITE);
        contrasenaLabel.setBounds(50, 200, 100, 25);
        getContentPane().add(contrasenaLabel);

        JPasswordField contrasenaField = new JPasswordField();
        contrasenaField.setBounds(160, 200, 200, 25);
        contrasenaField.setEchoChar('*'); // Asteriskoak erakutsi lehenetsita
        getContentPane().add(contrasenaField);

        // Pasahitza erakutsi/ezkutatu botoi txikia
        JButton mostrarBtn = new JButton("👁");
        mostrarBtn.setBounds(370, 200, 56, 25);
        getContentPane().add(mostrarBtn);
        
	     // ------------------------------
	     // SARTU BOTOIA
	     // ------------------------------
	     JButton sartuBtn = new JButton("Sartu");
	     sartuBtn.setBounds(217, 284, 100, 25); // Kokapena
	     getContentPane().add(sartuBtn);


        // ------------------------------
        // IRTEERAKO BOTOA
        // ------------------------------
        JButton salirBtn = new JButton("Irten");
        salirBtn.setBackground(Color.RED);
        salirBtn.setForeground(Color.WHITE);
        salirBtn.setBounds(400, 10, 80, 30);
        getContentPane().add(salirBtn);

        // Frame-a bistaratzea
        setVisible(true);
    }

    public static void main(String[] args) {
        // Frame baten instantzia sortu
        new Login();
    }
}
