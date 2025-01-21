import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[7];
        int guessCount  =0;

        ArrayList<Integer> list = new ArrayList<>();
        int index = (int) (Math.random() * (arr.length - 2));
        for (int i = index; i < index + 3; i++) {
            arr[i] = 1;
            list.add(i);
        }
        Scanner scanner = new Scanner(System.in);
        while (!list.isEmpty()){
            System.out.println("Enter prompt value");
            int userInput = scanner.nextInt();
            guessCount++;
            if (userInput<0 || userInput>arr.length){
                System.out.println("You gone to far away prompt value between 0 to 6");
            }
            else if ( arr[userInput]==1){
                System.out.println("hit");
                arr[userInput] = 0;
                list.remove(Integer.valueOf(userInput));
            }
            else
            {
                System.out.println("miss");
            }
            if (list.isEmpty()){
                System.out.println("kill");
                break;
            }
        }
        if (guessCount>5){
            System.out.println("It took you so long to guess : " + guessCount);
        }
        else {
            System.out.println("Great you took only " + guessCount + " number of guess ");
        }
    }
}