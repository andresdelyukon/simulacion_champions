import java.util.ArrayList;
import java.util.HashMap;

public class Torneo {
    private int id;
    private ArrayList<Equipo> equipos = new ArrayList<>();
    //debo tener un hashMap con las puntuaciones de los equipos
    private HashMap<String, Integer> tabla_posiciones = new HashMap<>();

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

    //necesito crear una lista a la que le vaya metiendo los equipos que yo quiera

    public void agregarEquipo(Equipo equipo) {
        if (!equipos.contains(equipo)) {
            equipos.add(equipo);
        }
    }

    public ArrayList<Equipo> obtenerListaEquipos() {
        return equipos; // Retornar la lista completa
    }

    //aquí no estoy seguro si voy a tener que llamar a este método cada vez que cree o quiera poner un equipo
    //lo otro que se me ocurre es ponerle como parámetro la lista de los equipos, Si necesito al objeto como parametro
    //para entrar a sus getters y setters
    public HashMap<String, Integer> iniciarTabla(ArrayList<Equipo> equipos) {
        HashMap<String, Integer> tabla = new HashMap<>();

        // Iterar sobre la lista de equipos y agregar cada uno al HashMap
        for (Equipo equipo : equipos) {
            tabla.put(equipo.getNombre(), equipo.getPuntos());
        }

        return tabla; // Devolver el HashMap con los equipos y sus puntos
    }


    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", equipos=" + equipos +
                ", tabla_posiciones=" + tabla_posiciones +
                '}';
    }

    //metodo para determinar al ganador de un juego y subir al equipo ganador y al perdedor a la tabla

    //aca hay que crear la lista de los equipos
}
