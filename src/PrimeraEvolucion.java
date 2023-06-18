public class PrimeraEvolucion extends Pokemon{

    private String evolucionBasica;

    private String evolucionSiguiente;

    public PrimeraEvolucion(int id, String nombre, String etapa, String tipo1, String tipo2, String evolucionBasica) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evolucionBasica = evolucionBasica;
    }

    public String getEvolucionBasica() {
        return evolucionBasica;
    }

    public void setEvolucionBasica(String evolucionBasica) {
        this.evolucionBasica = evolucionBasica;
    }

    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }

    public void setEvolucionSiguiente(String evolucionSiguiente) {
        this.evolucionSiguiente = evolucionSiguiente;
    }
}
