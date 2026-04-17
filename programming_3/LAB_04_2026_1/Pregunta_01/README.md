## Compilación y ejecución del proyecto

Para compilar todos los módulos del proyecto en un solo paso, puedes ejecutar el siguiente comando desde la raíz del proyecto `Pregunta_01`:

```bash
javac pe\edu\pucp\assessment\question\model\*.java pe\edu\pucp\assessment\teacher\model\*.java pe\edu\pucp\assessment\manager\model\*.java pe\edu\pucp\assessment\exam\model\*.java pe\edu\pucp\assessment\program\main\*.java
```

Luego, para ejecutar el programa principal:

```bash
java -cp . pe.edu.pucp.assessment.program.main.Main
```

### Nota
El comando de compilación genera los archivos `.class` directamente a partir de todos los paquetes del proyecto, y el comando de ejecución lanza la clase principal `Main`.
