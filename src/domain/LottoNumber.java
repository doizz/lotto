package domain;

import java.util.Objects;

public class LottoNumber {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static Integer numberValidation(Integer number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException("번호는 1이상 45이하의 숫자여야 합니다.");
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }


}
