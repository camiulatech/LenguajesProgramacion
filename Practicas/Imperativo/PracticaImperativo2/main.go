package main

import (
	"fmt"
	"sort"
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}
type listaProductos []producto

func (l *listaProductos) Len() int {
	return len(lProductos)
}

func (l *listaProductos) Less(i int, j int) bool {
	return lProductos[i].cantidad < lProductos[j].cantidad
}

func (l *listaProductos) Swap(i int, j int) {
	lProductos[i], lProductos[j] = lProductos[j], lProductos[i]
}

var lProductos listaProductos

const existenciaMinima int = 10 //la existencia mínima es el número mínimo debajo de el cual se deben tomar eventuales desiciones

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	var prod = l.buscarProducto(nombre)
	if prod != -1 {
		(*l)[prod].cantidad = (*l)[prod].cantidad + cantidad
	}
	if prod == -1 {
		*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
	}
}

func (l *listaProductos) agregarProductos(productos ...producto) {
	for _, prod := range productos {
		l.agregarProducto(prod.nombre, prod.cantidad, prod.precio)
	}
}

func (l *listaProductos) buscarProducto(nombre string) int { //el retorno es el índice del producto encontrado y -1 si no existe
	var result = -1
	var i int
	for i = 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			result = i
		}
	}
	return result
}

func (l *listaProductos) buscarProducto2(nombre string) (*producto, int) { //el retorno es el índice del producto encontrado y -1 si no existe
	var err = -1
	var p *producto = nil
	var i int
	for i = 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			err = 0
			p = &(*l)[i]
		}
	}
	return p, err
}

func (l *listaProductos) venderProducto(nombre string, cantidad int) {
	var prod, err = l.buscarProducto2(nombre)
	var indice = l.buscarProducto(nombre)

	if err != -1 || (*prod).cantidad > cantidad {
		(*prod).cantidad -= cantidad
	}
	if err != -1 || (*prod).cantidad == cantidad {
		lProductos = append(lProductos[:indice], lProductos[indice+1:]...)
		//(*prod).cantidad -= cantidad
		fmt.Println("Se eliminara de la lista debido a que la cantidad del producto es 0")
	}
	if err != -1 || (*prod).cantidad < cantidad {
		fmt.Println("No se puede vender dicha cantidad ya que es mayor al inventario ")
	}
}

func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)
	lProductos.agregarProducto("maiz", 7, 3000)

}

func (l *listaProductos) listarProductosMínimos() listaProductos {
	newSlice := make(listaProductos, 0)
	for _, p := range *l {
		if p.cantidad <= existenciaMinima {
			newSlice = append(newSlice, p)
		}
	}
	return newSlice
}

func (l *listaProductos) aumentarInventarioDeMinimos(listaMinimos listaProductos) {
	var i = 0
	for i = 0; i < len(listaMinimos); i++ {
		cantidadFaltante := existenciaMinima - listaMinimos[i].cantidad
		if cantidadFaltante > 0 {
			listaMinimos[i].cantidad += cantidadFaltante
		}
	}
}

func main() {
	llenarDatos()

	// Prueba Venta de Productos
	//lProductos.venderProducto("arroz", 35)
	//lProductos.venderProducto("frijoles", 15)

	lProductos.agregarProducto("arroz", 20, 20)
	lProductos.agregarProducto("frijoles", 30, 20)
	fmt.Println(lProductos)

	pminimos := lProductos.listarProductosMínimos()
	fmt.Println(pminimos)
	lProductos.aumentarInventarioDeMinimos(pminimos)

	fmt.Println("Productos Minimos actualizados: ")
	fmt.Println(pminimos)

	fmt.Println("Productos Ordenados: ")
	sort.Sort(&lProductos)
	fmt.Println(lProductos)

}
