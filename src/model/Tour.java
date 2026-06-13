package model;

public class Tour {
    private String nombre;
    private String tipo;
    private int stock;

    public Tour(String nombre, String tipo, int stock) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.stock = stock;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getStock() { return stock; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Tour{nombre='" + nombre + "', tipo='" + tipo + "', stock=" + stock + "}";
    }
}