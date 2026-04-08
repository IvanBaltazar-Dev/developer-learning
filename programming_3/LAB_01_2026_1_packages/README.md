# 📘 LAB 01 - Organización con Paquetes en Java

## 📌 Descripción

Este proyecto corresponde a la reorganización de un sistema de generación de exámenes en Java, aplicando **paquetes (packages)** para mejorar la estructura del código.

El sistema permite:

- Gestionar preguntas
- Seleccionar preguntas aleatorias
- Asignar puntajes por examen
- Registrar profesores
- Mostrar el examen en consola

---

## 🎯 Objetivo del ejercicio

Aplicar:

- Organización del código con paquetes
- Uso de `package` e `import`
- Compilación estructurada en Java
- Ejecución de clases dentro de paquetes

---

## 📂 Estructura del proyecto


LAB_01_2026_1_packages/
└── src/
├── app/
│ └── Main.java
├── model/
│ ├── Printable.java
│ ├── Question.java
│ ├── SingleChoiceQuestion.java
│ ├── MultipleChoiceQuestion.java
│ ├── Teacher.java
│ ├── QuestionAssessment.java
│ └── Assessment.java
├── service/
│ └── QuestionManager.java
└── view/
└── AssessmentViewerConsole.java


---

## 🧠 Organización por capas

| Paquete | Responsabilidad |
|--------|----------------|
| `model` | Entidades del sistema |
| `service` | Lógica de negocio |
| `view` | Visualización |
| `app` | Punto de entrada |

---

## ⚙️ Compilación del proyecto

Ubícate en la raíz del proyecto:

```bash
cd LAB_01_2026_1_packages
🔧 Compilar
javac -d out src/model/*.java src/service/*.java src/view/*.java src/app/*.java
🧠 ¿Qué significa -d out?
-d = destination (destino)
Indica dónde guardar los archivos compilados (.class)
📌 Resultado

Si tienes:

package app;

Se genera:

out/app/Main.class
❌ Sin -d out
Los .class se mezclan con los .java
Mala organización
Problemas al trabajar con paquetes
✅ Con -d out
out/
├── app/
├── model/
├── service/
└── view/

👉 Se respeta automáticamente la estructura de paquetes

▶️ Ejecución del programa
java -cp out app.Main
🧠 ¿Qué significa -cp out?
-cp = classpath
Indica dónde Java debe buscar las clases compiladas

👉 En este caso:

out/

Contiene:

out/app/Main.class
❌ Sin -cp out
Error: Could not find or load main class app.Main
🧠 Resumen
Parámetro	Función
-d out	Dónde guardar las clases compiladas
-cp out	Dónde buscarlas al ejecutar
🚀 Flujo completo
# Compilar
javac -d out src/model/*.java src/service/*.java src/view/*.java src/app/*.java

# Ejecutar
java -cp out app.Main
💡 Resultado esperado

El sistema mostrará en consola:

Datos del examen
Duración
Fecha
Preguntas con sus opciones

(Salida similar al enunciado de la práctica)
