package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = convertIntegerToLottoNo(lottoNumbers);
    }

    public List<LottoNumber> convertIntegerToLottoNo(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Lotto winningNumberGenerate(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int getHitCount(Lotto winningLotto) {
        return winningLotto.stream()
                .filter(lottoNumbers::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }
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
