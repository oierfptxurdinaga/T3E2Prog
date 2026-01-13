package Erronka2.view;

import javax.swing.*;

import Erronka2.model.Klasifikazioa;
import Erronka2.model.Partidua;
import Erronka2.model.Taldeak;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Partiduak fitxako interfazea eta edukia kudeatzen ditu.
 */
public class PartiduakMetodo {

	private JPanel panelPartiduak;

	private JTextField etxekoSetak;
	private JTextField kanpokoSetak;

	private JComboBox<String> denboraldiaCombo;
	private JComboBox<String> jardunaldiaCombo;
	private JComboBox<String> etxekoCombo;
	private JComboBox<String> kanpokoCombo;

	private JButton puntuakSartuBotoia;
	private JButton saioaAmaituBotoia;

	private JLabel titulua;
	private JLabel denboraldiaLabel;
	private JLabel jardunaldiaLabel; 
	private JLabel etxekoLabel;
	private JLabel etxekoSetakLabel;
	private JLabel kanpokoLabel;
	private JLabel kanpokoSetakLabel;
	
	private JButton hasiDenboraldiaBotoia; // Nuevo botón

	/**
	 * Eraikitzailea: panel nagusia sortu eta osagai guztiak gehitzen ditu
	 * 
	 * @param kolorea Atzeko planoko kolorea (kasu honetan urdina)
	 */
	public PartiduakMetodo(Color kolorea) {
		panelPartiduak = new JPanel(null); // Layout nulua, kokapen absolutua
		panelPartiduak.setBackground(kolorea);

		// Izenburua
		titulua = new JLabel("PARTIDUAK SARTU");
		titulua.setForeground(Color.WHITE);
		titulua.setFont(new Font("Arial", Font.BOLD, 40));
		titulua.setBounds(250, 40, 400, 50);
		panelPartiduak.add(titulua);
		
		// ===============================
		// BOTÓN "HASI DENBORALDIA"
		// ===============================
		hasiDenboraldiaBotoia = new JButton("Hasi Denboraldia");
		hasiDenboraldiaBotoia.setFont(new Font("Arial", Font.BOLD, 16));
		hasiDenboraldiaBotoia.setBackground(Color.GREEN);
		hasiDenboraldiaBotoia.setForeground(Color.BLACK);
		hasiDenboraldiaBotoia.setBounds(600, 90, 200, 40);
		hasiDenboraldiaBotoia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hasiDenboraldiaBerria();
			}
		});
		panelPartiduak.add(hasiDenboraldiaBotoia);

		// ===============================
		// DENBORALDIA (TEMPORADA)
		// ===============================
		denboraldiaLabel = new JLabel("Aukeratu denboraldia:");
		denboraldiaLabel.setForeground(Color.WHITE);
		denboraldiaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		denboraldiaLabel.setBounds(100, 120, 200, 30);
		panelPartiduak.add(denboraldiaLabel);

		denboraldiaCombo = new JComboBox<>();
		denboraldiaCombo.addItem("2022/2023");
		denboraldiaCombo.addItem("2023/2024");
		denboraldiaCombo.addItem("2024/2025");
		denboraldiaCombo.setBounds(100, 160, 200, 35);
		panelPartiduak.add(denboraldiaCombo);

		// ===============================
		// JARDUNALDIA
		// ===============================
		jardunaldiaLabel = new JLabel("Aukeratu jardunaldia:");
		jardunaldiaLabel.setForeground(Color.WHITE);
		jardunaldiaLabel.setFont(new Font("Arial", Font.BOLD, 18));
		jardunaldiaLabel.setBounds(320, 120, 200, 30);
		panelPartiduak.add(jardunaldiaLabel);

		// Jardunaldia aukeratzeko combo box-a
		jardunaldiaCombo = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			jardunaldiaCombo.addItem("Jardunaldia " + i);
		}
		jardunaldiaCombo.setBounds(320, 160, 200, 35);
		panelPartiduak.add(jardunaldiaCombo);

		// ===============================
		// ETXEKO TALDEA
		// ===============================
		etxekoLabel = new JLabel("Etxeko Taldea:");
		etxekoLabel.setForeground(Color.WHITE);
		etxekoLabel.setFont(new Font("Arial", Font.BOLD, 18));
		etxekoLabel.setBounds(100, 220, 200, 30);
		panelPartiduak.add(etxekoLabel);

		etxekoCombo = new JComboBox<>();
		etxekoCombo.addItem("Otxarkoaga Distira");
		etxekoCombo.addItem("Miribilla Uhinen Jokoak");
		etxekoCombo.addItem("Txurdinaga Harriak");
		etxekoCombo.addItem("Usansolo Hortzadak");
		etxekoCombo.addItem("Matiko Txirrindulariak");
		etxekoCombo.addItem("Santutxu Haizeak");
		etxekoCombo.setBounds(100, 260, 200, 35);
		panelPartiduak.add(etxekoCombo);

		// Etxeko setak etiketa eta testu-eremua
		etxekoSetakLabel = new JLabel("Setak (0-3):");
		etxekoSetakLabel.setForeground(Color.WHITE);
		etxekoSetakLabel.setFont(new Font("Arial", Font.BOLD, 16));
		etxekoSetakLabel.setBounds(100, 320, 100, 25);
		panelPartiduak.add(etxekoSetakLabel);

		etxekoSetak = new JTextField();
		etxekoSetak.setBounds(180, 320, 120, 30);
		panelPartiduak.add(etxekoSetak);

		// ===============================
		// KANPOKO TALDEA
		// ===============================
		kanpokoLabel = new JLabel("Kanpoko Taldea:");
		kanpokoLabel.setForeground(Color.WHITE);
		kanpokoLabel.setFont(new Font("Arial", Font.BOLD, 18));
		kanpokoLabel.setBounds(320, 220, 200, 30);
		panelPartiduak.add(kanpokoLabel);

		kanpokoCombo = new JComboBox<>();
		kanpokoCombo.addItem("Otxarkoaga Distira");
		kanpokoCombo.addItem("Miribilla Uhinen Jokoak");
		kanpokoCombo.addItem("Txurdinaga Harriak");
		kanpokoCombo.addItem("Usansolo Hortzadak");
		kanpokoCombo.addItem("Matiko Txirrindulariak");
		kanpokoCombo.addItem("Santutxu Haizeak");
		kanpokoCombo.setBounds(320, 260, 200, 35);
		panelPartiduak.add(kanpokoCombo);

		// Kanpoko setak etiketa eta testu-eremua
		kanpokoSetakLabel = new JLabel("Setak (0-3):");
		kanpokoSetakLabel.setForeground(Color.WHITE);
		kanpokoSetakLabel.setFont(new Font("Arial", Font.BOLD, 16));
		kanpokoSetakLabel.setBounds(320, 320, 100, 25);
		panelPartiduak.add(kanpokoSetakLabel);

		kanpokoSetak = new JTextField();
		kanpokoSetak.setBounds(400, 320, 120, 30);
		panelPartiduak.add(kanpokoSetak);

		// ===============================
		// BOTOIAK
		// ===============================
		puntuakSartuBotoia = new JButton("Sartu partidua");
		puntuakSartuBotoia.setBounds(200, 380, 200, 40);
		puntuakSartuBotoia.setFont(new Font("Arial", Font.BOLD, 16));
		panelPartiduak.add(puntuakSartuBotoia);

		puntuakSartuBotoia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Verificar si hay temporada actual
					if (Partidua.getUnekoDenboraldia() == null) {
						JOptionPane.showMessageDialog(panelPartiduak,
								"Lehenik denboraldia bat hasi behar duzu.", "Abisua",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					String etxekoIzena = (String) etxekoCombo.getSelectedItem();
					String kanpokoIzena = (String) kanpokoCombo.getSelectedItem();
					String jardunaldia = (String) jardunaldiaCombo.getSelectedItem();
					String denboraldia = (String) denboraldiaCombo.getSelectedItem();
					
					// Verificar que no se introducen resultados de otra temporada
					if (!denboraldia.equals(Partidua.getUnekoDenboraldia())) {
						JOptionPane.showMessageDialog(panelPartiduak,
								"Ezin duzu partidurik sartu denboraldi honetan. Uneko denboraldia: " + 
								Partidua.getUnekoDenboraldia(), "Errorea",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Etxeko eta kanpoko taldea berdinak ez direla egiaztatu
					if (etxekoIzena.equals(kanpokoIzena)) {
						JOptionPane.showMessageDialog(panelPartiduak,
								"Etxeko eta kanpoko taldea ezin dira berdinak izan.", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int etxekoS = Integer.parseInt(etxekoSetak.getText().trim());
					int kanpokoS = Integer.parseInt(kanpokoSetak.getText().trim());

					// Validación de sets (voleibol al mejor de 5)
					if (etxekoS < 0 || etxekoS > 3 || kanpokoS < 0 || kanpokoS > 3) {
						JOptionPane.showMessageDialog(panelPartiduak, "Setak 0 eta 3 artean egon behar dira.", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Verificar que un equipo tiene 3 sets ganados
					if ((etxekoS == 3 && kanpokoS < 3) || (kanpokoS == 3 && etxekoS < 3)) {
						// OK, un equipo tiene 3 sets
					} else {
						JOptionPane.showMessageDialog(panelPartiduak,
								"Partidu batek 3 set irabazi behar ditu (bestea 0, 1 edo 2).", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// La suma de sets no puede ser mayor a 5
					if ((etxekoS + kanpokoS) > 5) {
						JOptionPane.showMessageDialog(panelPartiduak,
								"Set guztien batura ezin da 5 baino handiagoa izan.", "Errorea",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					// Jardunaldi berean partida errepikaturik ez dagoela egiaztatu
					for (Partidua p : Partidua.getPartiduakList()) {
						boolean jardunaldiBerdina = p.getJardunaldia().equals(jardunaldia);
						boolean denboraldiaBerdina = p.getDenboraldia().equals(denboraldia);
						boolean taldeBerdinak = (p.getEtxeko_taldea().getIzena().equals(etxekoIzena)
								&& p.getKanpoko_taldea().getIzena().equals(kanpokoIzena))
								|| (p.getEtxeko_taldea().getIzena().equals(kanpokoIzena)
										&& p.getKanpoko_taldea().getIzena().equals(etxekoIzena));

						if (jardunaldiBerdina && denboraldiaBerdina && taldeBerdinak) {
							JOptionPane.showMessageDialog(panelPartiduak,
									"Partida hau jolastu da denboraldi honetako jardunaldi honetan.", "Abisua",
									JOptionPane.WARNING_MESSAGE);
							return;
						}
					}

					// Partidua sortu
					Partidua p = new Partidua();
					p.setDenboraldia(denboraldia);
					p.setJardunaldia(jardunaldia);
					
					// Obtener los objetos Taldeak completos
					Taldeak etxekoTaldea = Taldeak.getTaldeaByIzena(etxekoIzena);
					Taldeak kanpokoTaldea = Taldeak.getTaldeaByIzena(kanpokoIzena);
					
					if (etxekoTaldea == null) {
						etxekoTaldea = new Taldeak(0, etxekoIzena, "", "", "");
					}
					if (kanpokoTaldea == null) {
						kanpokoTaldea = new Taldeak(0, kanpokoIzena, "", "", "");
					}
					
					p.setEtxeko_taldea(etxekoTaldea);
					p.setKanpoko_taldea(kanpokoTaldea);
					
					p.setEtxekoTaldekoSetak(etxekoS);
					p.setKanpokoTaldekoSetak(kanpokoS);
					
					// Añadir fecha actual
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					p.setPartidudata(sdf.format(new Date()));

					// Partidua gorde
					Partidua.gehituPartidua(p);
					
					// Actualizar la clasificación
					Klasifikazioa.eguneratuPartiduarekin(p);

					// Irabazlea detektatu eta koloreak markatu
					if (etxekoS > kanpokoS) {
						etxekoSetak.setBackground(Color.GREEN);
						kanpokoSetak.setBackground(Color.RED);
					} else {
						etxekoSetak.setBackground(Color.RED);
						kanpokoSetak.setBackground(Color.GREEN);
					}

					JOptionPane.showMessageDialog(panelPartiduak, 
						"Partidua ondo gorde da.\nEmaitzak taula automatikoki eguneratuko da.", 
						"Ondo", 
						JOptionPane.INFORMATION_MESSAGE);

					// Hurrengo sarrerarako eremuak garbitu
					etxekoSetak.setText("");
					kanpokoSetak.setText("");
					etxekoSetak.setBackground(Color.WHITE);
					kanpokoSetak.setBackground(Color.WHITE);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(panelPartiduak, "Mesedez, sartu zenbaki baliodunak setetan.",
							"Errorea", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// ===============================
		// BOTOIA - SAIOA AMAITU
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

		panelPartiduak.add(saioaAmaituBotoia);
		
		// Comprobar estado actual de la temporada
		eguneratuInterfazea();
	}
	
	/**
	 * Método para iniciar una nueva temporada
	 */

private void hasiDenboraldiaBerria() {
    // Obtener la temporada seleccionada
    String denboraldiaBerria = (String) denboraldiaCombo.getSelectedItem();
    
    if (denboraldiaBerria == null || denboraldiaBerria.isEmpty()) {
        JOptionPane.showMessageDialog(panelPartiduak, "Aukeratu denboraldi bat.", "Abisua",
                JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Iniciar nueva temporada - SIN VALIDACIONES
    boolean ondo = Partidua.hasiDenboraldiaBerria(denboraldiaBerria);
    
    if (ondo) {
        JOptionPane.showMessageDialog(panelPartiduak, 
                "Denboraldi berria hasi da: " + denboraldiaBerria + "\n" +
                "Orain partiduak sartu ditzakezu.", "Ondo",
                JOptionPane.INFORMATION_MESSAGE);
        
        // Resetear clasificación para la nueva temporada
        Klasifikazioa.reset();
        
        // Actualizar interfaz
        eguneratuInterfazea();
    }
}
	
	/**
	 * Actualizar la interfaz según el estado de la temporada
	 */
private void eguneratuInterfazea() {
    String unekoDenboraldia = Partidua.getUnekoDenboraldia();
    boolean denboraldiaHasita = Partidua.isDenboraldiaHasita();
    
    if (unekoDenboraldia != null) {
        hasiDenboraldiaBotoia.setText("Denboraldia: " + unekoDenboraldia);
        hasiDenboraldiaBotoia.setEnabled(true); // Siempre habilitado para cambiar
        
        // Habilitar/deshabilitar controles según si la temporada ha empezado
        puntuakSartuBotoia.setEnabled(denboraldiaHasita);
        etxekoSetak.setEnabled(denboraldiaHasita);
        kanpokoSetak.setEnabled(denboraldiaHasita);
        
        // Mostrar estado
        if (denboraldiaHasita) {
            hasiDenboraldiaBotoia.setToolTipText("Denboraldia hasita dago. Partiduak sartu ditzakezu.");
        } else {
            hasiDenboraldiaBotoia.setToolTipText("Denboraldia amaitu da. Hasi beste bat partiduak sartzeko.");
        }
    } else {
        hasiDenboraldiaBotoia.setText("Hasi Denboraldia");
        hasiDenboraldiaBotoia.setEnabled(true);
        hasiDenboraldiaBotoia.setToolTipText("Hasi denboraldi berri bat");
        
        // Deshabilitar controles si no hay temporada
        puntuakSartuBotoia.setEnabled(false);
        etxekoSetak.setEnabled(false);
        kanpokoSetak.setEnabled(false);
    }
}

	/**
	 * Partiduak panel nagusia itzultzen du
	 * 
	 * @return JPanel Partiduak fitxako edukia duen panela
	 */
	public JPanel getPanel() {
		return panelPartiduak;
	}

}