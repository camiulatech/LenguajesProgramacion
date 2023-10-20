/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1repo;

/**
 *
 * @author camiu
 */
public class Ejercicio1Repo {

    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        Agenda agenda2 = new Agenda();

        ContactoEmpresarial contactoEmpresarial1 = new ContactoEmpresarial("Jorge Campos", "Belen, Heredia", "Proyect Manager");
        ContactoEmpresarial contactoEmpresarial2 = new ContactoEmpresarial("Karlinna Arce", "San Joaquin, Heredia", "Scrum Master");
        
        ContactoPersonal contactoPersonal1 = new ContactoPersonal("Gabriela Gonzales", "Escazu, San Jose", "Amiga");
        ContactoPersonal contactoPersonal2 = new ContactoPersonal("Santiago Mora", "Ceiba, Alajuela", "Hermano");
        
        EventoEmpresarial eventoEmpresarial1 = new EventoEmpresarial("Conferencia", "10/28/2023", "Centro de Convenciones");
        EventoEmpresarial eventoEmpresarial2 = new EventoEmpresarial("Reunion con el maneger", "11/01/2023", "Sala de Reuniones");
        
        EventoPersonal eventoPersonal1 = new EventoPersonal("Fiesta de Cumpleannos", "10/21/2023", "Celebracion cumplennos casa de Daniela");
        EventoPersonal eventoPersonal2 = new EventoPersonal("Cena con amigos", "11/10/2023", "Celebracion graduacion Jimena");
        
        agenda1.agregarElemento(contactoEmpresarial1);
        agenda1.agregarElemento(contactoPersonal2);
        agenda1.agregarElemento(eventoEmpresarial1);
        agenda1.agregarElemento(eventoPersonal1);
        
        agenda2.agregarElemento(contactoEmpresarial2);
        agenda2.agregarElemento(contactoPersonal1);
        agenda2.agregarElemento(eventoPersonal2);
        agenda2.agregarElemento(eventoEmpresarial2);

        System.out.println("Agenda 1:");
        System.out.println(agenda1);

        System.out.println("Agenda 2:");
        System.out.println(agenda2);

        // Modificar un contacto en la agenda 1
        ContactoPersonal nuevoContactoPersonal = new ContactoPersonal("Jose Solorzano", "La Trinidad, Alajuela", "Papa");
        agenda1.modificarElemento(0, nuevoContactoPersonal);

        // Eliminar un evento de la agenda 2
        agenda2.eliminarElemento(eventoPersonal2);

        // Agregar un nuevo evento a la agenda 1
        EventoEmpresarial nuevoEventoEmpresarial = new EventoEmpresarial("Seminario", "11/22/2023", "Hilton Garden");
        agenda1.agregarElemento(nuevoEventoEmpresarial);

        System.out.println("Agenda 1 (actualizada):");
        System.out.println(agenda1);
        
        System.out.println("Agenda 2 (actualizada):");
        System.out.println(agenda2);
    }
}
