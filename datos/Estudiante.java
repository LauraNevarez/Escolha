package datos;

public class Estudiante {
    private int id;            // ID del estudiante (código único)
    private String nombre;     // Nombre del estudiante
    private String email;      // Correo electrónico del estudiante
    private Fecha fechaNacimiento; // Fecha de nacimiento del estudiante
    private String genero;     // Género del estudiante
    private String carrera;    // Carrera que estudia el estudiante

    /**
     * Constructor para crear un nuevo estudiante.
     * 
     * @param id Código del estudiante
     * @param nombre Nombre del estudiante
     * @param email Correo electrónico del estudiante
     * @param fechaNacimiento Fecha de nacimiento del estudiante
     * @param genero Género del estudiante
     * @param carrera Carrera del estudiante
     */
    public Estudiante(int id, String nombre, String email, Fecha fechaNacimiento, String genero, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.carrera = carrera;
    }

    // Métodos getter y setter para acceder y modificar los atributos del estudiante.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Método para mostrar los detalles del estudiante.
     * 
     * @return String con la información completa del estudiante.
     */
    @Override
    public String toString() {
        return id + " - " + nombre + " (" + email + ") - " + genero + " - " + carrera;
    }
}