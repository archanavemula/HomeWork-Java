package com.advjava.hw3;
import java.util.concurrent.Semaphore;

/**
  * 
  * @author archana
  * This class is to run multiple threads 
  *
  */
public class ThreadDeadLockDemo {
	
	 
 public static void main(String[] args) throws InterruptedException {
	 
	/*
	* semaphores
	*/
	 Semaphore lock1 = new Semaphore (1);
	 Semaphore lock2 = new Semaphore (1);
	 Semaphore lock3 = new Semaphore (1);
		  
	// for(int i=0; i<1000;i++) {
	 Thread thread1 = new Thread(new DeadLockTask(lock1,lock2,lock3));	 
	 Thread thread2 = new Thread(new DeadLockTask(lock1,lock2,lock3));
	 Thread thread3 = new Thread(new DeadLockTask(lock1,lock2,lock3));
	 
	 thread3.start();
	 thread1.start();
	 thread2.start();
	 
	thread1.join();
	thread2.join();
	thread3.join();
	 System.out.println("Lucky! No deadlock occured!!!");

}
}

 class DeadLockTask implements Runnable {
	 
	 Semaphore lock1;
	  Semaphore lock2;
	  Semaphore lock3;
	 public DeadLockTask(Semaphore lck1,Semaphore lck2,Semaphore lck3) {
		// TODO Auto-generated constructor stub
		  lock1 = lck1;
		  lock2 =  lck2;
		  lock3 = lck3;
	}
	 
	 @Override
	public void run() {
		// TODO Auto-generated method stub
		 System.out.println("thread started");
         try {
             // Adding delay so that both threads can start trying to
             // lock resources
        	 Thread t = Thread.currentThread();

        	 lock1.acquire();
             System.out.println(t + " acquired " + lock1);

             Thread.sleep(200); // demonstrate deadlock

             lock2.acquire();
             System.out.println(t + " acquired " + lock2);
             
             lock3.acquire();
             System.out.println(t + " acquired " + lock3);

             Thread.sleep(1000);
             
             lock3.release();
             System.out.println(t + " released " + lock3);
             
             lock2.release();
             System.out.println(t + " released " + lock2);

             lock1.release();
             System.out.println(t + " released " + lock1);
             
        	 lock1.acquire (); 
        	 System.out.println("Lock aquire : lock1" );
             lock2 . acquire ();
             System.out.println("Lock aquire : lock2" );
             
             Thread.sleep(200);
             
             //critical section
             lock2 . release (); 
             System.out.println("Lock release : lock1" );
             lock1 . release ();
             System.out.println("Lock release : lock2" );
            
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
	}
 }



