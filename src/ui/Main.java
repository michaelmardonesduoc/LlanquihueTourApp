package ui;

import javax.swing.SwingUtilities;

/**
 * Clase principal del sistema Llanquihue Tour.
 * Punto de entrada: levanta la interfaz grafica.
 */
public class Main {

    public static void main(String[] args) {
        // Se lanza la ventana en el hilo de eventos de Swing (buena practica)
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}