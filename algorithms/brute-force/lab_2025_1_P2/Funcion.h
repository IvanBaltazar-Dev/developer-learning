//
// Created by Ivan Piero Baltazar on 12/03/2026.
//

#ifndef LAB_2025_1_P2_FUNCION_H
#define LAB_2025_1_P2_FUNCION_H
#include <iostream>
#include <cmath>
#include <fstream>

#define N 10
#define M 5
using namespace std;

void cargarDatos(int matrix[N][M], int size_fila, int size_columna,ifstream &arch);
void solucion(int matrix[N][M],int size_fila,int size_columna,int presupuesto_total,int seguridad_minima);
void cargarCromosoma(int num, int *cromosoma,int size);
void imprimirCromosoma(int *arr, int size);
bool cumpleRequisitos(int matrix[N][M],int size_fila,int size_columna,int presupuesto_total,int seguridad_minima,
    int *cromosoma,int &presupuesto_actual, int &seguridad_actual);
bool cumpleDependencias(int *fila_recurso, int size_columna, int *cromosoma);

#endif //LAB_2025_1_P2_FUNCION_H