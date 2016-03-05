/* -*- Mode:Prolog -*- */

 % and, or, nand, nor, xor, not, buffer, e input 
 
and(0,0,0).
and(0,_,0).
and(_,0,0).
and(1,1,0).
and(1,x,x).
and(x,1,x).
and(x,x,x).


or(1,_,1).
or(_,1,1).
or(0,0,0).
or(0,x,x).
or(x,0,x).
or(x,x,x).

not(0,1).
not(1,0).
not(x,x).
/*
nand(0,0,1).
nand(0,1,1).
nand(1,0,1).
nand(1,1,0).
*/
/*
nor(0,0,1).
nor(0,1,0).
nor(1,0,0).
nor(1,1,0).
*/
xor(0,0,0).
xor(0,1,1).
xor(1,0,1).
xor(1,1,0).
xor(x,x,x).
xor(0,x,x).
xor(1,x,x).
xor(x,1,x).
xor(x,0,x).

buffer(0,0).
buffer(1,1).
buffer(x,x).

input(0,0).
input(1,1).
input(x,x).

% sim_gate(+Type, +In,-Out), onde Type é o tipo da gate (buff, and, ...); 
% In é a sua lista de entradas com valores em {0,1,x},
% e Out é o seu valor de saída, também com 3 valores possíveis.

% caso uma das entradas for zero nao interessa o q as outras sao devolvemos 0
sim_gate(and,[0,_,_],0).
sim_gate(and,[E1,E2],Out):-and(E1,E2,Out).
sim_gate(and,[E1,E2|T],Out):-and(E1,E2,Out1),sim_gate(and,[Out1|T],Out).

% caso uma das entradas for 1 nao interessa o resto
sim_gate(or,[1,_,_],1).
sim_gate(or,[E1,E2],Out):-or(E1,E2,Out).
sim_gate(or,[E1,E2|T],Out):-or(E1,E2,Out1), sim_gate(or,[Out1|T],Out).

sim_gate(not,[E1],Out):-not(E1,Out).
sim_gate(xor,[E1,E2],Out):-xor(E1,E2,Out).


% nand(A,B,Out) = not and(A,B,Out)
sim_gate(nand,[E1,E2|T],Out):-sim_gate(and,[E1,E2|T],Out1),not(Out1,Out).
sim_gate(nor,[E1,E2|T],Out):-sim_gate(or,[E1,E2|T],Out1),not(Out1,Out).

sim_gate(buffer,[E],Out):-buffer(E,Out).
sim_gate(input,[E],Out):-input(E,Out).



% gate(+Type,+In,+Out,+N,+A(N-1),-AN)
/* Type é o tipo do gate
In lista de entradas
Out é  alista de saidas
N é o seu nome
A(N-1) e AN são duas variáveis, respectivamente de entrada e saida
*/


