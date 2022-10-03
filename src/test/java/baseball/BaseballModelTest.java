package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import baseball.model.BaseballModel;
import baseball.util.Constants;
import camp.nextstep.edu.missionutils.test.NsTest;

public class BaseballModelTest extends NsTest {
    private BaseballModel model = new BaseballModel();
	
	@Nested
	@DisplayName("생성값 유효성 테스트")
	class IsAnswerValid {
		String num = model.makeHitting().getNumber();
		
		@Test
		@DisplayName("생성값_0_미포함")
		void isZeroNotIncluded() {
			assertSimpleTest(() -> assertThat(num).doesNotContain("0"));
		}
		
		@Test
		@DisplayName("생성값_3자리_숫자")
		void isThreeDigitNum() {
			assertSimpleTest(() -> assertThat(num).matches("\\d{3}"));
		}
		
		@Test
		@DisplayName("생성값_중복_미포함")
		void isNotDuplicatedNum() {
			assertSimpleTest(() -> assertThat(num).doesNotMatch(".*?(.).*?\\1.*"));
		}		
	}
	
	@Nested
	@DisplayName("입력값 유효성 테스트")
	class IsUserInputValid {
	    @Test
	    @DisplayName("입력값_예외_0")
	    void testZeroValid() {
	        assertSimpleTest(() -> assertThatThrownBy(() -> runException("012")).hasMessage(Constants.ERR_NOT_VALID_NUM));
	    }

	    @Test
	    @DisplayName("입력값_예외_문자")
	    void testCharValid() {
	        assertSimpleTest(() -> assertThatThrownBy(() -> runException("abc")).hasMessage(Constants.ERR_NOT_3_DIGIT_NUM));
	    }
	    
	    @Test
	    @DisplayName("입력값_예외_3자미만")
	    void testLessLetterValid() {
	        assertSimpleTest(() -> assertThatThrownBy(() -> runException("12")).hasMessage(Constants.ERR_NOT_3_DIGIT_NUM));
	    }
	    
	    @Test
	    @DisplayName("입력값_예외_4자이상")
	    void testMoreLetterValid() {
	        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234")).hasMessage(Constants.ERR_NOT_3_DIGIT_NUM));
	    }

	    @Test
	    @DisplayName("입력값_예외_중복")
	    void testDuplicateValid() {
	        assertSimpleTest(() -> assertThatThrownBy(() -> runException("121")).hasMessage(Constants.ERR_DUPLICATE_NUM));
	    }
	}
	
	@Nested
	@DisplayName("검증로직 유효성 테스트")
	class IsResultCorrect {	
		String answer = "123";
		
		@Test
		@DisplayName("1볼_체크")
		void hasBall() {
			assertSimpleTest(() -> assertThat(model.playBall(answer, "451")).isEqualTo("1" + Constants.E_BALL));
		}
		
		@Test
		@DisplayName("1스트라이크_체크")
		void hasStrike() {
			assertSimpleTest(() -> assertThat(model.playBall(answer, "145")).isEqualTo("1" + Constants.E_STRIKE));
		}
		
		@Test
		@DisplayName("1볼_1스트라이크_체크")
		void hasBallAndStrike() {
			assertSimpleTest(() ->
				assertThat(model.playBall(answer, "135")).isEqualTo("1" + Constants.E_BALL + " 1" + Constants.E_STRIKE));
		}
		
		@Test
		@DisplayName("낫싱_체크")
		void hasNothing() {
			assertSimpleTest(() -> assertThat(model.playBall(answer, "456")).isEqualTo(Constants.E_NOTHING));
		}
		
        @Test
        @DisplayName("3스트라이크_체크")
        void hasThreeStrike() {
            assertSimpleTest(() ->
                assertThat(model.playBall(answer, "123")).isEqualTo("3" + Constants.E_STRIKE));
        }
	}
	
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
