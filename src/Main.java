import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        Main main = new Main();
        main.juego();
    }

    Partido partido = new Partido();
    Torneo torneo = new Torneo();
    GestorDelanteros gestor = new GestorDelanteros();

    Delantero delantero_pumas = new Delantero(1, "Palencia", 5, "delantero", "pumas");
    Delantero delantero_barcelona = new Delantero(2, "Lamine Yamal", 10, "delantero", "barcelona");
    Delantero delantero_madrid = new Delantero(3, "Mbappe", 9, "delantero", "real_madrid");
    Delantero delantero_manchester = new Delantero(4, "Garnacho", 8, "delantero", "manchester_united");



    Equipo equipo1 = new Equipo(1, "barcelona", 10, 0, 0);
    Equipo equipo2 = new Equipo(2, "pumas", 8, 0, 0);
    Equipo equipo3 = new Equipo(3, "real_madrid", 10,0,0);
    Equipo equipo4 = new Equipo(4, "manchester_united", 9,0,0);



    //es en el método juego cuando las cosas hacen click. Es en este metodo donde se simula el juego.
    //osea que si quiero ver la tabla de posiciones tengo que ponerla aca
    //sabes no es perfecto pero ya me aburri, allí muere por el momento
    public void juego() {
        // Repetimos el loop 10 veces
        torneo.agregarEquipo(equipo1);
        torneo.agregarEquipo(equipo2);
        torneo.agregarEquipo(equipo3);
        torneo.agregarEquipo(equipo4);

        // Agregar delanteros
        gestor.agregarDelantero(delantero_pumas);
        gestor.agregarDelantero(delantero_barcelona);
        gestor.agregarDelantero(delantero_madrid);
        gestor.agregarDelantero(delantero_manchester);

        ArrayList<Equipo> equiposParticipantes = torneo.obtenerListaEquipos();
        ArrayList<Delantero> delanterosParticipantes = gestor.obtenerTodosLosDelanteros();

        // Inicializamos la tabla de posiciones con los equipos y 0 puntos
        HashMap<String, Integer> tablaEquiposParticipantes = torneo.iniciarTabla(equiposParticipantes);

        // Iteramos sobre todos los posibles enfrentamientos entre equipos
        for (int i = 0; i < equiposParticipantes.size(); i++) {
            for (int j = i + 1; j < equiposParticipantes.size(); j++) {
                Equipo equipoLocal = equiposParticipantes.get(i);
                Equipo equipoVisitante = equiposParticipantes.get(j);

                // Filtramos los delanteros correspondientes para cada equipo
                Delantero delanteroLocal = obtenerDelanteroPorEquipo(delanterosParticipantes, equipoLocal);
                Delantero delanteroVisitante = obtenerDelanteroPorEquipo(delanterosParticipantes, equipoVisitante);

                // Simulamos el partido entre los dos equipos
                String resultado = simularPartido(delanteroLocal, delanteroVisitante, equipoLocal, equipoVisitante);

                // Determinamos al ganador y sumamos los puntos


                if (resultado.startsWith(equipoLocal.getNombre())) {
                    int puntosActualesLocal = tablaEquiposParticipantes.get(equipoLocal.getNombre()) + 3;
                    tablaEquiposParticipantes.put(equipoLocal.getNombre(), puntosActualesLocal);
                } else if (resultado.startsWith((equipoVisitante.getNombre()))) {
                    int puntosActualesVisita = tablaEquiposParticipantes.get(equipoVisitante.getNombre()) + 3;
                    tablaEquiposParticipantes.put(equipoVisitante.getNombre(), puntosActualesVisita);
                } else if(resultado.contains("Empate")) {
                    // Empate: sumamos 1 punto a ambos equipos
                    int puntosActualesLocal = tablaEquiposParticipantes.get(equipoLocal.getNombre()) + 1;
                    int puntosActualesVisita = tablaEquiposParticipantes.get(equipoVisitante.getNombre()) + 1;
                    tablaEquiposParticipantes.put(equipoLocal.getNombre(),  puntosActualesLocal);
                    tablaEquiposParticipantes.put(equipoVisitante.getNombre(),  puntosActualesVisita);
                }

                // Imprimimos el resultado del partido
                System.out.println(resultado);
            }
        }

        // Mostrar la tabla de posiciones final
        System.out.println("Tabla de posiciones:");
        for (Map.Entry<String, Integer> entry : tablaEquiposParticipantes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " puntos");
        }

        //registrar al ganador. Es un for loop que busca en los valores y devuelve el mayor
        int n = 0;
        for (int i : tablaEquiposParticipantes.values()){
            if(i > n){
                n = i;
            }

        }
        //nomas me falta sacar la llave asociada al valor. Se ocupa otro loop

        for (String k : tablaEquiposParticipantes.keySet()){
            //get se usa en los hashMap para acceder al valor asociado a una clave
            if(tablaEquiposParticipantes.get(k) == n){
                System.out.println("El equipo ganador es " + k + " con "+ n + " puntos");
            }
        }

    }


    public String simularPartido(Delantero delanteroLocal, Delantero delanteroVisitante, Equipo equipoLocal, Equipo equipoVisitante) {
        if (delanteroLocal == null || delanteroVisitante == null) {
            return "Error: uno de los delanteros es null.";
        }

        HashMap<String, Integer> tabla = torneo.getTabla_posiciones();
        Partido partido = new Partido();

        //hay una forma más fácil. usar un random
        double probabilidadLocal = 0.2; // Probabilidad aleatoria para el delantero local
        double probabilidadVisitante = 0.6; // Probabilidad aleatoria para el delantero visitante
        

        // Anotación de goles
        delanteroLocal.anotar(probabilidadLocal);
        delanteroVisitante.anotar(probabilidadVisitante);

        // Sumamos el marcador
        partido.sumar_marcador(delanteroLocal, equipoLocal, probabilidadLocal);
        partido.sumar_marcador(delanteroVisitante, equipoVisitante, probabilidadVisitante);

        // Determinamos el ganador
        int golesLocal = partido.getMarcadorEquipo(equipoLocal.getNombre()).get(equipoLocal.getNombre());
        int golesVisitante = partido.getMarcadorEquipo(equipoVisitante.getNombre()).get(equipoVisitante.getNombre());

        if (golesLocal > golesVisitante) {
            tabla.put(String.valueOf(equipoLocal), tabla.getOrDefault(equipoLocal, 0) + 3);
            return equipoLocal.getNombre() + " gana con " + golesLocal + " goles";

        } else if (golesVisitante > golesLocal) {
            tabla.put(String.valueOf(equipoVisitante), tabla.getOrDefault(equipoVisitante, 0) + 3);
            return equipoVisitante.getNombre() + " gana con " + golesVisitante + " goles";
        } else {
            tabla.put(String.valueOf(equipoLocal), tabla.getOrDefault(equipoLocal, 0) + 1); // Sumar 1 punto
            tabla.put(String.valueOf(equipoVisitante), tabla.getOrDefault(equipoVisitante, 0) + 1);
            return "Empate entre " + equipoLocal.getNombre() + " y " + equipoVisitante.getNombre() + " con " + golesLocal + " goles";
        }
    }


    public Delantero obtenerDelanteroPorEquipo(ArrayList<Delantero> delanteros, Equipo equipo) {
        for (Delantero delantero : delanteros) {
            if (delantero.getEquipo().equals(equipo.getNombre())) {
                return delantero;
            }
        }
        throw new IllegalArgumentException("No se encontró delantero para el equipo " + equipo.getNombre());
    }



    //pero en realidad si el objeto equipo ya trae los puntos pues no necesito sar el hashmap
    public String determinarGanador(HashMap<String, Integer> marcadorEquipoLocal, HashMap<String, Integer> marcadorEquipoVisita) {
        HashMap<String, Integer> tabla = torneo.getTabla_posiciones();
        String equipoLocal = marcadorEquipoLocal.keySet().iterator().next();
        String equipoVisita = marcadorEquipoVisita.keySet().iterator().next();

        int golesLocal = marcadorEquipoLocal.get(equipoLocal);
        int golesVisita = marcadorEquipoVisita.get(equipoVisita);


        if (golesLocal > golesVisita) {
            tabla.put(equipoLocal, tabla.getOrDefault(equipoLocal, 0) + 3); // Sumar 3 puntos
            return equipoLocal + " es el ganador con " + golesLocal + " goles ";
        } else if (golesVisita > golesLocal) {
            tabla.put(equipoVisita, tabla.getOrDefault(equipoVisita, 0) + 3); // Sumar 3 puntos
            return equipoVisita + " es el ganador con " + golesVisita + " goles ";
        } else {
            tabla.put(equipoLocal, tabla.getOrDefault(equipoLocal, 0) + 1); // Sumar 1 punto
            tabla.put(equipoVisita, tabla.getOrDefault(equipoVisita, 0) + 1); // Sumar 1 punto
            return "Es un empate, ambos equipos tienen " + golesLocal + " goles ";
        }
    }
    //Quiero publicar la tabla simplemente, osea quiero escribirla en consola



    //es malo que me quede tanta cosa en Main pero así es la vida papito


}