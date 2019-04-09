#!/usr/bin/env python2
import requests
import urllib
import urllib2
from urllib2 import Request
from requests import get
from requests.exceptions import RequestException
from contextlib import closing
import re
import json
from bs4 import *
from bs4 import NavigableString
import pandas as pd
import collections

def GetStockNameFromCode(stock):
	
	hdr={'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11','Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8','Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3','Accept-Encoding': 'none','Accept-Language': 'en-US,en;q=0.8','Connection': 'keep-alive'}
	
	url = Request('https://nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol='+stock+'&illiquid=0&smeFlag=0&itpFlag=0',headers=hdr)
	nav=urllib2.urlopen(url)
	data=nav.read()
	srch ='"companyName":"(.+?)"'
	com=re.compile(srch)
	rslt= re.findall(com,str(data))[0]
	if(rslt):
		return  rslt

def AnalysisFromTechAnalysis():
	url= "https://www.technicalanalysisofstocks.in/"
	header={'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11','Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8','Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3','Accept-Encoding': 'none','Accept-Language': 'en-US,en;q=0.8','Connection': 'keep-alive'}
	wiki=requests.get(url)
	page=wiki.text
	soup = BeautifulSoup(page,"html.parser")
	techanalysis= soup.find("div")
	raw_data = techanalysis.find_all('b')[0]
	text_data=raw_data.text
	techanalysis={}
	allanalysis={}
	tips =[5]
	tip="tips"
	list= text_data.split();
	for i in range(len(list)):
		
		if((list[i]=="Buy") and (list[i+1]=="above")):
			recommended_price = list[i+2]
			

		if(list[i]=="Target"):
			target = list[i+2]

		

		if((list[i]=="Stop") and (list[i+1]=="Loss")):
		    stop_loss = list[i+3]

		
		
		
		if((list[i]=="Buy" ) and (list[i+1]=="Stock")):
			stock_id = list[i+3]

	company_name=GetStockNameFromCode(stock_id)
	techanalysis["stock_id"]=stock_id
	techanalysis["company_name"]=company_name
	techanalysis["currency"]="INR"
	techanalysis["recommended_price"]=recommended_price
	techanalysis["target"]=target
	techanalysis["stop_loss"]=stop_loss



		
	for i in range(len(tips)):
			tips[0]= techanalysis
	print("{"+json.dumps(tip)+":"+json.dumps(tips)+"}")

AnalysisFromTechAnalysis()


	