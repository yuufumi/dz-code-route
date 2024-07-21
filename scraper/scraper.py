import requests
import os
from bs4 import BeautifulSoup
import json

url = "https://wimsauto.universite-paris-saclay.fr/wims/wims.cgi?lang=fr&+module=data%2Fimages%2Froadsigns.fr"
url_for_images = "https://wimsauto.universite-paris-saclay.fr/wims/"

r = requests.get(url)

print(r)


soup = BeautifulSoup(r.content,"html.parser")

s = soup.find('table')
filename = "panels.json"
content = s.find_all("tr")
panels = []
for c in content:
    data = c.find_all("td")
    image = data[0].find('img').get('src')
    if not image.startswith(('http:', 'https:')):
        img_url = f"{url_for_images.rstrip('/')}/{image.lstrip('/')}"
    
    img_data = requests.get(img_url).content
    filename = "images/" + os.path.basename(img_url)
    with open(filename, 'wb') as handler:
        handler.write(img_data)
    
    title = data[2].text
    
    panels.append({"image": image, "title": title})

#with open(filename,"w") as json_file:
#    json.dump(panels, json_file,indent=4)
print(panels)