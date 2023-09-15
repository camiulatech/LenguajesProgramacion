// 1. Realizar ejercicio para desplazar (SHIFT) una lista de elementos n posiciones a la 
// izquierda o la derecha según se indique por argumento. 
let desplazar direccion n lista =
    let longitud = List.length lista
    match direccion with
    | "izq" ->
        if n >= longitud then List.replicate longitud 0
        else
            let desplazada = List.append (List.skip n lista) (List.replicate n 0)
            List.take longitud desplazada
    | "der" ->
        if n >= longitud then List.replicate longitud 0
        else
            let desplazada = List.append (List.replicate n 0) (List.take (longitud - n) lista)
            List.take longitud desplazada
    | _ -> failwith "Dirección no válida"

printfn "Ejercicio 1"

let lista1 = [1; 2; 3; 4; 5]
let resultado1 = desplazar "izq" 3 lista1
let resultado2 = desplazar "der" 2 lista1
let resultado3 = desplazar "izq" 6 lista1

printfn "%A" resultado1
printfn "%A" resultado2
printfn "%A" resultado3

// 2. Haciendo uso de la función filter, implemente una función que, a partir de una lista de 
// cadenas de parámetro, filtre aquellas que contengan una subcadena que el usuario indique en 
// otro argumento. 

let contieneSubcadena (subcadena:string) (cadena:string) =
    cadena.Contains(subcadena)

let filtrarSubCadenas (subcadena:string) (lista:string list) =
    List.filter (fun cadena -> contieneSubcadena subcadena cadena) lista

printfn "\nEjercicio 2"

let listaCadenas = ["la casa"; "el perro"; "pintando la cerca"]
let subcadena = "la"
let resultado = filtrarSubCadenas subcadena listaCadenas

printfn "%A" resultado


// 3. Realizar una función que obtenga el n-esimo elemento de una lista pero utilizando
// solamente map (sin recursión). Tip: Utilizar lista de índices como segunda lista de 
// argumento para el map.

let n_esimo n lista =
    if n < 0 then None
    else
        let rec mapWithIndex f index list =
            match list with
            | [] -> []
            | x::xs -> (f index x)::(mapWithIndex f (index + 1) xs)
        
        let elementos = mapWithIndex (fun i elem -> if i = n then Some elem else None) 0 lista
        match List.choose id elementos with
        | [x] -> Some x
        | _ -> None

printfn "\nEjercicio 3"

let resultado4 = n_esimo 2 [1; 2; 3; 4; 5]
let resultado5 = n_esimo 3 [1; 2; 3; 4; 5]
let resultado6 = n_esimo 6 [1; 2; 3; 4; 5]

printfn "%A" resultado4
printfn "%A" resultado5
printfn "%A" resultado6

// 4. Modifique el ejercicio de búsqueda en profundidad visto en clase para ingresar pesos
// a los vértices. Implemente una función que encuentre el camino más corto en la búsqueda
// en profundidad basándose en la sumatoria de pesos. Implica cambiar la búsqueda en profundidad
// para que se lleven los pesos además de los vértices.

let grafoConPesos = [
    ("i", [("a", 3); ("b", 6)]);
    ("a", [("i", 3); ("c", 5); ("d", 6)]);
    ("b", [("i", 6); ("c", 2); ("d", 4)]);
    ("c", [("a", 5); ("b", 2); ("x", 1)]);
    ("d", [("a", 6); ("b", 4); ("f", 7)]);
    ("f", [("d", 7)]);
    ("x", [("c", 1)]);
]

let rec buscarNodo nodo lista =
    match lista with
    | [] -> None
    | (key, value) :: rest ->
        if key = nodo then Some (key, value)
        else buscarNodo nodo rest

let vecinosConPesos nodo grafo =
    match buscarNodo nodo grafo with
    | Some (_, neighbors) -> neighbors
    | None -> []

let extenderConPesos ruta grafo = 
    let nodoActual = fst (List.head ruta)
    let vecinos = vecinosConPesos nodoActual grafo
    let rutaSinRepetidos = List.filter (fun (vecino, _) -> not (List.exists (fun (nodo, _) -> nodo = vecino) ruta)) vecinos
    List.map (fun (vecino, peso) -> (vecino, peso + (snd (List.head ruta)))) rutaSinRepetidos

let rec profConPesos ini fin grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (fst (List.head ruta)) = fin then
            List.rev (List.map fst ruta)
        else
            let extensiones = extenderConPesos ruta grafo
            match extensiones with
            | [] -> prof_aux fin (ruta.Tail) grafo
            | _ ->
                let nueva_ruta = List.map (fun (vecino, peso) -> (vecino, peso + (snd (List.head ruta)))) extensiones
                prof_aux fin (nueva_ruta @ ruta) grafo
    prof_aux fin [(ini, 0)] grafo

printfn "\nEjercicio 4"

let caminoMasCorto = profConPesos "i" "x" grafoConPesos
printfn "Camino más corto: %A" caminoMasCorto

//5. Construya un programa que resuelva el problema de encontrar la o las rutas de un laberinto 
//con datos quemados. Dicho problema se puede resolver exactamente igual que un problema de grafos,
// entendiendo que cada casilla del laberinto puede verse como un “vecino” adjunto de otra, siempre
// que no haya pared

let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = nodo then neighbors
        else vecinos nodo rest

let bfsCaminoMasCorto inicio fin grafo =
    let rec bfsAux cola visitados =
        match cola with
        | [] -> [] // No se encontró un camino
        | (nodo, ruta) :: resto ->
            if nodo = fin then
                List.rev (fin :: ruta) // Se encontró un camino
            else
                let vecinosDelNodo = vecinos nodo grafo
                let nuevosVecinos =
                    List.filter (fun vecino -> not (List.contains vecino visitados)) vecinosDelNodo
                let nuevasRutas =
                    List.map (fun vecino -> (vecino, vecino :: ruta)) nuevosVecinos
                let nuevosVisitados = visitados @ nuevosVecinos
                bfsAux (resto @ nuevasRutas) nuevosVisitados
    let resultado = bfsAux [(inicio, [])] [inicio]
    match resultado with
    | [] -> None 
    | _ -> Some resultado 

let grafo5 =
    [("i", ["a"; "b"]);
     ("a", ["i"; "c"; "d"]);
     ("b", ["i"; "c"; "d"]);
     ("c", ["a"; "b"; "x"]);
     ("d", ["a"; "b"; "f"]);
     ("f", ["d"]);
     ("x", ["c"])]

let inicio = "i"
let fin = "f"

printfn "\nEjercicio 5"

match bfsCaminoMasCorto inicio fin grafo5 with
| None -> printfn "No se encontró un camino desde %s hasta %s." inicio fin
| Some camino -> printfn "Camino más corto desde %s hasta %s: %A" inicio fin camino

