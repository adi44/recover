
import java.util.*;
import java.io.*;
class Server {
    //public boolean busy = false;
    public int whenAvailable = 0;
    public static double[][] serviceProb = new double[4][2];
    Random rgen = new Random();
    public static int endTime;
       
    public Server(char server){
        if(server == 'a'){
           ableServiceTime(); 
        }
        else if(server == 'b'){
           bakerServiceTime();
        } 
    }
    public static void ableServiceTime(){
       serviceProb[0][0] = 0.3;
       serviceProb[1][0] = 0.28;
       serviceProb[2][0] = 0.25;
       serviceProb[3][0] = 0.17;
       serviceProb[0][1] = serviceProb[0][0];
       serviceProb[1][1] = serviceProb[0][1]+serviceProb[1][0];
       serviceProb[2][1] = serviceProb[1][1]+serviceProb[2][0];
       serviceProb[3][1] = serviceProb[2][1]+serviceProb[3][0];
    }
    public static void bakerServiceTime(){
       serviceProb[0][0] = 0.35;
       serviceProb[1][0] = 0.25;
       serviceProb[2][0] = 0.2;
       serviceProb[3][0] = 0.2;
       serviceProb[0][1] = serviceProb[0][0];
       serviceProb[1][1] = serviceProb[0][1]+serviceProb[1][0];
       serviceProb[2][1] = serviceProb[1][1]+serviceProb[2][0];
       serviceProb[3][1] = serviceProb[2][1]+serviceProb[3][0];
    }
    public int serviceTime(char server){
        double rNumber = rgen.nextDouble();
        int tempTime=0;
        for(int i = 0 ; i <=3; i++){
            if(rNumber <= serviceProb[i][1]){
                tempTime = i;
                break;
            }
        }
        //calc real times
        int aTime = 0;
        if(server == 'a'){
            aTime = tempTime+2;
        }
        else if(server == 'b'){
            aTime = tempTime+3;
        }
        return aTime;
    }
    
    
}
class Customer {
    public int arrivalTime;
    public int serviceStartTime;
    public int serviceTime;
    public int customerNum;
    public int endTime;
    public static double[][] interarrivalProb = new double[5][2];
    Random rgen = new Random();
    
    public Customer(){
        interarrivalTable();
        double rTempOne = rgen.nextDouble();
        for(int i = 1 ; i <=4; i++){
            if(rTempOne <= interarrivalProb[i][1]){
                arrivalTime = i;
                break;
            }
        }
    }
    
    public static void interarrivalTable(){
       interarrivalProb[1][0] = 0.25;
       interarrivalProb[2][0] = 0.4;
       interarrivalProb[3][0] = 0.2;
       interarrivalProb[4][0] = 0.15;
       interarrivalProb[1][1] = interarrivalProb[1][0];
       interarrivalProb[2][1] = interarrivalProb[1][1]+interarrivalProb[2][0];
       interarrivalProb[3][1] = interarrivalProb[2][1]+interarrivalProb[3][0];
       interarrivalProb[4][1] = interarrivalProb[3][1]+interarrivalProb[4][0];
    }
    
}

public class AbleBaker {
    public static Server Able = new Server('a');
    public static Server Baker = new Server('b');
    public static Customer[] Customers = new Customer[10];
    public static int cumulativeInterarrival = 0;
    public static String server;
    //public static int endTime;
    public static int queueLength=0;
    public static Queue<Customer> customerQueue = new LinkedList<Customer>();
    static int waitingTimeSum = 0;
    static int serviceTimeSum = 0;
    static int arrivalTimeSum = 0;
    static int inSystemTimeSum = 0;
    static int timeInSystem = 0;
    
   
    public static void main(String[] args) {
        Customers[0] = new Customer();
        Customers[0].arrivalTime = 0;
        Customers[0].serviceStartTime = 0;
        Customers[0].serviceTime = Able.serviceTime('a');
        server = "      Able";
        Customers[0].endTime = Customers[0].serviceTime;
        timeInSystem = Customers[0].endTime - Customers[0].arrivalTime;
       // Able.busy = true;
        Able.whenAvailable = Customers[0].serviceTime;
        
        System.out.println("Cust    Inter   Cummu   Able    Baker   Serve   Start   Server  EndTime"
                + " Time in System");
        System.out.println(1 + "        " +Customers[0].arrivalTime+ "      "+ 
                cumulativeInterarrival+"        "+ Able.whenAvailable+ "        " +
                Baker.whenAvailable+"       "+Customers[0].serviceTime+
                "       "+Customers[0].serviceStartTime + server + "        "+ Customers[0].endTime
                + "     " + timeInSystem);
        for(int i = 1; i < 10; i++){
            Customers[i]= new Customer();
            int tempI=i;
                    
            cumulativeInterarrival += Customers[i].arrivalTime;
            update();
            
            //If Able frees up 
            if(Able.whenAvailable <= Baker.whenAvailable 
                   && Able.whenAvailable <= cumulativeInterarrival){
                
                Able.whenAvailable = Able.whenAvailable + Customers[i].serviceTime;
                
                Customers[i].serviceStartTime = cumulativeInterarrival;
                Customers[i].serviceTime = Able.serviceTime('a');
                Able.whenAvailable = cumulativeInterarrival 
                        + Customers[i].serviceTime;
                Customers[i].endTime = Customers[i].serviceStartTime + Customers[i].serviceTime;
                timeInSystem = Customers[i].endTime - cumulativeInterarrival;
            
            //If Baker frees up
            } else if (Baker.whenAvailable <= cumulativeInterarrival){
                Baker.whenAvailable = Baker.whenAvailable + Customers[i].serviceTime;
                Customers[i].serviceStartTime = cumulativeInterarrival;
                Customers[i].serviceTime = Baker.serviceTime('b');
                Baker.whenAvailable = cumulativeInterarrival 
                        + Customers[i].serviceTime;
                 Customers[i].endTime = Customers[i].serviceStartTime + Customers[i].serviceTime;
                 timeInSystem = Customers[i].endTime - cumulativeInterarrival;
            //If neither free up, add them to the Queue
            } else {
                //cumulativeInterarrival -= Customers[i].arrivalTime;
                customerQueue.add(Customers[i]);
                queueLength ++;
                i--;               
            }
            
            if( Customers[i].serviceTime == Able.serviceTime('a'))
            {
                server = "Able";
            }
            else
            {
                server = "Baker";
            }
            
            if(tempI == i){
            System.out.println(i + 1 + "        " +Customers[i].arrivalTime+"       "+
                    cumulativeInterarrival+"        "+Able.whenAvailable+"      "+
                    Baker.whenAvailable+"       "+Customers[i].serviceTime+"        "+
                    Customers[i].serviceStartTime + "       " + server +
                    "       " + Customers[i].endTime + "        " + timeInSystem);
            }
        }
    }
//-----------------------------------------------------------------------------
//update()
    public static void update(){
        Customer newCustomer;    
        while(!customerQueue.isEmpty()){
            if(Able.whenAvailable <= Baker.whenAvailable 
                   && Able.whenAvailable <= cumulativeInterarrival){
                newCustomer = customerQueue.remove();
                queueLength--;
                newCustomer.serviceTime = Able.serviceTime('a');
                Able.whenAvailable = Able.whenAvailable + newCustomer.serviceTime;
            } else if (Baker.whenAvailable <= cumulativeInterarrival){
                newCustomer = customerQueue.remove();
                queueLength--;
                newCustomer.serviceTime = Baker.serviceTime('b');
                Baker.whenAvailable = Baker.whenAvailable + newCustomer.serviceTime;
            } else {
                break;
            }
        }
    }
     public static void analytics(){
      //  avg waiting time
        //Probability cust in queue
        //Probability of Idle
        //Avg Service time
        //avg time between arrivals
        //avg waiting time
        //avg time in system
        
        for(int i = 0; i<Customers.length; i++){
            serviceTimeSum+=Customers[i].serviceTime;
            waitingTimeSum+=(Customers[i].serviceStartTime-Customers[i].arrivalTime);
            arrivalTimeSum+=Customers[i].arrivalTime;
            inSystemTimeSum+=(Customers[i].endTime-cumulativeInterarrival);
        }
    }

}

