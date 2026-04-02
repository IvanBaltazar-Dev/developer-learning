#include "Funciones.h"

using namespace std;

int main() {

    ifstream arch("datos.txt", ios::in);
    if (!arch.is_open()) {
        cout<<"Archivo no existe"<<endl;
        return 0;
    }

    Guerrero arr_guerreros[MAX_GUERREROS]={};
    int cantGuerreros = 0;

    Arma arr_armas[MAX_ARMAS]={};
    int cantArmas = 0;

    cargarDatos(arch, arr_guerreros, cantGuerreros, arr_armas, cantArmas);

    solucion(arr_guerreros, cantGuerreros, arr_armas, cantArmas);

    cout<<"Hola"<<endl;

    return 0;
}