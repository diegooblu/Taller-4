import ucn.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.stream.Collectors;


public class SistemaImpl implements Sistema{

    private ListaNodoDoble listaNodoDoble;

    SistemaImpl() throws IOException {
        this.listaNodoDoble = new ListaNodoDoble();
        LecturaArchivo();
        Menu();
    }

    @Override
    public void LecturaArchivo() throws IOException {
        String inputFile = "kanto.txt";
        String outputFile = "kantoOrdenado.txt";
        try {
            // Leer el archivo desordenado, filtrar las líneas vacías, ordenar las líneas y guardar el resultado en el archivo ordenado
            Files.write(Paths.get(outputFile),
                    Files.lines(Paths.get(inputFile))
                            .map(line -> line.replaceAll("\\s+", ""))
                            .filter(line -> !line.isEmpty())
                            .sorted()
                            .collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArchivoEntrada kantoLista = new ArchivoEntrada("kantoOrdenado.txt");
        while (!kantoLista.isEndFile()) {
            Registro regEnt = kantoLista.getRegistro();
            int id = regEnt.getInt();
            String nombre = regEnt.getString();
            String etapa = regEnt.getString();
            switch (etapa){
                case "Basico" -> {
                    boolean verificar = true;
                    String aux = regEnt.getString();
                    if (!aux.equals("Hierba") && !aux.equals("Insecto") && !aux.equals("Volador") && !aux.equals("Agua") && !aux.equals("Fuego") &&
                            !aux.equals("Electrico") && !aux.equals("Veneno") && !aux.equals("Fantasma") && !aux.equals("Dragon") && !aux.equals("Hielo") &&
                            !aux.equals("Roca") && !aux.equals("Hada") && !aux.equals("Lucha") && !aux.equals("Acero") && !aux.equals("Psiquico") && !aux.equals("Tierra") && !aux.equals("Normal") && !aux.equals("Planta")) {
                        String aux1 = regEnt.getString();
                        if (!aux1.equals("Hierba") && !aux1.equals("Insecto") && !aux1.equals("Volador") && !aux1.equals("Agua") && !aux1.equals("Fuego") &&
                                !aux1.equals("Electrico") && !aux1.equals("Veneno") && !aux1.equals("Fantasma") && !aux1.equals("Dragon") && !aux1.equals("Hielo") &&
                                !aux1.equals("Roca") && !aux1.equals("Hada") && !aux1.equals("Lucha") && !aux1.equals("Acero") && !aux1.equals("Psiquico") && !aux1.equals("Tierra") && !aux1.equals("Normal") && !aux1.equals("Planta")){
                            String tipo1 = regEnt.getString();
                            String tipo2 = regEnt.getString();
                            Pokemon pokemon = new Pokemon(id,nombre,etapa,tipo1,tipo2);
                            pokemon.setPrimeraEvolucion(aux);
                            pokemon.setSegundaEvolucion(aux1);
                            listaNodoDoble.InsetaralFinalHead(pokemon);
                            verificar = false;
                        }
                        if (verificar) {
                            String tipo2 = regEnt.getString();
                            Pokemon pokemon = new Pokemon(id, nombre, etapa, aux1, tipo2);
                            pokemon.setPrimeraEvolucion(aux);
                            listaNodoDoble.InsetaralFinalHead(pokemon);
                        }
                    } else {
                        String tipo2 = regEnt.getString();
                        Pokemon pokemon = new Pokemon(id,nombre,etapa,aux,tipo2);
                        listaNodoDoble.InsetaralFinalHead(pokemon);
                    }
                }
                case "PrimeraEvolucion" -> {
                    String auxEvolucion = regEnt.getString();
                    String aux = regEnt.getString();
                    boolean verificar = true;
                    if (!aux.equals("Hierba") && !aux.equals("Insecto") && !aux.equals("Volador") && !aux.equals("Agua") && !aux.equals("Fuego") &&
                            !aux.equals("Electrico") && !aux.equals("Veneno") && !aux.equals("Fantasma") && !aux.equals("Dragon") && !aux.equals("Hielo") &&
                            !aux.equals("Roca") && !aux.equals("Hada") && !aux.equals("Lucha") && !aux.equals("Acero") && !aux.equals("Psiquico") && !aux.equals("Tierra") && !aux.equals("Normal") && !aux.equals("Planta")) {
                        String tipo1 = regEnt.getString();
                        String tipo2 = regEnt.getString();
                        Pokemon pokemon = new PrimeraEvolucion(id,nombre,etapa,tipo1,tipo2,aux);
                        ((PrimeraEvolucion) pokemon).setEvolucionSiguiente(auxEvolucion);
                        listaNodoDoble.InsetaralFinalHead(pokemon);
                        verificar = false;
                    }
                    if (verificar) {
                        String tipo2 = regEnt.getString();
                        Pokemon pokemon = new PrimeraEvolucion(id, nombre, etapa, aux, tipo2, auxEvolucion);
                        listaNodoDoble.InsetaralFinalHead(pokemon);
                    }
                }
                case "SegundaEvolucion" -> {
                    String evolucionPrevia = regEnt.getString();
                    String evolucionBasica = regEnt.getString();
                    String tipo1 = regEnt.getString();
                    String tipo2 = regEnt.getString();
                    Pokemon pokemon = new SegundaEvolucion(id,nombre,etapa,tipo1,tipo2,evolucionPrevia,evolucionBasica);
                    listaNodoDoble.InsetaralFinalHead(pokemon);
                }
            }
        }
    }
    @Override
    public void Menu() {
        StdOut.println("¡Bienvenido al nuevo sistema de busqueda de pokemon POKEDEX!");
        while (true) {
            StdOut.println("""
                    [1] Pokemons entre rango de números.
                    [2] Pokemons ordenados alfabeticamente.
                    [3] Pokemons por tipo.
                    [4] Primeras evoluciones.
                    [5] Busqueda Personalizada.
                    
                    [6] Salir del sistema.
                    """);
            StdOut.print("Escoja un opcion: ");
            String opcionEscogida = StdIn.readLine();
            if (opcionEscogida.equals("6")){
                StdOut.print("Muchas gracias usar nuestros servicios!");
                break;
            }
            switch (opcionEscogida) {
                case "1" -> DesplegarPokemonRangoNumero();
                case "2" -> DesplegarPokemonOrdenados();
                case "3" -> DeplegarTipoPokemon();
                case "4" -> DesplegarPrimeraEvolucion();
                case "5" -> BusquedaPersonalizada();
                default -> StdOut.println("¡Por favor escoja una opcion valida!");
            }
        }
    }

    @Override
    public void DesplegarPokemonRangoNumero() {
        try {
            StdOut.println("Ingrese los dos numeros entre los cuales buscar pokemons");
            StdOut.println("Solo numeros entre 1-151");
            int numero1;
            while (true) {
                StdOut.print("Numero N°1: ");
                numero1 = StdIn.readInt();
                if (numero1 < 1 || numero1 > 151) {
                    StdOut.println("porfavor, numeros entre 1-151");
                    StdOut.print("Numero N°1: ");
                    numero1 = StdIn.readInt();
                } else {
                    break;
                }
            }
            StdOut.print("Numero N°2: ");
            int numero2;
            while (true) {
                numero2 = StdIn.readInt();
                if (numero2 < 1 || numero2 > 151) {
                    StdOut.println("porfavor, numeros entre 1-151");
                    StdOut.print("Numero N°2: ");
                    numero2 = StdIn.readInt();
                } else {
                    break;
                }
            }
            if (numero1 > numero2) {
                int numeroAux = numero2;
                numero2 = numero1;
                numero1 = numeroAux;
            }
            StdOut.println("-----------------------------------------------------");
            listaNodoDoble.deplegarRangoNumeros(numero1,numero2);
            StdOut.println("-----------------------------------------------------");
        }catch (InputMismatchException e){
            StdOut.println("weqweqergda");
        }
    }

    @Override
    public void DesplegarPokemonOrdenados() {
        listaNodoDoble.OrdenarAlfabeticamente();
    }

    @Override
    public void DeplegarTipoPokemon() {
        StdOut.println("Por favor ingrese el tipo de pokemon que quiera buscar");
        StdOut.println("Si no recuerda los tipos de pokemon que hay escriba *ayuda*");
        StdOut.print("Tipo: ");
        String tipo = StdIn.readString();
        if (tipo.equalsIgnoreCase("ayuda")){
            StdOut.println("Tipos de pokemon:");
            StdOut.println("Hierba, Insecto, Volador, Agua, Fuego, Electrico, Veneno, Fantasma, Dragon, Hielo, Roca, Hada, Lucha, Acero, Psiquico, Tierra, Normal, Planta.");
        }
        while (!tipo.equalsIgnoreCase("Hierba") && !tipo.equalsIgnoreCase("Insecto") && !tipo.equalsIgnoreCase("Volador") && !tipo.equalsIgnoreCase("Agua") && !tipo.equalsIgnoreCase("Fuego") &&
                !tipo.equalsIgnoreCase("Electrico") && !tipo.equalsIgnoreCase("Veneno") && !tipo.equalsIgnoreCase("Fantasma") && !tipo.equalsIgnoreCase("Dragon") && !tipo.equalsIgnoreCase("Hielo") &&
                !tipo.equalsIgnoreCase("Roca") && !tipo.equalsIgnoreCase("Hada") && !tipo.equalsIgnoreCase("Lucha") && !tipo.equalsIgnoreCase("Acero") && !tipo.equalsIgnoreCase("Psiquico") &&
                !tipo.equalsIgnoreCase("Tierra") && !tipo.equalsIgnoreCase("Normal") && !tipo.equalsIgnoreCase("Planta")) {
            if (!tipo.equalsIgnoreCase("ayuda")){
                StdOut.println("Por favor escriba un tipo de pokemon valido!");
            }
            StdOut.println("Si no recuerda los tipos de pokemon que hay escriba *ayuda*");
            StdOut.print("Tipo: ");
            tipo = StdIn.readString();
            if (tipo.equalsIgnoreCase("ayuda")){
                StdOut.println("Tipos de pokemon:");
                StdOut.println("Hierba, Insecto, Volador, Agua, Fuego, Electrico, Veneno, Fantasma, Dragon, Hielo, Roca, Hada, Lucha, Acero, Psiquico, Tierra, Normal, Planta.");
            }
        }
        StdOut.println("-----------------------------------------------------");
        listaNodoDoble.desplegarTipo(tipo);
        StdOut.println("-----------------------------------------------------");
    }

    @Override
    public void DesplegarPrimeraEvolucion() {
        listaNodoDoble.desplegarPrimeraEvolucion();

    }

    @Override
    public void BusquedaPersonalizada() {
        StdOut.println("""
                    [1] Buscar por Nombre.
                    [2] Buscar por ID.
                    
                    [3] Salir del sistema.
                    """);
        StdOut.print("Escoja un opcion: ");
        String opcionEscogida = StdIn.readLine();

        switch (opcionEscogida){
            case "1" -> {
                StdOut.println("Ingrese nombre del pokemon a buscar");
                String nombre = StdIn.readString();

            }
            case "2" -> {
                StdOut.println("Ingrese ID del pokemon a buscar");
                int id = StdIn.readInt();
            }
        }



    }
}
