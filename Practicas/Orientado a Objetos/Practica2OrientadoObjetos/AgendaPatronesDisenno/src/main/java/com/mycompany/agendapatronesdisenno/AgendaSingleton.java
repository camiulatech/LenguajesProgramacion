package com.mycompany.agendapatronesdisenno;

import java.util.ArrayList;

// Singleton

/*
Eager Singleton crea la instancia de inmediato aunque esta no se vaya a utilizar, 
esto facilita una implementacion mas sencilla para los procesos ya que se garantiza
desde el inicio su existencia.

Lazy Singleton solo se crea la instancia cuando se necesita, esto puede ser mas eficiente
ya que si no se utiliza se ahorra la inicializacion. Esta requiere una implementacion 
adicional para garantizar la seguridad relacionada a los procesos.

En este caso la que se considera mejor y la que se implemento es Lazy Singleton ya que 
solamente se crea cuando es necesaria y siempre se hace una validacion de su existencia
antes de usar los procesos.
*/
public class AgendaSingleton {
    private static AgendaSingleton instanciaUnica;
    private final ArrayList<Object> contactosYEventos;

    private AgendaSingleton() {
        contactosYEventos = new ArrayList<>();
    }

    public static AgendaSingleton obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new AgendaSingleton();
        }
        return instanciaUnica;
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
