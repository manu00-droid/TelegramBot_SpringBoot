from rest_framework.decorators import api_view
from rest_framework.response import Response
import json
import translator


@api_view(['POST'])
def translate(request):
    print(request.data)
    text = request.data['text']
    language = request.data['language']
    translated_text = translator.translation(text, language)
    return Response(translated_text)
