
import pickle
import os
with open("train_label.pkl","rb") as f:
	data={}
	data=pickle.load(f)
print data