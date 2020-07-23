package example;

import java.util.ArrayList;
import java.util.List;

public class AnswerProvider implements AnswerGenerator {
    @Override
    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        int size=0;
        while (size<4){
            int number = (int)(Math.random()*10);
            if(!answer.contains(number)){
                answer.add(number);
                size++;
            }
        }
        return answer;
    }

}
