# -*- coding: utf-8 -*-

import telegram
from telegram.ext import *
import requests
import json

TOKEN_API = "761820232:AAGjFcbNwJCcChShP_7-5bYDJo6lRtCJYGI"
decide_bot = telegram.Bot(token=TOKEN_API)
decide_bot_updater = Updater(decide_bot.token)

values = {}

############################# START #############################
def start(bot, update, pass_chart_date=True):

    bot.sendMessage(chat_id=update.message.chat_id, text="Bienvenidx a la interfaz de votación de Decide! 🗳 \n"
                                                         "➡ ¿Desea iniciar sesión? Haga clic aquí: /login \n"
                                                         "➡ ¿Desea ver las votaciones? Haga clic aquí: /voting")


############################# HELP #############################
def help(bot, update):

    bot.sendMessage(chat_id=update.message.chat_id,
                    text="🆘 Escriba /start para comenzar a usar el bot. Puede utilizar el menú desplegable "
                         "escribiendo '/' y le aparecerán las diferentes opciones.")


############################# LOGIN #############################
def login(bot, update, args):

    if args == []:
        bot.sendMessage(chat_id=update.message.chat_id,
                        text="🛑 Para iniciar sesión introduzca: /login usuario contraseña.")
    elif 'LOGINTOKEN' not in values.keys() and args != []:

        url = "https://decide-europa-cabina.herokuapp.com/authentication/login/"

        payload = "username=" + args[0] + "&password=" + args[1] + "&undefined="
        headers = {
            'Content-Type': "application/x-www-form-urlencoded",
            'cache-control': "no-cache",
            'Postman-Token': "28cd2794-34bf-4959-982e-b7e42f1bbc26"
        }

        jsonLogin = requests.request("POST", url, data=payload, headers=headers)
        pythonLogin = json.loads(jsonLogin.text)

        if jsonLogin.status_code == 200:

            values["LOGINTOKEN"] = pythonLogin["token"]

            bot.sendMessage(chat_id=update.message.chat_id, text="🔒 Ha iniciado sesión como '" + args[0] + "'.")

        else:
            bot.sendMessage(chat_id=update.message.chat_id,
                            text="❌ Ha ocurrido un error, revise su usuario y contraseña.")

    else:
        bot.sendMessage(chat_id=update.message.chat_id, text="🔐 Sesión ya iniciada.")


############################# LOGOUT #############################
def logout(bot, update):

    if 'LOGINTOKEN' in values.keys():
        values.clear()
        bot.sendMessage(chat_id=update.message.chat_id, text="🔓 Se ha cerrado la sesión.")
    else:
        bot.sendMessage(chat_id=update.message.chat_id, text="❌ No se ha iniciado la sesión.")


############################# COMMANDHANDLER #############################
start_handler = CommandHandler('start', start)
help_handler = CommandHandler('help', help)
login_handler = CommandHandler('login', login, pass_args=True)
logout_handler = CommandHandler('logout', logout)

dispatcher = decide_bot_updater.dispatcher

dispatcher.add_handler(start_handler)
dispatcher.add_handler(help_handler)
dispatcher.add_handler(login_handler)
dispatcher.add_handler(logout_handler)

decide_bot_updater.start_polling()
decide_bot_updater.idle()

while True:
    pass