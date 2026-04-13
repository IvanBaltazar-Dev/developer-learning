\# 📦 Proyecto: LAB\_01\_2026\_1\_jar



Este proyecto muestra cómo crear una \*\*librería `.jar` en Java\*\* y cómo utilizarla desde una aplicación externa.



\---



\## 📁 Estructura del Proyecto



```bash

LAB\_01\_2026\_1\_jar/

├── assessment-lib/

│   └── src/

│       ├── model/

│       │   ├── Assessment.java

│       │   ├── Teacher.java

│       │   ├── Question.java

│       │   ├── QuestionAssessment.java

│       │   ├── SingleChoiceQuestion.java

│       │   ├── MultipleChoiceQuestion.java

│       │   └── Printable.java

│       ├── service/

│       │   └── QuestionManager.java

│       └── view/

│           └── AssessmentViewerConsole.java

│

└── assessment-app/

&#x20;   ├── src/

&#x20;   │   └── app/

&#x20;   │       └── Main.java

&#x20;   │

&#x20;   └── lib/

&#x20;       └── assessment-lib.jar

```



\---



\## 🎯 Objetivo



\- Crear una librería `.jar` con clases reutilizables  

\- Compilar una aplicación (`Main.java`) usando esa librería  



\---



\## ⚙️ Compilación y Uso



\### 🔹 1. COMPILAR la librería (`assessment-lib`)



Ubícate en:



```bash

cd LAB\_01\_2026\_1\_jar/assessment-lib

```



Ejecuta:



```bash

\# Crear carpeta bin

mkdir bin



\# Compilar clases hacia bin

javac -d bin src/model/\*.java src/service/\*.java src/view/\*.java



\# Forma rápida (si tu terminal lo soporta)

javac -d bin src/.../\*.java

```



\---



\### 🔹 2. EMPAQUETAR el `.jar`



```bash

\# OPCIÓN 1: empaquetar solo los paquetes necesarios

jar cvf ../assessment-app/lib/assessment-lib.jar -C bin model -C bin service -C bin view



\# OPCIÓN 2: empaquetar TODO lo que hay en bin

\# ⚠️ Solo si bin NO contiene Main.class

jar cvf ../assessment-app/lib/assessment-lib.jar -C bin .



\# Verificar contenido del jar

jar tf ../assessment-app/lib/assessment-lib.jar

```



\---



\### 🔹 3. COMPILAR la aplicación (`assessment-app`)



Ubícate en:



```bash

cd ../assessment-app

```



```bash

mkdir bin

```



\#### 🪟 Windows



```bash

javac -d bin -cp "lib/assessment-lib.jar" src/app/Main.java

```



\#### 🐧 Linux / 🍎 Mac



```bash

javac -d bin -cp lib/assessment-lib.jar src/app/Main.java

```



\---



\### 🔹 4. EJECUTAR usando el `.jar`



📌 El `bin` se agrega al classpath para que Java encuentre `Main.class`.



\#### 🪟 Windows



```bash

java -cp "lib/assessment-lib.jar;bin" app.Main

```



\#### 🐧 Linux / 🍎 Mac



```bash

java -cp "lib/assessment-lib.jar:bin" app.Main

```



\---



\## 🧠 Explicación del Classpath



El `-cp` (classpath) indica a Java dónde buscar clases:



```bash

lib/assessment-lib.jar

```



➡️ Contiene la librería



```bash

bin

```



➡️ Contiene `Main.class`



\---



\### 🔥 Diferencias por sistema operativo



| Sistema | Separador | Ejemplo |

|--------|----------|--------|

| Windows | `;` | `"lib/a.jar;bin"` |

| Linux / Mac | `:` | `lib/a.jar:bin` |



\---



\## ⚠️ Buenas prácticas



\- No mezclar `Main.class` dentro del `.jar` de la librería  

\- Mantener separados `lib` y `bin`  

\- Verificar el `.jar` con `jar tf`  

\- Usar comillas en Windows si hay espacios en rutas  



\---



\## ▶️ Flujo resumido



```bash

\# 1. Compilar librería

javac -d bin src/.../\*.java



\# 2. Crear jar

jar cvf assessment-lib.jar -C bin .



\# 3. Compilar app

javac -cp lib/assessment-lib.jar -d bin src/app/Main.java



\# 4. Ejecutar

java -cp "lib/assessment-lib.jar;bin" app.Main

```

