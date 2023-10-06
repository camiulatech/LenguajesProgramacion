% Ejercicio 1 Practica 2
% Camila Ulate Chaves 2022141633

conectado(i, a, 50).
conectado(i, b, 20).
conectado(a, b, 10).
conectado(a, c, 30).
conectado(b, f, 40).
conectado(b, c, 5).
conectado(c, f, 15).

ruta(Inicio, Fin, Ruta, Peso) :- ruta2(Inicio, Fin, [], Ruta, 0, Peso).

ruta2(Fin, Fin, _, [Fin], Peso, Peso).

ruta2(Inicio, Fin, Visitados, [Inicio | Resto], PesoActual, PesoTotal) :-
    conectado(Inicio, Alguien, Peso),
    not(member(Alguien, Visitados)),
    NuevoPesoActual is PesoActual + Peso,
    ruta2(Alguien, Fin, [Inicio | Visitados], Resto, NuevoPesoActual, PesoTotal).

% Encontrar la menor ruta
ruta_menor_peso(Inicio, Fin, Ruta, Peso) :-
    findall([R, P], ruta(Inicio, Fin, R, P), Rutas),
    min_peso(Rutas, [Ruta, Peso]).

min_peso([[Ruta, Peso]], [Ruta, Peso]).
min_peso([[R1, P1] | Resto], [R2, P2]) :-
    min_peso(Resto, [R2, P2]),
    P1 >= P2.
min_peso([[R1, P1] | Resto], [R1, P1]) :-
    min_peso(Resto, [_, P2]),
    P1 < P2.

%Ejemplos para probar el codigo
%ruta_menor_peso(i,f,Ruta,Peso).



