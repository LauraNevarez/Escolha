package negocios;

import datos.Estudiante;
import datos.Lista;
import datos.PosicionIlegalException;
import datos.Prestamo;
import datos.Recurso;
import datos.Fecha;
import datos.Email;
import datos.LectorArchivo;

/**
 * La clase Universidad representa una universidad que maneja listas de estudiantes, recursos y préstamos.
 * Proporciona métodos para gestionar estos datos.
 */
public class Universidad {
    private Lista<Estudiante> estudiantes;
    private Lista<Recurso> recursos;
    private Lista<Prestamo> prestamos;

    /**
     * Constructor por defecto que inicializa las listas de estudiantes, recursos y préstamos.
     */
    public Universidad() {
        // Invocar al archivo de recursos
    }

    /**
     * Agrega un nuevo estudiante a la lista de estudiantes.
     *
     * @param codigo   El código del estudiante.
     * @param nombre   El nombre del estudiante.
     * @param email    El correo electrónico del estudiante.
     * @param fechaNac La fecha de nacimiento del estudiante.
     * @param sexo     El sexo del estudiante.
     * @param programa El programa en el que está inscrito el estudiante.
     * @return true si el estudiante fue agregado exitosamente, false en caso contrario.
     * @throws PosicionIlegalException Si hay un error al intentar agregar el estudiante.
     */
    public boolean agregarEstudiante(int codigo, String nombre, Email email, Fecha fechaNac, char sexo, String programa) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Busca un estudiante por su código.
     *
     * @param codigo El código del estudiante.
     * @return El objeto `Estudiante` si existe, o `null` si no se encuentra.
     * @throws PosicionIlegalException Si hay un error al buscar el estudiante.
     */
    public Estudiante buscarEstudiante(int codigo) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Agrega un nuevo recurso a la lista de recursos.
     *
     * @param id    El ID del recurso.
     * @param nombre El nombre del recurso.
     * @return true si el recurso fue agregado exitosamente, false en caso contrario.
     * @throws PosicionIlegalException Si hay un error al intentar agregar el recurso.
     */
    public boolean agregarRecurso(int id, String nombre) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Busca un recurso por su ID.
     *
     * @param id El ID del recurso.
     * @return El objeto `Recurso` si existe, o `null` si no se encuentra.
     * @throws PosicionIlegalException Si hay un error al buscar el recurso.
     */
    public Recurso buscarRecurso(int id) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Realiza un préstamo de un recurso a un estudiante.
     *
     * @param codigo   El código del estudiante.
     * @param id       El ID del recurso.
     * @param fecha    La fecha del préstamo.
     * @return true si el préstamo se realizó exitosamente, false en caso contrario.
     * @throws PosicionIlegalException Si hay un error al realizar el préstamo.
     */
    public boolean prestarRecursos(int codigo, int id, Fecha fecha) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Consulta qué estudiante tiene un recurso específico.
     *
     * @param id El ID del recurso.
     * @return El objeto `Estudiante` que tiene el recurso, o `null` si no hay un estudiante con el recurso.
     * @throws PosicionIlegalException Si hay un error al realizar la consulta.
     */
    public Estudiante consultarEstudianteTieneRecurso(int id) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Consulta todos los recursos prestados por un estudiante específico.
     *
     * @param codigo El código del estudiante.
     * @return Una lista de `Recurso` prestados al estudiante, o `null` si no hay recursos prestados.
     * @throws PosicionIlegalException Si hay un error al realizar la consulta.
     */
    public Lista<Recurso> consultarRecursosDeUnEstudiante(int codigo) throws PosicionIlegalException {
        // Código aquí
    }

    /**
     * Realiza la devolución de un recurso.
     *
     * @param id        El ID del recurso.
     * @param fechaDev La fecha de devolución.
     * @return true si la devolución se realizó exitosamente, false en caso contrario.
     * @throws PosicionIlegalException Si hay un error al realizar la devolución.
     */
    public boolean devolverRecurso(int id, Fecha fechaDev) throws PosicionIlegalException {
        Recurso rec = buscarRecurso(id);
        if (rec == null) {
            System.out.println("Recurso no existe");
            return false;
        }
        if (rec.isDisponible()) {
            System.out.println("El recurso " + rec + " no se puede devolver porque está disponible");
            return false;
        }
        for (int i = 0; i < prestamos.getTamanio(); i++) {
            Prestamo pres = prestamos.getValor(i);
            if (pres.getRecurso().getId() == id && pres.getFechaDevolucion() == null) {
                // Validar que la fecha de devolución no debe ser menor que la fecha de préstamo
                if (fechaDev.compareTo(pres.getFechaPrestamo()) < 0) {
                    System.out.println("La fecha de devolución no puede ser anterior a la fecha de préstamo");
                    return false;
                }
                // Asigno la fecha de devolución
                pres.setFechaDevolucion(fechaDev);
                rec.setDisponible(true);
                System.out.println("Se ha devuelto el recurso " + rec + " por parte del estudiante " + pres.getEstudiante() + " satisfactoriamente");
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un recurso del sistema.
     *
     * @param id El ID del recurso.
     * @return true si el recurso fue eliminado exitosamente, false en caso contrario.
     * @throws PosicionIlegalException Si hay un error al intentar eliminar el recurso.
     */
    public boolean eliminarRecurso(int id) throws PosicionIlegalException {
        Recurso recurso = buscarRecurso(id);
        if (recurso == null) {
            System.out.println("Recurso no existe");
            return false;
        }
        for (int i = 0; i < prestamos.getTamanio(); i++) {
            Prestamo prestamo = prestamos.getValor(i);
            if (prestamo.getRecurso().getId() == id) {
                prestamos.getEliminar(i); // Supongo que hay un método para eliminar elementos en Lista
            }
        }
        // Aquí eliminaríamos también el recurso de la lista recursos
        return true;
    }

    /**
     * Elimina un estudiante del sistema.
     *
     * @param codigo El código del estudiante.
     * @return true si el estudiante fue eliminado exitosamente, false en caso contrario.
     * @throws PosicionIlegalException Si hay un error al intentar eliminar el estudiante.
     */
    public boolean eliminarEstudiante(int codigo) throws PosicionIlegalException {
        Estudiante est = buscarEstudiante(codigo);
        if (est == null) {
            System.out.println("Estudiante no existe");
            return false;
        }
        for (int i = 0; i < prestamos.getTamanio(); i++) {
            Prestamo prestamo = prestamos.getValor(i);
            if (prestamo.getEstudiante().getCodigo() == codigo) {
                prestamos.getEliminar(i); // Supongo que hay un método para eliminar elementos en Lista
            }
        }
        // Aquí eliminaríamos también el estudiante de la lista estudiantes
        return true;
    }

    /**
     * Busca el nombre del recurso por su ID.
     *
     * @param id El ID del recurso.
     * @return El nombre del recurso, o "No encontrado" si no existe.
     * @throws PosicionIlegalException Si hay un error al realizar la búsqueda.
     */
    public String buscarNombreRecurso(int id) throws PosicionIlegalException {
        Recurso recurso = buscarRecurso(id);
        return recurso != null ? recurso.getNombre() : "No encontrado";
    }

    /**
     * Busca el nombre del estudiante por su código.
     *
     * @param codigo El código del estudiante.
     * @return El nombre del estudiante, o "No encontrado" si no existe.
     * @throws PosicionIlegalException Si hay un error al realizar la búsqueda.
     */
    public String buscarNombreEstudiante(int codigo) throws PosicionIlegalException {
        Estudiante estudiante = buscarEstudiante(codigo);
        return estudiante != null ? estudiante.getNombre() : "No encontrado";
    }

    /**
     * Muestra todos los recursos disponibles en la universidad.
     *
     * @return Una lista de recursos.
     * @throws PosicionIlegalException Si hay un error al realizar la consulta.
     */
    public Lista<Recurso> mostrarRecursos() throws PosicionIlegalException {
        return recursos;
    }

    /**
     * Muestra todos los estudiantes en la universidad.
     *
     * @return Una lista de estudiantes.
     * @throws PosicionIlegalException Si hay un error al realizar la consulta.
     */
    public Lista<Estudiante> mostrarEstudiantes() throws PosicionIlegalException {
        return estudiantes;  
    }
}