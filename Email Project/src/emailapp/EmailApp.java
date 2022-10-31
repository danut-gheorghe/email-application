package emailapp;
import java.util.*;
public class EmailApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //User info
        System.out.println("Enter first name:");
        String fName = scan.next();
        System.out.println("Enter last name:");
        String lName = scan.next();

        //Creating object for Email class
        Email em1 = new Email(fName,lName);
        int choice  = -1;

        do{
            System.out.println("\n******\nenter your choice\n1.Show Info \n2.Change password \n3.Change mailbox capacity \n4.Set Alternate mail \n5.Store data in file \n6.Display data from file \n7.Exit");
            choice = scan.nextInt();
            switch(choice){
                case 1:
                    em1.getUserInfo();
                    break;
                case 2:
                    em1.setPassword();
                    break;
                case 3 :
                    em1.setMailCapacity();
                    break;
                case 4:
                    em1.setAlter_email();
                    break;
                case 5:
                    em1.storeFile();
                     break;
                case 6:
                    em1.readFile();
                      break;
                case 7:
                    System.out.println("Thank you for using our application!");
                default :
                    System.out.println("Invalid choice! Enter proper choice");

            }
        }while(choice!=5);
    }
}
