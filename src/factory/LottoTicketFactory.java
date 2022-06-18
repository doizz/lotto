package factory;

import domain.Lotto;
import domain.Lottos;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicketFactory {
    private static final int MIN_BUY_TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_MAX_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Integer> LOTTO_NUMBER = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static Lottos buyLotto(int price) {
        validatePrice(price);
        return Stream.generate(LottoTicketFactory::generateLottoTicket)
                .limit(price / MIN_BUY_TICKET_PRICE)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::of));
    }

    public static Lotto generateLottoTicket() {
        Collections.shuffle(LOTTO_NUMBER);
        return LOTTO_NUMBER.stream()
                .limit(LOTTO_NUMBER_MAX_SIZE)
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::of));
    }

    private static void validatePrice(int price) {
        if (price < MIN_BUY_TICKET_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

}
