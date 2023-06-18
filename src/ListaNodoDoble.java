import ucn.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaNodoDoble {

    NodoDoble head;
    NodoDoble tail;

    public ListaNodoDoble() {
        this.head = null;
        this.tail = null;
    }

    public void InsetaralFinalHead(Pokemon dato) {
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (this.head == null) {
            this.tail = nuevoNodo;
            this.head = nuevoNodo;
            return;
        }
        NodoDoble aux = this.head;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(aux);
        this.tail = nuevoNodo;
    }

    public void desplegarPokemon(Pokemon pokemon) {
        switch (pokemon.getEtapa()) {
            case "Basico" -> {
                if (pokemon.getPrimeraEvolucion() == null) {
                    StdOut.println(pokemon.getId() + "," + pokemon.getNombre() + "," + pokemon.getEtapa() + "," + pokemon.getTipo1() + "," + pokemon.getTipo2());
                }
                if (pokemon.getSegundaEvolucion() == null && pokemon.getPrimeraEvolucion() != null) {
                    StdOut.println(pokemon.getId() + "," + pokemon.getNombre() + "," + pokemon.getEtapa() + "," + pokemon.getPrimeraEvolucion() + "," + pokemon.getTipo1() + "," + pokemon.getTipo2());
                }
                if (pokemon.getSegundaEvolucion() != null && pokemon.getPrimeraEvolucion() != null) {
                    StdOut.println(pokemon.getId() + "," + pokemon.getNombre() + "," + pokemon.getEtapa() + "," + pokemon.getSegundaEvolucion() + "," + pokemon.getPrimeraEvolucion() + "," + pokemon.getTipo1() + "," + pokemon.getTipo2());
                }
            }
            case "PrimeraEvolucion" -> {
                PrimeraEvolucion auxPokemon = (PrimeraEvolucion) pokemon;
                if (auxPokemon.getEvolucionSiguiente() == null) {
                    StdOut.println(auxPokemon.getId() + "," + auxPokemon.getNombre() + "," + auxPokemon.getEtapa() + "," + auxPokemon.getEvolucionBasica() + "," + auxPokemon.getTipo1() + "," + auxPokemon.getTipo2());
                }
                if (auxPokemon.getEvolucionSiguiente() != null) {
                    StdOut.println(auxPokemon.getId() + "," + auxPokemon.getNombre() + "," + auxPokemon.getEtapa() + "," + auxPokemon.getEvolucionSiguiente() + "," + auxPokemon.getEvolucionBasica() + "," + auxPokemon.getTipo1() + "," + auxPokemon.getTipo2());
                }
            }
            case "SegundaEvolucion" -> {
                SegundaEvolucion auxPokemon = (SegundaEvolucion) pokemon;
                StdOut.println(auxPokemon.getId() + "," + auxPokemon.getNombre() + "," + auxPokemon.getEtapa() + "," + auxPokemon.getEvolucionPrevia() + "," + auxPokemon.getEvolucionBasica() + "," + auxPokemon.getTipo1() + "," + auxPokemon.getTipo2());
            }
        }
    }

    public void recorrer() {
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null) {
            pokemon = aux.getDato();
            desplegarPokemon(pokemon);
            aux = aux.getSiguiente();
        }
    }

    public void desplegarPrimeraEvolucion() {

    }

    public void deplegarRangoNumeros(int numero1, int numero2) {
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null) {
            pokemon = aux.getDato();
            if (pokemon.getId() > numero1 && pokemon.getId() < numero2) {
                desplegarPokemon(pokemon);
            }
            aux = aux.getSiguiente();
        }
    }

    public void desplegarTipo(String tipo) {
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null) {
            pokemon = aux.getDato();
            if (pokemon.getTipo1().equalsIgnoreCase(tipo) || pokemon.getTipo2().equalsIgnoreCase(tipo)) {
                desplegarPokemon(pokemon);
            }
            aux = aux.getSiguiente();
        }
    }

    public void OrdenarAlfabeticamente() {
        ArrayList<String> listaOrdenar = new ArrayList<>();
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null) {
            pokemon = aux.getDato();
            listaOrdenar.add(pokemon.getNombre());
            aux = aux.getSiguiente();
        }
        Collections.sort(listaOrdenar);
        NodoDoble aux1 = this.head;
        pokemon = aux1.getDato();
        int tamanio = listaOrdenar.size();
        int contador = 0;
        while (contador != tamanio) {
            String nombre = pokemon.getNombre();
            if(listaOrdenar.get(contador).equalsIgnoreCase(nombre)){
                desplegarPokemon(pokemon);
                contador++;
            }
            aux1 = aux1.getSiguiente();
            if (aux1 == null) {
                aux1 = this.head;
            }
            pokemon = aux1.getDato();
        }
    }

    public void Ordenar() {
        boolean cambio = true;

        while (cambio) {
            int iteracion = 0;
            cambio = false;

            for (NodoDoble i = this.head; iteracion < 30; i = i.getSiguiente()) {
                if (i.getDato().getId() > i.getSiguiente().getDato().getId()){

                }
                iteracion++;
            }
        }
    }
}

