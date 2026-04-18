#include "Funciones.h"

using namespace std;


int main() {
    ifstream arch("datos.txt",ios::in);
    if (!arch.is_open()) {
        cout<<"Error al abrir el archivo"<<endl;
        exit(1);
    }

    int data_base[N][M];
    int P1=-1,P2=-1,P3=-1;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            arch>>data_base[i][j];
        }
    }
    // cout<<"Introduce P1, P2 Y P3 en se orden: ";
    // cin>>P1>>P2>>P3;
    P1 = 1;
    P2 = 1;
    P3 = 3;
    solucion(data_base,P1,P2,P3);



    return 0;
}
