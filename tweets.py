#!/usr/bin/env python
import tweepy 
import json
import csv
import requests
  
# Fill the X's with the credentials obtained by  
# following the above mentioned procedure. 
consumer_key = "mA7DkhckWxIdTpNFG4DFVXSPN" 
consumer_secret = "8cVOndCsr1FE2zAB0YAAiP5z2wwIUpqpFwvB8y0VbRskiSDgk1"
access_key = "2371674115-neFMzLn83erOh9HvY1P6AF47TXOuIPPiszaL2mF"
access_secret = "UrtQOQQeNnK2GfQd8Gu6NLfDM0Mp1uYQR9ijiJcEbqwaQ"
  
# Function to extract tweets 
          
        # Authorization to consumer key and consumer secret 
auth = tweepy.OAuthHandler(consumer_key, consumer_secret) 
 
        # Access to user's access key and access secret 
auth.set_access_token(access_key, access_secret) 
  
        # Calling api 
api = tweepy.API(auth) 
  
        # 200 tweets to be extracted 
csvFile = open('tweets.csv', 'w')

#Use csv writer
csvWriter = csv.writer(csvFile)

for tweet in tweepy.Cursor(api.search,q = "midasIIITD", exclude_replies=True,lang = "en").items():

	for media in tweet.entities.get("media",[{}]):
    #checks if there is any media-entity
    		if media.get("type",None) == "photo":
        # checks if the entity is of the type "photo"
        		image_content=requests.get(media["media_url"])
        		print(image_content)
    # Write a row to the CSV file. I use encode UTF-8
	csvWriter.writerow([tweet.created_at, tweet.text.encode('utf-8')])
	print tweet.created_at, json.dumps(tweet.text)


csvFile.close()