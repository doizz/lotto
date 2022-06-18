package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
//    public int hitCount(Lotto winningNumber) {
//        int count = 0;
//
//        return count;
//    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
