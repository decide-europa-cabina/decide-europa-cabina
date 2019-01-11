# Interfaz para la votaci�n de Decide en Telegram

Bot creado por el grupo 15 de EGC.

`Ruta del bot` : <https://t.me/decide_europa_cabina_bot>

### Requisitos
Si tiene instalado pip3:

```pip3 install python-telegram-bot```

Si tiene problemas con el comando anterior:

```python3 -m pip install python-telegram-bot```

Si no tiene instalado pip3:

```sudo apt update && sudo apt install python3-pip -y```

### Inicializaci�n
Para iniciar el bot:
```sh
$ cd decide-cabina-telegram
$ python3 decide_bot.py
```
### Personalizaci�n
`BotFather`  : <https://telegram.me/botfather>

Para la personalizaci�n hemos hecho uso de BotFather, un bot creado por Telegram desde el que hacemos uso de la API para crear el bot, a�adirle un nombre, una descripci�n, un icono, una secci�n About y la barra r�pida de comandos.

### Implementaci�n

`Telegram Bot API` : <https://core.telegram.org/bots/api>

Para la implementaci�n hemos hecho uso de python-telegram-bot, una API que nos facilita la comunicaci�n con el bot creado a trav�s de la clave token generada y nos ofrece gran variedad de comandos diferentes.

### Comandos disponibles
- ```/start``` : Ventana de bienvenida con las opciones disponibles.
- ```/help``` : Ayuda para el uso del bot.
- ```/login``` - {usuario} {contrase�a} : Iniciar sesi�n.
- ```/logout``` : Cerrar la sesi�n actual.
- ```voting``` - Muestra las votaciones disponibles.
- ```question``` - {id_votaci�n} - Muestra las respuestas de la votaci�n.
- ```vote``` - {id_respuesta} - Vota la respuesta elegida.