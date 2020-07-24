package example;

import java.util.*;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private List<Integer> answer;

    private AnswerProvider answerProvider;

    private int times;

    public GuessNumberGame(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
        this.answer = answerProvider.generateAnswer();
        times = 0;
    }

//    public static void main(String[] args) {
//        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerProvider());
//        playGame(guessNumberGame);
//    }

    public List<Integer> receiveInput(Scanner scanner) {
        List<Integer> playerInput = new ArrayList<>();
        String[] input = scanner.nextLine().trim().split(" ");
        for (int j = 0; j < input.length; j++) {
            playerInput.add(Integer.parseInt(input[j]));
        }
        return playerInput;
    }

    public void playGame() {
        Scanner player = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            List<Integer> playerInput = receiveInput(player);
            String answer = this.guessNumber(playerInput);
            if (answer.equals("4A0B")) {
                System.out.println(answer + ",you win!");
                break;
            }
            System.out.println(output(answer));
        }
    }

    public String output(String answer) {
        StringBuilder result = new StringBuilder();
        if (this.getTimes() >= 6) {
            result.append("answer is : " + this.getAnswer() + "\ngame over!you lose!");
        } else {
            result.append(answer + "\ngame times : " + this.getTimes());
        }
        return result.toString();
    }

    public String guessNumber(List<Integer> playerAnswer) {
        times++;
        return (isValid(playerAnswer)) ? compare(this.answer, playerAnswer) : "Wrong Input，Input again";
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public String compare(List<Integer> answer, List<Integer> playerAnswer) {
        int rightNumberInRightPosition = 0, rightNumber = 0;
        Map<Integer, Integer> playerAnswerMap = new HashMap<>();
        for (int i = 0; i < answer.size(); i++) {
            playerAnswerMap.put(playerAnswer.get(i), i);
        }
        for (int i = 0; i < answer.size(); i++) {
            if (playerAnswerMap.containsKey(answer.get(i))) {
                if (playerAnswerMap.get(answer.get(i)) == i) {
                    rightNumberInRightPosition++;
                } else {
                    rightNumber++;
                }
            }
        }
        return String.format("%dA%dB", rightNumberInRightPosition, rightNumber);
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
        for (int number : playerAnswer) {
            if (number > 9 || number < 0) {
                result = false;
            }
        }
        return result;
    }

    public int getTimes() {
        return times;
    }
}
