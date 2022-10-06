import java.io.*;
import java.util.*;

public class Exceptionhandling {
  public static void main(String[] args) throws FileNotFoundException {
    try {
      // solve();
      // error1(1);
      // error1(3);
      // error1(2);
      error2();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(" Error Message " + e.getMessage());
    }
  }

  public static void solve() throws GeneralException {
    throw new GeneralException("this is not Good");
  }

  static void error1(int i) throws IOException, FileNotFoundException, ArithmeticException{
    if(i == 1){
      throw new IOException("IO exception...");
    }else if(i == 2){
      throw new FileNotFoundException("File not found...");
    }else{
      throw new ArithmeticException("Arithmetic Exception...");
    }
  }

  static void error2() throws GeneralException2{
    throw new GeneralException2();
  }
}

// How to make a general Exception handling.
class GeneralException extends Exception {
  GeneralException(String message) {
    super(message);
  }
}

class GeneralException2 extends Exception{
  @Override
  public String getMessage() {
    return "This is a Error message form GE 2";
  }
}