package com.mycompany.editorgrafico;


public class EditorGrafico {

    public static void main(String[] args) {
        Documento documento = new Documento();
        
        Hoja hoja1 = new Hoja();
        Hoja hoja2 = new Hoja();
        
        Circulo circulo1 = new Circulo(5);
        Circulo circulo2 = new Circulo(9);
        Linea linea1 = new Linea(6);
        Linea linea2 = new Linea(20);
        Rectangulo rectangulo1 = new Rectangulo(5,7);
        Texto texto1 = new Texto("Este es el texto 1");
        
        Grupo grupo1 = new Grupo();
        grupo1.agregarObjeto(circulo1);
        grupo1.agregarObjeto(linea1);
        
        hoja1.agregarObjeto(circulo2);
        hoja1.agregarObjeto(linea2);
        hoja2.agregarObjeto(grupo1);
        hoja2.agregarObjeto(rectangulo1);
        hoja2.agregarObjeto(texto1);
        
        documento.agregarHoja(hoja1);
        documento.agregarHoja(hoja2);

        documento.imprimirDocumento();

    }
}
