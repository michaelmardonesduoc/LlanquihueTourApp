package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Vehiculo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * Interfaz grafica basica del sistema Llanquihue Tour.
 *
 * Permite ingresar distintos tipos de entidades mediante JOptionPane y
 * visualizar el reporte generado por GestorEntidades, donde se aplica
 * polimorfismo e instanceof.
 */
public class VentanaPrincipal extends JFrame {

    // Gestor que mantiene la coleccion polimorfica de entidades
    private GestorEntidades gestor;

    // Area donde se muestra el reporte
    private JTextArea areaReporte;

    public VentanaPrincipal() {
        gestor = new GestorEntidades();
        inicializarComponentes();
    }

    /**
     * Arma la ventana: botones de accion arriba y area de texto al centro.
     */
    private void inicializarComponentes() {
        setTitle("Llanquihue Tour - Gestion de Entidades");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   // centra la ventana en pantalla
        setLayout(new BorderLayout());

        // ----- Panel superior con los botones -----
        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnGuia = new JButton("Agregar Guia");
        JButton btnVehiculo = new JButton("Agregar Vehiculo");
        JButton btnColaborador = new JButton("Agregar Colaborador");
        JButton btnReporte = new JButton("Ver Reporte");

        panelBotones.add(btnGuia);
        panelBotones.add(btnVehiculo);
        panelBotones.add(btnColaborador);
        panelBotones.add(btnReporte);

        add(panelBotones, BorderLayout.NORTH);

        // ----- Area central del reporte -----
        areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        areaReporte.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(areaReporte), BorderLayout.CENTER);

        // ----- Acciones de los botones -----
        btnGuia.addActionListener(e -> agregarGuia());
        btnVehiculo.addActionListener(e -> agregarVehiculo());
        btnColaborador.addActionListener(e -> agregarColaborador());
        btnReporte.addActionListener(e -> mostrarReporte());
    }

    /**
     * Pide los datos de un guia turistico y lo agrega a la coleccion.
     */
    private void agregarGuia() {
        try {
            String id = JOptionPane.showInputDialog(this, "ID del guia (ej: G001):");
            if (id == null) return;   // el usuario cancelo

            String nombre = JOptionPane.showInputDialog(this, "Nombre completo del guia:");
            if (nombre == null) return;

            String idioma = JOptionPane.showInputDialog(this, "Idioma principal:");
            if (idioma == null) return;

            String textoAnios = JOptionPane.showInputDialog(this, "Anios de experiencia:");
            if (textoAnios == null) return;

            int anios = Integer.parseInt(textoAnios.trim());

            // El objeto se agrega como Registrable a la coleccion generica
            gestor.agregarEntidad(new GuiaTuristico(id, nombre, idioma, anios));
            JOptionPane.showMessageDialog(this, "Guia turistico agregado correctamente.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Los anios de experiencia deben ser un numero entero.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Pide los datos de un vehiculo y lo agrega a la coleccion.
     */
    private void agregarVehiculo() {
        try {
            String id = JOptionPane.showInputDialog(this, "ID del vehiculo (ej: V001):");
            if (id == null) return;

            String nombre = JOptionPane.showInputDialog(this, "Modelo del vehiculo (ej: Mercedes Sprinter):");
            if (nombre == null) return;

            String tipo = JOptionPane.showInputDialog(this, "Tipo (Van, Bus, Lancha):");
            if (tipo == null) return;

            String patente = JOptionPane.showInputDialog(this, "Patente:");
            if (patente == null) return;

            String textoCapacidad = JOptionPane.showInputDialog(this, "Capacidad de pasajeros:");
            if (textoCapacidad == null) return;

            int capacidad = Integer.parseInt(textoCapacidad.trim());

            gestor.agregarEntidad(new Vehiculo(id, nombre, tipo, patente, capacidad));
            JOptionPane.showMessageDialog(this, "Vehiculo agregado correctamente.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "La capacidad debe ser un numero entero.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Pide los datos de un colaborador externo y lo agrega a la coleccion.
     */
    private void agregarColaborador() {
        try {
            String id = JOptionPane.showInputDialog(this, "ID del colaborador (ej: C001):");
            if (id == null) return;

            String nombre = JOptionPane.showInputDialog(this, "Nombre del colaborador:");
            if (nombre == null) return;

            String empresa = JOptionPane.showInputDialog(this, "Empresa a la que pertenece:");
            if (empresa == null) return;

            String servicio = JOptionPane.showInputDialog(this, "Servicio (Fotografia, Catering, Transporte):");
            if (servicio == null) return;

            String textoTarifa = JOptionPane.showInputDialog(this, "Tarifa por jornada (ej: 45000):");
            if (textoTarifa == null) return;

            // Se reemplaza la coma por punto para evitar problemas de configuracion regional
            double tarifa = Double.parseDouble(textoTarifa.trim().replace(",", "."));

            gestor.agregarEntidad(new ColaboradorExterno(id, nombre, empresa, servicio, tarifa));
            JOptionPane.showMessageDialog(this, "Colaborador externo agregado correctamente.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "La tarifa debe ser un numero valido.",
                    "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra en pantalla el reporte polimorfico generado por el gestor.
     */
    private void mostrarReporte() {
        areaReporte.setText(gestor.generarReporte());
    }
}