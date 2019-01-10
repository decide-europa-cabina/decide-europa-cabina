# Interfaz para la votación de Decide en Telegram.

Bot creado por el grupo 15 de EGC.

Ruta del bot: https://t.me/decide_europa_cabina_bot

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
$ python decide_bot.py
```


### Comandos disponibles:
- /start : Ventana de bienvenida con las opciones disponibles.
- /help : Ayuda para el uso del bot.
- /login - {usuario} {contraseña} : Iniciar sesión.
- /logout : Cerrar la sesión actual.
