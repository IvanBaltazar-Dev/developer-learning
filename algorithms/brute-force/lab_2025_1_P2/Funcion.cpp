//
// Created by Ivan Piero Baltazar on 12/03/2026.
//

#include "Funcion.h"

void cargarDatos(int matrix[N][M], int size_fila, int size_columna,ifstream &arch) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            arch>>matrix[i][j];
        }
    }
}

void solucion(int matrix[N][M],int size_fila,int size_columna,int presupuesto_total,int seguridad_minima) {
    int soluciones = pow(2,size_fila);
    int cantidad_validadas = 0;

    cout<<"Combinaciones validas (Costo entre "
        <<presupuesto_total*8/10
        <<" y "<<presupuesto_total
        <<" miles y Nivel de seguridad >= "
        <<seguridad_minima<<"):"<<endl;

    for (int num = 0 ; num < soluciones; num++) {
        // if (num == 263) {
        //     cout<<"PRUEBA"<<endl;
        // }
        int cromosoma[N]={};
        int presupuesto_actual = 0;
        int seguridad_actual = 0;

        cargarCromosoma(num,cromosoma, size_fila);

        if (cumpleRequisitos(matrix,size_fila,size_columna,presupuesto_total,seguridad_minima,cromosoma,
            presupuesto_actual,seguridad_actual)) {

            cantidad_validadas++;

            cout<<"Combinacion "<<num<<": Recursos: ";
            imprimirCromosoma(cromosoma,size_fila);
            cout<<" | Costo: "<<presupuesto_actual<<" miles"
                <<" | Nivel de Seguridad: "<<seguridad_actual<<endl;
        }
    }
    if (cantidad_validadas == 0) {
        cout<<"No se encontraron combinaciones que cumplan con lo solicitado"<<endl;
    }

}

bool cumpleRequisitos(int matrix[N][M],int size_fila,int size_columna,int presupuesto_total,int seguridad_minima,
    int *cromosoma,int &presupuesto_actual, int &seguridad_actual) {
    // Recorremos todos los recursos posibles
    for (int i = 0; i < size_fila; i++) {
        if (cromosoma[i] == 1) { // Si el recurso está seleccionado en el cromosoma
            bool dependencias_validas = cumpleDependencias(matrix[i], size_columna, cromosoma);
            // Si no se cumplen los requisitos, la combinación no es válida
            if (!dependencias_validas) {
                return false;
            }
            // Si las dependencias son correctas,
            presupuesto_actual += matrix[i][0]; // acumulamos el costo del recurso
            seguridad_actual += matrix[i][4]; // acumulamos el nivel de seguridad que aporta
        }
    }

    // Calculamos el mínimo permitido (80% del presupuesto)
    int presupuesto_minimo = presupuesto_total * 8 / 10;

    // Validamos las restricciones globales
    if (presupuesto_actual < presupuesto_minimo) return false;
    if (presupuesto_actual > presupuesto_total) return false;
    if (seguridad_actual < seguridad_minima) return false;
    // Si pasó todas las validaciones, la combinación es válida
    return true;
}

bool cumpleDependencias(int *fila_recurso, int size_columna, int *cromosoma) {
    // Recorremos las columnas donde están los requisitos
    // columna 1 → req1
    // columna 2 → req2
    // columna 3 → req3
    for (int i = 1; i < size_columna - 1; i++) {
        // CRITERIO 1: Si encontramos -1 significa que ya no hay más requisitos
        if (fila_recurso[i] == -1) {
            break;
        }
        // fila_recurso[i] -> indica el índice del recurso requerido
        // CRITERIO 2: El recurso no está seleccionado, no se cumple la depedencia
        if (cromosoma[fila_recurso[i]] == 0) {
            return false;
        }
    }
    // Si todos los requisitos están presentes
    return true;
}

void cargarCromosoma(int num,int *cromosoma,int size) {
    for (int i = 0; i < size; i++) {
        cromosoma[i] = num%2;
        num/=2;
    }
}

void imprimirCromosoma(int *arr, int size) {
    for (int i = 0; i < size; i++) {
        if (arr[i] == 1) {
            cout<<"R"<<i+1<<" ";
        }
    }
}



/*
 *APUNTES DE ERROR
 *LISTAR MANUALMENTE LA MATRIZ, USAR ARCHIVO datos.txt
 *No mezclar int con double usar presupuesto * 8 / 10 (todo queda en enteros)
 *CUANDO INICIAMOS UN bool Y LO USAREMOS DESPUÉS TENER EN CUENTA COMO SE INICIALIZA,
 *NO SIEMPRE FALSE ES LA MEJOR OPCION, DEPENDE DE LO QUE SUPONGAS
 *PENSAMIENTO: SI NO SE CUMPLE RETORNA FALSO O NO EJECUTES, SI PASA EL FILTRO RECIEN OPERA
 */