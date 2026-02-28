# Programacion\_III\_Queue-de-canciones


# Queue Music Simulator (FIFO)

Proyecto académico que simula un sistema tipo Spotify utilizando una estructura de datos \*\*Cola (FIFO)\*\* implementada completamente desde cero en Java, guiado por el código fuente compartido en clase.

Autor: Mario David Tereta Sapalun

0905-15-14297

Curso: Programación III

Semestre: 5to

# Explicación del diseño

El proyecto está dividido en dos módulos Maven:

- Librería de estructura de datos - /umg.edu.gt.data-structure.queue

- Aplicación consumidora (simulación de reproducción) - /queueHandler

## Estructura del Repositorio

/umg.edu.gt.data-structure.queue

/queueHandler

/README.md

/evidencias


## Parte A — Librería de Cola Manual


Proyecto:

umg.edu.gt.data-structure.queue


### Características


- Implementación genérica `QueueLinked<T>`

- Clase interna `Node<T>`

- Referencias privadas `head` y `tail`

- Variable interna `size`

- Encapsulamiento correcto

- Sin uso de `Queue`, `LinkedList`, `ArrayDeque`

- Sin uso de estructuras del JDK

## Complejidad

| Método     | Complejidad |

|------------|------------|

| enqueue()  | O(1)       |

| dequeue()  | O(1)       |

| peek()     | O(1)       |

| size()     | O(1)       |

La inserción y eliminación son O(1) porque se utilizan referencias directas a `head` y `tail`, evitando recorrer la lista.

# Cómo compilar e instalar la librería

Desde la carpeta del proyecto:

mvn clean install

Esto instala el `.jar` en el repositorio local de Maven (`~/.m2`).

# Simulación de Reproducción

Proyecto:

queueHandler

## Modelo Song

La clase `Song` contiene:

- `title`

- `artist`

- `duration` (entre 5 y 30 segundos)

- `priority` (1 = alta, 2 = normal)
Incluye validaciones para evitar datos inválidos.

## Simulación Realista

- Reproducción segundo a segundo

- Uso de `Thread.sleep(1000)`

- Logs detallados en consola

- Mensajes:

&nbsp; - `\[LOG] Starting playlist...`

&nbsp; - `\[LOG] Now playing:`

&nbsp; - `\[LOG] Playing:`

&nbsp; - `\[LOG] Finished:`

&nbsp; - `\[LOG] Playlist finished.`

# Sistema de Prioridad

Se implementó prioridad usando \*\*dos colas internas\*\*:

- Cola Alta Prioridad

- Cola Prioridad Normal

### Lógica:

1\. Siempre se atiende primero la cola de prioridad alta.

2\. Cuando la cola alta está vacía, se atiende la normal.

3\. Dentro de cada cola se respeta FIFO.

### Justificación técnica

Se utilizan dos colas para:

- Mantener prioridad global

- Mantener orden FIFO interno

- Evitar uso de `PriorityQueue`

- No romper la estructura original

# Extensiones Implementadas

Se implementaron dos mejoras obligatorias:

## Historial de reproducción

Se utiliza una tercera cola para almacenar las canciones en el orden exacto en que fueron reproducidas.

Se mantiene FIFO del historial.

Complejidad para mostrar historial: O(n).

\## Contador y tiempo total acumulado

Se implementaron variables internas:

- `totalSongsPlayed`

- `totalTimePlayed`

Permiten mostrar estadísticas finales al terminar la playlist.

# Decisiones Técnicas

- Se utilizó una implementación manual de cola basada en nodos enlazados.

- No se utilizaron estructuras del JDK.

- Se respetó encapsulamiento.

- Se utilizó arquitectura modular Maven.

- Se mantuvo separación de responsabilidades:

&nbsp; - `Song` → modelo

&nbsp; - `PlaylistManager` → lógica

&nbsp; - `Main` → ejecución

#  Cómo ejecutar la consola

Desde la carpeta `queueHandler`:

mvn clean compile

mvn exec:java "-Dexec.mainClass=umg.edu.gt.queueHandler.Main"

En el caso de Eclipse, se ejecuta desde Main.java de queueHandler.Main

# Conclusión finales

El proyecto demuestra:

- Implementación manual de estructura de datos

- Análisis de complejidad

- Diseño modular

- Manejo de prioridades

- Simulación realista de reproducción

- Manipulación segura de estructuras sin romper encapsulamiento
