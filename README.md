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
se hicieron cambios, revertirlos, etc.
2. ¿Cuáles son las tres áreas principales de Git (working directory, staging area/index y
repository) y qué papel cumple cada una?  
**R//** **Working directory:** Es donde están todos los archivos del proyecto. El usuario
escribe los cambios ahí.  
**Staging area:** Es donde Git reúne los cambios en los archivos deseados que formarán parte
del siguiente commit.
**Repository:** Es donde Git guarda los cambios en sí, es donde el historial y todos
los cambios anteriores residen en el equipo. El repository es lo que le da la habilidad al
usuario de cambiar entre versiones y guardar nuevas versiones de sus archivos.  
3. ¿Cómo representa Git los cambios internamente? (objetos blob, tree, commit y tag).  
**R//** Git almacena los cambios (y todos los datos en general) como objetos
dentro de `.git/objects`. Git genera una clave única (también llamada identificador o hash)
usando tradicionalmente el algoritmo SHA-1 aunque también existe SHA-256 para los repositorios
configurados con ese algoritmo.  
**Blob:** Siglas de Binary Large Object, representa el contenido de un archivo
excluyendo el nombre y ruta de este.  
**Tree:** Representa los directorios. Contiene los hashes de los blob o subtrees
junto con sus nombres de archivo, tipos y permisos de dichos archivos.  
**Commit:** Representa el tree raíz junto con quién hizo el commit (committer), quién escribió
los cambios en el commit (autor), cuándo (fecha) y
el porqué (mensaje), etc.  
**Tag:** Existen dos tipos:
    - **Ligeros:** Simplemente una referencia a un commit en específico.
    - **Anotados:** Referencia al commit y además de eso guarda el objeto etiquetado,
    tagger, correo, fecha y un mensaje de tagging.
4. ¿Cómo se crea un commit y qué información almacena un objeto commit?  
**R//** Primero se deben hacer cambios a los archivos deseados. Luego, se usa `git add` para mover
todos los archivos cambiados al staging area ya sea con `git add .` o `git add <nombre de archivos>`.
Posterior a ello, se crea el commit con `git commit -m "<mensaje descriptivo>"`
por ejemplo, digamos que alguien arregló un error; en ese caso, la creación del commit se vería
similar a: `git commit -m "error de memoria arreglado al..."`  
Un commit contiene la siguiente información:  
**Tree:** Hash del tree raíz.  
**Parent:** Hash o hashes de los commits anteriores.  
**Author:** Persona que originalmente escribió los cambios del commit y la fecha de autoría.  
**Committer:** Persona que creó el commit junto con la fecha de creación.  
**Mensaje:** Notas que describen los cambios del commit. Son añadidas por el committer.  
Aparte de estas cosas, los commits también guardan metadatos útiles para otras cosas (por ejemplo,
si se firma el commit con GPG este guarda los datos para ello), pero lo descrito anteriormente es lo
esencial.
5. ¿Cuál es la diferencia entre git pull y git fetch?  
**R//** La diferencia radica en que git fetch carga la información más reciente del repositorio
remoto sin actualizar los archivos locales; esto es útil para confirmar si hubo
cambios en el repositorio posteriores a la última actualización local. Por otro lado,
git pull no solo carga la información, sino que actualiza los archivos locales con la nueva información.
6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits?  
**R//** Una rama es un puntero a un commit de una línea de trabajo.
Por ejemplo, si un desarrollador quiere implementar algo en una app sin tocar el main, este
crea una nueva rama que va a apuntar al mismo commit al que apunta main, sin embargo él podrá
hacer cambios en esa nueva rama y la main seguirá apuntando a donde apuntaba originalmente
no sufrirá ningún cambio.  
Git gestiona esos punteros de esta manera: la rama apunta a un commit y dicho commit apunta
al commit que le precede y así sucesivamente hasta llegar al primer commit.
7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?  
**R//** Para realizar un merge, se debe ir a la rama que va a recibir los cambios con
`git switch <nombre-rama>` o `git checkout <nombre-rama>`, luego, se ejecuta `git merge <rama-con-cambios>`  
Durante este proceso, estos conflictos pueden surgir:  

- **Conflicto de contenido:** dos ramas modificaron las mismas líneas.

- **Modificar/eliminar:** una rama modificó un archivo y la otra lo eliminó.

- **Agregar/agregar:** ambas ramas crearon un archivo con el mismo nombre.

- **Renombrar/renombrar:** ambas ramas renombraron el mismo archivo de maneras diferentes.

- **Conflicto binario:** Git no puede combinar automáticamente archivos como imágenes o ciertos archivos compilados.

- **Conflicto de estructura:** una rama trata una ruta como archivo y la otra como directorio.

Para resolver los conflictos, se debe abrir los archivos afectados en un editor como VS Code, borrar las marcas de Git
(<<<<<<<, ======= y >>>>>>>) y hacer los cambios pertinentes para que el conflicto no exista más y luego se debe hacer `git add`
a todos los archivos cambiados y finalizar el merge con `git merge --continue` o `git commit`.

8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?  
**R//** El área de staging es un espacio donde Git guarda todo lo que va a ser parte
del siguiente commit, si se hacen cambios y este paso se omite, aunque se haga `git commit`,
Git no va a guardar nada en el repository ya que él busca en la staging area y la ve vacía.
Adicional a eso, Git también informará que hay cambios en archivos y dirá que se deben registrar
usando `git add`.
9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?  
**R//** El archivo .gitignore es un archivo que le dice a Git qué cosas no rastreadas debe ignorar completamente.
Por ejemplo, si alguien tiene ese archivo y adentro escribe *.txt, Git va a ignorar todos los archivos
de texto que Git no haya rastreado antes, aunque se hagan cambios en esos archivos y el usuario ejecute `git add .`
Git simplemente no tendrá en cuenta nada de eso, como si los archivos no existieran.
10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?  
**R//** La diferencia radica en que `git commit --amend` reemplaza el commit al cual apunta la rama
por uno nuevo. Con ese comando se pueden corregir cosas faltantes en el commit o reescribir el mensaje.
Por otro lado, un nuevo commit es añadir un nuevo commit a la rama, mientras que `--amend` no cambia los
contenidos del objeto commit anterior, sino que lo reemplaza completamente; un commit normal añade un nuevo objeto
completamente diferente.
11. ¿Cómo se utiliza git stash y en qué escenarios es útil?  
**R//** Se usa generalmente así `git stash push -m "<razón>"`. Es útil en situaciones en las que
se requiera guardar temporalmente cambios incompletos y cambiar de rama o se necesitaba hacer un `git pull` antes pero
el desarrollador lo olvidó y ya tiene cambios, etc.
12. ¿Qué mecanismos ofrece Git para deshacer cambios (por ejemplo, git reset, git
revert, git checkout)?  
**R//**  

- **reset:** Permite cambiar a qué commit apunta la rama actual. Por ejemplo, `git reset HEAD~1`
retrocede el puntero un commit, conserva los archivos modificados en el working tree y quita los
cambios de staging.
- **revert:** Deshace un commit ya realizado añadiendo un nuevo commit que invierte los cambios del
commit dado. Por ejemplo: `git revert HEAD~3` revierte los cambios en el tercer commit anterior a HEAD y
crea un nuevo commit con los cambios revertidos.
- **checkout:** Permite cambiar de rama y para restaurar una versión de un archivo con
`git checkout <commit> <nombre-archivo>` o `git checkout <nombre-archivo>`.
- **restore:** Permite restaurar archivos del working tree. Puede deshacer cambios locales de un archivo
con `git restore <nombre-archivo>` o quitarlo del staging area con `git restore --staged <nombre-archivo>`.

13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso
para gestión de forks?  
**R//** Los remotos son nombres locales asociados con URL de otro repositorio.

- **origin:** Normalmente, es el repositorio donde se clonó. Si se usa un fork, pues
es una copia del repositorio original.
- **upstream:** Usualmente representa el repositorio original del proyecto.

Estos nombres no son palabras reservadas; se pueden configurar como se deseen, por ejemplo:  
`git remote rename origin <nuevo-nombre>`.  

Suponiendo que `origin` sea un fork del repo original y `upstream` sea el repositorio original, entonces
para gestionar los forks, se hace lo siguiente:

Se clona el fork:

````bash
git clone <URL_DEL_FORK>
cd proyecto
````

Se registra el repositorio original:

````bash
git remote add upstream <URL_DEL_REPOSITORIO_ORIGINAL>
````

Se comprueba las ramas remotas:

````bash
git fetch --all
git branch -a
````

Actualiza la rama local con los cambios originales:

````bash
git switch main
git fetch upstream
git rebase upstream/main
````

También se puede utilizar merge:

````bash
git merge upstream/main
````

Publica la actualización en tu fork:

````bash
git push origin main
````

Crea una rama para tu trabajo:

````bash
git switch -c cambios
````

Después de realizar commits, se publica:

````bash
git push -u origin cambios
````

La opción -u establece la rama remota de seguimiento, por lo que posteriormente puedes usar simplemente:

````bash
git push
git pull
````

Git utiliza referencias como origin/main para representar localmente el último estado conocido de una rama remota. git push origin main envía la rama local main a la rama main del remoto origin.

14. ¿Cómo puedo inspeccionar el historial de commits (por ejemplo, git log, git
diff, git show)?  
**R//** Se puede inspeccionar el historial de commits con los siguientes comandos:

- **git log:** Muestra logs de commits en un orden cronológicamente inverso (los más recientes primero).
- **git diff:** Permite ver los cambios entre commits, commit y working tree, entre dos ramas, etc.
- **git show:** Permite ver los datos de un commit en específico.

### Programación

15. ¿Cuáles son los tipos de datos primitivos en Java?  
**R//** Los tipos de datos primitivos son tipos añadidos directamente en el lenguaje y no son objetos (como sí lo son
los no primitivos).

- **byte:** Almacena enteros desde -128 a 127.
- **short:** Almacena enteros desde -32,768 a 32,767.
- **int:** Almacena enteros desde -2,147,483,648 a 2,147,483,647.
- **long:** Almacena enteros desde -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807.
- **float:** Almacena números fraccionarios. Suficiente para guardar de 6 a 7 puntos decimales significativos.
- **double:** Almacena números fraccionarios. Suficiente para guardar de 15 a 16 puntos decimales significativos.
- **boolean:** Almacena falso (false) o verdadero (true).
- **char:** Almacena un solo carácter Unicode de 16 bits.

16. ¿Cómo funcionan las estructuras de control de flujo como if, else, switch y bucles en
Java?  
**R//**

- **Condicionales**
    - **if:** El código se ejecuta si y solo si la condición evaluada es verdadera.
    - **else if:** El código se ejecuta si la condición es verdadera y no se ejecutó un bloque
    if antes.
    - **else:** El código se ejecuta si ninguna condición evaluada se cumple.
    - **switch:** Se compara el valor de una expresión con muchos casos posibles llamados "case".
    Se ejecutará el código del case correspondiente si se rompe la ejecución con `break` al final
    de cada case. En caso de que no pase esto, se ejecutará cada case consecuente.
    Si se especifica un caso "default" entonces este se ejecutará si ningún case coincide con la expresión evaluada.

- **Repetitivas**
    - **for:** Permite repetir un bloque de código utilizando una inicialización, una condición
    y una expresión de actualización; normalmente se usa cuando se conoce o controla el número de iteraciones.
    - **while:** Se ejecuta mientras la condición dada sea verdadera. Este no maneja su iterador o
    algo por el estilo, para que la condición cambie su valor, el programa (otra parte del código) lo tiene que hacer.
    - **do while:** Se ejecuta el código deseado y luego se evalúa una condición. Si la condición no se cumple, el código
    no volverá a ejecutarse. Esto permite que sea seguro que el código adentro se ejecute al menos una vez.

17. ¿Por qué es importante usar nombres significativos para variables y métodos?  
**R//** Porque de esta manera el código se vuelve más legible y entendible para quienes lo mantienen.
Si se usaran nombres al azar o con poco sentido, arreglar errores o añadir cosas sería muy difícil, ya que no
se entendería el porqué ni el para qué de las variables.
18. ¿Qué es la Programación Orientada a Objetos (POO)?  
**R//** Es un paradigma de programación en el que se usan objetos para representar cosas del mundo real.
19. ¿Cuáles son los cuatro pilares de la Programación Orientada a Objetos?  
**R//**  
- **Herencia:** Permite que una clase reciba (herede) los atributos (características) y métodos (habilidades)
de otra clase. Por ejemplo, si se quiere representar a un lobo y a un perro, entonces las clases Perro y Lobo heredan de
Canino, ya que ambos son caninos.
- **Abstracción:** Se enfoca en mostrar las partes esenciales de un objeto, ocultando detalles complejos.
- **Polimorfismo:** Permite que un mismo método se comporte diferente según la clase que lo usa.
- **Encapsulación:** Se enfoca en proteger los datos internos de un objeto y exponer solo lo necesario, garantizando
una capa extra de control y protección.

20. ¿Qué es la herencia en POO y cómo se utiliza en Java?
**R//** La herencia permite que una clase herede los atributos y métodos de una clase padre. En Java, para que una clase herede
de otra, se debe usar la palabra `extends` e indicar el nombre de la clase de la cual va a heredar. Siguiendo el ejemplo
de la pregunta anterior, en Java se vería así:

```` java
// Clase base (Padre)
class Canino {
    String especie;

    public void emitirSonido() {
        System.out.println("El canino hace un sonido.");
    }
}

// Clase derivada (Hijo) que hereda de Canino
class Perro extends Canino {
    public void emitirSonido() {
        System.out.println("El perro ladra: ¡Guau, guau!");
    }
    
    public void moverCola() {
        System.out.println("El perro mueve la cola porque está feliz.");
    }
}

// Clase derivada (Hijo) que hereda de Canino
class Lobo extends Canino {
    public void emitirSonido() {
        System.out.println("El lobo aúlla: ¡Auuu!");
    }
    
    public void cazarEnManada() {
        System.out.println("El lobo se organiza con su manada para cazar.");
    }
}
````

21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java?  
**R//** Los modificadores de acceso son palabras reservadas que modifican la visibilidad y el nivel de acceso
a clases, métodos, variables y demás dentro del código. Estos modificadores son la base para la implementación
del encapsulamiento en Java. Los modificadores de acceso son:
- **package-private:** Sin palabra reservada, es el que tienen si no se especifica algún modificador.
El acceso queda limitado al mismo paquete; cualquier cosa fuera del paquete no podrá acceder a ello.
- **public:** El acceso está disponible en todo el código, sin importar en qué paquete se esté.
- **private:** El elemento solo es accesible dentro de la misma clase en la que se declara.
- **protected:** Permite el acceso desde el mismo paquete y clases hijas de la clase en la que se definió el elemento
(incluso si las clases hijas no son del mismo paquete).

22. ¿Qué es una variable de entorno y por qué son importantes para Java o la
programación en general?  
**R//** Una variable de entorno es un valor con nombre dinámico en el equipo que puede influir en el
comportamiento de procesos en ejecución.  
Las variables de entorno son muy importantes para la programación en general ya que permiten almacenar datos
sensibles de manera local en el equipo sin que esté directamente en el código fuente. Un caso en el que esto es muy útil
es al momento de tener un proyecto open source en GitHub que use una API key; en este caso no se puede poner la API key directamente
en el código o todo el mundo podría usarla y, dado que es open source, no tendría caso poner privado el repositorio. Al tener
una variable de entorno, el código puede leer la API key sin que esté directamente escrita ahí.

## Parte práctica

1. Crear un programa que utilice estructuras de control para resolver un problema
sencillo, como una calculadora básica que realice operaciones de suma, resta,
multiplicación y división.  
**R//** La solución a este punto está en el archivo [Calculadora.java](Calculadora.java).
2. Escribir un programa que cuente el número de vocales y consonantes en una
palabra. La palabra no contendrá símbolos, caracteres especiales, acentos, ni
números y siempre estará en minúsculas.  
**R//** La solución a este punto está en el archivo [Contador.java](Contador.java).
3. Escribir un programa que invierta una cadena de texto ingresada por el usuario.  
**R//** La solución a este punto está en el archivo [Invertidor.java](Invertidor.java).
