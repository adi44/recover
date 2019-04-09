#!/usr/bin/env python2
import requests
import urllib
from requests import get
from requests.exceptions import RequestException
from contextlib import closing
import re
import json
from bs4 import *
from bs4 import NavigableString
import pandas as pd
url= "https://www.technicalanalysisofstocks.in/"
header={'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11','Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8','Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3','Accept-Encoding': 'none','Accept-Language': 'en-US,en;q=0.8','Connection': 'keep-alive'}
wiki=requests.get(url)
page=wiki.text
soup = BeautifulSoup(page,"html.parser")
techanalysis= soup.find("div")
para = techanalysis.find_all('b')[0]
print(para.text)
		

	