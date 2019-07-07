#   Copyright 2019 CPL Group
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.

__auther__ = 'Akiko97'

import requests
import json
import time
from pyhanlp import HanLP
from bs4 import BeautifulSoup


def request_data(array, target, max_page, boundary_value):
    page = 1
    while page <= max_page:
        print("{} %".format(page / max_page * 100))
        payload = {'page': page}
        req = requests.get(url=target, params=payload)
        req.encoding = 'UTF-8'
        html = req.text
        bf = BeautifulSoup(html, features='html.parser')
        mlist = bf.find_all('div', class_='m-mlist')
        for element in mlist:
            pid = element.get('data-postid')
            if pid:
                user = element.get('data-blognickname')
                uid = element.get('data-authorblogid')
                dtype = int(element.get('data-type'))
                cmtcount = int(element.get('data-cmtcount'))
                popindex = int(element.get('data-hotcount'))
                if boundary_value != -1 and popindex >= boundary_value:
                    continue
                if dtype == 1:
                    dtypes = "TEXT"
                    title_unknown = element.find_all('h2', class_='tit')
                    if len(title_unknown) != 0:
                        title = title_unknown[0].text.replace('\n', ' ')
                    else:
                        title = ""
                    text = element.find_all('div', class_='txt js-content ptag')[0].text.replace('\n', ' ')
                elif dtype == 2:
                    dtypes = "PICTURE"
                    title = ""
                    text = element.find_all('div', class_='js-content ptag')[0].text.replace('\n', ' ')
                elif dtype == 3:
                    dtypes = "MUSIC"
                    title = ""
                    text = element.find_all('div', class_='js-content ptag')[0].text.replace('\n', ' ')
                elif dtype == 4:
                    dtypes = "MOVIE"
                    title = ""
                    text = element.find_all('div', class_='js-content ptag')[0].text.replace('\n', ' ')
                elif dtype == 6:
                    dtypes = "LONG-TEXT"
                    title = ""
                    text = element.find_all('div', class_='desc')[0].text.replace('\n', ' ')
                else:
                    dtypes = "UNKNOWN"
                    title = ""
                    text = ""
                tag = []
                tags = element.find_all('div', class_='opta')
                if len(tags) != 0:
                    tag_elems = tags[0].find_all('span', class_='opti')
                    for tag_elem in tag_elems:
                        tag.append(tag_elem.text)
                else:
                    tag.append("")
                elem = {
                    'pid': pid,
                    'uid': uid,
                    'user_name': user,
                    'data_type': dtypes,
                    'comment_count': cmtcount,
                    'pop_index': popindex,
                    'tag': tag,
                    'title': title,
                    'text': text
                }
                array.append(elem)
        page = page + 1


if __name__ == '__main__':
    tagnames = [
        '王者荣耀',
        '信白',
        '云亮',
        '铠约',
        '双兰',
        '策约',
        '邦良',
        '约策',
        '百里骨科',
        '狄芳',
        '瑜乔',
        '铠宝',
        '备香',
        '策乔',
        '药鱼',
        '邦信',
        '信云',
        '白亮',
        '白信',
        '明弈',
        '白狄',
        '亮瑜',
        '白鹊'
    ]
    for tagname in tagnames:
        elems = []
        target_total = 'http://www.lofter.com/tag/{}/total'.format(tagname)
        print("Process: {} total".format(tagname))
        request_data(elems, target_total, 59, -1)
        print('\n')
        target_new = 'http://www.lofter.com/tag/{}/new'.format(tagname)
        print("Process: {} new".format(tagname))
        bvalue = elems[len(elems) - 1]['pop_index']
        request_data(elems, target_new, 251, bvalue)
        print("write file")
        localtime = time.strftime("%Y-%m-%d_%H:%M:%S", time.localtime())
        with open("lofter_{}_{}.json".format(tagname, localtime), "w", encoding='utf-8') as f:
            f.write(json.dumps(elems, ensure_ascii=False, indent=4))
            f.close()
        with open("corpus_{}_{}.txt".format(tagname, localtime), "w", encoding='utf-8') as f:
            corpus_count = 1
            for corpus_elem in elems:
                f.write("{}\t".format(corpus_count))
                for word in HanLP.segment(corpus_elem['text']):
                    f.write(str(word) + ' ')
                f.write('\n')
                corpus_count = corpus_count + 1
            f.close()
        print('\n')
