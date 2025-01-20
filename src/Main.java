import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[7];
        int index = (int)(Math.random()*(arr.length-2));
        for(int i = index;i<index+3;i++){
            arr[i] = 1;
        }
        for (int i :arr){
            System.out.print(i+",");
        }
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean isKill = true ;
        int guessCount = 0;
        System.out.println("User Enter Prompt:");
        do {
            userInput = scanner.nextInt();
            guessCount++;

            if(userInput>arr.length){
                System.out.println("OOPS!! you have gone too far!! Enter prompt between 0 to 7");
            }
            else if (arr[userInput] ==1){
                System.out.println("hit");
                arr[userInput] = -1;
            }
            else
                System.out.println("miss");
           if(hasThreeConsecutiveHits(arr)){
               isKill = false;
           }
        }while (isKill);
        System.out.println("Congratulations! You found all hits in " + guessCount + " guesses.");
    }
    public static boolean hasThreeConsecutiveHits(int arr[]){
        for (int i =0;i<arr.length-2;i++){
            if(arr[i] == -1 && arr[i+1] ==-1 && arr[i+2]==-1){
                return true;
            }
        }
        return false;
    }
}
