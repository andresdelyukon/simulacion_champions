public class Delantero extends Jugador{

    public Delantero(int ID, String nombre, int ranking, String tipo, String equipo) {
        super(ID, nombre, ranking, tipo, equipo);
    }

    public int anotar(double probabilidadExtra) {
        double random = Math.random();
        return random < (0.5 + probabilidadExtra) ? 1 : 0;
    }


}
