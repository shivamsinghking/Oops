import java.util.concurrent.locks.ReentrantLock;

public class deadlock{
  private ReentrantLock lock1 = new ReentrantLock();
  private ReentrantLock lock2 = new ReentrantLock();
  public static void main(String[] args){
    deadlock d = new deadlock();
    Thread t1 = new Thread(new Thread1(d));
    Thread t2 = new Thread(new Thread2(d));
    t1.start();
    t2.start();
  }

  void operation1(){
    lock1.lock();
    System.out.println("lock1 is acquired, waiting for lock2....");
    lock2.lock();
    System.out.println("lock2 is acquired");

    System.out.println("executing 1st operation...");

    lock2.unlock();
    lock1.unlock();
  }

  void operation2(){
    lock2.lock();
    System.out.println("lock2 is acquired, waiting for lock1....");
    lock1.lock();
    System.out.println("lock1 is acquired");

    System.out.println("executing 2st operation...");

    lock1.unlock();
    lock2.unlock();
  }
}

class Thread1 implements Runnable{
  deadlock d;

  Thread1(deadlock d){
    this.d = d;
  }
  @Override
  public void run() {
    // TODO Auto-generated method stub
    d.operation1();
  }
}

class Thread2 implements Runnable{
  deadlock d;
  Thread2(deadlock d){
    this.d = d;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    d.operation2();
  }
}