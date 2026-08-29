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
**R//** Git almacena los cambios (y todos los datos en general) como objetos
dentro de `.git/objects`. Git genera una clave única (también llamado identificador o hash)
usando tradicionalmente el algoritmo SHA-1 aunque también existe SHA-256 para los repositorios
configurados con ese algoritmo.  
**Blob:** Siglas de Binary Large Object, representa el contenido de un archivo
excluyendo el nombre y ruta de este.  
**Tree:** Representa los directorios. Contiene los hashes de los blob o subtrees
junto con sus nombres de archivo, tipos y permisos de dichos archivos.  
**Commit:** Representa el tree raíz junto con quién hizo el commit (autor), cuando (fecha) y
el por qué (mensaje).  
**Tag:** Representa una etiqueta de un objeto (commit). Guarda el objeto etiquetado, nombre,
autor y mensaje.  
4. ¿Cómo se crea un commit y qué información almacena un objeto commit?  
**R//** Primero se deben hacer cambios a los archivos deseados. Luego, se usa `git add` para mover
todos los archivos cambiados al staging area ya sea con `git add .` o `git add <nombre de archivos>`.
Posterior a ello, se crea el commit con `git commit -m "<mensaje descriptivo>"`
por ejemplo digamos que alguien arregló un error, en ese caso la creación del commit se vería
similar a: `git commit -m "error de memoria arreglado al..."`  
Un commit contiene la siguiente información:  
**Tree:** Hash del tree raíz.  
**Parent:** Hash o hashes de los commits anteriores.  
**Author:** Persona que originalmente escribió los cambios del commit y la fecha de autoría.  
**Committer:** Persona que creó el commit junto con la fecha de creación.  
**Mensaje:** Notas que describen los cambios del commit. Son añadidas por el committer.  
A parte de estas cosas, los commits tambien guardan metadatos útiles para otras cosas (por ejemplo,
si se firma el commit con GPG este guarda los datos para ello) pero lo descrito anteriormente es lo
esencial.
5. ¿Cuál es la diferencia entre git pull y git fetch?  
**R//** La diferencia radica en que git fetch carga la información más reciente del repositorio
remoto sin actualizar los archivos locales, esto es útil para confirmar si hubo
cambios en el repositorio posteriores a la ultima actualización local. Por otro lado,
git pull no solo carga la información sino que actualiza los archivos locales con la nueva información.
6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits?  
**R//** Una rama es un puntero a un commit de una línea de trabajo.
Por ejemplo, si un desarrollador quiere implementar algo a una app sin tocar el main, este
crea una nueva rama que va a apuntar al mismo commit al que apunta main, sin embargo el podrá
hacer cambios en esa nueva rama y la main seguirá apuntando a donde apuntaba originalmente
no sufrirá ningún cambio.  
Git gestiona esos punteros de esta manera: la rama apunta a un commit y dicho commit apunta
al commit que le precede y asi sucesivamente hasta llegar al primer commit.
7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?  
**R//** Para realizar un merge se debe ir a la rama la cual va a recibir los cambios con
`git switch <nombre-rama>` o `git checkout <nombre-rama>`, luego, se ejecuta `git merge <rama-con-cambios>`  
Durante este proceso, estos conflictos pueden surgir:  

- **Conflicto de contenido:** dos ramas modificaron las mismas líneas.

- **Modificar/eliminar:** una rama modificó un archivo y la otra lo eliminó.

- **Agregar/agregar:** ambas ramas crearon un archivo con el mismo nombre.

- **Renombrar/renombrar:** ambas ramas renombraron el mismo archivo de maneras diferentes.

- **Conflicto binario:** Git no puede combinar automáticamente archivos como imágenes o ciertos archivos compilados.

- **Conflicto de estructura:** una rama trata una ruta como archivo y la otra como directorio.

Para resolver los conflictos se debe abrir los archivos afectados en un editor como VS Code, borrar las marcas de Git
(<<<<<<<, ======= y >>>>>>>) y hacer los cambios pertinentes para que el conflicto no exista más y luego se debe hacer `git add`
a todos los archivos cambiados y finalizar el merge con `git merge --continue` o `git commit`.

8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?  
**R//** El área de staging es un espacio donde Git guarda todo lo que va a ser parte
del siguiente commit, si se hacen cambios y este paso se omite, aunque se haga `git commit`,
Git no va a guardar nada en el repository ya que él busca en la staging area y la ve vacía.
Adicional a eso, Git también informará que hay cambios en archivos y dirá que se deben registrar
usando `git add`.
9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?  
**R//** El archivo .gitignore es un archivo que le dice a Git que cosas debe ignorar completamente.
Por ejemplo, si alguien tiene ese archivo y adentro escribe *.txt, Git va a ignorar todos los archivos
de texto, aunque se hagan cambios en esos archivos y el usuario ejecute `git add .` Git simplemente
no tendrá en cuenta nada de eso, como si los archivos no existieran.
10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?  
**R//** La diferencia radica en que `git commit --amend` reemplaza el commit al cual apunta la rama
por uno nuevo. Con ese comando se pueden corregir cosas faltantes en el commit o re escribir el mensaje.
Por otro lado, un nuevo commit es añadir un nuevo commit a la rama, mientras que `--amend` no cambia los
contenidos del objeto commit anterior sino que lo reemplaza completamente, un commit normal añade un nuevo objeto
completamente diferente.
11. ¿Cómo se utiliza git stash y en qué escenarios es útil?  
**R//** Se usa generalmente así `git stash push -m "<razón>"`. Es útil en situaciones en las que
se requiera descartar cambios incompletos y cambiar de rama o se necesitaba hacer un `git pull` antes pero
el desarrollador lo olvidó y ya tiene cambios, etc.
12. ¿Qué mecanismos ofrece Git para deshacer cambios (por ejemplo, git reset, git
revert, git checkout)?  
**R//**  
- **reset:** Se usa para mover los cambios en la staging area devuelta al working directory
- **revert:** Deshace un commit ya realizado añadiendo un nuevo commit que invierte los cambios del
commit dado. Por ejemplo: `git revert HEAD~3` revierte los cambios en el último cuarto commit en HEAD y
crea un nuevo commit con los cambios revertidos.
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
