
/**
*Name: Sean Pratt
*Course: CNT 4714 Spring 2017
*Assignment title: Project 2 – Multi-threaded programming in Java
*Date: February 12, 2017
*
* Class: ConveyorBelt
**/


import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ConveyorBelt {
    
    
   public static void main(String[] args) throws FileNotFoundException, IOException {
        
    int id = 0;
    int workload = 1;
    List<Integer> list = new ArrayList<Integer>();
  
    BufferedReader file = new BufferedReader(new FileReader("config.txt"));
    String line;
    while((line = file.readLine()) !=null){
       list.add(Integer.parseInt(line));
    }
    
    Conveyor previousConveyor = null;
    
    List<Station> statList = new ArrayList<Station>();
    
    for(int i =0; i<list.get(0);i++){
        Station Stat = new Station(i, list.get(i+1));
        statList.add(Stat);
        Conveyor Conv = new Conveyor(i);
        if(previousConveyor != null)
            Stat.attachConveyor(previousConveyor);
        Stat.attachConveyor(Conv);
        previousConveyor = Conv;
    }
    statList.get(0).attachConveyor(statList.get(statList.size()-1).getLastConveyor());
    for(Station stat : statList){
        stat.start();
    }
    
    
    
  }  
}
