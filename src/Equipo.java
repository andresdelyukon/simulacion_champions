import java.util.ArrayList;
import java.util.HashMap;

public class Equipo {
    private int ID;
    private String nombre;
    //el rango debe ser la suma de las capacidades individuales de los jugadores
    //tengo que crear un metodo que sume los rankings de los jugadores
    private int ranking;
    //Se tiene que poner en el marcador los goles que el equipo vaya marcando solamente.
    private int goles_favor = 0;
    private int goles_contra = 0;

    private ArrayList<Jugador> jugador;

    //ocupo un metodo para meter 11 jugadores


    public Equipo(int ID, String nombre, int ranking, int goles_favor, int goles_contra) {
        this.ID = ID;
        this.nombre = nombre;
        this.ranking = ranking;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public ArrayList<Jugador> getJugador() {
        return jugador;
    }

    public void setJugador(ArrayList<Jugador> jugador) {
        this.jugador = jugador;
    }

    public int getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(int goles_favor) {
        this.goles_favor = goles_favor;
    }

    public int getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(int goles_contra) {
        this.goles_contra = goles_contra;
    }

    //tiene que haber tambien un metodo para ir poniendo jugadores
    //En la misma clase de jugador debe existir un parametro de posicion

    public ArrayList<Jugador> armarEquipo(Jugador jugador){
        ArrayList<Jugador> equipo = new ArrayList<>();
        int n = 0;
        while (n < 11){
            equipo.add(jugador);
            n = n + 1;
        }
        return equipo;
    }

    //necesito un metodo para sumar puntos ganados y puntos perdidos
    public int puntos(){
        if (goles_favor == goles_contra){
            return 1;
        } else if (goles_favor > goles_contra) {
            return 3;
        }
        return 0;
    }
    //una forma sencilla de usar el ranking es


}
