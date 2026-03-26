#include "Funciones.h"


using namespace std;
int main() {
    //**CARGANDO DATOS**
    ifstream arch("datos.txt",ios::in);
    if (!arch.is_open()) {
        cout<<"Error al abrir el archivo"<<endl;
        return -1;
    }

    int num_letras;
    arch>>num_letras;
    char letras_fabricadas[10]={};
    for (int i = 0; i < num_letras; i++) {
        arch>>letras_fabricadas[i];
    }
    int num_palabras;
    arch>>num_palabras;
    char matriz[8][8] = {};
    for (int i = 0; i < num_palabras; i++) {
        arch >> matriz[i];
    }

    solucion(letras_fabricadas,num_letras,matriz,num_palabras);


    return 0;
}