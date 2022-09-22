public class Poly{
  public static void main(String[] args){
    Employee e1 = new Employee();
    Manager m1 = new Manager();
    m1.validate(2, 3);
  }
}

class Employee{
  String name;
  String age;

  boolean validate(){
      checkName();
      checkAge();
      return true;
  }

  private void checkName(){
    System.out.println("checked Name");
  }

  private void checkAge(){
    System.out.println("Check Age");
  }
}

class Manager extends Employee{

  void checkStatus(){
    System.out.println("Present in Office");
  }
  @Override
  boolean validate() {
    System.out.println("Manager validated");
    return true;
  }

  // Here this is static polymorphism, which is done using Overloading
  // OverLoading
  boolean validate(int x, int y){
    System.out.println(" --> ");
    return x == y;
  }
}

class Supervisor extends Employee{ 
  // This is dynamic polymorphism, which is done using Overriding
  @Override
  boolean validate() {
    System.out.println("--> -->");
    return true;
  }
}