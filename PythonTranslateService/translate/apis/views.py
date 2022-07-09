from rest_framework.decorators import api_view
from rest_framework.response import Response
import json
import translator


@api_view(['POST'])
def translate(request):
    data = json.loads(request.body.decode('utf-8'))
    text = data['text']
    language = data['language']
    translated_text = translator.translation(text, language)
    return Response(translated_text)
