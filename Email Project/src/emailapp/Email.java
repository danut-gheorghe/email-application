package emailapp;
import java.util.*;
import java.io.*;

public class Email {
    public Scanner scan = new Scanner(System.in);
    //Setting variables as private to not give access directly
    private String firstName;
    private String lastName;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    //Constructor to receive the first name, last name...
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: "+this.firstName+" "+this.lastName);

        //Calling methods
        this.dept = this.setDepartment();
        this.password = this.generatePassword(8); //password
        this.email = this.generateEmail(); // email generation

    }

    //Generating email method
    private String generateEmail(){
        return this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }

    //Asking for the department
    private String setDepartment(){
        System.out.println("Department codes \n 1 - Sales \n 2 - Development \n 3 - Accounting \n 0 - Nothing");
        boolean flag = false;
        do{
            System.out.println("Enter the department code:");
            int choice = scan.nextInt();
            switch (choice){
                case 1 :
                    return "Sales";

                case 2 :
                    return "Development";

                case 3:
                    return "Accounting";

                case 0 :
                    return "None";

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }while (!flag);
        return null;
    }

    //Generating random password method
    private String generatePassword(int length){
        Random random = new Random();
        String capitalCharacters = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        String smallCHaracters = "abcdefghijklmnopqrstuvxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*?";
        String values = capitalCharacters + smallCHaracters + numbers + symbols;
        String password = "";
        for(int i =0; i<length;i++){
            password=password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    //Changing password
    public void setPassword(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password?(Y/N)");
            char choice = scan.next().charAt(0);
            if(choice == 'Y' || choice == 'y'){
                flag = true;
                System.out.println("Enter current password:");
                String temp = scan.next();
                if(temp.equals(this.password)){
                    System.out.println("Enter the new password:");
                    this.password = scan.next();
                    System.out.println("password changed successfully");
                }
                else{
                    System.out.println("Incorrect password!");
                }
            }
            else if(choice == 'N' || choice == 'n'){
                    flag = true;
                System.out.println("Password changed option canceled.");
            }
            else{
                System.out.println("Enter valid choice!");
            }
        } while (!flag);
    }

    //Setting mailbox capacity method
    public void setMailCapacity(){
        System.out.println("Current capacity ="+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = scan.nextInt();
        System.out.println("Mailbox capacity is successfully changed!");
    }
    //Setting alternate email
    public void setAlter_email(){
        System.out.println("Enter new alternate email: ");
        this.alter_email = scan.next();
        System.out.println("Alternate email is set!");
    }

    //Display user information
    public void getUserInfo(){
        System.out.println("New:"+this.firstName+" "+this.lastName);
        System.out.println("Department:"+this.dept);
        System.out.println("Email:"+this.email);
        System.out.println("Password:"+this.password);
        System.out.println("Mailbox:"+this.mailCapacity+"mb");
        System.out.println("Alternate mail:"+this.alter_email);
    }

    //Store in File

    public void storeFile(){
        try {
            FileWriter in = new FileWriter("C:\\Users\\40760\\Desktop\\info\\info.txt");
            in.write("First Name:"+this.firstName);
            in.append("\nLast Name:"+this.lastName);
            in.append("\nEmail:"+this.email);
            in.append("\nPassword:"+this.password);
            in.append("\nCapacity:"+this.mailCapacity);
            in.append("\nAlternate email:"+this.alter_email);
            in.close();
            System.out.println("Data Stored...");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //Reading file method
    public void readFile(){
        try{
            FileReader f1 = new FileReader("C:\\Users\\40760\\Desktop\\info\\info.txt");
            int i;
            while((i=f1.read())!=-1){
                System.out.println((char)i);
            }

            f1.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
