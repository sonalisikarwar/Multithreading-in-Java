
package shivaafoundation.javatutorial;
//suspending and resuming a thread the modern way
class NewThread implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;
    NewThread(String threadname){
        name = threadname;
        t=new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
        public void run() {
            try {
                for(int i=15; i>0;i--)
                    System.out.println(name + ":"+i);
                Thread.sleep(200);
                synchronized(this){
                    while(suspendFlag){
                        wait();
                    }
                }
                    
            }
        }catch (InterruptedException e){
    System.out.println(name+ "interrupted");
}
   System.out.println(name + "exiting.");     
    }
synchronized void mysuspend(){
suspendFlag = true;

}
synchronized void myresume(){
suspendFlag = false;
notify();
}
    
}
class SuspendResume{
    public static void main(String args[]){
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
try{
    Thread.sleep(1000);
    ob1.mysuspend();
    System.out.println("Suspendeing thread One");
    Thread.sleep(1000);
    ob1.myresume();
    System.out.println("Resuming thread One");
    ob2.mysuspend();

    System.out.println("Suspendeing thread Two");
    Thread.sleep(1000);
    ob2.myresume();
    System.out.println("Resuming thread Two");
    

}catch (InterruptedException e){
    System.out.println("Main.thread interrupted");
}
try{
        System.out.println("Waiting for threads to finish.");
        ob1.t.join();
        ob2.t.join();
} catch (InterruptedException e){
    System.out.println("Main thread Interrupted");
}
   System.out.println("Main thread exiting");
    }
}


//Using join() to wait for threadsto finish
class NewThread implements Runnable {
    String name;
    Thread t;
    
    NewThread(String threadname){
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread:" + t);
        t.start();
        
    }
    public void run(){
        try {
            for(int i=5; i > 0; i--){
                System.out.println(name + ":" +i);
                Thread.sleep( 1000 );
            }
        } catch (InterruptedException e){
            System.out.println(name + "interrupted ");
            
        }
                    System.out.println(name + " exiting ");

    }
}
class DemoJoin{
    public static void main (String args[]){
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");
            System.out.println("Thread One is alive:" + ob1.t.isAlive());
            System.out.println("Thread Two is alive:" + ob2.t.isAlive());
            System.out.println("Thread One is alive:" + ob3.t.isAlive());
            try {
                            System.out.println("Waiting for threads to finish.");
                            ob1.t.join();
                            ob2.t.join();
                            ob3.t.join();
            } catch (InterruptedException e){
            System.out.println("Main thread Interrupted");
            }
            System.out.println("Thread One is alive:" + ob1.t.isAlive());
            System.out.println("Thread Two is alive:" + ob2.t.isAlive());
            System.out.println("Thread One is alive:" + ob3.t.isAlive());
            System.out.println("Main thread exiting.");



            }

    }


//create multiple threads
class NewThread implements Runnable {
String Name;
Thread t;

NewThread(String threadname) {
name = threadname;
t = new Thread(this, name );
System.out.println("New thread:" +t);
t.start();
}
public void run(){
    try {
        for(int i =5; i>0; i--)
            System.out.println(name + ":" +i);
        Thread.sleep(1000);
            
    }
} catch (InterruptedException e){
    System.out.println(name + "Interrupted");
}
System.out.println(name + " exiting .");
}
}
class MultiThreadDemo {
    public static void main(String args[]){
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            System.out.println("Main thread Interrupted");
            System.out.println( " Main thread exiting .");
        }

    }

//create second thread
class NewThread implements Runnable {
    Thread t ;
    NewThread(){
        t = new Thread(this,"Demo Thread");
        System.out.println("Child thread:" + t);
        t.start();
    }
    public void run(){
        try {
            for(int i=5; i>0; i--) {
                System.out.println("Child thread:" + i);
            Thread.sleep( 500 );
        }
    } catch (InterruptedException e) {
                 System.out.println("Child interrupted.");
                 }
         System.out.println("Exiting child thread." );
    }
    }
    class ThreadDemo{
        public static void main(String args[ ]){
            new NewThread();
            try {
                for(int i=5;i>0; i--) {
                    System.out.println("Main thread :"  + i);
                Thread.sleep( 1000 );
                
            }
        } catch (InterruptedException e){
                System.out.println( "Main thread interrupted." );
    }
        System.out.println(" Main thread exiting." );
    }
    }


//create a second thread by extending Thread
class NewThread extends Thread{
    
    NewThread(){
        super("Demo Thread");
        System.out.println("Child thread:" + this);
        start();
    }
    public void run(){
        try {
            for(int i=5; i>0; i--){
                System.out.println("Child thread:" + i);
            Thread.sleep( 500 );
        }
    } catch (InterruptedException e) {
                 System.out.println("Child interrupted.");
                 }
         System.out.println("Exiting child thread." );
    }
    }
    class ExtendThread{
        public static void main(String args[]){
            new NewThread();
            try {
                for(int i=5;i>0; i--) {
                    System.out.println();
                Thread.sleep(1000);
                
            }
        } catch (InterruptedException e) {
                System.out.println( "Main thread interrupted." );
    }
        System.out.println(" Main thread exiting." );
    }
    }

