package example;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GuessNumberGame {
    private List<Integer> answer;

    private AnswerProvider answerProvider;

    public GuessNumberGame(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
        this.answer = answerProvider.generateAnswer();
    }

    public String guessNumber(List<Integer> playerAnswer) {
        return compare(this.answer,playerAnswer);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    private static String compare(List<Integer> answer,List<Integer> playerAnswer){
        int A=0,B=0;
        Map<Integer,Integer> playerAnswerMap = new HashMap<>();
        for(int i=0;i<answer.size();i++){
            playerAnswerMap.put(playerAnswer.get(i),i);
        }
        for(int i=0;i<answer.size();i++){
            if(playerAnswerMap.containsKey(answer.get(i))){
                if(playerAnswerMap.get(answer.get(i))==i){
                    A++;
                }else{
                    B++;
                }
            }
        }
        return String.format("%dA%dB",A,B);
    }
}
