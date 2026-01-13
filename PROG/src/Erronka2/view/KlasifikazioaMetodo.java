package Erronka2.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Erronka2.model.Klasifikazioa;
import Erronka2.model.Partidua;
import Erronka2.model.TaldearenKlasifikazioa;

/**
 * Klasifikazioa pestañaren interfazea - Ahora con lógica real
 */
public class KlasifikazioaMetodo {

    private JPanel panel;
    private Color urdina;
    
    private JButton saioaAmaituBotoia;
    private JComboBox<String> denboraldiaCombo;
    private JTable klasifikazioaTaula;
    private DefaultTableModel tableModel;
    private JButton gordeBotoia;
    private JButton amaituDenboraldiaBotoia; // Nuevo: botón para terminar temporada

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
        denboraldiaCombo = new JComboBox<>();
        denboraldiaCombo.addItem("2022/2023");
        denboraldiaCombo.addItem("2023/2024");
        denboraldiaCombo.addItem("2024/2025");
        denboraldiaCombo.setFont(new Font("Arial", Font.BOLD, 18));
        denboraldiaCombo.setBounds(100, 90, 200, 40);
        denboraldiaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kargatuKlasifikazioa();
            }
        });
        panel.add(denboraldiaCombo);
        
        // Botón para terminar temporada - SIEMPRE HABILITADO
        amaituDenboraldiaBotoia = new JButton("Amaitu Denboraldia");
        amaituDenboraldiaBotoia.setFont(new Font("Arial", Font.BOLD, 16));
        amaituDenboraldiaBotoia.setBackground(Color.ORANGE);
        amaituDenboraldiaBotoia.setForeground(Color.BLACK);
        amaituDenboraldiaBotoia.setBounds(600, 90, 200, 40);
        amaituDenboraldiaBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amaituDenboraldia();
            }
        });
        panel.add(amaituDenboraldiaBotoia);

        // Taula - con modelo dinámico
        String[] zutabeak = {"Posizioa", "Taldea", "PJ", "PG", "PP", "PTS", "SG", "SP", "SD"};
        
        tableModel = new DefaultTableModel(zutabeak, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        klasifikazioaTaula = new JTable(tableModel);
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

        // Boton Gorde
        gordeBotoia = new JButton("Gorde");
        gordeBotoia.setFont(new Font("Arial", Font.BOLD, 20));
        gordeBotoia.setBackground(Color.WHITE);
        gordeBotoia.setBounds(150, 420, 200, 50);
        gordeBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Klasifikazioa gordeta.", "Gorde", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(gordeBotoia);

        // Boton Kargatu
        JButton kargatuBotoia = new JButton("Kargatu");
        kargatuBotoia.setFont(new Font("Arial", Font.BOLD, 20));
        kargatuBotoia.setBackground(Color.WHITE);
        kargatuBotoia.setBounds(450, 420, 200, 50);
        kargatuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kargatuKlasifikazioa();
            }
        });
        panel.add(kargatuBotoia);

        // Boton Saioa Amaitu
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
        panel.add(saioaAmaituBotoia);
        
        // Cargar la clasificación al iniciar
        kargatuKlasifikazioa();
        
        // Actualizar estado del botón de terminar temporada
        eguneratuAmaituBotoia();
    }
    
    /**
     * Método para terminar la temporada actual
     */
    private void amaituDenboraldia() {
        String unekoDenboraldia = Partidua.getUnekoDenboraldia();
        
        if (unekoDenboraldia == null) {
            JOptionPane.showMessageDialog(panel, "Ez dago denboraldirik hasita. Lehenik 'Hasi Denboraldia' sakatu partiduak pestañan.", 
                    "Abisua", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Preguntar confirmación - SIN VALIDAR SI ESTÁ COMPLETA
        int erantzuna = JOptionPane.showConfirmDialog(panel,
            "Ziur al zaude " + unekoDenboraldia + " denboraldia amaitu nahi duzula?\n" +
            "Honek fitxaketak egitea ahalbidetuko du.",
            "Denboraldia amaitu",
            JOptionPane.YES_NO_OPTION);
            
        if (erantzuna != JOptionPane.YES_OPTION) {
            return;
        }
        
        // Terminar temporada
        Partidua.amaituDenboraldia();
        
        JOptionPane.showMessageDialog(panel, 
            "Denboraldia amaitu da: " + unekoDenboraldia + "\n" +
            "Orain fitxaketak egin ditzakezu edo denboraldi berri bat hasi.",
            "Denboraldia Amaituta",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Actualizar interfaz
        eguneratuAmaituBotoia();
    }

    
    /**
     * Actualizar estado del botón de terminar temporada
     */
    private void eguneratuAmaituBotoia() {
        String unekoDenboraldia = Partidua.getUnekoDenboraldia();
        
        if (unekoDenboraldia != null) {
            // Hay temporada activa
            if (Partidua.isDenboraldiaHasita()) {
                amaituDenboraldiaBotoia.setText("Amaitu Denboraldia: " + unekoDenboraldia);
                amaituDenboraldiaBotoia.setToolTipText("Denboraldia amaitu fitxaketak egiteko");
            } else {
                amaituDenboraldiaBotoia.setText("Denboraldia Amaituta: " + unekoDenboraldia);
                amaituDenboraldiaBotoia.setToolTipText("Denboraldia dagoeneko amaitu da");
            }
        } else {
            // No hay temporada activa
            amaituDenboraldiaBotoia.setText("Amaitu Denboraldia");
            amaituDenboraldiaBotoia.setToolTipText("Ez dago denboraldirik hasita");
        }
        
        // EL BOTÓN ESTÁ SIEMPRE HABILITADO
        amaituDenboraldiaBotoia.setEnabled(true);
    }
    
    /**
     * Método para cargar la clasificación en la tabla
     */
    private void kargatuKlasifikazioa() {
        tableModel.setRowCount(0); // Limpiar tabla
        
        String denboraldiaHautatua = (String) denboraldiaCombo.getSelectedItem();
        
        if (denboraldiaHautatua == null || denboraldiaHautatua.isEmpty()) {
            return;
        }
        
        // Inicializar clasificación desde partidos existentes de esta temporada
        Klasifikazioa.inicializatuPartiduetatik(denboraldiaHautatua);
        
        List<TaldearenKlasifikazioa> klasifikazioa = Klasifikazioa.getKlasifikazioaOrdenatua();
        
        int posizioa = 1;
        for (TaldearenKlasifikazioa tk : klasifikazioa) {
            Object[] rowData = {
                posizioa++,
                tk.getTaldea().getIzena(),
                tk.getPartidaJokatuak(),
                tk.getPartidaIrabaziak(),
                tk.getPartidaGalduak(),
                tk.getPuntuak(),
                tk.getSetakIrabaziak(),
                tk.getSetakGalduak(),
                tk.getSetDiferentzia()
            };
            tableModel.addRow(rowData);
        }
        
        // Ajustar altura de filas
        int numFilas = tableModel.getRowCount();
        if (numFilas > 0) {
            int altoDisponible = 227;
            int alturaFila = Math.max(30, altoDisponible / numFilas);
            klasifikazioaTaula.setRowHeight(alturaFila);
        }
    }

    /**
     * Klasifikazioa panel hau itzultzen du
     * @return JPanel diseinua daukana
     */
    public JPanel getPanel() {
        return panel;
    }
}