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

	> [ ] Cuando se introduzca un usuario y contraseña incorrecto deberá mostrar una notificación.
	>
	> [ ] El nombre de usuario debe tener una longitud mayor de tres caracteres.

## Incremento

Un incremento es toda aquella petición de cambio que no viene derivado de un fallo sino que se produce como mejora en el software. En caso de querer realizar/proponer un incremento debemos:

1. Abrir una *issue*.
2. Poner un título descriptivo.
3. Realizar una descripción lo más detallada posible del incremento. En caso de no disponer de toda la información disponible en el momento de abrir la *issue* se deberá escribir en los **comentarios** de la misma los detalles del cambio conforme se vayan sabiendo.
4. Añadir la etiqueta **INCREMENTAL**.

## Proceso de actuación ante una incidencia para un miembro de decide-europa-cabina

**A partir de ahora cuando hablemos de incidencia nos referiremos también a un incremento.**

Un miembro de decide-europa-cabina puede reportar y solucionar él mismo una incidencia sin necesidad de actuación del *coordinador de issues*, Alejandro Santos Montaño, esta figura solo aparecerá cuando comience el proceso de revisión. A los pasos anteriormente descritos en los apartados **Incidencia** e **Incremento**, se añaden:

1. Determinar la prioridad que tendrá la incidencia (las etiquetas son explicadas en el siguiente apartado)
2. Añadir otra etiqueta en la que se indique el estado de la misma (explicadas en el siguiente apartado)
3. Se arreglará el fallo, siempre teniendo en cuenta el procedimiento descrito en los documentos *Estrategia de ramas* y *Política de commits*.
4. Una vez arreglado el fallo se añadirá un comentario avisando al coordinador para que este asigne a dos personas que se encargan de revisar, esto será, por supuesto, en caso de que no estén ya asignadas. En cualquier caso, el coordinador añadirá un comentario donde mencione (utilizando @) a los dos revisores, siguiendo el siguiente formato:

	> Los revisores de esta incidencia serán @usuario1 y @usuario2 

5. En caso de que los revisores encuentren problemas será arreglado por el encargado de la incidencia y en caso de que todo esté correcto procederá esta persona a realizar un *merge* desde la rama donde se realizaron los cambios a la *master*.

## Proceso de actuación para el coordinador de *issues* de decide-europa-cabina

**A partir de ahora cuando hablemos de incidencia nos referiremos también a un incremento.**

Si un miembro externo al equipo de decide-europa-cabina reporta una incidencia será Carlos Ortiz Prieto, como coordinador del grupo, quien escribirá dicha incidencia *issue* y avisará en los comentarios al ***coordinador de issues*** del equipo decide-europa-cabina: **Alejandro Santos Montaño**, para que estudie la incidencia. Este último deberá:

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
3. Asignar la incidencia en el apartado *Assignees* a una persona encargada de arreglarla y otras dos personas para el proceso de revisión. El coordinador añadirá un comentario donde mencione (utilizando @) a los dos revisores, siguiendo el siguiente formato:

	> Los revisores de esta incidencia serán @usuario1 y @usuario2 
	
4. Si el encargado de resolver una *issue* le solicita que le asigne revisores a su *issue*, porque aún no los tiene, el coordinador deberá añadir las personas que crea disponibles y capacitadas para llevar a cabo la revisión.
	
5. En caso de que el proceso para resolver la incidencia no se realice de forma inmediata se puede asignar dicha incidencia a un **milestone** concreto.

**Además, el coordinador deberá controlar que la persona encargada de resolver las incidencias y de revisarla hagan el trabajo.**

### Posibles problemas
Si la **incidencia** reportada está ya **duplicada**, el coordinador pondrá un **comentario** donde se **referencie** a la **incidencia original** y se **cerrará la duplicada**. 

En caso de que la incidencia haya sido reportada por un miembro externo, y **no aporte la información suficiente**, el coordinador o el encargado de resolverla podrá decidir **rechazarla** y cerrarla o **pedir más información** a Carlos Ortiz Prieto a través del sistema de comentarios.

## Proceso de actuación de los revisores

Un revisor será el encargado de comprobar las siguientes cosas:

1. **Que esté completo**: se considerará completo cuando estén implementados todos los cambios que se reflejen en la *issue* asociado a la rama.
2. **Que sea estable**: se considerará estable cuando tengan al menos tres pruebas unitarias que corroboren que lo realizado no produzca ningún fallo. En caso más particulares que no permitan realizar pruebas unitarias, como cambios de diseño, validaciones en el front-end, etc, deberá cumplir un *checklist* reflejado en la *issue*. Esto será así solamente en los cambios que tengan sentido, dado que un cambio de documentación, de configuracion, etc, puede no servir estos métodos y simplemente usar comprobaciones manuales.

El procedimiento de revisión será el siguiente:

1. El revisor utilizando los comandos descritos en el documento *Trabajando con ramas* se descargará la rama con los cambios.
2. Realizará distintas pruebas para asegurar la integridad del sistema mediante la ejecución de las pruebas unitarias y realizando de forma manual comprobaciones usando la interfaz de la web.
3. En caso de que el encargado del cambio haya realizado las pruebas unitarias se revisarán y ejecutarán, si se ha realizado un *checklist* se comprobará cada punto del mismo.
4. Si surgen dudas sobre la implementación se puede preguntar al encargado utilizando los comentarios de *issue*.
5. Si se observan fallos, el revisor puede considerar que es un fallo en el que merece la pena se puede crear una *issue* hija como se describe en el apartado "*Issues* anidadas" en la que prosiga la discusión sobre ese fallo en concreto. En caso contrario, puede reportar los fallos en los comentarios de la *issue* tratando siempre de ser lo más detallado posible.
6. En caso de un incremento, si el encargado de realizarla ha realizado *issues* anidadas, el revisor también deberá comprobar las mismas sin necesidad de que se les asigne en la *issue* hija.
6. En caso de no observar ningún tipo de fallo se añadirá un comentario especificando que todo está correcto por parte del revisor.

## *Issues* anidadas

Durante el proceso de realización de incrementos significativos (desarrollo de un módulo de votación con gran carga lógica) o durante el proceso de revisión se pueden crear *issues* derivadas de la *issue* principal. En ambos casos se pondrá un comentario en la *issue* padre en el que diga:

>Se tratará el siguiente problema ****describe el problema en lineas muy generales**** en la issue #ID\_ISSUE_HIJA

**Cabe destacar que los cambios de esa *issue* anidada se pueden realizar en la rama de la *issue* padre sin necesidad de que crear una nueva rama**

Dos casos:

### *Issues* derivadas del proceso de revisión

En caso de que a raiz del proceso de revisión del cambio en una *issue* se observen otros fallos, el revisor puede considerar si la magnitud del fallo (porque pueda producir muchos comentarios y no tiene una estricta relación con la *issue* que se está tratando) merece la pena abrir una nueva *issue* derivada de la que está revisando. Esto se realizará con el objetivo de no emborronar los comentarios de una *issue* que debe mantenerse legible.

En la *issue* hija creada por el revisor se asignará en el apartado *Asignees* al encargado de resolver la *issue* padre y a él mismo y deberá seguir los pasos indicados en el apartado **Incidencias** de este documento.

### Grandes *issues*

El programador Juan Molina tiene una *issue* donde está programando un framework JavaScript para manejar el front-end de la aplicación. Dado que es una incidencia que conllevará cierta cantidad de commits, se pueden crear *issues* hijas en las cuales se realicen ciertos cambios.

Por ejemplo Juan, podría tener su *issue*: 
> Crear framework para el front-end de la web

Y sus hijas: 
> Enrutador del framework
> 
> Uso de plantillas

Los revisores de las *issues* de incremento que se deriven en otras *issues*, tal y como se explica en este apartado, deberán también revisar esas *issues* derivadas.

## Proceso de actuación para el encargado de resolver la *issue*

1.  En caso de ser necesario, el encargado de resolver la *issue* puede requerir información al creador de la misma mencionándolo utilizando el @.
2. La persona encargada de resolver la incidencia, primero deberá cambiar la etiqueta de **ACCEPTED** a **IN PROGRESS**, si no lo está todavía.
3. Cuando la incidencia esté arreglada, se subirá la solución al repositorio en la rama correspondiente descrito en el documento *Estrategia de gestión de ramas*.
4. Cada vez que se quiera que los revisores comprueben algo se avisará a los mismos mencionandolos en un comentario o se avisará al coordinador (usando los comentarios) para que los asigne si aún no lo están, indicando que esta *issue* está lista para el proceso de revisión o la *issue* hija o cualquier parte que quieres que comprueben, también se puede especificar si no se quiere que comprueben algo o advertencias.
5. Durante el proceso de revisión, cada vez que los revisores mencionen un fallo que debas cambiar, al subir ese cambio deberás avisarlos diciendo que ya está arreglado el fallo que menciona @revisor1.
6. Una vez completado el proceso de revisión, si la incidencia fue creada por un miembro externo, se mencionara a este miembro para que compruebe si realmente el cambio realizado cumple con lo esperado. Si el usuario no reporta ningún otro fallo y está de acuerdo con la solución ofrecida, el encargado procederá a cerrar la incidencia, cambiar la etiqueta a **COMPLETE** y a realizar un *merge* al *master*.

**Toda incidencia creada por un miembro externo y resuelta por un encargado, si no recibe una nueva respuesta por parte del usuario en un plazo de 10 días, será cerrada.**

### En caso de *issue* cerrada

1. Si una persona, o el mismo encargado de la *issue*, encuentra un fallo relacionado con una *issue* ya cerrada **puede volver a abrir la issue** escribiendo un comentario que guarde una estructura similar a lo comentado en el apartado **Incidencia** del presente documento para describir el fallo encontrado o con un simple comentario puede valer mientras sea descriptivo ya que consideramos que la información más importante acerca del error es la misma que la que viene en la descripción de la *issue*.

2. El encargado de resolver esa *issue* deberá atender el problema y crear de nuevo la rama, en caso de que ya se encuentre eliminada, para solucionar el problema. Una vez solucionado, volverá a avisar a los revisores utilizando el sistema de comentarios para iniciar el proceso de revisión.