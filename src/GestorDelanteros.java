import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class GestorDelanteros {
    private HashMap<String, List<Delantero>> mapaDelanteros;

    public GestorDelanteros() {
        this.mapaDelanteros = new HashMap<>();
    }

    // Método para agregar un delantero a un equipo
    public void agregarDelantero(Delantero delantero) {
        String equipo = delantero.getEquipo();
        if (!mapaDelanteros.containsKey(equipo)) {
            mapaDelanteros.put(equipo, new ArrayList<>());
        }
        List<Delantero> listaDelanteros = mapaDelanteros.get(equipo);
        if (!listaDelanteros.contains(delantero)) {
            listaDelanteros.add(delantero);
        }
    }

    // Obtener la lista de delanteros de un equipo
    public ArrayList<Delantero> obtenerTodosLosDelanteros() {
        ArrayList<Delantero> todosLosDelanteros = new ArrayList<>();
        for (List<Delantero> lista : mapaDelanteros.values()) {
            todosLosDelanteros.addAll(lista); // Agregar todos los delanteros de cada lista
        }
        return todosLosDelanteros;
    }


    // Imprimir delanteros por equipo
    public void mostrarDelanteros() {
        for (String equipo : mapaDelanteros.keySet()) {
            System.out.println("Equipo: " + equipo + ", Delanteros: " + mapaDelanteros.get(equipo));
        }
    }
}

