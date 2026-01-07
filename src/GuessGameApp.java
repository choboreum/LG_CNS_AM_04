import java.util.Scanner;

import lgcns.domain.game.GuessGame;

public class GuessGameApp {
    public static void main(String[] args) {
        int num = (int)(Math.random() * 100) + 1;

        GuessGame guessGame = new GuessGame();
        
        String result = guessGame.gameFor(num);
        //String result = guessGame.gameWhile(num);

        System.out.println(result);
    }
}
