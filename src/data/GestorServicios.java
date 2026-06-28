package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

import java.util.ArrayList;

public class GestorServicios {

    private ArrayList<ServicioTuristico> servicios;

    public GestorServicios() {
        servicios = new ArrayList<>();

        // Rutas Gastronómicas
        servicios.add(new RutaGastronomica("Sabores del Sur", 3, 5));
        servicios.add(new RutaGastronomica("Ruta del Curanto", 4, 7));

        // Paseos Lacustres
        servicios.add(new PaseoLacustre("Travesía Lago Llanquihue", 2, "Catamarán"));
        servicios.add(new PaseoLacustre("Paseo Lago Todos los Santos", 3, "Lancha"));

        // Excursiones Culturales
        servicios.add(new ExcursionCultural("Historia de Puerto Montt", 4, "Museo Regional"));
        servicios.add(new ExcursionCultural("Legado Alemán de Frutillar", 5, "Teatro del Lago"));
    }

    public ArrayList<ServicioTuristico> getServicios() {
        return servicios;
    }
}