//
// Created by aml on 18/04/2026.
//

#include "Funciones.h"

void solucion(int data_base[N][M],int matrix_tiempo_costo[4][3],int *time_citas,int size_citas) {
    int num = pow(4,8);
    int ganancia_maxima = 0;
    int cromosoma_final[N]={};
    for (int i=1;i<num;i++) {

        int cromosoma[N]={};
        crearCromosoma(i,cromosoma,N);
        if (es_valido(cromosoma,N,data_base,matrix_tiempo_costo,time_citas,size_citas)) {
            //valida que no se exceda el tiempo
            int ganancia_actual=0;
            for (int i=0;i<N;i++) {
                if (cromosoma[i]!=0) {
                    int cant_caries = data_base[i][3];
                    int ganancia_por_carie = matrix_tiempo_costo[data_base[i][2]-1][2];
                    ganancia_actual+=cant_caries*ganancia_por_carie;
                }
            }
            if (ganancia_actual>ganancia_maxima) {
                for (int i=0;i<N;i++) {
                    cromosoma_final[i]=cromosoma[i];
                }
                ganancia_maxima=ganancia_actual;
            }
        }
    }
    impresion(cromosoma_final,N);
}

void crearCromosoma(int num,int* cromosoma,int size) {
    for (int i=0;i<size;i++) {
        cromosoma[i]=num%4;
        num=num/4;
    }
}

bool es_valido(int cromosoma[N], int size, int data_base[N][M],
               int matrix_tiempo_costo[4][3], int *time_citas,int size_citas) {
    int tiempo_atention[size_citas]={};
    for (int i=0;i<size;i++) {
        if (cromosoma[i]>0) {
            int cant_caries = data_base[i][3];
            int duracion = matrix_tiempo_costo[data_base[i][2]-1][1];
            if (cromosoma[i]==1 && cant_caries>0) {
                tiempo_atention[cromosoma[i]-1]+=cant_caries*duracion;
            }else if (cromosoma[i]==2) {
                tiempo_atention[cromosoma[i]-1]+=cant_caries*duracion;
            }else if (cromosoma[i]==3) {
                tiempo_atention[cromosoma[i]-1]+=cant_caries*duracion;
            }
        }
    }
    for (int i=0;i<size_citas;i++) {
        if (tiempo_atention[i]>=time_citas[i]) {
            return false;
        }
    }
    return true;
}

void impresion(int *cromosoma_final,int size) {
    //Para impresion
    cout<<"================================="<<endl;
    for (int i=0;i<N;i++) {
        if (cromosoma_final[i]==1) {
            cout<<"Cita: 1 Diente: "<<i+1<<endl;
        }
    }
    for (int i=0;i<N;i++) {
        if (cromosoma_final[i]==2) {
            cout<<"Cita: 2 Diente: "<<i+1<<endl;
        }
    }
    for (int i=0;i<N;i++) {
        if (cromosoma_final[i]==3) {
            cout<<"Cita: 3 Diente: "<<i+1<<endl;
        }
    }
    cout<<"================================="<<endl;
    cout<<endl;
}
