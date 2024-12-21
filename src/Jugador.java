public class Jugador {
    private int ID;
    private String nombre;
    //el ranking nos va a indicar que tan bueno es el jugador
    private int ranking;
    private String tipo;

    private String equipo;

    //el parametro de tipo ya da la posicion


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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //segun esto el primero paso es hacer uso de la herencia


    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Jugador(int ID, String nombre, int ranking, String tipo, String equipo) {
        this.ID = ID;
        this.nombre = nombre;
        this.ranking = ranking;
        this.tipo = tipo;
        this.equipo = equipo;
    }
}
