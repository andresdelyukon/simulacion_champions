import java.util.ArrayList;

public class Delantero extends Jugador{

    public Delantero(int ID, String nombre, int ranking, String tipo, String equipo) {
        super(ID, nombre, ranking, tipo, equipo);
    }
    private ArrayList<Delantero> delanteros = new ArrayList<>();

    public int anotar(double probabilidadExtra) {
        //guardamos en una variable double un Math que es una clase, el método random
        //a ese random le sumamos la probabilidad determinada por la calidad del equipo
        //
        double random = Math.random();
        //dice, si la probablidida extra que es el valor de la calidad del equipo es mayor que el resultado de random
        // le damos el valor de uno, si no le damos el valor de 0
        return random < (0.5 + probabilidadExtra) ? 1 : 0;
    }



}
