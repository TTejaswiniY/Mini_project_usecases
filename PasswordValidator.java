import java.util.Scanner;
public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            boolean Upper=false;
            boolean Digit=false;
            boolean isValid =true;
        if(password.length()<8){
            System.out.println("Password must be at least 8 characters long.");
            isValid=false;
        }      
        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);
            if(Character.isUpperCase(ch)){
                Upper=true;
            }
            if(Character.isDigit(ch)){
                Digit=true;
            }
        }
        if(!Digit){
            System.out.println("Password must contain at least one digit.");
            isValid=false;
        }
        if(!Upper){
            System.out.println("Password must contain at least one uppercase letter.");
            isValid=false;
        }
        if(isValid){
            System.out.println("Password is valid.");
            break;
        }else{
            System.out.println("Password is invalid, Please try again.");
        }
    }
    sc.close();

    }
}
        
