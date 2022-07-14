package domain;

import java.util.Objects;

public class LottoNumber {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        numberValidation(number);
        this.number = number;
    }

    public static Integer numberValidation(Integer number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException("번호는 1이상 45이하의 숫자여야 합니다.");
        }
        return number;
    }
}
