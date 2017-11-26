/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer_consumer_problem;

import java.util.logging.Level;
import java.util.logging.Logger;
//wannst ds mochst bruachst nd imma producer_consumer schreiben
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
            synchronized(Producer_consumer_problem.class){
                if (Producer_consumer_problem.count >= Producer_consumer_problem.N) { 
                    synchronized(this){this.wait();}
                } 
            }

            
            synchronized(Producer_consumer_problem.class){
                insert_item(item); 
                Producer_consumer_problem.count++; 
                System.out.println(count);
            }
            
            
             synchronized(Producer_consumer_problem.class){
                if (Producer_consumer_problem.count >= 1) { 
                    synchronized(Producer_consumer_problem.c){Producer_consumer_problem.c.notify();}
                } 
             }
        
        }
        
    
    }

    private int produce() {
        return 1010;
    }

    private void insert_item(int item) {
        System.out.println("insert_item");
    }
}
