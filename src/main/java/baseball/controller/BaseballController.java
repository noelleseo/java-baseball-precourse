package baseball.controller;

import baseball.model.BaseballModel;
import baseball.model.BaseballDTO;

public class BaseballController {
	private BaseballDTO hitter;
	private BaseballModel baseball;
	
	public void initBaseball() {
		baseball = new BaseballModel();
		hitter = baseball.makeHitting();
	}
	
	public String doBaseball(String input) {
		BaseballDTO pitcher = baseball.makePitching(input);
		return baseball.playBall(pitcher.getNumber(), hitter.getNumber());
	}
	
	public boolean checkStatus(String input) {
		return baseball.checkStatus(input);
	}
}
