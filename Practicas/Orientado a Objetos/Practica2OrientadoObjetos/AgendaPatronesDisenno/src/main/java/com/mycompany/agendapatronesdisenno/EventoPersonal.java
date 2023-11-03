package com.mycompany.agendapatronesdisenno;

class EventoPersonal extends Evento {
    private String descripcion;

    public EventoPersonal(String nombreEvento, String fecha, String descripcion) {
        super(nombreEvento, fecha);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Descripción: " + descripcion;
    }
}