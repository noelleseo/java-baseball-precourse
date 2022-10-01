package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import baseball.util.Constants;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }
    
    @Test
    void 입력값_예외_숫자_체크() {
        assertSimpleTest(() ->
        	assertThatThrownBy(() -> runException("abc"))
                .hasMessage(Constants.ERR_NOT_3_DIGIT_NUM)
        );
    }
    
    @Test
    void 입력값_예외_글자수_체크_3자미만() {
        assertSimpleTest(() ->
        	assertThatThrownBy(() -> runException("12"))
                .hasMessage(Constants.ERR_NOT_3_DIGIT_NUM)
        );
    }
    
    @Test
    void 입력값_예외_글자수_체크_4자이상() {
        assertSimpleTest(() ->
        	assertThatThrownBy(() -> runException("1234"))
                .hasMessage(Constants.ERR_NOT_3_DIGIT_NUM)
        );
    }

    @Test
    void 입력값_예외_중복_체크() {
        assertSimpleTest(() ->
        	assertThatThrownBy(() -> runException("121"))
                .hasMessage(Constants.ERR_DUPLICATE_NUM)
        );
    }

    @Test
    void 입력값_예외_0_포함() {
        assertSimpleTest(() ->
        	assertThatThrownBy(() -> runException("012"))
                .hasMessage(Constants.ERR_NOT_3_DIGIT_NUM)
        );
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
