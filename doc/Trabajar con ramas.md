# Trabajar con ramas

### Crear una rama

Para crear una rama debemos utilizar el comando:

`$ git branch NOMBRE_RAMA`

### Pasar de una rama a otra

`$ git checkout NOMBRE_RAMA`

> Para crear una rama y directamente pasar a ella podemos utilizar: `$ git checkout -b NOMBRE_RAMA`

### Comprobar si se ha creado una rama

`$ git branch`

La rama que tenga un * es en la que estamos actualmente.

Si queremos ver todas las ramas, incluso las ocultas:

`$ git branch -a`

### Subir una rama al servidor

De esta forma estará disponible para que otros puedan acceder a ella

`$ git push origin NOMBRE_RAMA`

Una vez esté subida si hacemos `$ git branch -a` nos aparecerá la rama oculta remotes/origin/NOMBRE_RAMA.

### Subir un cambio de una rama al servidor

El commit se reaizará de forma normal y el push sería:

`$ git push origin NOMBRE_RAMA`

### Realizar un merge

Nos situaremos en la rama master:

`$ git checkout master`

Y ponemos el siguiente comando:

`$ git merge NOMBRE_RAMA master --no-ff`

Ponemos el flag no-ff para que exista un commit que indique que se ha realizado el merge.

### Borrar una rama en el servidor

`$ git push origin :NOMBRE_RAMA`

### Borrar rama en local

`$ git branch -d NOMBRE_RAMA`

### Actualizar rama con los cambios subidos en el master

`$ git pull origin master --rebase`