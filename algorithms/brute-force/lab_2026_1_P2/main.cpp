#include "Funciones.h"

using namespace std;

int main() {

    int data_base[N][M]={
        {1, 1, 1, 3},
        {2, 1, 1, 1},
        {3, 1, 2, 0},
        {4, 1, 3, 1},
        {5, 1, 3, 2},
        {6, 1, 4, 1},
        {7, 1, 4, 2},
        {8, 1, 4, 3}
    };
    int matrix_tiempo_costo[4][3]= {
        {1, 5, 20},
        {2, 7, 30},
        {3, 10, 35},
        {4, 12, 42}
    };

    int time_citas[3]={60,45,50};

    solucion(data_base,matrix_tiempo_costo,time_citas,3);


    return 0;
}