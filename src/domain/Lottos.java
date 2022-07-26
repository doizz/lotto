package domain;

import exception.MinPriceException;
import factory.LottoFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final int MIN_BUY_TICKET_PRICE = 1_000;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResults lottoNumberMatch(Lotto winningNumber, LottoNumber bonusNumber) {
        LottoResults lottoResults = LottoResults.from();
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getHitCount(winningNumber), lotto.hasBonusNumber(bonusNumber));
        }
        return lottoResults;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos lottoGenerate(int price, List<Lotto> lottos) {
        validatePrice(price);
        int autoMaticLottoPrice = price - lottos.size() * MIN_BUY_TICKET_PRICE;
        lottos.addAll(autoLottoGenerate(autoMaticLottoPrice));
        return Lottos.of(lottos);
    }

    public static List<Lotto> autoLottoGenerate(int price) {
        return Stream.generate(LottoFactory::generateLotto)
                .limit(price / MIN_BUY_TICKET_PRICE)
                .collect(Collectors.toList());
    }

    private static void validatePrice(int price) {
        if (price < MIN_BUY_TICKET_PRICE) {
            throw new MinPriceException("금액이 부족합니다.");
        }
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getLottoCount() {
        return lottos.size();
    }
}