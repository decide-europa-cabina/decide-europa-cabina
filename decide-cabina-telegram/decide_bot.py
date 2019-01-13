# -*- coding: utf-8 -*-

import telegram
from telegram.ext import *
import requests
import json

TOKEN_API = "761820232:AAGjFcbNwJCcChShP_7-5bYDJo6lRtCJYGI"
decide_bot = telegram.Bot(token=TOKEN_API)
decide_bot_updater = Updater(decide_bot.token)

values = {}


# --------------------------- START -----------------------------
def start(bot, update):

    bot.sendMessage(chat_id=update.message.chat_id, text="Bienvenidx a la interfaz de votación de Decide! 🗳 \n"
                                                         "➡ ¿Desea iniciar sesión? Haga clic aquí: /login \n"
                                                         "➡ ¿Desea ver las votaciones? Haga clic aquí: /voting")


# --------------------------- HELP -----------------------------
def help(bot, update):

    bot.sendMessage(chat_id=update.message.chat_id,
                    text="🆘 Escriba /start para comenzar a usar el bot. Puede utilizar el menú desplegable "
                         "escribiendo '/' y le aparecerán las diferentes opciones.")


# --------------------------- LOGIN -----------------------------
def login(bot, update, args):

    if not args:
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

            url = "https://decide-europa-cabina.herokuapp.com/authentication/getuser/"

            payload = "token=" + values["LOGINTOKEN"] + "&undefined="
            headers = {
                'Content-Type': "application/x-www-form-urlencoded",
                'cache-control': "no-cache",
                'Postman-Token': "28cd2794-34bf-4959-982e-b7e42f1bbc26"
            }

            jsonLogin = requests.request("POST", url, data=payload, headers=headers)
            pythonLogin = json.loads(jsonLogin.text)

            if jsonLogin.status_code == 200:

                values["LOGINID"] = pythonLogin["id"]

                bot.sendMessage(chat_id=update.message.chat_id, text="🔒 Ha iniciado sesión como '" + args[0] + "'.")

        else:
            bot.sendMessage(chat_id=update.message.chat_id,
                            text="❌ Ha ocurrido un error, revise su usuario y contraseña.")

    else:
        bot.sendMessage(chat_id=update.message.chat_id, text="🔐 Sesión ya iniciada.")


# --------------------------- LOGOUT -----------------------------
def logout(bot, update):

    if 'LOGINTOKEN' in values.keys():
        values.clear()
        bot.sendMessage(chat_id=update.message.chat_id, text="🔓 Se ha cerrado la sesión.")
    else:
        bot.sendMessage(chat_id=update.message.chat_id, text="❌ No se ha iniciado la sesión.")


# --------------------------- VOTING -----------------------------
def voting(bot, update):

    bot.sendMessage(chat_id=update.message.chat_id, text="Elija la votación que desea votar:")

    jsonVoting = requests.get('https://decide-europa-cabina.herokuapp.com/voting/').text
    pythonVoting = json.loads(jsonVoting)

    text = ""
    for voting in pythonVoting:
        text += "☑ ID: " + str(voting["id"]) + " - Título: " + str(voting["name"]) + \
                " - Descripción: " + str(voting["desc"]) + "\n"
    bot.sendMessage(chat_id=update.message.chat_id, text=text)

    bot.sendMessage(chat_id=update.message.chat_id,
                    text="Para ver las respuestas de una votación introduzca: /question id_votación.")


# --------------------------- QUESTION -----------------------------
def question(bot, update, args):

    if not args:
        bot.sendMessage(chat_id=update.message.chat_id,
                        text="🛑 Para mostrar las respuestas de una votación introduzca: /question id_votación.")
    else:
        jsonVoting = requests.get('https://decide-europa-cabina.herokuapp.com/voting/?id=' + args[0]).text
        pythonVoting = json.loads(jsonVoting)

        question = ""

        values["IDVOTING"] = args[0]
        values["QUESTIONVOTING"] = pythonVoting[0]["question"]["options"]
        values["PUBKEY"] = pythonVoting[0]["pub_key"]

        question += "Título de la pregunta: " + pythonVoting[0]["question"]["desc"] + "\n"
        for option in pythonVoting[0]["question"]["options"]:
            question += "⁉ ID: " + str(option["number"]) + " - Respuesta: " + str(option["option"]) + "\n"

        bot.sendMessage(chat_id=update.message.chat_id, text=question)

        bot.sendMessage(chat_id=update.message.chat_id,
                        text="Para votar una de las opciones introduzca: /vote id_respuesta.")


# --------------------------- VOTE -----------------------------
def vote(bot, update, args):

    if not args:
        bot.sendMessage(chat_id=update.message.chat_id,
                        text="🛑 Para votar una opción introduzca: /vote id_respuesta.")
    elif 'LOGINTOKEN' not in values.keys() and args != []:
        bot.sendMessage(chat_id=update.message.chat_id, text="🛑 Para poder votar debe iniciar sesión.")
    elif 'IDVOTING' not in values.keys() and args != []:
        bot.sendMessage(chat_id=update.message.chat_id, text="🛑 Para poder votar debe seleccionar la votación.")
    else:

        # Obtenemos el texto de la pregunta:
        for question in values["QUESTIONVOTING"]:
            if str(question["number"]) == args[0]:
                text_question = str(question["option"])

        # Ciframos el texto

        cifrado = ""
        '''
        El texto de la respuesta text_question debe cifrarse con elgamal con la clave pública values["PUBKEY"].
        '''

        # Realizamos la petición
        url = "https://decide-europa-cabina.herokuapp.com/store/"

        payload = "voting=" + str(cifrado) + "&voter=" + str(values["LOGINID"]) + \
                  "&token=" + str(values["LOGINTOKEN"]) + "&undefined="
        headers = {
            'Content-Type': "application/x-www-form-urlencoded",
            'cache-control': "no-cache",
            'Postman-Token': "dfaba9d3-3aff-4e5d-a621-15c6ac19fd46"
        }
        jsonLogin = requests.request("POST", url, data=payload, headers=headers)

        if jsonLogin.status_code == 200:

            bot.sendMessage(chat_id=update.message.chat_id,
                            text="🗳 Su voto ha sido procesado correctamente.")

        else:
            bot.sendMessage(chat_id=update.message.chat_id, text="❌ Ha ocurrido un error en la votación.")


# --------------------------- COMMANDHANDLER -----------------------------
start_handler = CommandHandler('start', start)
help_handler = CommandHandler('help', help)
login_handler = CommandHandler('login', login, pass_args=True)
logout_handler = CommandHandler('logout', logout)
voting_handler = CommandHandler('voting', voting)
question_handler = CommandHandler('question', question, pass_args=True)
vote_handler = CommandHandler('vote', vote, pass_args=True)

dispatcher = decide_bot_updater.dispatcher

dispatcher.add_handler(start_handler)
dispatcher.add_handler(help_handler)
dispatcher.add_handler(login_handler)
dispatcher.add_handler(logout_handler)
dispatcher.add_handler(voting_handler)
dispatcher.add_handler(question_handler)
dispatcher.add_handler(vote_handler)

decide_bot_updater.start_polling()
decide_bot_updater.idle()
