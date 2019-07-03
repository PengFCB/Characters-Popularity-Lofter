# Characters-Popularity-Lofter

基于关键词提取技术的乐乎平台中文作品标签识别和角色热度统计系统

[项目主页](https://pengfcb.github.io/Characters-Popularity-Lofter/)

本项目使用如下开源软件

* [gson](https://github.com/google/gson)
* [HanLP](https://github.com/hankcs/HanLP)
* [jcommon](https://github.com/jfree/jcommon)
* [jfreechart](https://github.com/jfree/jfreechart)

项目展示视频背景音乐《Shadow Of Truth》由[Audionautix](https://audionautix.com)提供

## 使用

1. 安装依赖：

```shell
pip3 install bs4 requests pyhanlp
```

2. 爬取数据集：

```shell
cd crawler 
python3 ./lf.py 
python3 ./lfhot.py
```

3. 排行榜：

使用任意IDE打开Java源代码直接运行即可。

4. 生成语料库：
```
cd corpus/tools/ 
python3 ./main.py
```

## Developer
* [@PengFCB](https://github.com/PengFCB)
* [@Nanami-Mo](https://github.com/Nanami-Mo)
* [@Akiko97](https://github.com/Akiko97)
* [@zyc14588](https://github.com/zyc14588)
