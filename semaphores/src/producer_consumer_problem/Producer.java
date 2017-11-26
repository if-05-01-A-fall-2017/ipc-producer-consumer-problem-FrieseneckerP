/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer_consumer_problem;

import java.util.logging.Level;
import java.util.logging.Logger;

import static producer_consumer_problem.Producer_consumer_problem.*;
/**
 *
 * @author Pascal
 */
public class Producer extends Thread {
    
    @Override
    public void run (){
        try {
            producer();
        } catch (InterruptedException ex) {
            System.err.println("Fehler");
        }
    }
    
    void producer() throws InterruptedException { 
        Boolean acquired = false;
        int item; 
        
        while (true) { 
            
            item = produce();
            Producer_consumer_problem.available.acquire();
            acquired = true;
            if (Producer_consumer_problem.count >= Producer_consumer_problem.N) { 
                acquired = false;
                Producer_consumer_problem.available.release();
                synchronized(this){this.wait();}
            } 
            if(acquired)
                Producer_consumer_problem.available.release();
            
            available.acquire();
            insert_item(item); 
            Producer_consumer_problem.count++; 
            available.release();
            
            
            Producer_consumer_problem.available.acquire();
            if (Producer_consumer_problem.count >= 1) { 
                if(acquired){
                    Producer_consumer_problem.available.release();
                }
             
                synchronized(Producer_consumer_problem.c){Producer_consumer_problem.c.notify();}
            } 
            if(acquired){
                Producer_consumer_problem.available.release();
            }
        
        }
        
    
    }

    private int produce() {
        return 1;
    }

    private void insert_item(int item) {
        System.out.println("insert_item");
    }
}
