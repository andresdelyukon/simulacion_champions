import java.util.ArrayList;
import java.util.HashMap;

public class Torneo {
    private int id;
    private ArrayList<Equipo> equipos;
    //debo tener un hashMap con las puntuaciones de los equipos
    private HashMap<String, Integer> tabla_posiciones;

    public Torneo() {

    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public HashMap<String, Integer> getTabla_posiciones() {
        return tabla_posiciones;
    }

    public void setTabla_posiciones(HashMap<String, Integer> tabla_posiciones) {
        this.tabla_posiciones = tabla_posiciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //metodo para determinar al ganador de un juego y subir al equipo ganador y al perdedor a la tabla

    //aca hay que crear la lista de los equipos
}
