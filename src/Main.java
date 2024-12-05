import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Get username and show in output

        Scanner getUserName = new Scanner(System.in);
        System.out.println("Enter your name:");

        String userName = getUserName.nextLine();
        String concatName = "My name is:" + " " + userName;

        System.out.println(concatName);

        // Get user number and check it is even

        Scanner getUserNumber = new Scanner(System.in);
        System.out.println("Enter your number:");

        int userNumber = getUserNumber.nextInt();

        if(userNumber % 2 == 0) {
            System.out.println(userNumber + " is even");
        }else{
            System.out.println(userNumber + " is odd");
        }

        for (int i = 0; i<100; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }

       System.out.println(sum(2, 2));
    }

    private static int sum(int x, int y) {
        return x + y;
    }
}