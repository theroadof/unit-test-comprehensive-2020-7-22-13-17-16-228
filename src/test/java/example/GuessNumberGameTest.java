package example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    @Test
    void should_return_4A0B_when_play_guess_number_given_1234_and_1234() {
        //given
        List<Integer> answer = Stream.of(1,2,3,4).collect(Collectors.toList());
        AnswerProvider answerProvider = mock(AnswerProvider.class);
        when(answerProvider.generateAnswer()).thenReturn(Arrays.asList(1,2,3,4));
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerProvider);

        //when
        String actual = guessNumberGame.guessNumber(answer);

        //then
        assertEquals("4A0B",actual);
    }
}
