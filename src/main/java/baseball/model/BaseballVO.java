package baseball.model;

public class BaseballVO {
    private String number;
    private int strike, ball;

    public BaseballVO() {
        this.number = "";
        this.strike = 0;
        this.ball = 0;
    }

    public BaseballVO(String number) {
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

    public void addNumber(String num) {
        this.setNumber(number + num);
    }

    public void addStrikeCount(int cnt) {
        this.setStrike(strike + cnt);
    }

    public void addBallCount(int cnt) {
        this.setBall(ball + cnt);
    }
}
