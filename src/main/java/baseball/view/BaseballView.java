package baseball.view;

import baseball.controller.BaseballController;
import baseball.util.Constants;
import camp.nextstep.edu.missionutils.Console;

public class BaseballView {
    private BaseballController controller = new BaseballController();

    public void baseball() {
        initBaseball();

        while (controller.getGameStatus()) {
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
        System.out.println(controller.doBaseball(Console.readLine()));
    }

    /*
     * 게임 종료 처리 : 속행 여부 확인
     */
    private void endBaseball() {
        System.out.println(Constants.MSG_END);
        System.out.println(Constants.MSG_RESTART);

        if(controller.checkRetry(Console.readLine())) baseball();
    }
}
