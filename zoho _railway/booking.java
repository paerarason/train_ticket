import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.ArrayList; 
public  class booking
{
   static int Candidate_id=1;
   static int UB=27;
   static int MB=18;
   static int LB=18;
   
  static HashMap<Integer,Pasenger>cnf=new HashMap<>();

   static  ArrayList<Pasenger>SL=new ArrayList<>(9);
   static  LinkedList<Pasenger>RAC=new LinkedList<>();
   static  LinkedList<Pasenger>WL=new LinkedList<>();
   Scanner s = new Scanner(System.in);
   
    //booking 
    public  void  book()
    {
     
      System.out.println(".......Enter the name........");
      String Name=s.nextLine();
      System.out.println(".......Enter the Age........");
      int Age=s.nextInt(); 
      s.nextLine();
      System.out.println(".......Enter the Gender........");
      
      String Gender=s.nextLine();
      System.out.println(".......Enter the Berth Preference........");
      String  Berth_Preference=s.nextLine();
      ArrayList<child>kids=new ArrayList<>();
      
      
    //KIDS DETAILS
      System.out.println("..........numbers of  Kids pasengers............");
      int sizeof_child=s.nextInt();
         if(sizeof_child!=0)
         {
               for(int i=0;i<sizeof_child;i++)
                 {
                  s.nextLine();
                  System.out.println(".......Enter the name........");
                  String Name_child=s.nextLine();
                  System.out.println(".......Enter the Age........");
                  int Age_child=s.nextInt();
                  s.nextLine();

                  System.out.println(".......Enter the Gender........");
                  String Gender_child=s.nextLine();

                  child temp=new child(Name_child,Age_child,Gender_child); 
                  kids.add(temp);
                 }
         }
      
      Pasenger person=new Pasenger(Name, Age, Gender, Berth_Preference,Candidate_id,kids); 
      if(cnf.size()<=63)
         { 
          allocation(person);
          cnf.put(Candidate_id,person);      
         }
      else if(RAC.size()<18)
           { 
             person.allocated="RAC";
             RAC.add(person);
            }
      else if(WL.size()<=10)
           {
             person.allocated="waiting list";
             WL.add(person);
           }
            
      else
        System.out.print(" TIckets not available ");
    Candidate_id++;
    }
   
  
   //CANCELL 
    public  void cancel(int id) 
     {
        
      if(cnf.containsKey(id))
           {
            if(cnf.get(id).allocated.equals("LB"))
              {
               LB++;
               cnf.remove(id);
              }
            else if(cnf.get(id).allocated.equals("MB"))
            {
             MB++;
             cnf.remove(id);
            }
            else if(cnf.get(id).allocated.equals("UB"))
            {
             UB++;
             cnf.remove(id);
            }
            if(RAC.size()>1)
            {
            Pasenger temp=RAC.removeFirst();
            allocation(temp);
            cnf.put(temp.ID,temp);
            }
            
            
          }

      else if(RAC.size()<=18)
          { 
            int key=present(id,RAC);
            if(key<RAC.size())
             {
              RAC.remove(key);
              Pasenger temp=WL.removeFirst();
              RAC.add(temp);
             }
            }
      else if(WL.size()<10)
          {
          
               int key=present(id,WL);
                WL.remove(key);
          }
      else     
        {
          System.out.print(" ..........TIckets id not found ....... ");
        }   
     }


    // PRINT THE PASENGER  DETAILS METHOD 
    public void print()
    {
      
       for(Pasenger p:cnf.values())
        {
         p.pasenger_print();
        }

        for(Pasenger p:RAC)
        {
          p.pasenger_print();
        }

       //
       for(Pasenger p:WL)
        {
         p.pasenger_print();
        }
    }



  //TICKET DETAILS 
   public void TICKET()
    {  
      System.out.println("  CONFORMED TICKETS\n   "+cnf.size()+"\n     upper berth="+(27-UB)+"\n      Lower    ="+(18-LB)+"\n    middle    = "+(18-MB));
      System.out.println("  RAC  TICKETS     \n   "+RAC.size());
      System.out.println("  WL  TICKETS      \n   "+WL.size());
    }



  
    private static int present(int id,LinkedList<Pasenger> list)
    {
      for(int i=0;i<list.size();i++)
           {
            if(list.get(i).ID==id)
            {
              return i;
            }
           }
           return list.size()+1;
    }




    
    public  void  allocation(Pasenger p)
    {
    if(((p.Gender.equals("Female")|| p.Age>60) && (p.kids.size()>0)) || ((p.Berth_Preference.equals("LB")) || ((LB>0)&&(MB==0 && UB==0))))
      {
        p.allocated="LB";
        LB--;
      }
    else if(p.Berth_Preference.equals("UB") && (UB>0))
      {  
        p.allocated="UB-";
        UB--;    
      }
    else if(p.Berth_Preference.equals("MB") && (MB>0))
      {
        p.allocated="MB-";
        MB--;
      }
    else 
      {
        if(MB>0)
        {
          p.allocated="MB-";
          MB--;
        }
        else if(UB>0)
        {
          p.allocated="UB-";
          UB--;   
        }
        else if(LB>0)
        {
          p.allocated="LB";
          LB--;
        }
      }
    }
}
