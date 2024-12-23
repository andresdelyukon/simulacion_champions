import java.util.ArrayList;
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
    Delantero delantero_madrid = new Delantero(3, "Mbappe", 9, "delantero", "real_madrid");
    Delantero delantero_manchester = new Delantero(4, "Garnacho", 9, "delantero", "real_madrid");

    Equipo equipo1 = new Equipo(1, "barcelona", 10, 0, 0);
    Equipo equipo2 = new Equipo(2, "pumas", 8, 0, 0);
    Equipo equipo3 = new Equipo(3, "real_madrid", 10,0,0);
    Equipo equipo4 = new Equipo(4, "manchester_united", 9,0,0);

    //es en el método juego cuando las cosas hacen click. Es en este metodo donde se simula el juego.
    //osea que si quiero ver la tabla de posiciones tengo que ponerla aca
    //sabes no es perfecto pero ya me aburri, allí muere por el momento
    public void juego() {
        //repetimos el loop 10 veces
        torneo.agregarEquipo(equipo1);
        torneo.agregarEquipo(equipo2);
        torneo.agregarEquipo(equipo3);
        torneo.agregarEquipo(equipo4);
        ArrayList<Equipo> equiposParticipantes = torneo.obtenerListaEquipos();
        HashMap<String, Integer> tablaEquiposParticipantes = torneo.iniciarTabla(equiposParticipantes);
        for (int i = 0; i < 10; i++) {
            //en cada una de estas ocasiones determinamos si efectivamente el equipo trae chance de anotar
            //o si trae puro sueño
            delantero_barcelona.anotar(0.3); // 10% más probabilidad para Barcelona
            delantero_pumas.anotar(0.1);

            // 10% menos probabilidad para Pumas
            partido.sumar_marcador(delantero_barcelona, equipo1, 0.15);
            partido.sumar_marcador(delantero_pumas, equipo2,0.1);

        }

        String ganador = determinarGanador(partido.getMarcadorEquipo("barcelona"), partido.getMarcadorEquipo("pumas"));
        System.out.println(ganador);
        System.out.println(tablaEquiposParticipantes);
    }

    //pero en realidad si el objeto equipo ya trae los puntos pues no necesito sar el hashmap
    public String determinarGanador(HashMap<String, Integer> marcadorEquipoLocal, HashMap<String, Integer> marcadorEquipoVisita) {
        HashMap<String, Integer> tabla = torneo.getTabla_posiciones();
        String equipoLocal = marcadorEquipoLocal.keySet().stream().findFirst().orElse("Equipo Local");
        String equipoVisita = marcadorEquipoVisita.keySet().stream().findFirst().orElse("Equipo Visitante");

        int golesLocal = marcadorEquipoLocal.values().stream().findFirst().orElse(0);
        int golesVisita = marcadorEquipoVisita.values().stream().findFirst().orElse(0);



        if (golesLocal > golesVisita) {
            tabla.put(equipoLocal, tabla.getOrDefault(equipoLocal, 0) + 3); // Sumar 3 puntos
            return equipoLocal + " es el ganador con " + golesLocal + " goles";
        } else if (golesVisita > golesLocal) {
            tabla.put(equipoVisita, tabla.getOrDefault(equipoVisita, 0) + 3); // Sumar 3 puntos
            return equipoVisita + " es el ganador con " + golesVisita + " goles";
        } else {
            tabla.put(equipoLocal, tabla.getOrDefault(equipoLocal, 0) + 1); // Sumar 1 punto
            tabla.put(equipoVisita, tabla.getOrDefault(equipoVisita, 0) + 1); // Sumar 1 punto
            return "Es un empate, ambos equipos tienen " + golesLocal + " goles";
        }
    }
    //Quiero publicar la tabla simplemente, osea quiero escribirla en consola



    //es malo que me quede tanta cosa en Main pero así es la vida papito


}