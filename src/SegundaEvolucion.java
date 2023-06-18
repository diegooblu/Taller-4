public class SegundaEvolucion extends Pokemon{

    private String evolucionPrevia;
    private String evolucionBasica;

    public SegundaEvolucion(int id, String nombre, String etapa, String tipo1, String tipo2, String evolucionPrevia, String evolucionBasica) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evolucionPrevia = evolucionPrevia;
        this.evolucionBasica = evolucionBasica;
    }

    public String getEvolucionPrevia() {
        return evolucionPrevia;
    }

    public String getEvolucionBasica() {
        return evolucionBasica;
    }

    public void setEvolucionPrevia(String evolucionPrevia) {
        this.evolucionPrevia = evolucionPrevia;
    }
}
