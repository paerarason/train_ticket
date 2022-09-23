public class child 
{
    String Name;
    int Age;
    String Gender;
    child(String Name,int Age,String Gender)
    {
       this.Name=Name;
       this.Age=Age;
       this.Gender=Gender; 
    }
    public void print_kids()
     {
      System.out.println("   Name      : "+Name);
      System.out.println("   Age       : "+Age);
      System.out.println("   Gender    : "+Gender);
     }
}
