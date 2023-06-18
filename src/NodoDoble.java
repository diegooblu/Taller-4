public class NodoDoble {

    Pokemon Dato;
    NodoDoble Anterior;
    NodoDoble Siguiente;

    public NodoDoble(Pokemon dato) {
        Dato = dato;
    }

    public void setAnterior(NodoDoble anterior) {
        Anterior = anterior;
    }

    public void setSiguiente(NodoDoble siguiente) {
        Siguiente = siguiente;
    }

    public Pokemon getDato() {
        return Dato;
    }

    public NodoDoble getSiguiente() {
        return Siguiente;
    }
}
