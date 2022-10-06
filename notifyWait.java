import java.util.*;
import java.lang.*;

// Multi-thread processing...
public class notifyWait{
  public static void main(String[] args){
     Data d = new Data();
     Thread sender = new Thread(new Sender(d));
     Thread receiver = new Thread(new Receiver(d));

     sender.start();
     receiver.start();
  }
}

class Data{
  private String packet;
  int maxPackageSize = 4;
  private boolean transfer = true;

  // transfer == false, means -> receive is active, sender should be in wait
  public synchronized String get(){
     if(transfer){
      try{ wait(); }catch(Exception e){}
     }
     transfer = !transfer;
     notifyAll();
     return packet;
  }
  public synchronized void set(String s){
    if(!transfer){
      try{ wait(); }catch(Exception e){}
    }
    this.packet = s;
    transfer = !transfer;
    notifyAll();
  }
}

class Sender implements Runnable{
  Data d;
  String[] packets = {"First", "Second", "Third"};

  Sender(Data d){
    this.d = d;
  }
  public void run(){
     for(String p: packets){
      d.set(p);
      try{
        // Sender will send packet fast
        Thread.sleep(500);
      }catch(Exception e){
        System.out.println("Something wrong...");
      }
     }
  }
}

class Receiver implements Runnable{
  Data d;

  Receiver(Data d){
    this.d = d;
  }
  public void run(){
    for(int i = 0; i < d.maxPackageSize; i++){
      String receive = d.get();
      System.out.println(receive + " " + "received");
      try{
        // Here we can see, even receiver receive the packet late, sender will still wait for receiver to receive than only it will send the other packet.
        Thread.sleep(3000);
      }catch(Exception e){
        System.out.println("Something wrong...");
      }
    }
  }
}

