from bs4 import BeautifulSoup
import requests


def list_to_string(s):
    str1 = ""
    for ele in s:
        str1 += ele
    return str1


def send_msg(text, chat_id):
    token = "5459955578:AAG-Dr0d8bWluBk9y4RAuKFiWTRkg6JGHpI"
    url_req = "https://api.telegram.org/bot" + token + "/sendMessage" + "?chat_id=" + chat_id + "&text=" + text + "&parse_mode=html"
    results = requests.get(url_req)
    print(results.json())


def prices(crop, state, chat_id):
    req = f"https://www.commodityonline.com/mandiprices/{crop}/{state}"
    hit = requests.get(req)
    soup = BeautifulSoup(hit.text, "lxml")

    # scrape mandi highlight box from the website
    overview_div = soup.find_all("div", {"class": "mandi_highlight"})
    print("mandi_highlight fetched: \n")
    print(overview_div)

    # return if nothing is scraped
    if len(overview_div) == 0:
        send_msg("No data found", chat_id)
        return

    # extract data from overview_div which is a resultSet
    element_text_list = []
    for i in overview_div.pop():
        text = i.text.strip()
        if len(text) != 0:
            element_text_list.append(text)

    # underlining and bolding heading
    element_text_list[0] = "<u><b>" + element_text_list[0] + "</b></u>" + "\n\n"
    element_text_list[1] = "<u><b>" + element_text_list[1].split(":", 1)[0] + ":" + "</b></u>" + \
                           element_text_list[1].split(":", 1)[1] + "\n\n"
    temp_list = []
    for i in element_text_list[2].split("\n"):
        if len(i) != 0:
            temp_list.append(i)

    # editing average price
    temp_list[0] = "<u><b>" + temp_list[0] + "</b></u>\n"

    # editing the lowest price
    temp_list[2] = "\n\n<u><b>" + temp_list[2] + "</b></u>\n"

    # editing the highest price
    temp_list[4] = "\n\n<u><b>" + temp_list[4] + "</b></u>\n"

    # convert list to string
    element_text_list[2] = list_to_string(temp_list)

    # send message to user
    send_string = list_to_string(element_text_list)
    send_msg(send_string, chat_id)


# prices("rice", "west-bengal", "1449110496")
# prices("rice", "punjab", "1449110496")
# print(prices("rice", "uttar-pradesh"))
# print(result)
