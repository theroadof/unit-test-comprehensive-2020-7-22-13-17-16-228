package example;

import java.util.List;

public class GuessNumberGame {
    private List<Integer> answer;

    private AnswerProvider answerProvider;

    public GuessNumberGame(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
        this.answer = answerProvider.generateAnswer();
    }

    public String guessNumber(List<Integer> answer) {
        return null;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
