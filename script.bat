@echo off
:: Désactiver l'affichage des commandes

cd C:\AgenceImmo

:: Activer l'environnement virtuel
call .venv\Scripts\activate

:: Ouvrir un lien dans le navigateur
start "" "http://192.168.1.90:9001/"

:: Exécuter un script Python, si nécessaire
py  manage.py runserver 192.168.1.90:9001



:: Désactiver l'environnement virtuel à la fin (facultatif)
deactivate
pause
