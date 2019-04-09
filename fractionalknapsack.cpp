#include<cstdlib>
#include<iostream>
using namespace std;
float W[5], B[5], X[5], RW, TB=0;
int i,j;

int main(int argc, char *argv[])
{
	cout<<"Enter the weight of Knapsack:";
	cin>>RW;
	cout<<endl;
	//input the weight and benefit of each item
	for(i=0;i<5;i++)
		{
			cout<<"weight item"<<i+1<<"=";
			cin>>W[i];
			cout<<"Benefit item"<<i+1<<"=";
			cin>>B[i];
		
	//calculate value of X
			X[i]=B[i]/W[i];
			cout<<"Benefit for unit weight of item"<<i+1<<"="<<X[i];
			cout<<endl;
			cout<<endl;
		}
	//descending bubble sort to find largest number of X
	float temp;
	float temp1;//to make W follow X
	float temp2;//to make B follow X

	for(i=0;i<=4;i++)
		{
			for(j=0;j<4;j++)
				if(X[j]<X[j+1])
				{
					temp=X[j];
					temp1= W[j];
					temp2 = B[j];

					X[j]=X[j+1];
					W[j]=W[j+1];
					B[j]=B[j+1];

					X[j+1]=temp;
					W[j+1]=temp1;
					B[j+1]=temp2;

				}
		}

	for(i=0;i<5;i++)
	{
		if(RW>=0)
		{
			RW=RW-W[i];
			TB=TB+B[i];
		}
		if(RW<0)
		{
			cout<<"X="<<" "<<endl;

			TB=TB +RW*X[i];
		}
	}

	//output
	cout<<"the total benefit is :"<<TB<<endl;
	cout<<"RW:"<<RW<<endl;
	system("PAUSE");
	return EXIT_SUCCESS;
		
	

}