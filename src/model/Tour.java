package model;

public class Tour {
    private String nombre;
    private String tipo;
    private int stock;
    private Guia guia;   // NUEVO: el Tour ahora contiene un Guia

    // NUEVO: agregamos "Guia guia" al constructor
    public Tour(String nombre, String tipo, int stock, Guia guia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.stock = stock;
        this.guia = guia;   // NUEVO
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getStock() { return stock; }
    public Guia getGuia() { return guia; }   // NUEVO

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setStock(int stock) { this.stock = stock; }
    public void setGuia(Guia guia) { this.guia = guia; }   // NUEVO

    @Override
    public String toString() {
        return "Tour{nombre='" + nombre + "', tipo='" + tipo +
                "', stock=" + stock + ", guia=" + guia + "}";   // NUEVO: + ", guia=" + guia
    }
}