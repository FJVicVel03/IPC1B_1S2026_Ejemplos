package modelo;

import java.io.Serializable;

public class Inscripcion implements Serializable {
    private String nombre;
    private String codigo;
    private String fecha;

    public Inscripcion(String nombre, String codigo, String fecha) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}