# TelegramBot_SpringBoot
Telegram bot developed as a spring boot application.

It is used to classify Rice, Wheat dieseases and detect presence of Weed in rice crop fields.
Using a Resnet50 model for classification of rice diseases and Efficientnet b0 for Wheat crop accuracy for both was above 93%, atlast yolov5 was used to detect presence of weed in rice crops.

## System Architecture:
- It consists of 4 microservices and the names represents the obvious functionalty of them.
- All the callbacks are handled by Bot-Service developed using spring boot and it made API calls to the rest of the 3 services.
- The User-Service is responsible for storing the users information like username, chatid, language selected, crop selected etc. It is also developed in Spring boot.
- The Classifier service is a django microservice which is responsible for classifying diseases.
- Atlast the translate service, also developed using django, uses Google Translate API for translating any text. 

<br />

![1](https://user-images.githubusercontent.com/79694635/190929138-7bdd2f59-1b2c-4246-b75d-9142902a3a23.jpg)


## Bot working images:

#### All of the bot commands
![bot](https://user-images.githubusercontent.com/79694635/190929156-cf1b3f54-4b05-400e-bc8e-da13b81a1b71.png)

#### Selecting rice as crop and sending rice image with Bacterial Blight disease 
<br />

![bot2](https://user-images.githubusercontent.com/79694635/190929173-f7ac47fb-43d7-4dcb-a892-11974113bfcf.png)

<br />

#### Bot replying with disease name and its remedies and bot also provides audio file for the same.

<br />

![bot3](https://user-images.githubusercontent.com/79694635/190929179-c6cc406b-af1c-41d5-9de5-64a8764d65d0.png)

<br />

#### Weed detection done by bot
<br />

![bot4](https://user-images.githubusercontent.com/79694635/190929636-a06350e2-1976-4b79-b1e8-a2ea22e73298.png)
<br />

<br />

![bot5](https://user-images.githubusercontent.com/79694635/190929550-ad1f2f33-7459-4bd6-ab69-b3bd701963b3.png)

<br />

#### Changing the language of bot
<br />


![bot6](https://user-images.githubusercontent.com/79694635/190929557-5910399a-7eda-467e-9100-1bc7c14166e3.png)


<br />
<br />





## Steps to build this bot

- Firstly create a bot on telegram using BOT FATHER. 
- Save the bot username and the API_KEY and exchange it with the existing in the CropSaviourBot.java file present in Bot Service.

```
    @Override
    public String getBotUsername() {
        return "BOT_USERNAME";
    }

    @Override
    public String getBotToken() {
        return "BOT_API_KEY";
    }
```
- Download weed detection model weights and place it in PythonClassifierService/classifiers/apis/AI_models/ directory.
```
https://drive.google.com/file/d/1ywgBMK3VwAqVpnppe8yMUvHLnejq878k/view?usp=sharing
```

- Configure the Paths present in CropSaviourBot.java, AudioService.java, custom_sesame_yolov4_image_nms.py, Inference.py, rice_classifiers.py files
<br />
In CropSaviourBot.java file, change /home/ubuntu/telegram/ path according to your os
    
```
private final String IMAGE_DOWNLOAD_PATH = "/home/ubuntu/telegram/bot-service/src/main/java/com/thapar/CropSaviour/DownloadedImages/";
```    
    
<br />
Similarly in AudioService.java
    
```
private final String AUDIO_FILES_PATH = "/home/ubuntu/telegram/bot-service/src/main/java/com/thapar/CropSaviour/AudioFiles/";
```
In custom_sesame_yolov4_image_nms.py file
 ```
yolo_model = cv2.dnn.readNetFromDarknet(
    '/home/ubuntu/Final-Telegram-Bot/PythonClassifierService/classifiers/apis/AI_models/cov_yolov4.cfg',
    '/home/ubuntu/Final-Telegram-Bot/PythonClassifierService/classifiers/apis/AI_models/cov_yolov4_best.weights'
)
```

<br />
In Inference.py file

```
wheat_model = os.path.join(os.path.dirname(os.path.dirname(__file__)),'/home/ubuntu/Final-Telegram-Bot/PythonClassifierService/classifiers/apis/AI_models/DiseaseClassification.pt')
```

<br />
In rice_classifiers.py file

```
rice_model = os.path.join(os.path.dirname(os.path.dirname(__file__)),
                          '/home/ubuntu/Final-Telegram-Bot/PythonClassifierService/classifiers/apis/AI_models/rice.pt')
```

- Now export PYTHONPATH from terminal using following commands(Change the paths accordingly)
```
export PYTHONPATH="/home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonTranslateService/translate/apis/Modules:${PYTHONPATH}"

export PYTHONPATH="/home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonClassifierService/classifiers/apis/AI_models:${PYTHONPATH}"
```

- Finally run these 4 commands from your terminal
```
python3 /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonClassifierService/classifiers/manage.py runserver 8083

python3 /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/PythonTranslateService/translate/manage.py runserver 8082

java -jar /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/User Service/target/user-service-0.0.1-SNAPSHOT.jar

java -jar /home/cropsaviour/CropSaviour/TelegramBot_SpringBoot/bot-service/target/CropSaviour-0.0.1-SNAPSHOT.jar
```

