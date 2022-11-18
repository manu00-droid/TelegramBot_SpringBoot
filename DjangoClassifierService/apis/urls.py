from django.urls import path
from . import views

urlpatterns = [
    path('prediction/', views.predict),
    path('mandiRate/', views.mandi_rate)
    # path('translate/', views.translate)
]
