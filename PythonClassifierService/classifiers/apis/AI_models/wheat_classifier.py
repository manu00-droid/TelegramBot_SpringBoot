import Inference


def proc_wheat(im):
    disease_classification = Inference.DiseaseClassification(filename=im)
    prediction_wheat_model = disease_classification.prediction()
    return prediction_wheat_model


def disease_prediction(im):
    fin_wheat = {0: "Healthy", 1: "leaf rust", 2: "Powdery Mildew", 3: "seedlings", 4: "Septoria", 5: "Stem Rust",
                 6: "Yellow rust"}
    prediction = proc_wheat(im)
    print(prediction)
    for i in range(7):
        if prediction[i][1] > 0.5:
            return prediction([i][0])
    return "no disease found"

# print(disease_prediction("/home/manav/Crop_Saviour/file_0.jpg"))
