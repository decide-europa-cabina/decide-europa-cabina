# Proceso de gestión de incidencias

Este documento presenta un protocolo de actuación tanto para incidencias como para peticiones de cambios. La gestión de incidencias será llevada acabado con Github, en la pestaña *[Issues](https://github.com/decide-europa-cabina/decide-europa-cabina/issues)* del repositorio [decide-europa-cabina](https://github.com/decide-europa-cabina/decide-europa-cabina).

## Incidencia

Explicaremos este proceso mediante un ejemplo: hemos encontrado un fallo a la hora de votar con respuestas dicotómicas, en la que al pulsar en la primera opción envia al servidor la segunda.

1. Abrir una *issue*.
2. Poner un título descriptivo.
> Error en las votaciones con respuesta dicotómicas.

3. Rellenar la descripción con los siguientes apartados:
	1. **Breve descripción**: en la que se describa en una o dos lineas el error que hemos encontrado.
	2. **Pasos para reproducir la incidencia**: serie de pasos explicitamente definidos para llegar al fallo.
	3. **Salida obtenida / Salida esperada**: de forma breve se explicará cuál es la salida que obtenemos al realizar los pasos del anterior apartado y cual es la salida que en realida deberíamos esperar.
	4. **Información adicional**: en este apartado se añadirá cualquier información adicional que pueda ser de ayuda como versión del producto utilizado, sistema operativo, navegador, dispositivo, 
	
	> #### Breve descripción
	> Tras crear una votación con preguntas que tengan dos respuestas (dicotómicas), al seleccionar la repuesta 1, el sistema guarda mi respuesta como si hubiera escogido la segunda opción.
	> #### Pasos para reproducir la incidencia
	> 1. Crear votación con preguntas que tengan dos respuestas
	> 2. Ir a la pagína de la votación
	> 3. Seleccionar una opción
	> 4. Votar
	>
	> #### Salida obtenida / Salida esperada
	> Marca que he votado la opción 2, cuando en realidad debería guardar mi respuesta como la opción 1.
	> #### Información adicional
	> Utilizo la versión x.x.x de decide-europa-cabina en un MacBook Pro con la versión 10.13.3 de macOS.

4. Añadiremos una **etiqueta** en la que se indique el tipo de incidencia, estas pueden ser:
	1. **LOGIC ERROR**: es aquel que supone una anomalía en la lógica espera del software.
	2. **DESIGN ERROR**: cuando el diseño tiene inconsistencias o existen fallos de visualización en las vistas.
	3. **TYPO**: faltas de ortografía en la redacción en cualquiera de los textos del software.
	4. **SECURITY FAILURE**: aquel fallo que nos permite acceder a zonas restringuidas o realizar acciones limitadas sin los permisos necesarios.

	> En nuestro caso le añadiremos la etiqueta **LOGIC ERROR**.
	
5. En caso de que sea un cambio en la vista, se deberá escribir de la forma más detallada posible un *check list* que reuna una serie de premisas que debe cumplir el cambio. Por ejemplo, si la *issue* trata de un cambio en la validación del formulario para iniciar sesión, el *check list* deberá ser algo así:

	> [ ] Cuando se introduzca un usuario y contraseña incorrecto deberá una notificación.
	>
	> [ ] El nombre de usuario debe tener una longitud mayor de tres caracteres.

## Incremento

Un incremento es toda aquella petición de cambio que no viene derivado de un fallo sino que se produce como mejora en el software. En caso de querer realizar/proponer un incremento debemos:

1. Abrir una *issue*.
2. Poner un título descriptivo.
3. Realizar una descripción lo más detallada posible del incremento. En caso de no disponer de toda la información disponible en el momento de abrir la *issue* se deberá escribir en los **comentarios** de la misma los detalles del cambio conforme se vayan sabiendo.

## Proceso de actuación para el coordinador de *issue* de decide-europa-cabina

**A partir de ahora cuando hablemos de incidencia nos referiremos también a un incremento.**

Una vez reportada la incidencia, si esta fue reportada por un miembro externo al equipo decide-europa-cabina, deberá ser el ***coordinador de issues*** del equipo decide-europa-cabina: **Alejandro Santos Montaño** quien estudie la incidencia. Deberá:

1. Determinar la prioridad que tendrá la incidencia, y se le añadirá una etiqueta: 
	1. **CRITICAL**: usualmente se añadirá cuando sea un error, el cual debe ser resuelto de forma inmediata pues afecta de forma directa a los usuario de *decide*.
	2. **HIGH**: incidencia relevante que paraliza en parte el progreso del equipo.
	3. **MEDIUM**: incidencia con cierta urgencia sin que esta sea bloqueante.
	4. **LOW**: no existe ninguna prisa para resolver la incidencia dado que es irrelevante.
2. Añadir otra etiqueta en la que se indique el estado de la misma: 
	1. **INVALID**: la incidencia abierta no cumple con el cometido del equipo de cabina de decide-europa.
	2. **DENIED**: el equipo no va a proceder a realizar esa incidencia.
	3. **ACCEPTED**: la incidencia tiene toda la información necesaria.
	4. **DUPLICATED**: la incidencia ya ha sido reportada/propuesta.
	5. **IN PROGRESS**: la resolución de la incidencia está en progreso.
	6. **COMPLETE**: la incidencia ha sido resuelta de forma exitosa.
3. Asignar la incidencia a, como mínimo, dos personas de los miembros del equipo de decide-europa-cabina en el apartado *Assignees*.
4. En caso de que el proceso para resolver la incidencia no se realice de forma inmediata se puede asignar dicha incidencia a un **milestone** concreto.

**Además, el coordinador deberá controlar que las personas encargadas de resolver las incidencias hagan el trabajo.**

### Posibles problemas
Si la **incidencia** reportada está ya **duplicada**, se pondrá un **comentario** donde se **referencie** a la **incidencia original** y se **cerrará la duplicada**. 

En caso de que la incidencia haya sido descrita por un miembro externo y **no aporte la información suficiente**, el coordinador podrá decidir **rechazarla** y cerrarla o **pedir más información** al usuario a través del sistema de comentarios.

### Anotaciones

En caso de que la incidencia sea añadida por un miembro del equipo no tendrá por qué necesariamente esperar al coordinador para añadir las etiquetas. Esto se hará así para aumentar la velocidad del proceso de gestión de incidencias en caso de que no sea necesaria una intervención directa del coordinador. Estos casos serán cuando sea un fallo breve que deba quedar reflejado como *issue* pero no necesite un largo proceso de cambio o cuando sea un fallo crítico que requiera una actuación inmedieta, o en el caso de un incremento que sea algo que el miembro del equipo vaya a ser sin necesidad de que el coordinador de las *issues* le esté indicando las etiquetas.

En caso de realizarse un incremento, el coordinador de las *issues* deberá asignarle, como mínimo, a dos personas la revisión de dicho incremento. Estas personas encargadas deberán comprobar que el incremento cumpla con cada una de las funciones que describe la *issue* y además que no cree ningún otro conflico, esto es, ejecutando las pruebas unitarias del proyecto.

## Proceso de actuación para el encargado de resolver la *issue*

1.  La persona encargada de resolver la incidencia, primero deberá cambiar la etiqueta de **ACCEPTED** a **IN PROGRESS**, si no lo está todavía, de esta forma no habrá dos personas trabajando en una misma incidencia.
2. Cuando la incidencia esté arreglada, se subirá la solución al repositorio en la rama correspondiente descrito en el documento de estrategia de gestión de ramas.
3. hj
4. Si la incidencia fue creada por un miembro externo, se mencionara a este miembro para que compruebe si realmente el cambio realizado cumple con lo esperado. Si el usuario no reporta ningún otro fallo y está de acuerdo con la solución ofrecida, el encargado procederá a cerrar la incidencia y a cambiar la etiqueta a **COMPLETE**.

**Toda incidencia creada por un miembro externo y resuelta por un encargado, si no recibe una nueva respuesta por parte del usuario en un plazo de 10 días, será cerrada.**
