package data;

import model.Tour;
import model.Guia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {

    public ArrayList<Tour> cargarTours(String ruta) {
        ArrayList<Tour> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = br.readLine()) != null) {

                if (linea.trim().isEmpty()) {   // NUEVO: salta líneas vacías
                    continue;
                }

                // NUEVO: try-catch interno -> una línea mala NO detiene todo
                try {
                    String[] partes = linea.split(";");
                    String nombre = partes[0];
                    String tipo = partes[1];
                    int stock = Integer.parseInt(partes[2]);
                    String nombreGuia = partes[3];
                    String idioma = partes[4];

                    Guia guia = new Guia(nombreGuia, idioma);
                    Tour tour = new Tour(nombre, tipo, stock, guia);
                    lista.add(tour);

                } catch (NumberFormatException e) {
                    System.out.println("Stock inválido, línea ignorada: " + linea);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Línea incompleta, ignorada: " + linea);
                }
            }
            br.close();

        } catch (IOException e) {   // error del archivo (no existe, no se puede abrir)
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}