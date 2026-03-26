//
// Created by Ivan Piero Baltazar on 12/03/2026.
//

#include "Funciones.h"

void solucion(int *arr_tablas,int size_tabla, int *arr_discos, int size_disco) {
    int cromosoma_solucion[N]={};
    int minimo_mayor = 0;
    int soluciones = pow(size_disco,size_tabla);
    //RECORRE TODAS LAS POSIBLES SOLUCIONES
    for(int num=1;num<soluciones;num++) {
        int cromosoma[N]={};
        int minimo_actual = 0;
        // if (num == 32) {
        // // 2 1 0 1 0 0
        //     cout<<"Prueba"<<endl;
        // }
        cargarCromosoma(num,cromosoma,size_tabla);
        minimo_actual = calcularMinimo(arr_tablas,size_tabla,arr_discos,size_disco,cromosoma);
        if (minimo_actual > minimo_mayor) {
            //SI minimo_actual es mayor -> ACTUALIZA EL MINIMO MAYOR
            minimo_mayor = minimo_actual;
            //COPIA EL CROMOSOMA EN CROMOSOMA SOLUCION
            copyCromo(cromosoma,cromosoma_solucion,size_tabla);
        }
    }
    imprimirCromosoma(cromosoma_solucion,size_tabla,size_disco);

}

void cargarCromosoma(int num, int *crosomoma,int size_tabla) {
    for(int i=0;i<size_tabla;i++) {
        crosomoma[i]=num%3;
        num=num/3;
    }
}

int calcularMinimo(int *arr_tablas,int size_tabla,int *arr_discos,int size_disco,int *cromosoma) {
    int minimo_actual = INT_MAX ;
    int arr_velocidad[D]={};
    for(int i=0;i<size_disco;i++) {
        arr_velocidad[i]=arr_discos[i];
    }
    for(int i=0;i<size_tabla;i++) {
        if (cromosoma[i] == 0 and arr_velocidad[0] > 0) {
                arr_velocidad[0] -= arr_tablas[i];
        }
        else if (cromosoma[i] == 1 and arr_velocidad[1] > 0) {
                arr_velocidad[1] -= arr_tablas[i];
        }
        else if (cromosoma[i] == 2 and arr_velocidad[2] > 0) {
                arr_velocidad[2] -= arr_tablas[i];
        }else {
            return -1;
        }
    }
    for (int i=0;i<size_disco;i++) {
        if (arr_velocidad[i] < minimo_actual)
            minimo_actual = arr_velocidad[i];
    }
    return minimo_actual;
}



void imprimirCromosoma(int *cromosoma, int size_tabla, int size_disco) {
    int matrix[D][N]={};
    int size_D1 = 0;
    int size_D2= 0;
    int size_D3 = 0;
    for(int i=0;i<size_tabla;i++) {
        if (cromosoma[i] == 0) {
            matrix[0][size_D1++]=i+1;
        }
        else if (cromosoma[i] == 1) {
            matrix[1][size_D2++]=i+1;
        }
        else if (cromosoma[i] == 2) {
            matrix[2][size_D3++]=i+1;
        }
    }
    for (int i=0;i<size_disco;i++) {
        cout<<"Disco "<< i+1 <<" : ";
        bool es_primero = true;
        for (int j=0;j<D;j++) {
            if (matrix[i][j] != 0) {
                if (!es_primero) {
                    cout<<", ";
                }
                cout<<matrix[i][j];
                es_primero = false;
            }
        }
        cout<<endl;
    }
}

void copyCromo(int *cromosoma,int *cromosoma_solucion,int size_tabla) {
    for(int i=0;i<size_tabla;i++) {
        cromosoma_solucion[i]=cromosoma[i];
    }
}


/*
 *APUNTE DE ERRORES:
 * pow(D,N); pow(BASE,SOLUCIONES);
 * No modificar los arreglos que utilizaremos en cada iteracion
 * CRITERIO 1: NO PUEDE EXCEDER LA CAPACIDAD DEL DISCO
 * CRITERIO 2: ENCONTRAR EL MENOR EN CADA POSIBLE SOLUCION PARA LUEGO
 * BUSCAR EL MENOR MAXIMO DE TODOS,
 */