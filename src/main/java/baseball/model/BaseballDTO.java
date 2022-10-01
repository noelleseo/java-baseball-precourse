package baseball.model;

public class BaseballDTO {
	private String number;
	private int strike, ball;

	public BaseballDTO() {
		this.number = "";
		this.strike = 0;
		this.ball = 0;
	}
	
	public BaseballDTO(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}
}
