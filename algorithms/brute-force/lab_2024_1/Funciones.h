//
// Created by Ivan Piero Baltazar on 30/03/2026.
//

#ifndef LAB_2024_1_FUNCIONES_H
#define LAB_2024_1_FUNCIONES_H
#include <iostream>
#include <fstream>
#include <cmath>

#include "Guerrero.h"
#include "Arma.h"

using namespace std;

#define MAX_GUERREROS 3
#define MAX_ARMAS 12

void cargarDatos(ifstream &arch, Guerrero *arr_guerreros,int &cantGuerreros, Arma *arr_armas, int &cantArmas);
void solucion(Guerrero *arr_guerreros,int cantGuerreros,Arma *arr_armas,int cantArmas);
void crearCromosoma(int *cromosoma, int cantArmas, int cantGuerreros,int num);
void imprimirCromosoma(int *cromosoma,int cantArmas);
bool validaMochila(int *cromosoma,int cantArmas, Arma* arr_armas);
bool validaArma(int *cromosoma, int personaje_actual, Arma arma_actual, Arma *arr_armas, int cantArmas);
Guerrero buscaGuerrero(int id,Guerrero *arr_guerreros,int cantGuerreros);
bool validaAtaque(int *cromosoma,Guerrero *arr_guerreros,int cantGuerreros,Arma *arr_armas,int cantArmas);

#endif //LAB_2024_1_FUNCIONES_H