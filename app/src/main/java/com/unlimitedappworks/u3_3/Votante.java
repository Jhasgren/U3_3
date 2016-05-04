package com.unlimitedappworks.u3_3;

/**
 * Created by Luis Fernando on 04/05/2016.
 */
public class Votante {
    private String ife, nombre, direccion_de_voto;
    private int num_casilla;

    public Votante(String ife, String nombre, String direccion_de_voto, int num_casilla) {
        this.ife = ife;
        this.nombre = nombre;
        this.direccion_de_voto = direccion_de_voto;
        this.num_casilla = num_casilla;
    }

    public String getIfe() {
        return ife;
    }

    public void setIfe(String ife) {
        this.ife = ife;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion_de_voto() {
        return direccion_de_voto;
    }

    public void setDireccion_de_voto(String direccion_de_voto) {
        this.direccion_de_voto = direccion_de_voto;
    }

    public int getNum_casilla() {
        return num_casilla;
    }

    public void setNum_casilla(int num_casilla) {
        this.num_casilla = num_casilla;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
