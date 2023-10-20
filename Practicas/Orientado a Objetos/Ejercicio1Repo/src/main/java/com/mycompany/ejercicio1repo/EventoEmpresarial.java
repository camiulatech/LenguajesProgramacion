package com.mycompany.ejercicio1repo;

class EventoEmpresarial extends Evento {
    private String lugar;

    public EventoEmpresarial(String nombreEvento, String fecha, String lugar) {
        super(nombreEvento, fecha);
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lugar: " + lugar;
    }
}