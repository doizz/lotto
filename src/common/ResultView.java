package common;

import domain.Lotto;
import domain.Lottos;

import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {}
    public static void resultMessage(Object message){System.out.print(message);}

    public static void lottoNumberPrint(Lottos lottos) {
        resultMessage(lottos.getLottoCount() +" 개를 구매했습니다.\n");
        lottos.stream()
              .forEach(System.out::println);
    }
}
