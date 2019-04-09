#!/usr/bin/env python2
import random
class CallerPerson():

    intervalArrivalTime = 0
    customerarrivalTime = 0
    wAbleAvailable = 0
    wBakerAvailable = 0
    serverSelected = 0   # 0 is able and 1 is baker
    serviceproviderTime = 0
    ServiceBegins = 0
    ableServiceCompletedTime = 0
    bakerServiceCompletedTime = 0
    Delayincall = 0
    timeInsystem = 0


    def __init__(self,iat,at,waa,wbb,sc,st,tsb,asct,bsct,cd,tis):
        self.intervalArrivalTime = iat
        self.customerarrivalTime = at
        self.wAbleAvailable = waa
        self.wBakerAvailable = wbb
        self.serverSelected = sc
        self.serviceproviderTime = st
        self.ServiceBegins = tsb
        self.ableServiceCompletedTime = asct
        self.bakerServiceCompletedTime = bsct
        self.Delayincall = cd
        self.timeInsystem = tis

def FinalOutput(Output):
        print "customer Number"+"  |  "+"interArrivalTime"+"  |  "+"arrivalTime"+"  |  "+"whenAbleAvailable"+"  |  "+"whenBakerAvailable)"+"  |  "+"serverChosen"+"  |  "+"serviceTime"+"  |  "+"timeServiceBegins"+"  |  "+"ableServiceCompletedTime"+"  |  "+"(bakerServiceCompletedTime)"+"  |  "+"callerDelay"+"  |  "+"timeInsystem"+"  |  ";
        for i in range(len(Output)):
            k = Output[i]
            print str(i)+"  |  "+str(k.intervalArrivalTime)+"  |  "+str(k.customerarrivalTime)+"  |  "+str(k.wAbleAvailable)+"  |  "+str(k.wBakerAvailable)+"  |  "+str(k.serverSelected)+"  |  "+str(k.serviceproviderTime)+"  |  "+str(k.ServiceBegins)+"  |  "+str(k.ableServiceCompletedTime)+"  |  "+str(k.bakerServiceCompletedTime)+"  |  "+str(k.Delayincall)+"  |  "+str(k.timeInsystem)+"  |  ";

#it displays the final output.

def getInterArrivalTime(customerList):
    return random.choice(customerList)
#this gets the interval arrival time.
def getAbleOrBaker(ableAvailTime,bakerAvailTime,priority):
    if(ableAvailTime == bakerAvailTime):
        if(priority == 2):
            select = random.choice([0,1])
            return select
        else:
            return priority
    else:
        if(ableAvailTime < bakerAvailTime):
            return 0
        else:
            return 1
#this function decided whom to select, if able and baker are free it will select the able and if able is busy it will select the baker.
def getServiceTime(ableOrBaker,ableList,bakerList):
    if(ableOrBaker == 0):
        return random.choice(ableList)
    else:
        return random.choice(bakerList)
#it will get the service time from the list o able service time list and baker service time list.

def customerlistGenerator(customerTimeList,ableList,bakerList,priority,customerOrTime,count):
#this is the function which helps in generating the customer list.
    customerList = list()

    if(customerOrTime):
        for i in range(count):
            if(len(customerList) == 0):    # The fist caller
                if(priority == 2):
                    priority  = random.choice([0,1])
                if(priority == 0):
                    servTime = random.choice(ableList)
                    customerList.append(CallerPerson(0,0,0,0,0,servTime,0,servTime,0,0,0))
                if(priority == 1):
                    servTime = random.choice(bakerList)
                    customerList.append(CallerPerson(0,0,0,0,1,servTime,0,0,servTime,0,0))
#this part of code checks whether the priority is 0,1,2
#if it is zero it will append with able availability Service time
#if it is one it will append with baker availability Service time.
            else:
                interArrVlTime = getInterArrivalTime(customerTimeList)
                timeInSystem = customerList[len(customerList)-1].customerarrivalTime
                if(priority == 2):
                    priority  = random.choice([0,1])
                ableBaker = getAbleOrBaker(customerList[len(customerList)-1].ableServiceCompletedTime, customerList[len(customerList)-1].bakerServiceCompletedTime, priority)
                servTime = getServiceTime(ableBaker, ableList, bakerList)
#if priority it 2 it can choose any of the server whether it is able or baker.

                if(ableBaker == 0):
                    arrivalTime = customerList[len(customerList)-1].customerarrivalTime + interArrVlTime
                    whenAbleAvailable = customerList[len(customerList)-1].ableServiceCompletedTime
                    whenBakerAvailableTime = customerList[len(customerList)-1].bakerServiceCompletedTime
#if it is not a first customer. it calculates the arrivalTime of the n+1 customer by adding the interArrVlTime to the arrival time of previous customer.

                    if(arrivalTime > whenAbleAvailable):
                        whenServiceBegins = arrivalTime
                    else:
                        whenServiceBegins = whenAbleAvailable

                    if(arrivalTime < whenServiceBegins):
                        delay = whenServiceBegins - arrivalTime
                    else:
                        delay = 0
                    customerList.append(CallerPerson(interArrVlTime,arrivalTime,whenAbleAvailable,whenBakerAvailableTime,0,servTime,whenServiceBegins,whenAbleAvailable + servTime,whenBakerAvailableTime,delay,timeInSystem))
#if the arrival time of greater than when Able is available the service will begin at the time able is free.
#if the arrival time is less than able availibility time than a delay in call will be there it will be added to the time of previous customer.
                if(ableBaker == 1):
                    arrivalTime = customerList[len(customerList)-1].customerarrivalTime + interArrVlTime
                    whenAbleAvailable = customerList[len(customerList)-1].ableServiceCompletedTime
                    whenBakerAvailableTime = customerList[len(customerList)-1].bakerServiceCompletedTime

                    if(arrivalTime > whenBakerAvailableTime):
                        whenServiceBegins = arrivalTime
                    else:
                        whenServiceBegins = whenBakerAvailableTime

                    if(arrivalTime < whenServiceBegins):
                        delay = whenServiceBegins - arrivalTime
                    else:
                        delay = 0
                    customerList.append(CallerPerson(interArrVlTime,arrivalTime,whenAbleAvailable,whenBakerAvailableTime,1,servTime,whenServiceBegins,whenAbleAvailable,whenBakerAvailableTime + servTime,delay,timeInSystem))
#if the arrival time of greater than when Baker is available the service will begin at the time baker is free.
#if the arrival time is less than Baker availibility time than a delay in call will be there it will be added to the time of previous customer.
    else:
        pass

    return customerList
def main():


    customerIntervalArrivalTime = [1,2,3,4]
    ableServiceTime = [5,6,7,8]
    bakerServiceTime = [10,11,12,13]
    print("-------------------------------------------------------Welcome to the Simulation of Able and Baker Call Center Problem-------------------------------------------------------\n")
    print("                                                                       1.)When Able is Best                                                                                  \n")
    print("                                                                       2.)When Baker is Best                                                                                 \n")
    print("                                                                       3.)When you want it to choose randomly                                                                \n")
    print("                                                                       4.)Exit                                                                                               \n")
    user_choice=int(input("Enter your choice"))
    if(user_choice==1):

            print("You have chosen Able as for Simulation\n")
            print("Pls Enter the number of customers\n")
            number_of_customers=int(input())
            ableBakerPriority=0
            selectCustomerOrTime = True
            customerCount = number_of_customers
            if(selectCustomerOrTime):
                count = customerCount
            else:
                count = timeLength
            Output = customerlistGenerator(customerIntervalArrivalTime, ableServiceTime, bakerServiceTime, ableBakerPriority, selectCustomerOrTime, count)
    if(user_choice==2):

            print("You have chosen Able as for Simulation\n")
            print("Pls Enter the number of customers\n")
            number_of_customers=int(input())
            ableBakerPriority=1
            selectCustomerOrTime = True
            customerCount = number_of_customers
            if(selectCustomerOrTime):
                count = customerCount
            else:
                count = timeLength
            Output = customerlistGenerator(customerIntervalArrivalTime, ableServiceTime, bakerServiceTime, ableBakerPriority, selectCustomerOrTime, count)
    if(user_choice==3):

            print("You have chosen Able as for Simulation\n")
            print("Pls Enter the number of customers\n")
            number_of_customers=int(input())
            ableBakerPriority=2
            selectCustomerOrTime = True
            customerCount = number_of_customers
            if(selectCustomerOrTime):
                count = customerCount
            else:
                count = timeLength
            Output = customerlistGenerator(customerIntervalArrivalTime, ableServiceTime, bakerServiceTime, ableBakerPriority, selectCustomerOrTime, count)
    if(user_choice==4):
        exit()





    FinalOutput(Output)

    return 0
main()
