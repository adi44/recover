#include "random"
#include "iostream"
#include "ctime"
using namespace std;
class Caller{

public:

	int intervaltime=0;
	int ArrivalTime=0;
	int whenAbleAvailable=0;
	int whenBakerAvailable=0;
	int serverChosen=0;
	int serviceTime=0;
	int timeServiceBegins=0;
	int ableServiceCompletedTime=0;
	int bakerServiceCompletedTime=0;
	int callerDelay=0;
	int timeInsystem=0;

 	int caller(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8,int i9,int i10,int i11)
 	{
 		intervaltime=i1;
 		ArrivalTime=i2;
 		whenAbleAvailable=i3;
 		whenBakerAvailable=i4;
 		serverChosen=i5;
 		serviceTime=i6;
 		timeServiceBegins=i7;
 		ableServiceCompletedTime=i8;
 		bakerServiceCompletedTime=i9;
 		callerDelay=i10;
 		timeInsystem=i11;
 	}


int getIntervalTime(int customerList[])
{

 	int randomcustomerList= customerList[rand()%10];
 	return randomcustomerList;
}

int getAbleorBaker(int AbleAvailTime, int BakerAvailTime, int Priority)
{
	if(AbleAvailTime==BakerAvailTime)
	{
		if(Priority==2)
		{
			int select= rand();
			return select;
		}
		else
		{
			return Priority;
		}
	}
	else
	{
		if(AbleAvailTime<BakerAvailTime)
		{
			return 0;
		}
		else
		{
			return 1;
		}

	}
}
int getServiceTime(int ableorbaker, int ablelist[10],int bakerlist[10])
{
	if(ableorbaker==0)
	{
		srand(time(0));
		long int ablelistrandom = ablelist[rand()%10];
		return ablelistrandom;
	}
	else
	{
		srand(time(0));
		long int bakerlistrandom=bakerlist[rand()%10];
		return bakerlistrandom;
	}
}
int customerGenerator(int customertimelist[10], int ablelist[10],int bakerlist[10], int priority, int customerOrTime, int count)
{
	int customerlist[10];
	int Servtime;
	if(customerOrTime)
	{
		for(int i=0; i<count;i++)
		{
			if(customerlist==NULL)
				if(priority==2)
				{
					int prioritylist[2]={0,1};
					priority=prioritylist[rand()%2];
				}
				if(priority==0)
				{
					Servtime= ablelist[rand()%10];
					customerlist[i]=caller(0,0,0,0,0, Servtime,0,Servtime,0,0,0);
				}
				if(priority==1)
				{
					Servtime= bakerlist[rand()%10];
					customerlist[i]=caller(0,0,0,0,1,Servtime,0,0,Servtime,0,0);
				}
			else
			{
				int interArrVlTime= getIntervalTime(customertimelist);
				int timeInSystem=customerlist[sizeof(customerlist)-1].ArrivalTime
			}
		}
	}
}
};
int main()
{

}
