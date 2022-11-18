# TESTING CODE BELOW
# CHANGE CHAT ID AND TOKEN
# CURRENT SUPPORT FOR RUNTIME INPUT NOT THROUGH CHAT INTERFACE

from bs4 import BeautifulSoup
import requests
import pandas as pd
import datetime as dt
from googletrans import Translator


def prices(crop, state, chat_id):
    req = f"https://www.commodityonline.com/mandiprices/{crop}/{state}"
    hit = requests.get(req)
    soup = BeautifulSoup(hit.text, "lxml")
    table = soup.find('table', {'main-table2'})
    headers = []
    for i in table.find_all('th'):
        title = i.text.strip()
        headers.append(title)
    df = pd.DataFrame(columns=headers)
    for i in table.find_all('tr')[1:]:
        data = i.find_all('td')
        rowdata = [td.text.strip() for td in data]
        length = len(df)
        df.loc[length] = rowdata
    drop_columns = ['Telegram', 'Max Price', 'Min Price', 'State', 'Commodity']
    df = df.drop(columns=drop_columns, axis=1)
    # Uncomment code below to save data tp text file
    # df.to_csv('mandi_data.txt', sep ='\t')
    print(df)
    send_msg(df.to_string(index=False), chat_id)


# result = prices("rice", "punjab").to_string(index=False)
# print(prices("rice", "uttar-pradesh"))

def send_msg(text, chat_id):
    token = "5459955578:AAG-Dr0d8bWluBk9y4RAuKFiWTRkg6JGHpI"
    url_req = "https://api.telegram.org/bot" + token + "/sendMessage" + "?chat_id=" + chat_id + "&text=" + text
    results = requests.get(url_req)
    print(results.json())
