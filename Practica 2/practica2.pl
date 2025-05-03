
main:-nl,cls,
write('a: '),read(A),
write('b: '),read(B),
write('c: '),read(C),
formula_general(A,B,C).



formula_general(A,B,C):-
D is (B*B-4*A*C),
   ((D<0;A=0,write('El sistema no tiene solucion real'));
   ((D>=0,A\=0),raiz(D,R),
    X1 is (-B+R)/(2*A),
    X2 is (-B-R)/(2*A),
    format('\nX1: ~g',X1),
   format('\nX2: ~g',X2))).


raiz(X,R):-sqrt(X,R).
