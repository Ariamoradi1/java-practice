//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

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