package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Vehiculo;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    // El gestor mantiene la colección de entidades mientras la ventana está abierta
    private final GestorEntidades gestor = new GestorEntidades();

    // Área de texto donde se muestran los resultados
    private final JTextArea areaTexto = new JTextArea();

    public VentanaPrincipal() {
        // --- Configuración de la ventana ---
        setTitle("Llanquihue Tour - Gestión de Entidades");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centra la ventana en pantalla
        setLayout(new BorderLayout());

        // --- Panel de botones (arriba) ---
        JPanel panelBotones = new JPanel();
        JButton btnGuia = new JButton("Agregar Guía");
        JButton btnVehiculo = new JButton("Agregar Vehículo");
        JButton btnColaborador = new JButton("Agregar Colaborador");
        JButton btnReporte = new JButton("Ver Reporte");

        panelBotones.add(btnGuia);
        panelBotones.add(btnVehiculo);
        panelBotones.add(btnColaborador);
        panelBotones.add(btnReporte);
        add(panelBotones, BorderLayout.NORTH);

        // --- Área de texto con scroll (centro) ---
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // --- Acciones de los botones ---
        btnGuia.addActionListener(e -> agregarGuia());
        btnVehiculo.addActionListener(e -> agregarVehiculo());
        btnColaborador.addActionListener(e -> agregarColaborador());
        btnReporte.addActionListener(e -> verReporte());
    }

    // Pide datos y crea un GuiaTuristico
    private void agregarGuia() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del guía:");
        if (nombre == null || nombre.isBlank()) return;

        String idioma = JOptionPane.showInputDialog(this, "Idioma:");
        if (idioma == null || idioma.isBlank()) return;

        String textoAnios = JOptionPane.showInputDialog(this, "Años de experiencia:");
        if (textoAnios == null) return;

        try {
            int anios = Integer.parseInt(textoAnios.trim());
            gestor.agregar(new GuiaTuristico(nombre, idioma, anios));
            areaTexto.append("Guía agregado: " + nombre + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los años deben ser un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Pide datos y crea un Vehiculo
    private void agregarVehiculo() {
        String tipo = JOptionPane.showInputDialog(this, "Tipo (Van, Bus, Lancha...):");
        if (tipo == null || tipo.isBlank()) return;

        String patente = JOptionPane.showInputDialog(this, "Patente:");
        if (patente == null || patente.isBlank()) return;

        String textoCap = JOptionPane.showInputDialog(this, "Capacidad (pasajeros):");
        if (textoCap == null) return;

        try {
            int capacidad = Integer.parseInt(textoCap.trim());
            gestor.agregar(new Vehiculo(tipo, patente, capacidad));
            areaTexto.append("Vehículo agregado: " + tipo + " (" + patente + ")\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La capacidad debe ser un número.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Pide datos y crea un ColaboradorExterno
    private void agregarColaborador() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del colaborador:");
        if (nombre == null || nombre.isBlank()) return;

        String servicio = JOptionPane.showInputDialog(this, "Servicio (Fotografía, Catering...):");
        if (servicio == null || servicio.isBlank()) return;

        String telefono = JOptionPane.showInputDialog(this, "Teléfono:");
        if (telefono == null || telefono.isBlank()) return;

        gestor.agregar(new ColaboradorExterno(nombre, servicio, telefono));
        areaTexto.append("Colaborador agregado: " + nombre + "\n");
    }

    // Muestra el reporte completo (aquí se ejecuta el instanceof del gestor)
    private void verReporte() {
        if (gestor.getEntidades().isEmpty()) {
            areaTexto.setText("No hay entidades registradas todavía.\n" +
                    "Usa los botones de arriba para agregar algunas.");
            return;
        }
        areaTexto.setText("=== REPORTE DE ENTIDADES ===\n\n");
        areaTexto.append(gestor.generarReporte());
    }// NUEVO (Semana 8): punto de entrada que abre la ventana
    public static void main(String[] args) {
        // Buenas prácticas de Swing: crear la ventana en el hilo de eventos
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}