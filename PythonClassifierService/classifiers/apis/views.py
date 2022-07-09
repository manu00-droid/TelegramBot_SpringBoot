from rest_framework.decorators import api_view
import logging

from rest_framework.response import Response
import json

import rice_classifiers
import wheat_classifier


@api_view(['POST'])
def predict(request):
    data = json.loads(request.body.decode('utf-8'))
    file_path = data['file_path']
    crop = data['crop']
    print(file_path)
    print(crop)
    if crop == 'rice':
        return Response(rice_classifiers.disease_prediction(file_path))
    if crop == 'wheat':
        return Response(wheat_classifier.disease_prediction(file_path))
    return Response("invalid crop")
