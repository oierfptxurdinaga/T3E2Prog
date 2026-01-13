package Erronka2.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Erronka2.model.Partidua;

/**
 * Emaitzak pestañaren interfazea - AHORA CON LÓGICA REAL Y AUTOMÁTICA
 */
public class EmaitzakMetodo {
    
    private JPanel panel;
    private Color urdina;
    private JComboBox<String> temporadaCombo;
    private JComboBox<String> jornadaCombo;
    private JTable taula;
    private DefaultTableModel tableModel;
    
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
        
        temporadaCombo = new JComboBox<>();
        temporadaCombo.addItem("Guztiak"); // Opción para ver todos
        temporadaCombo.addItem("2022/2023");
        temporadaCombo.addItem("2023/2024");
        temporadaCombo.addItem("2024/2025");
        temporadaCombo.setBounds(100, 160, 180, 35);
        temporadaCombo.addActionListener(e -> kargatuEmaitzakAutomatikoki());
        panel.add(temporadaCombo);
        
        // ===============================
        // JARDUNALDIA (JORNADA)
        // ===============================
        JLabel jornadaLabel = new JLabel("Jardunaldia:");
        jornadaLabel.setForeground(Color.WHITE);
        jornadaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        jornadaLabel.setBounds(300, 120, 150, 30);
        panel.add(jornadaLabel);
        
        jornadaCombo = new JComboBox<>();
        jornadaCombo.addItem("Guztiak"); // Opción para ver todos
        for (int i = 1; i <= 10; i++) {
            jornadaCombo.addItem("Jardunaldia " + i);
        }
        jornadaCombo.setBounds(300, 160, 180, 35);
        jornadaCombo.addActionListener(e -> kargatuEmaitzakAutomatikoki());
        panel.add(jornadaCombo);
        
        // ===============================
        // TAULA (RESULTADOS) CON MODELO DINÁMICO
        // ===============================
        String[] columnas = {
            "Talde lokala",
            "Golak lokala",
            "Golak kanpokoa",
            "Talde kanpokoa",
            "Jardunaldia",
            "Denboraldia"
        };
        
        tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 1 || columnIndex == 2) {
                    return Integer.class; // Para que ordene bien los números
                }
                return String.class;
            }
        };
        
        taula = new JTable(tableModel);
        taula.setRowHeight(35);
        taula.setFont(new Font("Arial", Font.PLAIN, 14));
        taula.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        taula.setAutoCreateRowSorter(true); // Para poder ordenar
        
        JScrollPane scrollTaula = new JScrollPane(taula);
        scrollTaula.setBounds(100, 230, 700, 220);
        panel.add(scrollTaula);
        
        // NOTA: Ya NO hay botón de "Freskatu emaitzak" - es automático
        
        // ===============================
        // BOTOIA - SAIOA AMAITU
        // ===============================
        JButton saioaAmaituBotoia = new JButton("Saioa amaitu");
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
        
        // Cargar resultados iniciales
        kargatuEmaitzakAutomatikoki();
    }
    
    /**
     * Método para cargar los resultados en la tabla AUTOMÁTICAMENTE
     */
    private void kargatuEmaitzakAutomatikoki() {
        tableModel.setRowCount(0); // Limpiar tabla
        
        String jardunaldiaHautatua = (String) jornadaCombo.getSelectedItem();
        String denboraldiaHautatua = (String) temporadaCombo.getSelectedItem();
        
        // Si se selecciona "Guztiak", filtrar como vacío
        if ("Guztiak".equals(jardunaldiaHautatua)) {
            jardunaldiaHautatua = "";
        }
        if ("Guztiak".equals(denboraldiaHautatua)) {
            denboraldiaHautatua = "";
        }
        
        // Obtener partidos filtrados
        List<Partidua> partiduak = Partidua.getPartiduakByDenboraldiaAndJardunaldia(
            "Guztiak".equals(denboraldiaHautatua) ? "" : denboraldiaHautatua,
            "Guztiak".equals(jardunaldiaHautatua) ? "" : jardunaldiaHautatua
        );
        
        boolean partiduakAurkituta = false;
        
        for (Partidua partidua : partiduak) {
            partiduakAurkituta = true;
            
            // Determinar el ganador para colorear
            int etxekoPuntuak = partidua.getEtxekoTaldekoPuntuazioa();
            int kanpokoPuntuak = partidua.getKanpokoTaldekoPuntuazioa();
            
            // Añadir a la tabla
            Object[] rowData = {
                partidua.getEtxeko_taldea().getIzena(),
                etxekoPuntuak,
                kanpokoPuntuak,
                partidua.getKanpoko_taldea().getIzena(),
                partidua.getJardunaldia(),
                partidua.getDenboraldia()
            };
            
            tableModel.addRow(rowData);
        }
        
        // Si no hay resultados, mostrar mensaje
        if (!partiduakAurkituta) {
            Object[] noData = {
                "Ez dago partidurik",
                "-",
                "-",
                "Sartu partidu bat",
                jardunaldiaHautatua.isEmpty() ? "Guztiak" : jardunaldiaHautatua,
                denboraldiaHautatua.isEmpty() ? "Guztiak" : denboraldiaHautatua
            };
            tableModel.addRow(noData);
        }
    }
    
    /**
     * Método público para actualizar la tabla desde otras clases
     */
    public void actualizarTabla() {
        kargatuEmaitzakAutomatikoki();
    }
    
    /**
     * Emaitzak panel hau itzultzen du
     */
    public JPanel getPanel() {
        return panel;
    }
    
    // Getters para los combobox
    public JComboBox<String> getTemporadaCombo() {
        return temporadaCombo;
    }
    
    public JComboBox<String> getJornadaCombo() {
        return jornadaCombo;
    }
    
    public JTable getTaula() {
        return taula;
    }
    
    /**
     * Método para notificar que se ha añadido un nuevo partido
     */
    public void notifyPartiduaGehitu() {
        kargatuEmaitzakAutomatikoki();
    }
}