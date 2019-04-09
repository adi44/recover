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
def stockprice(stock_id):
	
	hdr={'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11','Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8','Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3','Accept-Encoding': 'none','Accept-Language': 'en-US,en;q=0.8','Connection': 'keep-alive'}
	
	url = Request('https://nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol='+stock_id+'&illiquid=0&smeFlag=0&itpFlag=0',headers=hdr)
	nav=urllib2.urlopen(url)
	data=nav.read()
	srch ='"lastPrice":"(.+?)"'
	com=re.compile(srch)

	rslt= re.findall(com,str(data))[0]
	
	if(rslt):
		return rslt

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
	techanalysis= soup.find_all("div",id="vitalleftcontent1")[1]
	raw_data = techanalysis.find('br')
	stock_id=raw_data.find_next()
	list_stock_id=stock_id.text.split()
	

	raw_data = techanalysis.find_all('br')[7]
	previous_price=raw_data.find_next()
	list_previous_price=previous_price.text.split()
	list_previous_price.remove('PREV')
	list_previous_price.remove('Close')
	
	

	techanalysis= soup.find_all("div",id="vitalleftcontent2")[1]
	raw_data = techanalysis.find_all('br')[7]
	recommended_price=raw_data.find_next()
	list_recommended_price=recommended_price.text.split()
	list_recommended_price.remove('Buy')
	list_recommended_price.remove('Above')
	

	techanalysis= soup.find_all("div",id="vitalleftcontent2")[2]
	raw_data = techanalysis.find_all('br')[7]
	stop_loss=raw_data.find_next()
	list_stop_loss=stop_loss.text.split()
	list_stop_loss.remove('Stop')
	list_stop_loss.remove('Loss')
	

	techanalysis= soup.find_all("div",id="vitalleftcontent2")[3]
	raw_data = techanalysis.find_all('br')[7]
	target_one=raw_data.find_next()
	list_target_one=target_one.text.split()
	list_target_one.remove('TGT')
	list_target_one.remove('One')
	

	techanalysis= soup.find_all("div",id="vitalleftcontent2")[4]
	raw_data = techanalysis.find_all('br')[7]
	target_two=raw_data.find_next()
	list_target_two=target_two.text.split()
	list_target_two.remove('TGT')
	list_target_two.remove('Two')


	Stock_0={}
	Stock_0["stock_id"]=list_stock_id[0]
	Stock_0["company_name"]=GetStockNameFromCode(list_stock_id[0])
	Stock_0["current_price"]=list_previous_price[0]
	Stock_0["target1"]=list_target_one[0]
	Stock_0["target2"]=list_target_two[0]
	Stock_0["recommended_price"]=list_recommended_price[0]
	Stock_0["stop_loss"]=list_stop_loss[0]
	Stock_0["currency"]="INR"

	Stock_1={}
	Stock_1["stock_id"]=list_stock_id[1]
	Stock_1["company_name"]=GetStockNameFromCode(list_stock_id[1])
	Stock_1["current_price"]=list_previous_price[1]
	Stock_1["target1"]=list_target_one[1]
	Stock_1["target2"]=list_target_two[1]
	Stock_1["recommended_price"]=list_recommended_price[1]
	Stock_1["stop_loss"]=list_stop_loss[1]
	Stock_1["currency"]="INR"

	Stock_2={}
	Stock_2["stock_id"]=list_stock_id[2]
	Stock_2["company_name"]=GetStockNameFromCode(list_stock_id[2])
	Stock_2["current_price"]=list_previous_price[2]
	Stock_2["target1"]=list_target_one[2]
	Stock_2["target2"]=list_target_two[2]
	Stock_2["recommended_price"]=list_recommended_price[2]
	Stock_2["stop_loss"]=list_stop_loss[2]
	Stock_2["currency"]="INR"

	Stock_3={}
	Stock_3["stock_id"]=list_stock_id[3]
	Stock_3["company_name"]=GetStockNameFromCode(list_stock_id[3])
	Stock_3["current_price"]=list_previous_price[3]
	Stock_3["target1"]=list_target_one[3]
	Stock_3["target2"]=list_target_two[3]
	Stock_3["recommended_price"]=list_recommended_price[3]
	Stock_3["stop_loss"]=list_stop_loss[3]
	Stock_3["currency"]="INR"

	tips=list()

	tips.append(Stock_0)
	tips.append(Stock_1)
	tips.append(Stock_2)
	tips.append(Stock_3)

	print("{"+json.dumps("tips")+":"+json.dumps(tips)+"}")


	

AnalysisFromTechAnalysis()