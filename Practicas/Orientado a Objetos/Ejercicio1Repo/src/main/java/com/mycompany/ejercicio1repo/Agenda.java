package com.mycompany.ejercicio1repo;

import java.util.ArrayList;

class Agenda {
    private final ArrayList<Object> contactosYEventos;

    public Agenda() {
        contactosYEventos = new ArrayList<>();
    }

    public void agregarElemento(Object elemento) {
        contactosYEventos.add(elemento);
    }

    public void eliminarElemento(Object elemento) {
        contactosYEventos.remove(elemento);
    }

    public void modificarElemento(int indice, Object nuevoElemento) {
        contactosYEventos.set(indice, nuevoElemento);
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object objeto : contactosYEventos) {
            result.append(objeto.toString()).append("\n");
        }
        return result.toString();
    }
}