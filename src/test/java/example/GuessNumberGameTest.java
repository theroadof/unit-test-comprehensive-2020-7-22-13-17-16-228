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

    @Test
    void should_return_1A3B_when_play_guess_number_given_1234_and_1342() {
        //given
        List<Integer> answer = Stream.of(1,3,4,2).collect(Collectors.toList());
        AnswerProvider answerProvider = mock(AnswerProvider.class);
        when(answerProvider.generateAnswer()).thenReturn(Arrays.asList(1,2,3,4));
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerProvider);

        //when
        String actual = guessNumberGame.guessNumber(answer);

        //then
        assertEquals("1A3B",actual);
    }

    @Test
    void should_return_1A1B_when_play_guess_number_given_1234_and_1356() {
        //given
        List<Integer> answer = Stream.of(1,3,5,6).collect(Collectors.toList());
        AnswerProvider answerProvider = mock(AnswerProvider.class);
        when(answerProvider.generateAnswer()).thenReturn(Arrays.asList(1,2,3,4));
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerProvider);

        //when
        String actual = guessNumberGame.guessNumber(answer);

        //then
        assertEquals("1A1B",actual);
    }

    @Test
    void should_return_0A4B_when_play_guess_number_given_1234_and_4321() {
        //given
        List<Integer> answer = Stream.of(4,3,2,1).collect(Collectors.toList());
        AnswerProvider answerProvider = mock(AnswerProvider.class);
        when(answerProvider.generateAnswer()).thenReturn(Arrays.asList(1,2,3,4));
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerProvider);

        //when
        String actual = guessNumberGame.guessNumber(answer);

        //then
        assertEquals("0A4B",actual);
    }

    @Test
    void should_return_0A2B_when_play_guess_number_given_1234_and_2478() {
        //given
        List<Integer> answer = Stream.of(2,4,7,8).collect(Collectors.toList());
        AnswerProvider answerProvider = mock(AnswerProvider.class);
        when(answerProvider.generateAnswer()).thenReturn(Arrays.asList(1,2,3,4));
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerProvider);

        //when
        String actual = guessNumberGame.guessNumber(answer);

        //then
        assertEquals("0A2B",actual);
    }
}
