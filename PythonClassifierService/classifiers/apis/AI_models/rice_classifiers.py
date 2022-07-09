import torch
from torchvision import transforms
from PIL import Image
import os

rice_model = os.path.join(os.path.dirname(os.path.dirname(__file__)),
                          '/home/manav/PycharmProjects/PythonClassifierService/classifiers/apis/AI_models/rice.pt')


def proc_rice(im):
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
    model = torch.load(rice_model, map_location=device)
    img = Image.open(im)
    tfms = transforms.Compose([
        transforms.Resize(256),
        transforms.CenterCrop(224),
        transforms.ToTensor(),
        transforms.Normalize([0.485, 0.456, 0.406], [0.229, 0.224, 0.225])
    ])
    img_t = tfms(img)
    img_t = img_t.unsqueeze(0)
    img_t = img_t.to(device)
    output = model(img_t)
    prediction = int(torch.max(output.cpu().data, 1)[1].numpy())
    return prediction


def disease_prediction(im):
    fin_rice = {0: "Bacterial Blight", 1: "Blast", 2: "Brownspot", 3: "Healthy", 4: "Hispa", 5: "Leaf Blast",
                6: "Tungro"}
    prediction = proc_rice(im)
    # print(fin_rice[prediction])
    disease_predicted = fin_rice[prediction]
    # print(disease_predicted)
    return disease_predicted

# disease_prediction("/home/manav/Crop_Saviour/file_0.jpg")
