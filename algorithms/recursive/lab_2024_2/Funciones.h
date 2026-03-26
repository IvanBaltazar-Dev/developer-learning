//
// Created by Ivan Piero Baltazar on 10/03/2026.
//

#ifndef LAB_2024_2_FUNCIONES_H
#define LAB_2024_2_FUNCIONES_H
#include <iostream>
#include <fstream>

#define N 5
#define M 5
using namespace std;

void solucion(int matrix[N][M]);
void funcionRecursiva(int matrix[N][M],int matrix_result[N][M],
    int fila, int columna, int mayor_valor,bool encontro_mayor);

#endif //LAB_2024_2_FUNCIONES_H
