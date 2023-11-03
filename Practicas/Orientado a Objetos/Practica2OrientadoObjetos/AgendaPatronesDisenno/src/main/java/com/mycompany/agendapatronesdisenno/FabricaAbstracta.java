package com.mycompany.agendapatronesdisenno;


public abstract class FabricaAbstracta {
    public abstract Contacto crearContacto(String nombre, String direccion, String tipo, String puestoRelacion);
    public abstract Evento crearEvento(String nombre, String fecha, String tipo, String lugarDescripcion);
}



