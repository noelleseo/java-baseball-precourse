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
}
