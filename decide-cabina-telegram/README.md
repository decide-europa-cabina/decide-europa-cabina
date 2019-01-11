# Interfaz para la votación de Decide en Telegram

Bot creado por el grupo 15 de EGC.

`Ruta del bot` : <https://t.me/decide_europa_cabina_bot>

### Requisitos
Si tiene instalado pip3:

```pip3 install python-telegram-bot```

Si tiene problemas con el comando anterior:

```python3 -m pip install python-telegram-bot```

Si no tiene instalado pip3:

```sudo apt update && sudo apt install python3-pip -y```

### Inicialización
Para iniciar el bot:
```sh
$ cd decide-cabina-telegram
$ python3 decide_bot.py
```
### Personalización
`BotFather`  : <https://telegram.me/botfather>

Para la personalización hemos hecho uso de BotFather, un bot creado por Telegram desde el que hacemos uso de la API para crear el bot, añadirle un nombre, una descripción, un icono, una sección About y la barra rápida de comandos.

### Implementación

`Telegram Bot API` : <https://core.telegram.org/bots/api>

Para la implementación hemos hecho uso de python-telegram-bot, una API que nos facilita la comunicación con el bot creado a través de la clave token generada y nos ofrece gran variedad de comandos diferentes.

### Comandos disponibles
- ```/start``` : Ventana de bienvenida con las opciones disponibles.
- ```/help``` : Ayuda para el uso del bot.
- ```/login``` - {usuario} {contraseña} : Iniciar sesión.
- ```/logout``` : Cerrar la sesión actual.
- ```voting``` - Muestra las votaciones disponibles.
- ```question``` - {id_votación} - Muestra las respuestas de la votación.
- ```vote``` - {id_respuesta} - Vota la respuesta elegida.