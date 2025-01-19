package sinkdotcom;

import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numberOfGuess = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("YOUR GOAL IS TO SINK THREE DOT COMS.");
        System.out.println("PETS.COM , ETOY.COM, GO.COM");
        System.out.println("TRY TO SINK THEM ALL IN FEWEST NUMBER OF GUESSES");

        for(DotCom dotComSet:dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
             checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numberOfGuess++;
        String result = "miss";
        for(DotCom dotComToTest:dotComsList){
            result = dotComToTest.checkYourSelf(userGuess);
            if(result.equals("hit"))
                break;
            if(result.equals("kill"))
            {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("ALL DOT COMS ARE DEAD! YOUR STOCK IS NOW WORTHLESS");
        if(numberOfGuess<=18){
            System.out.println("IT ONLY TOOK YOU: "+ numberOfGuess + " GUESSES");
            System.out.println("YOU ARE OUT BEFORE YOUR OPTIONS SANK");
        }
        else {
            System.out.println("TOOK YOU LONG ENOUGH. " + numberOfGuess + " GUESSES");
            System.out.println("FISH ARE DANCING WITH YOUR OPTIONS");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }




}
