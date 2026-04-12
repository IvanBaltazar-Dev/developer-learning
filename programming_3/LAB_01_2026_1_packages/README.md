LAB_01_2026_1_packages

Proyecto Java que organiza el código utilizando packages para separar responsabilidades en capas: model, service, view y app.

📁 Estructura del proyecto
LAB_01_2026_1_packages/
```
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── model/
│   │   ├── Assessment.java
│   │   ├── Teacher.java
│   │   ├── Question.java
│   │   ├── QuestionAssessment.java
│   │   ├── SingleChoiceQuestion.java
│   │   ├── MultipleChoiceQuestion.java
│   │   └── Printable.java
│   ├── service/
│   │   └── QuestionManager.java
│   └── view/
│       └── AssessmentViewerConsole.java
└── bin/   ← se crea al compilar
```
⚙️ Compilación y ejecución
# 🔹Opción A: Compilar todo de una vez
  ## Crear carpeta de salida
  mkdir bin
  
  ## Compilar
  javac -d bin src/model/*.java src/service/*.java src/view/*.java src/app/Main.java
  
  ## Ejecutar
  java -cp bin app.Main
# 🔹Opción B: Compilar por etapas (recomendado)
  ## Crear carpeta de salida
  mkdir bin
  
  ## 1. Compilar model (sin dependencias)
  javac -d bin src/model/*.java
  
  ## 2. Compilar service y view (dependen de model)
  javac -d bin -cp bin src/service/*.java 
  javac -d bin -cp bin src/view/*.java
  
  ## 3. Compilar app (depende de todo)
  javac -d bin -cp bin src/app/Main.java

  ## Ejecutar
  java -cp bin app.Main

📌 Notas importantes
-d bin → define el directorio de salida de los .class (destination)
-cp bin → indica a Java dónde buscar las clases compiladas (classpath)
El orden de compilación es importante cuando hay dependencias entre paquetes
✅ Recomendación

Usa la Opción B para entender mejor cómo funcionan las dependencias entre paquetes en Java.

🧠 Conceptos clave
Packages: organización lógica del código
Classpath (-cp): rutas donde Java busca clases
Compilación modular: compilar por capas según dependencias
