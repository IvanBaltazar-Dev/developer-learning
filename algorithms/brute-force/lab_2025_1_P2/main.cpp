#include "Funcion.h"

int main() {
    ifstream arch("datos.txt",ios::in);
    if (!arch.is_open()) {
        cout<<"ERROR AL ABRIR EL ARCHIVO"<<endl;
        exit(1);
    }

    //CARGAR DATOS
    int matrix[N][M] = {};
    cargarDatos(matrix,N,M,arch);

    int presupuesto = 300;
    // cout<<"Ingrese el presupuesto (en miles de soles): ";
    // cin>>presupuesto;

    int nivel_seguridad = 620;
    // cout<<"Ingrese el nivel de seguridad minimo requerido: ";
    // cin>>nivel_seguridad;

    //SOLUCION
    solucion(matrix,N,M,presupuesto,nivel_seguridad);

    return 0;
}