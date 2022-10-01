package baseball.view;

import baseball.controller.BaseballController;
import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Console;

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
		System.out.print(Constants.MSG_START);
		
		String result = controller.doBaseball(Console.readLine());
		
		System.out.println(result);
		
		checkResult(result);
	}
	
	/*
	 * 리턴 메시지가 "3스트라이크"인 경우 게임 종료
	 */
	private void checkResult(String result) {
		if(result.indexOf("3" + Constants.E_STRIKE) > -1) status = false;
	}
	
	/*
	 * 게임 종료 처리 : 속행 여부 확인
	 */
	private void endBaseball() {
		System.out.println(Constants.MSG_END);
		System.out.println(Constants.MSG_RESTART);
		
		status = controller.checkStatus(Console.readLine());
		
		if(status) {
			baseball();
		}
	}
}