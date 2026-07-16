package data;

import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.RecursoAgencia;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;

/**
 * Gestor de las entidades registrables de la agencia.
 *
 * Almacena objetos de distintas clases en una única colección genérica
 * ArrayList<Registrable>, aprovechando que todas comparten el mismo contrato.
 * Al recorrerla, usa el operador instanceof para identificar el tipo real de
 * cada objeto en tiempo de ejecución y aplicar lógica diferenciada.
 */
public class GestorEntidades {

    // Colección polimórfica: acepta cualquier objeto que implemente Registrable
    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    /**
     * Agrega una entidad a la colección, sin importar su clase concreta.
     */
    public void agregarEntidad(Registrable entidad) {
        if (entidad != null) {
            entidades.add(entidad);
        }
    }

    public int getCantidadEntidades() {
        return entidades.size();
    }

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Recorre la colección y construye un reporte completo.
     *
     * Aquí ocurre el polimorfismo: la llamada a mostrarResumen() se resuelve
     * en tiempo de ejecución según la clase real del objeto. Además, instanceof
     * permite agregar información extra que solo existe en cada subclase.
     */
    public String generarReporte() {
        if (entidades.isEmpty()) {
            return "No hay entidades registradas todavia.\nUsa los botones de arriba para agregar algunas.";
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("===== REPORTE DE ENTIDADES REGISTRADAS =====\n\n");

        int contador = 1;

        // Recorrido con for-each sobre la colección genérica
        for (Registrable entidad : entidades) {

            // Llamada polimórfica: cada clase responde con su propia versión
            reporte.append(contador).append(". ").append(entidad.mostrarResumen()).append("\n");

            // Lógica diferenciada por tipo usando instanceof
            if (entidad instanceof GuiaTuristico) {
                GuiaTuristico guia = (GuiaTuristico) entidad;   // downcast seguro
                if (guia.getAniosExperiencia() >= 5) {
                    reporte.append("   >> Guia senior: habilitado para tours internacionales.\n");
                } else {
                    reporte.append("   >> Guia junior: requiere acompanamiento en tours largos.\n");
                }

            } else if (entidad instanceof Vehiculo) {
                Vehiculo vehiculo = (Vehiculo) entidad;
                if (vehiculo.getCapacidad() >= 20) {
                    reporte.append("   >> Vehiculo de alta capacidad: apto para grupos grandes.\n");
                } else {
                    reporte.append("   >> Vehiculo pequeno: ideal para tours privados.\n");
                }

            } else if (entidad instanceof ColaboradorExterno) {
                ColaboradorExterno colaborador = (ColaboradorExterno) entidad;
                double costoSemana = colaborador.getTarifaPorJornada() * 5;
                reporte.append("   >> Costo estimado por semana (5 jornadas): $")
                        .append(costoSemana).append("\n");

            } else {
                reporte.append("   >> Entidad generica sin logica especializada.\n");
            }

            reporte.append("\n");
            contador++;
        }

        reporte.append("Total de entidades registradas: ").append(entidades.size());
        return reporte.toString();
    }

    /**
     * Cuenta cuántas entidades pertenecen a una jerarquía determinada,
     * demostrando instanceof aplicado sobre la superclase común.
     */
    public int contarRecursosAgencia() {
        int total = 0;
        for (Registrable entidad : entidades) {
            if (entidad instanceof RecursoAgencia) {
                total++;
            }
        }
        return total;
    }
}
