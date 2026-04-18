//
// Created by aml on 18/04/2026.
//

#ifndef INC_20196388_LAB1_P2_FUNCIONES_H
#define INC_20196388_LAB1_P2_FUNCIONES_H
#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

#define N 8
#define M 4

void solucion(int data_base[N][M],int matrix_tiempo_costo[4][3],int* time_citas,int size_citas);
void crearCromosoma(int num,int* cromosoma,int size);
bool es_valido(int cromosoma[N], int size, int data_base[N][M],
               int matrix_tiempo_costo[4][3], int *time_citas,int size_citas);
void impresion(int *cromosoma_final,int size);
#endif //INC_20196388_LAB1_P2_FUNCIONES_H