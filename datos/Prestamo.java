package datos;

/**
 * La clase Prestamo representa un préstamo de recursos realizado por un estudiante.
 * Contiene información sobre el recurso prestado, el estudiante que realiza el préstamo,
 * la fecha de préstamo y la fecha de devolución (si aplica).
 */
public class Prestamo {
    private Recurso recurso; // Recurso prestado
    private Estudiante estudiante; // Estudiante que realiza el préstamo
    private Fecha fechaPrestamo; // Fecha en que se realizó el préstamo
    private Fecha fechaDevolucion; // Fecha de devolución del recurso (puede ser null si no se ha devuelto)

    // Constructor por defecto
    public Prestamo() {
        // Inicializa los campos, si es necesario.
    }

    // Constructor que recibe recurso y estudiante
    public Prestamo(Recurso recurso, Estudiante estudiante) {
        this.recurso = recurso;
        this.estudiante = estudiante;
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
    }

    // Constructor que recibe recurso, estudiante y fecha de préstamo
    public Prestamo(Recurso recurso, Estudiante estudiante, Fecha fechaPrestamo) {
        this.recurso = recurso;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null; // No hay fecha de devolución al inicio
    }

    // Constructor que recibe recurso, estudiante, fecha de préstamo y fecha de devolución
    public Prestamo(Recurso recurso, Estudiante estudiante, Fecha fechaPrestamo, Fecha fechaDevolucion) {
        this.recurso = recurso;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getter y Setter para recurso
    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    // Getter y Setter para estudiante
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    // Getter y Setter para fecha de préstamo
    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    // Getter y Setter para fecha de devolución
    public Fecha getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Fecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // Método toString para representar el préstamo en formato String
    @Override
    public String toString() {
        return "Prestamo{" +
               "recurso=" + recurso.getNombre() + // Suponiendo que el Recurso tiene un método getNombre()
               ", estudiante=" + estudiante.getNombre() + // Suponiendo que el Estudiante tiene un método getNombre()
               ", fechaPrestamo=" + (fechaPrestamo != null ? fechaPrestamo.toString() : "No disponible") +
               ", fechaDevolucion=" + (fechaDevolucion != null ? fechaDevolucion.toString() : "No devuelto") +
               '}';
    }
}
