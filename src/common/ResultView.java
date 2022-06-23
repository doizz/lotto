package common;

import domain.LottoResult;
import domain.LottoResults;
import domain.Lottos;


public class ResultView {

    private ResultView() {}
    private static final String WINNINNG_STATISTICS_MESSAGE = "당첨 통계.\n---------";
    private static final String STATISTICS_STATUS= "%d개 일치 (%d원)- %d개";

    public static void resultMessage(Object message){System.out.print(message);}

    public static void lottoNumberPrint(Lottos lottos) {
        resultMessage(lottos.getLottoCount() +" 개를 구매했습니다.\n");
        lottos.stream()
              .forEach(System.out::println);
    }
    public static void printLottoResult(LottoResults prizes) {
        System.out.println(WINNINNG_STATISTICS_MESSAGE);
        System.out.println(printLottoPrizes(prizes));
    }
    private static String printLottoPrizes(LottoResults prizes) {
        StringBuilder sb = new StringBuilder();

        for (LottoResult value : prizes.getLottoResults()) {
            sb.append(String.format(STATISTICS_STATUS, value.getMatchCount(), value.getMoney(), value.getWinCount()));
            sb.append("\n");
        }
        return sb.toString();
    }

}
