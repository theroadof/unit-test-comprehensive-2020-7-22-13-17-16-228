package example;

public class PlayGame {
    public static void main(String args[]){
        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerProvider());
        guessNumberGame.playGame();
    }
}
