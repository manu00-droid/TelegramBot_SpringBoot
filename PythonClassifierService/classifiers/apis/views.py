from rest_framework.decorators import api_view
from rest_framework.response import Response
import json
import os
import rice_classifiers
import wheat_classifier
import custom_sesame_yolov4_image_nms


# rice_classifiers = os.path.join(os.path.dirname(os.path.dirname(__file__)),
#                                 '/home/manav/Work/IdeaProjects/TelegramBot_SpringBoot/PythonClassifierService'
#                                 '/classifiers '
#                                 '/apis/AI_models/rice_classifiers.py')
#
# wheat_classifier = os.path.join(os.path.dirname(os.path.dirname(__file__)),
#                                 '/home/manav/Work/IdeaProjects/TelegramBot_SpringBoot/PythonClassifierService'
#                                 '/classifiers '
#                                 '/apis/AI_models/wheat_classifier.py')


@api_view(['POST'])
def predict(request):
    # data = json.loads(request.body.decode('utf-8'))
    # # data=request.body
    # print(data)
    print(request.POST.get)
    file_path = request.POST.get('file_path')
    crop = request.POST.get('crop')
    print(file_path)
    print(crop)
    if crop == 'rice':
        disease = rice_classifiers.disease_prediction(file_path)
        return Response(disease)
    if crop == 'wheat':
        disease = wheat_classifier.disease_prediction(file_path)
        return Response(disease)
    if crop == 'weed':
        img_path = custom_sesame_yolov4_image_nms.weedDetection(file_path)
        return Response(img_path)
    return Response("invalid crop")
