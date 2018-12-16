# Política de *commits*

## ¿Cuándo puedo hacer un *commit*?
Un *commit* se lleva a cabo cada vez que exista un cambio lógico. Se debe diferenciar entre un cambio para resolver un error, el cual será marcado como **SOL**, al principio del título, y un cambio que introduce un incremento que será marcado como **INC**. Existe un caso especial, en el caso de que querramos subir documentación, sin que esté relacionado con ninguna *isssue* en el que pondremos **DOC**.

Se considera un cambio lógico:

* Todos los cambios necesarios para solucionar un error.
* Añadir/Modificar/Borrar la estructura base de una clase.
* Añadir/Modificar/Borrar un método o varios, siempre y cuando estos estén totalmente relacionados y en caso de separarse no ofrezcan ninguna funcionalidad.

## ¿Cómo hago un *commit*?

Para realizar un *commit*, se debe emplear la siguiente estructura:

* Primera línea (Título):
	* SOL ó INC CABINA
	* Establecer el issue al que está asociado el commit.
	* Título que identifica el cambio realizado como máximo entre 80 y 100 caracteres.
* Línea en blanco
* Descripción:
	* Establecer la causa del cambio.
	* Describir el comportamiento del código antes de realizar el cambio.
	* Describir el comportamiento del código después de realizar el cambio.

#### Caso especial

En caso de subir un documento que no esté relacionado con una *issue* solo se pondrá *DOC* junto con el nombre del documento en el título y una breve descripción del mismo en la descripción.

### Ejemplo

![](https://i.imgur.com/6N1bWOe.png)

SOL CABINA #1 – Arreglo en el mensaje que se imprime por pantalla, se contradecía con la condición.

*Línea en blanco*

Causa: Corrección del mensaje que imprimía por pantalla “menor que cero” cuando el condicional era “num > 0”

Antes del cambio: El mensaje de error indicaba que era “menor que cero”, cuando se cumplía la condición “num > 0” 

Después del cambio: El mensaje de error indica que es “mayor que cero”, si la condición “num > 0” se cumple.
