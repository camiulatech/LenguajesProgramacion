% Camila Ulate Chaves 2022141633

% Ejercicio 1
sumlist([], 0).
sumlist([X|Resto], S) :-
    sumlist(Resto, SResto),
    S is X + SResto.
% para probarlo sumlist([1,2,3], 6).

% Ejercicio 2
subconj([], _).
subconj([X|S], S1) :-
    member(X, S1),
    subconj(S, S1).
subconj([_|S], S1) :-
    subconj(S, S1).
% para probarlo subconj([1,2,3,4],[2,3]).

% Ejercicio 3
aplanar([], []).
aplanar([X|Resto], L2) :-
    is_list(X),
    aplanar(X, SubLista),
    aplanar(Resto, RestoAplanado),
    append(SubLista, RestoAplanado, L2).
aplanar([X|Resto], [X|RestoAplanado]) :-
    not(is_list(X)),
    aplanar(Resto, RestoAplanado).
% para probarlo aplanar([1,[2,3],[4,5],[6]], [1,2,3,4,5,6]).

% Ejercicio 4
partir([], _, [], []).
partir([X|Resto], Umbral, [X|Menores], Mayores) :-
    X =< Umbral,
    partir(Resto, Umbral, Menores, Mayores).
partir([X|Resto], Umbral, Menores, [X|Mayores]) :-
    X > Umbral,
    partir(Resto, Umbral, Menores, Mayores).
% para probarlo partir([2, 7, 4, 8, 9, 1], 6, Menores, Mayores).

% Ejercicio 5
sub_cadenas(_, [], []).
sub_cadenas(Subcadena, [Cadena|Resto], Filtradas) :-
    sub_atom(Cadena, _, _, _, Subcadena),
    sub_cadenas(Subcadena, Resto, RestoFiltradas),
    Filtradas = [Cadena|RestoFiltradas].
sub_cadenas(Subcadena, [_|Resto], Filtradas) :-
    sub_cadenas(Subcadena, Resto, Filtradas).
% para probarlo sub_cadenas("la", ["la casa", "el perro", "pintando la cerca"], Filtradas).
