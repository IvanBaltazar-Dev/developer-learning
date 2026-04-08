\# 📘 LAB 01 - Organización con Paquetes en Java



\## 📌 Descripción



Este proyecto corresponde a la reorganización de un sistema de generación de exámenes en Java, aplicando paquetes (packages) para mejorar la estructura del código.



El sistema permite:



\- gestionar preguntas

\- seleccionar preguntas aleatorias

\- asignar puntajes por examen

\- registrar profesores

\- mostrar el examen en consola



\## 🎯 Objetivo del ejercicio



Aplicar:



\- organización del código con paquetes

\- uso de package e import

\- compilación estructurada en Java

\- ejecución de clases dentro de paquetes



\## 📂 Estructura del proyecto

```

LAB\_01\_2026\_1\_packages/

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

```

\## 🧠 Organización por capas



| Paquete | Responsabilidad |

|--------|----------------|

| model | Entidades del sistema |

| service | Lógica de negocio |

| view | Visualización |

| app | Punto de entrada |



\## ⚙️ Compilación del proyecto



Ubícate en la raíz del proyecto:



```bash

cd LAB\_01\_2026\_1\_packages



🔧 Comando de compilación

javac -d out src/model/\*.java src/service/\*.java src/view/\*.java src/app/\*.java



\##🧠 ¿Qué significa -d out?

\-d = destination (destino)

Indica dónde guardar los archivos compilados (.class)



\#🔍 Ejemplo



Si tienes:

package app;



Java generará:

out/app/Main.class



\#💡 Sin -d out



Los .class se generan desordenados en la misma carpeta de los .java.



\#⚠️ Problemas:



mala organización

errores al ejecutar con paquetes

difícil mantenimiento



\#✅ Con -d out

```

out/

├── app/

├── model/

├── service/

└── view/

```



👉 Se respeta la estructura de paquetes automáticamente



\#▶️ Ejecución del programa

java -cp out app.Main

\#🧠 ¿Qué significa -cp out?

\-cp = classpath

Indica a Java: “Busca las clases en esta ruta”

\#🔍 En este caso

\-cp out



Significa:



👉 Java debe buscar clases dentro de la carpeta out



\#💡 ¿Por qué es necesario?



Porque ahí están los .class generados:



out/app/Main.class



\##⚠️ Sin -cp out



Java no encuentra la clase:



Error: Could not find or load main class app.Main



\##🧠 Forma simple de entenderlo

Parámetro	Significado

\-d out	dónde guardar clases compiladas

\-cp out	dónde buscarlas para ejecutar



\##🚀 Flujo completo



\# Compilar

javac -d out src/model/\*.java src/service/\*.java src/view/\*.java src/app/\*.java



\# Ejecutar

java -cp out app.Main

💡 Resultado esperado



El sistema mostrará en consola:



datos del examen

duración

fecha

preguntas con opciones



(similar al output del enunciado de la práctica)



