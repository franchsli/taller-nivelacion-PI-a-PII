# taller-nivelacion-PI-a-PII

Solución para el taller de nivelación en PII.

## Parte teórica

### Markdown

Investigar qué es markdown.

**R//** Markdown es un lenguaje de marcado ligero que permite dar formato
a texto plano de forma sencilla y legible. Es muy usado en GitHub, blogs,
documentación técnica, foros y demás.

### GIT

1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto “normal”?
**R//** Un repositorio en Git o también llamado "repo" es un espacio de almacenamiento
donde se guarda el historial de cambios de un proyecto y sus archivos.
Se diferencia de un proyecto "normal" en que Git permite conocer cuándo y dónde
se hicieron cambios, revertirlos, etc. Nada de eso sería posible sin el historial de Git.
2. ¿Cuáles son las tres áreas principales de Git (working directory, staging area/index y
repository) y qué papel cumple cada una?
**R//** **Working directory:** Es donde están todos los archivos del proyecto. El usuario
escribe los cambios ahí.
**Staging area:** Es donde Git reune los cambios en los archivos deseados. También le permite
al usuario añadir mensajes a sus cambios para diferenciarlos de otros de manera comprensible.
**Repository:** Es donde Git guarda los cambios en sí, es donde el historial y todos
los cambios anteriores residen en el equipo. El repository es lo que le da la habilidad al
usuario de cambiar entre versiones y guardar nuevas versiones de sus archivos.
3. ¿Cómo representa Git los cambios internamente? (objetos blob, tree, commit y tag).
**R//** Git almacena los cambio 
**Blob:** Siglas de Binary Large Object, representa el contenido de un archivo
excluyendo el nombre y ruta de este.
**Tree:** Representa los directorios. Contiene los hashes de los blob o subtrees
junto con sus nombres de archivo, tipos y permisos de dichos archivos.
**Commit:** Representa el tree raíz junto con quién hizo el commit (padre), cuando (fecha) y
el por qué (mensaje).
**Tag:** Representa una etiqueta de un objeto (commit). Guarda el objeto etiquetado, nombre,
autor y mensaje.
4. ¿Cómo se crea un commit y qué información almacena un objeto commit?
5. ¿Cuál es la diferencia entre git pull y git fetch?
6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits?
7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?
8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?
9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?
10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?
11. ¿Cómo se utiliza git stash y en qué escenarios es útil?
12. ¿Qué mecanismos ofrece Git para deshacer cambios (por ejemplo, git reset, git
revert, git checkout)?
13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso
para gestión de forks?
14. ¿Cómo puedo inspeccionar el historial de commits (por ejemplo, git log, git
diff, git show)?

### Programación

15. ¿Cuáles son los tipos de datos primitivos en Java?
16. ¿Cómo funcionan las estructuras de control de flujo como if, else, switch y bucles en
Java?
17. ¿Por qué es importante usar nombres significativos para variables y métodos?
18. ¿Qué es la Programación Orientada a Objetos (POO)?
19. ¿Cuáles son los cuatro pilares de la Programación Orientada a Objetos?
20. ¿Qué es la herencia en POO y cómo se utiliza en Java?
21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java?
22. ¿Qué es una variable de entorno y por qué son importantes para Java o la
programación en general?

## Parte práctica

1. Crear un programa que utilice estructuras de control para resolver un problema
sencillo, como una calculadora básica que realice operaciones de suma, resta,
multiplicación y división.
2. Escribir un programa que cuente el número de vocales y consonantes en una
palabra. La palabra no contendrá símbolos, caracteres especiales, acentos, ni
números y siempre estará en minúsculas.
3. Escribir un programa que invierta una cadena de texto ingresada por el usuario.
