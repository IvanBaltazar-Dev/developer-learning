#include "Funciones.h"

#include <iostream>


using namespace std;
int main() {

    int matriz[C][3] = {
        {35000,80,1},
        {24000,60,3},
        {30000,70,2},
        {27000,48,1},
        {10000,20,1},
        {7000,35,2},
        {6000,10,1},
        {40000,40,3}
    };

    int P = 70000;
    int B = 150;
    int F = 5;

    solucion(matriz, P, B, F);

    return 0;
}