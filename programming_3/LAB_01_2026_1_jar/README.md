# 📦 Proyecto: LAB_01_2026_1_jar

Este proyecto muestra cómo crear una **librería `.jar` en Java** y cómo utilizarla desde una aplicación externa.

---

## 📁 Estructura del Proyecto
```
LAB_01_2026_1_jar/
├── assessment-lib/
│ └── src/
│ ├── model/
│ │ ├── Assessment.java
│ │ ├── Teacher.java
│ │ ├── Question.java
│ │ ├── QuestionAssessment.java
│ │ ├── SingleChoiceQuestion.java
│ │ ├── MultipleChoiceQuestion.java
│ │ └── Printable.java
│ ├── service/
│ │ └── QuestionManager.java
│ └── view/
│ └── AssessmentViewerConsole.java
│
└── assessment-app/
├── src/
│ └── app/
│ └── Main.java
│
└── lib/
└── assessment-lib.jar
```
---

## 🎯 Objetivo

- Crear una librería `.jar` con clases reutilizables  
- Compilar una aplicación (`Main.java`) usando esa librería  

---

## ⚙️ Compilación y Uso

### 🔹 1. COMPILAR la librería (`assessment-lib`)

Ubícate en:

```bash
cd LAB_01_2026_1_jar/assessment-lib
```
### Ejecuta:

Crear carpeta bin
```bash
mkdir bin
```
Compilar clases hacia bin
```bash
javac -d bin src/model/*.java src/service/*.java src/view/*.java
```
Forma rápida (si tu terminal lo soporta)
```bash
javac -d bin src/**/*.java
```
### 🔹 2. EMPAQUETAR el .jar
OPCIÓN 1: empaquetar solo los paquetes necesarios
```bash
jar cvf ../assessment-app/lib/assessment-lib.jar -C bin model -C bin service -C bin view
```
OPCIÓN 2: empaquetar TODO lo que hay en bin

⚠️ Solo si bin NO contiene Main.class
```bash
jar cvf ../assessment-app/lib/assessment-lib.jar -C bin .
```
Verificar contenido del jar
```bash
jar tf ../assessment-app/lib/assessment-lib.jar
```
### 🔹 3. COMPILAR la aplicación (assessment-app)

Ubícate en:
```bash
cd ../assessment-app
mkdir bin
```

🪟 Windows
```bash
javac -d bin -cp "lib/assessment-lib.jar" src/app/Main.java
```
🐧 Linux / 🍎 Mac
```bash
javac -d bin -cp lib/assessment-lib.jar src/app/Main.java
```

### 🔹 4. EJECUTAR usando el .jar
📌 El bin se agrega al classpath para que Java encuentre Main.class

🪟 Windows
```bash
java -cp "lib/assessment-lib.jar;bin" app.Main
```
🐧 Linux / 🍎 Mac
```bash
java -cp "lib/assessment-lib.jar:bin" app.Main
```
---
🧠 Explicación del Classpath
El -cp (classpath) indica a Java dónde buscar clases:
```bash
lib/assessment-lib.jar
```

➡️ Contiene la librería
```bash
bin
```

➡️ Contiene Main.class


🔥 Diferencias por sistema operativo

Sistema	Separador	Ejemplo

Windows	";"	
```bash
"lib/a.jar;bin"
```
Linux / Mac	":"	
```bash
lib/a.jar:bin
```
---
## ⚠️ **Buenas prácticas**

- **No mezclar** `Main.class` dentro del `.jar` de la librería  
- **Mantener separados** `lib` y `bin`  
- **Verificar** el `.jar` con `jar tf`  
- **Usar comillas** en Windows si hay espacios en rutas
---

### ▶️ Flujo resumido
1. Compilar librería
```bash
javac -d bin src/**/*.java
```
2. Crear jar
```bash
jar cvf assessment-lib.jar -C bin .
```
3. Compilar app
```bash
javac -cp lib/assessment-lib.jar -d bin src/app/Main.java
```
4. Ejecutar
```bash
java -cp "lib/assessment-lib.jar;bin" app.Main
```
