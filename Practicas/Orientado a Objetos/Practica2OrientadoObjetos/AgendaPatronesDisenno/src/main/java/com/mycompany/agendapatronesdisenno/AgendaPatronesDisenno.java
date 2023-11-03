package com.mycompany.agendapatronesdisenno;

public class AgendaPatronesDisenno {

    public static void main(String[] args) {
        AgendaSingleton agenda = AgendaSingleton.obtenerInstancia();

        FabricaAbstracta fabrica = new FabricaConcreta();

        Contacto contactoEmpresarial1 = fabrica.crearContacto("Jorge Campos", "Belen, Heredia", "empresarial", "Gerente de Proyecto");
        Contacto contactoPersonal1 = fabrica.crearContacto("Gabriela Gonzales", "Escazu, San Jose", "personal", "Hermana");

        Evento eventoEmpresarial1 = fabrica.crearEvento("Conferencia", "10/28/2023", "empresarial", "Centro de Convenciones");
        Evento eventoPersonal1 = fabrica.crearEvento("Fiesta de Cumpleaños", "10/21/2023", "personal", "Celebración de cumpleaños en casa de Daniela");

        agenda.agregarElemento(contactoEmpresarial1);
        agenda.agregarElemento(contactoPersonal1);
        agenda.agregarElemento(eventoEmpresarial1);
        agenda.agregarElemento(eventoPersonal1);

        System.out.println("Agenda");
        System.out.println(agenda);


    }
}
