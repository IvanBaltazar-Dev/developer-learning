//
// Created by Ivan Piero Baltazar on 30/03/2026.
//

#include "Funciones.h"

void cargarDatos(ifstream &arch, Guerrero *arr_guerreros, int &cantGuerreros, Arma *arr_armas, int &cantArmas) {
    arch>>cantGuerreros;
    arch>>cantArmas;

    for (int i = 0; i < cantGuerreros; i++) {
        arch>>arr_guerreros[i].id;
        arch>>arr_guerreros[i].poder;
        arch>>arr_guerreros[i].tipo_arma[0];
        arch>>arr_guerreros[i].tipo_arma[1];
        arch>>arr_guerreros[i].tipo_arma[2];
    }

    for (int i = 0; i < cantArmas; i++) {
        arch>>arr_armas[i].id;
        arch>>arr_armas[i].poder;
        arch>>arr_armas[i].tipo;
        arch>>arr_armas[i].pre_requisito[0];
        arch>>arr_armas[i].pre_requisito[1];
        arch>>arr_armas[i].pre_requisito[2];
    }



}

void solucion(Guerrero *arr_guerreros, int cantGuerreros, Arma *arr_armas, int cantArmas) {
    int solucion = static_cast<int>(pow(cantGuerreros + 1, cantArmas));
    for (int num = 0; num < solucion; num++) {
        int cromosoma[MAX_ARMAS]={};
        crearCromosoma(cromosoma,cantArmas,cantGuerreros,num);
        if (validaMochila(cromosoma,cantArmas,arr_armas)) {
            if (validaAtaque(cromosoma,arr_guerreros,cantGuerreros,arr_armas,cantArmas)) {
                imprimirCromosoma(cromosoma,cantArmas);
            }
        }
    }
}

bool validaAtaque(int *cromosoma,Guerrero *arr_guerreros,int cantGuerreros,Arma *arr_armas,int cantArmas) {
    int arr_ataque[MAX_GUERREROS+1]={}; //arreglo que acumula los ataques
    for (int i=0; i < cantArmas; i++) {
        Guerrero guerrero_actual = buscaGuerrero(cromosoma[i],arr_guerreros,cantGuerreros);
        for (int j=0; guerrero_actual.tipo_arma[j] != -1; j++) {
            if (guerrero_actual.tipo_arma[j] == arr_armas[i].tipo) {
                arr_ataque[guerrero_actual.id] += arr_guerreros[i].poder;
            }
        }
    }
    for (int i=1; i < cantGuerreros+1; i++) {
        if (arr_ataque[i] <= arr_guerreros[i].poder) {
            return false;
        }
    }
    return true;
}

Guerrero buscaGuerrero(int id,Guerrero *arr_guerreros,int cantGuerreros) {
    Guerrero guerrero = {};
    for (int i=0; i < cantGuerreros+1; i++) {
        if (arr_guerreros[i].id == id) {
            return arr_guerreros[i];
        }
    }
    return guerrero;
}
void crearCromosoma(int *cromosoma,int cantArmas, int cantGuerreros, int num) {
    for (int i=0; i < cantArmas; i++) {
        cromosoma[i] = num%(cantGuerreros+1);
        num = num/(cantGuerreros+1);
    }
}
void imprimirCromosoma(int *cromosoma,int cantArmas) {
    for (int i=0; i < cantArmas; i++) {
        cout<<cromosoma[i];
    }
    cout<<endl;
}

bool validaMochila(int *cromosoma,int cantArmas, Arma *arr_armas) {
    for (int i = 0 ; i < cantArmas; i++) {
        if (cromosoma[i] != 0) {
            if (!validaArma(cromosoma,cromosoma[i],arr_armas[i],arr_armas,cantArmas)) {
                return false;
            }
        }
    }
    return true;
}

bool validaArma(int *cromosoma, int personaje_actual, Arma arma_actual, Arma *arr_armas, int cantArmas) {
    //Debe cumplir los requisitos y tambien debe pertenecer a la misma mochila
    for (int i=0; arma_actual.pre_requisito[i] != '-'; i++) {
        for (int j=0; j < cantArmas; j++) {
            if (arma_actual.pre_requisito[i] == arr_armas[j].id &&
                personaje_actual != cromosoma[j] ) {
                return false;
            }
        }
    }
    return true;
}