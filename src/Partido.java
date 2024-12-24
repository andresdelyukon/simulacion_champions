import java.util.HashMap;

public class Partido {
    private Delantero delanteroLocal;
    private Delantero delanteroVisitante;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
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

        //es el método mas largo y que mas se le ocurrió al chatGPT
        //si el objeto delantero y el objeto equipo es nulo lanzas una advertencia
        if (delantero == null || equipo == null) {
            throw new IllegalArgumentException("Delantero o equipo no pueden ser nulos.");
        }

        //equipo actual se supone que es el equipo del delantero
        String equipo_actual = delantero.getEquipo();
        if (equipo_actual == null) {
            throw new IllegalArgumentException("El equipo del delantero no puede ser nulo.");
        }
        //sacas con la función mágica llave equipo actual y el valor de los goles que lleva
        //me confundía de donde sacaba el hashMap marcador pero es una variable de clase
        //ya trae un constructor el cual inicia un hashMap
        int goles_anteriores = marcador.getOrDefault(equipo_actual, 0); // Obtener goles previos del equipo
        //aca llama al método anotar con la probabilidad que llenamos al momento de hacer la funcion
        //si la probabilidad es igual a 1 sumas un gol, si no, no sumas nada
        int goles_actuales = delantero.anotar(probabilidadExtra) == 1 ? goles_anteriores + 1 : goles_anteriores;

        //ya finalmente actualizas los valores de marcador.
        marcador.put(equipo_actual, goles_actuales); // Actualizar marcador

        return marcador;
    }

    //estoy seguro que estos métodos se pueden combinar para no repetir codigo a lo wey
    // Método para obtener el marcador del equipo local
    public HashMap<String, Integer> getMarcadorEquipo(String nombreEquipo) {
        //inicias el HashMap
        HashMap<String, Integer> marcadorLocal = new HashMap<>();
        //le pones al HashMap el nombre del equipoLocal y el marcador usando la funcion getOrDefault
        marcadorLocal.put(nombreEquipo, marcador.getOrDefault(nombreEquipo, 0));
        return marcadorLocal;
    }

    //jaja me salen puros empates pero ya va andando este pedo

    public void simulacionJuego(double probabilidadAnotar1, double probabilidadAnotar2) {
        for (int i = 0; i < 10; i++) {
            delanteroLocal.anotar(probabilidadAnotar1);
            delanteroVisitante.anotar(probabilidadAnotar2);
            sumar_marcador(delanteroLocal, equipoLocal, probabilidadAnotar1);
            sumar_marcador(delanteroVisitante, equipoVisitante, probabilidadAnotar2);
        }
    }

    public Delantero getDelanteroLocal() {
        return delanteroLocal;
    }

    public void setDelanteroLocal(Delantero delanteroLocal) {
        this.delanteroLocal = delanteroLocal;
    }

    public Delantero getDelanteroVisitante() {
        return delanteroVisitante;
    }

    public void setDelanteroVisitante(Delantero delanteroVisitante) {
        this.delanteroVisitante = delanteroVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
}

