package model;

public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Paseo Lacustre | Embarcación: " + tipoEmbarcacion;
    }
    // NUEVO (Semana 7): sobrescritura polimórfica
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   Tipo: Paseo Lacustre | Embarcación: " + tipoEmbarcacion);
    }
}