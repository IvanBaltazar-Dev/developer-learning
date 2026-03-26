//
// Created by Ivan Piero Baltazar on 7/03/2026.
//

#include "Funciones.h"
/* Modo:
 * 0 -> busca espacio apra iniciar
 * 1 -> bajar todo lo posible
 * 2 -> avanza, sube
 * 3 -> elimina galeria incompleta
 */

void solucion(int mina[N][M]) {
    int totalGalerias = 0;

    recorrido(mina,totalGalerias,0,N-1,0,1,N-1);

    if (totalGalerias == 0) {
        cout<<"No se pudo completar ninguna galeria"<<endl;
    }else {
        cout<<"Solucion: Mina a imprimir con " << totalGalerias << " galerias"<<endl;
        imprimir(mina,0,0);
    }
}

void recorrido(int mina[N][M],int &totalGalerias,int modo,int fila, int columna, int galeria_actual, int inicio_fila) {
    if (modo == 0) { //Buscando lugar para empezar

        if (fila < 0) {//CASO BASE, ya no se puede subir mas filas
            totalGalerias = galeria_actual-1; //No completa la ultima
            return;
        }
        if (mina[inicio_fila][0] == 0) {//puede iniciar
            mina[inicio_fila][columna] = galeria_actual;
            // imprimir(mina,0,0);
            //Cambio a modo bajar
            recorrido(mina,totalGalerias,1,fila,0,galeria_actual,inicio_fila);
            return;
        }

        //Probar iniciar en la fila superior
        recorrido(mina,totalGalerias,0,fila-1,0,galeria_actual,inicio_fila-1);
    }

    if (modo == 1) { //Bajar todo lo posible
        if (fila+1 < N && mina[fila+1][columna] == 0) {//Disponible para bajar
            mina[fila+1][columna] = galeria_actual;
            recorrido(mina,totalGalerias,1,fila+1,columna,galeria_actual,inicio_fila);
            return;
        }
        //Si no se puede bajar -> avanza o sube (MODO 2)
        recorrido(mina,totalGalerias,2,fila,columna,galeria_actual,inicio_fila);
    }

    if (modo == 2) {//AVANZA A LA DERECHA O SUBE
        //PRIMERO: EVALUAR SI LA GALERIA YA SE COMPLETO
        if (columna == M-1) {
            recorrido(mina,totalGalerias,0,inicio_fila-1,0,galeria_actual+1,inicio_fila-1);
            return;
        }
        //SEGUNDO: EVALUAR SI ES POSIBLE IR A LA DERECHA
        if (columna+1 < M && mina[fila][columna+1] == 0) {
            mina[fila][columna+1] = galeria_actual;
            recorrido(mina,totalGalerias,1,fila,columna+1,galeria_actual,inicio_fila);
            return;
        }
        //TERCERO: EVALUAR SUBIR
        if (fila-1 >= 0 && mina[fila-1][columna] == 0) {
            mina[fila-1][columna] = galeria_actual;
            recorrido(mina,totalGalerias,2,fila-1,columna,galeria_actual,inicio_fila);
            return;
        }
        //CUARTO: NO SE PUEDE SUBIR NI DERECHA -> MODO 3 BORRAR GALERIA INCOMPLETA
        recorrido(mina,totalGalerias,3,0,0,galeria_actual,0);
    }

    if (modo == 3) { //Borrar galerias incompletas
        if (fila == N) { //Fila llego al final
            //Intenta iniciar mas arriba
            recorrido(mina,totalGalerias,0,inicio_fila-1,0,galeria_actual,inicio_fila-1);
            return;
        }
        if (mina[fila][columna] == galeria_actual) {
            mina[fila][columna] = 0;
        }

        if (columna + 1 < M) { //Mientras sea posible ir a la siguiente columna
            recorrido(mina,totalGalerias,3,fila,columna+1,galeria_actual,inicio_fila);
        }else {
            recorrido(mina,totalGalerias,3,fila+1,0,galeria_actual,inicio_fila);
        }
    }
}

void imprimir(int mina[N][M],int fila, int columna) {
    // CON BUCLES ANIDADOS
    // for (int i=0;i<columna;i++) {
    //     for (int j=0;j<M;j++) {
    //         if (mina[fila][columna] == -1) {
    //             cout<<"*";
    //         }else {
    //             cout<<mina[fila][columna];
    //         }
    //         cout<<" ";
    //     }
    //     cout<<endl;
    // }

    // Caso base: ya no hay más filas por imprimir
    if (fila == N) {
        cout<<endl;
        return;
    }

    // Imprimir la celda actual
    if (mina[fila][columna] == -1) {
        cout << "*";
    } else {
        cout << mina[fila][columna];
    }
    cout << " ";

    // Si aún hay columnas en esta fila, avanzar a la derecha
    if (columna + 1 < M) {
        imprimir(mina, fila, columna + 1);
    } else {
        // Si ya terminó la fila, hacer salto de línea
        cout << endl;
        imprimir(mina, fila + 1, 0);
    }
}