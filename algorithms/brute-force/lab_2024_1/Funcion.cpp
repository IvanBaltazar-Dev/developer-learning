//
// Created by Ivan Piero Baltazar on 13/03/2026.
//

#include "Funcion.h"

void cargarDatos(const char *nombre_archivo,
    int matrix_guerreros[F_G][C_G],Arma *arr_armas) {
    ifstream arch(nombre_archivo,ios::in);
    if (!arch.is_open()) {
        cout<<"ERROR AL ABRIR EL ARCHIVO"<<endl;
        exit(1);
    }
    int num = -1;
    for (int i = 0; i < F_G; i++) {
        for (int j = 0; j < C_G; j++) {
            arch>>num;
            matrix_guerreros[i][j] = num;
        }
    }
    for (int i = 0; i < A; i++) {
        arch>>arr_armas[i].id_arma;
        arch>>arr_armas[i].poder;
        arch>>arr_armas[i].tipo;
        arch>>arr_armas[i].pre_requisitos[0];
        arch>>arr_armas[i].pre_requisitos[1];
        arch>>arr_armas[i].pre_requisitos[2];
    }
}


void solucion(int matrix_guerreros[F_G][C_G],Arma *arr_armas) {
    int combinaciones = (int)pow(F_G+1,A);
    int cant_soluciones = 0;
    for (int num = 1; num < combinaciones; num++) {
        int cromosoma[A]={};
        cargarCromosoma(num,cromosoma,A);
        if ( num == 12662874) {
            // 2 2 1 1 0 2 3 0 1 0 0 3 =  12662874
            imprimirCromosoma(cromosoma,A);
            cout<<"PRUEBA"<<endl;
        }
        bool valid = validaArmas(arr_armas,cromosoma,A);
        if (valid) {
            enfrentaGuerreros(matrix_guerreros,F_G,C_G,arr_armas,
                cromosoma,A,cant_soluciones);
        }
    }
    if (cant_soluciones == 0) {
        cout<<"No se encontraron soluciones posibles"<<endl;
    }

}

void cargarCromosoma(int num,int *cromosoma,int size_armas) {
    for (int i = 0; i < size_armas; i++) {
        cromosoma[i] = num%4;
        num = num/4;
    }
}

void imprimirCromosoma(int *cromosoma,int size_armas) {
    for (int i = 0; i < size_armas; i++) {
        cout<<cromosoma[i];
    }
    cout<<endl;
}

bool validaArmas(Arma *arr_armas,int *cromosoma,int size_armas) {
    for (int i = 0; i < size_armas; i++) {
        if (cromosoma[i]!=0) { //ARMA SELECCIONADA
            for (int j = 0; j < 3; j++) { //VALIDA REQUISITOS
                if (arr_armas[i].pre_requisitos[j] == '-') { //Una vez no hayan requisitos
                    break;
                }
                //TIENE REQUISITO
                int posReq = buscarArma(arr_armas,size_armas,arr_armas[i].pre_requisitos[j]);
                //CRITERIO 1: NO ENCONTRO EL ARMA
                if (posReq == -1) return false;
                //CRITERIO 2: ARMA NO SELECCIONADA EN EL CROMOSOMA
                if (cromosoma[posReq]==0) return false;
                //CRITERIO 3: NO SE ENCUENTRA EN LA MISMA MOCHILA
                if (cromosoma[i] != cromosoma[posReq]) return false;
            }
        }
    }
    return true;
}

void enfrentaGuerreros(int matrix_guerreros[F_G][C_G],int fila,
    int columna,Arma *arr_armas,int *cromosoma,int size_armas,
    int &cant_soluciones) {
    int poder_total[F_G]={}; //ACUMULADOR

    for (int i = 0; i<size_armas ; i++) {
        if (cromosoma[i] > 0 ) {
            int indice_guerrero = cromosoma[i]-1;
            if (!tipoValidoParaGuerrero(matrix_guerreros,columna,arr_armas[i].tipo,cromosoma[i])) {
                return;
            }
            poder_total[indice_guerrero] += arr_armas[i].poder;
        }
    }

    for (int i = 0; i < fila; i++) {
        if (poder_total[i] <= matrix_guerreros[i][0]) {
            return;
        }
    }
    cant_soluciones++;
    imprimirCromosoma(cromosoma,size_armas);
}

int buscarArma(Arma* arr_armas,int size_armas,char pre_req_actual) {
    for (int i = 0; i < size_armas; i++) {
        if (arr_armas[i].id_arma == pre_req_actual) {
            return i;
        }
    }
    return -1;
}

bool tipoValidoParaGuerrero(int matrix_guerreros[F_G][C_G],int columna,char tipo_arma,
    int indice_guerrero) {
    for (int i = 1; i < columna; i++) {
        //NO EXISTEN ARMAS PARA SER VENCIDOS
        if (matrix_guerreros[indice_guerrero][i] == -1) break;
        //SI ENCUENTRA UN ARMA DEL TIPO PARA SER VENCIDO
        if (matrix_guerreros[indice_guerrero][i] == tipo_arma) {
            return true;
        }
    }
    //NINGUNO DE LOS TIPOS DE ARMA PARA SER VENCIDO COINCIDE
    return false;
}

/*
 * APUNTE DE ERRORES
 * Error 1: creer que “pre-requisito seleccionado” ya es suficiente
     * No.
     * Debe estar en la misma mochila.
 *
 * Error 2: usar pow y olvidar que devuelve double
    * Siempre mejor castear.
 *
 * Error 3: seguir leyendo archivo aunque no abrió
    * Eso deja basura en los arreglos.
 *
 * Error 4: confundir “poder mayor” con “poder mayor o igual”
    * El enunciado dice:
    * sea mayor al del guerrero
    * Entonces debe ser:
    * poder_total > poder_guerrero
    * no >=.

 * Error 5: validar tipos después de sumar todo sin cortar
    * Apenas una mochila tenga un arma de tipo inválido para ese guerrero, el cromosoma ya no sirve.
 *
 */