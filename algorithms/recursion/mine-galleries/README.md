# Galerías en Mina usando Recursión (C++)

## Descripción

Este proyecto resuelve un problema de algoritmia donde un robot perforador debe crear galerías dentro de una mina representada como una matriz.
El robot debe perforar galerías **desde el lado izquierdo hasta el lado derecho de la mina**, respetando ciertas restricciones.
La solución está implementada **usando recursión** y **sin utilizar ciclos dentro de la función recursiva principal**.

---

## Reglas del problema

El robot cumple las siguientes condiciones:

- Inicia desde el **lado izquierdo inferior de la mina**
- Solo puede moverse:
  - a la **derecha**
  - hacia **arriba**
  - hacia **abajo**
- Las galerías deben ir **de izquierda a derecha**
- No puede atravesar:
  - rocas (`*`)
  - otras galerías
- Si una galería **no llega al final**, debe eliminarse
- El algoritmo debe mostrar **cuántas galerías completas se pudieron construir**

---
## Representación de la mina

La mina se representa con una matriz `N x M`.
Valores posibles:
| Valor | Significado |
|------|-------------|
| `0` | espacio libre |
| `-1` | roca |
| `1,2,3...` | número de galería construida |

Ejemplo de mina inicial:
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 * 0 0 0 0 0
0 0 0 0 0 * 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0

---

## Estrategia del algoritmo
El algoritmo utiliza una **función recursiva con distintos modos de operación**.

### Modos de la recursión
| Modo | Acción |
|-----|------|
| 0 | Buscar posición para iniciar una nueva galería |
| 1 | Bajar todo lo posible |
| 2 | Intentar avanzar a la derecha o subir |
| 3 | Borrar una galería incompleta |

---

## Lógica del robot
El robot sigue esta estrategia:

1. Busca una fila disponible para iniciar la galería.
2. Baja todo lo posible en la columna actual.
3. Intenta avanzar a la derecha.
4. Si no puede avanzar, intenta subir para rodear el obstáculo.
5. Si no puede avanzar ni subir, la galería **fracasa**.
6. Cuando una galería fracasa, se elimina completamente de la matriz.
7. El proceso continúa hasta que ya no sea posible iniciar más galerías.
---

## Archivos del proyecto
.
├── main.cpp
├── Funciones.cpp
├── Funciones.h
└── README.md

### main.cpp
Inicializa la mina y ejecuta el algoritmo.

### Funciones.h
Define las constantes y prototipos de funciones.

### Funciones.cpp
Contiene toda la lógica recursiva del algoritmo.

---

## Compilación

Usando **g++**:

```bash
g++ main.cpp Funciones.cpp -o mina
