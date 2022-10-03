package baseball.controller;

import baseball.model.BaseballModel;
import baseball.model.BaseballVO;
import baseball.util.Constants;

public class BaseballController {
    private BaseballVO hitter;
    private BaseballModel baseball;

    public void initBaseball() {
        baseball = new BaseballModel();
        hitter = baseball.makeHitting();
    }

    public String doBaseball(String input) {
        BaseballVO pitcher = baseball.makePitching(input);
        String result = baseball.playBall(pitcher.getNumber(), hitter.getNumber());
        
        return result;
    }

    public boolean checkRetry(String input) {
        return baseball.checkRetry(input);
    }

    public boolean getGameStatus() {
        return baseball.getGameStatus();
    }
}
