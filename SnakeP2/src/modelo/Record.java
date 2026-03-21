package modelo;

/**
 * Representa un record simple de puntaje.
 */
public class Record {
    private final String nombre;
    private final int puntaje;
    private final String dificultad;
    private final String fecha;

    public Record(String nombre, int puntaje, String dificultad, String fecha) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.dificultad = dificultad;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getFecha() {
        return fecha;
    }

    public String toLine() {
        return nombre + ";" + puntaje + ";" + dificultad + ";" + fecha;
    }

    public static Record fromLine(String line) {
        String[] parts = line.split(";", -1);
        if (parts.length < 4) {
            return null;
        }
        try {
            int score = Integer.parseInt(parts[1]);
            return new Record(parts[0], score, parts[2], parts[3]);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
