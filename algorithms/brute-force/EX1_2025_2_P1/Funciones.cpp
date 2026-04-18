//
// Created by Ivan Piero Baltazar on 18/04/2026.
//

#include "Funciones.h"

void solucion(int data_base[N][M], int p1, int p2, int p3) {
    int num = pow(2,N);
    for (int i = 1; i < num; i++) {
        int cromosoma[N]={};
        creaCromosoma(i,cromosoma,N);
        // if (i == 2213) { // 1 0 1 0 0 1 0 1 0 0 0 1 0
        //     cout<<"It's work"<<endl;
        // }
        if (es_valido(cromosoma,N,data_base)) { //Cromo valido
            if (cumple_requisitos(p1,p2,p3,cromosoma,N,data_base)) {//Valida los requerimientos de P1, P2, P3
                bool es_primero = true;
                for (int j = 0; j < N; j++) {
                    if (cromosoma[j] == 1) {
                        if (!es_primero) {
                            cout<<" |";
                        }

                        cout<<data_base[j][0]<<" P"<<data_base[j][1];

                        es_primero = false;
                    }
                }
                cout<<endl;
            }

        }

    }
}
void creaCromosoma(int num, int * arr, int size) {
    for (int i = 0; i < size; i++) {
        arr[i]=num%2;
        num=num/2;
    }
}

bool es_valido(int * arr, int size, int data_base[N][M]) {
    int inicio_X = -1;
    int inicio_Y = -1;
    int final_X = -1;
    int final_Y = -1;

    int prioridad_X=-1;
    int prioridad_Y=-1;

    for (int i = 0; i < size; i++) {
        if (arr[i] == 1) {
            if (inicio_X == -1) {
                //Primera vez
                inicio_X = data_base[i][2];
                prioridad_X = data_base[i][1];
                if (prioridad_X == 1) {
                    final_X = data_base[i][2] + data_base[i][3] + 1;
                } else {
                    final_X = data_base[i][2] + data_base[i][3];
                }
            } else {
                if ((13 <= inicio_X and inicio_X < 14) ||
                    13 < final_X and final_X <= 14) {
                    //VALIDA ALMUERZO
                    return false;
                }

                inicio_Y = data_base[i][2];
                prioridad_Y = data_base[i][1];
                if (prioridad_Y == 1) {
                    final_Y = data_base[i][2] + data_base[i][3] + 1;
                } else {
                    final_Y = data_base[i][2] + data_base[i][3];
                }
                if (inicio_Y < final_X) {
                    // Se cruzan
                    return false;
                }
                if (final_Y > 17) {//FUERA DE HORARIO
                    return false;
                }

                //SI CUMPLE ACTUALIZA X
                inicio_X = inicio_Y;
                final_X = final_Y;
                prioridad_X = prioridad_Y;
            }
        }
    }
    return true;
}


bool cumple_requisitos(int p1, int p2, int p3, int * arr, int size, int data_base[N][M]) {
    int p1_count = 0;
    int p2_count = 0;
    int p3_count = 0;
    for (int i = 0; i < size; i++) {
        if (arr[i] == 1) {
            if (data_base[i][1] == 1) {
                p1_count++;
            }else if (data_base[i][1] == 2) {
                p2_count++;
            }else if (data_base[i][1] == 3) {
                p3_count++;
            }
        }
    }
    if (p1_count == p1 && p2_count == p2 && p3_count == p3) {
        return true;
    }
    return false;
}