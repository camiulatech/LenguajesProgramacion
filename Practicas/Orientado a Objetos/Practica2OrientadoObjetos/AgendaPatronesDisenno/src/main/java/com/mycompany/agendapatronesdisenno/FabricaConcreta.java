package com.mycompany.agendapatronesdisenno;


public class FabricaConcreta extends FabricaAbstracta {
    @Override
    public Contacto crearContacto(String nombre, String direccion, String tipo, String puestoRelacion) {
        if (tipo.equalsIgnoreCase("empresarial")) {
            return new ContactoEmpresarial(nombre, direccion, puestoRelacion);
        } else if (tipo.equalsIgnoreCase("personal")) {
            return new ContactoPersonal(nombre, direccion, puestoRelacion);
        }
        return null;
    }

    @Override
    public Evento crearEvento(String nombre, String fecha, String tipo, String lugarDescripcion) {
        if (tipo.equalsIgnoreCase("empresarial")) {
            return new EventoEmpresarial(nombre, fecha, lugarDescripcion);
        } else if (tipo.equalsIgnoreCase("personal")) {
            return new EventoPersonal(nombre, fecha, lugarDescripcion);
        }
        return null;
    }

}

