package datos;

public class Recurso {
    private boolean disponible;
    private String nombre;
    private String tipo;
    private int cantidad;

    // Constructor
    public Recurso(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // toString method
    public String toString() {
        return "Recurso [nombre=" + nombre + ", tipo=" + tipo + ", cantidad=" + cantidad + "]";
    }
}
