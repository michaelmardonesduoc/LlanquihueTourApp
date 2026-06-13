package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {

    // Lee el archivo y retorna un ArrayList de Tours
    public ArrayList<Tour> cargarTours(String ruta) {
        ArrayList<Tour> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;

            // Lee línea por línea
            while ((linea = br.readLine()) != null) {
                // Separa los datos con punto y coma
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String tipo = partes[1];
                int stock = Integer.parseInt(partes[2]);

                // Crea objeto y lo agrega al ArrayList
                Tour tour = new Tour(nombre, tipo, stock);
                lista.add(tour);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}