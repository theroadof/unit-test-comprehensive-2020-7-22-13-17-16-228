package example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnswerProviderTest {
    @Test
    void should_generate_size_4_answer_when_play_generate_answer() {

        //when
        AnswerProvider answerProvider = new AnswerProvider();
        List<Integer> answer = answerProvider.generateAnswer();

        //then
        assertEquals(4, answer.size());
    }

    @Test
    void should_generate_different_number_of_answer_when_play_generate_answer() {
        //when
        AnswerProvider answerProvider = new AnswerProvider();
        List<Integer> answer = answerProvider.generateAnswer();
        Set<Integer> answerSet = new HashSet<>(answer);

        //then
        assertTrue(answer.size() == answerSet.size());
    }

    @Test
    void should_generate_number_of_answer_when_play_generate_answer() {
        //given
        AnswerProvider answerProvider = new AnswerProvider();
        List<Integer> answer = answerProvider.generateAnswer();
        boolean actual = false;

        //when
        for (Integer number : answer) {
            if (number != null) {
                actual = true;
                break;
            }
        }

        //then
        assertTrue(actual);
    }
}
