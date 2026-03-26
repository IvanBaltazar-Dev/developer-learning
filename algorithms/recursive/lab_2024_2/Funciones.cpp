//
// Created by Ivan Piero Baltazar on 10/03/2026.
//

#include "Funciones.h"

void solucion(int matrix[N][M]) {
    int matrix_result[N][M]={};

    funcionRecursiva(matrix,matrix_result,0,0,-1,false);
    //IMPRESION
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cout<< matrix_result[i][j]<<" ";
        }
        cout<<endl;
    }
}
void funcionRecursiva(int matrix[N][M],int matrix_result[N][M],
    int fila, int columna, int mayor_valor, bool encontro_mayor) {
    if (fila == N-1 and columna == M-1 and encontro_mayor) {
        matrix_result[fila][columna] = mayor_valor-matrix[fila][columna];
        return; //CASE BASE
    }
    //RECURSIVIDAD
    //CRITERIO 1 -> ENCUENTRA EL MAYOR
    if (!encontro_mayor) {
        if (mayor_valor < matrix[fila][columna]) {
            mayor_valor = matrix[fila][columna];
        }
        if (fila == N-1 and columna == M-1) {
            encontro_mayor = true;
            funcionRecursiva(matrix,matrix_result,0,0,mayor_valor,encontro_mayor);
            return;
        }
        if (columna < M -1) {
            funcionRecursiva(matrix,matrix_result,fila,columna+1,mayor_valor,encontro_mayor);
        }else {
            funcionRecursiva(matrix,matrix_result,fila+1,0,mayor_valor,encontro_mayor);
        }
    }else {
        if (columna < M-1) {
            matrix_result[fila][columna] = mayor_valor-matrix[fila][columna];
            funcionRecursiva(matrix,matrix_result,fila,columna+1,mayor_valor,encontro_mayor);
        }else {
            funcionRecursiva(matrix,matrix_result,fila+1,0,mayor_valor,encontro_mayor);
            matrix_result[fila][columna] = mayor_valor-matrix[fila][columna];

        }
    }
}
/*
 * APUNTE DE FALLOS
 * NO USAR WHILE EN LA RECURSION PARA RECORRER LA COLUMNA
 * CUANDO TERMINA UNA FILA LA COLUMNA SE REINICIA A 0
 * SI VAMOS A ACTIVAR UNA FLAG O OPERACION SE HACE ANTES DE VOLVER A LLAMAR LA RECURSIVIDAD
 * LINEA 34 DEBEMOS COLOCAR UN RETURN DESPUÉS DE VALIDAR NUESTRA PRIMERA OPERACION
 * EL ULTIMO DATO NO SE LLEGA A COMPLETAR, VALIDAR ANTES DEL RETURN FINAL
 */