# Estrategia de ramas

En este documento definiremos el “usage model” de la/s herramienta/s que vamos a utilizar y trataremos de responder las preguntas sobre cómo se gestionan las ramas, qué permisos se dan a los usuarios, cómo se hacen los merge, con qué frecuencia, por qué motivos se crean las ramas, cómo se eliminan, entre muchas otras.

Las ramas tienen una importancia clave en la gestión del código fuente de un proyecto dado que nos permite llevar una línea de desarrollo independiente que comparte parte de historia común con la rama padre. 

Nuestra motivación para crear ramas es por motivos **funcionales** dado que crearemos **una rama cada vez que queramos realizar un cambio funcional o de corrección**. Los cambios surgirán de las *issues* que se añadan en el proyecto, de forma que las ramas creadas para realizar los cambios deberán tener su nombre en snake case uppercase de la siguiente forma: **NOMBRE\_DESCRIPTIVO\_#IDISSUE**. Por ejemplo, dado la siguiente issue:

![](https://i.imgur.com/7xWBEvl.png)

> **IMPORTANTE**: La incidencia descrita en esta imagen no supone un modelo, para futuras incidencia se deberá seguir el manual denominado: *Proceso de gestión de incidencias*.

1. Crearemos un *branch* de nombre: **FALLO\_DISEÑO\_VOTACIÓN\_#2**. 
2. Crearemos una rama en local y la subiremos al servidor según los pasos definidos en el documento 'Trabajando con ramas' dentro de la carpeta doc del repositorio.

### Consideraciones a tener en cuenta

En caso de tener que subir cambios referentes a **documentación** o **archivos de configuración** de servicios como TravisCI, Heroku, etc, **NO** será necesario realizar una rama.

Si otro desarrollador también quiere usar dicha rama en su repositorio local o quiere introducir los cambios de una rama en el master se denomina merge debe seguir lo descrito en el documento 'Trabajando con ramas' dentro de la carpeta doc del repositorio.

Una vez se hayan terminado los cambios de una *issue* deberán pasar a la rama master de forma que quede disponible para todos.

Es importante remarcar que la **rama master** debe ser totalmente **estable** por lo que hay que tener especial cuidado al meter los cambios realizados en una rama. Los cambios realizados en una rama se considerará completo cuando estén implementados todos los cambios que se reflejen en la *issue* asociado a una rama y además será estable cuando tengan al menos tres pruebas unitarias que corroboren que lo realizado no produzca ningún fallo. Esto será así solamente en los cambios que tengan sentido, dado que un cambio de documentación o visual no tiene esa necesidad.



Hay que tener mucho cuidado cuando se produzcan conflictos dado que es un momento delicado en el que git pedirá la intervención manual del desarrollador para saber cómo solucionarlo. En caso de poder, se ruega que se resuelva entre l@s dos responsables del conflicto.