# 📦 LAB 01 - Java Packages

Refactor de un sistema en Java aplicando **organización por paquetes** para mejorar la estructura del proyecto.

---

## 🧠 Estructura
```
src/
├── app/ # entry point
├── model/ # entidades
├── service/ # lógica de negocio
└── view/ # salida en consola
```
---

## ⚙️ Compilar
Desde la raíz del proyecto:
```
javac -d out src/model/.java src/service/.java src/view/.java src/app/.java
```

### ¿Qué hace `-d out`?
Define la carpeta donde se generan los `.class`.

Resultado:
```
out/
├── app/
├── model/
├── service/
└── view/
```
---

## ▶️ Ejecutar
```
java -cp out app.Main
```

### ¿Qué hace `-cp out`?
Indica a Java dónde buscar las clases compiladas.

---

## 🔁 Flujo completo
```
javac -d out src/model/.java src/service/.java src/view/.java src/app/.java
java -cp out app.Main
```

---

## 🧩 Idea clave
- `-d out` → dónde se guardan las clases  
- `-cp out` → dónde Java las busca  

---

## ✅ Resultado

El programa se ejecuta en consola mostrando el examen generado.
