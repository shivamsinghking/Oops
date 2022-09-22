public class Interface{
  public static void main(String[] args){
    Employee e1 = new Employee();
    Manager m1 = new Manager();

    m1.validate(2, 3);
  }
}

interface ICustomer{
  void checkName();
}

// Interface is a type of contract, contract is something built b/w developer 1 and deveoper 2.
// Here GoldCustomer has to follow ICustomer format

abstract class Customer implements ICustomer{
  public abstract void checkName();
}

class GoldCustomer extends Customer{
  public void checkName(){
    System.out.println("--> cheked Name");
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

  // OverLoading
  boolean validate(int x, int y){
    System.out.println(" --> ");
    return x == y;
  }
}
