package com.alopez.appfacturas.modelo;

public class Cliente {

    private String nombre;
    private String identificacionTributaria;


    //Método Getter and Setter de nombre e Identificacion tributaria
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacionTributaria() {
        return identificacionTributaria;
    }
    public void setIdentificacionTributaria(String identificacionTributaria) {
        this.identificacionTributaria = identificacionTributaria;
    }
}