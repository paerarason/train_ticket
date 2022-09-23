import java.util.ArrayList;
public class Pasenger
 {
    String Name;
    int Age;
    String Gender;
    String  Berth_Preference;
    int ID;
    String ticket_status;
    String allocated="NO TICKET";
    ArrayList<child>kids;

    Pasenger(String Name,int Age,String Gender,String  Berth_Preference,int ID,ArrayList<child>kid)
    {
    this.Name=Name;
    this.Age=Age;
    this.Gender=Gender;
    this.Berth_Preference=Berth_Preference;
    this.ID=ID; 
    this.kids=kid;
    }
     public void pasenger_print()
     {
      System.out.println("");
      System.out.println("ID       : "+ID);
      System.out.println("Name       : "+Name);
      System.out.println("Age        : "+Age);
      System.out.println("Gender     : "+Gender);
      System.out.println("preference : "+Berth_Preference);
      System.out.println("Allocated  : "+allocated);
      for(child x:kids)
         {
           x.print_kids();
         }
     }
    
}
