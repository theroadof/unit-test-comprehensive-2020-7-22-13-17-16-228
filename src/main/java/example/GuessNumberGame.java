package example;

import java.util.*;

public class GuessNumberGame {
    private List<Integer> answer;

    private AnswerProvider answerProvider;

    private int times;

    public GuessNumberGame(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
        this.answer = answerProvider.generateAnswer();
        times = 0;
    }

    public static void main(String[] args) {
//        Scanner player = new Scanner(System.in);
//        List<Integer> playerInput = new ArrayList<>();
//        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerProvider());
//        for(int i=0;i<6;i++){
//            for (int j = 0; j < 4; j++) {
//                playerInput.add(player.nextInt());
//            }
//            String answer = guessNumberGame.guessNumber(playerInput);
//            if (answer.equals("4A0B")) {
//                System.out.println(answer);
//                System.out.println("you win");
//                break;
//            }
//            System.out.println(answer);
//            playerInput.clear();
//            System.out.println("game times:"+guessNumberGame.getTimes());
//        }
//        if(guessNumberGame.getTimes()==6){
//            System.out.println("answer is:"+guessNumberGame.getAnswer());
//            System.out.println("game over!you lose!");
//        }
        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerProvider());
        playGame(guessNumberGame);
    }

    public static void playGame(GuessNumberGame guessNumberGame){
        Scanner player = new Scanner(System.in);
        List<Integer> playerInput = new ArrayList<>();
//        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerProvider());
        for(int i=0;i<6;i++){
            for (int j = 0; j < 4; j++) {
                playerInput.add(player.nextInt());
            }
            String answer = guessNumberGame.guessNumber(playerInput);
            if (answer.equals("4A0B")) {
                System.out.println(answer);
                System.out.println("you win");
                break;
            }
            System.out.println(answer);
            playerInput.clear();
            System.out.println("game times:"+guessNumberGame.getTimes());
        }
        if(guessNumberGame.getTimes()==6){
            System.out.println("answer is:"+guessNumberGame.getAnswer());
            System.out.println("game over!you lose!");
        }
    }


    public String guessNumber(List<Integer> playerAnswer) {
        times++;
        return (isValid(playerAnswer)) ? compare(this.answer, playerAnswer) : "Wrong Input，Input again";
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public String compare(List<Integer> answer, List<Integer> playerAnswer) {
        int A = 0, B = 0;
        Map<Integer, Integer> playerAnswerMap = new HashMap<>();
        for (int i = 0; i < answer.size(); i++) {
            playerAnswerMap.put(playerAnswer.get(i), i);
        }
        for (int i = 0; i < answer.size(); i++) {
            if (playerAnswerMap.containsKey(answer.get(i))) {
                if (playerAnswerMap.get(answer.get(i)) == i) {
                    A++;
                } else {
                    B++;
                }
            }
        }
        return String.format("%dA%dB", A, B);
    }

    public boolean isValid(List<Integer> playerAnswer) {
        boolean result = true;
        if (playerAnswer.isEmpty()) {
            result = false;
        }
        Set playerAnswerSet = new HashSet(playerAnswer);
        if (playerAnswerSet.size() < playerAnswer.size() || playerAnswer.size() < this.answer.size()) {
            result = false;
        }
        return result;
    }

    public int getTimes() {
        return times;
    }
}
