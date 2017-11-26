/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer_consumer_problem;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pascal
 */
public class Producer_consumer_problem {
    static  int count = 0;
    final static int N = 10;
    static Consumer c;
    static Producer p;
    final static Semaphore available = new Semaphore(1); 
    
    /**
j     * @param args the command line arguments
     */
    public static void main(String[] args) {
       c = new Consumer();
       p = new Producer();
        c.start();
        p.start();
    }
    
}
