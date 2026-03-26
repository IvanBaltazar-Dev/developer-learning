//
// Created by Ivan Piero Baltazar on 12/03/2026.
//

#ifndef LAB_2025_1_FUNCIONES_H
#define LAB_2025_1_FUNCIONES_H
#include <iostream>
#include <cmath>
#include <fstream>

#define N 6
#define D 3
using namespace std;

void solucion(int *tablas,int size_tabla, int *discos, int size_disco);
void cargarCromosoma(int num, int *crosomoma,int size_tabla);
void imprimirCromosoma(int *cromosoma, int size_tabla, int size_disco);
int calcularMinimo(int *arr_tablas,int size_tabla,int *arr_discos,int size_disco,int *cromosoma);
void copyCromo(int *cromosoma,int *cromosoma_solucion,int size_tabla);
#endif //LAB_2025_1_FUNCIONES_H