package com.advjava.hw3;
import java.util.concurrent.Semaphore;

//Deadlock demo shared1 and shared2 will never end

public class DeadLockDemo 
{ 
    public static void main(String[] args) throws InterruptedException 
    { 
    	ObjShare obj1 = new ObjShare(); 
    	ObjShare obj2 = new ObjShare(); 
  
        Thread1 thread1 = new Thread1(obj1, obj2); 
        thread1.start(); 
        Thread2 thread2 = new Thread2(obj1, obj2); 
        thread2.start(); 
  
        // sleeping main thread 
        Thread.sleep(1000); 
    } 
} 


//This class is shared by both threads test1 wants to call test2 and test2 wants to call test1
//Both wait for each other and a deadlock happens.
class ObjShare 
{ 
	Semaphore lock1 = new Semaphore (1);
	Semaphore lock2 = new Semaphore (1);

 // first  method 
  public void shared1(ObjShare s2) throws InterruptedException 
 { 
	 lock1.acquire();
     System.out.println("shared1-started");
     Thread.sleep(1000); 

     s2.shared2(this); 
     System.out.println("shared1-ended"); 
     lock1.release();
 } 

 // second  method 
  public void shared2(ObjShare s1) throws InterruptedException 
 { 
	 lock2.acquire();
     System.out.println("shared2-started"); 
     Thread.sleep(1000); 

     s1.shared1(this); 
     System.out.println("shared2-ended"); 
     lock2.release();
 } 
} 

/**
 * First thread using test1 method.
 *
 */
class Thread1 extends Thread 
{ 
 private ObjShare s1; 
 private ObjShare s2; 

 public Thread1(ObjShare s1, ObjShare s2) 
 { 
     this.s1 = s1; 
     this.s2 = s2; 
 } 


 @Override
 public void run() 
 {  
     try {
		s1.shared1(s2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
 } 
} 

/**
 * Thread 2 using test2 method.
 *
 */
class Thread2 extends Thread 
{ 
    private ObjShare s1; 
    private ObjShare s2; 

    public Thread2(ObjShare s1, ObjShare s2) 
    { 
        this.s1 = s1; 
        this.s2 = s2; 
    } 
  
    @Override
    public void run() 
    { 

			try {
				s2.shared2(s1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    } 
} 



