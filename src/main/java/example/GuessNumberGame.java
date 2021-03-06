package example;

import java.util.*;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private static final String SPACE_REGEX = " ";
    private static final String YOU_WIN = ",you win!";
    private static final String GAME_OVER_YOU_LOSE = "\ngame over!you lose!";
    private static final String GAME_TIMES = "\ngame times : ";
    private static final String ANSWER_IS = "answer is : ";
    private static final String WRONG_INPUT = "Wrong Input，Input again";
    private static final int MAX_GAME_TIME = 6;
    private static final String WIN_CONDITION = "4A0B";
    private final List<Integer> answer;

    private int times;

    public GuessNumberGame(AnswerProvider answerProvider) {
        this.answer = answerProvider.generateAnswer();
        times = 0;
    }

    private List<Integer> receiveInput(Scanner scanner) {
        List<String> numbers = Arrays.asList(scanner.nextLine().trim().split(SPACE_REGEX));
        return numbers.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    void playGame() {
        Scanner player = new Scanner(System.in);
        for (int i = 0; i < MAX_GAME_TIME; i++) {
            List<Integer> playerInput = receiveInput(player);
            String answer = this.guessNumber(playerInput);
            if (WIN_CONDITION.equals(answer)) {
                System.out.println(answer + YOU_WIN);
                break;
            }
            System.out.println(output(answer));
        }
    }

    private String output(String answer) {
        StringBuilder result = new StringBuilder();
        if (this.getTimes() >= MAX_GAME_TIME) {
            result.append(ANSWER_IS).append(this.getAnswer()).append(GAME_OVER_YOU_LOSE);
        } else {
            result.append(answer).append(GAME_TIMES).append(this.getTimes());
        }
        return result.toString();
    }

    public String guessNumber(List<Integer> playerAnswer) {
        times++;
        return (isValid(playerAnswer)) ? compare(this.answer, playerAnswer) : WRONG_INPUT;
    }

    private List<Integer> getAnswer() {
        return answer;
    }

    private String compare(List<Integer> answer, List<Integer> playerAnswer) {
        Map<Integer, Integer> playerAnswerMap = new HashMap<>();
        playerAnswer.forEach(playerInput -> playerAnswerMap.put(playerInput, playerAnswer.indexOf(playerInput)));
        int rightNumber = (int) answer.stream().filter(playerAnswerMap::containsKey).count();
        int rightNumberInRightPosition = (int) answer.stream().filter(number -> (
                (playerAnswerMap.containsKey(number)) && (answer.indexOf(number) == playerAnswerMap.get(number))
        )).count();
        return String.format("%dA%dB", rightNumberInRightPosition, rightNumber - rightNumberInRightPosition);
    }

    private boolean isValid(List<Integer> playerAnswer) {
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

    private int getTimes() {
        return times;
    }
}
