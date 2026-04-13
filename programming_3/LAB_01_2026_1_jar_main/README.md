# 📦 Proyecto: LAB\_01\_2026\_1\_jar\_main

Este proyecto implementa una arquitectura modular en Java usando JARs, separando la lógica en una librería reutilizable (`assessment-lib`) y una aplicación principal (`assessment-app`).

---
## 📁 Estructura del Proyecto
```bash

LAB_01_2026_1_jar_main/
├── assessment-lib/
│   ├── src/
│   │   ├── model/
│   │   │   ├── Assessment.java
│   │   │   ├── Teacher.java
│   │   │   ├── Question.java
│   │   │   ├── QuestionAssessment.java
│   │   │   ├── SingleChoiceQuestion.java
│   │   │   ├── MultipleChoiceQuestion.java
│   │   │   └── Printable.java
│   │   ├── service/
│   │   │   └── QuestionManager.java
│   │   └── view/
│   │       └── AssessmentViewerConsole.java
│   │
│   └── bin/
│       ├── model/
│       ├── service/
│       └── view/
│
└── assessment-app/
    ├── src/
    │   └── app/
    │       └── Main.java
    │
    ├── bin/
    │   └── app/
    │       └── Main.class
    │
    ├── lib/
    │   └── assessment-lib.jar
    │
    ├── MANIFEST.MF
    └── assessment-app.jar

```
---

## ⚙️ Compilación y Ejecución

### 🔹 1. Compilar la librería `assessment-lib`

Ubícate en:

```bash

cd LAB\_01\_2026\_1\_jar\_main/assessment-lib

```
Ejecuta:

```bash

\# 1. Crear bin si no existe

mkdir bin

\# 2. Compilar la librería

javac -d bin src/model/\*.java src/service/\*.java src/view/\*.java

\# 3. Crear el jar de la librería

jar cvf ../assessment-app/lib/assessment-lib.jar -C bin .

\# 4. Verificar el jar de la librería

jar tf ../assessment-app/lib/assessment-lib.jar

```
---
### 🔹 2. Compilar la aplicación `assessment-app`
Ubícate en:
```bash
cd ../assessment-app
```

Ejecuta:

```bash
# 1. Crear bin si no existe
mkdir bin

# 2. Compilar Main usando la librería
javac -cp "lib/assessment-lib.jar" -d bin src/app/Main.java
```



---



### 🔹 3. Crear el `MANIFEST.MF`
Ubicado en: `assessment-app/`

```bash
# Crear carpeta META-INF/
mkdir META-INF

# Crear archivo MANIFEST.MF
notepad MANIFEST.MF
```
Contenido:

```bash
Main-Class: app.Main
Class-Path: lib/assessment-lib.jar
```
---
### 🔹 4. Crear el `.jar` ejecutable

Ubícate en:

```bash
cd LAB\_01\_2026\_1\_jar\_main/assessment-app
```
Ejecuta:

```bash
jar cvfm assessment-app.jar MANIFEST.MF -C bin app
#        < Nombre del .jar> <MANIFEST>     <empaquetar bin/app>
```
---

## 🔍 ¿Qué significa este comando?

```bash
jar cvfm assessment-app.jar MANIFEST.MF -C bin app
```

- `c` → create  
- `v` → verbose  
- `f` → file  
- `m` → usar manifest  

Luego:

```bash
\-C bin app
```

➡️ Entra a `bin` y empaqueta solo la carpeta `app`

---
## ⚠️ MUY IMPORTANTE (MANIFEST.MF)

El archivo `MANIFEST.MF` \*\*debe terminar con una línea en blanco\*\*.
Si no la tiene:
- La última línea (ej. `Class-Path`) \*\*es ignorada\*\*
- El `.jar` no carga dependencias correctamente
---



## 📦 Resultado dentro del `.jar`

```bash
assessment-app.jar
├── META-INF/
│   └── MANIFEST.MF
└── app/
    └── Main.class
```

---
## ▶️ Ejecutar

```bash
java -jar assessment-app.jar
```

---
## ✅ Notas adicionales
- Asegúrate de que `assessment-lib.jar` esté dentro de `lib/`
- Usa comillas en `-cp` si estás en Windows
- Mantén la estructura del proyecto para evitar errores de classpath
- No olvides la línea en blanco en el `MANIFEST.MF`

