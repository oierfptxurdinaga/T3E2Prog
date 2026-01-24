package Erronka2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Erronka2.model.Taldeak;
import Erronka2.model.Taldeak.TaldeFactory;
import Erronka2.model.Jokalaria;
import Erronka2.model.Partidua;

/**
 * Interfaz gráfica para gestionar las fitxaketak (traspasos) de jugadores entre equipos.
 * <p>
 * Permite seleccionar un equipo, mostrar sus jugadores, seleccionar otro equipo destino
 * y realizar la transferencia de un jugador seleccionado. Además, controla si la temporada
 * ha comenzado para deshabilitar la operación si es necesario.
 * </p>
 */
public class FitxaketakMetodo {

    private JPanel panela;
    private Color urdina;
    private JComboBox<Taldeak> taldeaCombo;
    private JList<Jokalaria> jokalariakZerrenda;
    private DefaultListModel<Jokalaria> zerrendaModeloa;
    private JComboBox<Taldeak> helburuTaldeaCombo; 
    
    private JButton saioaAmaituBotoia;
    private JButton traspasatuBotoia;
    
    private JLabel titulua;
    private JLabel taldeaEtiketa;
    private JLabel jokalariakEtiketa;
    private JLabel helburuTaldeaEtiketa;
    
    private JScrollPane korritzePanelaJokalariak;
    private JLabel abisuaEtiketa; // Etiqueta para mostrar avisos
    
    /**
     * Constructor que inicializa la interfaz gráfica, componentes y carga inicial de datos.
     * También gestiona la habilitación/deshabilitación de operaciones según el estado de la temporada.
     * 
     * @param urdina Color principal del fondo del panel
     */
    public FitxaketakMetodo(Color urdina) {
        this.urdina = urdina;
        panela = new JPanel(null);
        panela.setBackground(urdina);

        // --- Configuración visual y creación de componentes ---
        titulua = new JLabel("FITXAKETAK");
        titulua.setForeground(Color.WHITE);
        titulua.setFont(new Font("Arial", Font.BOLD, 32));
        titulua.setBounds(350, 40, 300, 40);
        panela.add(titulua);
        
        abisuaEtiketa = new JLabel("");
        abisuaEtiketa.setForeground(Color.YELLOW);
        abisuaEtiketa.setFont(new Font("Arial", Font.BOLD, 16));
        abisuaEtiketa.setBounds(100, 100, 700, 30);
        abisuaEtiketa.setHorizontalAlignment(SwingConstants.CENTER);
        panela.add(abisuaEtiketa);

        taldeaEtiketa = new JLabel("Aukeratu taldea:");
        taldeaEtiketa.setForeground(Color.WHITE);
        taldeaEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        taldeaEtiketa.setBounds(100, 150, 200, 30);
        panela.add(taldeaEtiketa);

        taldeaCombo = new JComboBox<>();
        try {
            for (Taldeak t : TaldeFactory.sortuTaldeak()) {
                if (t != null) {
                    taldeaCombo.addItem(t);
                }
            }
        } catch (Exception e) {
            System.err.println("Errorea taldeak kargatzerakoan: " + e.getMessage());
            JOptionPane.showMessageDialog(panela, 
                "Errorea taldeak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
        }
        taldeaCombo.setBounds(100, 190, 250, 35);
        panela.add(taldeaCombo);

        jokalariakEtiketa = new JLabel("Jokalariak:");
        jokalariakEtiketa.setForeground(Color.WHITE);
        jokalariakEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        jokalariakEtiketa.setBounds(100, 240, 200, 30);
        panela.add(jokalariakEtiketa);

        zerrendaModeloa = new DefaultListModel<>();
        jokalariakZerrenda = new JList<>(zerrendaModeloa);
        korritzePanelaJokalariak = new JScrollPane(jokalariakZerrenda);
        korritzePanelaJokalariak.setBounds(100, 280, 250, 200);
        panela.add(korritzePanelaJokalariak);

        helburuTaldeaEtiketa = new JLabel("Traspasatu nahi den taldea:");
        helburuTaldeaEtiketa.setForeground(Color.WHITE);
        helburuTaldeaEtiketa.setFont(new Font("Arial", Font.BOLD, 18));
        helburuTaldeaEtiketa.setBounds(450, 150, 300, 30);
        panela.add(helburuTaldeaEtiketa);

        helburuTaldeaCombo = new JComboBox<>();
        try {
            for (Taldeak t : TaldeFactory.sortuTaldeak()) {
                if (t != null) {
                    helburuTaldeaCombo.addItem(t);
                }
            }
        } catch (Exception e) {
            System.err.println("Errorea helburu taldeak kargatzerakoan: " + e.getMessage());
            JOptionPane.showMessageDialog(panela, 
                "Errorea helburu taldeak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
        }
        helburuTaldeaCombo.setBounds(450, 190, 250, 35);
        panela.add(helburuTaldeaCombo);

        traspasatuBotoia = new JButton("Traspasatu");
        traspasatuBotoia.setBounds(475, 280, 200, 40);
        traspasatuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    traspasatuJokalariaGUI();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea jokalaria traspasatzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(traspasatuBotoia);

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
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea saioa amaitzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panela.add(saioaAmaituBotoia);

        taldeaCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    kargatuJokalariak();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panela, 
                        "Errorea jokalariak kargatzerakoan: " + ex.getMessage(), 
                        "Errorea", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        try {
            kargatuJokalariak();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panela, 
                "Errorea hasierako jokalariak kargatzerakoan: " + e.getMessage(), 
                "Errorea", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        eguneratuInterfazeaDenboraldia();
    }

    /**
     * Actualiza la interfaz para habilitar o deshabilitar componentes
     * según si la temporada está activa o no.
     */
    private void eguneratuInterfazeaDenboraldia() {
        try {
            String unekoDenboraldia = Partidua.getUnekoDenboraldia();
            boolean denboraldiaHasita = Partidua.isDenboraldiaHasita();

            if (unekoDenboraldia != null && denboraldiaHasita) {
                traspasatuBotoia.setEnabled(false);
                taldeaCombo.setEnabled(false);
                helburuTaldeaCombo.setEnabled(false);
                abisuaEtiketa.setText("OHARRA: Denboraldia hasita dago. Ezin dira fitxaketak egin.");
                abisuaEtiketa.setForeground(Color.RED);
            } else {
                traspasatuBotoia.setEnabled(true);
                taldeaCombo.setEnabled(true);
                helburuTaldeaCombo.setEnabled(true);
                abisuaEtiketa.setText("Fitxaketak egin daitezke denboraldia hasi aurretik.");
                abisuaEtiketa.setForeground(Color.YELLOW);
            }
        } catch (Exception e) {
            System.err.println("Errorea denboraldiaren egoera egiaztatzerakoan: " + e.getMessage());
            traspasatuBotoia.setEnabled(false);
            taldeaCombo.setEnabled(false);
            helburuTaldeaCombo.setEnabled(false);
            abisuaEtiketa.setText("Errorea sistemaren egoera egiaztatzerakoan.");
            abisuaEtiketa.setForeground(Color.RED);
        }
    }

    /**
     * Carga los jugadores del equipo seleccionado en el listado.
     * 
     * @throws Exception si no se puede cargar la lista de jugadores
     */
    private void kargatuJokalariak() throws Exception {
        zerrendaModeloa.clear();

        Taldeak hautatutakoTaldea = (Taldeak) taldeaCombo.getSelectedItem();

        if (hautatutakoTaldea == null) {
            throw new IllegalStateException("Ez da talderik aukeratu.");
        }

        if (hautatutakoTaldea.getTalde_kod() != 0) { // Ignorar placeholder "-"

            System.out.println("Talde aukeratua: " + hautatutakoTaldea.getIzena()
                + " | kodea: " + hautatutakoTaldea.getTalde_kod());

            List<Jokalaria> jokalariak;
            try {
                jokalariak = Jokalaria.getJokalariakByTaldea(hautatutakoTaldea.getTalde_kod());

                if (jokalariak == null) {
                    throw new IllegalStateException("Jokalarien zerrenda nulua itzuli da.");
                }

            } catch (Exception e) {
                throw new Exception("Errorea jokalariak datu basetik kargatzerakoan: " + e.getMessage(), e);
            }

            System.out.println("Aurkitutako jokalariak: " + jokalariak.size());

            for (Jokalaria jokalaria : jokalariak) {
                if (jokalaria == null) {
                    throw new IllegalStateException("Jokalari nulua aurkitu da.");
                }
                zerrendaModeloa.addElement(jokalaria);
            }
        }
    }

    /**
     * Controla la lógica para traspasar un jugador seleccionado a otro equipo destino,
     * mostrando mensajes y validando las condiciones.
     * 
     * @throws Exception si no se puede realizar el traspaso
     */
    private void traspasatuJokalariaGUI() throws Exception {
        if (Partidua.isDenboraldiaHasita()) {
            throw new IllegalStateException("Ezin dira fitxaketak egin denboraldia hasita dagoelako.");
        }

        Jokalaria hautatutakoJokalaria = jokalariakZerrenda.getSelectedValue();

        if (hautatutakoJokalaria == null) {
            throw new IllegalArgumentException("Mesedez, aukeratu jokalari bat traspasatzeko.");
        }

        Taldeak helburuTaldea = (Taldeak) helburuTaldeaCombo.getSelectedItem();

        if (helburuTaldea == null || helburuTaldea.getTalde_kod() == 0) {
            throw new IllegalArgumentException("Mesedez, aukeratu talde helburu balido bat.");
        }

        if (hautatutakoJokalaria.getTaldeKod() == helburuTaldea.getTalde_kod()) {
            throw new IllegalArgumentException("Jokalaria hau talde honetan dago.");
        }

        int erantzuna = JOptionPane.showConfirmDialog(panela,
                hautatutakoJokalaria.getIzena() + " jokalaria " + helburuTaldea.getIzena() + " taldera traspasatu nahi duzu?",
                "Traspasoa baieztatu",
                JOptionPane.YES_NO_OPTION);

        if (erantzuna == JOptionPane.YES_OPTION) {
            String taldeJatorriIzena = Jokalaria.getTaldeIzenaByKod(hautatutakoJokalaria.getTaldeKod());

            if (taldeJatorriIzena == null || taldeJatorriIzena.equals("Ezezaguna")) {
                throw new IllegalStateException("Ezin izan da jatorrizko taldearen izena lortu.");
            }

            boolean traspasoArrakastatsua = Jokalaria.traspasatuJokalaria(hautatutakoJokalaria,
                    helburuTaldea.getTalde_kod());

            if (!traspasoArrakastatsua) {
                throw new Exception("Traspasoa huts egin du.");
            }

            kargatuJokalariak();

            JOptionPane.showMessageDialog(null,
                    hautatutakoJokalaria.getIzena() + " traspasatu da " + taldeJatorriIzena
                            + " taldetik " + helburuTaldea.getIzena() + " taldera.",
                    "Traspasoa burututa",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("TRASPASOA: " + hautatutakoJokalaria.getIzena() + " " + taldeJatorriIzena
                    + "-tik " + helburuTaldea.getIzena() + "-ra Erabiltzaileak");
        }
    }

    /**
     * Devuelve el panel principal que contiene todos los componentes.
     * 
     * @return JPanel principal
     */
    public JPanel getPanela() {
        return panela;
    }

    /**
     * Devuelve la lista gráfica de jugadores.
     * 
     * @return JList con los jugadores cargados
     */
    public JList<Jokalaria> getJokalariakZerrenda() {
        return jokalariakZerrenda;
    }

    /**
     * Devuelve el modelo de la lista de jugadores.
     * 
     * @return DefaultListModel de jugadores
     */
    public DefaultListModel<Jokalaria> getZerrendaModeloa() {
        return zerrendaModeloa;
    }

    /**
     * Devuelve el combo box del equipo origen.
     * 
     * @return JComboBox de equipos
     */
    public JComboBox<Taldeak> getTaldeaCombo() {
        return taldeaCombo;
    }

    /**
     * Devuelve el combo box del equipo destino para traspaso.
     * 
     * @return JComboBox de equipos destino
     */
    public JComboBox<Taldeak> getHelburuTaldeaCombo() {
        return helburuTaldeaCombo;
    }
}
