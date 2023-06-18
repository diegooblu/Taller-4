import java.io.IOException;

public interface Sistema {

    /**
     * Lectura de archivo que dara inicio al codigo, leyendo archivos de txt desordenados y ordenandolos,
     * guardando los distintos pokemons en la lista de nodos del programa.
     * @throws IOException
     */
    void LecturaArchivo() throws IOException;

    /**
     * Menu en el cual el usuario podra llegar a todas las opciones ofrecidas por el programa.
     */
    void Menu();

    /**
     * Metodo que desplegara los pokemons dentro de un rango de numero especifico ingresado por el usuario
     * ademas de desplegarlos de manera creciente segun su ID.
     */
    void DesplegarPokemonRangoNumero();

    /**
     * Metodo que desplegara los pokemons ordenamos de manera alfabetica por sus nombres, entregando
     * toda la informacion de los mismos.
     */
    void DesplegarPokemonOrdenados();

    /**
     * Al usuario ingresas por teclado un tipo de pokemon, el sistema desplegara a todos lo pokemons que
     * coincidan con el ingresado, sin importar si sea el primer o segundo tipo.
     */
    void DeplegarTipoPokemon();

    /**
     * Metodo que desplegara todos los pokemons que sean de primera evolucion ingresados en el sistema.
     */
    void DesplegarPrimeraEvolucion();

    /**
     * Metodo en el cual se realizara una busqueda personalizada por el usuario, donde podra elegir un pokemon
     * en especifico mediante su nombre o su id, y podra navegar entre las evoluciones siguiente o previas
     * si es el caso.
     */
    void BusquedaPersonalizada();
}
