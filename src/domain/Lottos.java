package domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> Lottos;

    public Lottos(List<Lotto> lottos) {
        Lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Stream<Lotto> stream() {
        return Lottos.stream();
    }

    public int getLottoCount() {
        return Lottos.size();
    }


    public List<Lotto> getlottos() {
        return Lottos;
    }
}
