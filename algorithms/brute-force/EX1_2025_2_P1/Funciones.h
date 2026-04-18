//
// Created by Ivan Piero Baltazar on 18/04/2026.
//

#ifndef EX1_2025_2_P1_FUNCIONES_H
#define EX1_2025_2_P1_FUNCIONES_H
#include <iostream>
#include <fstream>
#include <iostream>
#include <cmath>
#define N 13
#define M 4

using namespace std;

void solucion(int data_base[N][M], int p1, int p2, int p3);
void creaCromosoma(int num, int * arr, int size);
bool es_valido(int * arr, int size, int data_base[N][M]);
bool cumple_requisitos(int p1, int p2, int p3, int * arr, int size, int data_base[N][M]);

#endif //EX1_2025_2_P1_FUNCIONES_H