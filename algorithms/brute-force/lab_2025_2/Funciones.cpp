//
// Created by Ivan Piero Baltazar on 5/03/2026.
//

#include "Funciones.h"

void cargarCromosoma(int num, int *arr, int size){

    for(int i = 0; i < size; i++){
        arr[i] = num % 2;
        num = num / 2;
    }
}

bool cumpleRequerimiento(int &sum_costos,
                         int &sum_beneficio,
                         int &sum_falsos_negativos,
                         int *arr,
                         int size,
                         int P, int B, int F,
                         const int matriz[C][3]){

    for(int i = 0; i < size; i++){

        if(arr[i] == 1){
            sum_costos += matriz[i][0];
            sum_beneficio += matriz[i][1];
            sum_falsos_negativos += matriz[i][2];
        }

    }

    return (sum_costos <= P && sum_beneficio >= B && sum_falsos_negativos <= F);
}

void imprimeCromosoma(int *arr,
                      int size,
                      int sum_costos,
                      int sum_beneficio,
                      int sum_falsos_negativos){

    cout << "Recursos: {";
    bool primero = true;

    for(int i = 0; i < size; i++){

        if(arr[i] == 1){
            if(!primero){
                cout << ",";
            }
            cout << i + 1;
            primero = false;
        }
    }

    cout << "}, Costo total: " << sum_costos
         << ", Beneficio: " << sum_beneficio
         << ", Falsos Negativos: " << sum_falsos_negativos
         << endl;
}


void solucion(const int matriz[C][3], int P, int B, int F){

    int num = pow(2, C);
    int cromosoma[C]={};

    int haySol = 0; //Queda en 0 si no hay solucion
    for(int i = 1; i < num; i++){
        // if ( i == 17) {
        //     cout<<"CUMPLE";
        // }
        cargarCromosoma(i, cromosoma, C);

        int sum_costos = 0;
        int sum_beneficio = 0;
        int sum_falsos_negativos = 0;

        if (cumpleRequerimiento(sum_costos,
                                sum_beneficio,
                                sum_falsos_negativos,
                                cromosoma,
                                C,
                                P, B, F,
                                matriz)) {
            imprimeCromosoma(cromosoma,
                             C,
                             sum_costos,
                             sum_beneficio,
                             sum_falsos_negativos);
            haySol++;
        }
    }
    if (haySol == 0) {
        cout<<"No se pueden seleccionar controles de seguridad que cumplan todas las restricciones." << endl;
    }
}

