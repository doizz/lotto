package domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static int match(Lotto winningNumber) {
//        for(Lotto l : lottos){
//            Lotto.hitCount(winningNumber);
//        }
        return 0;
//        Lottos.stream().forEach(System.out::println);
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
