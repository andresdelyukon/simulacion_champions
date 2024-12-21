import java.util.HashMap;

public class Partido {
    private int id;
    private String ganador;
    private HashMap<String, Integer> marcador;

    // Constructor
    public Partido() {
        this.marcador = new HashMap<>();
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public HashMap<String, Integer> getMarcador() {
        return marcador;
    }

    public void setMarcador(HashMap<String, Integer> marcador) {
        this.marcador = marcador;
    }

    // Método sumar_marcador
    public HashMap<String, Integer> sumar_marcador(Delantero delantero, Equipo equipo, double probabilidadExtra) {

        if (delantero == null || equipo == null) {
            throw new IllegalArgumentException("Delantero o equipo no pueden ser nulos.");
        }

        String equipo_actual = delantero.getEquipo();
        if (equipo_actual == null) {
            throw new IllegalArgumentException("El equipo del delantero no puede ser nulo.");
        }

        int goles_anteriores = marcador.getOrDefault(equipo_actual, 0); // Obtener goles previos del equipo
        int goles_actuales = delantero.anotar(probabilidadExtra) == 1 ? goles_anteriores + 1 : goles_anteriores;

        marcador.put(equipo_actual, goles_actuales); // Actualizar marcador

        return marcador;
    }

    // Método para obtener el marcador del equipo local
    public HashMap<String, Integer> getMarcadorEquipoLocal(String nombreEquipoLocal) {
        HashMap<String, Integer> marcadorLocal = new HashMap<>();
        marcadorLocal.put(nombreEquipoLocal, marcador.getOrDefault(nombreEquipoLocal, 0));
        return marcadorLocal;
    }

    // Método para obtener el marcador del equipo visitante
    public HashMap<String, Integer> getMarcadorEquipoVisita(String nombreEquipoVisita) {
        HashMap<String, Integer> marcadorVisita = new HashMap<>();
        marcadorVisita.put(nombreEquipoVisita, marcador.getOrDefault(nombreEquipoVisita, 0));
        return marcadorVisita;
    }

    //jaja me salen puros empates pero ya va andando este pedo 
}

