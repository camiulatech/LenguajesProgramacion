package main

import (
	"fmt"
	"strings"
)

// Ejercicio 1
func Contador(texto string) {
	cantidadCaracteres := len(texto)
	cantidadPalabras := contarPalabras(texto)
	cantidadLineas := strings.Count(texto, "\n") + 1

	fmt.Printf("Cantidad de Caracteres: %d\n", cantidadCaracteres)
	fmt.Printf("Cantidad de Palabras: %d\n", cantidadPalabras)
	fmt.Printf("Cantidad de Lineas: %d \n", cantidadLineas)
}

func contarPalabras(texto string) int {
	palabras := strings.Fields(texto)
	return len(palabras)
}

// Ejercicio 2
func ImpresionFigura(cantidad int) {
	if cantidad%2 != 0 {
		var contador = 1
		for contador < cantidad+1 {
			espacios := (cantidad - contador) / 2
			ImpresionFiguraAux(espacios, contador)
			fmt.Println("")
			contador += 2
		}
		var contador2 = 1
		contador2 = cantidad - 2
		for contador2 > 0 {
			espacios := (cantidad - contador2) / 2
			ImpresionFiguraAux(espacios, contador2)
			fmt.Println("")
			contador2 -= 2
		}
	}
}

func ImpresionFiguraAux(espacios int, contador int) {
	for espaciosC := 0; espaciosC < espacios; espaciosC++ {
		fmt.Print(" ")
	}
	for contadorC := 0; contadorC < contador; contadorC++ {
		fmt.Print("*")
	}
	for espaciosC := 0; espaciosC < espacios; espaciosC++ {
		fmt.Print(" ")
	}
}

// Ejercicio 3
func Rotaciones(arreglo []string, rotaciones []int, direccion []int) {
	fmt.Println("Secuencia inicial: ", arreglo)
	var i = 0
	for i = 0; i < len(rotaciones); i++ {
		if direccion[i] == 0 { // rotaciones a la izquierda
			var limite = rotaciones[i]
			var j = 0
			for j = 0; j < limite; j++ {
				primerElemento := arreglo[0]
				arreglo = append(arreglo[1:], primerElemento)
			}
			fmt.Println("Cantidad de rotaciones = ", rotaciones[i])
			fmt.Println("Direccion = izquierda")
			fmt.Println("Secuencia = ", arreglo)

		}
		if direccion[i] == 1 { // rotaciones a la derecha
			var limite = rotaciones[i]
			var k = 0
			for k = 0; k < limite; k++ {
				ultimoElemento := arreglo[len(arreglo)-1]
				arreglo = append([]string{ultimoElemento}, arreglo[:len(arreglo)-1]...)
			}
			fmt.Println("Cantidad de rotaciones = ", rotaciones[i])
			fmt.Println("Direccion = derecha")
			fmt.Println("Secuencia = ", arreglo)
		}
	}
}

// Ejercicio 4

type Calzado struct {
	marca  string
	talla  int
	precio int
}

type ListaCalzados []Calzado

var lCalzados ListaCalzados

func (l *ListaCalzados) buscarCalzado(marca string, talla int) (int, int) {
	var result = -1
	var tallaBuscador = -1
	var i int = 0
	for i = 0; i < len(*l); i++ {
		if (*l)[i].marca == marca || (*l)[i].talla == talla {
			result = i
			tallaBuscador = talla
		}
	}
	return result, tallaBuscador
}

func (l *ListaCalzados) venderCalzado(marca string, talla int, cantidad int) {
	var i int
	var contador = 0
	for i = 0; i < cantidad; i++ {
		var indice, tallaVendedor = l.buscarCalzado(marca, talla)
		if indice != -1 || tallaVendedor == talla {
			lCalzados = append(lCalzados[:indice], lCalzados[indice+1:]...)
			contador++
		}
	}
	fmt.Printf("De la cantidad %d solicitada, hay inventario para la venta de %d pares de calzado", cantidad, contador)
	fmt.Println(" ")
}

func (l *ListaCalzados) agregarCalzado(marca string, talla int, precio int) {
	*l = append(*l, Calzado{marca: marca, talla: talla, precio: precio})
}

func llenarDatos() {
	lCalzados.agregarCalzado("Nike", 34, 45000)
	lCalzados.agregarCalzado("Nike", 40, 45000)
	lCalzados.agregarCalzado("Sperry", 36, 70000)
	lCalzados.agregarCalzado("Converse", 42, 50000)
	lCalzados.agregarCalzado("Converse", 38, 50000)
	lCalzados.agregarCalzado("Converse", 38, 50000)
	lCalzados.agregarCalzado("Vans", 34, 38000)
}

func main() {

	// Ejercicio 1
	fmt.Println("Ejercicio 1")
	texto := "En el siguiente ejercicio se van a contar la cantidad de palabras, caracteres y lineas de este texto"
	fmt.Println(texto)
	Contador(texto)
	fmt.Println(" ")

	// Ejercicio 2
	fmt.Println("Ejercicio 2")
	ImpresionFigura(5)
	ImpresionFigura(9)
	fmt.Println(" ")

	// Ejercicio 3
	fmt.Println("Ejercicio 3")
	var arreglo [5]string
	arreglo[0] = "a"
	arreglo[1] = "b"
	arreglo[2] = "c"
	arreglo[3] = "d"
	arreglo[4] = "e"
	rotaciones := []int{3, 2}
	direccion := []int{0, 1}
	Rotaciones(arreglo[:], rotaciones, direccion)
	fmt.Println(" ")

	// Ejercicio 4
	fmt.Println("Ejercicio 4")
	llenarDatos()
	fmt.Println(lCalzados)
	lCalzados.venderCalzado("Converse", 38, 2)
	lCalzados.venderCalzado("Sperry", 50, 3)
	fmt.Println(lCalzados)
	fmt.Println(" ")
}
