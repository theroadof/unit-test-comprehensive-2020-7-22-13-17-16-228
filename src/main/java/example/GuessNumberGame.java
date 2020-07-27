package example;

import java.util.*;

public class GuessNumberGame {
    private final List<Integer> answer;

    private int times;

    public GuessNumberGame(AnswerProvider answerProvider) {
        this.answer = answerProvider.generateAnswer();
        times = 0;
    }

    public List<Integer> receiveInput(Scanner scanner) {
        List<Integer> playerInput = new ArrayList<>();
        String[] input = scanner.nextLine().trim().split(" ");
        for (String s : input) {
            playerInput.add(Integer.parseInt(s));
        }
        return playerInput;
    }

    public void playGame() {
        Scanner player = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            List<Integer> playerInput = receiveInput(player);
            String answer = this.guessNumber(playerInput);
            if ("4A0B".equals(answer)) {
                System.out.println(answer + ",you win!");
                break;
            }
            System.out.println(output(answer));
        }
    }

    public String output(String answer) {
        StringBuilder result = new StringBuilder();
        if (this.getTimes() >= 6) {
            result.append("answer is : ").append(this.getAnswer()).append("\ngame over!you lose!");
        } else {
            result.append(answer).append("\ngame times : ").append(this.getTimes());
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
                break;
            }
        }
        return result;
    }

    public int getTimes() {
        return times;
    }
}
