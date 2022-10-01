package baseball.model;

import baseball.util.RegexUtil;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
	public String baseball(BaseballDTO pitcher, BaseballDTO hitter) {
		BaseballDTO ballCount = new BaseballDTO();
		char[] parr = pitcher.getNumber().toCharArray();
		
		for(int i=0; i<parr.length; i++) {
			char t = parr[i];
			checkBalls(hitter.getNumber(), i, t, ballCount);
		}
		
		return getMessage(ballCount);
	}
	
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
	 * 투수(사용자) 객체 생성하여 3자리 숫자 세팅
	 */
	public BaseballDTO makePitching(String num) throws IllegalArgumentException{
		RegexUtil r = new RegexUtil();
		
		if(!r.match("\\d{3}", num)) throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
		if(r.match(".*?(.).*?\\1.*", num)) throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");

		BaseballDTO pitcher = new BaseballDTO();
		pitcher.setNumber(num);
		
		return pitcher;
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
	
	/*
	 * 타자 객체와 투수 객체의 세팅값을 비교하여 스트라이크 or 볼 체크
	 */
	private BaseballDTO checkBalls(String swings, int index, char ball, BaseballDTO result) {
		if(swings.charAt(index) == ball) { //스트라이크
			result.setStrike(result.getStrike() + 1);
			return result;
		}
		
		if(swings.indexOf(Character.toString(ball)) > -1) { //볼
			result.setBall(result.getBall() + 1);
		}
		
		return result;
	}
	
	/*
	 * 결과 메시지 세팅
	 */
	private String getMessage(BaseballDTO ballCount) {
		String msg = "";
		
		if(ballCount.getBall() > 0) msg += ballCount.getBall() + "볼";
		if(ballCount.getStrike() > 0) msg += " " + ballCount.getStrike() + "스트라이크";
		if("".equals(msg)) msg = "낫싱";
		
		return msg.trim();
	}
}
