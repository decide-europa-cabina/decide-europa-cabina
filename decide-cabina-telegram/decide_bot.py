# -*- coding: utf-8 -*-

import telegram
from telegram.ext import *
from telegram.ext import CommandHandler

TOKEN_API = "761820232:AAGjFcbNwJCcChShP_7-5bYDJo6lRtCJYGI"
decide_bot = telegram.Bot(token=TOKEN_API)
decide_bot_updater = Updater(decide_bot.token)

############################# START #############################
def start(bot, update, pass_chart_date=True):

    bot.sendMessage(chat_id=update.message.chat_id, text="Bienvenidx a la votación de Decide. \n"
                                                         "¿Desea iniciar sesión? Haga clic aquí: /login \n"
                                                         "¿Desea ver las votaciones? Haga clic aquí: /voting")


############################# HELP #############################
def help(bot, update):

    bot.sendMessage(chat_id=update.message.chat_id,
                    text="Escriba /start para comenzar a usar el bot. Puede utilizar el menú desplegable "
                         "escribiendo '/' y le aparecerán las diferentes opciones.")


############################# COMMANDHANDLER #############################
start_handler = CommandHandler('start', start)
help_handler = CommandHandler('help', help)

dispatcher = decide_bot_updater.dispatcher

dispatcher.add_handler(start_handler)
dispatcher.add_handler(help_handler)

decide_bot_updater.start_polling()
decide_bot_updater.idle()

while True:
    pass