# Estrategia de ramas

En este documento definiremos el “usage model” de la/s herramienta/s que vamos a utilizar y trataremos de responder las preguntas sobre cómo se gestionan las ramas, qué permisos se dan a los usuarios, cómo se hacen los merge, con qué frecuencia, por qué motivos se crean las ramas, cómo se eliminan, entre muchas otras.

Las ramas tienen una importancia clave en la gestión del código fuente de un proyecto dado que nos permite llevar una línea de desarrollo independiente que comparte parte de historia común con la rama padre. 

Nuestra motivación para crear ramas es por motivos **funcionales** dado que crearemos **una rama cada vez que queramos realizar un cambio funcional o de corrección**. Los cambios surgirán de las *issues* que se añadan en el proyecto, de forma que las ramas creadas para realizar los cambios deberán tener su nombre en snake case uppercase de la siguiente forma: **NOMBRE\_DESCRIPTIVO\_#IDISSUE**. Por ejemplo, dado la siguiente issue:

![](https://i.imgur.com/7xWBEvl.png)

> **IMPORTANTE**: La incidencia descrita en esta imagen no supone un modelo, para futuras incidencia se deberá seguir el manual denominado: *Proceso de gestión de incidencias*.

1. Crearemos un *branch* de nombre: **FALLO\_DISEÑO\_VOTACIÓN\_#2** 
2. Subimos la rama al repositorio (esto no se tiene por qué dar de forma inmediata, el encargado de resolver la *issue* decidirá cuando realizar este paso, siempre antes del proceso de revisión)
3. Realizaremos los cambios necesarios en esta rama.

Todo ello siguiendo los comandos definidos en el documento [Trabajando con ramas](https://github.com/decide-europa-cabina/decide-europa-cabina/wiki/Trabajar-con-ramas)

### Consideraciones a tener en cuenta

En caso de tener que subir cambios referentes a **documentación** o **archivos de configuración** de servicios como TravisCI, Heroku, etc, que no tengan una *issue* asociada **NO** será necesario realizar una rama.

Una vez se hayan terminado los cambios de una *issue* deberán pasar a la rama master de forma que quede disponible para todos. Es importante remarcar que la **rama master** debe ser totalmente **estable** y **completa** por lo que hay que tener especial cuidado al meter los cambios realizados en una rama. Según lo descrito en el documento *Proceso de gestión de incidencias* será **estable** y **completa** cuando haya acabado el proceso de revisión.

Hay que tener mucho cuidado cuando se produzcan conflictos dado que es un momento delicado en el que git pedirá la intervención manual del desarrollador para saber cómo solucionarlo. En caso de poder, **se ruega que se resuelva entre l@s dos responsables del conflicto**.