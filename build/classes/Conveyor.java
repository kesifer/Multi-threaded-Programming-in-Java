/**
*Name: Sean Pratt
*Course: CNT 4714 Spring 2017
*Assignment title: Project 2 – Multi-threaded programming in Java
*Date: February 12, 2017
*
* Class: Station
*/

import java.util.concurrent.locks.ReentrantLock;


public class Conveyor extends ReentrantLock {
    
    
    int id;

    public Conveyor(int id) {
        super();
        this.id = id;
        
    }
    
    public int getId() {
        return id;
    }
    
    
}
