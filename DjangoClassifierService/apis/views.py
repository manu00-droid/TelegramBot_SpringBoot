from rest_framework.decorators import api_view
from rest_framework.response import Response
import rice_classifiers
import wheat_classifier
import custom_sesame_yolov4_image_nms
import mandi
# import translator


@api_view(['POST'])
def predict(request):
    # data = json.loads(request.body.decode('utf-8'))
    # data=request.body
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


@api_view(['POST'])
def mandi_rate(request):
    crop = request.POST.get('crop')
    state = request.POST.get('state')
    chat_id = request.POST.get('chat_id')
    mandi.prices(crop, state, chat_id)
    return Response("okay")


# @api_view(['POST'])
# def translate(request):
#     print(request.data)
#     text = request.data['text']
#     language = request.data['language']
#     translated_text = translator.translation(text, language)
#     return Response(translated_text)
