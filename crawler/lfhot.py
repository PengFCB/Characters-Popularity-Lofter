# -*- coding:UTF-8 -*-
import requests, sys
from bs4 import BeautifulSoup

page = 1

target = 'http://www.lofter.com/tag/%E7%8E%8B%E8%80%85%E8%8D%A3%E8%80%80/total'

outfile = open('lfhot.txt', 'w')

while page <= 59:
    payload = {'page': page}
    req = requests.get(url=target, params=payload)
    req.encoding = 'UTF-8'
    html = req.text
    bf = BeautifulSoup(html, features='html.parser')
    isaym = bf.find_all('div', class_='isaym')
    for in_isaym in isaym:
        who = in_isaym.find_all('a', class_='ptag')
        if len(who):
            outfile.write("user:\n"+who[0].text+"\n")
        else:
            break
        txt = in_isaym.find_all('div', class_="txt js-content ptag")
        for in_txt in txt:
            outfile.write("main:\n"+in_txt.text+"\n")
        txt = in_isaym.find_all('div', class_="js-content ptag")
        for in_txt in txt:
            outfile.write("main:\n"+in_txt.text+"\n")
        tag = in_isaym.find_all('span', class_="opti")
        for in_tag in tag:
            outfile.write("other:\n"+in_tag.text+"\n")
#outfile.write("\nPage:"+page+"\n")
    page = page + 1
outfile.close()

