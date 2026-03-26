//
// Created by Ivan Piero Baltazar on 10/03/2026.
//

#ifndef LAB_2024_2_FUNCIONES_H
#define LAB_2024_2_FUNCIONES_H
#include <iostream>
#include <cmath>
#include <fstream>
using namespace std;

void solucion(char *letras_fabricadas,int num_letras,char matriz[8][8],int num_palabras);
void cargarCromosoma(int num,int *cromosoma,int size);
void imprimirCromosoma(int *cromosoma,int size);
bool esSolucionValida(char *letras_fabricadas,int num_letras,char *palabra_actual,int *cromosoma);
void imprimePalabra(char *palabra_actual);

#endif //LAB_2024_2_FUNCIONES_H