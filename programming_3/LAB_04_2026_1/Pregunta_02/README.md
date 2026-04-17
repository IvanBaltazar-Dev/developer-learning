## Compilación y empaquetado del proyecto

El proyecto se compila por módulos, respetando el orden de dependencias entre paquetes.  
Primero se generan los JAR de los módulos base y luego los de los módulos que dependen de ellos.

⚠️ **IMPORTANTE:** Todos los comandos deben ejecutarse desde la **raíz del proyecto** (donde se encuentra la carpeta `pe`). De lo contrario, las rutas de paquetes no serán reconocidas correctamente.

### 1. Módulo Question
Se compilan las clases del paquete `question.model` y luego se empaquetan en un archivo JAR.

```bash
javac pe\edu\pucp\assessment\question\model\*.java
jar cvf "assessmentQuestionModel.jar" -C . pe\edu\pucp\assessment\question\model
```

### 2. Módulo Teacher
Se compilan las clases del paquete `teacher.model` usando como dependencia el JAR del módulo `Question`.  
Luego se empaquetan en su propio archivo JAR.

```bash
javac -cp assessmentQuestionModel.jar pe\edu\pucp\assessment\teacher\model\*.java
jar cvf "assessmentTeacherModel.jar" -C . pe\edu\pucp\assessment\teacher\model
```

### 3. Módulo Manager
Se compilan las clases del paquete `manager.model` usando como dependencias los módulos `Question` y `Teacher`.  
Después se genera su archivo JAR.

```bash
javac -cp assessmentQuestionModel.jar;assessmentTeacherModel.jar pe\edu\pucp\assessment\manager\model\*.java
jar cvf "assessmentManagerModel.jar" -C . pe\edu\pucp\assessment\manager\model
```

### 4. Módulo Exam
Se compilan las clases del paquete `exam.model` utilizando como dependencias los módulos `Question`, `Teacher` y `Manager`.  
Finalmente, se empaquetan en un archivo JAR.

```bash
javac -cp assessmentQuestionModel.jar;assessmentTeacherModel.jar;assessmentManagerModel.jar pe\edu\pucp\assessment\exam\model\*.java
jar cvf "assessmentExamModel.jar" -C . pe\edu\pucp\assessment\exam\model
```

### 5. Programa principal
Se compilan las clases del paquete `program.main` usando todos los módulos anteriores como dependencias.  
Luego se genera el JAR principal del sistema.

```bash
javac -cp assessmentQuestionModel.jar;assessmentTeacherModel.jar;assessmentManagerModel.jar;assessmentExamModel.jar pe\edu\pucp\assessment\program\main\*.java
jar cvf "assessmentPrincipal.jar" -C . pe\edu\pucp\assessment\program\main
```

### 6. Generación del JAR ejecutable
Se crea el archivo JAR final incluyendo el manifiesto, el cual define la clase principal de ejecución del programa.

```bash
jar cvfm assessmentPrincipal.jar Pregunta02.txt -C . pe\edu\pucp\assessment\program\main
```

### Nota
El comando final con `cvfm` vuelve a generar `assessmentPrincipal.jar`, pero esta vez incluyendo el archivo de manifiesto.  
Por ello, ese es el JAR que debe considerarse como la versión ejecutable final del proyecto.
