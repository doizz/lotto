package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final String OVER_SIZE_MESSAGE = "숫자 중복 혹은 갯수가 부적절합니다.";
    private final int LOTTO_NUMBER_SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        validation(lottoNumbers);
        this.lottoNumbers = convertIntegerToLottoNo(lottoNumbers);
    }

    private void validation(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBER_SIZE || lottoNumbers.size() != lottoNumbers.stream().distinct().count()){
            throw new ArrayIndexOutOfBoundsException(OVER_SIZE_MESSAGE);
        }
    }

    public List<LottoNumber> convertIntegerToLottoNo(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Lotto winningNumberGenerate(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::numberValidation)
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
    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
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