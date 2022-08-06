# TelegramBot_SpringBoot
Telegram bot using spring boot

Download weed detection model weights
https://drive.google.com/file/d/1ywgBMK3VwAqVpnppe8yMUvHLnejq878k/view?usp=sharing



script to run
#! /bin/bash

sudo service network-manager restart

sudo source home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/venv/bin/activate

export PYTHONPATH="/home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonTranslateService/translate/apis/Modules:${PYTHONPATH}"

export PYTHONPATH="/home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonClassifierService/classifiers/apis/AI_models:${PYTHONPATH}"

python3 /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonClassifierService/classifiers/manage.py runserver 8083

python3 /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonTranslateService/translate/manage.py runserver 8082

java -jar /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/User Service/target/user-service-0.0.1-SNAPSHOT.jar

java -jar /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/bot-service/target/CropSaviour-0.0.1-SNAPSHOT.jar
