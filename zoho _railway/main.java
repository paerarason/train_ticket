import java.util.Scanner; 
public class main
{

    public static void main(String[] args) 
    {
      Scanner sc = new Scanner(System.in);
      boolean key=true;
    while(key)
       {
       
        System.out.println("#1\n....for booking \n#2\n....for cancel \n#3\n....for print summery\n#4\n....for CURRENT STATUS:");
        int c=sc.nextInt();
        booking train=new booking(); 
        switch (c) {
                  case 1:
                {
                train.book();
                break;
                }
                 case 2:
                   {
                    System.out.println("....... id to cancel ........");
                    int temp=sc.nextInt();
                    train.cancel(temp);
                    break;
                  }

                case 3:
                    {
                     System.out.println("                 <<<pasengers details>>>              ");
                     train.print();
                     break;
                    }
                case 4:
                   {
                    System.out.println("                 <<<   TICKET DETAILS   >>>              ");
                     train.TICKET();
                     break;
                   }
                case 5:
                  {
                    key=false;
                    break;
                  }  
                default:
                  {
                     System.out.println(" enter valid task ");
                     break;
                  }
             }
       } 
    }
}