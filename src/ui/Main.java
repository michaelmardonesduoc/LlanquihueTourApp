package ui;

import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Cargar tours desde el archivo
        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours("resources/tours.txt");

        // 1. Mostrar todos los tours
        System.out.println("=== TODOS LOS TOURS ===");
        for (Tour t : tours) {
            System.out.println(t);
        }

        // 2. Filtrar tours con stock > 0
        System.out.println("\n=== TOURS CON STOCK DISPONIBLE ===");
        for (Tour t : tours) {
            if (t.getStock() > 0) {
                System.out.println(t);
            }
        }

        // 3. Filtrar tours de tipo lacustre
        System.out.println("\n=== TOURS LACUSTRES ===");
        for (Tour t : tours) {
            if (t.getTipo().equals("lacustre")) {
                System.out.println(t);
            }
        }

        // 4. Buscar tours por nombre
        String busqueda = "lago";
        System.out.println("\n=== BÚSQUEDA POR NOMBRE: '" + busqueda + "' ===");
        for (Tour t : tours) {
            if (t.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                System.out.println(t);
            }
        }
    }   // cierra el main
}       // cierra la clase Main