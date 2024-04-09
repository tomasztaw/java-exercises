package pl.taw.bowling;

/**
 * Cel gry: jak najwięcej punktów, max = 300.
 * Ilość rung: 10 (strike i spare powiększają ilość rzutów).
 * Ilość kręgli: 10.
 * Punkty: za każdy zbity kręgiel
 * Rzut: po 2 na gracza (wyjątek strike)
 * Strikes i spares:
 * - strike: zbicie wszystkich kręgli w pierwszym rzucie.
 * - strike: dodawane są punkty z 2 kolejnych rzutów.
 * - spare: zbicie wszystkich w drugim rzucie.
 * - spare: dodawane są punkty z 1 kolejnego rzutu.
 */

public interface Game {

    void roll(int bowling);

    int getScore();

}
