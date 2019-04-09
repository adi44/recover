#include <cstdlib>


#include <iostream>
using namespace std;
int main()

{
 struct node
      { 
int n;
char name[10];
         struct node*next;};
 struct node*p1,*temp,*list;
 list=NULL;
 for(int i=0;i<10; i++)
 {p1=new(node);
cout<<"________________STUDENT DETAILS_____________"<<endl;
 cout<<"Please Enter roll number of student "<<i+1<<":";


 cin>>p1->n;

cout<<"Enter name of the student";
cin>>p1->name;

 cout<<endl;
 p1->next=NULL;
     if(list==NULL){list=p1,temp=p1;}
     else{temp->next=p1;temp=p1;}
     }
     temp=list;
     while(temp!=NULL)
     {
    
    cout<<"pointer value is;"<<temp<<endl;
     cout<<"data stored;"<<temp->n<<endl;

    cout<<"Name is:"<<temp->name<<endl;
     temp=temp->next;
     cout<<endl;
     }
     system("PAUSE");
     return EXIT_SUCCESS;}