#auther: PengFCB

import requests
import json
from bs4 import BeautifulSoup


def request_data(array,array1, target, max_page, boundary_value):
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
                textlist = [""]
                textlist[0]=text
                elem = {
                    'user_name': user,
                    'main': textlist,
                    'tag': tag,
                    'hotIndex': popindex,
                    'commentNum': cmtcount
                }
                elem1 = {
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
                array1.append(elem1)
        page = page + 1


if __name__ == '__main__':
    tagnames = [
        '王者荣耀'
    ]
    for tagname in tagnames:
        elems = []
        elem1s = []
        target_total = 'http://www.lofter.com/tag/{}/total'.format(tagname)
        print("Process: {} total".format(tagname))
        request_data(elems,elem1s, target_total, 59, -1)
        print("write file")
        with open("../json/lfhot.json", "w", encoding='utf-8') as f:
            f.write(json.dumps(elems, ensure_ascii=False, indent=4))
            f.close()
        print('\n')
        target_new = 'http://www.lofter.com/tag/{}/new'.format(tagname)
        print("Process: {} new".format(tagname))
        bvalue = elems[len(elems) - 1]['hotIndex']
        elems = []
        request_data(elems, elem1s, target_new, 251, bvalue)
        print("write file")
        #localtime = time.strftime("%Y-%m-%d_%H:%M:%S", time.localtime())
        with open("../json/lf.json", "w", encoding='utf-8') as f:
            f.write(json.dumps(elems, ensure_ascii=False, indent=4))
            f.close()
        with open("../json/lofter.json", "w", encoding='utf-8') as f:
            f.write(json.dumps(elem1s, ensure_ascii=False, indent=4))
            f.close()
        #with open("corpus_{}_{}.txt".format(tagname, localtime), "w", encoding='utf-8') as f:
        #    corpus_count = 1
        #    for corpus_elem in elems:
        #        f.write("{}\t".format(corpus_count))
        #        for word in HanLP.segment(corpus_elem['text']):
        #            f.write(str(word) + ' ')
        #        f.write('\n')
        #        corpus_count = corpus_count + 1
        #    f.close()
        print('\n')
