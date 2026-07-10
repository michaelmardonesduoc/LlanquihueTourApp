package data;

import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;

public class GestorEntidades {

    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    // Agrega cualquier objeto que implemente Registrable a la colección
    public void agregar(Registrable entidad) {
        entidades.add(entidad);
    }

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    // Recorre la colección genérica y usa instanceof para diferenciar cada tipo
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        int guias = 0, vehiculos = 0, colaboradores = 0;

        for (Registrable entidad : entidades) {
            // Todas responden a mostrarResumen() (polimorfismo por la interfaz)
            reporte.append(entidad.mostrarResumen());

            // instanceof: identifica el tipo real y aplica lógica diferenciada
            if (entidad instanceof GuiaTuristico) {
                reporte.append("   -> [Personal de guía]");
                guias++;
            } else if (entidad instanceof Vehiculo) {
                reporte.append("   -> [Recurso de transporte]");
                vehiculos++;
            } else if (entidad instanceof ColaboradorExterno) {
                reporte.append("   -> [Servicio externo]");
                colaboradores++;
            }

            reporte.append("\n");
        }

        reporte.append("\n--- Totales ---\n");
        reporte.append("Guías: ").append(guias).append("\n");
        reporte.append("Vehículos: ").append(vehiculos).append("\n");
        reporte.append("Colaboradores: ").append(colaboradores).append("\n");

        return reporte.toString();
    }
}