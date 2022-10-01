package baseball.view;

import baseball.controller.BaseballController;
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
		System.out.print("숫자를 입력해주세요 : ");
		
		String result = controller.doBaseball(Console.readLine());
		
		System.out.println(result);
		
		checkResult(result);
	}
	
	/*
	 * 리턴 메시지가 "3스트라이크"인 경우 게임 종료
	 */
	private void checkResult(String result) {
		if(result.indexOf("3스트라이크") > -1) status = false;
	}
	
	/*
	 * 게임 종료 처리 : 속행 여부 확인
	 */
	private void endBaseball() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		status = controller.checkStatus(Console.readLine());
		
		if(status) {
			baseball();
		}
	}
}