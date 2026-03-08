//
// Created by Ivan Piero Baltazar on 7/03/2026.
//

#ifndef LAB_2025_2_P2_FUNCIONES_H
#define LAB_2025_2_P2_FUNCIONES_H
#include <iostream>

using namespace std;

#define N 6
#define M 11

void solucion(int mina[N][M]);
void recorrido(int mina[N][M],int &totalGalerias,int modo,int fila, int columna, int galeria_actual, int inicio_fila);
void imprimir(int mina[N][M],int columna,int fila);
#endif //LAB_2025_2_P2_FUNCIONES_H
