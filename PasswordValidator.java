import java.util.Scanner;
public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            boolean hasUpper=false;
            boolean hasDigit=false;
            boolean isValid =true;
        if(password.length()<8){
            System.out.println("Password must be at least 8 characters long.");
            isValid=false;
        }      
        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);
            if(Character.isUpperCase(ch)){
                hasUpper=true;
            }
            if(Character.isDigit(ch)){
                hasDigit=true;
            }
        }
        if(!hasUpper){
            System.out.println("Password must contain at least one uppercase letter.");
            isValid=false;
        }
        if(!hasDigit){
            System.out.println("Password must contain at least one digit.");
            isValid=false;
        }
        if(isValid){
            System.out.println("Password is valid.");
            break;
        }else{
            System.out.println("Please try again.");
        }
    }
    sc.close();

    }
}
        