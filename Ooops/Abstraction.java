public class Abstraction{
  public static void main(String[] args){
    Employee e1 = new Employee();
    

  }
}

class Employee{
  String name;
  String age;

  // Abstraction is done using design phase, while Encapsulation is done during execution
  boolean validate(){
      // Only validate function should see outside
      checkName();
      checkAge();
      return true;
  }

  // here checkName and checkAge are made by developer and we don't want to anybody to access it, so we make it private
  private void checkName(){
    System.out.println("checked Name");
  }

  private void checkAge(){
    System.out.println("Check Age");
  }
}
