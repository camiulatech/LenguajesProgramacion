% Ejercicio 2 Practica 2
% Camila Ulate Chaves 2022141633

persona('Sheldon','Cooper', [0,1,1,0,0,1,0,0,1,1]).
persona('Leonard','Hofstader', [1,1,0,0,0,0,0,0,0,0]).
persona('Howard','Wolowitz', [1,0,0,1,1,0,1,1,0,0]).
persona('Rajesh','Koothrappali', [1,0,1,1,0,0,1,0,0,1]).
persona('Amy','Farrah', [1,0,1,1,1,1,0,0,0,0]).
persona('Penny','Hofstader', [0,1,0,0,0,1,0,0,0,0]).
persona('Claire','Dunphy', [0,0,1,1,0,0,1,0,0,1]).
persona('Jay','Pritchett', [0,1,0,1,1,0,1,0,1,0]).
persona('Gloria','Delgado', [1,1,0,0,1,0,1,1,1,1]).
persona('Andy','Bailey', [1,0,1,0,0,0,0,1,1,0]).

% Recibe lista de cromosomas e indica cual es la persona con mayor
% similitud
persona_mas_similar(Cromosomas, Nombre, Apellido, Similitud) :-
    persona(Nombre, Apellido, Caracteristicas),
    calcular_similitud(Cromosomas, Caracteristicas, Similitud),
    \+ (persona(_, _, OtrasCaracteristicas), calcular_similitud(Cromosomas, OtrasCaracteristicas, OtraSimilitud), OtraSimilitud > Similitud).


% Calcular similitud
calcular_similitud([], [], 0).
calcular_similitud([X|Resto1], [Y|Resto2], Similitud) :-
    calcular_similitud(Resto1, Resto2, SimilitudResto),
    Similitud is SimilitudResto + (X * Y).

%Ejemplo para probar el codigo
%persona_mas_similar([1,0,0,0,1,0,0,1,0,1], Nombre, Apellido, Similitud). como modifico este codigo para que no devuelva la similut cuando uso persona_mas_similar
