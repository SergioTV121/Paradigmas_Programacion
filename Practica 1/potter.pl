%Alumno Tinoco Videgaray Sergio
%Grupo 3BV1
%Fecha 07/09/21

hombre(harry).
hombre(james_potter).
hombre(arthur_weasley).
hombre(fred).
hombre(george).
hombre(hugo).
hombre(ron).
hombre(albus_severus).
hombre(james_sirius).


mujer(lily_evans).
mujer(lily_luna).
mujer(molly_weasley).
mujer(hermione).
mujer(rose).
mujer(ginny).



progenitor(hermione,rose).
progenitor(hermione,hugo).

progenitor(ron,rose).
progenitor(ron,hugo).

progenitor(arthur_weasley,ron).
progenitor(arthur_weasley,fred).
progenitor(arthur_weasley,george).
progenitor(arthur_weasley,ginny).

progenitor(molly_weasley,ron).
progenitor(molly_weasley,fred).
progenitor(molly_weasley,george).
progenitor(molly_weasley,ginny).

progenitor(james_potter,harry).
progenitor(lily_evans,harry).

progenitor(harry,james_sirius).
progenitor(harry,albus_severus).
progenitor(harry,lily_luna).

progenitor(ginny,lily_luna).
progenitor(ginny,albus_severus).
progenitor(ginny,james_sirius).

conyugue(james_potter,lily_evans).
conyugue(molly_weasley,arthur_weasley).
conyugue(harry,ginny).
conyugue(ron,hermione).



mama(X,Y):- mujer(X), progenitor(X,Y).
papa(X,Y):- hombre(X), progenitor(X,Y).

hermanos(X,Y):- papa(Z,X),papa(Z,Y),mama(W,X),mama(W,Y),X\=Y.



esposa(X,Y):-(conyugue(X,Y);conyugue(Y,X)),mujer(X).
esposo(X,Y):-(conyugue(X,Y);conyugue(Y,X)),hombre(X).

