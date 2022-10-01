package baseball.view;

import baseball.controller.BaseballController;

public class BaseballView {
	private BaseballController controller = new BaseballController();
	private boolean status = true;
	
	public void baseball() {
		initBaseball();
		
		while(status) {
			doBaseball();
		}
		
		endBaseball();
	}
	
	/*
	 * 게임 초기화
	 */
	private void initBaseball() {
		controller.initBaseball();
	}
	
	/*
	 * 게임 진행
	 */
	private void doBaseball() {
	}
	
	/*
	 * 게임 종료 처리
	 */
	private void endBaseball() {
	}
}
