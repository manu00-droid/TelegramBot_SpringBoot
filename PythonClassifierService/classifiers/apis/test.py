from classifiers.apis.AI_models import rice_classifiers


def test():
    file_path = "/home/manav/Crop_Saviour/file_0.jpg"
    disease = rice_classifiers.disease_prediction(file_path)
    print(disease)
    return disease


print(test())
