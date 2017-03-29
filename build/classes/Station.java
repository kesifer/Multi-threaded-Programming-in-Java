/**
*Name: Sean Pratt
*Course: CNT 4714 Spring 2017
*Assignment title: Project 2 – Multi-threaded programming in Java
*Date: February 12, 2017
*
* Class: Station
**/



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static javafx.application.Platform.exit;



public class Station extends Thread{
    
    int workload;
    ArrayList<Conveyor> conveyors = new ArrayList(); 
    int id;
    
    public Station (int id, int workload){
        super();
        this.workload = workload;
        this.id = id;
        System.out.println("Station " + id + ": workload set to " + workload + "." );
}
    
    public void attachConveyor(Conveyor conveyor) {

        if(conveyors.size() == 2){
            System.out.println("Station already connected to max conveyors");
            exit();
        }
        conveyors.add(conveyor);
        Collections.sort(conveyors, new Comparator<Conveyor>(){
            @Override
            public int compare(Conveyor conveyor2, Conveyor conveyor1) {
                Integer id1 = conveyor1.getId();
                Integer id2 = conveyor2.getId();
                return id1.compareTo(id2);
            }        
        });
        
         
        if(conveyors.size() == 1){
            System.out.println("Station" + id + ": In-Connection set to conveyor" + conveyor.getId() + ".");
        }
        else if(conveyors.size() == 2){
            System.out.println("Station" + id + ": Out-Connection set to conveyor" + conveyor.getId() + ".");
        } 
        
    }
    
    @Override
    public void run(){
      for(int i=0;i<workload;i++){  
        doWork(); 
      }
      System.out.println("* * Station " + id + ": workload successfully completed. * *");
    }
    
    public void doWork(){
       for(Conveyor conveyor : conveyors){
           conveyor.lock();
           System.out.println("Station " + id + " granted access to conveyor " + conveyor.getId());
       }
       for(Conveyor conveyor : conveyors){
           System.out.println("Station " + id + " successfully moves packages on conveyor " + conveyor.getId());
       }
       for(Conveyor conveyor : conveyors){
           conveyor.unlock();
           System.out.println("Station " + id + " released access to conveyor " + conveyor.getId());
       }
       
       
    }
    
    public Conveyor getLastConveyor(){
       return conveyors.get(conveyors.size()-1);
        
    }
    
    
    
    
    
}
