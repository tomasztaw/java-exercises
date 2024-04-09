/**
 * Created by tomasz_taw
 * Date: 09.04.2024
 * Time: 18:28
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameImplTest {

    private Game game;

    @BeforeEach
    public void initTest() {
        game = new GameImpl();
    }

    @Test
    void shouldGet0If0BowlingHits() {
        // given
        // when
        rollTheBoll(20, 0);

        // then
        assertEquals(0, game.getScore());
    }

    @Test
    void shouldGet20If20BowlingHitsOneBowlingInEachRound() {
        // given
        // when
        rollTheBoll(20, 1);

        // then
        assertEquals(20, game.getScore());
    }

    @Test
    void shouldGet14IfHitsSpare2x_5And1x_2() {
        // given
        // when
        game.roll(5);
        game.roll(5);
        game.roll(2);
        rollTheBoll(17, 0);

        // then
        assertEquals(14, game.getScore());
    }

    @Test
    void shouldGet20IfHitsStrike1x_10And1x_3And1x_2() {
        // given
        // when
        game.roll(10);
        game.roll(3);
        game.roll(2);
        rollTheBoll(16, 0);

        // then
        assertEquals(20, game.getScore());
    }

    @Test
    void shouldGet300ForAllStrikes() {
        // given
        // when
        rollTheBoll(12, 10);

        // then
        assertEquals(300, game.getScore());
    }

    @Test
    void shouldGet48For18x_1And3x_10() {
        // given
        // when
        rollTheBoll(18, 1);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        // then
        assertEquals(48, game.getScore());
    }


    private void rollTheBoll(int rounds, int bowling) {
        for (int i = 0; i < rounds; i++) {
            game.roll(bowling);
        }
    }
}
