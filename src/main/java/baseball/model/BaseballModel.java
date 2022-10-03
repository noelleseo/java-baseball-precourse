package baseball.model;

import baseball.util.Constants;
import baseball.util.RegexUtil;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballModel {
    private boolean status = true;
    
    /*
     * 타자 객체와 투수 객체의 세팅값을 비교
     */
    public String playBall(String num, String answer) {
        BaseballVO result = new BaseballVO();
        char[] numArr = num.toCharArray();

        for (int i = 0; i < numArr.length; i++) {
            char c = numArr[i];
            result = countScore(answer, i, c, result);
        }

        checkResult(result);
        return getMessage(result);
    }

    /*
     * 타자(컴퓨터) 객체 생성하여 3자리 숫자 세팅
     */
    public BaseballVO makeHitting() {
        BaseballVO hitter = new BaseballVO();

        hitter.addNumber(chooseNumber(hitter)); // 첫번째 숫자 세팅
        hitter.addNumber(chooseNumber(hitter)); // 두번째 숫자 세팅
        hitter.addNumber(chooseNumber(hitter)); // 세번째 숫자 세팅

        return hitter;
    }

    /*
     * 투수(사용자) 객체 생성하여 3자리 숫자 세팅
     */
    public BaseballVO makePitching(String input) throws IllegalArgumentException {
        String check = checkNumber(input);

        if (!"".equals(check))
            throw new IllegalArgumentException(check);

        BaseballVO pitcher = new BaseballVO();
        pitcher.setNumber(input);

        return pitcher;
    }

    /*
     * 게임 종료 후 재시작 여부 확인 1 : 게임 속행 2 : 게임 종료
     */
    public boolean checkRetry(String input) {
        boolean rtn = false;

        if (!RegexUtil.match("1|2", input))
            throw new IllegalArgumentException(Constants.ERR_NOT_1_OR_2);
        if ("1".equals(input))
            rtn = true;

        return rtn;
    }
    
    /*
     * 결과 메시지 세팅
     */
    public String getMessage(BaseballVO ballCount) {
        String msg = "";

        if (ballCount.getBall() > 0)
            msg += ballCount.getBall() + Constants.E_BALL;
        if (ballCount.getStrike() > 0)
            msg += " " + ballCount.getStrike() + Constants.E_STRIKE;
        if ("".equals(msg))
            msg = Constants.E_NOTHING;

        return msg.trim();
    }
    
    /*
     * 게임 상태 확인
     */
    public boolean getGameStatus() {
        return status;
    }

    /*
     * 1~9사이 랜덤값 중 객체에 포함되어 있지 않은 숫자 리턴
     */
    private String chooseNumber(BaseballVO b) {
        String rtn = "";

        while (b.getNumber().indexOf(rtn) > -1) {
            rtn = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }

        return rtn;
    }

    /*
     * 사용자 입력값 체크
     */
    private String checkNumber(String input) {
        if (!RegexUtil.match("[^0]*", input))
            return Constants.ERR_NOT_VALID_NUM;
        if (!RegexUtil.match("\\d{3}", input))
            return Constants.ERR_NOT_3_DIGIT_NUM;
        if (RegexUtil.match(".*?(.).*?\\1.*", input))
            return Constants.ERR_DUPLICATE_NUM;

        return "";
    }

    /*
     * 스트라이크 or 볼 체크
     */
    private BaseballVO countScore(String answer, int index, char c, BaseballVO result) {
        if (answer.charAt(index) == c) { // 스트라이크
            result.addStrikeCount(1);
            return result;
        }

        if (answer.indexOf(Character.toString(c)) > -1) { // 볼
            result.addBallCount(1);
        }

        return result;
    }
    
    /*
     * 게임 종료 체크
     */
    private void checkResult(BaseballVO result) {
        if(result.getStrike() == 3) {
            status = false;
        }
    }
}
