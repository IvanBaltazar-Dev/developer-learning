//
// Created by Ivan Piero Baltazar on 10/03/2026.
//

#include "Funciones.h"

void solucion(char *letras_fabricadas,int num_letras,char matriz[8][8],int num_palabras) {
    int soluciones = pow(2,num_letras);
    for ( int i = 0; i < num_palabras; i++) { // ITERA POR CADA PALABRA
        int cant_soluciones = 0;
        for (int num = 1; num < soluciones; num++) { // POSIBLES SOLUCIONES
            // if ( num == 21) {
            //     cout<<"prueba"<<endl;
            // }
            int cromosoma[num_letras];
            cargarCromosoma(num,cromosoma,num_letras);
            bool valid = esSolucionValida(letras_fabricadas,num_letras,matriz[i],cromosoma);
            if (valid) {
                cant_soluciones++;
            }
        }
        cout<<"La palabra ";
        imprimePalabra(matriz[i]);
        cout<<" tiene "<<cant_soluciones<<" combinaciones de Letras."<<endl;
    }
}

void cargarCromosoma(int num,int *cromosoma,int size) {
    for (int i = 0; i < size; i++) {
        cromosoma[i] = num % 2;
        num /= 2;
    }
}

void imprimirCromosoma(int *cromosoma,int size) {
    for (int i = 0; i < size; i++) {
        cout << cromosoma[i] << " ";
    }
    cout<<endl;
}

bool esSolucionValida(char *letras_fabricadas,int num_letras,char *palabra_actual,int *cromosoma) {
    int size_cromosoma = 0;
    for (int i = 0; i < num_letras; i++) { //conteo de cromosoma
        if (cromosoma[i] == 1) size_cromosoma++;
    }
    int size_palabra = 0;
    while (palabra_actual[size_palabra] != '\0') size_palabra++;
    //**CRITERIO 1: EL TAMANIO DE LA PALABRA DEBE SER IGUAL AL TAMANIO DE CROMOSOMA
    if (size_cromosoma != size_palabra) return false;

    for (int i = 0; i < size_palabra; i++) {
        for (int j = 0; j < num_letras; j++) {
            //**CRITERIO 2: BUSCA EL CARACTER, SI ENCUENTRA LO MARCA Y SALE A BUSCAR EL SIGUIENTE
            if (cromosoma[j] == 1 && letras_fabricadas[j] == palabra_actual[i]) {
                cromosoma[j] = -1;
                break;
            }
        }
    }
    //**CRITERIO 3: VERIFICAR QUE TODOS LOS CARACTERES HAYAN SIDO ENCONTRADOS
    for (int i = 0; i < num_letras; i++) {
        if (cromosoma[i] == 1) return false;
    }
    return true;
}

void imprimePalabra(char *palabra_actual) {
    for (int i = 0; palabra_actual[i]; i++) {
        cout << palabra_actual[i];
    }
}
