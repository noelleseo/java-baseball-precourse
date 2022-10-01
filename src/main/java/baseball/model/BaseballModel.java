package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
	/*
	 * 타자(컴퓨터) 객체 생성하여 3자리 숫자 세팅
	 */
	public BaseballDTO makeHitting() {
		BaseballDTO hitter = new BaseballDTO();
		
		hitter.setNumber(hitter.getNumber() + chooseBalls(hitter)); //첫번째 숫자 세팅
		hitter.setNumber(hitter.getNumber() + chooseBalls(hitter)); //두번째 숫자 세팅
		hitter.setNumber(hitter.getNumber() + chooseBalls(hitter)); //세번째 숫자 세팅
		
		return hitter;
	}
	
	/*
	 * 1~9사이 랜덤값 중 객체에 포함되어 있지 않은 숫자 리턴
	 */
	private String chooseBalls(BaseballDTO b) {
		String rtn = "";
		
		while(b.getNumber().indexOf(rtn) > -1) {
			rtn = String.valueOf(Randoms.pickNumberInRange(1, 9));
		}
		
		return rtn;
	}
}
