import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Here we can see the threadpoll is 3, that means 10 jobs will be assigned to 3 thread only, whenever a thread becomes free, new jobs is assigned to it. 
// But at max only 3 thread will be working
public class ThreadPool{
  public static void main(String[] args){
    ExecutorService pool = Executors.newFixedThreadPool(3);
    
    for(int i = 0; i < 10; i++){
      pool.execute(new Worker(i));
    }

    pool.shutdown();
  }
}

class Worker implements Runnable{
  private int num;
  Worker(int num){
    this.num = num;
  }
  public void run(){
    try{
        System.out.println(Thread.currentThread().getName() + " is running..." + "command " + num);
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " is done..." + " command " + num);
    }catch(Exception e){
      System.out.println("Something went wrong...");
    }
  }
}