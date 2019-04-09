#!/usr/bin/env python2
from nsetools import Nse
import json
nse =Nse()
def StockCodeFromName():
	stock=str(raw_input("Enter the stock Name in correct format: "))
	all_stock_code=nse.get_stock_codes()
	dictionary={}
	for x,y in all_stock_code.items():
		if(y==stock):
			dictionary["Stock Code"] = x
	print(json.dumps(dictionary))

StockCodeFromName()
