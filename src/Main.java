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
    Torneo torneo = new Torneo();

    Delantero delantero_pumas = new Delantero(1, "Palencia", 10, "delantero", "pumas");
    Delantero delantero_barcelona = new Delantero(2, "Lamine Yamal", 10, "delantero", "barcelona");

    Equipo equipo_local = new Equipo(1, "barcelona", 10, 0, 0);
    Equipo equipo_visita = new Equipo(2, "pumas", 10, 0, 0);

    public void juego() {
        //repetimos el loop 10 veces
        for (int i = 0; i < 10; i++) {
            //en cada una de estas ocasiones determinamos si efectivamente el equipo trae chance de anotar
            //o si trae puro sueño
            delantero_barcelona.anotar(0.3); // 10% más probabilidad para Barcelona
            delantero_pumas.anotar(0.1);   // 10% menos probabilidad para Pumas
            partido.sumar_marcador(delantero_barcelona, equipo_local, 0.15);
            partido.sumar_marcador(delantero_pumas, equipo_visita,0.1);
        }

        String ganador = determinarGanador(partido.getMarcadorEquipo("barcelona"), partido.getMarcadorEquipo("pumas"));
        System.out.println(ganador);
    }


    public String determinarGanador(HashMap<String, Integer> marcadorEquipoLocal, HashMap<String, Integer> marcadorEquipoVisita) {
        HashMap<String, Integer> tabla = torneo.getTabla_posiciones();
        String equipoLocal = marcadorEquipoLocal.keySet().stream().findFirst().orElse("Equipo Local");
        String equipoVisita = marcadorEquipoVisita.keySet().stream().findFirst().orElse("Equipo Visitante");


        int golesLocal = marcadorEquipoLocal.values().stream().findFirst().orElse(0);
        int golesVisita = marcadorEquipoVisita.values().stream().findFirst().orElse(0);


        // Comparar los goles
        if (golesLocal > golesVisita) {
            tabla.put(equipoLocal, 3);
            return equipoLocal + " es el ganador con " + golesLocal + " goles";
        } else if (golesVisita > golesLocal) {
            tabla.put(equipoVisita, 3);
            return equipoVisita + " es el ganador con " + golesVisita + " goles";
        } else {
            tabla.put(equipoLocal, 1);
            tabla.put(equipoVisita, 1);
            return "Es un empate, ambos equipos tienen " + golesLocal + " goles";
        }
    }

    //es malo que me quede tanta cosa en Main pero así es la vida papito
    

}