import ucn.*;
import java.util.ArrayList;
import java.util.Collections;

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

    /**
     * @param pokemon entregado por usuario
     */
    public void desplegarPokemon(Pokemon pokemon) {
        //Se despliegan los pokemons mediante su clase.
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

    public void desplegarPrimeraEvolucion() {
        ArrayList<Integer> listaOrdenar = new ArrayList<>();
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null){
            pokemon = aux.getDato();
            listaOrdenar.add(pokemon.getId());
            aux = aux.getSiguiente();
        }
        //Se ordena de manera decreciente los pokemons mediante su id
        listaOrdenar.sort(Collections.reverseOrder());
        aux = this.head;
        int tamanio = listaOrdenar.size();
        int contador = 0;
        //Ciclo que entrega los pokemons en orden mediante la lista Array
        while (contador!= tamanio) {
            pokemon = aux.getDato();
            int ID = pokemon.getId();
            if (listaOrdenar.get(contador) == ID){
                if (pokemon.getEtapa().equalsIgnoreCase("PrimeraEvolucion")) {
                    desplegarPokemon(pokemon);
                }
                contador++;
            }
            aux = aux.getSiguiente();
            if (aux == null){
                aux = this.head;
            }
        }
    }

    /**
     * @param numero1 entregado por el usuario
     * @param numero2 entregado por el usuario
     */
    public void deplegarRangoNumeros(int numero1, int numero2) {
        ArrayList<Integer> listaOrdenar = new ArrayList<>();
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null) {
            pokemon = aux.getDato();
            listaOrdenar.add(pokemon.getId());
            aux = aux.getSiguiente();
        }
        //Se ordena de manera creciente la lista mediante las id
        Collections.sort(listaOrdenar);
        aux = this.head;
        int tamanio = listaOrdenar.size();
        int contador = 0;
        //Ciclo que entrega los pokemons de manera creciente por su id
        while (tamanio != contador) {
            pokemon = aux.getDato();
            int id = pokemon.getId();
            if (listaOrdenar.get(contador) == id) {
                if (id > numero1 && id < numero2) {
                    desplegarPokemon(pokemon);
                }
                contador++;
            }
            aux = aux.getSiguiente();
            if (aux == null) {
                aux = this.head;
            }
        }
    }

    /**
     * @param tipo especificado por el usuario
     */
    public void desplegarTipo(String tipo) {
        NodoDoble aux = this.head;
        Pokemon pokemon;
        //Cilo el cual entregara solo los pokemons que coincidan con el tipo especifico
        while (aux != null) {
            pokemon = aux.getDato();
            if (pokemon.getTipo1().equalsIgnoreCase(tipo) || pokemon.getTipo2().equalsIgnoreCase(tipo)) {
                desplegarPokemon(pokemon);
            }
            aux = aux.getSiguiente();
        }
    }

    public void OrdenarAlfabeticamente() {
        StdOut.println("");
        StdOut.println("---------------------------------------------------------------");
        ArrayList<String> listaOrdenar = new ArrayList<>();
        NodoDoble aux = this.head;
        Pokemon pokemon;
        while (aux != null) {
            pokemon = aux.getDato();
            listaOrdenar.add(pokemon.getNombre());
            aux = aux.getSiguiente();
        }
        //Se ordena alfabeticamente el ArrayList
        Collections.sort(listaOrdenar);
        NodoDoble aux1 = this.head;
        pokemon = aux1.getDato();
        int tamanio = listaOrdenar.size();
        int contador = 0;
        //Ciclo el cual entregara ordenadamente los pokemons
        while (contador != tamanio) {
            String nombre = pokemon.getNombre();
            if (listaOrdenar.get(contador).equalsIgnoreCase(nombre)) {
                desplegarPokemon(pokemon);
                contador++;
            }
            aux1 = aux1.getSiguiente();
            if (aux1 == null) {
                aux1 = this.head;
            }
            pokemon = aux1.getDato();
        }
        StdOut.println("---------------------------------------------------------------");
        StdOut.println("");
    }

    /**
     * Si es que el usuario busca mediante el id se derivara directamente a este metodo.
     * @param id entregada por el usuario.
     */
    public void busquedaPId (int id) {
        NodoDoble aux = this.head;
        Pokemon pokemon = aux.getDato();
        while (true) {
            if (pokemon.getId() == id) {
                buscaPersonalizada(pokemon);
                break;
            }
            aux = aux.getSiguiente();
            if (aux == null) {
                aux = this.head;
            }
            pokemon = aux.getDato();
        }
    }

    /**
     * Mediante el nombre entregado se buscara la ID del pokemon y esta sera derivada al metodo busquedaPId.
     * @param nombre entregado por el usuario.
     */
    public void busquedaPNombre (String nombre) {
        NodoDoble aux = this.head;
        Pokemon pokemon = aux.getDato();
        while (!pokemon.getNombre().equalsIgnoreCase(nombre)) {
            pokemon = aux.getDato();
            aux = aux.getSiguiente();
            if (aux == null) {
                StdOut.println("Por favor escriba un nombre valido de pokemon!");
                StdOut.println("Ingrese nombre del pokemon a buscar");
                String opcion = StdIn.readLine();
                busquedaPNombre(opcion);
                return;
            }
        }
        busquedaPId(pokemon.getId());
    }

    /**
     * A partir de este metodo salen 3 metodos mas, los cuales se llamaran entre si, entregandose el nombre del pokemon
     * para no perder la informacion, hasta que el usuario elija cerrar el menu de busqueda y volver al inicial.
     * @param pokemon entregado por los metodos de busqueda personalizada.
     */
    public void buscaPersonalizada (Pokemon pokemon) {
        switch (pokemon.getEtapa()) {
            case "Basico" -> busquedaBasico(pokemon.getNombre());
            case "PrimeraEvolucion" -> busquedaPrimeraEvolucion(pokemon.getNombre());
            case "SegundaEvolucion" -> busquedaSegundaEvolucion(pokemon.getNombre());
        }
    }

    public void busquedaBasico (String nombrePokemon) {
        NodoDoble aux = this.head;
        Pokemon auxPokemon = aux.getDato();
        while (!auxPokemon.getNombre().equalsIgnoreCase(nombrePokemon)) {
            aux = aux.getSiguiente();
            if (aux == null) {
                aux = this.head;
            }
            auxPokemon = aux.getDato();
        }
        StdOut.println("");
        StdOut.println("El pokemon escogido es: ");
        StdOut.println("-----------------------------------------------------");
        desplegarPokemon(auxPokemon);
        StdOut.println("-----------------------------------------------------");
        StdOut.println("""
                    Elija evolucion la cual quisiera obtener la informacion:
                               
                    [1] Primera Evolucion.
                    [2] Segunda Evolucion.
                    
                    [3] Salir.
                    """);
        StdOut.print("Escoja una opcion: ");
        String opcion = StdIn.readLine();
        switch (opcion) {
            case "1" -> {
                if (auxPokemon.getPrimeraEvolucion() == null) {
                    StdOut.println("El pokemon no tiene primera evolucion!");
                    busquedaBasico(auxPokemon.getNombre());
                } else {
                    String nombreEvolucion = auxPokemon.getPrimeraEvolucion();
                    busquedaPrimeraEvolucion(nombreEvolucion);
                }
            }
            case "2" -> {
                if (auxPokemon.getSegundaEvolucion() == null) {
                    StdOut.println("El pokemon no tiene segunda evolucion!");
                    busquedaBasico(auxPokemon.getNombre());
                } else {
                    String nombreEvolucion = auxPokemon.getSegundaEvolucion();
                    busquedaSegundaEvolucion(nombreEvolucion);
                }
            }
            case "3" ->{}
            default -> {
                StdOut.println("Escoja una opcion valida!");
                busquedaBasico(auxPokemon.getNombre());
            }
        }
    }

    public void busquedaPrimeraEvolucion (String nombreEvolucion) {
        NodoDoble aux = this.head;
        Pokemon auxPokemon = aux.getDato();
        while (!auxPokemon.getNombre().equalsIgnoreCase(nombreEvolucion)) {
            aux = aux.getSiguiente();
            if (aux == null) {
                aux = this.head;
            }
            auxPokemon = aux.getDato();
        }
        StdOut.println("");
        StdOut.println("El pokemon escogido es: ");
        StdOut.println("-----------------------------------------------------");
        desplegarPokemon(auxPokemon);
        StdOut.println("-----------------------------------------------------");
        StdOut.println("""
                    Elija evolucion la cual quisiera obtener la informacion:
                               
                    [1] Evolucion Basica.
                    [2] Segunda Evolucion.
                    
                    [3] Salir.
                    """);
        StdOut.print("Escoja una opcion: ");
        String opcion = StdIn.readLine();
        //Se convierte el pokemon a PrimeraEvolucion para poder usar lo atributos de esta clase.
        PrimeraEvolucion pokemonBuscar = (PrimeraEvolucion) auxPokemon;
        switch (opcion) {
            case "1" -> {
                String nombreBasico = pokemonBuscar.getEvolucionBasica();
                busquedaBasico(nombreBasico);
            }
            case "2" -> {
                if (pokemonBuscar.getEvolucionSiguiente() == null) {
                    StdOut.println("El pokemon no tiene segunda evolucion!");
                    busquedaPrimeraEvolucion(pokemonBuscar.getNombre());
                } else {
                    String nombrePokemon = pokemonBuscar.getEvolucionSiguiente();
                    busquedaSegundaEvolucion(nombrePokemon);
                }
            }
            case "3" -> {}
            default -> {
                StdOut.println("Escoja una opcion valida!");
                busquedaPrimeraEvolucion(auxPokemon.getNombre());
            }

        }
    }

    public void busquedaSegundaEvolucion (String nombrePokemon) {
        NodoDoble aux = this.head;
        Pokemon auxPokemon = aux.getDato();
        while (!auxPokemon.getNombre().equalsIgnoreCase(nombrePokemon)) {
            aux = aux.getSiguiente();
            if (aux == null) {
                aux = this.head;
            }
            auxPokemon = aux.getDato();
        }
        StdOut.println("");
        StdOut.println("El pokemon escogido es: ");
        StdOut.println("-----------------------------------------------------");
        desplegarPokemon(auxPokemon);
        StdOut.println("-----------------------------------------------------");
        StdOut.println("""
                    Elija evolucion la cual quisiera obtener la informacion:
                               
                    [1] Evolucion Basica.
                    [2] Primera Evolucion.
                    
                    [3] Salir.
                    """);
        StdOut.print("Escoja una opcion: ");
        String opcion = StdIn.readLine();
        //Se convierte al pokemon en SegundaEvolucion para poder ocupar los atributos de la clase
        SegundaEvolucion pokemonBuscar = (SegundaEvolucion) auxPokemon;
        switch (opcion) {
            case "1" -> {
                String nombreBasico = pokemonBuscar.getEvolucionBasica();
                busquedaBasico(nombreBasico);
            }
            case "2" -> {
                if (pokemonBuscar.getEvolucionPrevia() == null) {
                    StdOut.println("El pokemon no tiene primera evolucion!");
                } else {
                    String nombreEvolucion = pokemonBuscar.getEvolucionPrevia();
                    busquedaPrimeraEvolucion(nombreEvolucion);
                }
            }
            case "3" -> {}
            default -> {
                StdOut.println("Escoja una opcion valida!");
                busquedaSegundaEvolucion(auxPokemon.getNombre());
            }
        }
    }
}

