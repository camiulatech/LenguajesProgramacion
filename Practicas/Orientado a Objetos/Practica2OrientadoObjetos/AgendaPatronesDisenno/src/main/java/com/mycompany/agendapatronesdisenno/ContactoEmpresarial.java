package com.mycompany.agendapatronesdisenno;

class ContactoEmpresarial extends Contacto {
    private String puesto;

    public ContactoEmpresarial(String nombre, String direccion, String puesto) {
        super(nombre, direccion);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return super.toString() + ", Puesto: " + puesto;
    }
}

