package domain;

import factory.LottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final int MIN_BUY_TICKET_PRICE = 1000;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos lottoGenerate(int price) {
        validatePrice(price);
        return Stream.generate(LottoFactory::generateLotto)
                .limit(price / MIN_BUY_TICKET_PRICE)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::of));
    }

    private static void validatePrice(int price) {
        if (price < MIN_BUY_TICKET_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    public LottoResults lottoNumberMatch(Lotto winningNumber) {
        LottoResults lottoResults = LottoResults.of();
        lottos.stream().forEach(System.out::println);
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getHitCount(winningNumber));
        }
        return lottoResults;

    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
