import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class locks{
  public static void main(String[] args){
    ReentrantLock lock = new ReentrantLock();
    ExecutorService threadPool = Executors.newFixedThreadPool(5);
    Runnable r1 = new Worker("JOBS1", lock);
    Runnable r2 = new Worker("JOBS2", lock);
    Runnable r3 = new Worker("JOBS3", lock);
    Runnable r4 = new Worker("JOBS4", lock);

    threadPool.execute(r4);
    threadPool.execute(r2);
    threadPool.execute(r1);
    threadPool.execute(r3);
    threadPool.shutdown();
  }
}

class Worker implements Runnable{
  String name;
  ReentrantLock lock;

  Worker(String name, ReentrantLock l){
    this.name = name;
    this.lock = l;
  }

  public void run(){
    boolean isDone = false;
    while(!isDone){
      // try lock is check if lock available, then lock it and return true, otherwise false
      boolean canAcquireLock = lock.tryLock();
      if(canAcquireLock){
          try{
            System.out.println("Thread " + name + " is running..." + "--" + Thread.currentThread().getName());
            Thread.sleep(500);
          }catch(Exception e){
            System.out.println("Something went wrong in " + name);
          }finally{
            lock.unlock();
            System.out.println(name + "is done...");
            isDone = true;
          }
          
      }else{
        try {
          System.out.println(name + "is waiting...");
          Thread.sleep(2000);
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    }
  }
}
