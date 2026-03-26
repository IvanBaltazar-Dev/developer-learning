#include "Funcion.h"

int main() {
    int matrix_guerrreros[F_G][C_G]={};
    Arma arr_armas[A]={};

    cargarDatos("datos.txt",matrix_guerrreros,arr_armas);

    solucion(matrix_guerrreros,arr_armas);
    return 0;
}