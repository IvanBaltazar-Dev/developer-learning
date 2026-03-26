//
// Created by Ivan Piero Baltazar on 5/03/2026.
//

#ifndef LAB_2025_1_FUNCIONES_H
#define LAB_2025_1_FUNCIONES_H
#include <iostream>
#include <cmath>

#define C 8
using namespace std;

// genera el cromosoma binario
void cargarCromosoma(int num, int *arr, int size);

// verifica si cumple las restricciones
bool cumpleRequerimiento(int &sum_costos,
                         int &sum_beneficio,
                         int &sum_falsos_negativos,
                         int *arr,
                         int size,
                         int P, int B, int F,
                         const int matriz[C][3]);

// imprime la solución
void imprimeCromosoma(int *arr,
                      int size,
                      int sum_costos,
                      int sum_beneficio,
                      int sum_falsos_negativos);

// función principal del algoritmo
void solucion(const int matriz[C][3], int P, int B, int F);

#endif //LAB_2025_1_FUNCIONES_H