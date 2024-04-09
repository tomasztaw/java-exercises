/**
 * Created by tomasz_taw
 * Date: 09.04.2024
 * Time: 18:34
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.bowling;

public class GameImpl implements Game {

    private final int[] scores = new int[21];
    private int currentRound = 0;
    private final static int MAX_ROUND = 10;

    @Override
    public void roll(int bowling) {
        scores[currentRound++] = bowling;
    }

    @Override
    public int getScore() {
        int score = 0;
        int scoreIdx = 0;

        for (int i = 0; i < MAX_ROUND; i++) {
            if (isStrike(scoreIdx)) {
                score += getScoreForStrike(scoreIdx);
                scoreIdx += 1;
            } else if (isSpore(scoreIdx)) {
                score += getScoreForSpore(scoreIdx);
                scoreIdx += 2;
            } else {
                score += getStandardScore(scoreIdx);
                scoreIdx += 2;
            }
        }

        return score;
    }

    private int getScoreForStrike(int scoreIdx) {
        return scores[scoreIdx] + scores[scoreIdx + 1] + scores[scoreIdx + 2];
    }

    private boolean isStrike(int scoreIdx) {
        return scores[scoreIdx] == 10;
    }

    private int getStandardScore(int scoreIdx) {
        return scores[scoreIdx] + scores[scoreIdx + 1];
    }

    private int getScoreForSpore(int scoreIdx) {
        return scores[scoreIdx] + scores[scoreIdx + 1] + scores[scoreIdx + 2];
    }

    private boolean isSpore(int scoreIdx) {
        return scores[scoreIdx] + scores[scoreIdx + 1] == 10;
    }

}
