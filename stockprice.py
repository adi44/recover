#!/usr/bin/env python2
import urllib2
import time
from urllib2 import Request
import re
import json

def stockprice():
	stock=str(raw_input("Enter the stock symbol: "))
	hdr={'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11','Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8','Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3','Accept-Encoding': 'none','Accept-Language': 'en-US,en;q=0.8','Connection': 'keep-alive'}
	
	url = Request('https://nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol='+stock+'&illiquid=0&smeFlag=0&itpFlag=0',headers=hdr)
	nav=urllib2.urlopen(url)
	data=nav.read()
	srch ='"lastPrice":"(.+?)"'
	srchh='"change":"(.+?)"'
	com=re.compile(srch)
	comm=re.compile(srchh)
	rslt= re.findall(com,str(data))
	rsl=re.findall(comm,str(data))
	if(rslt):
		result='Last Price:'+str(rslt[0])
		res='Change:'+str(rsl[0])
		print(json.dumps((result,res)))
		



stockprice()


