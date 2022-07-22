package factory;

import domain.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final int LOTTO_NUMBER_MAX_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Integer> LOTTO_NUMBER = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static Lotto generateLotto() {
        Collections.shuffle(LOTTO_NUMBER);
        return LOTTO_NUMBER.stream()
                .limit(LOTTO_NUMBER_MAX_SIZE)
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    public static Lotto generateLotto(String manualNumber) {
        return Arrays.stream(manualNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }
}
