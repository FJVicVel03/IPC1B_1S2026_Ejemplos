/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Fernando Vicente
 */
public class MenuDatos {
    private String dificultad;
    private int celdas;
    private String velocidadTexto;
    private int velocidadMs;

    public MenuDatos(String dificultad, int celdas, String velocidadTexto, int velocidadMs) {
        this.dificultad = dificultad;
        this.celdas = celdas;
        this.velocidadTexto = velocidadTexto;
        this.velocidadMs = velocidadMs;
    }

    public MenuDatos() {
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getCeldas() {
        return celdas;
    }

    public void setCeldas(int celdas) {
        this.celdas = celdas;
    }

    public String getVelocidadTexto() {
        return velocidadTexto;
    }

    public void setVelocidadTexto(String velocidadTexto) {
        this.velocidadTexto = velocidadTexto;
    }

    public int getVelocidadMs() {
        return velocidadMs;
    }

    public void setVelocidadMs(int velocidadMs) {
        this.velocidadMs = velocidadMs;
    }
}
