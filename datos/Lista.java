package datos;
public class Lista<T> {
    public class Lista<T> {
    private List<T> elementos = new ArrayList<>();

    public int getTamanio() {
        return elementos.size();
    }

    public T getValor(int index) {
        return elementos.get(index);
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }
}

    private Nodo<T> cabeza;
    private int tamaño;

    public Lista() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregar(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    public void eliminar(T valor) {
        if (cabeza == null) return;
        if (cabeza.getValor().equals(valor)) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null && !actual.getSiguiente().getValor().equals(valor)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamaño--;
        }
    }

    public boolean contiene(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int tamaño() {
        return tamaño;
    }

    public Nodo<T> obtenerNodo(int index) throws PosicionIllegalException {
        if (index < 0 || index >= tamaño) {
            throw new PosicionIllegalException("Índice fuera de rango.");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }
}
