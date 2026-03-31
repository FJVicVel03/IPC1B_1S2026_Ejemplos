package modelo;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String codigo;
    protected String nombre;
    protected String password;

    public Usuario(String codigo, String nombre, String password){
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class Administrador extends Usuario{
        public Administrador(String codigo, String nombre, String password){
            super(codigo, nombre, password);
        }
    }

    //acá les toca a ustedes implementar Estudiante e Instructor (es casi lo mismo)
}
