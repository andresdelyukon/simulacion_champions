import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        Main main = new Main();
        main.juego();
    }

    Partido partido = new Partido();

    Delantero delantero_pumas = new Delantero(1, "Palencia", 10, "delantero", "pumas");
    Delantero delantero_barcelona = new Delantero(2, "Lamine Yamal", 10, "delantero", "barcelona");

    Equipo equipo_local = new Equipo(1, "barcelona", 10, 0, 0);
    Equipo equipo_visita = new Equipo(2, "pumas", 10, 0, 0);

    public void juego() {
        for (int i = 0; i < 10; i++) {
            delantero_barcelona.anotar(0.1); // 10% más probabilidad para Barcelona
            delantero_pumas.anotar(0.1);   // 10% menos probabilidad para Pumas
            partido.sumar_marcador(delantero_barcelona, equipo_local, 0.15);
            partido.sumar_marcador(delantero_pumas, equipo_visita,0.1);
        }

        String ganador = determinarGanador(partido.getMarcadorEquipoLocal("barcelona"), partido.getMarcadorEquipoVisita("pumas"));
        System.out.println(ganador);
    }


    public String determinarGanador(HashMap<String, Integer> marcadorEquipoLocal, HashMap<String, Integer> marcadorEquipoVisita) {
        // Obtener los nombres y goles de los equipos
        String equipoLocal = marcadorEquipoLocal.keySet().stream().findFirst().orElse("Equipo Local");
        String equipoVisita = marcadorEquipoVisita.keySet().stream().findFirst().orElse("Equipo Visitante");

        int golesLocal = marcadorEquipoLocal.values().stream().findFirst().orElse(0);
        int golesVisita = marcadorEquipoVisita.values().stream().findFirst().orElse(0);

        // Comparar los goles
        if (golesLocal > golesVisita) {
            return equipoLocal + " es el ganador con " + golesLocal + " goles";
        } else if (golesVisita > golesLocal) {
            return equipoVisita + " es el ganador con " + golesVisita + " goles";
        } else {
            return "Es un empate, ambos equipos tienen " + golesLocal + " goles";
        }
    }

    //con un poco de trampa ya tengo la simulacion del partido. ahora falta asignar los puntos que el equipo ganador fue generando

    public void puntos(){

    }

    //falta la segunda parte del proyecto que es generar el torneo y no solo el partido 

    //falta tambien asignar que equipos componen el torneo

}