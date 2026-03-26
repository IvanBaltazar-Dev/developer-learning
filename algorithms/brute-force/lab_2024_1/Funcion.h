//
// Created by Ivan Piero Baltazar on 13/03/2026.
//

#ifndef LAB_2024_1_FUNCION_H
#define LAB_2024_1_FUNCION_H
#include <iostream>
#include <fstream>
#include <cmath>
#include "Arma.h"
#define F_G 3
#define C_G 4
#define A 12
using namespace std;

void cargarDatos(const char *nombre_archivo,
    int matrix_guerreros[F_G][C_G],Arma *arr_armas);
void solucion(int matrix_guerreros[F_G][C_G],Arma *arr_armas);
void cargarCromosoma(int num,int *cromosoma,int size_armas);
void imprimirCromosoma(int *cromosoma,int size_armas);
bool validaArmas(Arma *arr_armas,int *cromosoma,int size_armas);
void enfrentaGuerreros(int matrix_guerreros[F_G][C_G],int fila,
    int columna,Arma *arr_armas,int *cromosoma,int size_armas,
    int &cant_soluciones);
int buscarArma(Arma* arr_armas,int size_armas,char pre_req_actual);
bool tipoValidoParaGuerrero(int matrix_guerreros[F_G][C_G],int columna,char tipo_arma,
    int indice_guerrero);
#endif //LAB_2024_1_FUNCION_H